package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class DangKyLopTinChi {
    private String maLopTinChi;
    private List<String> dsMaSinhVien;

    public DangKyLopTinChi(String maLopTinChi) {
        this.maLopTinChi = maLopTinChi;
        this.dsMaSinhVien = new ArrayList<>();
    }

    public String getMaLopTinChi() {
        return maLopTinChi;
    }

    public void themSinhVien(String maSinhVien) {
        dsMaSinhVien.add(maSinhVien);
    }

    public void xoaSinhVien(String maSinhVien) {
        dsMaSinhVien.remove(maSinhVien);
    }

    public List<String> getDsMaSinhVien() {
        return dsMaSinhVien;
    }
}
