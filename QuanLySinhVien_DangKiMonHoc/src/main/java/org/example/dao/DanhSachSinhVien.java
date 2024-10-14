package org.example.dao;

import org.example.model.SinhVien;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class DanhSachSinhVien {
    private Node head;  // The head of the linked list

    // Inner class to represent each node in the linked list
    private class Node{
        SinhVien sinhVien;
        Node next;

        Node(SinhVien sinhVien){
            this.sinhVien = sinhVien;
            this.next = null;
        }
    }

    public DanhSachSinhVien(){
        this.head = null; // Initialize the linked list as empty
    }

    // Method to add a student to the linked list
    public void themSinhVien(SinhVien sv){
        Node newNode = new Node(sv);
        if(head == null){
            head = newNode;
        }
        else{
            Node current = head;
            // Traverse to the end of the list
            while(current.next != null){
                current.next = newNode;
            }
            current.next = newNode;
        }
    }

    // Method to remove a student based on their ID
    public void xoaSinhVien(String maSV){
        if(head == null) return;
        // If the student to remove is the head of the list
        if(head.sinhVien.getMaSV().equals(maSV)){
            head = head.next;
            return;
        }
        Node current = head;
        // Traverse to find the student with the given ID
        while(current.next != null && !current.next.sinhVien.getMaSV().equals(maSV)){
            current = current.next;
        }
        // If found, bypass the node to remove it
        if(current.next != null){
            current.next = current.next.next;
        }
    }

    // Method to find a student by their ID
    public SinhVien timSinhVienByMa(String maSV){
        Node current = head;
        while(current != null){
            if(current.sinhVien.getMaSV().equals(maSV)){
                return current.sinhVien;
            }
            current = current.next;
        }
        return null;
    }

    // Method to find students by their first name
    public List<SinhVien> timSinhVienByFirstname(String firstname) {
        List<SinhVien> result = new ArrayList<>();
        Node current = head;
        while (current != null) {
            if (current.sinhVien.getFirstName().startsWith(firstname)) {
                result.add(current.sinhVien);
            }
            current = current.next;
        }
        return result;
    }

    // Method to sort students by their GPA in descending order
    public List<SinhVien> sapXepSinhVienTheoDiem() {
        List<SinhVien> result = new ArrayList<>();
        Node current = head;
        while (current != null) {
            result.add(current.sinhVien);
            current = current.next;
        }

        result.sort((sv1, sv2) -> Double.compare(sv2.getGpa(), sv1.getGpa()));
        return result;
    }

    // Method to update a student's information
    public void suaThongTinSinhVien(String maSinhVien, String firstName, String lastName, double gpa) {
        SinhVien sv = timSinhVienByMa(maSinhVien);
        if (sv != null) {
            sv.setFirstName(firstName);
            sv.setLastName(lastName);
            sv.setGpa(gpa);
        }
    }

    // Method to save the list of students to a file
    public void luuSinhVienVaoFile(String filePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            Node current = head;
            while (current != null) {
                oos.writeObject(current.sinhVien);
                current = current.next;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to load the list of students from a file
    public void loadDataSinhVienTuFile(String filePath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            while (true) {
                SinhVien sv = (SinhVien) ois.readObject();
                themSinhVien(sv);
            }
        } catch (EOFException e) {
            // End of file reached
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

