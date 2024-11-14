package com.dat.solid.ocp.good;

public class SinhVienTaiNang extends SinhVien {
    public SinhVienTaiNang(String maSV, String tenSV) {
        super(maSV, tenSV);
    }

    @Override
    public float tinhHocPhi(int soTinChi, float tienMotTin) {
        return soTinChi * tienMotTin * 0.8f;
    }
}
