package com.dat.solid.ocp.good;

public class DuHocSinh extends SinhVien {
    public DuHocSinh(String maSV, String tenSV) {
        super(maSV, tenSV);
    }

    @Override
    public float tinhHocPhi(int soTinChi, float tienMotTin) {
        return soTinChi * tienMotTin * 1.3f;
    }
}
