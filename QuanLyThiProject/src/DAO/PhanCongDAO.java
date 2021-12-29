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
    
     public ArrayList<PhanCongDTO> getList(){
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
        try{
        conn.getConn().close();
        }catch (SQLException e){
            System.out.println("GiaoVienDAO.getList.close error.");
        }
        return phanCongDTOs;
    }
}
