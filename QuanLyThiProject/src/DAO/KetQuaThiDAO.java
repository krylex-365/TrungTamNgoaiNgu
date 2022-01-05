/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.DataThiSinh;
import DTO.KetQuaThiDTO;
import DTO.ThiSinhDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class KetQuaThiDAO {
    Connect conn;

    public KetQuaThiDAO() {
    }

    public ArrayList<KetQuaThiDTO> getList() {
        ArrayList<KetQuaThiDTO> ketQuaThiDTO = new ArrayList<KetQuaThiDTO>();
        conn = new Connect();
        conn.getConnection();
        String query = "select * from KetQuaThi where Status<>1";
        try {
            conn.executeQuery(query);
            while (conn.rs.next()) {
                KetQuaThiDTO dto = new KetQuaThiDTO();
                dto.setSoBaoDanh(conn.rs.getString(1));
                dto.setNghe(conn.rs.getFloat(2));
                dto.setNoi(conn.rs.getFloat(3));
                dto.setDoc(conn.rs.getFloat(4));
                dto.setViet(conn.rs.getFloat(4));
                ketQuaThiDTO.add(dto);
//                System.out.println(dto);
            }

        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("KetQuaThiDAO.getList.executeQuery error.");
        }
        try {
            conn.getConn().close();
        } catch (SQLException e) {
            System.out.println("KetQuaThiDAO.getList.close error.");
        }
        return ketQuaThiDTO;
    }
    
    public ArrayList<DataThiSinh> getDataThiSinh(){
        ArrayList<DataThiSinh> dataThiSinhs = new ArrayList<DataThiSinh>();
        conn = new Connect();
        conn.getConnection();
        String query = "select " +
                "    ts.MaThiSinh, " +
                "    pbdt.SoBaoDanh, " +
                "    ts.HoTen, " +
                "    ts.SDT, " +
                "    td.TenTrinhDo, " +
                "    pt.TenPhongThi, " +
                "    ct.MaCaThi, " +
                "    kq.Nghe, " +
                "    kq.Noi, " +
                "    kq.Doc, " +
                "    kq.Viet " +
                "from KetQuaThi kq " +
                "left join PhieuBaoDuThi pbdt on kq.SoBaoDanh=pbdt.SoBaoDanh " +
                "left join ThiSinh ts on ts.MaThiSinh=pbdt.MaThiSinh " +
                "left join TrinhDo td on ts.MaTrinhDo = td.MaTrinhDo " +
                "left join PhongThi pt on pt.MaPhongThi = pbdt.MaPhongThi " +
                "left join CaThi ct on ct.MaCaThi = pbdt.MaCaThi " +
                "where kq.Status <> 0 ";
        try {
            conn.executeQuery(query);
            while (conn.rs.next()) {
                DataThiSinh dataThiSinh = new DataThiSinh();
                ThiSinhDTO thiSinh = new ThiSinhDTO();
                
                thiSinh.setMaThiSinh(conn.rs.getString(1));
                dataThiSinh.soBaoDanh = conn.rs.getString(2);
                thiSinh.setHoTen(conn.rs.getString(3));
                thiSinh.setSdt(conn.rs.getString(4));
                dataThiSinh.tenTrinhDo = conn.rs.getString(5);
                dataThiSinh.tenPhongThi = conn.rs.getString(6);
                dataThiSinh.maCaThi = conn.rs.getString(7);
                dataThiSinh.nghe = conn.rs.getFloat(8);
                dataThiSinh.noi = conn.rs.getFloat(9);
                dataThiSinh.doc = conn.rs.getFloat(10);
                dataThiSinh.viet = conn.rs.getFloat(11);
                dataThiSinh.thiSinhDTO = thiSinh;

                dataThiSinhs.add(dataThiSinh);
            }
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("KetQuaThiDAO.getList.executeQuery error.");
        }
        try{
            conn.getConn().close();
        }catch (SQLException e){
            System.out.println("KetQuaThiDAO.getList.close error.");
        }
        return dataThiSinhs;
    }

    public boolean insertKetQuaThi(KetQuaThiDTO ketQuaThiDTO) {
        conn = new Connect();
        conn.getConnection();
        //System.out.println("MaPhongThi : "+phanCongDTO.getMaPhongThi()+"  MaCaThi: "+phanCongDTO.getMaCaThi()+"  MaGiaoVien: "+phanCongDTO.getMaGiaoVien());
        
        String query = " IF EXISTS (SELECT * FROM KetQuaThi WHERE SoBaoDanh='" + ketQuaThiDTO.getSoBaoDanh()+ "') "+
        " BEGIN "+
        " UPDATE KetQuaThi SET Status=1,Nghe=-1,Noi=-1,Doc=-1,Viet=-1 WHERE SoBaoDanh='" + ketQuaThiDTO.getSoBaoDanh()+ "'"+
        " END "+
        " ELSE "+
        " BEGIN "+
        "INSERT INTO KetQuaThi"
                + " VALUES ('" + ketQuaThiDTO.getSoBaoDanh()+"',-1,-1,-1,-1,1) "+ 
        " END";
        if (conn.executeUpdate(query)) {
            conn.close();
            System.out.println("KetQuaThiDAO insert success.");
            return true;
        }
        conn.close();
        System.out.println("KetQuaThiDAO insert fail.");
        return false;
    }

    public boolean deleteKetQuaThi(String SBD) {
        String sql = "update KetQuaThi "
                + "set Status=0 "
                + "where SoBaoDanh='" + SBD+ "'";
        conn = new Connect();
        conn.getConnection();
        if (conn.executeUpdate(sql)) {
            conn.close();
            System.out.println("KetQuaThiDAO delete success.");
            return true;
        }
        conn.close();
        System.out.println("KetQuaThiDAO delete fail.");
        return false;
    }
    
    public boolean delete(String SBD) {
        String sql = "delete from KetQuaThi "
                + " where SoBaoDanh='" + SBD+ "'";
        conn = new Connect();
        conn.getConnection();
        if (conn.executeUpdate(sql)) {
            conn.close();
            System.out.println("KetQuaThiDAO delete success.");
            return true;
        }
        conn.close();
        System.out.println("KetQuaThiDAO delete fail.");
        return false;
    }
    
    public boolean updateKetQuaThi(KetQuaThiDTO ketQuaThiDTO) {
        conn = new Connect();
        conn.getConnection();
        String sql = "UPDATE KetQuaThi SET"
                + " Nghe=" + ketQuaThiDTO.getNghe()+ ", "
                + " Noi=" + ketQuaThiDTO.getNoi()+ ", "
                + " Doc=" + ketQuaThiDTO.getDoc()+ ", "
                + " Viet=" + ketQuaThiDTO.getViet()+ " "
                + " WHERE SoBaoDanh='" + ketQuaThiDTO.getSoBaoDanh()+"'";
        if (conn.executeUpdate(sql)) {
            conn.close();
            System.out.println("KetQuaThiDAO update success.");
            return true;
        }
        conn.close();
        System.out.println("KetQuaThiDAO update fail.");
        return false;
    }

}
