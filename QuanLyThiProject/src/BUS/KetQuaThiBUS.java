/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.KetQuaThiDAO;
import DTO.DataThiSinh;
import DTO.KetQuaThiDTO;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/**
 *
 * @author User
 */
public class KetQuaThiBUS {
    public Utils utl = new Utils();
    public KetQuaThiDAO ketQuaThiDAO = new KetQuaThiDAO();
    
    public ArrayList<DataThiSinh> getMixedList(){
        return ketQuaThiDAO.getDataThiSinh();
    }
    
    public boolean checkExist(String sbd,ArrayList<KetQuaThiDTO> ketQuaThiDTOs){
        for(KetQuaThiDTO a : ketQuaThiDTOs){
            if(a.getSoBaoDanh().equals(sbd)){
                return false;
            }
        }
        return true;
    }
    
    public boolean Add(KetQuaThiDTO ketQuaThiDTO,ArrayList<KetQuaThiDTO> ketQuaThiDTOs,Date ngayThi){
        if(ngayThi.before(utl.getDateWithoutTimeUsingFormat())&&ketQuaThiDAO.insertKetQuaThi(ketQuaThiDTO)){
            ketQuaThiDTOs.add(ketQuaThiDTO);
            return true;
        }
        return false;
    }
    
    public boolean Delete(String ketQuaThiDTO,ArrayList<KetQuaThiDTO> ketQuaThiDTOs){
        if(ketQuaThiDAO.deleteKetQuaThi(ketQuaThiDTO)){
            Iterator<KetQuaThiDTO> iterator = ketQuaThiDTOs.iterator();
            while (iterator.hasNext()) {
                KetQuaThiDTO a = iterator.next();
                if (a.getSoBaoDanh().equals(ketQuaThiDTO)) {
                    iterator.remove();
                    
                }
            }
            return true;
            
        }
        return false;
    }
    
    
    public boolean Update(KetQuaThiDTO ketQuaThiDTO,ArrayList<KetQuaThiDTO> ketQuaThiDTOs){
        if (ketQuaThiDAO.updateKetQuaThi(ketQuaThiDTO)) {
            System.out.println("Update success");
            for(KetQuaThiDTO a : ketQuaThiDTOs){
                if(a.getSoBaoDanh().equals(ketQuaThiDTO.getSoBaoDanh())){
                    a = ketQuaThiDTO;
                    break;
                }
            }
            return true;
        }
        return false;
    }
}
