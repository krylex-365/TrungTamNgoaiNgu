/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.MaDuLieuCuoiDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class MaDuLieuCuoiDAO {
    private String maKhoaThiLast;
    private String maTrinhDoLast;
    private String maPhongThiLast;
    private String maCaThiLast;
    private String maGiaoVienLast;
    private String maThiSinhLast;
    Connect conn;
    
    public MaDuLieuCuoiDAO() {
        getLastData();
    }
    
    public void getLastData() {
        conn = new Connect();
        conn.getConnection();
        String query = "select * from MaDuLieuCuoi";
        try {
            conn.executeQuery(query);
            while (conn.rs.next()) {
                setMaKhoaThiLast(conn.rs.getString(1));
                setMaTrinhDoLast(conn.rs.getString(2));
                setMaPhongThiLast(conn.rs.getString(3));
                setMaCaThiLast(conn.rs.getString(4));
                setMaGiaoVienLast(conn.rs.getString(5));
                setMaThiSinhLast(conn.rs.getString(6));
            }
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("DuLieuLast.executeQuery error.");
        }
        try {
            conn.getConn().close();
        } catch (SQLException e) {
            System.out.println("DuLieuLast.close error.");
        }
    }
    
    public boolean updateMaKhoaThi(String newLatestMaKhoaThi){
        conn = new Connect();
        conn.getConnection();
        String query = "UPDATE MaDuLieuCuoi SET"
                    + " MaKhoaThi='"+newLatestMaKhoaThi+"'"
                    + " WHERE MaKhoaThi='"+getMaKhoaThiLast()+"'";
        if (conn.executeUpdate(query)) {
            System.out.println("Update last MaKhoaThi success.");
            setMaKhoaThiLast(newLatestMaKhoaThi);
            conn.close();
            return true;
        }
        System.out.println("Update last MaKhoaThi fail.");
        conn.close();
        return false;
    }
    
    public boolean updateMaTrinhDo(String newLatestMaTrinhDo){
        conn = new Connect();
        conn.getConnection();
        String query = "UPDATE MaDuLieuCuoi SET"
                    + " MaTrinhDo='"+newLatestMaTrinhDo+"'"
                    + " WHERE MaTrinhDo='"+getMaTrinhDoLast()+"'";
        if (conn.executeUpdate(query)) {
            System.out.println("Update last MaTrinhDo success.");
            setMaTrinhDoLast(newLatestMaTrinhDo);
            conn.close();
            return true;
        }
        System.out.println("Update last MaTrinhDo fail.");
        conn.close();
        return false;
    }
    
    public boolean updateMaPhongThi(String newLatestMaPhongThi){
        conn = new Connect();
        conn.getConnection();
        String query = "UPDATE MaDuLieuCuoi SET"
                    + " MaPhongThi='"+newLatestMaPhongThi+"'"
                    + " WHERE MaPhongThi='"+getMaPhongThiLast()+"'";
        if (conn.executeUpdate(query)) {
            System.out.println("Update last MaPhongThi success.");
            setMaPhongThiLast(newLatestMaPhongThi);
            conn.close();
            return true;
        }
        System.out.println("Update last MaPhongThi fail.");
        conn.close();
        return false;
    }
    
    public boolean updateMaCaThi(String newLatestMaCaThi){
        conn = new Connect();
        conn.getConnection();
        String query = "UPDATE MaDuLieuCuoi SET"
                    + " MaCaThi='"+newLatestMaCaThi+"'"
                    + " WHERE MaCaThi='"+getMaCaThiLast()+"'";
        if (conn.executeUpdate(query)) {
            System.out.println("Update last MaCaThi success.");
            setMaCaThiLast(newLatestMaCaThi);
            conn.close();
            return true;
        }
        System.out.println("Update last MaCaThi fail.");
        conn.close();
        return false;
    }
    
    public boolean updateMaGiaoVien(String newLatestMaGiaoVien){
        conn = new Connect();
        conn.getConnection();
        String query = "UPDATE MaDuLieuCuoi SET"
                    + " MaGiaoVien='"+newLatestMaGiaoVien+"'"
                    + " WHERE MaGiaoVien='"+getMaGiaoVienLast()+"'";
        if (conn.executeUpdate(query)) {
            System.out.println("Update last MaGiaoVien success.");
            setMaGiaoVienLast(newLatestMaGiaoVien);
            conn.close();
            return true;
        }
        System.out.println("Update last MaGiaoVien fail.");
        conn.close();
        return false;
    }
    
    public boolean updateMaThiSinh(String newLatestMaThiSinh){
        conn = new Connect();
        conn.getConnection();
        String query = "UPDATE MaDuLieuCuoi SET"
                    + " MaThiSinh='"+newLatestMaThiSinh+"'"
                    + " WHERE MaThiSinh='"+getMaThiSinhLast()+"'";
        if (conn.executeUpdate(query)) {
            System.out.println("Update last MaThiSinh success.");
            setMaThiSinhLast(newLatestMaThiSinh);
            conn.close();
            return true;
        }
        System.out.println("Update last MaThiSinh fail.");
        conn.close();
        return false;
    }

    public String getMaKhoaThiLast() {
        return maKhoaThiLast;
    }

    public void setMaKhoaThiLast(String maKhoaThiLast) {
        this.maKhoaThiLast = maKhoaThiLast;
    }

    public String getMaTrinhDoLast() {
        return maTrinhDoLast;
    }

    public void setMaTrinhDoLast(String maTrinhDoLast) {
        this.maTrinhDoLast = maTrinhDoLast;
    }

    public String getMaPhongThiLast() {
        return maPhongThiLast;
    }

    public void setMaPhongThiLast(String maPhongThiLast) {
        this.maPhongThiLast = maPhongThiLast;
    }

    public String getMaCaThiLast() {
        return maCaThiLast;
    }

    public void setMaCaThiLast(String maCaThiLast) {
        this.maCaThiLast = maCaThiLast;
    }

    public String getMaGiaoVienLast() {
        return maGiaoVienLast;
    }

    public void setMaGiaoVienLast(String maGiaoVienLast) {
        this.maGiaoVienLast = maGiaoVienLast;
    }

    public String getMaThiSinhLast() {
        return maThiSinhLast;
    }

    public void setMaThiSinhLast(String maThiSinhLast) {
        this.maThiSinhLast = maThiSinhLast;
    }

    public Connect getConn() {
        return conn;
    }

    public void setConn(Connect conn) {
        this.conn = conn;
    }
}
