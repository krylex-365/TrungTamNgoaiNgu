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
        String query = "select * from ThiSinh where Status<>0";
        try {
            conn.executeQuery(query);
            while (conn.rs.next()) {
                ThiSinhDTO cp = new ThiSinhDTO();
                cp.setMaThiSinh(conn.rs.getString(1));
                cp.setHoTen(conn.rs.getString(2));
                cp.setGioiTinh(conn.rs.getString(3));
                cp.setNgaySinh(conn.rs.getString(4));
                cp.setCmnd(conn.rs.getString(5));
                cp.setNgayCap(conn.rs.getString(6));
                cp.setNoiCap(conn.rs.getString(7));
                cp.setSdt(conn.rs.getString(8));
                cp.setMail(conn.rs.getString(9));
                cp.setDiaChi(conn.rs.getString(10));
                cp.setMaKhoaThi(conn.rs.getString(11));
                cp.setMaTrinhDo(conn.rs.getString(12));
                cp.setTinhTrang(conn.rs.getInt(13));
                thiSinhDTOs.add(cp);
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
    
    public boolean insertThiSinh(ThiSinhDTO thiSinhDTO) {
        conn = new Connect();
        conn.getConnection();
        String query = "INSERT INTO ThiSinh"
                + " VALUES ('" + thiSinhDTO.getMaThiSinh()
                + "',N'" + thiSinhDTO.getHoTen()
                + "','" + thiSinhDTO.getGioiTinh()
                + "','" + thiSinhDTO.getNgaySinh()
                + "','" + thiSinhDTO.getCmnd()
                + "','" + thiSinhDTO.getNgayCap()
                + "','" + thiSinhDTO.getNoiCap()
                + "','" + thiSinhDTO.getSdt()
                + "','" + thiSinhDTO.getMail()
                + "','" + thiSinhDTO.getDiaChi()
                + "','" + thiSinhDTO.getMaKhoaThi()
                + "','" + thiSinhDTO.getMaTrinhDo()
                + "', 1);";
        if (conn.executeUpdate(query)) {
            conn.close();
            System.out.println("ThiSinhDAO insert success.");
            return true;
        }
        conn.close();
        System.out.println("ThiSinhDAO insert fail.");
        return false;
    }

    public boolean updateThiSinh(ThiSinhDTO thiSinhDTO) {
        conn = new Connect();
        conn.getConnection();
        String sql = "UPDATE ThiSinh SET"
                + " HoTen=N'" + thiSinhDTO.getHoTen()+ "',"
                + " GioiTinh='" + thiSinhDTO.getGioiTinh()+ "',"
                + " NgaySinh='" + thiSinhDTO.getNgaySinh()+ "',"
                + " Cmnd='" + thiSinhDTO.getCmnd()+ "',"
                + " NgayCap='" + thiSinhDTO.getNgayCap()+ "',"
                + " NoiCap='" + thiSinhDTO.getNoiCap()+ "',"
                + " Sdt='" + thiSinhDTO.getSdt()+ "',"
                + " Mail='" + thiSinhDTO.getMail()+ "',"
                + " DiaChi='" + thiSinhDTO.getDiaChi()+ "',"
                + " MaKhoaThi='" + thiSinhDTO.getMaKhoaThi()+ "',"
                + " MaTrinhDo='" + thiSinhDTO.getMaTrinhDo()+ "',"
                + " Status='" + thiSinhDTO.getTinhTrang()+ "'"
                + " WHERE MaThiSinh='" + thiSinhDTO.getMaThiSinh()+ "';";
        if (conn.executeUpdate(sql)) {
            conn.close();
            System.out.println("ThiSinhDAO update success.");
            return true;
        }
        conn.close();
        System.out.println("ThiSinhDAO update fail.");
        return false;
    }
    
    public boolean updateStatusThiSinh(String maThiSinh,int Status) {
        conn = new Connect();
        conn.getConnection();
        String sql = "UPDATE ThiSinh SET"
                + " Status='" + Status+ "'"
                + " WHERE MaThiSinh='" + maThiSinh+ "';";
        if (conn.executeUpdate(sql)) {
            conn.close();
            System.out.println("ThiSinhDAO update status success.");
            return true;
        }
        conn.close();
        System.out.println("ThiSinhDAO update status fail.");
        return false;
    }
    

    public boolean deleteThiSinh(String maThiSinh) {
        String sql = "update ThiSinh "
                + "set Status=0 "
                + "where MaThiSinh='" + maThiSinh + "'";
        conn = new Connect();
        conn.getConnection();
        if (conn.executeUpdate(sql)) {
            conn.close();
            System.out.println("ThiSinhDAO delete success.");
            return true;
        }
        conn.close();
        System.out.println("ThiSinhDAO delete fail.");
        return false;
    }

}
