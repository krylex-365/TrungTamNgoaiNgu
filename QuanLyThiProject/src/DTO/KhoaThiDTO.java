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
public class KhoaThiDTO {
    private String maKhoaThi;
    private String tenKhoaThi;
    private String ngayThi;

    public KhoaThiDTO() {
    }

    public KhoaThiDTO(String maKhoaThi, String tenKhoaThi, String ngayThi) {
        this.maKhoaThi = maKhoaThi;
        this.tenKhoaThi = tenKhoaThi;
        this.ngayThi = ngayThi;
    }

    public String getMaKhoaThi() {
        return maKhoaThi;
    }

    public void setMaKhoaThi(String maKhoaThi) {
        this.maKhoaThi = maKhoaThi;
    }

    public String getTenKhoaThi() {
        return tenKhoaThi;
    }

    public void setTenKhoaThi(String tenKhoaThi) {
        this.tenKhoaThi = tenKhoaThi;
    }

    public String getNgayThi() {
        return ngayThi;
    }

    public void setNgayThi(String ngayThi) {
        this.ngayThi = ngayThi;
    }

    @Override
    public String toString() {
        return "KhoaThiDTO{" + "maKhoaThi=" + maKhoaThi + ", tenKhoaThi=" + tenKhoaThi + ", ngayThi=" + ngayThi + '}';
    }
}
