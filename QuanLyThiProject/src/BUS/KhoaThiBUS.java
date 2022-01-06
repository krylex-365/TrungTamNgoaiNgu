/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.KhoaThiDAO;
import DAO.MaDuLieuCuoiDAO;
import DTO.KhoaThiDTO;
import DTO.ThiSinhDTO;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class KhoaThiBUS {
    private Utils utl = new Utils();
    private MaDuLieuCuoiDAO maLast = new MaDuLieuCuoiDAO();
    public KhoaThiDAO khoaThiDAO = new KhoaThiDAO();

    public KhoaThiBUS() {
    }

    public ArrayList<KhoaThiDTO> getList(){
        return  khoaThiDAO.getList();
    }
    
    public boolean checkFinished(String maKhoaThi,ArrayList<KhoaThiDTO> khoaThiDTOs){
        for(KhoaThiDTO a : khoaThiDTOs){
            if(a.getMaKhoaThi().equals(maKhoaThi)){
                if(utl.stringToDate(a.getNgayThi()).before(utl.getDateWithoutTimeUsingFormat())){
                    return true;
                }
            }
        }
        return false;
    }

    public KhoaThiDTO findKhoaThi (String maKhoaThi, ArrayList<KhoaThiDTO> khoaThiDTOs){
        KhoaThiDTO khoaThiDTO = new KhoaThiDTO();
        for (KhoaThiDTO khoaThi : khoaThiDTOs) {
            if (khoaThi.getMaKhoaThi().equals(maKhoaThi)) {
                khoaThiDTO = khoaThi;
                break;
            }
        }
        return khoaThiDTO;
    }
    
    public KhoaThiDTO findKhoaThi(String maKhoaThi){
        return khoaThiDAO.findKhaoThi(maKhoaThi);
    }
    
    public String findTenKhoaKhoaThi (String maKhoaThi, ArrayList<KhoaThiDTO> khoaThiDTOs){
        for (KhoaThiDTO khoaThi : khoaThiDTOs) {
            if (khoaThi.getMaKhoaThi().equals(maKhoaThi)) {
                return khoaThi.getTenKhoaThi();
            }
        }
        return null;
    }

    public int indexKhoaThi (String maKhoaThi, ArrayList<KhoaThiDTO> khoaThiDTOs) {
        int i = -1, j = 0;
        for (KhoaThiDTO khoaThi : khoaThiDTOs) {
            if (khoaThi.getMaKhoaThi().equals(maKhoaThi)) {
                i = j;
                break;
            }
            j++;
        }
        return i;
    }
    
    public String capPhat (){
        return utl.initMaKhoaThi();
    }

    public boolean them(KhoaThiDTO khoaThiDTO, ArrayList<KhoaThiDTO> khoaThiDTOs) {
//        for (KhoaThiDTO k : khoaThiDTOs) {
//            if (k.getMaKhoaThi().equals(khoaThiDTO.getMaKhoaThi())) {
//                return false;
//            }
//        }
        if (khoaThiDAO.insertKhoaThi(khoaThiDTO)) {
            khoaThiDTOs.add(khoaThiDTO);
            maLast.updateMaKhoaThi(khoaThiDTO.getMaKhoaThi());
            System.out.println("Thêm thành công KhoaThiBUS");
            return true;
        }
        System.out.println("Thêm thất bại KhoaThiBUS");
        return false;
    }

    public boolean sua(KhoaThiDTO khoaThiDTO, ArrayList<KhoaThiDTO> khoaThiDTOs, boolean check) {
        if (khoaThiDAO.updateKhoaThi(khoaThiDTO, check)) {
            khoaThiDTOs.set(indexKhoaThi(khoaThiDTO.getMaKhoaThi(), khoaThiDTOs), khoaThiDTO);
            System.out.println("Sửa thành công KhoaThiBUS");
            return true;
        }
        System.out.println("Sửa thất bại KhoaThiBUS");
        return false;
    }

    public boolean xoa(KhoaThiDTO khoaThiDTO, ArrayList<KhoaThiDTO> khoaThiDTOs) {
        if (khoaThiDAO.deleteKhoaThi(khoaThiDTO.getMaKhoaThi())) {
            khoaThiDTOs.remove(khoaThiDTO);
            System.out.println("Xóa thành công KhoaThiBUS");
            return true;
        }
        System.out.println("Xóa thất bại KhoaThiBUS");
        return false;
    }
}
