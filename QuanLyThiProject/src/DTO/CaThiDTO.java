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
public class CaThiDTO {
    private String maCaThi;
    private String gioBatDau;
    private String gioKetThuc;

    public CaThiDTO() {
    }

    public CaThiDTO(String maCaThi, String gioBatDau, String gioKetThuc) {
        this.maCaThi = maCaThi;
        this.gioBatDau = gioBatDau;
        this.gioKetThuc = gioKetThuc;
    }

    public String getMaCaThi() {
        return maCaThi;
    }

    public void setMaCaThi(String maCaThi) {
        this.maCaThi = maCaThi;
    }

    public String getGioBatDau() {
        return gioBatDau;
    }

    public void setGioBatDau(String gioBatDau) {
        this.gioBatDau = gioBatDau;
    }

    public String getGioKetThuc() {
        return gioKetThuc;
    }

    public void setGioKetThuc(String gioKetThuc) {
        this.gioKetThuc = gioKetThuc;
    }

    @Override
    public String toString() {
        return "CaThiDTO{" + "maCaThi=" + maCaThi + ", gioBatDau=" + gioBatDau + ", gioKetThuc=" + gioKetThuc + '}';
    }
}
