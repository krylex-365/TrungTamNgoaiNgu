/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author User
 */
public class ThiSinhDTO {
    private String maThiSinh;
    private String hoTen;
    private String gioiTinh;
    private String ngaySinh;
    private String cmnd;
    private String ngayCap;
    private String noiCap;
    private String sdt;
    private String mail;
    private String diaChi;
    private String maKhoaThi;
    private String maTrinhDo;
    private String tinhTrang;

    public ThiSinhDTO() {
    }

    public ThiSinhDTO(String maThiSinh, String hoTen, String gioiTinh, String ngaySinh, String cmnd, String ngayCap, String noiCap, String sdt, String mail, String diaChi, String maKhoaThi, String maTrinhDo, String tinhTrang) {
        this.maThiSinh = maThiSinh;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.cmnd = cmnd;
        this.ngayCap = ngayCap;
        this.noiCap = noiCap;
        this.sdt = sdt;
        this.mail = mail;
        this.diaChi = diaChi;
        this.maKhoaThi = maKhoaThi;
        this.maTrinhDo = maTrinhDo;
        this.tinhTrang = tinhTrang;
    }

    public String getMaThiSinh() {
        return maThiSinh;
    }

    public void setMaThiSinh(String maThiSinh) {
        this.maThiSinh = maThiSinh;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getNgayCap() {
        return ngayCap;
    }

    public void setNgayCap(String ngayCap) {
        this.ngayCap = ngayCap;
    }

    public String getNoiCap() {
        return noiCap;
    }

    public void setNoiCap(String noiCap) {
        this.noiCap = noiCap;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getMaKhoaThi() {
        return maKhoaThi;
    }

    public void setMaKhoaThi(String maKhoaThi) {
        this.maKhoaThi = maKhoaThi;
    }

    public String getMaTrinhDo() {
        return maTrinhDo;
    }

    public void setMaTrinhDo(String maTrinhDo) {
        this.maTrinhDo = maTrinhDo;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    @Override
    public String toString() {
        return "ThiSinhDTO{" + "maThiSinh=" + maThiSinh + ", hoTen=" + hoTen + ", gioiTinh=" + gioiTinh + ", ngaySinh=" + ngaySinh + ", cmnd=" + cmnd + ", ngayCap=" + ngayCap + ", noiCap=" + noiCap + ", sdt=" + sdt + ", mail=" + mail + ", diaChi=" + diaChi + ", maKhoaThi=" + maKhoaThi + ", maTrinhDo=" + maTrinhDo + ", tinhTrang=" + tinhTrang + '}';
    }
}
