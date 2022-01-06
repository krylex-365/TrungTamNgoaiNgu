/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.MaDuLieuCuoiDAO;
import DAO.PhieuBaoDuThiDAO;
import DAO.ThiSinhDAO;
import DTO.KhoaThiDTO;
import DTO.PhieuBaoDuThiDTO;
import DTO.PhongThiDTO;
import DTO.ThiSinhDTO;
import DTO.TrinhDoDTO;
import GUI.DashBoard;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/**
 *
 * @author User
 */
public class PhieuBaoDuThiBUS {
    private Utils utl = new Utils();
    private ThiSinhBUS thiSinhBUS = new ThiSinhBUS();
    private KhoaThiBUS khoaThiBUS = new KhoaThiBUS();
    private PhieuBaoDuThiDAO phieuBaoDuThiDAO= new PhieuBaoDuThiDAO();
    private MaDuLieuCuoiDAO maDuLieuCuoiDAO = new MaDuLieuCuoiDAO();
    private TrinhDoBUS trinhDoBUS = new TrinhDoBUS();
    
    
    public ArrayList<PhieuBaoDuThiDTO> getThiSinhs(String maPhong,String maCa,ArrayList<PhieuBaoDuThiDTO> phieuBaoDuThiDTOs){
        ArrayList<PhieuBaoDuThiDTO> list = new ArrayList<>();
        for(PhieuBaoDuThiDTO a : phieuBaoDuThiDTOs){
            if(a.getMaPhongThi().equals(maPhong)&&a.getMaCaThi().equals(maCa)){
                list.add(a);
            }
        }
        return list;
    }
    
    public Date getNgayThiBySBD(String SBD){
        for(PhieuBaoDuThiDTO a : phieuBaoDuThiDAO.getList()){
            if(a.getSoBaoDanh().equals(SBD)){
                return utl.stringToDate(a.getNgayThi());
            }
        }
        return null;
    }
    
    public boolean CheckThiChua(String SBD){
        if(getNgayThiBySBD(SBD).before(utl.getDateWithoutTimeUsingFormat())){
            return true;
        }
        return false;
    }
    
    public boolean CheckOwned(String maThiSinh,String maPhongThi,String maCaThi,ArrayList<PhieuBaoDuThiDTO> phieuBaoDuThiDTOs){
        for(PhieuBaoDuThiDTO a : phieuBaoDuThiDTOs){
            if(a.getMaThiSinh().equals(maThiSinh)&&a.getMaPhongThi().equals(maPhongThi))return true;
        }
        return false; 
    }
    
    public ArrayList<ThiSinhDTO> getThiSinhsBy(String maTrinhDo,String maKhoaThi,String maPhongThi,String maCaThi,ArrayList<PhieuBaoDuThiDTO> phieuBaoDuThiDTOs){
        ArrayList<ThiSinhDTO> list = new ArrayList<>();
        for(ThiSinhDTO a : thiSinhBUS.getByMaTrinhDo(maTrinhDo,maKhoaThi)){
            //System.out.println(a);
            if(a.getTinhTrang() == 2 && !CheckOwned(a.getMaThiSinh(), maPhongThi, maCaThi, phieuBaoDuThiDTOs)){
                list.add(a);
            }
        }
        return list;
    }
    
    

    public PhieuBaoDuThiDTO Add(PhongThiDTO phongThiDTO,ThiSinhDTO thiSinhDTO,String maCaThi, ArrayList<PhieuBaoDuThiDTO> phieuBaoDuThiDTOs, ArrayList<TrinhDoDTO> trinhDoDTOs,ArrayList<KhoaThiDTO> khoaThiDTOs) {
//        for (PhongThiDTO k : phongThiDTOs) {
//            if (k.getMaKhoaThi().equals(phongThiDTO.getMaKhoaThi())) {
//                return false;
//            }
//        }
        TrinhDoDTO trinhDoDTO = trinhDoBUS.findTrinhDo(thiSinhDTO.getMaTrinhDo(), trinhDoDTOs);
        int num = trinhDoDTO.getSoLuongTS()+1;
        PhieuBaoDuThiDTO pbdt = new PhieuBaoDuThiDTO(trinhDoDTO.getMaTrinhDo()+num, thiSinhDTO.getMaThiSinh(), phongThiDTO.getMaPhongThi(), maCaThi, khoaThiBUS.findKhoaThi(thiSinhDTO.getMaKhoaThi()).getNgayThi());
        System.out.println(trinhDoDTO.getMaTrinhDo()+"-"+num);
        if (phieuBaoDuThiDAO.countThiSinhPhongThi(phongThiDTO.getMaPhongThi(), maCaThi)<=phongThiDTO.getSoLuong()&&phieuBaoDuThiDAO.insertPhieuBaoDuThi(pbdt)) {
            
            if (trinhDoBUS.capNhatSLTS(thiSinhDTO.getMaTrinhDo(), num, trinhDoDTOs)) {
                phieuBaoDuThiDTOs.add(pbdt);
                System.out.println("Thêm thành công PhieuBaoDuThiBUS");
                return pbdt;
            }
        }
        System.out.println("Thêm thất bại PhieuBaoDuThiBUS");
        return null;
    }
    
    public boolean Delete(String SBD,ArrayList<PhieuBaoDuThiDTO> phieuBaoDuThiDTOs){
        if (phieuBaoDuThiDAO.delete(SBD)) {
//            for(PhieuBaoDuThiDTO a : phieuBaoDuThiDTOs){
//                if(a.getSoBaoDanh().equals(SBD)){
//                    phieuBaoDuThiDTOs.remove(a);
//                }
//            }
            Iterator<PhieuBaoDuThiDTO> iterator = phieuBaoDuThiDTOs.iterator();
            while (iterator.hasNext()) {
                PhieuBaoDuThiDTO a = iterator.next();
                if(a.getSoBaoDanh().equals(SBD)){
                    iterator.remove();
                }
            }
            System.out.println("Xóa thành công PhieuBaoDuThiBUS");
            return true;
        }
        System.out.println("Xóa thành công PhieuBaoDuThiBUS");
        return false;
    }
    
    
}
