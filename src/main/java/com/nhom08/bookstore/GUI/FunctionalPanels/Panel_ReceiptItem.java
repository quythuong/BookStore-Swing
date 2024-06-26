/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.nhom08.bookstore.GUI.FunctionalPanels;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.text.View.*;

/**
 *
 * @author Admin
 */
public class Panel_ReceiptItem extends javax.swing.JPanel {

    /**
     * Creates new form Panel_ReceiptItem
     */
    public Panel_ReceiptItem() {
        initComponents();
        
        // Load ImageIcon
        ImageIcon icon = new ImageIcon(getClass().getResource("/icons/trash-xmark.png"));
        // Resize ImageIcon
        Image img = icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(img);
        // Set resized ImageIcon to JLabel
        lb_iconTrash.setIcon(resizedIcon);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb_iconTrash = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        buttonCustom1 = new Custom.ButtonCustom();
        buttonCustom2 = new Custom.ButtonCustom();
        jLabel10 = new javax.swing.JLabel();
        panelCustom16 = new Custom.PanelCustom();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb_iconTrash.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_iconTrash.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/trash-xmark.png"))); // NOI18N
        add(lb_iconTrash, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 26, 20, 20));

        jLabel9.setFont(new java.awt.Font("Lexend", 0, 15)); // NOI18N
        jLabel9.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 19, 207, 33));

        buttonCustom1.setText("-");
        buttonCustom1.setRadius(500);
        add(buttonCustom1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 27, -1, -1));

        buttonCustom2.setText("+");
        buttonCustom2.setRadius(500);
        add(buttonCustom2, new org.netbeans.lib.awtextra.AbsoluteConstraints(357, 27, -1, -1));

        jLabel10.setFont(new java.awt.Font("Lexend", 0, 15)); // NOI18N
        jLabel10.setText("xxx.xxx.xxx VNĐ");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 28, -1, -1));

        panelCustom16.setBackground(new java.awt.Color(255, 255, 255));
        panelCustom16.setName(""); // NOI18N
        panelCustom16.setPreferredSize(new java.awt.Dimension(519, 71));
        panelCustom16.setRoundBottomLeft(30);
        panelCustom16.setRoundBottomRigt(30);
        panelCustom16.setRoundTopLeft(30);
        panelCustom16.setRoundTopRigt(30);

        javax.swing.GroupLayout panelCustom16Layout = new javax.swing.GroupLayout(panelCustom16);
        panelCustom16.setLayout(panelCustom16Layout);
        panelCustom16Layout.setHorizontalGroup(
            panelCustom16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 53, Short.MAX_VALUE)
        );
        panelCustom16Layout.setVerticalGroup(
            panelCustom16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );

        add(panelCustom16, new org.netbeans.lib.awtextra.AbsoluteConstraints(297, 17, 53, 38));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Custom.ButtonCustom buttonCustom1;
    private Custom.ButtonCustom buttonCustom2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lb_iconTrash;
    private Custom.PanelCustom panelCustom16;
    // End of variables declaration//GEN-END:variables
}
