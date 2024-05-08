/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom08.bookstore.Utils;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Admin
 */
public class ImageConverter {
    public static Image loadImage(String imagePath) {
        try {
            // Đọc tệp hình ảnh và tạo một BufferedImage
            BufferedImage bufferedImage = ImageIO.read(new File(imagePath));

            // Nếu bạn muốn thay đổi kích thước của hình ảnh, bạn có thể sử dụng getScaledInstance()
            int newWidth = 170; // Chiều rộng mới
            int newHeight = 150; // Chiều cao mới
            Image scaledImage = bufferedImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

            return scaledImage;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
