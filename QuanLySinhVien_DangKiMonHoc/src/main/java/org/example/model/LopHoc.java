package org.example.model;

public class LopHoc {
    private String maLopHoc;
    private String tenLopHoc;
    private String maMonHoc;

    public LopHoc(String maLopHoc, String tenLopHoc, String maMonHoc) {
        this.maLopHoc = maLopHoc;
        this.tenLopHoc = tenLopHoc;
        this.maMonHoc = maMonHoc;
    }

    public String getMaLopHoc() {
        return maLopHoc;
    }

    public String getTenLopHoc() {
        return tenLopHoc;
    }

    public String getMaMonHoc() {
        return maMonHoc;
    }

    @Override
    public String toString() {
        return "LopHoc{" +
                "maLopHoc='" + maLopHoc + '\'' +
                ", tenLopHoc='" + tenLopHoc + '\'' +
                ", maMonHoc='" + maMonHoc + '\'' +
                '}';
    }
}
