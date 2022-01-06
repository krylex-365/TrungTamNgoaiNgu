/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.GiaoVienDAO;
import DAO.MaDuLieuCuoiDAO;
import DTO.GiaoVienDTO;
import DTO.PhanCongDTO;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class GiaoVienBUS {

    private Utils utl = new Utils();
    private MaDuLieuCuoiDAO maLast = new MaDuLieuCuoiDAO();
    GiaoVienDAO giaoVienDAO = new GiaoVienDAO();

    public GiaoVienBUS() {

    }
    
    public String findHoTenByMaGiaoVien(String maGiaoVien,ArrayList<GiaoVienDTO> giaoVienDTOs){
        for(GiaoVienDTO a : giaoVienDTOs){
            if(a.getMaGiaoVien().equals(maGiaoVien)){
                return a.getHoTen();
            }
        }
        return null;
    }

    public int indexGiaoVien(String maGiaoVien, ArrayList<GiaoVienDTO> giaoVienDTOs) {
        int i = -1, j = 0;
        for (GiaoVienDTO khoaThi : giaoVienDTOs) {
            if (khoaThi.getMaGiaoVien().equals(maGiaoVien)) {
                i = j;
                break;
            }
            j++;
        }
        return i;
    }

    public String capPhat() {
        return utl.initMaGiaoVien();
    }

    public boolean themGiaoVien(GiaoVienDTO giaoVienDTO, ArrayList<GiaoVienDTO> giaoVienDTOs) {
        if (giaoVienDAO.insertGiaoVien(giaoVienDTO)) {
            giaoVienDTOs.add(giaoVienDTO);
            maLast.updateMaGiaoVien(giaoVienDTO.getMaGiaoVien());
            System.out.println("Thêm thành công GiaoVienBUS");
            return true;
        }
        System.out.println("Thêm thất bại GiaoVienBUS");
        return false;
    }

    public boolean suaGiaoVien(GiaoVienDTO giaoVienDTO, ArrayList<GiaoVienDTO> giaoVienDTOs) {
        if (giaoVienDAO.updateGiaoVien(giaoVienDTO)) {
            giaoVienDTOs.set(indexGiaoVien(giaoVienDTO.getMaGiaoVien(), giaoVienDTOs), giaoVienDTO);
            System.out.println("Sửa thành công GiaoVienBUS");
            return true;
        }
        System.out.println("Sửa thất bại GiaoVienBUS");
        return false;
    }

    public boolean xoaGiaoVien(GiaoVienDTO giaoVienDTO, ArrayList<GiaoVienDTO> giaoVienDTOs) {

        if (giaoVienDAO.deleteGiaoVien(giaoVienDTO.getMaGiaoVien())) {
            giaoVienDTOs.remove(giaoVienDTO);
            System.out.println("Xóa thành công GiaoVienBUS");
            return true;
        }
        System.out.println("Xóa thất bại GiaoVienBUS");
        return false;
    }
}
