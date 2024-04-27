/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom08.bookstore.DAO;

import com.nhom08.bookstore.Models.AuthorModel;
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
public class AuthorDAO {

    private Connection con = null;

    public AuthorDAO() {
        con = (new DBConnection()).GetDBConnection();
    }

    public List<AuthorModel> getAll() throws SQLException {
        List<AuthorModel> authorList = new ArrayList<AuthorModel>();
        PreparedStatement statement = null;
        ResultSet rs = null;

        try {
            statement = con.prepareStatement("select * from TacGia");
            rs = statement.executeQuery();
            while (rs.next()) {
                AuthorModel author = new AuthorModel();

                author.setId(rs.getString(1));
                author.setPublisherId(rs.getString(2));
                author.setName(rs.getString(3));
                author.setContact(rs.getString(4));

                authorList.add(author);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return authorList;
    }

    public AuthorModel getOne(String id) throws SQLException {
        AuthorModel author = new AuthorModel();
        PreparedStatement statement = null;
        ResultSet rs = null;

        try {
            statement = con.prepareStatement("select * from TacGia where MaTG = ?");
            statement.setString(1, id);
            rs = statement.executeQuery();
            while (rs.next()) {
                author.setId(rs.getString(1));
                author.setPublisherId(rs.getString(2));
                author.setName(rs.getString(3));
                author.setContact(rs.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return author;
    }

    public boolean delete(String id) throws SQLException {
        CallableStatement statement = null;
        ResultSet rs = null;
        boolean hasResultSet = false;

        try {
            statement = con.prepareCall("{ call XoaTacGia(?) }");
            statement.setString(1, id);

            hasResultSet = statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hasResultSet;
    }

    public boolean add(AuthorModel author) throws SQLException {
        CallableStatement statement = null;
        ResultSet rs = null;
        boolean hasResultSet = false;

        try {
            statement = con.prepareCall("{ call ThemTacGia(?,?,?,?) }");
            statement.setString(1, author.getId());
            statement.setString(2, author.getPublisherId());
            statement.setString(3, author.getName());
            statement.setString(4, author.getContact());

            hasResultSet = statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hasResultSet;
    }

    public boolean update(AuthorModel author) throws SQLException {
        CallableStatement statement = null;
        ResultSet rs = null;
        boolean hasResultSet = false;

        try {
            statement = con.prepareCall("{ call CapNhatTacGia(?,?,?,?) }");
            statement.setString(1, author.getId());
            statement.setString(2, author.getPublisherId());
            statement.setString(3, author.getName());
            statement.setString(4, author.getContact());

            hasResultSet = statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return hasResultSet;
    }
}
