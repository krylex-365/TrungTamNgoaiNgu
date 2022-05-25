/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.MaDuLieuCuoiDAO;
import DAO.PhongThiDAO;
import DTO.PhongThiDTO;
import DTO.PhongThongKe;
import DTO.TrinhDoDTO;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class PhongThiBUS {
    private Utils utl = new Utils();
    private MaDuLieuCuoiDAO maLast = new MaDuLieuCuoiDAO();
    public PhongThiDAO phongThiDAO = new PhongThiDAO();

    public PhongThiBUS() {
    }
    public ArrayList<PhongThongKe> getListTK(String matrinhdo){
        return phongThiDAO.getThonkephong(matrinhdo);
    }
    public ArrayList<PhongThiDTO> getList(){
        return  phongThiDAO.getList();
    }
    public PhongThiDTO findPhongThi (String maKhoaThi, ArrayList<PhongThiDTO> phongThiDTOs){
        PhongThiDTO phongThiDTO = new PhongThiDTO();
        for (PhongThiDTO phongThi : phongThiDTOs) {
            if (phongThi.getMaKhoaThi().equals(maKhoaThi)) {
                phongThiDTO = phongThi;
                break;
            }
        }
        return phongThiDTO;
    }
    
    public PhongThiDTO findPhongThiByMaPhongThi(String maPhongThi,ArrayList<PhongThiDTO> phongThiDTOs){
        for (PhongThiDTO phongThi : phongThiDTOs) {
            if (phongThi.getMaPhongThi().equals(maPhongThi)) {
                return phongThi;
            }
        }
        return null;
    }

    public int indexPhongThi (String maKhoaThi, ArrayList<PhongThiDTO> phongThiDTOs) {
        int i = -1, j = 0;
        for (PhongThiDTO phongThi : phongThiDTOs) {
            if (phongThi.getMaKhoaThi().equals(maKhoaThi)) {
                i = j;
                break;
            }
            j++;
        }
        return i;
    }
    
    public String capPhat (){
        return utl.initMaPhongThi();
    }

    public boolean them(PhongThiDTO phongThiDTO, ArrayList<PhongThiDTO> phongThiDTOs, 
            int SLPG, ArrayList<TrinhDoDTO> trinhDoDTOs) {
//        for (PhongThiDTO k : phongThiDTOs) {
//            if (k.getMaKhoaThi().equals(phongThiDTO.getMaKhoaThi())) {
//                return false;
//            }
//        }
        if (phongThiDAO.insertPhongThi(phongThiDTO)) {
            TrinhDoBUS trinhDoBUS = new TrinhDoBUS();
            if (trinhDoBUS.capNhatSLPG(phongThiDTO.getMaTrinhDo(), SLPG, trinhDoDTOs)) {
                phongThiDTOs.add(phongThiDTO);
                maLast.updateMaPhongThi(phongThiDTO.getMaPhongThi());
                System.out.println("Thêm thành công PhongThiBUS");
                return true;
            }
        }
        System.out.println("Thêm thất bại PhongThiBUS");
        return false;
    }

    public boolean sua(PhongThiDTO phongThiDTO, PhongThiDTO oldDTO, ArrayList<PhongThiDTO> phongThiDTOs) {
        boolean checkKhoaThi = false, checkTrinhDo = false;
        if (phongThiDTO.getMaKhoaThi().equals(oldDTO.getMaKhoaThi())) {
            checkKhoaThi = true;
        }
        if (phongThiDTO.getMaTrinhDo().equals(oldDTO.getMaTrinhDo())) {
            checkTrinhDo = true;
        }
        if (phongThiDAO.updatePhongThi(phongThiDTO, checkKhoaThi, checkTrinhDo)) {
            phongThiDTOs.set(indexPhongThi(phongThiDTO.getMaKhoaThi(), phongThiDTOs), phongThiDTO);
            System.out.println("Sửa thành công PhongThiBUS");
            return true;
        }
        System.out.println("Sửa thất bại PhongThiBUS");
        return false;
    }

    public boolean xoa(PhongThiDTO phongThiDTO, ArrayList<PhongThiDTO> phongThiDTOs) {
        if (phongThiDAO.deletePhongThi(phongThiDTO.getMaPhongThi())) {
            phongThiDTOs.remove(phongThiDTO);
            System.out.println("Xóa thành công PhongThiBUS");
            return true;
        }
        System.out.println("Xóa thất bại PhongThiBUS");
        return false;
    }
}
