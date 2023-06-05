package Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SetRemainder extends baseClass{
	int date;
	int month;
	int year;
	String message;
	Connection can;
	Statement statement;
	public SetRemainder(int dates,int month,int year,String message,int count) {
		super.show();
		this.date=dates;
		this.month=month;
		this.year=year;
		this.message=message;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			can=DriverManager.getConnection("jdbc:mysql://localHost:3306/Calendar","root","Saran@123");
			statement=can.createStatement();
			String data="INSERT INTO Remainder values("+dates+","+month+","+year+",'"+message+"')";
			statement.executeUpdate(data);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
	}	
}
