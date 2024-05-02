/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.nhom08.bookstore.GUI.FunctionalPanels;

import com.nhom08.bookstore.DAO.AuthorDAO;
import com.nhom08.bookstore.DAO.BookDAO;
import com.nhom08.bookstore.DAO.PublisherDAO;
import com.nhom08.bookstore.Models.AuthorModel;
import com.nhom08.bookstore.Models.BookModel;
import com.nhom08.bookstore.Models.PublisherModel;
import com.nhom08.bookstore.Utils.changeIconSize;
import com.nhom08.bookstore.Utils.showMessageDialogs;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author quythuong
 */
public class panel_books extends javax.swing.JPanel {

    BookDAO bookDAO;
    BookModel bookModel;
    showMessageDialogs message;
    changeIconSize chIconSize;
    boolean choice;
    int status, flagauthor = 0, flagpublisher = 0;

    /**
     * Creates new form panel_books
     */
    public panel_books() {
        initComponents();
        
        resizeicon();
        
        try {
            disabletext();
            updateTable();
        } catch (SQLException ex) {
            Logger.getLogger(panel_books.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        panelCustom1 = new Custom.PanelCustom();
        btn_add = new Custom.ButtonCustom();
        btn_edit = new Custom.ButtonCustom();
        btn_delete = new Custom.ButtonCustom();
        panelCustom2 = new Custom.PanelCustom();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_book = new javax.swing.JTable();
        panelCustom3 = new Custom.PanelCustom();
        jPanel1 = new javax.swing.JPanel();
        tf_bookid = new com.nhom08.bookstore.GUI.TextFieldCustom();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        cb_authorid = new javax.swing.JComboBox<>();
        tf_authorid = new com.nhom08.bookstore.GUI.TextFieldCustom();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        cb_publisherid = new javax.swing.JComboBox<>();
        tf_publisherid = new com.nhom08.bookstore.GUI.TextFieldCustom();
        jLabel6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        tf_bookname = new com.nhom08.bookstore.GUI.TextFieldCustom();
        jLabel7 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        tf_quantity = new com.nhom08.bookstore.GUI.TextFieldCustom();
        jLabel8 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        tf_price = new com.nhom08.bookstore.GUI.TextFieldCustom();
        jLabel9 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        tf_genre = new com.nhom08.bookstore.GUI.TextFieldCustom();
        jLabel10 = new javax.swing.JLabel();
        btn_cancel = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        tf_image = new com.nhom08.bookstore.GUI.TextFieldCustom();
        jLabel12 = new javax.swing.JLabel();
        btn_save = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 254, 251));
        setPreferredSize(new java.awt.Dimension(1056, 740));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Lexend", 0, 30)); // NOI18N
        jLabel2.setText("Books Management");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(382, 25, -1, -1));

