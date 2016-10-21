package com.poore;

import java.sql.ResultSet;

import com.opensymphony.xwork2.Action;
import com.poore.model.Author;
import com.poore.sql.Dao;

public class saAuthorID implements Action {
	Author authorinfo;
	int authorID;

	public int getAuthorID() {
		return authorID;
	}

	public void setAuthorID(int authorID) {
		this.authorID = authorID;
	}

	public Author getAuthorinfo() {
		return authorinfo;
	}

	public void setAuthorinfo(Author authorinfo) {
		this.authorinfo = authorinfo;
	}

	@Override
	public String execute() throws Exception {

		if (authorID < 0) {
			System.out.println("authorID error");
			return "fail";
		}

		Dao dao = new Dao();
		ResultSet rs = dao.executeQuery(String.format(
				"select * from author where authorID='%s'", authorID));

		System.out.println("hahahahaha");

		if (rs.next()) {
			authorinfo = new Author(rs.getInt("authorID"),
					rs.getString("name"), rs.getInt("age"),
					rs.getString("country"));
			dao.close();
			return "found";
		}
		else {
			System.out.println("author not found");
			dao.close();
			return "notfound";
		}
	}
}
