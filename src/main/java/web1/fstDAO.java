package web1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class fstDAO {

	private static final String DB_NAME="com.mysql.cj.jdbc.Driver";
	private static final String DB_URL="jdbc:mysql://localhost:3306/mysqltut";
	private static final String DB_USER="root";
	private static final String DB_PASS="Kiran*123#";
	
	public void getdata(String name,String pass)throws Exception
	{
		
		Class.forName(DB_NAME);
		Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
		String sql="insert into Mydata values(?,?)";
		PreparedStatement pep = con.prepareStatement(sql);
		pep.setString(1, name);
		pep.setString(2, pass);
		int co = pep.executeUpdate();
		System.out.println("row effect"+co);
		con.close();
		
	}
	
	
}
