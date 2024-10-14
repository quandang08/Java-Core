package org.example.model;

public class SinhVien {
    private static int count = 1000000000;
    private String maSV;
    private String firstName;
    private String lastName;
    private double gpa;

    public SinhVien( String firstName, String lastName, double gpa) {
        this.maSV = String.valueOf(count++);
        this.firstName = firstName;
        this.lastName = lastName;
        this.gpa = gpa;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "SinhVien{" +
                "maSV='" + maSV + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gpa=" + gpa +
                '}';
    }
}
