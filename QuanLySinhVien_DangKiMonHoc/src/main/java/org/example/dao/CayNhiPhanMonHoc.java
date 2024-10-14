package org.example.dao;

import org.example.model.MonHoc;

// Lớp CayNhiPhanMonHoc đại diện cho một cây nhị phân lưu trữ các đối tượng MonHoc.

public class CayNhiPhanMonHoc {
    private Node root; // Gốc của cây nhị phân.

    // Lớp Node đại diện cho một nút (node) trong cây nhị phân, chứa một đối tượng MonHoc.
    private class Node {
        MonHoc monHoc;
        Node left;
        Node right;

        //Constructor để khởi tạo một node mới với môn học cho trước.
        Node(MonHoc monHoc) {
            this.monHoc = monHoc;
            this.left = null;
            this.right = null;
        }
    }

    // Constructor để khởi tạo cây nhị phân rỗng.
    public CayNhiPhanMonHoc() {
        this.root = null;
    }


    public void themMonHoc(MonHoc monHoc) {
        root = themMonHoc(root, monHoc); // Gọi phương thức đệ quy để thêm môn học.
    }

    // Phương thức đệ quy để thêm môn học vào cây tại vị trí phù hợp.
    private Node themMonHoc(Node node, MonHoc monHoc) {
        if (node == null) {
            return new Node(monHoc);
        }
        // So sánh mã môn học để quyết định thêm vào cây con trái hoặc cây con phải.
        if (monHoc.getMaMonHoc().compareTo(node.monHoc.getMaMonHoc()) < 0) {
            node.left = themMonHoc(node.left, monHoc);
        } else if (monHoc.getMaMonHoc().compareTo(node.monHoc.getMaMonHoc()) > 0) {
            node.right = themMonHoc(node.right, monHoc);
        }
        // Trả về node hiện tại sau khi đã thêm môn học vào đúng vị trí.
        return node;
    }

    // Phương thức tìm kiếm một môn học theo mã môn học.
    public MonHoc timMonHoc(String maMonHoc) {
        return timMonHoc(root, maMonHoc);
    }

    // Phương thức đệ quy để tìm kiếm môn học trong cây.
    private MonHoc timMonHoc(Node node, String maMonHoc) {
        //Tra ve Null neu khong tim thay mon hoc
        if (node == null) {
            return null;
        }
        if (maMonHoc.equals(node.monHoc.getMaMonHoc())) {
            return node.monHoc;
        }
        // So sánh mã môn học để quyết định tìm trong cây con trái hoặc cây con phải.
        if (maMonHoc.compareTo(node.monHoc.getMaMonHoc()) < 0) {
            return timMonHoc(node.left, maMonHoc);
        } else {
            return timMonHoc(node.right, maMonHoc);
        }
    }

    // Phương thức xóa một môn học khỏi cây theo mã môn học.
    public void xoaMonHoc(String maMonHoc) {
        root = xoaMonHoc(root, maMonHoc);
    }

    // Phương thức đệ quy để xóa một môn học khỏi cây.
    private Node xoaMonHoc(Node node, String maMonHoc) {
        if (node == null) {
            return null;
        }
        // Nếu tìm thấy node chứa môn học cần xóa.
        if (maMonHoc.equals(node.monHoc.getMaMonHoc())) {
            // Trường hợp node không có con hoặc chỉ có một con.
            if (node.left == null && node.right == null) {
                return null;
            }
            if (node.left == null) {
                return node.right; // Node chỉ có con phải, trả về con phải.
            }
            if (node.right == null) {
                return node.left;
            }
            // Trường hợp node có hai con: tìm node nhỏ nhất ở cây con phải.
            MonHoc minRight = timMin(node.right);
            node.monHoc = minRight; // Thay thế dữ liệu của node hiện tại bằng dữ liệu của node nhỏ nhất.
            node.right = xoaMonHoc(node.right, minRight.getMaMonHoc());  // Xóa node nhỏ nhất trong cây con phải.
            return node; // Trả về node hiện tại sau khi đã xóa.
        }
        // So sánh mã môn học để quyết định xóa trong cây con trái hoặc cây con phải.
        if (maMonHoc.compareTo(node.monHoc.getMaMonHoc()) < 0) {
            node.left = xoaMonHoc(node.left, maMonHoc); // Xóa trong cây con trái.
        } else {
            node.right = xoaMonHoc(node.right, maMonHoc);
        }
        return node;
    }

    // Phương thức tìm node có giá trị nhỏ nhất trong cây con phải.
    private MonHoc timMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.monHoc;
    }
}
