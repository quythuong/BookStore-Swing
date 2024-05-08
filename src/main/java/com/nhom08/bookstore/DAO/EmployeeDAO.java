package com.nhom08.bookstore.DAO;

import com.nhom08.bookstore.Models.BookModel;
import com.nhom08.bookstore.Models.EmployeeModel;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class EmployeeDAO {

    private Connection con = null;

    // Hàm khởi tạo với tham số là kết nối CSDL
    public EmployeeDAO() {
        con = (new DBConnection()).GetDBConnection();
    }

    public List<EmployeeModel> getAll() throws SQLException {
        List<EmployeeModel> employeeList = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet rs = null;

        try {
            statement = con.prepareStatement("SELECT * FROM NhanVien");
            rs = statement.executeQuery();
            while (rs.next()) {
                EmployeeModel employee = new EmployeeModel();
                employee.setId(rs.getInt("MaNV"));
                employee.setName(rs.getString("TenNV"));
                employee.setSex(rs.getString("GioiTinh"));
                employee.setAddress(rs.getString("DiaChi"));
                employee.setAccount(rs.getString("TenTaiKhoan"));
                employee.setLevel(rs.getInt("Cap"));
                employee.setPosition(rs.getString("ChucVu"));

                employeeList.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (statement != null) {
                statement.close();
            }
        }
        return employeeList;
    }
    public boolean addEmployee(EmployeeModel employee) throws SQLException {
        CallableStatement statement = null;
        ResultSet rs = null;
        boolean hasResultSet = false;

        try {
            statement = con.prepareCall("{CALL Proc_ThemNhanVien(?, ?, ?, ?, ?, ?, ?, ?)}");
            statement.setInt(1, employee.getId());
            statement.setString(2, employee.getName());
            statement.setString(3, employee.getSex());
            statement.setString(4, employee.getAddress());
            statement.setString(5, employee.getAccount());
            statement.setString(6, employee.getPass());
            statement.setInt(7, employee.getLevel());
            statement.setString(8, employee.getPosition());

            hasResultSet = statement.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return hasResultSet;
    }

    public boolean updateEmployee(EmployeeModel employee) throws SQLException {
        CallableStatement statement = null;
        boolean hasResultSet = false;

        try {
            statement = con.prepareCall("{CALL Proc_CapNhatNhanVien(?, ?, ?, ?, ?, ?, ?, ?)}");
            statement.setInt(1, employee.getId());
            statement.setString(2, employee.getName());
            statement.setString(3, employee.getSex());
            statement.setString(4, employee.getAddress());
            statement.setString(5, employee.getAccount());
            statement.setString(6, employee.getPass());
            statement.setInt(7, employee.getLevel());
            statement.setString(8, employee.getPosition());

            hasResultSet = statement.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return hasResultSet;
    }

    public boolean deleteEmployee(int id) {
        boolean hasResultSet = false;

        try (CallableStatement statement = con.prepareCall("{CALL Proc_XoaNhanVien(?)}")) {
            statement.setInt(1, id); // Sử dụng setInt để gán giá trị kiểu int
            hasResultSet = statement.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

        return hasResultSet;
    }
    public EmployeeModel getEmployeeByUsername(String username) {
	EmployeeModel employee = new EmployeeModel();
        PreparedStatement statement = null;
        ResultSet rs = null;

        try {
            statement = con.prepareStatement("select * from NhanVien where TenTaiKhoan=?");
            statement.setString(1, username);
            rs = statement.executeQuery();
            while (rs.next()) {
                employee.setId(rs.getInt(1));
                employee.setName(rs.getString(2));
                employee.setSex(rs.getString(3));
                employee.setAddress(rs.getString(4));
                employee.setAccount(rs.getString(5));
                employee.setPass(rs.getString(6));
                employee.setLevel(rs.getInt(7));
		employee.setPosition(rs.getString(8));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }
}
