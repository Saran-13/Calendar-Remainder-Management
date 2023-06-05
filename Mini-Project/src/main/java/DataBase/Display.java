package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



public class Display {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection can=DriverManager.getConnection("jdbc:mysql://localHost:3306/Calendar","root","Saran@123");
		Statement statement=can.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		String str="select * from Remainder";
		ResultSet res=statement.executeQuery(str);
		while(res.next()) {
			System.out.println(res.getInt("Date"));
		}	
	}
}
