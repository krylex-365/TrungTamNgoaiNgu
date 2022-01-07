/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.PhanCongDTO;
import java.util.ArrayList;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class PhanCongDAO {

    Connect conn;

    public PhanCongDAO() {
    }

    public ArrayList<PhanCongDTO> getList() {
        ArrayList<PhanCongDTO> phanCongDTOs = new ArrayList<PhanCongDTO>();
        conn = new Connect();
        conn.getConnection();
        String query = "select * from PhanCong where Status=1";
        try {
            conn.executeQuery(query);
            while (conn.rs.next()) {
                PhanCongDTO dto = new PhanCongDTO();
                dto.setMaPhongThi(conn.rs.getString(1));
                dto.setMaCaThi(conn.rs.getString(2));
                dto.setMaGiaoVien(conn.rs.getString(3));
                dto.setNgayThi(conn.rs.getString(4));
                dto.setNhiemVu(conn.rs.getString(5));
                phanCongDTOs.add(dto);
//                System.out.println(dto);
            }

        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("GiaoVienDAO.getList.executeQuery error.");
        }
        try {
            conn.getConn().close();
        } catch (SQLException e) {
            System.out.println("GiaoVienDAO.getList.close error.");
        }
        return phanCongDTOs;
    }

    public boolean insertPhanCong(PhanCongDTO phanCongDTO) {
        conn = new Connect();
        conn.getConnection();
        System.out.println("MaPhongThi : "+phanCongDTO.getMaPhongThi()+"  MaCaThi: "+phanCongDTO.getMaCaThi()+"  MaGiaoVien: "+phanCongDTO.getMaGiaoVien());
        
        String query = " IF EXISTS (SELECT * FROM PhanCong WHERE MaPhongThi='" + phanCongDTO.getMaPhongThi() + "' AND MaCaThi='"+phanCongDTO.getMaCaThi()+"' AND MaGiaoVien='"+phanCongDTO.getMaGiaoVien()+"' ) "+
        " BEGIN "+
        " UPDATE PhanCong SET Status=1,NhiemVu='"+phanCongDTO.getNhiemVu()+"' WHERE MaPhongThi='" + phanCongDTO.getMaPhongThi() + "' and MaCaThi='"+phanCongDTO.getMaCaThi()+"' and MaGiaoVien='"+phanCongDTO.getMaGiaoVien()+"'"+
        " END "+
        " ELSE "+
        " BEGIN "+
        "INSERT INTO PhanCong"
                + " VALUES ('" + phanCongDTO.getMaPhongThi()
                + "','" + phanCongDTO.getMaCaThi()
                + "','" + phanCongDTO.getMaGiaoVien()
                + "','" + phanCongDTO.getNgayThi()
                + "','" + phanCongDTO.getNhiemVu()
                + "', 1)"+
        " END";
        if (conn.executeUpdate(query)) {
            conn.close();
            System.out.println("PhanCongDAO insert success.");
            return true;
        }
        conn.close();
        System.out.println("PhanCongDAO insert fail.");
        return false;
    }

    public boolean deletePhanCong(PhanCongDTO phanCongDTO) {
        String sql = "update PhanCong "
                + "set Status=0 "
                + "where MaPhongThi='" + phanCongDTO.getMaPhongThi() + "' and MaCaThi='"+phanCongDTO.getMaCaThi()+"' and MaGiaoVien='"+phanCongDTO.getMaGiaoVien()+"'";
        conn = new Connect();
        conn.getConnection();
        if (conn.executeUpdate(sql)) {
            conn.close();
            System.out.println("PhanCongDAO delete success.");
            return true;
        }
        conn.close();
        System.out.println("PhanCongDAO delete fail.");
        return false;
    }
    
    public boolean updatePhanCong(PhanCongDTO phanCongDTO) {
        conn = new Connect();
        conn.getConnection();
        String sql = "UPDATE PhanCong SET"
                + " NhiemVu='" + phanCongDTO.getNhiemVu()+ "' "
                + " WHERE MaPhongThi='" + phanCongDTO.getMaPhongThi() + "' and MaCaThi='"+phanCongDTO.getMaCaThi()+"' and MaGiaoVien='"+phanCongDTO.getMaGiaoVien()+"'";
        if (conn.executeUpdate(sql)) {
            conn.close();
            System.out.println("PhanCongDAO update success.");
            return true;
        }
        conn.close();
        System.out.println("PhanCongDAO update fail.");
        return false;
    }

}
