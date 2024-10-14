package org.example;

import org.example.dao.DanhSachSinhVien;
import org.example.dao.CayNhiPhanMonHoc;
import org.example.dao.DanhSachLopHoc;
import org.example.model.SinhVien;
import org.example.model.MonHoc;
import org.example.model.LopHoc;
import org.example.model.DangKyLopTinChi;

public class Main {
    public static void main(String[] args) {
        // Quản lý danh sách sinh viên
        DanhSachSinhVien dsSinhVien = new DanhSachSinhVien();
        SinhVien sv1 = new SinhVien("Nguyen ","Van A", 8.5);
        SinhVien sv2 = new SinhVien("Tran ","Thi B", 9.0);
        dsSinhVien.themSinhVien(sv1);
        dsSinhVien.themSinhVien(sv2);

        // Quản lý danh sách môn học
        CayNhiPhanMonHoc cayMonHoc = new CayNhiPhanMonHoc();
        MonHoc mh1 = new MonHoc("MH01", "Toan");
        MonHoc mh2 = new MonHoc("MH02", "Ly");
        cayMonHoc.themMonHoc(mh1);
        cayMonHoc.themMonHoc(mh2);

        // Quản lý danh sách lớp học
        DanhSachLopHoc dsLopHoc = new DanhSachLopHoc();
        LopHoc lh1 = new LopHoc("LH01", "Toan Cao Cap", "MH01");
        LopHoc lh2 = new LopHoc("LH02", "Vat Ly Dai Cuong", "MH02");
        dsLopHoc.themLopHoc(lh1);
        dsLopHoc.themLopHoc(lh2);

        // Đăng ký lớp tín chỉ
        DangKyLopTinChi dkLopTinChi = new DangKyLopTinChi("LH01");
        dkLopTinChi.themSinhVien(sv1.getMaSV());
        dkLopTinChi.themSinhVien(sv2.getMaSV());

        // In ra kết quả
        System.out.println("Danh sách sinh viên:");
        System.out.println(dsSinhVien.timSinhVienByMa(sv1.getMaSV()));
        System.out.println(dsSinhVien.timSinhVienByMa(sv2.getMaSV()));

        System.out.println("Danh sách môn học:");
        System.out.println(cayMonHoc.timMonHoc("MH01"));
        System.out.println(cayMonHoc.timMonHoc("MH02"));

        System.out.println("Danh sách lớp học:");
        System.out.println(dsLopHoc.timLopHocByMa("LH01"));
        System.out.println(dsLopHoc.timLopHocByMa("LH02"));

        System.out.println("Danh sách sinh viên đăng ký lớp tín chỉ LH01:");
        for (String maSV : dkLopTinChi.getDsMaSinhVien()) {
            System.out.println(dsSinhVien.timSinhVienByMa(maSV));
        }
    }
}
