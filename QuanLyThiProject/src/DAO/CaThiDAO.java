/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.CaThiDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class CaThiDAO {
    Connect conn;

    public CaThiDAO() {
    }
    
    public ArrayList<CaThiDTO> getList(){
        ArrayList<CaThiDTO> caThiDTOs = new ArrayList<CaThiDTO>();
        conn = new Connect();
        conn.getConnection();
        String query = "select * from CaThi where Status=1";
        try {
            conn.executeQuery(query);
            while (conn.rs.next()) {
                CaThiDTO dto = new CaThiDTO();
                dto.setMaCaThi(conn.rs.getString(1));
                dto.setGioBatDau(conn.rs.getString(2));
                dto.setGioKetThuc(conn.rs.getString(3));
                caThiDTOs.add(dto);
            }
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("CaThiDAO.getList.executeQuery error.");
        }
        try{
        conn.getConn().close();
        }catch (SQLException e){
            System.out.println("CaThiDAO.getList.close error.");
        }
        return caThiDTOs;
    }
    
    public boolean insertCaThi(CaThiDTO caThiDTO) {
        conn = new Connect();
        conn.getConnection();
        String query = "INSERT INTO CaThi"
                + " VALUES ('" + caThiDTO.getMaCaThi()
                + "','" + caThiDTO.getGioBatDau()
                + "','" + caThiDTO.getGioKetThuc()
                + "', 1);";
        if (conn.executeUpdate(query)) {
            conn.close();
            System.out.println("CaThiDAO insert success.");
            return true;
        }
        conn.close();
        System.out.println("CaThiDAO insert fail.");
        return false;
    }

    public boolean updateCaThi(CaThiDTO caThiDTO) {
        conn = new Connect();
        conn.getConnection();
        String sql = "UPDATE CaThi SET"
                + " GioBatDau='" + caThiDTO.getGioBatDau()+ "',"
                + " GioKetThuc='" + caThiDTO.getGioKetThuc()+ "'"
                + " WHERE MaCaThi='" + caThiDTO.getMaCaThi()+ "';";
        if (conn.executeUpdate(sql)) {
            conn.close();
            System.out.println("CaThiDAO update success.");
            return true;
        }
        conn.close();
        System.out.println("CaThiDAO update fail.");
        return false;
    }

    public boolean deleteCaThi(String maCaThi) {
        String sql = "update CaThi "
                + "set Status=0 "
                + "where MaCaThi='" + maCaThi + "'";
        conn = new Connect();
        conn.getConnection();
        if (conn.executeUpdate(sql)) {
            conn.close();
            System.out.println("CaThiDAO delete success.");
            return true;
        }
        conn.close();
        System.out.println("CaThiDAO delete fail.");
        return false;
    }
}
