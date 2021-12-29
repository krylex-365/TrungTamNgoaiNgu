/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.MaDuLieuCuoiDAO;
import DAO.ThiSinhDAO;
import DTO.PhieuBaoDuThiDTO;
import DTO.ThiSinhDTO;
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
            if(pbdt.getMaThiSinh().equals(maThiSinh)){
                if(utl.stringToDate(pbdt.getNgayThi()).before(utl.getDateWithoutTimeUsingFormat())){
                    return false;
                }
                break;
            }
        }
        if(thiSinhDAO.deleteThiSinh(maThiSinh)){
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
    
    public boolean UpdataStatus(String maThiSinh,int status){
        if(thiSinhDAO.updateStatusThiSinh(maThiSinh, status)){
            return true;
        }else{
            return false;
        }
    }
    
    
    public String capPhat (){
        return utl.initMaThiSinh();
    }
}
