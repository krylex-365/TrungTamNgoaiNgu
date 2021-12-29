/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.MaDuLieuCuoiDAO;
import DAO.ThiSinhDAO;
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
    
    public ThiSinhDTO findByMaThiSinh(String maThiSinh){    
        for(ThiSinhDTO thisinh: DashBoard.thiSinhDTOs){
            if(thisinh.getMaThiSinh().equals(maThiSinh)){
                return thisinh;
            }
        }
        return null;
    }
    
    
    public String capPhat (){
        return utl.initMaThiSinh();
    }
}
