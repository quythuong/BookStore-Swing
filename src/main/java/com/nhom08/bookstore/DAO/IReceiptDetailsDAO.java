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
	public boolean save(IReceiptDetailsModel iReceiptDetailsModel) throws SQLException {
		PreparedStatement st = null;
		
		try {
        
            String sql = "insert into ChiTietPhieuNhap(MaPhieuNhap, MaSach, SoLuongNhap) values(?, ?, ?);";	
		st = con.prepareStatement(sql);
		st.setString(1, iReceiptDetailsModel.getIReceipId());
		st.setString(2, iReceiptDetailsModel.getBookId());
		st.setInt(3, iReceiptDetailsModel.getQuantity());
            } catch(SQLException e) {
		    e.printStackTrace();
	    }
		return st.execute();
	}
	public boolean update(IReceiptDetailsModel iReceiptDetailsModel) throws SQLException {
		PreparedStatement st = null;
		
		try {
        
            String sql = "update ChiTietPhieuNhap set SoLuongNhap=? where MaPhieuNhap=? and MaSach=?;";	
		st = con.prepareStatement(sql);
		st.setString(3, iReceiptDetailsModel.getBookId());
		st.setInt(1, iReceiptDetailsModel.getQuantity());
		st.setString(2, iReceiptDetailsModel.getIReceipId());	
            } catch(SQLException e) {
		    e.printStackTrace();
	    }
		return st.execute();
	}
	public boolean delete(IReceiptDetailsModel iReceiptDetailsModel) throws SQLException {
		PreparedStatement st = null;
		
		try {
        
            String sql = "delete from ChiTietPhieuNhap where MaPhieuNhap=? and MaSach=?;";	
		st = con.prepareStatement(sql);
		st.setString(1, iReceiptDetailsModel.getIReceipId());
		st.setString(2, iReceiptDetailsModel.getBookId());
            } catch(SQLException e) {
		    e.printStackTrace();
	    }
		return st.execute();
	}
}
