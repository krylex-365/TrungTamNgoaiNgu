/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.TrinhDoDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class TrinhDoDAO {
    Connect conn;

    public TrinhDoDAO() {
    }
    
    public ArrayList<TrinhDoDTO> getList(){
        ArrayList<TrinhDoDTO> trinhDoDTOs = new ArrayList<TrinhDoDTO>();
        conn = new Connect();
        conn.getConnection();
        String query = "select * from TrinhDo where Status=1";
        try {
            conn.executeQuery(query);
            while (conn.rs.next()) {
                TrinhDoDTO dto = new TrinhDoDTO();
                dto.setMaTrinhDo(conn.rs.getString(1));
                dto.setTenTrinhDo(conn.rs.getString(2));
                dto.setLePhi(conn.rs.getString(3));
                dto.setSoLuongTS(conn.rs.getInt(4));
                dto.setSoLuongPG(conn.rs.getInt(5));
                trinhDoDTOs.add(dto);
            }
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("TrinhDoDAO.getList.executeQuery error.");
        }
        try{
        conn.getConn().close();
        }catch (SQLException e){
            System.out.println("TrinhDoDAO.getList.close error.");
        }
        return trinhDoDTOs;
    }
}
