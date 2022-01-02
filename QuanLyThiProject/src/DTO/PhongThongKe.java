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

    public String getNgaythi() {
        return tenkhoathi;
    }

    public String getTentringdo() {
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

    public void setNgaythi(String tentringdo) {
        this.ngaythi = tentringdo;
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
