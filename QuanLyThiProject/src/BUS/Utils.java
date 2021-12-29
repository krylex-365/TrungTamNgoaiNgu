package BUS;

import DAO.MaDuLieuCuoiDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class Utils {

    public MaDuLieuCuoiDAO maDLCuoi = new MaDuLieuCuoiDAO();

    public Utils() {
        maDLCuoi = new MaDuLieuCuoiDAO();
    }
    
    ////////////////Tạo mã khóa thi
    public String initMaKhoaThi() {
        maDLCuoi = new MaDuLieuCuoiDAO();
        String temp = maDLCuoi.getMaKhoaThiLast();
        System.out.println(temp);
        String add = temp.substring(2, temp.length());
        int ma = Integer.parseInt(add);
        ma++;
        int totalzero = 6;
        add = String.valueOf(ma);
        int cpzero = totalzero - add.length();
        String init = "KH";
        for (int i = 0; i < cpzero; i++) {
            init += '0';
        }
        init += add;
        return init;
    }
    
    ////////////////Tạo mã trình độ
    public String initMaTrinhDo() {
        maDLCuoi = new MaDuLieuCuoiDAO();
        String temp = maDLCuoi.getMaTrinhDoLast();
        System.out.println(temp);
        String add = temp.substring(2, temp.length());
        int ma = Integer.parseInt(add);
        ma++;
        int totalzero = 6;
        add = String.valueOf(ma);
        int cpzero = totalzero - add.length();
        String init = "TD";
        for (int i = 0; i < cpzero; i++) {
            init += '0';
        }
        init += add;
        return init;
    }
    
    ////////////////Tạo mã phòng thi
    public String initMaPhongThi() {
        maDLCuoi = new MaDuLieuCuoiDAO();
        String temp = maDLCuoi.getMaPhongThiLast();
        System.out.println(temp);
        String add = temp.substring(2, temp.length());
        int ma = Integer.parseInt(add);
        ma++;
        int totalzero = 6;
        add = String.valueOf(ma);
        int cpzero = totalzero - add.length();
        String init = "PG";
        for (int i = 0; i < cpzero; i++) {
            init += '0';
        }
        init += add;
        return init;
    }
    
    ////////////////Tạo mã ca thi
    public String initMaCaThi() {
        maDLCuoi = new MaDuLieuCuoiDAO();
        String temp = maDLCuoi.getMaCaThiLast();
        System.out.println(temp);
        String add = temp.substring(2, temp.length());
        int ma = Integer.parseInt(add);
        ma++;
        int totalzero = 6;
        add = String.valueOf(ma);
        int cpzero = totalzero - add.length();
        String init = "CA";
        for (int i = 0; i < cpzero; i++) {
            init += '0';
        }
        init += add;
        return init;
    }
    
    ////////////////Tạo mã giáo viên
    public String initMaGiaoVien() {
        maDLCuoi = new MaDuLieuCuoiDAO();
        String temp = maDLCuoi.getMaGiaoVienLast();
        System.out.println(temp);
        String add = temp.substring(2, temp.length());
        int ma = Integer.parseInt(add);
        ma++;
        int totalzero = 6;
        add = String.valueOf(ma);
        int cpzero = totalzero - add.length();
        String init = "GV";
        for (int i = 0; i < cpzero; i++) {
            init += '0';
        }
        init += add;
        return init;
    }
    
    ////////////////Tạo mã thí sinh
    public String initMaThiSinh() {
        maDLCuoi = new MaDuLieuCuoiDAO();
        String temp = maDLCuoi.getMaThiSinhLast();
        System.out.println(temp);
        String add = temp.substring(2, temp.length());
        int ma = Integer.parseInt(add);
        ma++;
        int totalzero = 6;
        add = String.valueOf(ma);
        int cpzero = totalzero - add.length();
        String init = "TS";
        for (int i = 0; i < cpzero; i++) {
            init += '0';
        }
        init += add;
        return init;
    }

    ////////////////Lấy ngày hiện tại
    public String initDateNow() {
        final Date currentTime = new Date();
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+7"));
        System.out.println("GMT time: " + sdf.format(currentTime));
        String date = sdf.format(currentTime).toString();
        return date;
    }
    
    public Date getDateWithoutTimeUsingFormat(){
        try{
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            return formatter.parse(formatter.format(new Date()));
        }catch(ParseException e){
            System.out.println(e);
            return null;   
        }  
    }

    ////////////////Lấy ngày đầu tiên của tháng kế tiếp
    public String firstDayOfnextMonth(String ngay) {
        String thanglamviec = getMonth(ngay);
        String namlamviec = getYear(ngay);
        int temp1 = Integer.parseInt(thanglamviec);
        temp1++;
        thanglamviec = String.valueOf(temp1);
        if (thanglamviec.length() == 1) {
            thanglamviec = "0" + thanglamviec;
        }
        if (thanglamviec.equals("13")) {
            int temp2 = Integer.parseInt(namlamviec);
            temp2++;
            namlamviec = String.valueOf(temp2);
            thanglamviec = "01";
        }
        String thoigian = namlamviec + "-" + thanglamviec + "-01";
        return thoigian;
    }

    /////////////////Tính số ngày so với hiện tại
    public int totalDays(String thoigian) {
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
        String hientai = initDateNow();
        System.out.println("thoigian: " + thoigian + "\nhientai: " + hientai);
        int total = -1;
        try {
            Date date1 = myFormat.parse(thoigian);
            Date date2 = myFormat.parse(hientai);
            long diff = date2.getTime() - date1.getTime();
            System.out.println("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
            total = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return total;
    }

    /////////////////Tính số ngày với 2 tham số truyền vào
    public int totalDays2(String thoigian, String d) {
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
        String hientai = d;
        System.out.println("thoigian: " + thoigian + "\nhientai: " + hientai);
        int total = -1;
        try {
            Date date1 = myFormat.parse(thoigian);
            Date date2 = myFormat.parse(hientai);
            long diff = date2.getTime() - date1.getTime();
            System.out.println("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
            total = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return total;
    }

    ////////////////Tách năm
    public static String getYear(String name) {
        int pos = name.indexOf("-");
        //System.out.println (pos);
        if (pos == -1) {
            return null;
        }
        if (pos == name.length() - 1) {
            return null;
        }
        return name.substring(0, pos);
    }

    ////////////////Tách tháng
    public static String getMonth(String name) {
        int pos = name.indexOf("-");
        //System.out.println (pos);
        int pos1 = name.indexOf("-", pos + 1);
        //System.out.println (pos1);
        if (pos == -1) {
            return null;
        }
        if (pos == name.length() - 1) {
            return null;
        }
        return name.substring(pos + 1, pos1);
    }

    ////////////////Tách ngày
    public static String getDay(String name) {
        int pos = name.indexOf("-");
        //System.out.println (pos);
        int pos1 = name.indexOf("-", pos + 1);
        //System.out.println (pos1);
        if (pos == -1) {
            return null;
        }
        if (pos == name.length() - 1) {
            return null;
        }
        return name.substring(pos1 + 1, name.length());
    }

    ////////////////Thêm 0 vào ngày có length = 1
    public String them0(String num) {
        if (num.length() >= 2) {
            return num;
        } else {
            num = "0" + num;
            return num;
        }
    }

    ////////////////Tháng -> ngày cuối cùng của tháng
    public int lastDayOfMonth(String date) {
        int monthcheck = Integer.parseInt(getMonth(date));
        int year = Integer.parseInt(getYear(date));
        switch (monthcheck) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 2:
                if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
                    return 29;
                } else {
                    return 28;
                }
            default:
                return 30;
        }
    }
    
    public Date stringToDate(String strDate){   
        try{
            SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = myFormat.parse(strDate);
            return date;
        }catch(ParseException e){
            return new Date(0, 0, 0);
        }
    }

}

class main {

    public static void main(String[] args) throws ParseException {
        Utils ut = new Utils();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        Date tgBD = simpleDateFormat.parse("12/17/2021");
        Date tgKT = simpleDateFormat1.parse("2021-12-14");
        if (tgBD.before(tgKT))
        {
            System.out.println("dsds");
        } else
        {
            System.out.println("No");
        }
//        System.out.println(ut.totalDays("2020-06-02"));
//        DiaDiemBUS diaDiemBUS = new DiaDiemBUS();
//        String maDD = diaDiemBUS.CapPhat(new MaDuLieuCuoiDAO().getMaDiaDiemLast());
//        diaDiemBUS.themDiaDiem(maDD, "dsfsdgfds");
        //diaDiemBUS.xoaDiaDiem("DD000002");
    }
}
