package mvc.com.dao;

import java.sql.*;
import java.util.ArrayList;

import mvc.com.bean.UserBEAN;

public class UserDAO {
	PreparedStatement ps = null;
	Statement st = null;
	ResultSet rs = null;
	DBConnection db = new DBConnection();
	Connection con = db.db_connect();
	
	public String register(UserBEAN bean) {
		try {
			String query = "insert into users(first_name, last_name, username, password) values('"+bean.getFirst_name()+"', '"+bean.getLast_name()+"', '"+bean.getUsername()+"', '"+bean.getPassword()+"') ";
			System.out.println(query);
			System.out.println("success");
			ps = con.prepareStatement(query);
			if(ps.executeUpdate()!=0) {
				return "success";
			}
			con.close();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			e.printStackTrace();
		}
		return "failed";
	}

	public ArrayList<UserBEAN> getAll() {
		// TODO Auto-generated method stub
		ArrayList<UserBEAN> user = new ArrayList<UserBEAN>();
		try {
			String query = "select * from users";
			System.out.println(query);
			
			st = con.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()) {
				UserBEAN person = new UserBEAN();
				person.setId(rs.getInt(1));
				person.setFirst_name(rs.getString(2));
				person.setLast_name(rs.getString(3));
				person.setUsername(rs.getString(4));
				person.setPassword(rs.getString(5));
				user.add(person);
			}
			con.close();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			e.printStackTrace();
		}
		return user;
	}
	
	public String login(UserBEAN bean) {
		try {
			String query = "select * from users where username = '"+bean.getLoginusername()+"' and password = '"+bean.getLoginpassword()+"'";
			System.out.println(query);
			
			st = con.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()) {
				return "success";
			}
			con.close();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return "failed";
	}
	
	//edit
	public UserBEAN edit(String id) {
		UserBEAN user = new UserBEAN();
		try {
			String query = "select * from users where id = '"+id+"' ";
			System.out.println(query);
			st = con.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()) {
				user.setId(rs.getInt(1));
				user.setFirst_name(rs.getString(2));
				user.setLast_name(rs.getString(3));
				user.setUsername(rs.getString(4));
				user.setPassword(rs.getString(5));
			}
			con.close();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			e.printStackTrace();
		}
		return user;
	}
	
	//update
	public String update(UserBEAN bean) {
		try {
			String query = "update users set first_name = '"+bean.getFirst_name()+"', last_name = '"+bean.getLast_name()+"', username = '"+bean.getUsername()+"', password = '"+bean.getPassword()+"' where id = '"+bean.getId()+"' ";
			System.out.println(query);
			ps = con.prepareStatement(query);
			if(ps.executeUpdate()!=0) {
				return "success";
			}
			con.close();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			e.printStackTrace();
		}
		return "failed";
	}
	
	public String delete(String id) {
		try {
			String query = "delete from users where id = '"+id+"'";
			System.out.println(query);
			ps = con.prepareStatement(query);
			if(ps.executeUpdate()!=0) {
				return "success";
			}
			con.close();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			e.printStackTrace();
		}
		return "failed";
	}
}
