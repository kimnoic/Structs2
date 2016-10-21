package com.poore;


import com.opensymphony.xwork2.Action;

public class toaddBook implements Action {
	
	int authorID;
	
	public int getAuthorID() {
		return authorID;
	}

	public void setAuthorID(int authorID) {
		this.authorID = authorID;
	}

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
}
