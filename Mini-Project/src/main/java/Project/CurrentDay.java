package Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CurrentDay extends baseClass implements Calendar{
	int date;
	int month;
	int year;
	int total=0;
	Connection can;
	Statement statement;
	public CurrentDay(int date,int month,int year) {
		super.show();
		this.date=date;
		this.month=month;
		this.year=year;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			can=DriverManager.getConnection("jdbc:mysql://localHost:3306/Calendar","root","Saran@123");
			statement=can.createStatement();
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
	}
	public void calculate() {
		// TODO Auto-generated method stub
		//Step---1
		total=total+date;
		//step---2
		int mod=year%100;
		total=total+mod;
		//step---3
		total=total+(mod/4);
		//step---4
		switch(month) { //Adding according to month
		case 1:
			total+=0;
			break;
		case 2:
			total+=3;
			break;
		case 3:
			total+=3;
			break;
		case 4:
			total+=6;
			break;
		case 5:
			total+=1;
			break;
		case 6:
			total+=4;
			break;
		case 7:
			total+=6;
			break;
		case 8:
			total+=2;
			break;
		case 9:
			total+=5;
			break;
		case 10:
			total+=0;
			break;
		case 11:
			total+=3;
			break;
		case 12:
			total+=5;
			break;
		default :
			System.out.println("Please verify the Month you entered");
		}
		//step 5
		if(year>=2000&&year<=2099) {
			total+=6;
		}
		//step 6
		total=total%7;
	}
	public String day() {
		String result = str[total];
		try {
		String data="INSERT INTO CurrentDay values("+date+","+month+","+year+",'"+str[total]+"')";
		statement.executeUpdate(data);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
}
