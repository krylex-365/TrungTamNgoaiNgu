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
public class PhieuBaoDuThiDTO {
    private String soBaoDanh;
    private String maThiSinh;
    private String maPhongThi;
    private String maCaThi;
    private String ngayThi;

    public PhieuBaoDuThiDTO() {
    }

    public PhieuBaoDuThiDTO(String soBaoDanh, String maThiSinh, String maPhongThi, String maCaThi, String ngayThi) {
        this.soBaoDanh = soBaoDanh;
        this.maThiSinh = maThiSinh;
        this.maPhongThi = maPhongThi;
        this.maCaThi = maCaThi;
        this.ngayThi = ngayThi;
    }

    public String getSoBaoDanh() {
        return soBaoDanh;
    }

    public void setSoBaoDanh(String soBaoDanh) {
        this.soBaoDanh = soBaoDanh;
    }

    public String getMaThiSinh() {
        return maThiSinh;
    }

    public void setMaThiSinh(String maThiSinh) {
        this.maThiSinh = maThiSinh;
    }

    public String getMaPhongThi() {
        return maPhongThi;
    }

    public void setMaPhongThi(String maPhongThi) {
        this.maPhongThi = maPhongThi;
    }

    public String getMaCaThi() {
        return maCaThi;
    }

    public void setMaCaThi(String maCaThi) {
        this.maCaThi = maCaThi;
    }

    public String getNgayThi() {
        return ngayThi;
    }

    public void setNgayThi(String ngayThi) {
        this.ngayThi = ngayThi;
    }

    @Override
    public String toString() {
        return "PhieuBaoDuThiDTO{" + "soBaoDanh=" + soBaoDanh + ", maThiSinh=" + maThiSinh + ", maPhongThi=" + maPhongThi + ", maCaThi=" + maCaThi + ", ngayThi=" + ngayThi + '}';
    }
}