        panelCustom1.setPreferredSize(new java.awt.Dimension(695, 68));
        panelCustom1.setRoundBottomLeft(10);
        panelCustom1.setRoundBottomRigt(10);
        panelCustom1.setRoundTopLeft(10);
        panelCustom1.setRoundTopRigt(10);
        panelCustom1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_add.setBackground(new java.awt.Color(217, 217, 217));
        btn_add.setBorder(null);
        btn_add.setText("Add");
        btn_add.setBorderColor(new java.awt.Color(217, 217, 217));
        btn_add.setFont(new java.awt.Font("Lexend", 0, 24)); // NOI18N
        btn_add.setPreferredSize(new java.awt.Dimension(160, 42));
        btn_add.setRadius(20);
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });
        panelCustom1.add(btn_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 14, -1, -1));

        btn_edit.setBackground(new java.awt.Color(217, 217, 217));
        btn_edit.setBorder(null);
        btn_edit.setText("Edit");
        btn_edit.setBorderColor(new java.awt.Color(217, 217, 217));
        btn_edit.setFont(new java.awt.Font("Lexend", 0, 24)); // NOI18N
        btn_edit.setPreferredSize(new java.awt.Dimension(160, 42));
        btn_edit.setRadius(20);
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });
        panelCustom1.add(btn_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(266, 14, -1, -1));

        btn_delete.setBackground(new java.awt.Color(217, 217, 217));
        btn_delete.setBorder(null);
        btn_delete.setText("Delete");
        btn_delete.setBorderColor(new java.awt.Color(217, 217, 217));
        btn_delete.setFont(new java.awt.Font("Lexend", 0, 24)); // NOI18N
        btn_delete.setPreferredSize(new java.awt.Dimension(160, 42));
        btn_delete.setRadius(20);
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });
        panelCustom1.add(btn_delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(519, 14, -1, -1));

        add(panelCustom1, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 103, -1, -1));

        panelCustom2.setPreferredSize(new java.awt.Dimension(695, 515));
        panelCustom2.setRoundBottomLeft(10);
        panelCustom2.setRoundBottomRigt(10);
        panelCustom2.setRoundTopLeft(10);
        panelCustom2.setRoundTopRigt(10);

        tb_book.setAutoCreateRowSorter(true);
        tb_book.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Sách", "Mã TG", "Mã NXB", "Tên Sách", "SL Sách", "Giá", "Thể Loại", "Ảnh"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_book.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_bookMouseClicked(evt);
            }
        });
        tb_book.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tb_bookPropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(tb_book);

        javax.swing.GroupLayout panelCustom2Layout = new javax.swing.GroupLayout(panelCustom2);
        panelCustom2.setLayout(panelCustom2Layout);
        panelCustom2Layout.setHorizontalGroup(
            panelCustom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 695, Short.MAX_VALUE)
        );
        panelCustom2Layout.setVerticalGroup(
            panelCustom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
        );

        add(panelCustom2, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 200, -1, -1));

        panelCustom3.setPreferredSize(new java.awt.Dimension(248, 612));
        panelCustom3.setRoundBottomLeft(10);
        panelCustom3.setRoundBottomRigt(10);
        panelCustom3.setRoundTopLeft(10);
        panelCustom3.setRoundTopRigt(10);
        panelCustom3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tf_bookid.setPreferredSize(new java.awt.Dimension(210, 33));
        tf_bookid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_bookidActionPerformed(evt);
            }
        });
        jPanel1.add(tf_bookid, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 210, 40));

        jLabel4.setFont(new java.awt.Font("Lexend", 0, 15)); // NOI18N
        jLabel4.setText("Book ID");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 80, -1));

        panelCustom3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 21, -1, -1));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cb_authorid.setPreferredSize(new java.awt.Dimension(210, 33));
        jPanel3.add(cb_authorid, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, -1, -1));

        tf_authorid.setPreferredSize(new java.awt.Dimension(210, 33));
        tf_authorid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_authoridActionPerformed(evt);
            }
        });
        jPanel3.add(tf_authorid, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 210, 40));

        jLabel5.setFont(new java.awt.Font("Lexend", 0, 15)); // NOI18N
        jLabel5.setText("Author ID");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        panelCustom3.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 159, -1, -1));

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cb_publisherid.setPreferredSize(new java.awt.Dimension(210, 33));
        jPanel4.add(cb_publisherid, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, -1, -1));

        tf_publisherid.setPreferredSize(new java.awt.Dimension(210, 33));
        tf_publisherid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_publisheridActionPerformed(evt);
            }
        });
        jPanel4.add(tf_publisherid, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 210, 40));

        jLabel6.setFont(new java.awt.Font("Lexend", 0, 15)); // NOI18N
        jLabel6.setText("Publisher ID");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        panelCustom3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 90, -1, -1));

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tf_bookname.setPreferredSize(new java.awt.Dimension(210, 33));
        tf_bookname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_booknameActionPerformed(evt);
            }
        });
        jPanel5.add(tf_bookname, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 210, 40));

        jLabel7.setFont(new java.awt.Font("Lexend", 0, 15)); // NOI18N
        jLabel7.setText("Book Name");
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        panelCustom3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 228, -1, -1));

        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tf_quantity.setPreferredSize(new java.awt.Dimension(210, 33));
        tf_quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_quantityActionPerformed(evt);
            }
        });
        jPanel6.add(tf_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 210, 40));

        jLabel8.setFont(new java.awt.Font("Lexend", 0, 15)); // NOI18N
        jLabel8.setText("Quantity");
        jPanel6.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        panelCustom3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 297, -1, -1));

        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tf_price.setPreferredSize(new java.awt.Dimension(210, 33));
        tf_price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_priceActionPerformed(evt);
            }
        });
        jPanel7.add(tf_price, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 210, 40));

        jLabel9.setFont(new java.awt.Font("Lexend", 0, 15)); // NOI18N
        jLabel9.setText("Price");
        jPanel7.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        panelCustom3.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 366, -1, -1));

        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tf_genre.setPreferredSize(new java.awt.Dimension(210, 33));
        tf_genre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_genreActionPerformed(evt);
            }
        });
        jPanel8.add(tf_genre, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 210, 40));

        jLabel10.setFont(new java.awt.Font("Lexend", 0, 15)); // NOI18N
        jLabel10.setText("Genre");
        jPanel8.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        panelCustom3.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 435, -1, -1));

        btn_cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cancle.png"))); // NOI18N
        btn_cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_cancelMouseClicked(evt);
            }
        });
        panelCustom3.add(btn_cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 560, 40, 38));

        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tf_image.setPreferredSize(new java.awt.Dimension(210, 33));
        tf_image.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_imageActionPerformed(evt);
            }
        });
        jPanel9.add(tf_image, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 210, 40));

        jLabel12.setFont(new java.awt.Font("Lexend", 0, 15)); // NOI18N
        jLabel12.setText("Image");
        jPanel9.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        panelCustom3.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, -1, -1));

        btn_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/save.png"))); // NOI18N
        btn_save.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_saveMouseClicked(evt);
            }
        });
        panelCustom3.add(btn_save, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 560, 40, 38));

        add(panelCustom3, new org.netbeans.lib.awtextra.AbsoluteConstraints(766, 103, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        try {
            addBook();
        } catch (SQLException ex) {
            Logger.getLogger(panel_books.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        try {
            editBook();
        } catch (SQLException ex) {
            Logger.getLogger(panel_books.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        try {
            deleteBook();
        } catch (SQLException ex) {
            Logger.getLogger(panel_books.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void tf_bookidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_bookidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_bookidActionPerformed

    private void tf_authoridActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_authoridActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_authoridActionPerformed

    private void tf_publisheridActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_publisheridActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_publisheridActionPerformed

    private void tf_booknameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_booknameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_booknameActionPerformed

    private void tf_quantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_quantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_quantityActionPerformed

    private void tf_priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_priceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_priceActionPerformed

    private void tf_genreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_genreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_genreActionPerformed

    private void tf_imageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_imageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_imageActionPerformed

    private void tb_bookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_bookMouseClicked
        clickRowTable();
    }//GEN-LAST:event_tb_bookMouseClicked

    private void btn_cancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancelMouseClicked
        status = -1;
//        try {
//            loadAuthorComboBox();
//            loadPublisherComboBox();
//        } catch (SQLException ex) {
//            Logger.getLogger(panel_books.class.getName()).log(Level.SEVERE, null, ex);
//        }
        resetText();
        disabletext();
    }//GEN-LAST:event_btn_cancelMouseClicked

    private void btn_saveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_saveMouseClicked
        save();
    }//GEN-LAST:event_btn_saveMouseClicked

    private void tb_bookPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tb_bookPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_tb_bookPropertyChange


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Custom.ButtonCustom btn_add;
    private javax.swing.JLabel btn_cancel;
    private Custom.ButtonCustom btn_delete;
    private Custom.ButtonCustom btn_edit;
    private javax.swing.JLabel btn_save;
    private javax.swing.JComboBox<String> cb_authorid;
    private javax.swing.JComboBox<String> cb_publisherid;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private Custom.PanelCustom panelCustom1;
    private Custom.PanelCustom panelCustom2;
    private Custom.PanelCustom panelCustom3;
    private javax.swing.JTable tb_book;
    private com.nhom08.bookstore.GUI.TextFieldCustom tf_authorid;
    private com.nhom08.bookstore.GUI.TextFieldCustom tf_bookid;
    private com.nhom08.bookstore.GUI.TextFieldCustom tf_bookname;
    private com.nhom08.bookstore.GUI.TextFieldCustom tf_genre;
    private com.nhom08.bookstore.GUI.TextFieldCustom tf_image;
    private com.nhom08.bookstore.GUI.TextFieldCustom tf_price;
    private com.nhom08.bookstore.GUI.TextFieldCustom tf_publisherid;
    private com.nhom08.bookstore.GUI.TextFieldCustom tf_quantity;
    // End of variables declaration//GEN-END:variables

    private void updateTable() throws SQLException {
        DefaultTableModel model = (DefaultTableModel) tb_book.getModel();
        model.setRowCount(0);
        bookDAO = new BookDAO();
        List<BookModel> bookList = bookDAO.getAll();
        for (BookModel book : bookList) {
            String id = book.getId();
            String authorid = book.getAuthorId();
            String publisherid = book.getPublisherId();
            String name = book.getName();
            int quantity = book.getQuantity();
            double price = book.getPrice();
            String genre = book.getType();
            //String img = book.getImage();

            model.addRow(new Object[]{id, authorid, publisherid, name, quantity, price, genre});
        }
        loadPublisherComboBox();
        loadAuthorComboBox();
        resetText();
    }

    private void addBook() throws SQLException {
        status = 1;
        enableText();
        loadAuthorComboBoxByPublisher();
//        loadPublisherComboBoxByAuthor();
        resetText();
    }

    private void editBook() throws SQLException {
        status = 2;
        enableText();
        loadAuthorComboBoxByPublisher();
//        loadPublisherComboBoxByAuthor();
    }

    private void deleteBook() throws SQLException {
        choice = new showMessageDialogs().deleteMessage("author");
        if (choice == true) {
            String id = tf_bookid.getText().toString();

            bookDAO.delete(id);
            updateTable();
        }
    }

    private void clickRowTable() {
        int row = tb_book.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) tb_book.getModel();

        tf_bookid.setText(model.getValueAt(row, 0).toString());
//        tf_authorid.setText(model.getValueAt(row, 1).toString());
        cb_authorid.setSelectedItem(model.getValueAt(row, 1).toString());
//        tf_publisherid.setText(model.getValueAt(row, 2).toString());
        cb_publisherid.setSelectedItem(model.getValueAt(row, 2).toString());
        tf_bookname.setText(model.getValueAt(row, 3).toString());
        tf_quantity.setText(model.getValueAt(row, 4).toString());
        tf_price.setText(model.getValueAt(row, 5).toString());
        tf_genre.setText(model.getValueAt(row, 6).toString());
        //tf_image.setText(model.getValueAt(row, 7).toString());
    }

    private void loadPublisherComboBox() throws SQLException {
        // Load Publisher id combobox
        PublisherDAO publisherDAO = new PublisherDAO();
        List<PublisherModel> publisherList = publisherDAO.getAll();

        for (PublisherModel publisher : publisherList) {
            cb_publisherid.addItem(publisher.getId());
        }

        // 
    }

    private void loadAuthorComboBox() throws SQLException {
        // Load Publisher id combobox
        AuthorDAO authorDAO = new AuthorDAO();
        List<AuthorModel> authorList = authorDAO.getAll();

        for (AuthorModel author : authorList) {
            cb_authorid.addItem(author.getId());
        }
    }

    private void loadAuthorComboBoxByPublisher() throws SQLException {
        if (status == 1 || status == 2) {
            cb_publisherid.addItemListener(new ItemListener() {
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {

                        cb_authorid.removeAllItems();
                        String pid = cb_publisherid.getSelectedItem().toString();
                        AuthorDAO authorDAO = new AuthorDAO();
                        List<AuthorModel> authorList;
                        try {
                            authorList = authorDAO.getAuthorByPublisher(pid);
                            for (AuthorModel author : authorList) {
                                cb_authorid.addItem(author.getId());
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(panel_books.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            });
        }
    }

    private void loadPublisherComboBoxByAuthor() {
        if (status == 1 || status == 2) {
            cb_authorid.addItemListener(new ItemListener() {
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        cb_publisherid.removeAllItems();
                        String aid = cb_authorid.getSelectedItem().toString();
                        PublisherDAO publisherDAO = new PublisherDAO();
                        List<PublisherModel> publisherList;
                        try {
                            publisherList = publisherDAO.getPublisherByAuthor(aid);
                            for (PublisherModel publisher : publisherList) {
                                cb_publisherid.addItem(publisher.getId());
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(panel_books.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            });
        }
    }

    private void save() {
        try {
            // add
            if (status == 1) {
                choice = new showMessageDialogs().saveMessage("author");
                if (choice == true) {
                    bookDAO = new BookDAO();
                    String id = tf_bookid.getText().toString();
                    String authorid = cb_authorid.getSelectedItem().toString();
                    String publisherid = cb_publisherid.getSelectedItem().toString();
                    String name = tf_bookname.getText().toString();
                    int quantity = Integer.parseInt(tf_quantity.getText().toString());
                    double price = Double.parseDouble(tf_price.getText().toString());
                    String genre = tf_genre.getText().toString();
                    //String img = book.getImage();

                    bookModel = new BookModel(id, authorid, publisherid, name, quantity, price, genre);
                    bookDAO.save(bookModel);
                    updateTable();
                }
            } // edit
            else if (status == 2) {
                choice = new showMessageDialogs().editMessage();
                if (choice == true) {
                    bookDAO = new BookDAO();

                    String id = tf_bookid.getText().toString();
                    String authorid = cb_authorid.getSelectedItem().toString();
                    String publisherid = cb_publisherid.getSelectedItem().toString();
                    String name = tf_bookname.getText().toString();
                    int quantity = Integer.parseInt(tf_quantity.getText().toString());
                    double price = Double.parseDouble(tf_price.getText().toString());
                    String genre = tf_genre.getText().toString();
                    //String img = book.getImage();

                    bookModel = new BookModel(id, authorid, publisherid, name, quantity, price, genre);
                    bookDAO.update(bookModel);
                    updateTable();
                }
            } else {
                disabletext();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            status = -1;
            disabletext();
            resetText();
        }

    }

    private void disabletext() {
        tf_bookid.enable(false);
        tf_publisherid.enable(false);
        tf_bookname.enable(false);
        tf_authorid.enable(false);
        tf_genre.enable(false);
        tf_quantity.enable(false);
        tf_price.enable(false);
        tf_image.enable(false);
        cb_authorid.enable(false);
        cb_publisherid.enable(false);
    }

    private void enableText() {
        tf_bookid.enable(true);
        tf_publisherid.enable(true);
        tf_bookname.enable(true);
        tf_authorid.enable(true);
        tf_genre.enable(true);
        tf_quantity.enable(true);
        tf_price.enable(true);
        tf_image.enable(true);
        cb_authorid.enable(true);
        cb_publisherid.enable(true);
    }

    private void resetText() {
        tf_bookid.setText("");
        tf_publisherid.setText("");
        tf_bookname.setText("");
        tf_authorid.setText("");
        tf_genre.setText("");
        tf_quantity.setText("");
        tf_price.setText("");
        tf_image.setText("");
        cb_authorid.setSelectedItem(null);
        cb_publisherid.setSelectedItem(null);
    }

    private void resizeicon() {
//        chIconSize = new changeIconSize();
        (new changeIconSize()).setIconWithSize(btn_save, "/icons/save.png", 25, 25);
        (new changeIconSize()).setIconWithSize(btn_cancel, "/icons/cancle.png", 25, 25);
//        chIconSize.setIconWithSize(btn_save, "/icons/save.png", 25, 25);
//        chIconSize.setIconWithSize(btn_cancel, "/icons/cancel.png", 25, 25);
    }

}
