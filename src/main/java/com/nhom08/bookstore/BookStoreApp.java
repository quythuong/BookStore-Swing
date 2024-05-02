/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.nhom08.bookstore;

import com.nhom08.bookstore.DAO.ReceiptDAO;
import com.nhom08.bookstore.Models.ReceiptModel;
import java.sql.SQLException;
import java.util.List;

/**
 * @author quythuong
 */
public class BookStoreApp {

    public static void main(String[] args) throws SQLException {
//        (new LoginFrame()).setVisible(true);
        (new ManagerFrame()).setVisible(true);
//        (new StorageManagerFrame()).setVisible(true);
//        (new CashierFrame()).setVisible(true);
//	    ReceiptDAO receiptDAO = new ReceiptDAO();
//	    List<ReceiptModel> receiptModels = receiptDAO.getAll();
//	    receiptModels.forEach((e)-> {System.out.println(e.toString());});
    }
}
