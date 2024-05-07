/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.nhom08.bookstore.GUI.FunctionalPanels;

import com.nhom08.bookstore.DAO.BookDAO;
import com.nhom08.bookstore.DAO.IReceiptDetailsDAO;
import com.nhom08.bookstore.Models.BookModel;
import com.nhom08.bookstore.Models.IReceiptDetailsModel;
import java.awt.Color;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Admin
 */
@Getter
@Setter
public class panel_iReceiptDetail extends javax.swing.JPanel {

    /**
     * Creates new form panel_iReceiptDetail
     */
    private String iReceiptId;
    private IReceiptDetailsModel selectedIReceiptDetails = null;
    private IReceiptDetailsDAO iReceiptDetailDAO = new IReceiptDetailsDAO();
    private BookDAO bookDAO = new BookDAO();
    private DefaultTableModel tableModel;
    private String Mode = null; // the trash code because of the UI

    public panel_iReceiptDetail() {
        initComponents();
        loadTable();

    }

    public void loadTable() {
        tableModel = (DefaultTableModel) table_iReceiptDetails.getModel();
        tableModel.setRowCount(0);
        List<IReceiptDetailsModel> iReceiptDetailsList = iReceiptDetailDAO.getAllByReceiptId(iReceiptId);

        iReceiptDetailsList.forEach((e) -> {
            BookModel book;
//		    try {
            book = bookDAO.getOne(e.getBookId());
            tableModel.addRow(new Object[]{e.getIReceipId(), e.getBookId(), book.getName(), String.valueOf(e.getQuantity())});
//		    } catch (SQLException ex) {
//			    Logger.getLogger(panel_iReceiptDetail.class.getName()).log(Level.SEVERE, null, ex);
//		    }
        });
    }

    public void clearText() {
        tf_bookId.setText("");
        tf_bookName.setText("");
        tf_iReceiptId.setText("");
        tf_quantity.setText("");
    }

    public void enableText() {
//		tf_bookId.setBackground(Color.WHITE);
//		tf_iReceiptId.setBackground(Color.WHITE);
        tf_quantity.setBackground(Color.WHITE);

//		tf_bookId.setEditable(true);
//		tf_iReceiptId.setEditable(true);
        tf_quantity.setEditable(true);
    }

    public void disableText() {
        tf_bookId.setBackground(new Color(204, 204, 204));
        tf_iReceiptId.setBackground(new Color(204, 204, 204));
        tf_quantity.setBackground(new Color(204, 204, 204));

        tf_bookId.setEditable(false);
        tf_iReceiptId.setEditable(false);
        tf_quantity.setEditable(false);
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
                panelCustom3 = new Custom.PanelCustom();
                jScrollPane1 = new javax.swing.JScrollPane();
                table_iReceiptDetails = new javax.swing.JTable();
                panelCustom2 = new Custom.PanelCustom();
                btn_add = new Custom.ButtonCustom();
                btn_edit = new Custom.ButtonCustom();
                btn_delete = new Custom.ButtonCustom();
                panelCustom4 = new Custom.PanelCustom();
                jPanel1 = new javax.swing.JPanel();
                tf_iReceiptId = new com.nhom08.bookstore.GUI.TextFieldCustom();
                jLabel4 = new javax.swing.JLabel();
                jPanel3 = new javax.swing.JPanel();
                tf_bookId = new com.nhom08.bookstore.GUI.TextFieldCustom();
                jLabel5 = new javax.swing.JLabel();
                jPanel4 = new javax.swing.JPanel();
                tf_bookName = new com.nhom08.bookstore.GUI.TextFieldCustom();
                jLabel6 = new javax.swing.JLabel();
                jPanel5 = new javax.swing.JPanel();
                tf_quantity = new com.nhom08.bookstore.GUI.TextFieldCustom();
                jLabel7 = new javax.swing.JLabel();
                lbl_clearBtn = new javax.swing.JLabel();
                lbl_saveBtn = new javax.swing.JLabel();
                lbl_backBtn = new javax.swing.JLabel();

                setBackground(new java.awt.Color(255, 254, 251));
                setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                jLabel2.setFont(new java.awt.Font("Lexend", 0, 30)); // NOI18N
                jLabel2.setText("I-Receipts Detail Management");
                add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(347, 25, -1, -1));

