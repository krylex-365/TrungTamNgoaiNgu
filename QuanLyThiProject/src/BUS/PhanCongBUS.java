/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.MaDuLieuCuoiDAO;
import DAO.PhanCongDAO;
import DTO.GiaoVienDTO;
import DTO.KhoaThiDTO;

import DTO.PhanCongDTO;
import DTO.PhieuBaoDuThiDTO;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author User
 */
public class PhanCongBUS {
    public Utils utl = new Utils();
    public PhanCongDAO phanCongDAO = new PhanCongDAO();
    public GiaoVienBUS giaoVienBUS = new GiaoVienBUS();
    public MaDuLieuCuoiDAO maDuLieuCuoiDAO = new MaDuLieuCuoiDAO();
    public KhoaThiBUS khoaKhiBUS = new KhoaThiBUS();
    
    public ArrayList<PhanCongDTO> getList(){
        return phanCongDAO.getList();
    }
    
    public ArrayList<PhanCongDTO> getListByMaPhongThi_MaCaThi(String maPhongThi,String maCaThi,ArrayList<PhanCongDTO> phanCongDTOs){
        ArrayList<PhanCongDTO> list = new ArrayList<>();
        for(PhanCongDTO a : phanCongDTOs){
            if(a.getMaPhongThi().equals(maPhongThi)&&a.getMaCaThi().equals(maCaThi)){
                list.add(a);
            }
        }
        return list;
    }
    
    public boolean checkNhiemVu(String maPhongThi,String maCaThi,String nhiemVu,ArrayList<PhanCongDTO> phanCongDTOs){
        for(PhanCongDTO a : phanCongDTOs){
            if(a.getMaPhongThi().equals(maPhongThi)&&a.getMaCaThi().equals(maCaThi)){
                if(a.getNhiemVu().equals(nhiemVu)){
                    return false;
                }
            }
        }
        return true;
    }

    public ArrayList<GiaoVienDTO> getGiaoViensBy(String maPhongThi,String maCaThi,ArrayList<PhanCongDTO> phanCongDTOs,ArrayList<GiaoVienDTO> giaoVienDTOs){
        ArrayList<GiaoVienDTO> list = new ArrayList<>();
        for(GiaoVienDTO a : giaoVienDTOs){
            if(checkOwned(a.getMaGiaoVien(), maPhongThi, maCaThi, phanCongDTOs)){
                list.add(a);
            }
        }
        return list;
    }
    
    public boolean checkOwned(String maGiaoVien,String maPhongThi,String maCaThi,ArrayList<PhanCongDTO> phanCongDTOs){
        for(PhanCongDTO a : phanCongDTOs){
            if(a.getMaCaThi().equals(maCaThi)&&a.getMaGiaoVien().equals(maGiaoVien)&&a.getMaPhongThi().equals(maPhongThi)){
                return false;
            }
        }
        return true;
    }
    
    public boolean checkFull(String maPhongThi,String maCaThi,ArrayList<PhanCongDTO> phanCongDTOs){
        int count = 0;
        for(PhanCongDTO a : phanCongDTOs){
            if(maPhongThi.equals(a.getMaPhongThi())&&maCaThi.equals(a.getMaCaThi())){
                count++;
                if(count>=2){
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean Add(PhanCongDTO phanCongDTO,ArrayList<PhanCongDTO> phanCongDTOs){
        
        if(phanCongDAO.insertPhanCong(phanCongDTO)){
            phanCongDTOs.add(phanCongDTO);
            return true;
        }
        return false;
    }
    
    public boolean Delete(PhanCongDTO phanCongDTO,ArrayList<PhanCongDTO> phanCongDTOs,String maKhoaThi,ArrayList<KhoaThiDTO> khoaThiDTOs){
        if(!khoaKhiBUS.checkFinished(maKhoaThi, khoaThiDTOs) && phanCongDAO.deletePhanCong(phanCongDTO)){
//            for(PhanCongDTO a : phanCongDTOs){
//                if(a.getMaCaThi().equals(phanCongDTO.getMaCaThi())&&a.getMaGiaoVien().equals(phanCongDTO.getMaGiaoVien())&&a.getMaPhongThi().equals(phanCongDTO.getMaPhongThi())){
//                    phanCongDTOs.remove(a);
//                }
//            }
            Iterator<PhanCongDTO> iterator = phanCongDTOs.iterator();
            while (iterator.hasNext()) {
                PhanCongDTO a = iterator.next();
                if(a.getMaCaThi().equals(phanCongDTO.getMaCaThi())&&a.getMaGiaoVien().equals(phanCongDTO.getMaGiaoVien())&&a.getMaPhongThi().equals(phanCongDTO.getMaPhongThi())){
                    iterator.remove();
                }
            }
            
            return true;
        }
        return false;
    }
    
    public boolean Update(PhanCongDTO phanCongDTO,ArrayList<PhanCongDTO> phanCongDTOs){
        if(phanCongDAO.updatePhanCong(phanCongDTO)){
            for(PhanCongDTO a : phanCongDTOs){
                if(a.getMaCaThi().equals(phanCongDTO.getMaCaThi())&&a.getMaGiaoVien().equals(phanCongDTO.getMaGiaoVien())&&a.getMaPhongThi().equals(phanCongDTO.getMaPhongThi())){
                    a.setNhiemVu(phanCongDTO.getNhiemVu());
                }
            }
            return true;
        }
        return false;
    }
    
    
}
