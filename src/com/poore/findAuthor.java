package com.poore;


import java.sql.ResultSet;
import java.util.ArrayList;


import com.opensymphony.xwork2.Action;
import com.poore.sql.Dao;

class bookinfo {
	String name;
	String ISBN;
	
	public bookinfo(String name, String iSBN) {
		super();
		this.name = name;
		ISBN = iSBN;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
}

public class findAuthor implements Action {
	
	private ArrayList<bookinfo> namelist;
	private String name;
	
	public String getName() {
		return name;
	}
	
	public ArrayList<bookinfo> getNamelist() {
		return namelist;
	}

	public void setNamelist(ArrayList<bookinfo> namelist) {
		this.namelist = namelist;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String execute() throws Exception {
		System.out.println("serch author:" + name);	
		if (name == null || name.length() == 0) {
			System.out.println("name ["+name+"] error");
			return "fail";
		}
		
		Dao dao = new Dao();
		ResultSet rs = dao.executeQuery(String.format("select authorID from author where name='%s'", name));
		namelist = new ArrayList<bookinfo>();
		
		ArrayList<Integer> authorid = new ArrayList<Integer>();
		
		while(rs.next()) {
			authorid.add(rs.getInt("authorID"));
		}
		for (int i = 0; i < authorid.size(); i++)
		{
//			System.out.println(rs.getString("name"));
			int authorID = authorid.get(i);
			ResultSet rs1 = dao.executeQuery(String.format("select title,ISBN from book where authorID='%d'", authorID));
			while(rs1.next()) {
				namelist.add(new bookinfo(rs1.getString("title"), rs1.getString("ISBN")));
				System.out.println(namelist.get(namelist.size()-1).name);
				System.out.println(namelist.get(namelist.size()-1).ISBN);
			}
		}
		

		dao.close();
		return SUCCESS;
	}
}
