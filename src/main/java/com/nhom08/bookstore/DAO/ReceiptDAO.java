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

/**
 *
 * @author quythuong
 */
public class ReceiptDAO {
	private Connection con = null;
	
	public ReceiptDAO() {
		con = (new DBConnection()).GetDBConnection();
	}
	
	public List<ReceiptModel> getAll() {
		List<ReceiptModel> receiptList = new ArrayList<ReceiptModel>();
		PreparedStatement statement = null;
		ResultSet rs = null;
		
		try {
			statement = con.prepareStatement("select * from HoaDon");
			rs = statement.executeQuery();
			while(rs.next()) {
				ReceiptModel receipt = new ReceiptModel();
				
				receipt.setId(rs.getString(1));
				receipt.setTotal(rs.getDouble(2));
				receipt.setDate(rs.getDate(3));
				
				receiptList.add(receipt);
			}
		} catch(SQLException e) {
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
			while(rs.next()) {
				receipt.setId(rs.getString(1));
				receipt.setTotal(rs.getDouble(2));
				receipt.setDate(rs.getDate(3));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return receipt;
	}
	
}
