/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom08.bookstore.DAO;

import com.nhom08.bookstore.Models.EmployeeModel;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author MSI
 */
public class EmployeeDetailDAO {

    private Connection con = null;

    // Hàm khởi tạo với tham số là kết nối CSDL
    public EmployeeDetailDAO() {
        con = (new DBConnection()).GetDBConnection();
    }

    public EmployeeModel getInfo() {
        EmployeeModel employee = new EmployeeModel();
        CallableStatement statement = null;
        ResultSet rs = null;
        boolean hasResultSet = false;

        try {
            statement = con.prepareCall("{call Proc_XemThongTinCaNhan}");
            hasResultSet = statement.execute();
            if (hasResultSet) {
                rs = statement.getResultSet();
                if (rs.next()) {
                    employee.setId(rs.getInt("MaNV"));
                    employee.setName(rs.getString("TenNV"));
                    employee.setSex(rs.getString("GioiTinh"));
                    employee.setAddress(rs.getString("DiaChi"));
                    employee.setAccount(rs.getString("TenTaiKhoan"));
                    employee.setPass(rs.getString("MatKhau"));
                    employee.setPosition(rs.getString("ChucVu"));
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return employee;
    }

    public boolean updateInfo(String tenNV, String gioiTinh, String diaChi, String matKhauMoi) {
        CallableStatement statement = null;
        ResultSet rs = null;
        boolean hasResultSet = false;
        boolean success = false;

        try {
            statement = con.prepareCall("{call Proc_SuaThongTinCaNhan(?, ?, ?, ?)}");
            statement.setString(1, tenNV);
            statement.setString(2, gioiTinh);
            statement.setString(3, diaChi);
            statement.setString(4, matKhauMoi);

            hasResultSet = statement.execute();
            if (!hasResultSet) {
                int rowsAffected = statement.getUpdateCount();
                success = rowsAffected > 0;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return success;
    }

}
