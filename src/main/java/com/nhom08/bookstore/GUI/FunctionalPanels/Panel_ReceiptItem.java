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
        panelCustom10 = new Custom.PanelCustom();
        lb_iconTrash1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        buttonCustom3 = new Custom.ButtonCustom();
        buttonCustom4 = new Custom.ButtonCustom();
        panelCustom17 = new Custom.PanelCustom();
        jLabel12 = new javax.swing.JLabel();

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

        panelCustom10.setBackground(new java.awt.Color(238, 238, 238));
        panelCustom10.setPreferredSize(new java.awt.Dimension(519, 71));
        panelCustom10.setRoundBottomLeft(30);
        panelCustom10.setRoundBottomRigt(30);
        panelCustom10.setRoundTopLeft(30);
        panelCustom10.setRoundTopRigt(30);

        jLabel11.setFont(new java.awt.Font("Lexend", 0, 15)); // NOI18N
        jLabel11.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");

        buttonCustom3.setText("-");
        buttonCustom3.setRadius(500);

        buttonCustom4.setText("+");
        buttonCustom4.setRadius(500);

        panelCustom17.setBackground(new java.awt.Color(255, 255, 255));
        panelCustom17.setPreferredSize(new java.awt.Dimension(519, 71));
        panelCustom17.setRoundBottomLeft(30);
        panelCustom17.setRoundBottomRigt(30);
        panelCustom17.setRoundTopLeft(30);
        panelCustom17.setRoundTopRigt(30);

        javax.swing.GroupLayout panelCustom17Layout = new javax.swing.GroupLayout(panelCustom17);
        panelCustom17.setLayout(panelCustom17Layout);
        panelCustom17Layout.setHorizontalGroup(
            panelCustom17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 57, Short.MAX_VALUE)
        );
        panelCustom17Layout.setVerticalGroup(
            panelCustom17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        jLabel12.setFont(new java.awt.Font("Lexend", 0, 14)); // NOI18N
        jLabel12.setText("xxx.xxx.xxx VNĐ");

        javax.swing.GroupLayout panelCustom10Layout = new javax.swing.GroupLayout(panelCustom10);
        panelCustom10.setLayout(panelCustom10Layout);
        panelCustom10Layout.setHorizontalGroup(
            panelCustom10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCustom10Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lb_iconTrash1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonCustom3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelCustom17, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonCustom4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        panelCustom10Layout.setVerticalGroup(
            panelCustom10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCustom10Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(panelCustom10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelCustom10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelCustom10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonCustom3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonCustom4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addComponent(lb_iconTrash1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelCustom17, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13))
        );

        add(panelCustom10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Custom.ButtonCustom buttonCustom1;
    private Custom.ButtonCustom buttonCustom2;
    private Custom.ButtonCustom buttonCustom3;
    private Custom.ButtonCustom buttonCustom4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lb_iconTrash;
    private javax.swing.JLabel lb_iconTrash1;
    private Custom.PanelCustom panelCustom10;
    private Custom.PanelCustom panelCustom16;
    private Custom.PanelCustom panelCustom17;
    // End of variables declaration//GEN-END:variables
}
