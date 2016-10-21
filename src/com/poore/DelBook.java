package com.poore;

import com.opensymphony.xwork2.Action;
import com.poore.sql.Dao;

public class DelBook implements Action {

	String ISBN;

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	@Override
	public String execute() throws Exception {

		if (ISBN == null || ISBN.length() <= 0) {
			System.out.println("ISBN error");
			return "fail";
		}
		Dao dao = new Dao();
		boolean rs = dao.execute(String.format(
				"delete from book where ISBN='%s'", ISBN));
		dao.close();
		System.out.println(rs);
		return SUCCESS;
	}
}
