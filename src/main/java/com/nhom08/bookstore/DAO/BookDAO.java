/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom08.bookstore.DAO;

import com.nhom08.bookstore.Models.BookModel;
import java.sql.CallableStatement;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author quythuong
 */
public class BookDAO {
	private Connection con = null;
	
	public BookDAO() {
		con = (new DBConnection()).GetDBConnection();
	}
	
	public List<BookModel> getAll() throws SQLException {
		List<BookModel> bookList = new ArrayList<BookModel>();
		PreparedStatement statement = null;
		ResultSet rs = null;
		
		try {
			statement = con.prepareStatement("select * from Sach");
			rs = statement.executeQuery();
			while(rs.next()) {
				BookModel book = new BookModel();
				
				book.setId(rs.getString(1));
				book.setAuthorId(rs.getString(2));
				book.setPublisherId(rs.getString(3));
				book.setName(rs.getString(4));
				book.setQuantity(rs.getInt(5));
				book.setPrice(rs.getDouble(6));
				book.setType(rs.getString(7));
				
				bookList.add(book);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return bookList;
	}
	public BookModel getOne(String id) throws SQLException {
		BookModel book = new BookModel();
		PreparedStatement statement = null;
		ResultSet rs = null;
		
		try {
			statement = con.prepareStatement("select * from Sach where MaSach=?");
			statement.setString(1, id);
			rs = statement.executeQuery();
			while(rs.next()) {
				book.setId(rs.getString(1));
				book.setAuthorId(rs.getString(2));
				book.setPublisherId(rs.getString(3));
				book.setName(rs.getString(4));
				book.setQuantity(rs.getInt(5));
				book.setPrice(rs.getDouble(6));
				book.setType(rs.getString(7));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return book;
	}
	public boolean delete(String id) throws SQLException{
		CallableStatement statement = null;
		ResultSet rs = null;
		boolean hasResultSet = false;
		
		try {
			statement = con.prepareCall("{ call Proc_XoaSach(?) }");
			statement.setString(1, id);
			
			hasResultSet = statement.execute();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return hasResultSet;
	}
	public boolean save(BookModel book) throws SQLException{
		CallableStatement statement = null;
		ResultSet rs = null;
		boolean hasResultSet = false;
		
		try {
			statement = con.prepareCall("{ call Proc_ThemSach(?,?,?,?,?,?,?) }");
			statement.setString(1, book.getId());
			statement.setString(2, book.getAuthorId());
			statement.setString(3, book.getPublisherId());
			statement.setString(4, book.getName());
			statement.setInt(5, book.getQuantity());
			statement.setDouble(6, book.getPrice());
			statement.setString(7, book.getType());
			//statement.setString(8, book.get());
			
			hasResultSet = statement.execute();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return hasResultSet;
	}
	public boolean update(BookModel book) throws SQLException {
		CallableStatement statement = null;
		ResultSet rs = null;
		boolean hasResultSet = false;
		
		try {
			statement = con.prepareCall("{ call Proc_SuaSach(?,?,?,?,?,?,?) }");
			statement.setString(1, book.getId());
			statement.setString(2, book.getAuthorId());
			statement.setString(3, book.getPublisherId());
			statement.setString(4, book.getName());
			statement.setInt(5, book.getQuantity());
			statement.setDouble(6, book.getPrice());
			statement.setString(7, book.getType());
			//statement.setString(8, book.get());
			
			hasResultSet = statement.execute();

		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return hasResultSet;
	}
}
