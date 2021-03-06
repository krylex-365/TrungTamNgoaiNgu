/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.KhoaThiDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class KhoaThiDAO {
    Connect conn;

    public KhoaThiDAO() {
        
    }
    
    public ArrayList<KhoaThiDTO> getList(){
        ArrayList<KhoaThiDTO> khoaThiDTOs = new ArrayList<KhoaThiDTO>();
        conn = new Connect();
        conn.getConnection();
        String query = "select * from KhoaThi where Status=1";
        try {
            conn.executeQuery(query);
            while (conn.rs.next()) {
                KhoaThiDTO dto = new KhoaThiDTO();
                dto.setMaKhoaThi(conn.rs.getString(1));
                dto.setTenKhoaThi(conn.rs.getString(2));
                dto.setNgayThi(conn.rs.getString(3));
                khoaThiDTOs.add(dto);
            }
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("KhoaThiDAO.getList.executeQuery error.");
        }
        try{
        conn.getConn().close();
        }catch (SQLException e){
            System.out.println("KhoaThiDAO.getList.close error.");
        }
        return khoaThiDTOs;
    }
    
    public KhoaThiDTO findKhaoThi(String maKhoaThi){
        //ArrayList<KhoaThiDTO> khoaThiDTOs = new ArrayList<KhoaThiDTO>();
        conn = new Connect();
        conn.getConnection();
        KhoaThiDTO dto = new KhoaThiDTO();
        String query = "select * from KhoaThi where Status=1 and MaKhoaThi='"+maKhoaThi+"'";
        try {
            conn.executeQuery(query);
            while (conn.rs.next()) {     
                dto.setMaKhoaThi(conn.rs.getString(1));
                dto.setTenKhoaThi(conn.rs.getString(2));
                dto.setNgayThi(conn.rs.getString(3));
            }
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("KhoaThiDAO.getList.executeQuery error.");
        }
        try{
        conn.getConn().close();
        }catch (SQLException e){
            System.out.println("KhoaThiDAO.getList.close error.");
        }
        return dto;
    }
    
    public boolean insertKhoaThi(KhoaThiDTO khoaThiDTO) {
        conn = new Connect();
        conn.getConnection();
        String query = "INSERT INTO KhoaThi"
                + " VALUES ('" + khoaThiDTO.getMaKhoaThi()
                + "',N'" + khoaThiDTO.getTenKhoaThi()
                + "','" + khoaThiDTO.getNgayThi()
                + "', 1);";
        if (conn.executeUpdate(query)) {
            conn.close();
            System.out.println("KhoaThiDAO insert success.");
            return true;
        }
        conn.close();
        System.out.println("KhoaThiDAO insert fail.");
        return false;
    }

    public boolean updateKhoaThi(KhoaThiDTO khoaThiDTO, boolean check) {
        conn = new Connect();
        conn.getConnection();
        String sql = "UPDATE KhoaThi SET"
                + " TenKhoaThi=N'" + khoaThiDTO.getTenKhoaThi()+ "'";
        if (check) {
            sql += ", NgayThi='" + khoaThiDTO.getNgayThi()+ "'";
        }
        sql += " WHERE MaKhoaThi='" + khoaThiDTO.getMaKhoaThi()+ "';";
        if (conn.executeUpdate(sql)) {
            conn.close();
            System.out.println("KhoaThiDAO update success.");
            return true;
        }
        conn.close();
        System.out.println("KhoaThiDAO update fail.");
        return false;
    }

    public boolean deleteKhoaThi(String maKhoaThi) {
        String sql = "update KhoaThi "
                + "set Status=0 "
                + "where MaKhoaThi='" + maKhoaThi + "'";
        conn = new Connect();
        conn.getConnection();
        if (conn.executeUpdate(sql)) {
            conn.close();
            System.out.println("KhoaThiDAO delete success.");
            return true;
        }
        conn.close();
        System.out.println("KhoaThiDAO delete fail.");
        return false;
    }
}
