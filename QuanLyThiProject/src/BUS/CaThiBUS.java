/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.CaThiDAO;
import DAO.MaDuLieuCuoiDAO;
import DTO.CaThiDTO;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class CaThiBUS {
    private Utils utl = new Utils();
    private MaDuLieuCuoiDAO maLast = new MaDuLieuCuoiDAO();
    CaThiDAO caThiDAO = new CaThiDAO();

    public CaThiBUS() {
    }
    
    public CaThiDTO findCaThi (String maCaThi, ArrayList<CaThiDTO> caThiDTOs){
        CaThiDTO caThiDTO = new CaThiDTO();
        for (CaThiDTO caThi : caThiDTOs) {
            if (caThi.getMaCaThi().equals(maCaThi)) {
                caThiDTO = caThi;
                break;
            }
        }
        return caThiDTO;
    }

    public int indexCaThi (String maCaThi, ArrayList<CaThiDTO> caThiDTOs) {
        int i = -1, j = 0;
        for (CaThiDTO caThi : caThiDTOs) {
            if (caThi.getMaCaThi().equals(maCaThi)) {
                i = j;
                break;
            }
            j++;
        }
        return i;
    }
    
    public String capPhat (){
        return utl.initMaCaThi();
    }

    public boolean them(CaThiDTO caThiDTO, ArrayList<CaThiDTO> caThiDTOs) {
        if (caThiDAO.insertCaThi(caThiDTO)) {
            caThiDTOs.add(caThiDTO);
            maLast.updateMaCaThi(caThiDTO.getMaCaThi());
            System.out.println("Thêm thành công CaThiBUS");
            return true;
        }
        System.out.println("Thêm thất bại CaThiBUS");
        return false;
    }

    public boolean sua(CaThiDTO caThiDTO, ArrayList<CaThiDTO> caThiDTOs) {
        if (caThiDAO.updateCaThi(caThiDTO)) {
            caThiDTOs.set(indexCaThi(caThiDTO.getMaCaThi(), caThiDTOs), caThiDTO);
            System.out.println("Sửa thành công CaThiBUS");
            return true;
        }
        System.out.println("Sửa thất bại CaThiBUS");
        return false;
    }

    public boolean xoa(CaThiDTO caThiDTO, ArrayList<CaThiDTO> caThiDTOs) {
        if (caThiDAO.deleteCaThi(caThiDTO.getMaCaThi())) {
            caThiDTOs.remove(caThiDTO);
            System.out.println("Xóa thành công CaThiBUS");
            return true;
        }
        System.out.println("Xóa thất bại CaThiBUS");
        return false;
    }
}
