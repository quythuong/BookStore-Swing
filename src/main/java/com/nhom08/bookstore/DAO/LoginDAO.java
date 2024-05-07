/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom08.bookstore.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

/**
 *
 * @author Admin
 */
public class LoginDAO {
    private Connection connection = null;

    public LoginDAO(Connection connection) {
        this.connection = connection;
    }

    public int dangNhap(String tenTaiKhoan, String matKhau) throws SQLException {
        int cap = 0;
        CallableStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareCall("{ ? = call func_DangNhap(?, ?) }");
            statement.registerOutParameter(1, Types.INTEGER);
            statement.setString(2, tenTaiKhoan);
            statement.setString(3, matKhau);

            statement.execute();

            // Lấy giá trị trả về từ hàm SQL
            cap = statement.getInt(1);
        } finally {
            // Đóng ResultSet và CallableStatement
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
        }

        return cap;
    }
}
