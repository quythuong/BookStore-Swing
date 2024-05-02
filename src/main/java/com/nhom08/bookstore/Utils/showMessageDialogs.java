/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom08.bookstore.Utils;

import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class showMessageDialogs {
    public boolean saveMessage(String name){
        int dialogResult = JOptionPane.showConfirmDialog(null, String.format("Are you sure to add a new %s?", name), "Warning", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean editMessage(){
        int dialogResult = JOptionPane.showConfirmDialog(null, String.format("Are you sure to save your change?"), "Warning", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean deleteMessage(String name){
        int dialogResult = JOptionPane.showConfirmDialog(null, String.format("Do you want to delete this %s?", name), "Warning", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            return true;
        } else {
            return false;
        }
    }
}
