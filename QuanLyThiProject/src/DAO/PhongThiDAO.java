/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.PhongThiDTO;
import DTO.PhongThongKe;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class PhongThiDAO {
    Connect conn;

    public PhongThiDAO() {
    }
    
    public ArrayList<PhongThiDTO> getList(){
        ArrayList<PhongThiDTO> phongThiDTOs = new ArrayList<PhongThiDTO>();
        conn = new Connect();
        conn.getConnection();
        String query = "select * from PhongThi where Status=1";
        try {
            conn.executeQuery(query);
            while (conn.rs.next()) {
                PhongThiDTO dto = new PhongThiDTO();
                dto.setMaPhongThi(conn.rs.getString(1));
                dto.setTenPhongThi(conn.rs.getString(2));
                dto.setSoLuong(conn.rs.getInt(3));
                dto.setMaKhoaThi(conn.rs.getString(4));
                dto.setMaTrinhDo(conn.rs.getString(5));
                phongThiDTOs.add(dto);
            }
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("PhongThiDAO.getList.executeQuery error.");
        }
        try{
        conn.getConn().close();
        }catch (SQLException e){
            System.out.println("PhongThiDAO.getList.close error.");
        }
        return phongThiDTOs;
    }
    public ArrayList<PhongThongKe> getThonkephong(String matrinhdo){
        ArrayList<PhongThongKe> phongThongKes = new ArrayList<PhongThongKe>();
        conn = new Connect();
        conn.getConnection();
        String query = "select pt.MaPhongThi, pt.TenPhongThi, k.TenKhoaThi, k.NgayThi\n" +
                "from PhongThi pt, KhoaThi k\n" +
                "where pt.MaKhoaThi=k.MaKhoaThi and pt.MaTrinhDo='"+matrinhdo+"' and pt.Status=1";
        try {
            conn.executeQuery(query);
            while (conn.rs.next()) {
                PhongThongKe dto = new PhongThongKe();
                dto.setMaphong(conn.rs.getString(1));
                dto.setTenphong(conn.rs.getString(2));
                dto.setTenkhoathi(conn.rs.getString(3));
                dto.setNgaythi(conn.rs.getString(4));
                phongThongKes.add(dto);

            }
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("PhongThiDAO.getList.executeQuery error.");
        }
        try{
            conn.getConn().close();
        }catch (SQLException e){
            System.out.println("PhongThiDAO.getList.close error.");
        }
        return phongThongKes;
    }

    public boolean insertPhongThi(PhongThiDTO phongThiDTO) {
        conn = new Connect();
        conn.getConnection();
        String query = "INSERT INTO PhongThi"
                + " VALUES ('" + phongThiDTO.getMaPhongThi()
                + "','" + phongThiDTO.getTenPhongThi()
                + "','" + phongThiDTO.getSoLuong()
                + "','" + phongThiDTO.getMaKhoaThi()
                + "','" + phongThiDTO.getMaTrinhDo()
                + "', 1);";
        if (conn.executeUpdate(query)) {
            conn.close();
            System.out.println("PhongThiDAO insert success.");
            return true;
        }
        conn.close();
        System.out.println("PhongThiDAO insert fail.");
        return false;
    }

    public boolean updatePhongThi(PhongThiDTO phongThiDTO, boolean checkMaKhoaThi, boolean checkMaTrinhDo) {
        conn = new Connect();
        conn.getConnection();
        String sql = "UPDATE PhongThi SET"
                + " TenPhongThi='" + phongThiDTO.getTenPhongThi()+ "',"
                + " SoLuong='" + phongThiDTO.getSoLuong()+ "'";
        if (checkMaKhoaThi) {
            sql += ", MaKhoaThi='" + phongThiDTO.getMaKhoaThi() + "'";
        }
        if (checkMaTrinhDo) {
            sql += ", MaTrinhDo='" + phongThiDTO.getMaTrinhDo() + "'";
        }
        sql += " WHERE MaPhongThi='" + phongThiDTO.getMaPhongThi()+ "';";
        if (conn.executeUpdate(sql)) {
            conn.close();
            System.out.println("PhongThiDAO update success.");
            return true;
        }
        conn.close();
        System.out.println("PhongThiDAO update fail.");
        return false;
    }

    public boolean deletePhongThi(String maPhongThi) {
        String sql = "update PhongThi "
                + "set Status=0 "
                + "where MaPhongThi='" + maPhongThi + "'";
        conn = new Connect();
        conn.getConnection();
        if (conn.executeUpdate(sql)) {
            conn.close();
            System.out.println("PhongThiDAO delete success.");
            return true;
        }
        conn.close();
        System.out.println("PhongThiDAO delete fail.");
        return false;
    }

}
