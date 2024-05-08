/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom08.bookstore.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author quythuong
 */
public  class DBConnection {
	// doi ten server "MSI\\SQLEXPRESS" cho phu hop voi may
	private String ConnectionString = "jdbc:sqlserver://DESKTOP-71H1I04;Database=QLNhaSach;IntegratedSecurity=true;encrypt=true;trustServerCertificate=true"; 
	Connection con = null;
	
	public Connection GetDBConnection() {
		try {
			con = DriverManager.getConnection(ConnectionString);
			System.out.println("Ket noi database thanh cong!");
			
		} catch(SQLException e) {
			System.out.println("Ket noi that bai!");
			e.printStackTrace();
		}
		return con;
	}	
        
     public static void main(String[] args) {
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:sqlserver://LAPTOP-0BT01DIR;databaseName=QLNhaSach;user=sa;password=123456789;encrypt=false");
            System.out.println("Ket noi database thanh cong!");

        }catch(SQLException e){
            System.out.println("Ket noi that bai!");
            e.printStackTrace();
        }
        // Sử dụng kết nối con ở đây (nếu cần)
    }

}
