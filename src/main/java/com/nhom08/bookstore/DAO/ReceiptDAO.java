/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom08.bookstore.DAO;

import com.nhom08.bookstore.Models.BookModel;
import com.nhom08.bookstore.Models.ReceiptModel;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author quythuong
 */
public class ReceiptDAO {

    private Connection con = null;

    public ReceiptDAO() {
        con = (new DBConnection()).GetDBConnection();
    }

    public void updateTotalInHoaDon(String maHD, double total) {
        // Câu lệnh SQL cập nhật tổng hóa đơn
        String sql = "UPDATE HoaDon SET TongHD = ? WHERE MaHD = ?";

        // Tạo đối tượng PreparedStatement
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            // Thiết lập giá trị cho tham số
            stmt.setDouble(1, total);
            stmt.setString(2, maHD);

            // Thực thi câu lệnh cập nhật
            int rowsAffected = stmt.executeUpdate();

            // Kiểm tra xem có hàng được cập nhật không
            if (rowsAffected > 0) {
                System.out.println("Tổng hóa đơn đã được cập nhật thành công.");
            } else {
                System.out.println("Không có hóa đơn nào được cập nhật.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi cập nhật tổng hóa đơn: " + ex.getMessage());
        }
    }

    public List<ReceiptModel> getAll() {
        List<ReceiptModel> receiptList = new ArrayList<ReceiptModel>();
        PreparedStatement statement = null;
        ResultSet rs = null;

        try {
            statement = con.prepareStatement("select * from HoaDon");
            rs = statement.executeQuery();
            while (rs.next()) {
                ReceiptModel receipt = new ReceiptModel();

                receipt.setId(rs.getString(1));
                receipt.setTotal(rs.getDouble(2));
                receipt.setDate(rs.getDate(3));

                receiptList.add(receipt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return receiptList;
    }

    public ReceiptModel getOne(String id) {
        ReceiptModel receipt = new ReceiptModel();
        PreparedStatement statement = null;
        ResultSet rs = null;

        try {
            statement = con.prepareStatement("select * from HoaDon where MaHD=?");
            statement.setString(1, id);
            rs = statement.executeQuery();
            while (rs.next()) {
                receipt.setId(rs.getString(1));
                receipt.setTotal(rs.getDouble(2));
                receipt.setDate(rs.getDate(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return receipt;
    }

}
