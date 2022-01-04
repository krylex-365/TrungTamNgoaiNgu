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
        String query = "select * from PhieuBaoDuThi where Status<>0";
        try {
            conn.executeQuery(query);
            while (conn.rs.next()) {
                PhieuBaoDuThiDTO pbdt = new PhieuBaoDuThiDTO();
                pbdt.setSoBaoDanh(conn.rs.getString(1));
                pbdt.setMaThiSinh(conn.rs.getString(2));
                pbdt.setMaPhongThi(conn.rs.getString(3));
                pbdt.setMaCaThi(conn.rs.getString(4));
                pbdt.setNgayThi(conn.rs.getString(5));
                phieuBaoDuThiDTOs.add(pbdt);
            }
            conn.getConn().close();
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("ThiSinhDAO.getList.executeQuery error.");
        }
        return phieuBaoDuThiDTOs;
    }
    
    public boolean insertPhieuBaoDuThi(PhieuBaoDuThiDTO phieuBaoDuThiDTO) {
        conn = new Connect();
        conn.getConnection();
        System.out.println(phieuBaoDuThiDTO.getNgayThi());
        String query = "INSERT INTO PhieuBaoDuThi"
                + " VALUES ('" + phieuBaoDuThiDTO.getSoBaoDanh()
                + "','" + phieuBaoDuThiDTO.getMaThiSinh()
                + "','" + phieuBaoDuThiDTO.getMaPhongThi()
                + "','" + phieuBaoDuThiDTO.getMaCaThi()
                + "','" + phieuBaoDuThiDTO.getNgayThi()
                + "', 1);";
        if (conn.executeUpdate(query)) {
            conn.close();
            System.out.println("PhieuBaoDuThiDAO insert success.");
            return true;
        }
        conn.close();
        System.out.println("PhieuBaoDuThiDAO insert fail.");
        return false;
    }
//
//    public boolean updateThiSinh(ThiSinhDTO thiSinhDTO) {
//        conn = new Connect();
//        conn.getConnection();
//        String sql = "UPDATE ThiSinh SET"
//                + " HoTen=N'" + thiSinhDTO.getHoTen()+ "',"
//                + " GioiTinh='" + thiSinhDTO.getGioiTinh()+ "',"
//                + " NgaySinh='" + thiSinhDTO.getNgaySinh()+ "',"
//                + " Cmnd='" + thiSinhDTO.getCmnd()+ "',"
//                + " NgayCap='" + thiSinhDTO.getNgayCap()+ "',"
//                + " NoiCap='" + thiSinhDTO.getNoiCap()+ "',"
//                + " Sdt='" + thiSinhDTO.getSdt()+ "',"
//                + " Mail='" + thiSinhDTO.getMail()+ "',"
//                + " DiaChi='" + thiSinhDTO.getDiaChi()+ "',"
//                + " MaKhoaThi='" + thiSinhDTO.getMaKhoaThi()+ "',"
//                + " MaTrinhDo='" + thiSinhDTO.getMaTrinhDo()+ "',"
//                + " Status='" + thiSinhDTO.getTinhTrang()+ "'"
//                + " WHERE MaThiSinh='" + thiSinhDTO.getMaThiSinh()+ "';";
//        if (conn.executeUpdate(sql)) {
//            conn.close();
//            System.out.println("ThiSinhDAO update success.");
//            return true;
//        }
//        conn.close();
//        System.out.println("ThiSinhDAO update fail.");
//        return false;
//    }
//    
//    public boolean updateStatusThiSinh(String maThiSinh,int Status) {
//        conn = new Connect();
//        conn.getConnection();
//        String sql = "UPDATE ThiSinh SET"
//                + " Status='" + Status+ "'"
//                + " WHERE MaThiSinh='" + maThiSinh+ "';";
//        if (conn.executeUpdate(sql)) {
//            conn.close();
//            System.out.println("ThiSinhDAO update status success.");
//            return true;
//        }
//        conn.close();
//        System.out.println("ThiSinhDAO update status fail.");
//        return false;
//    }
//    
//
    public boolean deleteThiSinh(String SBD) {
        String sql = "update PhieuBaoDuThi "
                + "set Status=0 "
                + "where SoBaoDanh='" + SBD + "'";
        conn = new Connect();
        conn.getConnection();
        if (conn.executeUpdate(sql)) {
            conn.close();
            System.out.println("PhieuBaoDuThiDAO delete success.");
            return true;
        }
        conn.close();
        System.out.println("PhieuBaoDuThiDAO delete fail.");
        return false;
    }
}
