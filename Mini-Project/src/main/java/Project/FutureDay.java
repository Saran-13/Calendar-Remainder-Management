package Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class FutureDay extends baseClass implements Calendar  {
	int date;
	int month;
	int year;
	String day;
	int findyear;
	int count=0;
	Connection can;
	Statement statement;
	public FutureDay(int date,int month,int year,String day,int findyear) {
		super.show();
		this.date=date;
		this.month=month;
		this.year=year;
		this.findyear=findyear;
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		can=DriverManager.getConnection("jdbc:mysql://localHost:3306/Calendar","root","Saran@123");
		statement=can.createStatement();
		String data="INSERT INTO FutureDay values('Before',"+date+","+month+","+year+",'Null')";
		statement.executeUpdate(data);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void calculate() {	
		for(int i=year+1;i<=findyear;i++) {
			if(year==findyear) {
				System.out.println("The Day of "+date+" "+month+" "+year+" is "+day);
			}
			else if(i%4==0) {
				if(month<=2&&i==findyear) {
					count++;					
				}
				else {
					count+=2;
				}
			}
			else {
				count++;
			}
		}
	}	
	public String day(String day) {
		String [] str= {"Sunday","Monday","Tuesday","Wednesday",
				"thursday","Friday","Saturday"};
		count=count%7;
		String result=null;
		for(int j=0;j<str.length;j++) {
			if(str[j].equalsIgnoreCase(day)) {
				if(j+count<str.length) {
					result=str[j+count];
				}
				else if(j+count==str.length) {
					result=str[j+count];
				}
				else if(j+count>str.length) {
					int counts=((j+count)%7);
					result=str[counts];
				}
			}						
		}
		try {
		String data1="INSERT INTO FutureDay values('After',"+date+","+month+","+findyear+",'"+result+"')";
		statement.executeUpdate(data1);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	
 }
