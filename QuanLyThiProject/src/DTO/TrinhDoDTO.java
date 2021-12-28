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
public class TrinhDoDTO {
    private String maTrinhDo;
    private String tenTrinhDo;
    private String lePhi;
    private int soLuongTS;
    private int soLuongPG;

    public TrinhDoDTO() {
    }

    public TrinhDoDTO(String maTrinhDo, String tenTrinhDo, String lePhi, int soLuongTS, int soLuongPG) {
        this.maTrinhDo = maTrinhDo;
        this.tenTrinhDo = tenTrinhDo;
        this.lePhi = lePhi;
        this.soLuongTS = soLuongTS;
        this.soLuongPG = soLuongPG;
    }
    
    public String getMaTrinhDo() {
        return maTrinhDo;
    }

    public void setMaTrinhDo(String maTrinhDo) {
        this.maTrinhDo = maTrinhDo;
    }

    public String getTenTrinhDo() {
        return tenTrinhDo;
    }

    public void setTenTrinhDo(String tenTrinhDo) {
        this.tenTrinhDo = tenTrinhDo;
    }

    public String getLePhi() {
        return lePhi;
    }

    public void setLePhi(String lePhi) {
        this.lePhi = lePhi;
    }

    public int getSoLuongTS() {
        return soLuongTS;
    }

    public void setSoLuongTS(int soLuongTS) {
        this.soLuongTS = soLuongTS;
    }

    public int getSoLuongPG() {
        return soLuongPG;
    }

    public void setSoLuongPG(int soLuongPG) {
        this.soLuongPG = soLuongPG;
    }

    @Override
    public String toString() {
        return "TrinhDoDTO{" + "maTrinhDo=" + maTrinhDo + ", tenTrinhDo=" + tenTrinhDo + ", lePhi=" + lePhi + ", soLuongTS=" + soLuongTS + ", soLuongPG=" + soLuongPG + '}';
    }
}
