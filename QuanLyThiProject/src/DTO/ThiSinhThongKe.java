package DTO;

public class ThiSinhThongKe {
    private String mathisinh;
    private String tenthisinh;
    private String tenkhoathi;
    private String trangthai;

    public String getMathisinh() {
        return mathisinh;
    }

    public void setMathisinh(String mathisinh) {
        this.mathisinh = mathisinh;
    }

    public String getTenthisinh() {
        return tenthisinh;
    }

    public void setTenthisinh(String tenthisinh) {
        this.tenthisinh = tenthisinh;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public String getTenkhoathi() {
        return tenkhoathi;
    }

    public void setTenkhoathi(String tenkhoathi) {
        this.tenkhoathi = tenkhoathi;
    }

    @Override
    public String toString() {
        return "ThiSinhThongKe{" +
                "mathisinh='" + mathisinh + '\'' +
                ", tenthisinh='" + tenthisinh + '\'' +
                ", tentrinhdo='" + trangthai + '\'' +
                ", tenkhoathi='" + tenkhoathi + '\'' +
                '}';
    }
}
