package EBS;

import java.sql.*;

public class conn {
	Connection con;
	Statement s;
	public conn() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://ebs","root","root");
			s=con.createStatement();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
}
