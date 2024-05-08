/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.nhom08.bookstore;

//import com.nhom08.bookstore.DAO.BookDAO;
import Event.EventItem;
import com.nhom08.bookstore.GUI.FunctionalPanels.FormHome;
import com.nhom08.bookstore.DAO.BookDAO;

import com.nhom08.bookstore.Models.BookModel;

import java.awt.BorderLayout;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.text.DecimalFormat;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Admin
 */
@Getter
@Setter
public class CashierFrame extends javax.swing.JFrame {

    /**
     * Creates new form CashierFrame
     */
    private FormHome home;

    private BookDAO bookDao;

    private String maHoaDon;
    
    public CashierFrame() {
        initComponents();
        init();

        //BookDAO bookDao = new BookDAO();
        bookDao = new BookDAO();
        lb_cart.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                themMaHoaDon();
                chuyenSangReceiptFrame();
            }

            private void themMaHoaDon() {
                maHoaDon=bookDao.themMaHoaDon();
                
            }

            private void chuyenSangReceiptFrame() {
                Cashier_ReceiptFrame receiptFrame = new Cashier_ReceiptFrame(maHoaDon);
                receiptFrame.setVisible(true);

                CashierFrame cs = new CashierFrame();
                cs.setVisible(false);
            }
        });

    }

    private void showData() {
        home.setEvent(new EventItem() {
            @Override
            public void itemClick(Component com, BookModel item) {
                //System.err.println(item.getId());
                String id = item.getId();
                //String id = "1";
                home.setSelected(com);

                BookDAO bookDao = new BookDAO();
                BookModel selectedBook = bookDao.getOne(id);

                // Nếu sách được tìm thấy, đổ dữ liệu vào các text field
                if (selectedBook != null) {
                    tf_masach.setText(selectedBook.getId());
                    tf_matacgia.setText(selectedBook.getAuthorId());
                    tf_manxb.setText(selectedBook.getPublisherId());
                    tf_tensach.setText(selectedBook.getName());
                    tf_soluong.setText(String.valueOf(selectedBook.getQuantity()));
                    DecimalFormat df = new DecimalFormat("#,### VNĐ");
                    tf_gia.setText(df.format(selectedBook.getPrice()));
                    tf_theloai.setText(selectedBook.getType());
                } else {
                    // Xử lý trường hợp không tìm thấy sách
                    System.err.println("Không tìm thấy sách trong CSDL");
                }
            }

        });

        BookDAO bookDao = new BookDAO();
        if (bookDao != null) {
            List<BookModel> books = bookDao.getInfoBook();

            for (BookModel book : books) {
                home.addItem(book);
            }
        } else {
            System.err.println("Không thể kết nối đến CSDL");

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_Header = new javax.swing.JPanel();
        lbl_userIcon = new javax.swing.JLabel();
        lbl_accountName = new javax.swing.JLabel();
        textFieldCustom1 = new com.nhom08.bookstore.GUI.TextFieldCustom();
        panelCustom1 = new com.nhom08.bookstore.GUI.PanelCustom();
        jPanel1 = new javax.swing.JPanel();
        tf_matacgia = new com.nhom08.bookstore.GUI.TextFieldCustom();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        tf_masach = new com.nhom08.bookstore.GUI.TextFieldCustom();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        tf_manxb = new com.nhom08.bookstore.GUI.TextFieldCustom();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        tf_tensach = new com.nhom08.bookstore.GUI.TextFieldCustom();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        tf_soluong = new com.nhom08.bookstore.GUI.TextFieldCustom();
        jLabel6 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        tf_gia = new com.nhom08.bookstore.GUI.TextFieldCustom();
        jLabel7 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        tf_theloai = new com.nhom08.bookstore.GUI.TextFieldCustom();
        jLabel8 = new javax.swing.JLabel();
        panel_cancelBtn = new com.nhom08.bookstore.GUI.PanelCustom();
        lb_cart = new javax.swing.JLabel();
        mainPanel = new com.nhom08.bookstore.GUI.FunctionalPanels.main_CashierPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 254, 251));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_Header.setBackground(new java.awt.Color(219, 235, 247));
        panel_Header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_userIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_userIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/user_filled.png"))); // NOI18N
        panel_Header.add(lbl_userIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 12, 40, 40));

        lbl_accountName.setFont(new java.awt.Font("Lexend SemiBold", 0, 20)); // NOI18N
        lbl_accountName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_accountName.setText("Account name");
        panel_Header.add(lbl_accountName, new org.netbeans.lib.awtextra.AbsoluteConstraints(1098, 18, -1, -1));
        panel_Header.add(textFieldCustom1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 11, 338, 41));

        getContentPane().add(panel_Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 60));

        panelCustom1.setBackground(new java.awt.Color(137, 207, 245));
        panelCustom1.setRoundBottomLeft(20);
        panelCustom1.setRoundBottomRight(20);
        panelCustom1.setRoundTopLeft(20);
        panelCustom1.setRoundTopRight(20);
        panelCustom1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(137, 207, 245));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tf_matacgia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_matacgiaActionPerformed(evt);
            }
        });
        jPanel1.add(tf_matacgia, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 32, 280, -1));

        jLabel1.setFont(new java.awt.Font("Lexend", 0, 15)); // NOI18N
        jLabel1.setText("Mã Tác Giả:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        panelCustom1.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 300, -1));

        jPanel2.setBackground(new java.awt.Color(137, 207, 245));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tf_masach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_masachActionPerformed(evt);
            }
        });
        jPanel2.add(tf_masach, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 32, 280, -1));

        jLabel2.setFont(new java.awt.Font("Lexend", 0, 15)); // NOI18N
        jLabel2.setText("Mã Sách:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        panelCustom1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 300, -1));

        jPanel3.setBackground(new java.awt.Color(137, 207, 245));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tf_manxb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_manxbActionPerformed(evt);
            }
        });
        jPanel3.add(tf_manxb, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 32, 280, -1));

        jLabel3.setFont(new java.awt.Font("Lexend", 0, 15)); // NOI18N
        jLabel3.setText("Mã NXB:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        panelCustom1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 300, -1));

        jPanel4.setBackground(new java.awt.Color(137, 207, 245));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tf_tensach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_tensachActionPerformed(evt);
            }
        });
        jPanel4.add(tf_tensach, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 32, 280, -1));

        jLabel4.setFont(new java.awt.Font("Lexend", 0, 15)); // NOI18N
        jLabel4.setText("Tên Sách:");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        panelCustom1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 300, -1));

        jPanel5.setBackground(new java.awt.Color(137, 207, 245));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tf_soluong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_soluongActionPerformed(evt);
            }
        });
        jPanel5.add(tf_soluong, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 32, 280, -1));

        jLabel6.setFont(new java.awt.Font("Lexend", 0, 15)); // NOI18N
        jLabel6.setText("Số Lượng:");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        panelCustom1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 300, -1));

        jPanel6.setBackground(new java.awt.Color(137, 207, 245));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tf_gia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_giaActionPerformed(evt);
            }
        });
        jPanel6.add(tf_gia, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 32, 280, -1));

        jLabel7.setFont(new java.awt.Font("Lexend", 0, 15)); // NOI18N
        jLabel7.setText("Giá:");
        jPanel6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        panelCustom1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 300, -1));

        jPanel7.setBackground(new java.awt.Color(137, 207, 245));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tf_theloai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_theloaiActionPerformed(evt);
            }
        });
        jPanel7.add(tf_theloai, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 32, 280, -1));

        jLabel8.setFont(new java.awt.Font("Lexend", 0, 15)); // NOI18N
        jLabel8.setText("Thể Loại:");
        jPanel7.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 9, -1, 20));

        panelCustom1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 300, -1));

        panel_cancelBtn.setRoundBottomLeft(20);
        panel_cancelBtn.setRoundBottomRight(20);
        panel_cancelBtn.setRoundTopLeft(20);
        panel_cancelBtn.setRoundTopRight(20);
        panel_cancelBtn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb_cart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add_item_cart.png"))); // NOI18N
        panel_cancelBtn.add(lb_cart, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 40, 38));

        panelCustom1.add(panel_cancelBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 530, 50, 50));

        getContentPane().add(panelCustom1, new org.netbeans.lib.awtextra.AbsoluteConstraints(953, 85, 305, 700));
        getContentPane().add(mainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 940, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_theloaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_theloaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_theloaiActionPerformed

    private void tf_giaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_giaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_giaActionPerformed

    private void tf_soluongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_soluongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_soluongActionPerformed

    private void tf_tensachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_tensachActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_tensachActionPerformed

    private void tf_manxbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_manxbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_manxbActionPerformed

    private void tf_masachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_masachActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_masachActionPerformed

    private void tf_matacgiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_matacgiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_matacgiaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CashierFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CashierFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CashierFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CashierFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CashierFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel lb_cart;
    private javax.swing.JLabel lbl_accountName;
    private javax.swing.JLabel lbl_userIcon;
    private com.nhom08.bookstore.GUI.FunctionalPanels.main_CashierPanel mainPanel;
    private com.nhom08.bookstore.GUI.PanelCustom panelCustom1;
    private com.nhom08.bookstore.GUI.FunctionalPanels.Panel_BookItem panel_BookItem1;
    private javax.swing.JPanel panel_Header;
    private com.nhom08.bookstore.GUI.PanelCustom panel_cancelBtn;
    private com.nhom08.bookstore.GUI.TextFieldCustom textFieldCustom1;
    private com.nhom08.bookstore.GUI.TextFieldCustom tf_gia;
    private com.nhom08.bookstore.GUI.TextFieldCustom tf_manxb;
    private com.nhom08.bookstore.GUI.TextFieldCustom tf_masach;
    private com.nhom08.bookstore.GUI.TextFieldCustom tf_matacgia;
    private com.nhom08.bookstore.GUI.TextFieldCustom tf_soluong;
    private com.nhom08.bookstore.GUI.TextFieldCustom tf_tensach;
    private com.nhom08.bookstore.GUI.TextFieldCustom tf_theloai;
    // End of variables declaration//GEN-END:variables

    private void init() {
        home = new FormHome();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(home);
        showData();
    }
}
