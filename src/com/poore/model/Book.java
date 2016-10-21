package com.poore.model;

import java.util.Date;

public class Book {
	private String title;
	private int authorID;
	private String publisher;
	private int price;
	private String ISBN;
	private Date publiDate;
	public Book(String title, int authorID, String publisher, int price,
			String iSBN, Date publiDate) {
		System.out.println("befor init");
		this.title = title;
		this.authorID = authorID;
		this.publisher = publisher;
		this.price = price;
		this.ISBN = iSBN;
		this.publiDate = publiDate;
		System.out.println("after init");
		System.out.println(title+authorID+publisher+price+ISBN+publiDate);
	}
 
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getAuthorID() {
		return authorID;
	}
	public void setAuthorID(int authorID) {
		this.authorID = authorID;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public Date getPubliDate() {
		return publiDate;
	}
	public void setPubliDate(Date publiDate) {
		this.publiDate = publiDate;
	}
	
}
