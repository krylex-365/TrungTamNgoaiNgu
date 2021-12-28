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
public class KetQuaThiDTO {
    private String soBaoDanh;
    private float nghe;
    private float noi;
    private float doc;
    private float viet;

    public KetQuaThiDTO() {
    }

    public KetQuaThiDTO(String soBaoDanh, float nghe, float noi, float doc, float viet) {
        this.soBaoDanh = soBaoDanh;
        this.nghe = nghe;
        this.noi = noi;
        this.doc = doc;
        this.viet = viet;
    }

    public String getSoBaoDanh() {
        return soBaoDanh;
    }

    public void setSoBaoDanh(String soBaoDanh) {
        this.soBaoDanh = soBaoDanh;
    }

    public float getNghe() {
        return nghe;
    }

    public void setNghe(float nghe) {
        this.nghe = nghe;
    }

    public float getNoi() {
        return noi;
    }

    public void setNoi(float noi) {
        this.noi = noi;
    }

    public float getDoc() {
        return doc;
    }

    public void setDoc(float doc) {
        this.doc = doc;
    }

    public float getViet() {
        return viet;
    }

    public void setViet(float viet) {
        this.viet = viet;
    }

    @Override
    public String toString() {
        return "KetQuaThiDTO{" + "soBaoDanh=" + soBaoDanh + ", nghe=" + nghe + ", noi=" + noi + ", doc=" + doc + ", viet=" + viet + '}';
    }
}
