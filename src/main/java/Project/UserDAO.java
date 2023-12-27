package Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

	
	
	public boolean saveUser(String name,String mail,String pass,String Phno)throws Exception
	{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		connectionFact  co=connectionFact.getInstance();
	    Connection con = co.getConnection();
			 
		String sql="insert into UserData values(?,?,?,?)";
		PreparedStatement pep = con.prepareStatement(sql);
		pep.setString(1, name);
		pep.setString(2, mail);
		pep.setString(3, pass);
		pep.setString(4, Phno);
		
		int c = pep.executeUpdate();
		System.out.println("row effect"+c);
		con.close();
	    return true;
	}
	
	public boolean login(String mail,String pass) throws Exception{
	
       Class.forName("com.mysql.cj.jdbc.Driver");
		
		connectionFact  co=connectionFact.getInstance();
	    Connection con = co.getConnection();
		
		String sql="select Mail,password from UserData where Mail=? and password=?";
		PreparedStatement pep1 = con.prepareStatement(sql);
		pep1.setString(1,mail);
		pep1.setString(2,pass);
		boolean result=false;
		ResultSet res = pep1.executeQuery();
		boolean next = res.next();
		
		return next;
		
		
	}
	public String getName(String Mail)throws Exception
	
	{
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 connectionFact  co=connectionFact.getInstance();
		 Connection con = co.getConnection();
		 String sql="select name from UserData where Mail=?";
		 PreparedStatement pep = con.prepareStatement(sql);
		 pep.setString(1, Mail);
		 ResultSet res = pep.executeQuery();
		 String NAME="";
		  while(res.next())
		  {
		   
			  NAME=res.getString(1);
			  
		  }
		  return NAME;
		 
		
	}
	
}
