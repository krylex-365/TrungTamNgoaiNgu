/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.DataThiSinh;
import DTO.ThiSinhDTO;
import DTO.ThiSinhThongKe;

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

    public ArrayList<ThiSinhThongKe> getListThongKe(String matrinhdo){
        ArrayList<ThiSinhThongKe> thiSinhThongKes = new ArrayList<ThiSinhThongKe>();
        conn = new Connect();
        conn.getConnection();
        String query = "select ts.MaThiSinh, ts.HoTen, k.TenKhoaThi, ts.Status\n" +
                "from ThiSinh ts, TrinhDo td, KhoaThi k\n" +
                "where ts.MaTrinhDo=td.MaTrinhDo and ts.MaTrinhDo='"+matrinhdo+"' \n" +
                "\tand ts.MaKhoaThi=k.MaKhoaThi and ts.Status<>0";
        try {
            conn.executeQuery(query);
            String trangThai;
            while (conn.rs.next()) {
                ThiSinhThongKe ts = new ThiSinhThongKe();
                ts.setMathisinh(conn.rs.getString(1));
                ts.setTenthisinh(conn.rs.getString(2));
                ts.setTenkhoathi(conn.rs.getString(3));
                trangThai = conn.rs.getString(4);
                if (trangThai.equals("1")) {
                    ts.setTrangthai("Chưa đóng tiền");
                } else if (trangThai.equals("2")) {
                    ts.setTrangthai("Đã đóng tiền");
                } else if (trangThai.equals("3")) {
                    ts.setTrangthai("Chưa thi");
                } else if (trangThai.equals("4")) {
                    ts.setTrangthai("Đã thi");
                } else {
                    ts.setTrangthai("Error");
                }
                thiSinhThongKes.add(ts);
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
        return thiSinhThongKes;
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
    
    public ArrayList<ThiSinhDTO> getByMaTrinhDo(String maTrinhDo,String maKhoaThi){
        ArrayList<ThiSinhDTO> thiSinhDTOs = new ArrayList<ThiSinhDTO>();
        conn = new Connect();
        conn.getConnection();
        //int count = 0;
        String query = "select * from ThiSinh where Status<>0 and MaTrinhDo ='"+maTrinhDo+"' and MaKhoaThi='"+maKhoaThi+"'";
        try {
            conn.executeQuery(query);
            while (conn.rs.next()) {
//                count++;
//                System.out.println(count);
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
                //System.out.println(cp);
                thiSinhDTOs.add(cp);
            }
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("ThiSinhDAO.findByMaTrinhDo.executeQuery error.");
        }
        try{
            conn.getConn().close();
        }catch (SQLException e){
            System.out.println("ThiSinhDAO.findByMaTrinhDo.close error.");
        }
        return thiSinhDTOs;
    }

    public ArrayList<DataThiSinh> timKiemThiSinh(String hoTen, String sdt){
        ArrayList<DataThiSinh> dataThiSinhs = new ArrayList<DataThiSinh>();
        conn = new Connect();
        conn.getConnection();
        String query = "select " +
                "    ts.*, " +
                "    kt.TenKhoaThi, " +
                "    td.TenTrinhDo, " +
                "    pbdt.SoBaoDanh, " +
                "    pt.TenPhongThi, " +
                "    ct.GioBatDau, " +
                "    ct.GioKetThuc, " +
                "    kq.Nghe, " +
                "    kq.Noi, " +
                "    kq.Doc, " +
                "    kq.Viet, " +
                "    pbdt.NgayThi " +
                "from ThiSinh ts " +
                "left join KhoaThi kt on kt.MaKhoaThi = ts.MaKhoaThi and kt.Status = 1 " +
                "left join TrinhDo td on ts.MaTrinhDo = td.MaTrinhDo and td.Status = 1 " +
                "left join PhieuBaoDuThi pbdt on pbdt.MaThiSinh = ts.MaThiSinh and pbdt.Status = 1 " +
                "left join PhongThi pt on pt.MaPhongThi = pbdt.MaPhongThi and pt.Status = 1 " +
                "left join CaThi ct on ct.MaCaThi = pbdt.MaCaThi and ct.Status = 1 " +
                "left join KetQuaThi kq on kq.SoBaoDanh = pbdt.SoBaoDanh and kq.Status = 1 " +
                "where " +
                "    ts.HoTen = N'" + hoTen + "' " +
                "    and ts.Sdt = '" + sdt + "' " +
                "    and ts.Status <> 0";
        try {
            conn.executeQuery(query);
            while (conn.rs.next()) {
                DataThiSinh dataThiSinh = new DataThiSinh();
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
                dataThiSinh.thiSinhDTO = cp;

                dataThiSinh.khoaThi = conn.rs.getString(14);
                dataThiSinh.tenTrinhDo = conn.rs.getString(15);
                dataThiSinh.soBaoDanh = conn.rs.getString(16);
                dataThiSinh.tenPhongThi = conn.rs.getString(17);
                dataThiSinh.gioBatDau = conn.rs.getString(18);
                dataThiSinh.gioKetThuc = conn.rs.getString(19);
                dataThiSinh.nghe = conn.rs.getFloat(20);
                dataThiSinh.noi = conn.rs.getFloat(21);
                dataThiSinh.doc = conn.rs.getFloat(22);
                dataThiSinh.viet = conn.rs.getFloat(23);
                dataThiSinh.ngayThi = conn.rs.getString(24);

                dataThiSinhs.add(dataThiSinh);
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
        return dataThiSinhs;
    }

    public ArrayList<DataThiSinh> timKiemThiSinhDuThi(String maKhoaThi, String maPhongThi){
        ArrayList<DataThiSinh> dataThiSinhs = new ArrayList<DataThiSinh>();
        conn = new Connect();
        conn.getConnection();
        String query = "select " +
                "    ts.*, " +
                "    kt.TenKhoaThi, " +
                "    td.TenTrinhDo, " +
                "    pbdt.SoBaoDanh, " +
                "    pt.TenPhongThi, " +
                "    ct.GioBatDau, " +
                "    ct.GioKetThuc, " +
                "    kq.Nghe, " +
                "    kq.Noi, " +
                "    kq.Doc, " +
                "    kq.Viet, " +
                "    pbdt.NgayThi " +
                "from ThiSinh ts " +
                "left join KhoaThi kt on kt.MaKhoaThi = ts.MaKhoaThi and kt.Status = 1 " +
                "left join TrinhDo td on ts.MaTrinhDo = td.MaTrinhDo and td.Status = 1 " +
                "left join PhieuBaoDuThi pbdt on pbdt.MaThiSinh = ts.MaThiSinh and pbdt.Status = 1 " +
                "left join PhongThi pt on pt.MaPhongThi = pbdt.MaPhongThi and pt.Status = 1 " +
                "left join CaThi ct on ct.MaCaThi = pbdt.MaCaThi and ct.Status = 1 " +
                "left join KetQuaThi kq on kq.SoBaoDanh = pbdt.SoBaoDanh and kq.Status = 1 " +
                "where " +
                "    pt.MaKhoaThi = '" + maKhoaThi + "' " +
                "    and pt.MaPhongThi = '" + maPhongThi + "' " +
                "    and ts.Status >= 3";
        try {
            conn.executeQuery(query);
            while (conn.rs.next()) {
                DataThiSinh dataThiSinh = new DataThiSinh();
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
                dataThiSinh.thiSinhDTO = cp;

                dataThiSinh.khoaThi = conn.rs.getString(14);
                dataThiSinh.tenTrinhDo = conn.rs.getString(15);
                dataThiSinh.soBaoDanh = conn.rs.getString(16);
                dataThiSinh.tenPhongThi = conn.rs.getString(17);
                dataThiSinh.gioBatDau = conn.rs.getString(18);
                dataThiSinh.gioKetThuc = conn.rs.getString(19);
                dataThiSinh.nghe = conn.rs.getFloat(20);
                dataThiSinh.noi = conn.rs.getFloat(21);
                dataThiSinh.doc = conn.rs.getFloat(22);
                dataThiSinh.viet = conn.rs.getFloat(23);
                dataThiSinh.ngayThi = conn.rs.getString(24);

                dataThiSinhs.add(dataThiSinh);
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
        return dataThiSinhs;
    }

    public ArrayList<DataThiSinh> timKiemThiSinhSoBaoDanh(String SDB){
        ArrayList<DataThiSinh> dataThiSinhs = new ArrayList<DataThiSinh>();
        conn = new Connect();
        conn.getConnection();
        String query = "select " +
                "    ts.*, " +
                "    kt.TenKhoaThi, " +
                "    td.TenTrinhDo, " +
                "    pbdt.SoBaoDanh, " +
                "    kq.Nghe, " +
                "    kq.Noi, " +
                "    kq.Doc, " +
                "    kq.Viet, " +
                "    pbdt.NgayThi " +
                "from ThiSinh ts " +
                "left join KhoaThi kt on kt.MaKhoaThi = ts.MaKhoaThi and kt.Status = 1 " +
                "left join TrinhDo td on ts.MaTrinhDo = td.MaTrinhDo and td.Status = 1 " +
                "left join PhieuBaoDuThi pbdt on pbdt.MaThiSinh = ts.MaThiSinh and pbdt.Status = 1 " +
                "left join KetQuaThi kq on kq.SoBaoDanh = pbdt.SoBaoDanh and kq.Status = 1 " +
                "where " +
                "    pbdt.SoBaoDanh = '" + SDB + "' " +
                "    and ts.Status >= 3";
        try {
            conn.executeQuery(query);
            while (conn.rs.next()) {
                DataThiSinh dataThiSinh = new DataThiSinh();
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
                dataThiSinh.thiSinhDTO = cp;

                dataThiSinh.khoaThi = conn.rs.getString(14);
                dataThiSinh.tenTrinhDo = conn.rs.getString(15);
                dataThiSinh.soBaoDanh = conn.rs.getString(16);
                dataThiSinh.nghe = conn.rs.getFloat(17);
                dataThiSinh.noi = conn.rs.getFloat(18);
                dataThiSinh.doc = conn.rs.getFloat(19);
                dataThiSinh.viet = conn.rs.getFloat(20);
                dataThiSinh.ngayThi = conn.rs.getString(21);

                dataThiSinhs.add(dataThiSinh);
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
        return dataThiSinhs;
    }

}
