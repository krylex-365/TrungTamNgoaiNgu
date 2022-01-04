/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.KetQuaThiDAO;
import DTO.KetQuaThiDTO;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class KetQuaThiBUS {
    public Utils utl = new Utils();
    public KetQuaThiDAO ketQuaThiDAO = new KetQuaThiDAO();
    
    
    
    public boolean checkExist(String sbd,ArrayList<KetQuaThiDTO> ketQuaThiDTOs){
        for(KetQuaThiDTO a : ketQuaThiDTOs){
            if(a.getSoBaoDanh().equals(sbd)){
                return false;
            }
        }
        return true;
    }
    
    public boolean Add(String sbd,float nghe,float noi,float doc,float viet){
        return false;
    }
    
    public boolean Delete(String sbd){
        return false;
    }
    
    public boolean Update(String sbd,float nghe,float noi,float doc,float viet){
        return false;
    }
}
