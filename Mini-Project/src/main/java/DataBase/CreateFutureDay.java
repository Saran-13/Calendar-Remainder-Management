package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateFutureDay {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection can=DriverManager.getConnection("jdbc:mysql://localHost:3306/Calendar","root","Saran@123");
		Statement statement=can.createStatement();	
		String str1="CREATE TABLE FutureDay"+
				"(State VARCHAR(30),"
				+"Date INTEGER,"
				+"Month INTEGER,"
				+"Year INTEGER,"+
				"Day VARCHAR(300))";
		statement.execute(str1);
	}

}
