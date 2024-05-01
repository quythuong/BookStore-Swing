/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom08.bookstore.DAO;

import com.nhom08.bookstore.Models.IReceiptDetailsModel;
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
public class IReceiptDetailsDAO {
	private Connection con = null;
	public IReceiptDetailsDAO() {
		con = (new DBConnection()).GetDBConnection();
	}
	
	public List<IReceiptDetailsModel> getAllByReceiptId(String iReceiptId) {
		List<IReceiptDetailsModel> iReceiptDetailsList = new ArrayList<>();
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			statement = con.prepareStatement("select * from ChiTietPhieuNhap where MaPhieuNhap=?");
			statement.setString(1, iReceiptId);
			rs = statement.executeQuery();
			while(rs.next()) {
				IReceiptDetailsModel iReceipt = new IReceiptDetailsModel();
				
				iReceipt.setIReceipId(rs.getString(1));
				iReceipt.setBookId(rs.getString(2));
				iReceipt.setQuantity(rs.getInt(3));
				
				iReceiptDetailsList.add(iReceipt);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return iReceiptDetailsList;
	}
}
