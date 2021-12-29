/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DTO.TrinhDoDTO;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class TrinhDoBUS {
    public TrinhDoDTO findByMaTrinhDo(String maTrinhDo,ArrayList<TrinhDoDTO> maTrinhDoDTOs){
        for(TrinhDoDTO trinhdo: maTrinhDoDTOs){
            if(trinhdo.getMaTrinhDo().equals(maTrinhDo)){
                return trinhdo;
            }
        }
        return null;
    }
    
    public String findTenTrinhDo(String maTrinhDo,ArrayList<TrinhDoDTO> maTrinhDoDTOs){
        for(TrinhDoDTO trinhdo: maTrinhDoDTOs){
            if(trinhdo.getMaTrinhDo().equals(maTrinhDo)){
                return trinhdo.getTenTrinhDo();
            }
        }
        return null;
    }
}
