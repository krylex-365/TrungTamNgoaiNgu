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
public class PhongThiDTO {
    private String maPhongThi;
    private String tenPhongThi;
    private int soLuong;
    private String maKhoaThi;
    private String maTrinhDo;

    public PhongThiDTO() {
    }

    public PhongThiDTO(String maPhongThi, String tenPhongThi, int soLuong, String maKhoaThi, String maTrinhDo) {
        this.maPhongThi = maPhongThi;
        this.tenPhongThi = tenPhongThi;
        this.soLuong = soLuong;
        this.maKhoaThi = maKhoaThi;
        this.maTrinhDo = maTrinhDo;
    }

    public String getMaPhongThi() {
        return maPhongThi;
    }

    public void setMaPhongThi(String maPhongThi) {
        this.maPhongThi = maPhongThi;
    }

    public String getTenPhongThi() {
        return tenPhongThi;
    }

    public void setTenPhongThi(String tenPhongThi) {
        this.tenPhongThi = tenPhongThi;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
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

    @Override
    public String toString() {
        return "PhongThiDTO{" + "maPhongThi=" + maPhongThi + ", tenPhongThi=" + tenPhongThi + ", soLuong=" + soLuong + ", maKhoaThi=" + maKhoaThi + ", maTrinhDo=" + maTrinhDo + '}';
    }
}
