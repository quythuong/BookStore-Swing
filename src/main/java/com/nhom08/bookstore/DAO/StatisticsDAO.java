/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom08.bookstore.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class StatisticsDAO {

    private Connection connection;

    public StatisticsDAO(Connection connection) {
        this.connection = connection;
    }

    public float tinhDoanhThuNgay(int ngay, int thang, int nam) {
        float doanhThu = 0;
        String query = "SELECT COALESCE(SUM(TongHD), 0) AS DoanhThu FROM HoaDon WHERE DAY(NgayInHD) = ? AND MONTH(NgayInHD) = ? AND YEAR(NgayInHD) = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, ngay);
            statement.setInt(2, thang);
            statement.setInt(3, nam);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                doanhThu = resultSet.getFloat("DoanhThu");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return doanhThu;
    }

    public float tinhDoanhThuThang(int thang, int nam) {
        float doanhThu = 0;
        String query = "SELECT COALESCE(SUM(TongHD), 0) AS DoanhThu FROM HoaDon WHERE MONTH(NgayInHD) = ? AND YEAR(NgayInHD) = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, thang);
            statement.setInt(2, nam);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                doanhThu = resultSet.getFloat("DoanhThu");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return doanhThu;
    }

    public float tinhDoanhThuNam(int nam) {
        float doanhThu = 0;
        String query = "SELECT COALESCE(SUM(TongHD), 0) AS DoanhThu FROM HoaDon WHERE YEAR(NgayInHD) = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, nam);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                doanhThu = resultSet.getFloat("DoanhThu");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return doanhThu;
    }
}
