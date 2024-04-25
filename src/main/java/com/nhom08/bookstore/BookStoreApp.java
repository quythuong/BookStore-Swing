/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.nhom08.bookstore;

import com.nhom08.bookstore.DAO.BookDAO;
import com.nhom08.bookstore.Models.BookModel;
import java.sql.SQLException;
import java.util.List;

/**
 * @author quythuong
 */
public class BookStoreApp {

    public static void main(String[] args) throws SQLException {
//        (new LoginFrame()).setVisible(true);
//	(new ManagerFrame()).setVisible(true);
//        (new StorageManagerFrame()).setVisible(true);
//        (new CashierFrame()).setVisible(true);
	    BookDAO bookdao = new BookDAO();
//	    List<BookModel> bookList = bookdao.getAll();
//	    bookList.forEach((e)-> {System.out.println(e.toString());});
	    
		   //System.out.println(bookdao.getOne("4"));
		   //bookdao.save(new BookModel("29", "TG_VT", "NXB_DT", "Sach rac", 12, 12.5, "Kinh dị"));
		   bookdao.delete("29");
    }
}