                panelCustom3.setPreferredSize(new java.awt.Dimension(695, 515));
                panelCustom3.setRoundBottomLeft(10);
                panelCustom3.setRoundBottomRigt(10);
                panelCustom3.setRoundTopLeft(10);
                panelCustom3.setRoundTopRigt(10);
                panelCustom3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                table_iReceiptDetails.setFont(new java.awt.Font("Lexend", 0, 14)); // NOI18N
                table_iReceiptDetails.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {

                        },
                        new String [] {
                                "Mã phiếu nhập", "Mã sách", "Tên sách", "Số lượng nhập"
                        }
                ));
                table_iReceiptDetails.setRowHeight(30);
                table_iReceiptDetails.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                table_iReceiptDetailsMouseClicked(evt);
                        }
                });
                jScrollPane1.setViewportView(table_iReceiptDetails);

                panelCustom3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 106, 649, 484));

                panelCustom2.setPreferredSize(new java.awt.Dimension(695, 68));
                panelCustom2.setRoundBottomLeft(10);
                panelCustom2.setRoundBottomRigt(10);
                panelCustom2.setRoundTopLeft(10);
                panelCustom2.setRoundTopRigt(10);
                panelCustom2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                btn_add.setBackground(new java.awt.Color(217, 217, 217));
                btn_add.setBorder(null);
                btn_add.setText("Add");
                btn_add.setBorderColor(new java.awt.Color(217, 217, 217));
                btn_add.setColor(new java.awt.Color(217, 217, 217));
                btn_add.setColorOver(new java.awt.Color(217, 217, 217));
                btn_add.setFont(new java.awt.Font("Lexend", 0, 24)); // NOI18N
                btn_add.setPreferredSize(new java.awt.Dimension(160, 42));
                btn_add.setRadius(20);
                btn_add.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                btn_addMouseClicked(evt);
                        }
                });
                btn_add.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btn_addActionPerformed(evt);
                        }
                });
                panelCustom2.add(btn_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 14, -1, -1));

                btn_edit.setBackground(new java.awt.Color(217, 217, 217));
                btn_edit.setBorder(null);
                btn_edit.setText("Edit");
                btn_edit.setBorderColor(new java.awt.Color(217, 217, 217));
                btn_edit.setColor(new java.awt.Color(217, 217, 217));
                btn_edit.setColorOver(new java.awt.Color(217, 217, 217));
                btn_edit.setFont(new java.awt.Font("Lexend", 0, 24)); // NOI18N
                btn_edit.setPreferredSize(new java.awt.Dimension(160, 42));
                btn_edit.setRadius(20);
                btn_edit.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                btn_editMouseClicked(evt);
                        }
                });
                btn_edit.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btn_editActionPerformed(evt);
                        }
                });
                panelCustom2.add(btn_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(266, 14, -1, -1));

                btn_delete.setBackground(new java.awt.Color(217, 217, 217));
                btn_delete.setBorder(null);
                btn_delete.setText("Delete");
                btn_delete.setBorderColor(new java.awt.Color(217, 217, 217));
                btn_delete.setColor(new java.awt.Color(217, 217, 217));
                btn_delete.setColorOver(new java.awt.Color(217, 217, 217));
                btn_delete.setFont(new java.awt.Font("Lexend", 0, 24)); // NOI18N
                btn_delete.setPreferredSize(new java.awt.Dimension(160, 42));
                btn_delete.setRadius(20);
                btn_delete.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                btn_deleteMouseClicked(evt);
                        }
                });
                btn_delete.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btn_deleteActionPerformed(evt);
                        }
                });
                panelCustom2.add(btn_delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(519, 14, -1, -1));

                panelCustom3.add(panelCustom2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 690, -1));

                add(panelCustom3, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 105, -1, 610));

                panelCustom4.setPreferredSize(new java.awt.Dimension(248, 612));
                panelCustom4.setRoundBottomLeft(10);
                panelCustom4.setRoundBottomRigt(10);
                panelCustom4.setRoundTopLeft(10);
                panelCustom4.setRoundTopRigt(10);
                panelCustom4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                tf_iReceiptId.setEditable(false);
                tf_iReceiptId.setBackground(new java.awt.Color(204, 204, 204));
                tf_iReceiptId.setFont(new java.awt.Font("Lexend", 0, 14)); // NOI18N
                tf_iReceiptId.setPreferredSize(new java.awt.Dimension(210, 33));
                tf_iReceiptId.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                tf_iReceiptIdActionPerformed(evt);
                        }
                });
                jPanel1.add(tf_iReceiptId, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 210, 40));

                jLabel4.setFont(new java.awt.Font("Lexend", 0, 15)); // NOI18N
                jLabel4.setText("Mã phiếu nhập");
                jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

                panelCustom4.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 21, -1, -1));

                jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                tf_bookId.setEditable(false);
                tf_bookId.setBackground(new java.awt.Color(204, 204, 204));
                tf_bookId.setFont(new java.awt.Font("Lexend", 0, 14)); // NOI18N
                tf_bookId.setPreferredSize(new java.awt.Dimension(210, 33));
                tf_bookId.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                tf_bookIdActionPerformed(evt);
                        }
                });
                jPanel3.add(tf_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 210, 40));

                jLabel5.setFont(new java.awt.Font("Lexend", 0, 15)); // NOI18N
                jLabel5.setText("Mã sách");
                jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

                panelCustom4.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 90, -1, -1));

                jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                tf_bookName.setEditable(false);
                tf_bookName.setBackground(new java.awt.Color(204, 204, 204));
                tf_bookName.setFont(new java.awt.Font("Lexend", 0, 14)); // NOI18N
                tf_bookName.setPreferredSize(new java.awt.Dimension(210, 33));
                tf_bookName.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                tf_bookNameActionPerformed(evt);
                        }
                });
                jPanel4.add(tf_bookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 210, 40));

                jLabel6.setFont(new java.awt.Font("Lexend", 0, 15)); // NOI18N
                jLabel6.setText("Tên sách");
                jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

                panelCustom4.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 159, -1, -1));

                jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                tf_quantity.setEditable(false);
                tf_quantity.setBackground(new java.awt.Color(204, 204, 204));
                tf_quantity.setFont(new java.awt.Font("Lexend", 0, 14)); // NOI18N
                tf_quantity.setPreferredSize(new java.awt.Dimension(210, 33));
                tf_quantity.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                tf_quantityActionPerformed(evt);
                        }
                });
                jPanel5.add(tf_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 210, 40));

                jLabel7.setFont(new java.awt.Font("Lexend", 0, 15)); // NOI18N
                jLabel7.setText("Số lượng nhập");
                jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

                panelCustom4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 228, -1, -1));

                lbl_clearBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cancle.png"))); // NOI18N
                lbl_clearBtn.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                lbl_clearBtnMouseClicked(evt);
                        }
                });
                panelCustom4.add(lbl_clearBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 556, 40, 38));

                lbl_saveBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/save.png"))); // NOI18N
                lbl_saveBtn.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                lbl_saveBtnMouseClicked(evt);
                        }
                });
                panelCustom4.add(lbl_saveBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 556, 40, 38));

                add(panelCustom4, new org.netbeans.lib.awtextra.AbsoluteConstraints(766, 103, -1, -1));

                lbl_backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/arrow-small-left.png"))); // NOI18N
                add(lbl_backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 24, -1, -1));
        }// </editor-fold>//GEN-END:initComponents

    private void tf_iReceiptIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_iReceiptIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_iReceiptIdActionPerformed

    private void tf_bookIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_bookIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_bookIdActionPerformed

    private void tf_bookNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_bookNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_bookNameActionPerformed

    private void tf_quantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_quantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_quantityActionPerformed

        private void table_iReceiptDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_iReceiptDetailsMouseClicked
            // TODO add your handling code here:
            selectedIReceiptDetails = new IReceiptDetailsModel(tableModel.getValueAt(table_iReceiptDetails.getSelectedRow(), 0).toString(), tableModel.getValueAt(table_iReceiptDetails.getSelectedRow(), 1).toString(), Integer.parseInt(tableModel.getValueAt(table_iReceiptDetails.getSelectedRow(), 3).toString()));
            tf_iReceiptId.setText(selectedIReceiptDetails.getIReceipId());
            tf_bookId.setText(selectedIReceiptDetails.getBookId());
            tf_bookName.setText(tableModel.getValueAt(table_iReceiptDetails.getSelectedRow(), 2).toString());
            tf_quantity.setText(String.valueOf(selectedIReceiptDetails.getQuantity()));
        }//GEN-LAST:event_table_iReceiptDetailsMouseClicked

        private void btn_addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addMouseClicked
            // TODO add your handling code here:
            Mode = "add";

            enableText();

            this.clearText();
            tf_iReceiptId.setText(this.iReceiptId);
            this.enableText();
            tf_bookId.setEditable(true);
            tf_bookId.setBackground(Color.WHITE);
        }//GEN-LAST:event_btn_addMouseClicked

        private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
            // TODO add your handling code here:
        }//GEN-LAST:event_btn_addActionPerformed

        private void btn_editMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_editMouseClicked
            // TODO add your handling code here:
            if (selectedIReceiptDetails == null) {
                JOptionPane.showMessageDialog(this, "Chưa chọn phiếu nhập nào!");
                return;
            }
            enableText();
            this.tf_iReceiptId.setEditable(false);
            this.tf_iReceiptId.setBackground(new Color(204, 204, 204));
            Mode = "edit";
        }//GEN-LAST:event_btn_editMouseClicked

        private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
            // TODO add your handling code here:
        }//GEN-LAST:event_btn_editActionPerformed

        private void btn_deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_deleteMouseClicked
            // TODO add your handling code here:
            if (selectedIReceiptDetails == null) {
                JOptionPane.showMessageDialog(this, "Chưa chọn dòng chi tiết phiếu nhập nào!");
                return;
            }
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(null, "Bạn có muốn xoá chi tiết phiếu nhập " + "" + "?", "Warning", dialogButton);
            if (dialogResult == JOptionPane.YES_OPTION) {
                try {
                    iReceiptDetailDAO.delete(selectedIReceiptDetails);
                } catch (SQLException ex) {
                    Logger.getLogger(panel_iReceipt.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(this, "Xoá chi tiết phiếu nhập thất bại");
                }
                JOptionPane.showMessageDialog(this, "Xoá chi tiết phiếu nhập thành công");
                loadTable();
            }
        }//GEN-LAST:event_btn_deleteMouseClicked

        private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
            // TODO add your handling code here:
        }//GEN-LAST:event_btn_deleteActionPerformed

        private void lbl_clearBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_clearBtnMouseClicked
            // TODO add your handling code here:
            clearText();
            this.iReceiptId = null;
            this.table_iReceiptDetails.clearSelection();
        }//GEN-LAST:event_lbl_clearBtnMouseClicked

        private void lbl_saveBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_saveBtnMouseClicked
            // TODO add your handling code here:
            if (Mode == null) {
                JOptionPane.showMessageDialog(this, "Chưa chọn thêm hoặc chỉnh sửa!");
                return;
            }
            if (tf_iReceiptId.getText().isEmpty() || tf_bookId.getText().isEmpty() || tf_quantity.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Không được để trống các trường!");
                return;
            }
            try {

                IReceiptDetailsModel iReceiptDetailsModel = new IReceiptDetailsModel(tf_iReceiptId.getText(), tf_bookId.getText(), Integer.parseInt(tf_quantity.getText()));
                System.out.println(iReceiptDetailsModel.toString());
                //save to DB
                if ("add".equals(Mode)) {
                    iReceiptDetailDAO.save(iReceiptDetailsModel);
                } else if ("edit".equals(Mode)) {
                    iReceiptDetailDAO.update(iReceiptDetailsModel);
                }
            } catch (SQLException ex) {
                Logger.getLogger(panel_iReceipt.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Thất bại");
                Mode = null;
            }
            if ("add".equals(Mode)) {
                JOptionPane.showMessageDialog(this, "Thêm chi tiết phiếu nhập thành công");
            } else if ("edit".equals(Mode)) {
                JOptionPane.showMessageDialog(this, "Sửa chi tiết phiếu nhập thành công");
            }

            loadTable();
            clearText();
            disableText();
            Mode = null;
            selectedIReceiptDetails = null;
        }//GEN-LAST:event_lbl_saveBtnMouseClicked


        // Variables declaration - do not modify//GEN-BEGIN:variables
        private Custom.ButtonCustom btn_add;
        private Custom.ButtonCustom btn_delete;
        private Custom.ButtonCustom btn_edit;
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
        private javax.swing.JLabel lbl_backBtn;
        private javax.swing.JLabel lbl_clearBtn;
        private javax.swing.JLabel lbl_saveBtn;
        private Custom.PanelCustom panelCustom2;
        private Custom.PanelCustom panelCustom3;
        private Custom.PanelCustom panelCustom4;
        private javax.swing.JTable table_iReceiptDetails;
        private com.nhom08.bookstore.GUI.TextFieldCustom tf_bookId;
        private com.nhom08.bookstore.GUI.TextFieldCustom tf_bookName;
        private com.nhom08.bookstore.GUI.TextFieldCustom tf_iReceiptId;
        private com.nhom08.bookstore.GUI.TextFieldCustom tf_quantity;
        // End of variables declaration//GEN-END:variables
}
