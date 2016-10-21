package com.poore;

import java.sql.Date;
import java.sql.ResultSet;

import com.opensymphony.xwork2.Action;
import com.poore.sql.Dao;

public class addBook implements Action {

	String title;
	int authorID;
	String publisher;
	int price;
	String ISBN;
	Date publishdate;

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

	public Date getPublishdate() {
		return publishdate;
	}

	public void setPublishdate(Date publishdate) {
		this.publishdate = publishdate;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub

		Dao dao = new Dao();

		System.out.println(ISBN);

		ResultSet rs = dao.executeQuery(String.format(
				"select * from book where ISBN='%s'", ISBN));

		if (rs.next()) {
			rs.close();
			dao.close();
			return "fail";
		} else {
			rs.close();
			System.out
					.println(String
							.format("insert into book values('%s',%d,'%s',%d,'%s','%s')",
									title, authorID, publisher, price, ISBN,
									(Date) publishdate));
			dao.execute(String
					.format("insert into book values('%s',%d,'%s',%d,'%s','%s')",
							title, authorID, publisher, price, ISBN,
							(Date) publishdate));
		}
		dao.close();
		return "success";
	}
}
