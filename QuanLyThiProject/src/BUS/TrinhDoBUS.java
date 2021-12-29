/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.KhoaThiDAO;
import DAO.MaDuLieuCuoiDAO;
import DAO.TrinhDoDAO;
import DTO.PhongThiDTO;
import DTO.ThiSinhDTO;
import DTO.TrinhDoDTO;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class TrinhDoBUS {
    public Utils util;
    private TrinhDoDAO trinhDoDAO;

    public TrinhDoBUS(){
        util = new Utils();
        trinhDoDAO  = new TrinhDoDAO();
    }

    public ArrayList<TrinhDoDTO> getList(){
        return  trinhDoDAO.getList();
    }

    public boolean them(String maTrinhDo, String tenTrinhDo, String lePhi) {
        if(trinhDoDAO.them(maTrinhDo, tenTrinhDo, lePhi)){
            util.maDLCuoi.updateMaTrinhDo(maTrinhDo);
            return true;
        }
        return false;
    }

    public boolean sua(String maTrinhDo, String tenTrinhDo, String lePhi) {
        if(trinhDoDAO.sua(maTrinhDo, tenTrinhDo, lePhi)){
            return true;
        }
        return false;
    }

    public boolean xoa(String maTrinhDo) {
        PhongThiBUS phongThiBUS = new PhongThiBUS();
        ArrayList<PhongThiDTO> phongThiDTOs = phongThiBUS.getList();
        for (PhongThiDTO phongThiDTO: phongThiDTOs){
            if(maTrinhDo.equals(phongThiDTO.getMaTrinhDo())){
                return false;
            }
        }
        ThiSinhBUS thiSinhBUS = new ThiSinhBUS();
        ArrayList<ThiSinhDTO> thiSinhDTOs = thiSinhBUS.thiSinhDAO.getList();
        for (ThiSinhDTO thiSinhDTO: thiSinhDTOs){
            if (maTrinhDo.equals(thiSinhDTO.getMaTrinhDo())){
                return false;
            }
        }
        if(trinhDoDAO.xoa(maTrinhDo)){
            return true;
        }
        return false;
    }
}
