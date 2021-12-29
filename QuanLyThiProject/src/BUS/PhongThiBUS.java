/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.PhongThiDAO;
import DTO.PhongThiDTO;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class PhongThiBUS {
    PhongThiDAO phongThiDAO;
    public PhongThiBUS(){
        phongThiDAO = new PhongThiDAO();
    }

    public ArrayList<PhongThiDTO> getList(){
        return phongThiDAO.getList();
    }
}
