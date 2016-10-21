package com.poore;

import java.sql.ResultSet;

import com.opensymphony.xwork2.Action;
import com.poore.model.Author;
import com.poore.model.Book;
import com.poore.sql.Dao;

public class findBook implements Action {
	
	Book bookinfo;
	Author authorinfo;
	String ISBN;

	public Author getAuthorinfo() {
		return authorinfo;
	}

	public void setAuthorinfo(Author authorinfo) {
		this.authorinfo = authorinfo;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public Book getBookinfo() {
		return bookinfo;
	}

	public void setBookinfo(Book bookinfo) {
		this.bookinfo = bookinfo;
	}


	@Override
	public String execute() throws Exception {
		
		if (ISBN == null || ISBN.length() <= 0) {
			System.out.println("ISBN error");
			return "fail";
		}
		
		Dao dao = new Dao();
		ResultSet rs = dao.executeQuery(String.format("select * from book where ISBN='%s'", ISBN));
		
		System.out.println("hahahahaha");
		
		if (rs.next()) {
			bookinfo = new Book(rs.getString("title"), 
							rs.getInt("authorID"), 
							rs.getString("publisher"), 
							rs.getInt("price"), 
							rs.getString("ISBN"), 
							rs.getDate("publishdate")
							);
			rs = dao.executeQuery(String.format("select * from author where authorID='%d'", bookinfo.getAuthorID()));
			
			if (rs.next()) {
				authorinfo = new Author(rs.getInt("authorID"), rs.getString("name"), rs.getInt("age"), rs.getString("country"));
			}
			else {
				System.out.println("author not found");
				return "fail";
			}
		}
		else {
			System.out.println("not found");
			return "fail";
		}
		return SUCCESS;
	}
}
