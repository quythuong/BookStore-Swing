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

    //private Connection con = null;
    private Connection con = (new DBConnection()).GetDBConnection();

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
            while (rs.next()) {
                BookModel book = new BookModel();

                book.setId(rs.getString(1));
                book.setAuthorId(rs.getString(2));
                book.setPublisherId(rs.getString(3));
                book.setName(rs.getString(4));
                book.setQuantity(rs.getInt(5));
                book.setPrice(rs.getDouble(6));
                book.setType(rs.getString(7));
                book.setImage(rs.getString(8));
                bookList.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookList;
    }

    public List<BookModel> getInfoBook() {

        List<BookModel> books = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet rs = null;

        try {
            statement = con.prepareStatement("select MaSach,TenSach,SoLuongSach,Gia,Anh from Sach");
            rs = statement.executeQuery();
            while (rs.next()) {
                //byte[] anh = rs.getBytes("Anh");
                String maSach = rs.getString("MaSach");
                String tenSach = rs.getString("TenSach");
                int soLuong = rs.getInt("SoLuongSach");
                double gia = rs.getDouble("Gia");
                String img = rs.getString("Anh");
                BookModel book = new BookModel(maSach, tenSach, soLuong, gia, img);
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    public BookModel getOne(String id) {
        BookModel book = new BookModel();
        PreparedStatement statement = null;
        ResultSet rs = null;

        try {
            statement = con.prepareStatement("select * from Sach where MaSach=?");
            statement.setString(1, id);
            rs = statement.executeQuery();
            while (rs.next()) {
                book.setId(rs.getString(1));
                book.setAuthorId(rs.getString(2));
                book.setPublisherId(rs.getString(3));
                book.setName(rs.getString(4));
                book.setQuantity(rs.getInt(5));
                book.setPrice(rs.getDouble(6));
                book.setType(rs.getString(7));
                book.setImage(rs.getString(8));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }

    public boolean delete(String id) throws SQLException {
        CallableStatement statement = null;
        ResultSet rs = null;
        boolean hasResultSet = false;

        try {
            statement = con.prepareCall("{ call Proc_XoaSach(?) }");
            statement.setString(1, id);

            hasResultSet = statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hasResultSet;
    }

    public boolean save(BookModel book) throws SQLException {
        CallableStatement statement = null;
        ResultSet rs = null;
        boolean hasResultSet = false;

        try {
            statement = con.prepareCall("{ call Proc_ThemSach(?,?,?,?,?,?,?,?) }");
            statement.setString(1, book.getId());
            statement.setString(2, book.getAuthorId());
            statement.setString(3, book.getPublisherId());
            statement.setString(4, book.getName());
            statement.setInt(5, book.getQuantity());
            statement.setDouble(6, book.getPrice());
            statement.setString(7, book.getType());
            statement.setString(8, book.getImage());

            hasResultSet = statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hasResultSet;
    }

    public boolean update(BookModel book) throws SQLException {
        CallableStatement statement = null;
        ResultSet rs = null;
        boolean hasResultSet = false;

        try {
            statement = con.prepareCall("{ call Proc_SuaSach(?,?,?,?,?,?,?,?) }");
            statement.setString(1, book.getId());
            statement.setString(2, book.getAuthorId());
            statement.setString(3, book.getPublisherId());
            statement.setString(4, book.getName());
            statement.setInt(5, book.getQuantity());
            statement.setDouble(6, book.getPrice());
            statement.setString(7, book.getType());
            statement.setString(8, book.getImage());

            hasResultSet = statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return hasResultSet;
    }

    public String themMaHoaDon() {
        CallableStatement cstmt = null;
        String maHoaDon = null;

        try {
            cstmt = con.prepareCall("{call Proc_ThemMaHoaDon}");

            // Thực thi stored procedure
            cstmt.execute();

            // Lấy giá trị mã hóa đơn từ cstmt
            ResultSet rs = cstmt.getGeneratedKeys();
            if (rs.next()) {
                maHoaDon = rs.getString(1);
            }

            // In ra thông báo khi thành công
            System.out.println("Đã thêm mã hóa đơn thành công.");

        } catch (SQLException e) {
            // Xử lý nếu có lỗi xảy ra
            e.printStackTrace();
        } finally {
            // Đóng các tài nguyên
            try {
                if (cstmt != null) {
                    cstmt.close();
                }
            } catch (SQLException e) {
                // Xử lý nếu có lỗi xảy ra khi đóng tài nguyên
                e.printStackTrace();
            }
        }

        return maHoaDon;
    }

    public boolean deleteReceipt(String receiptId) {
        CallableStatement statement = null;
        boolean success = false;

        try {
            statement = con.prepareCall("{ call Proc_XoaHoaDon(?) }");
            statement.setString(1, receiptId);

            // Execute the stored procedure
            success = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the statement
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return success;
    }

    public int getQuantityById(String id) {
        int quantity = 0;
        PreparedStatement statement = null;
        ResultSet rs = null;

        try {
            String query = "SELECT SoLuongSach FROM Sach WHERE MaSach = ?";
            statement = con.prepareStatement(query);
            statement.setString(1, id);
            rs = statement.executeQuery();

            if (rs.next()) {
                quantity = rs.getInt("SoLuongSach");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return quantity;
    }

}
