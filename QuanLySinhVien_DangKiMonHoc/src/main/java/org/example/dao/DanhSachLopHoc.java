package org.example.dao;

import org.example.model.LopHoc;

import java.util.ArrayList;
import java.util.List;

// Lớp DanhSachLopHoc quản lý danh sách các đối tượng LopHoc.
public class DanhSachLopHoc {
    private List<LopHoc> dsLopHoc;

    public DanhSachLopHoc() {
        dsLopHoc = new ArrayList<>(); // Sử dụng ArrayList để quản lý danh sách lớp học.
    }

    public void themLopHoc(LopHoc lh) {
        dsLopHoc.add(lh); // Thêm đối tượng LopHoc vào danh sách.
    }

    // Phương thức xóa lớp học khỏi danh sách dựa trên mã lớp học.
    public void xoaLopHoc(String maLopHoc) {
        // Dùng lambda expression và phương thức removeIf để xóa lớp học có mã tương ứng.
        dsLopHoc.removeIf(lh -> lh.getMaLopHoc().equals(maLopHoc));
    }

    // Phương thức tìm và trả về một lớp học dựa trên mã lớp học.
    public LopHoc timLopHocByMa(String maLopHoc) {
        for (LopHoc lh : dsLopHoc) {
            // Nếu tìm thấy lớp học có mã trùng khớp, trả về đối tượng LopHoc đó.
            if (lh.getMaLopHoc().equals(maLopHoc)) {
                return lh;
            }
        }
        //Nếu không tìm thấy.
        return null;
    }

    // Phương thức tìm và trả về danh sách các lớp học dựa trên mã môn học.
    public List<LopHoc> timLopHocByMonHoc(String maMonHoc) {
        List<LopHoc> result = new ArrayList<>(); // Danh sách lưu trữ kết quả tìm kiếm.
        for (LopHoc lh : dsLopHoc) {
            // Nếu lớp học có mã môn học trùng khớp, thêm vào danh sách kết quả.
            if (lh.getMaMonHoc().equals(maMonHoc)) {
                result.add(lh);
            }
        }
        // Trả về danh sách các lớp học có mã môn học trùng khớp.
        return result;
    }
}
