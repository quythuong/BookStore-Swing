/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom08.bookstore.DAO;

import java.sql.Connection;

/**
 *
 * @author quythuong
 */
public class ReceiptDetailsDAO {
	private Connection con = null;
	
	public ReceiptDetailsDAO() {
		con = (new DBConnection()).GetDBConnection();
	}
}
