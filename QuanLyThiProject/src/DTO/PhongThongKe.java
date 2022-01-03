package DTO;

public class PhongThongKe {
    private String maphong;
    private String tenphong;
    private String tenkhoathi;
    private String ngaythi;

    public String getMaphong() {
        return maphong;
    }

    public String getTenphong() {
        return tenphong;
    }

    public String getTenkhoathi() {
        return tenkhoathi;
    }

    public String getNgaythi() {
        return ngaythi;
    }

    public void setMaphong(String maphong) {
        this.maphong = maphong;
    }

    public void setTenphong(String tenphong) {
        this.tenphong = tenphong;
    }

    public void setTenkhoathi(String tenkhoathi) {
        this.tenkhoathi = tenkhoathi;
    }

    public void setNgaythi(String ngaythi) {
        this.ngaythi = ngaythi;
    }

    @Override
    public String toString() {
        return "thongkephong{" +
                "maphong='" + maphong + '\'' +
                ", tenphong='" + tenphong + '\'' +
                ", tenkhoathi='" + tenkhoathi + '\'' +
                ", ngaythi='" + ngaythi + '\'' +
                '}';
    }
}
