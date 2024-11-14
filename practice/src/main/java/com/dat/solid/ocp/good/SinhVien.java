package com.dat.solid.ocp.good;

public class SinhVien {
    private String maSV;
    private String tenSV;
    private String loaiSV;

    public SinhVien(String maSV, String tenSV) {
        this.maSV = maSV;
        this.tenSV = tenSV;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getTenSV() {
        return tenSV;
    }

    public void setTenSV(String tenSV) {
        this.tenSV = tenSV;
    }

    public float tinhHocPhi(int soTinChi, float tienMotTin) {
        return soTinChi * tienMotTin;
    }
}
