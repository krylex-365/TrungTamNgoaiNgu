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

    public boolean them(String maTrinhDo, String tenTrinhDo, String lePhi, ArrayList<TrinhDoDTO> trinhDoDTOs) {
        if(trinhDoDAO.them(maTrinhDo, tenTrinhDo, lePhi)){
            util.maDLCuoi.updateMaTrinhDo(maTrinhDo);
            trinhDoDTOs.add(new TrinhDoDTO(maTrinhDo, tenTrinhDo, lePhi, 0, 0));
            return true;
        }
        return false;
    }

    public boolean sua(String maTrinhDo, String tenTrinhDo, String lePhi, ArrayList<TrinhDoDTO> trinhDoDTOs) {
        if(trinhDoDAO.sua(maTrinhDo, tenTrinhDo, lePhi)){
            updateDtoOfList(trinhDoDTOs, new TrinhDoDTO(maTrinhDo, tenTrinhDo, lePhi, 0, 0));
            return true;
        }
        return false;
    }

    private void updateDtoOfList(ArrayList<TrinhDoDTO> trinhDoDTOs, TrinhDoDTO trinhDoDTO) {
        for(TrinhDoDTO td: trinhDoDTOs){
            if(td.getMaTrinhDo().equals(trinhDoDTO.getMaTrinhDo())){
                td.setTenTrinhDo(trinhDoDTO.getTenTrinhDo());
                td.setLePhi(trinhDoDTO.getLePhi());
                td.setSoLuongTS(trinhDoDTO.getSoLuongTS());
                td.setSoLuongPG(trinhDoDTO.getSoLuongPG());
                break;
            }
        }
    }

    public boolean xoa(String maTrinhDo, ArrayList<TrinhDoDTO> trinhDoDTOs) {
        if(trinhDoDAO.xoa(maTrinhDo)){
            deleteDtoOfList(trinhDoDTOs, maTrinhDo);
            return true;
        }
        return false;
    }

    private void deleteDtoOfList(ArrayList<TrinhDoDTO> trinhDoDTOs, String maTrinhDo) {
        for (TrinhDoDTO trinhDoDTO: trinhDoDTOs){
            if(trinhDoDTO.getMaTrinhDo().equals(maTrinhDo)){
                trinhDoDTOs.remove(trinhDoDTO);
                break;
            }
        }
    }
}
