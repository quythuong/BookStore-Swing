/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.nhom08.bookstore;

import com.nhom08.bookstore.DAO.DBConnection;
import com.nhom08.bookstore.DAO.EmployeeDAO;
import com.nhom08.bookstore.DAO.LoginDAO;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

/**
 *
 * @author Admin
 */
public class LoginFrame extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public LoginFrame() {
        initComponents();
        setLocationRelativeTo(null);
        scale();
        reset();
    }
    public void reset() {
        txt_username.setText("");
        txt_password.setText("");
        // Mở và xóa các text field khác ở đây tương tự
    }
    public void scale() {
//        ImageIcon icon = new javax.swing.ImageIcon(getClass().getResource("/images/Login Background1280_800.png"));
//        Image img = icon.getImage();
//        Image scale = img.getScaledInstance(1280, 800, Image.SCALE_DEFAULT);
//        ImageIcon scaleicon = new ImageIcon(scale);
//        jLabel2.setIcon(scaleicon);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_login = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txt_username = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_password = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_login.setBackground(new java.awt.Color(255, 216, 156));
        btn_login.setFont(new java.awt.Font("Lexend Medium", 0, 16)); // NOI18N
        btn_login.setText("Login");
        btn_login.setPreferredSize(new java.awt.Dimension(94, 32));
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });
        getContentPane().add(btn_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 480, -1, -1));

        jLabel4.setFont(new java.awt.Font("Lexend Light", 0, 16)); // NOI18N
        jLabel4.setText("Username:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 330, -1, -1));

        txt_username.setFont(new java.awt.Font("Lexend Thin", 0, 12)); // NOI18N
        txt_username.setForeground(new java.awt.Color(157, 157, 157));
        txt_username.setText("Username");
        txt_username.setMinimumSize(new java.awt.Dimension(239, 31));
        txt_username.setPreferredSize(new java.awt.Dimension(239, 31));
        txt_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usernameActionPerformed(evt);
            }
        });
        getContentPane().add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 320, 239, 31));

        jLabel5.setFont(new java.awt.Font("Lexend Light", 0, 16)); // NOI18N
        jLabel5.setText("Password:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 390, -1, -1));

        txt_password.setFont(new java.awt.Font("Lexend Thin", 0, 24)); // NOI18N
        txt_password.setForeground(new java.awt.Color(157, 157, 157));
        txt_password.setText("password");
        txt_password.setMinimumSize(new java.awt.Dimension(239, 31));
        txt_password.setPreferredSize(new java.awt.Dimension(239, 31));
        txt_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passwordActionPerformed(evt);
            }
        });
        getContentPane().add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 390, 239, 31));

        jLabel3.setFont(new java.awt.Font("Lexend Light", 0, 16)); // NOI18N
        jLabel3.setText("Hi, login to get access to your roles");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 220, -1, -1));

        jLabel1.setFont(new java.awt.Font("Lexend SemiBold", 0, 35)); // NOI18N
        jLabel1.setText("LOGIN");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 170, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Login Background1280_800.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passwordActionPerformed

    private void txt_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usernameActionPerformed

    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
        String tenDangNhap = txt_username.getText();
        String matKhau = new String(txt_password.getPassword());

        DBConnection dbConnection = new DBConnection();
        Connection con = dbConnection.GetDBConnection();
        LoginDAO loginDAO = new LoginDAO(con);
	EmployeeDAO employeeDAO = new EmployeeDAO();
	JLabel lbl_accountName = null;
	JTabbedPane TabbedPane = null;
        try {
            int cap = loginDAO.dangNhap(tenDangNhap, matKhau);
            if (cap > 0) {
                this.setVisible(false); // Ẩn LoginFrame
                if (cap == 1) {
                    ManagerFrame managerFrame = new ManagerFrame(); // Tạo đối tượng ManagerFrame
                    managerFrame.setVisible(true); // Hiển thị ManagerFrame
		    managerFrame.setEmployee(employeeDAO.getEmployeeByUsername(tenDangNhap));
		    managerFrame.getLbl_accountName().setText(employeeDAO.getEmployeeByUsername(tenDangNhap).getAccount()); // user account trên header
		    lbl_accountName = managerFrame.getLbl_accountName();
                } else if (cap == 2) {
                    CashierFrame cashierFrame = new CashierFrame(); // Tạo đối tượng CashierFrame
                    cashierFrame.setVisible(true);
		    cashierFrame.setEmployeeId(employeeDAO.getEmployeeByUsername(tenDangNhap));
		    cashierFrame.getLbl_accountName().setText(employeeDAO.getEmployeeByUsername(tenDangNhap).getAccount());
		    lbl_accountName = cashierFrame.getLbl_accountName();
                    
                } else if (cap == 3) {
                    StorageManagerFrame storagemanagerFrame = new StorageManagerFrame(); // Tạo đối tượng storagemanagerFrame
                    storagemanagerFrame.setVisible(true);
		    storagemanagerFrame.setEmployee(employeeDAO.getEmployeeByUsername(tenDangNhap));
		    storagemanagerFrame.getLbl_accountName().setText(employeeDAO.getEmployeeByUsername(tenDangNhap).getAccount());
		    lbl_accountName = storagemanagerFrame.getLbl_accountName();
                }
		
                // Đăng nhập thành công, ẩn LoginFrame và hiển thị Frame

            } else {
                // Đăng nhập thất bại, hiển thị thông báo cho người dùng
                JOptionPane.showMessageDialog(LoginFrame.this, "Tên đăng nhập hoặc mật khẩu không đúng", "Đăng nhập không thành công", JOptionPane.ERROR_MESSAGE);
            }
            
        } catch (SQLException ex) {
            // Xử lý khi có lỗi xảy ra
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btn_loginActionPerformed
    
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
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_login;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
