/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.GiaoVienDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class GiaoVienDAO {
    Connect conn;

    public GiaoVienDAO() {
    }
    
     public ArrayList<GiaoVienDTO> getList(){
        ArrayList<GiaoVienDTO> giaoVienDTOs = new ArrayList<GiaoVienDTO>();
        conn = new Connect();
        conn.getConnection();
        String query = "select * from GiaoVien where Status=1";
        try {
            conn.executeQuery(query);
            while (conn.rs.next()) {
                GiaoVienDTO dto = new GiaoVienDTO();
                dto.setMaGiaoVien(conn.rs.getString(1));
                dto.setHoTen(conn.rs.getString(2));
                dto.setGioiTinh(conn.rs.getString(3));
                dto.setSdt(conn.rs.getString(4));
                dto.setMail(conn.rs.getString(5));
                giaoVienDTOs.add(dto);
                System.out.println(dto);
            }
            
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("GiaoVienDAO.getList.executeQuery error.");
        }
        try{
        conn.getConn().close();
        }catch (SQLException e){
            System.out.println("GiaoVienDAO.getList.close error.");
        }
        return giaoVienDTOs;
    }
     
     public boolean insertGiaoVien(GiaoVienDTO giaoVienDTO) {
        conn = new Connect();
        conn.getConnection();
        String query = "INSERT INTO GiaoVien"
                + " VALUES ('" + giaoVienDTO.getMaGiaoVien()
                + "',N'" + giaoVienDTO.getHoTen()
                + "',N'" + giaoVienDTO.getGioiTinh()
                + "','" + giaoVienDTO.getSdt()
                + "','" + giaoVienDTO.getMail()
                + "', 1);";
        if (conn.executeUpdate(query)) {
            conn.close();
            System.out.println("GiaoVienDAO insert success.");
            return true;
        }
        conn.close();
        System.out.println("GiaoVienDAO insert fail.");
        return false;
    }
     
     public boolean updateGiaoVien(GiaoVienDTO giaoVienDTO) {
        conn = new Connect();
        conn.getConnection();
        String sql = "UPDATE GiaoVien SET"
                + " HoTen=N'" + giaoVienDTO.getHoTen()+ "',"
                + " GioiTinh='" + giaoVienDTO.getGioiTinh()+ "',"
                + " Sdt='" + giaoVienDTO.getSdt()+ "',"
                + " Mail='" + giaoVienDTO.getMail()+ "'"
                + " WHERE MaGiaoVien='" + giaoVienDTO.getMaGiaoVien()+ "';";
        if (conn.executeUpdate(sql)) {
            conn.close();
            System.out.println("GiaoVienDAO update success.");
            return true;
        }
        conn.close();
        System.out.println("GiaoVienDAO update fail.");
        return false;
    }
     
     public boolean deleteGiaoVien(String maGiaoVien) {
        String sql = "update GiaoVien "
                + "set Status=0 "
                + "where MaGiaoVien='" + maGiaoVien + "'";
        conn = new Connect();
        conn.getConnection();
        if (conn.executeUpdate(sql)) {
            conn.close();
            System.out.println("GiaoVienDAO delete success.");
            return true;
        }
        conn.close();
        System.out.println("GiaoVienDAO delete fail.");
        return false;
    }

}
