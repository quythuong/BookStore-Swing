/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom08.bookstore.Models;

import java.awt.Image;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
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
	private Image image;
}
