/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.nhom08.bookstore.GUI.FunctionalPanels;

import com.nhom08.bookstore.DAO.PublisherDAO;
import com.nhom08.bookstore.Models.PublisherModel;
import com.nhom08.bookstore.Utils.showMessageDialogs;
import java.awt.Color;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author quythuong
 */
public class panel_publishers extends javax.swing.JPanel {

    PublisherDAO publisherDAO;
    PublisherModel publisherModel;
    showMessageDialogs message;
    boolean choice;
    int status;

    /**
     * Creates new form panel_publishers
     */
    public panel_publishers() {
        initComponents();

        try {
            disabletext();
            resetText();
            updateTable();
        } catch (SQLException ex) {
            Logger.getLogger(panel_authors.class.getName()).log(Level.SEVERE, null, ex);
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
        tb_publisher = new javax.swing.JTable();
        panelCustom3 = new Custom.PanelCustom();
        jPanel1 = new javax.swing.JPanel();
        tf_publisherid = new com.nhom08.bookstore.GUI.TextFieldCustom();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        tf_publishername = new com.nhom08.bookstore.GUI.TextFieldCustom();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        tf_address = new com.nhom08.bookstore.GUI.TextFieldCustom();
        jLabel6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        tf_contact = new com.nhom08.bookstore.GUI.TextFieldCustom();
        jLabel7 = new javax.swing.JLabel();
        btn_cancle = new javax.swing.JLabel();
        btn_save = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 254, 251));
        setPreferredSize(new java.awt.Dimension(1056, 740));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Lexend", 0, 30)); // NOI18N
        jLabel2.setText("Publishers Management");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 25, -1, -1));

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

        tb_publisher.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Publisher ID", "Publisher Name", "Address", "Contact"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_publisher.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_publisherMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_publisher);

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

        tf_publisherid.setPreferredSize(new java.awt.Dimension(210, 33));
        tf_publisherid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_publisheridActionPerformed(evt);
            }
        });
        jPanel1.add(tf_publisherid, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 210, 40));

        jLabel4.setFont(new java.awt.Font("Lexend", 0, 15)); // NOI18N
        jLabel4.setText("Publisher ID");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 110, -1));

        panelCustom3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 21, -1, -1));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tf_publishername.setPreferredSize(new java.awt.Dimension(210, 33));
        tf_publishername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_publishernameActionPerformed(evt);
            }
        });
        jPanel3.add(tf_publishername, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 210, 40));

        jLabel5.setFont(new java.awt.Font("Lexend", 0, 15)); // NOI18N
        jLabel5.setText("Publisher Name");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 130, -1));

        panelCustom3.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 90, -1, -1));

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tf_address.setPreferredSize(new java.awt.Dimension(210, 33));
        tf_address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_addressActionPerformed(evt);
            }
        });
        jPanel4.add(tf_address, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 210, 40));

        jLabel6.setFont(new java.awt.Font("Lexend", 0, 15)); // NOI18N
        jLabel6.setText("Address");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 120, -1));

        panelCustom3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 159, -1, -1));

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tf_contact.setPreferredSize(new java.awt.Dimension(210, 33));
        tf_contact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_contactActionPerformed(evt);
            }
        });
        jPanel5.add(tf_contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 210, 40));

        jLabel7.setFont(new java.awt.Font("Lexend", 0, 15)); // NOI18N
        jLabel7.setText("Contact");
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        panelCustom3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 228, -1, -1));

        btn_cancle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cancle.png"))); // NOI18N
        btn_cancle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_cancleMouseClicked(evt);
            }
        });
        panelCustom3.add(btn_cancle, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 556, 40, 38));

        btn_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/save.png"))); // NOI18N
        btn_save.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_saveMouseClicked(evt);
            }
        });
        panelCustom3.add(btn_save, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 556, 40, 38));

        add(panelCustom3, new org.netbeans.lib.awtextra.AbsoluteConstraints(766, 103, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        try {
            addPublisher();
        } catch (SQLException ex) {
            Logger.getLogger(panel_authors.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        try {
            editPublisher();
        } catch (SQLException ex) {
            Logger.getLogger(panel_authors.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        try {
            deletePublisher();
        } catch (SQLException ex) {
            Logger.getLogger(panel_authors.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void tb_publisherMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_publisherMouseClicked
        clickRowTable();
    }//GEN-LAST:event_tb_publisherMouseClicked

    private void tf_publisheridActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_publisheridActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_publisheridActionPerformed

    private void tf_publishernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_publishernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_publishernameActionPerformed

    private void tf_addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_addressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_addressActionPerformed

    private void tf_contactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_contactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_contactActionPerformed

    private void btn_cancleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancleMouseClicked
        status = -1;
        resetText();
        disabletext();
    }//GEN-LAST:event_btn_cancleMouseClicked

    private void btn_saveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_saveMouseClicked
        try {
            save();
        } catch (SQLException ex) {
            Logger.getLogger(panel_authors.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_saveMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Custom.ButtonCustom btn_add;
    private javax.swing.JLabel btn_cancle;
    private Custom.ButtonCustom btn_delete;
    private Custom.ButtonCustom btn_edit;
    private javax.swing.JLabel btn_save;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private Custom.PanelCustom panelCustom1;
    private Custom.PanelCustom panelCustom2;
    private Custom.PanelCustom panelCustom3;
    private javax.swing.JTable tb_publisher;
    private com.nhom08.bookstore.GUI.TextFieldCustom tf_address;
    private com.nhom08.bookstore.GUI.TextFieldCustom tf_contact;
    private com.nhom08.bookstore.GUI.TextFieldCustom tf_publisherid;
    private com.nhom08.bookstore.GUI.TextFieldCustom tf_publishername;
    // End of variables declaration//GEN-END:variables

    private void addPublisher() throws SQLException {
        status = 1;
        enableText();
        resetText();
    }

    private void editPublisher() throws SQLException {
        status = 2;
        enableText();
        tf_publisherid.setBackground(new Color(204, 204, 204));
        tf_publisherid.setEditable(false);
    }

    private void deletePublisher() throws SQLException {
        choice = new showMessageDialogs().deleteMessage("author");
        if (choice == true) {
            String id = tf_publisherid.getText().toString();

            publisherDAO.delete(id);
            updateTable();
        }
        enableText();
        resetText();
    }

    private void clickRowTable() {
        int row = tb_publisher.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) tb_publisher.getModel();

        tf_publisherid.setText(model.getValueAt(row, 0).toString());
        tf_publishername.setText(model.getValueAt(row, 1).toString());
        tf_address.setText(model.getValueAt(row, 2).toString());
        tf_contact.setText(model.getValueAt(row, 3).toString());
    }

    private void save() throws SQLException {
        try {
            if (tf_contact.getText().isEmpty() || tf_publisherid.getText().isEmpty() || tf_publishername.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Không được để trống các trường!");
                return;
            }

            // add
            if (status == 1) {
                choice = new showMessageDialogs().saveMessage("author");
                if (choice == true) {
                    publisherDAO = new PublisherDAO();
                    String id = tf_publisherid.getText().toString();
                    String publishername = tf_publishername.getText().toString();
                    String address = tf_address.getText().toString();
                    String contact = tf_contact.getText().toString();
                    publisherModel = new PublisherModel(id, publishername, address, contact);
                    publisherDAO.add(publisherModel);
                    updateTable();
                }
            } // edit
            else if (status == 2) {
                choice = new showMessageDialogs().editMessage();
                if (choice == true) {
                    publisherDAO = new PublisherDAO();
                    String id = tf_publisherid.getText().toString();
                    String publishername = tf_publishername.getText().toString();
                    String address = tf_address.getText().toString();
                    String contact = tf_contact.getText().toString();
                    publisherModel = new PublisherModel(id, publishername, address, contact);
                    publisherDAO.update(publisherModel);
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

    private void updateTable() throws SQLException {
        DefaultTableModel model = (DefaultTableModel) tb_publisher.getModel();
        model.setRowCount(0);
        publisherDAO = new PublisherDAO();
        List<PublisherModel> publisherModels = publisherDAO.getAll();
        for (PublisherModel publisher : publisherModels) {
            String id = publisher.getId();
            String publishername = publisher.getName();
            String address = publisher.getAddress();
            String contact = publisher.getContact();
            model.addRow(new Object[]{id, publishername, address, contact});
        }
        resetText();
    }

    private void disabletext() {
        tf_publishername.enable(false);
        tf_publisherid.enable(false);
        tf_address.enable(false);
        tf_contact.enable(false);
    }

    private void enableText() {
        tf_publishername.enable(true);
        tf_publisherid.enable(true);
        tf_address.enable(true);
        tf_contact.enable(true);
    }

    private void resetText() {
        tf_publisherid.setText("");
        tf_publishername.setText("");
        tf_address.setText("");
        tf_contact.setText("");
    }
}
