/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom08.bookstore.Utils;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Admin
 */
public class changeIconSize {

    public void setIconWithSize(JLabel label, String iconUrl, int width, int height) {
        try {
            // url = "/images/Login Background1280_800.png"
            ImageIcon icon = new javax.swing.ImageIcon(getClass().getResource(iconUrl));
            Image img = icon.getImage();
            Image scale = img.getScaledInstance(width, height, Image.SCALE_DEFAULT);
            ImageIcon scaleicon = new ImageIcon(scale);
            label.setIcon(scaleicon);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Custom Label Icon Size");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                JLabel label = new JLabel();

                changeIconSize c = new changeIconSize();
                // Thay đổi kích thước icon của JLabel
                c.setIconWithSize(label, "/icons/save.png", 30, 30);

                frame.getContentPane().add(label);
                frame.pack();
                frame.setVisible(true);
            }
        });

    }
}
