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
public class PhanCongDTO {
    private String maPhongThi;
    private String maCaThi;
    private String maGiaoVien;
    private String ngayThi;
    private String nhiemVu;

    public PhanCongDTO() {
    }

    public PhanCongDTO(String maPhongThi, String maCaThi, String maGiaoVien, String ngayThi, String nhiemVu) {
        this.maPhongThi = maPhongThi;
        this.maCaThi = maCaThi;
        this.maGiaoVien = maGiaoVien;
        this.ngayThi = ngayThi;
        this.nhiemVu = nhiemVu;
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

    public String getMaGiaoVien() {
        return maGiaoVien;
    }

    public void setMaGiaoVien(String maGiaoVien) {
        this.maGiaoVien = maGiaoVien;
    }

    public String getNgayThi() {
        return ngayThi;
    }

    public void setNgayThi(String ngayThi) {
        this.ngayThi = ngayThi;
    }

    public String getNhiemVu() {
        return nhiemVu;
    }

    public void setNhiemVu(String nhiemVu) {
        this.nhiemVu = nhiemVu;
    }

    @Override
    public String toString() {
        return "PhanCongDTO{" + "maPhongThi=" + maPhongThi + ", maCaThi=" + maCaThi + ", maGiaoVien=" + maGiaoVien + ", ngayThi=" + ngayThi + ", nhiemVu=" + nhiemVu + '}';
    }

    
}
