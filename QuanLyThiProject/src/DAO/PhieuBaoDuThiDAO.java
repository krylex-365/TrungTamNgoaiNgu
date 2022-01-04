/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.PhieuBaoDuThiDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class PhieuBaoDuThiDAO {
    Connect conn;

    public PhieuBaoDuThiDAO() {
        
    }
    
    public ArrayList<PhieuBaoDuThiDTO> getList(){
        ArrayList<PhieuBaoDuThiDTO> phieuBaoDuThiDTOs = new ArrayList<PhieuBaoDuThiDTO>();
        conn = new Connect();
        conn.getConnection();
        String query = "select * from PhieuBaoDuThi where Status=1";
        try {
            conn.executeQuery(query);
            while (conn.rs.next()) {
                PhieuBaoDuThiDTO dto = new PhieuBaoDuThiDTO();
                dto.setSoBaoDanh(conn.rs.getString(1));
                dto.setMaThiSinh(conn.rs.getString(2));
                dto.setMaPhongThi(conn.rs.getString(3));
                dto.setMaCaThi(conn.rs.getString(4));
                dto.setNgayThi(conn.rs.getString(5));
                phieuBaoDuThiDTOs.add(dto);
            }
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("PhieuBaoDuThiDAO.getList.executeQuery error.");
        }
        try{
        conn.getConn().close();
        }catch (SQLException e){
            System.out.println("PhieuBaoDuThiDAO.getList.close error.");
        }
        return phieuBaoDuThiDTOs;
    }
}
