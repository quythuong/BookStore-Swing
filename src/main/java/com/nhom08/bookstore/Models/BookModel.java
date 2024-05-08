/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom08.bookstore.Models;

import java.awt.Image;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author quythuong
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BookModel {
	private String id;
	private String authorId;
	private String publisherId;
	private String name;
	private int quantity;
	private double price;
	private String type;
        private String image;

    public BookModel(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public BookModel(String id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
}
