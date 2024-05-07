/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom08.bookstore.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author quythuong
 */
public class ReceiptDetailsDAO {

    private Connection con = null;

    public ReceiptDetailsDAO() {
        con = (new DBConnection()).GetDBConnection();
    }

    public void addChiTietHoaDon(String maHD, String maSach, int soLuongBan, double gia) {
        // Câu lệnh SQL thêm chi tiết hóa đơn
        String sql = "INSERT INTO ChiTietHoaDon (MaHD, MaSach, SoLuongBan, Gia) VALUES (?, ?, ?, ?)";

        // Tạo đối tượng PreparedStatement
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            // Thiết lập giá trị cho các tham số
            stmt.setString(1, maHD);
            stmt.setString(2, maSach);
            stmt.setInt(3, soLuongBan);
            stmt.setDouble(4, gia);

            // Thực thi câu lệnh thêm
            int rowsAffected = stmt.executeUpdate();

            // Kiểm tra xem có hàng nào được thêm không
            if (rowsAffected > 0) {
                System.out.println("Chi tiết hóa đơn đã được thêm thành công.");
            } else {
                System.out.println("Không có chi tiết hóa đơn nào được thêm.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Lỗi khi thêm chi tiết hóa đơn: " + ex.getMessage());
        }
    }

}
