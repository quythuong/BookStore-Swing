/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom08.bookstore.DAO;

import com.nhom08.bookstore.Models.ShiftModel;
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
 * @author MSI
 */
public class ShiftDAO {

    private Connection con = null;

    public ShiftDAO() {
        con = (new DBConnection()).GetDBConnection();
    }

    public boolean addShift(int MaNV, String Ca, String Thu, String ChucVu) throws SQLException {
        CallableStatement statement = null;
        ResultSet rs = null;
        boolean hasResultSet = false;

        try {
            statement = con.prepareCall("{CALL Proc_ThemCaLam(?, ?, ?, ?)}");
            statement.setInt(1, MaNV);
            statement.setString(2, Ca);
            statement.setString(3, Thu);
            statement.setString(4, ChucVu);

            hasResultSet = statement.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return hasResultSet;
    }

    public boolean updateShift(int MaNV, String Ca, String Thu, String ChucVu) throws SQLException {
        CallableStatement statement = null;
        boolean hasResultSet = false;

        try {
            statement = con.prepareCall("{CALL Proc_SuaCaLam(?, ?, ?, ?)}");
            statement.setInt(1, MaNV);
            statement.setString(2, Ca);
            statement.setString(3, Thu);
            statement.setString(4, ChucVu);

            hasResultSet = statement.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return hasResultSet;
    }

    public boolean deleteShift(int MaNV, String Ca, String Thu) throws SQLException {
        CallableStatement statement = null;
        boolean hasResultSet = false;

        try {
            statement = con.prepareCall("{CALL Proc_XoaCaLam(?, ?, ?)}");
            statement.setInt(1, MaNV);
            statement.setString(2, Ca);
            statement.setString(3, Thu);
            hasResultSet = statement.execute();
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return hasResultSet;
    }

    public List<ShiftModel> getAllShifts() throws SQLException {
        List<ShiftModel> shiftList = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet rs = null;

        try {
            // Thực hiện truy vấn và sắp xếp kết quả theo trường "Thu"
            statement = con.prepareStatement("SELECT MaNV, TenNV, Ca, Thu, ChucVu FROM View_XemCaLam ORDER BY "
                    + "CASE "
                    + "WHEN Thu = 'Mon' THEN 1 "
                    + "WHEN Thu = 'Tue' THEN 2 "
                    + "WHEN Thu = 'Wed' THEN 3 "
                    + "WHEN Thu = 'Thu' THEN 4 "
                    + "WHEN Thu = 'Fri' THEN 5 "
                    + "WHEN Thu = 'Sat' THEN 6 "
                    + "WHEN Thu = 'Sun' THEN 7 "
                    + "END");
            rs = statement.executeQuery();
            while (rs.next()) {
                ShiftModel shift = new ShiftModel();
                shift.setId(rs.getString("MaNV"));
                shift.setName(rs.getString("TenNV"));
                shift.setShift(rs.getString("Ca"));
                shift.setDate(rs.getString("Thu"));
                shift.setPosition(rs.getString("ChucVu"));
                shiftList.add(shift);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (statement != null) {
                statement.close();
            }
        }
        return shiftList;
    }

    public String getEmployeeNameById(int employeeId) throws SQLException {
        // Viết truy vấn SQL để lấy tên nhân viên từ bảng nhân viên dựa trên mã nhân viên
        // Ví dụ:
        String query = "SELECT TenNV FROM NhanVien WHERE MaNV = ?";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, employeeId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("TenNV");
                }
            }
        }
        return null; // Trả về null nếu không tìm thấy
    }

    public String getPositionById(int employeeId) throws SQLException {
        // Viết truy vấn SQL để lấy tên nhân viên từ bảng nhân viên dựa trên mã nhân viên
        // Ví dụ:
        String query = "SELECT ChucVu FROM NhanVien WHERE MaNV = ?";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, employeeId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("ChucVu");
                }
            }
        }
        return null; // Trả về null nếu không tìm thấy
    }

    public List<Integer> getAllEmployeeIDs() throws SQLException {
        List<Integer> employeeIDs = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet rs = null;

        try {
            statement = con.prepareStatement("SELECT MaNV FROM NhanVien");
            rs = statement.executeQuery();
            while (rs.next()) {
                int employeeID = rs.getInt("MaNV");
                employeeIDs.add(employeeID);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (statement != null) {
                statement.close();
            }
        }
        return employeeIDs;
    }

}
