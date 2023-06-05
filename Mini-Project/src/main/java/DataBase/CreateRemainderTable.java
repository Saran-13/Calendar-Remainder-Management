package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateRemainderTable {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection can=DriverManager.getConnection("jdbc:mysql://localHost:3306/Calendar","root","Saran@123");
		Statement statement=can.createStatement();	
		String str="CREATE TABLE Remainder"+
		"(Date INTEGER,"
		+"Month INTEGER,"
		+"Year INTEGER,"
		+"Remainder VARCHAR(3000))";
		statement.execute(str);
	}

}
