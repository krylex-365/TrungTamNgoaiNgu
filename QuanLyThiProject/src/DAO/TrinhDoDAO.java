/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.KhoaThiDTO;
import DTO.TrinhDoDTO;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class TrinhDoDAO {
    Connect conn;

    public ArrayList<TrinhDoDTO> getList(){
        ArrayList<TrinhDoDTO> trinhDoDTOs = new ArrayList<TrinhDoDTO>();
        conn = new Connect();
        conn.getConnection();
        String query = "select * from TrinhDo where Status=1";
        try {
            conn.executeQuery(query);
            while (conn.rs.next()) {
                TrinhDoDTO cp = new TrinhDoDTO();
                cp.setMaTrinhDo(conn.rs.getString(1));
                cp.setTenTrinhDo(conn.rs.getString(2));
                cp.setLePhi(conn.rs.getString(3));
                cp.setSoLuongTS(conn.rs.getInt(4));
                cp.setSoLuongPG(conn.rs.getInt(5));
                trinhDoDTOs.add(cp);
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
        return trinhDoDTOs;
    }

    public boolean them(String maTrinhDo, String tenTrinhDo, String lePhi) {
        conn = new Connect();
        conn.getConnection();
        String query = "insert into TrinhDo values ('" + maTrinhDo + "', N'" + tenTrinhDo + "'," +
                " '" + lePhi + "', 0, 0, 1);";
        if(conn.executeUpdate(query)){
            try {
                conn.getConn().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }

    public boolean sua(String maTrinhDo, String tenTrinhDo, String lePhi) {
        conn = new Connect();
        conn.getConnection();
        String query = "update TrinhDo set "
//                + "TenTrinhDo = N'" + tenTrinhDo + "', " 
                + "LePhi = '" + lePhi 
                + "' where MaTrinhDo = '" + maTrinhDo + "'";
        if(conn.executeUpdate(query)){
            try {
                conn.getConn().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }
    
    public boolean updateTS(String maTrinhDo, int soLuongTS) {
        conn = new Connect();
        conn.getConnection();
        String query = "update TrinhDo set SoLuongTS = '" + soLuongTS + "'"
                + " where MaTrinhDo = '" + maTrinhDo + "'";
        if(conn.executeUpdate(query)){
            try {
                conn.getConn().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }
    
    public boolean updatePG(String maTrinhDo, int soLuongPG) {
        conn = new Connect();
        conn.getConnection();
        String query = "update TrinhDo set SoLuongPG = '" + soLuongPG + "'"
                + " where MaTrinhDo = '" + maTrinhDo + "'";
        if(conn.executeUpdate(query)){
            try {
                conn.getConn().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }

    public boolean xoa(String maTrinhDo) {
        conn = new Connect();
        conn.getConnection();
        String query = "update TrinhDo set Status = " + 0 + " where MaTrinhDo = '" + maTrinhDo + "'";
        if(conn.executeUpdate(query)){
            try {
                conn.getConn().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }
}
