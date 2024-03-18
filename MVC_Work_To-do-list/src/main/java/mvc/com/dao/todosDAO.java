package mvc.com.dao;

import java.sql.*;
import java.util.ArrayList;

import mvc.com.bean.todosBEAN;

public class todosDAO {
	PreparedStatement ps = null;
	Statement st = null;
	ResultSet rs = null;
	DBConnection db = new DBConnection();
	Connection con = db.db_connect();
	
	public String insert(todosBEAN bean) {
		try {
			String query = "insert into todos(title, description, status, target_date) values('"+bean.getTitle()+"', '"+bean.getDescription()+"', '"+bean.getStatus()+"', '"+bean.getTarget_date()+"') ";
			System.out.println(query);
			ps = con.prepareStatement(query);
			if(ps.executeUpdate()!=0) {
				return "success";
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			e.printStackTrace();
		}
		return "failed";
	}
	
	public ArrayList<todosBEAN> getAll() {
		// TODO Auto-generated method stub
		ArrayList<todosBEAN> user = new ArrayList();
		try {
			String query = "select * from todos";
			System.out.println(query);
			st = con.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()) {
				todosBEAN person = new todosBEAN();
				person.setId(rs.getInt(1));
				person.setTitle(rs.getString(2));
				person.setDescription(rs.getString(3));
				person.setStatus(rs.getString(4));
				person.setTarget_date(rs.getDate("target_date").toLocalDate());
				user.add(person);
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			e.printStackTrace();
		}
		return user;
	}
	//edit
	public todosBEAN edit(String id) {
		todosBEAN user = new todosBEAN();
		try {
			String query = "select * from todos where id = '"+id+"' ";
			System.out.println(query);
			st = con.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()) {
				user.setId(rs.getInt(1));
				user.setTitle(rs.getString(2));
				user.setDescription(rs.getString(3));
				user.setStatus(rs.getString(4));
				user.setTarget_date(rs.getDate("target_date").toLocalDate());
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return user;
	}
	
	//update
	public String update(todosBEAN bean) {
		try {
			String query = "update todos set title = '"+bean.getTitle()+"', description = '"+bean.getDescription()+"', status = '"+bean.getStatus()+"', target_date = '"+bean.getTarget_date()+"' where id = '"+bean.getId()+"' ";
			System.out.println(query);
			ps = con.prepareStatement(query);
			if(ps.executeUpdate()!=0) {
				return "success";
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return "failed";
	}
	
	//delete
	public String delete(String id) {
		try {
			String query = "delete from todos where id = '"+id+"'";
			System.out.println(query);
			ps = con.prepareStatement(query);
			if(ps.executeUpdate()!=0) {
				return "success";
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			e.printStackTrace();
		}
		return "failed";
	}
}
