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
public class GiaoVienDTO {
    private String maGiaoVien;
    private String hoTen;
    private String gioiTinh;
    private String sdt;
    private String mail;

    public GiaoVienDTO() {
    }

    public GiaoVienDTO(String maGiaoVien, String hoTen, String gioiTinh, String sdt, String mail) {
        this.maGiaoVien = maGiaoVien;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.sdt = sdt;
        this.mail = mail;
    }

    public String getMaGiaoVien() {
        return maGiaoVien;
    }

    public void setMaGiaoVien(String maGiaoVien) {
        this.maGiaoVien = maGiaoVien;
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

    @Override
    public String toString() {
        return "GiaoVienDTO{" + "maGiaoVien=" + maGiaoVien + ", hoTen=" + hoTen + ", gioiTinh=" + gioiTinh + ", sdt=" + sdt + ", mail=" + mail + '}';
    }
}
