package Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class GetRemainder extends baseClass 
{
	int count;
	int date;
	int month;
	int year;
	String message;
	SetRemainder [] remainder;
	Statement statement;
	Connection can;
	public GetRemainder(int count,SetRemainder [] remainder) {
		this.count=count;
		this.remainder=remainder;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			can=DriverManager.getConnection("jdbc:mysql://localHost:3306/Calendar","root","Saran@123");
			statement=can.createStatement();
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
	}
	public void display() {
		//System.out.println(count +"   Get Remainder");
		System.out.println("The Total Remainders are "+count);
		for(int i=0;i<count;i++) {
				System.out.println(remainder[i].date+" "+remainder[i].month+" "+remainder[i].year+" "+remainder[i].message+" ");
		}
	}
	public void dataBase() {
		String str="select * from Remainder";
		int count=0;
		try {
		ResultSet res=statement.executeQuery(str);
		while(res.next()) {
			System.out.print(res.getInt("date")+" ");
			System.out.print(res.getInt("month")+" ");
			System.out.print(res.getInt("year")+" ");
			System.out.print(res.getString("Remainder")+"\n");
			count++;
		}
		System.out.println("The total remainder in the database is "+count);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
