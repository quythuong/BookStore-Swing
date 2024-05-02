/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom08.bookstore.DAO;

import com.nhom08.bookstore.Models.PublisherModel;
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
public class PublisherDAO {

    private Connection con = null;

    public PublisherDAO() {
        con = (new DBConnection()).GetDBConnection();
    }

    public List<PublisherModel> getAll() throws SQLException {
        List<PublisherModel> publisherList = new ArrayList<PublisherModel>();
        PreparedStatement statement = null;
        ResultSet rs = null;

        try {
            statement = con.prepareStatement("select * from NhaXuatBan");
            rs = statement.executeQuery();
            while (rs.next()) {
                PublisherModel publisher = new PublisherModel();

                publisher.setId(rs.getString(1));
                publisher.setName(rs.getString(2));
                publisher.setAddress(rs.getString(3));
                publisher.setContact(rs.getString(4));

                publisherList.add(publisher);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return publisherList;
    }

    public PublisherModel getOne(String id) throws SQLException {
        PublisherModel publisher = new PublisherModel();
        PreparedStatement statement = null;
        ResultSet rs = null;

        try {
            statement = con.prepareStatement("select * from NhaXuatBan where MaNXB = ?");
            statement.setString(1, id);
            rs = statement.executeQuery();
            while (rs.next()) {
                publisher.setId(rs.getString(1));
                publisher.setName(rs.getString(2));
                publisher.setAddress(rs.getString(3));
                publisher.setContact(rs.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return publisher;
    }

    public boolean delete(String id) throws SQLException {
        CallableStatement statement = null;
        ResultSet rs = null;
        boolean hasResultSet = false;

        try {
            statement = con.prepareCall("{ call Proc_XoaNhaXuatBan(?) }");
            statement.setString(1, id);

            hasResultSet = statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hasResultSet;
    }

    public boolean add(PublisherModel publisher) throws SQLException {
        CallableStatement statement = null;
        ResultSet rs = null;
        boolean hasResultSet = false;

        try {
            statement = con.prepareCall("{ call Proc_ThemNhaXuatBan(?,?,?,?) }");
            statement.setString(1, publisher.getId());
            statement.setString(2, publisher.getName());
            statement.setString(3, publisher.getAddress());
            statement.setString(4, publisher.getContact());

            hasResultSet = statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hasResultSet;
    }

    public boolean update(PublisherModel publisher) throws SQLException {
        CallableStatement statement = null;
        ResultSet rs = null;
        boolean hasResultSet = false;

        try {
            statement = con.prepareCall("{ call Proc_SuaNhaXuatBan(?,?,?,?) }");
            statement.setString(1, publisher.getId());
            statement.setString(2, publisher.getName());
            statement.setString(3, publisher.getAddress());
            statement.setString(4, publisher.getContact());

            hasResultSet = statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return hasResultSet;
    }

    public List<PublisherModel> getPublisherByAuthor(String aid) throws SQLException {
        List<PublisherModel> publisherList = new ArrayList<PublisherModel>();
        PreparedStatement statement = null;
        ResultSet rs = null;

        try {
            statement = con.prepareStatement("select nxb.MaNXB, nxb.TenNXB, nxb.DiaChiNXB, nxb.LienHe from NhaXuatBan nxb, TacGia tg where nxb.MaNXB = tg.MaNXB and tg.MaTG = ?");
            statement.setString(1, aid);
            rs = statement.executeQuery();
            while (rs.next()) {
                PublisherModel publisher = new PublisherModel();

                publisher.setId(rs.getString(1));
                publisher.setName(rs.getString(2));
                publisher.setAddress(rs.getString(3));
                publisher.setContact(rs.getString(4));

                publisherList.add(publisher);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return publisherList;
    }

}
