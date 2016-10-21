package com.poore;


import java.sql.ResultSet;
import java.util.ArrayList;


import com.opensymphony.xwork2.Action;
import com.poore.sql.Dao;



public class ListBook implements Action {
	
	private ArrayList<bookinfo> namelist;

	
	public ArrayList<bookinfo> getNamelist() {
		return namelist;
	}

	public void setNamelist(ArrayList<bookinfo> namelist) {
		this.namelist = namelist;
	}

	@Override
	public String execute() throws Exception {
		
		Dao dao = new Dao();
		ResultSet rs = dao.executeQuery(String.format("select * from book"));
		namelist = new ArrayList<bookinfo>();
		
		
		
		while(rs.next())
		{
				namelist.add(new bookinfo(rs.getString("title"), rs.getString("ISBN")));
				System.out.println(namelist.get(namelist.size()-1).name);
				System.out.println(namelist.get(namelist.size()-1).ISBN);
		}
		
		dao.close();
		return SUCCESS;
	}
}
