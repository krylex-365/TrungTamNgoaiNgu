/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.ThiSinhDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class ThiSinhDAO {
    Connect conn;

    public ThiSinhDAO() {
    }
    
    public ArrayList<ThiSinhDTO> getList(){
        ArrayList<ThiSinhDTO> thiSinhDTOs = new ArrayList<ThiSinhDTO>();
        conn = new Connect();
        conn.getConnection();
        String query = "select * from ThiSinh where Status=1";
        try {
            conn.executeQuery(query);
            while (conn.rs.next()) {
                ThiSinhDTO dto = new ThiSinhDTO();
                dto.setMaThiSinh(conn.rs.getString(1));
                dto.setHoTen(conn.rs.getString(2));
                dto.setGioiTinh(conn.rs.getString(3));
                dto.setNgaySinh(conn.rs.getString(4));
                dto.setCmnd(conn.rs.getString(5));
                dto.setNgayCap(conn.rs.getString(6));
                dto.setNoiCap(conn.rs.getString(7));
                dto.setSdt(conn.rs.getString(8));
                dto.setMail(conn.rs.getString(9));
                dto.setDiaChi(conn.rs.getString(10));
                dto.setMaKhoaThi(conn.rs.getString(11));
                dto.setMaTrinhDo(conn.rs.getString(12));
                thiSinhDTOs.add(dto);
            }
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("ThiSinhDAO.getList.executeQuery error.");
        }
        try{
        conn.getConn().close();
        }catch (SQLException e){
            System.out.println("ThiSinhDAO.getList.close error.");
        }
        return thiSinhDTOs;
    }
}
