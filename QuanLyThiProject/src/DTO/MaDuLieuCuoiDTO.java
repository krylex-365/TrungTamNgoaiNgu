/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author User
 */
public class MaDuLieuCuoiDTO {
    private String maKhoaThi;
    private String maTrinhDo;
    private String maPhongThi;
    private String maCaThi;
    private String maGiaoVien;
    private String maThiSinh;

    public MaDuLieuCuoiDTO() {
    }

    public MaDuLieuCuoiDTO(String maKhoaThi, String maTrinhDo, String maPhongThi, String maCaThi, String maGiaoVien, String maThiSinh) {
        this.maKhoaThi = maKhoaThi;
        this.maTrinhDo = maTrinhDo;
        this.maPhongThi = maPhongThi;
        this.maCaThi = maCaThi;
        this.maGiaoVien = maGiaoVien;
        this.maThiSinh = maThiSinh;
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

    public String getMaThiSinh() {
        return maThiSinh;
    }

    public void setMaThiSinh(String maThiSinh) {
        this.maThiSinh = maThiSinh;
    }

    @Override
    public String toString() {
        return "MaDuLieuCuoi{" + "maKhoaThi=" + maKhoaThi + ", maTrinhDo=" + maTrinhDo + ", maPhongThi=" + maPhongThi + ", maCaThi=" + maCaThi + ", maGiaoVien=" + maGiaoVien + ", maThiSinh=" + maThiSinh + '}';
    }
}
