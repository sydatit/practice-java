package com.dat.solid.ocp.bad;

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
        float hocPhi = soTinChi * tienMotTin;
        if (loaiSV.equals("du hoc sinh")) {
            return hocPhi * 1.3f;
        } else if (loaiSV.equals("sinh vien tai nang")) {
            return hocPhi * 0.8f;
        } else {
            return hocPhi;
        }
    }
}
