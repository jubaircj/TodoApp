package mvc.com.dao;

import java.sql.*;

public class DBConnection {
	Connection con = null;
	public Connection db_connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			e.printStackTrace();
		}
		return con;
	}
}
