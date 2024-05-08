/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.nhom08.bookstore.GUI.FunctionalPanels;

import com.nhom08.bookstore.Models.BookModel;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.text.DecimalFormat;
/**
 *
 * @author Admin
 */
public class Panel_BookItem extends javax.swing.JPanel {

    /**
     * @return the selected
     */
    public boolean isSelected() {
        return selected;
    }

    /**
     * @param selected the selected to set
     */
    public void setSelected(boolean selected) {
        this.selected = selected;
        repaint();
    }

    /**
     * @return the data
     */
    public BookModel getData() {
        return data;
    }

    private boolean selected;
    
    public Panel_BookItem() {
        initComponents();
        setOpaque(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        lbl_masach.setVisible(false);
    }

    private BookModel data;
    
    public void setData(BookModel data){
        this.data = data;
        //pictureBook.setImage(data.getImage());
        lbl_masach.setText(data.getId());
        lbl_bookName.setText(data.getName());
        lbl_quantity.setText(String.valueOf(data.getQuantity()));
        DecimalFormat df = new DecimalFormat("#,### VNĐ");
        lbl_price.setText(df.format(data.getPrice()));
        
    }
    
    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(242,242,242));
        g2.fillRoundRect(0,0,getWidth(),getHeight(),20,20);
        if(isSelected()){
            g2.setColor(new Color(94,156,255));
            g2.drawRoundRect(0,0,getWidth()-1,getHeight()-1,20,20);
        }
        g2.dispose();
        super.paint(g); 
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_bookName = new javax.swing.JLabel();
        lbl_quantity = new javax.swing.JLabel();
        lbl_price = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        pictureBook = new Custom.PictureBox();
        lbl_masach = new javax.swing.JLabel();

        setBackground(new java.awt.Color(243, 243, 243));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_bookName.setFont(new java.awt.Font("Lexend", 0, 15)); // NOI18N
        lbl_bookName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_bookName.setText("Tên sách");
        add(lbl_bookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 177, 175, 60));

        lbl_quantity.setFont(new java.awt.Font("Lexend", 0, 15)); // NOI18N
        lbl_quantity.setText("xx xxx");
        add(lbl_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 248, -1, -1));

        lbl_price.setFont(new java.awt.Font("Lexend", 0, 15)); // NOI18N
        lbl_price.setText("xxx.xxx.xxx VND");
        add(lbl_price, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 270, -1, -1));

        jLabel41.setFont(new java.awt.Font("Lexend", 0, 15)); // NOI18N
        jLabel41.setText("Quantity:");
        add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 248, -1, -1));

        jLabel42.setFont(new java.awt.Font("Lexend", 0, 15)); // NOI18N
        jLabel42.setText("Price:");
        add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 270, -1, -1));

        pictureBook.setImage(new javax.swing.ImageIcon(getClass().getResource("/images/Home - Bookimage550-550.png"))); // NOI18N
        add(pictureBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 170, 150));

        lbl_masach.setText("jLabel1");
        add(lbl_masach, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, -1, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel lbl_bookName;
    private javax.swing.JLabel lbl_masach;
    private javax.swing.JLabel lbl_price;
    private javax.swing.JLabel lbl_quantity;
    private Custom.PictureBox pictureBook;
    // End of variables declaration//GEN-END:variables

    
}
