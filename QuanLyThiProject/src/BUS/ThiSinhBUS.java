/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.MaDuLieuCuoiDAO;
import DAO.ThiSinhDAO;
import DTO.*;
import GUI.DashBoard;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class ThiSinhBUS {
    private Utils utl = new Utils();
    private MaDuLieuCuoiDAO maLast = new MaDuLieuCuoiDAO();
    ThiSinhDAO thiSinhDAO = new ThiSinhDAO();

    public ArrayList<ThiSinhDTO> getList(){
        return  thiSinhDAO.getList();
    }
    public ArrayList<ThiSinhThongKe> getThongke(String matrinhdo){
        return thiSinhDAO.getListThongKe(matrinhdo);
    }
    public ArrayList<ThiSinhDTO> getByMaTrinhDo(String matrinhdo,String maKhoaThi){
        return thiSinhDAO.getByMaTrinhDo(matrinhdo,maKhoaThi);
    }
    
    public String getHoTenByMaThiSinh(String maThiSinh,ArrayList<ThiSinhDTO> thiSinhDTOs){
        for(ThiSinhDTO a : thiSinhDTOs){
            if(a.getMaThiSinh().equals(maThiSinh)){
                return a.getHoTen();
            }
        }
        return null;
    }
    
    public int getStatusByMaThiSinh(String maThiSinh,ArrayList<ThiSinhDTO> thiSinhDTOs){
        for(ThiSinhDTO a : thiSinhDTOs){
            if(a.getMaThiSinh().equals(maThiSinh)){
                return a.getTinhTrang();
            }
        }
        return 0;
    }
    
    public boolean allowToUpdate(String maThiSinh,ArrayList<ThiSinhDTO> thiSinhDTOs){
        for(ThiSinhDTO a : thiSinhDTOs){
            if(a.getMaThiSinh().equals(maThiSinh)){
                if(a.getTinhTrang()==3||a.getTinhTrang()==4){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean Add(ThiSinhDTO thiSinh,ArrayList<ThiSinhDTO> thiSinhDTOS){
        if(thiSinhDAO.insertThiSinh(thiSinh)){
            thiSinhDTOS.add(thiSinh);
            maLast.updateMaThiSinh(thiSinh.getMaThiSinh());
            System.out.println("ThiSinhBUS.Add success");
            return true;
        }
        System.out.println("ThiSinhBUS.Add fail");
        return false;
    }

    public boolean Add(ThiSinhDTO thiSinh){
        if(thiSinhDAO.insertThiSinh(thiSinh)){
            maLast.updateMaThiSinh(thiSinh.getMaThiSinh());
            System.out.println("ThiSinhBUS.Add success");
            return true;
        }
        System.out.println("ThiSinhBUS.Add fail");
        return false;
    }
    
    public boolean Update(ThiSinhDTO thiSinh,ArrayList<ThiSinhDTO> thiSinhDTOS){
        if(thiSinhDAO.updateThiSinh(thiSinh)){
            for(ThiSinhDTO thisinh: thiSinhDTOS){
                if(thisinh.getMaThiSinh().equals(thiSinh.getMaThiSinh())){
                    thisinh = thiSinh;
                }
            }
            System.out.println("ThiSinhBUS.Update success");
            return true;
        }
        System.out.println("ThiSinhBUS.Update fail");
        return false;
    }
    
    public boolean Delete(String maThiSinh,ArrayList<ThiSinhDTO> thiSinhDTOs,ArrayList<PhieuBaoDuThiDTO> phieuBaoDuThiDTOs){
        for(PhieuBaoDuThiDTO pbdt: phieuBaoDuThiDTOs){
            System.out.println("PBDT: "+pbdt.getMaThiSinh());
            System.out.println("ThiSinh: "+ maThiSinh);
            if(pbdt.getMaThiSinh().equals(maThiSinh)){
                if(utl.stringToDate(pbdt.getNgayThi()).before(utl.getDateWithoutTimeUsingFormat())){
//                    System.out.println("NgayThi:  "+pbdt.getNgayThi());
//                    System.out.println("NgayHienTai:  "+utl.getDateWithoutTimeUsingFormat());
//                    System.out.println("Thi roi khong xoa dc");
                    return false;
                }
            }
        }
        if(thiSinhDAO.deleteThiSinh(maThiSinh)){
            thiSinhDTOs.remove(findByMaThiSinh(maThiSinh));
            return true;
        }
        return false;
    }
    
    public ThiSinhDTO findByMaThiSinh(String maThiSinh){    
        for(ThiSinhDTO thisinh: DashBoard.thiSinhDTOs){
            if(thisinh.getMaThiSinh().equals(maThiSinh)){
                return thisinh;
            }
        }
        return null;
    }
    
    public boolean UpdateStatusAfterModified(String maThiSinh,int status,ArrayList<ThiSinhDTO> thiSinhDTOs){
            if(thiSinhDAO.updateStatusThiSinh(maThiSinh, status)){
                return true;
            }
                return false;
    }
    
    public boolean UpdataStatus(String maThiSinh,int status,ArrayList<ThiSinhDTO> thiSinhDTOs){
        if(allowToUpdate(maThiSinh,thiSinhDTOs)){
            if(thiSinhDAO.updateStatusThiSinh(maThiSinh, status)){
                return true;
            }else{
                return false;
            }
        }else{
            System.out.println("Khong duoc sua status");
        }
        return false;
    }
    
    
    public String capPhat (){
        return utl.initMaThiSinh();
    }

    public ArrayList<DataThiSinh> timKiemThiSinh(String hoTen, String sdt){
        return thiSinhDAO.timKiemThiSinh(hoTen, sdt);
    }

    public ArrayList<DataThiSinh> timKiemThiSinhDuThi(String maKhoaThi, String maPhongThi){
        return thiSinhDAO.timKiemThiSinhDuThi(maKhoaThi, maPhongThi);
    }

    public ArrayList<DataThiSinh> timKiemThiSinhSoBaoDanh(String SDB){
        return thiSinhDAO.timKiemThiSinhSoBaoDanh(SDB);
    }
}
