package Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Pastday extends baseClass implements Calendar {
		int date;
		int month;
		int year;
		String day;
		int findyear;
		int count=0;
		Connection can;
		Statement statement;
		public Pastday(int date,int month,int year,String day,int findyear) {
			super.show();
			this.date=date;
			this.month=month;
			this.year=year;
			this.day=day;
			this.findyear=findyear;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				can=DriverManager.getConnection("jdbc:mysql://localHost:3306/Calendar","root","Saran@123");
				statement=can.createStatement();
				String data="INSERT INTO PastDay values('Before',"+date+","+month+","+year+",'Null')";
				statement.executeUpdate(data);
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
		}
		public void calculate() {
			// TODO Auto-generated method stub
			
			for(int i=year;i>=findyear;i--) {
				 if(i%4==0) {
					 if(i==year&&month<2||i==findyear&&month<2) {
						 count+=2;
					 }
					 else if(i==year&&month>2||i==findyear&&month>2) {				 
						 count+=1;
					 }
					 else {
						 count+=2;
					 } 
					}
				 else if(i==year) {
					 count=0;
				 }
				else {
					count+=1;
				}
			}
			//System.out.print("The difference between the years : "+count+"\n");
		}
		public String day(String day) {
			String [] str= {"Sunday","Monday","Tuesday","Wednesday",
					"thursday","Friday","Saturday"};
			count=count%7;
			String result=null;
			//System.out.print("The difference after the years after modulus with 7 : "+count+"\n");
			for(int j=0;j<str.length;j++) {
				if(str[j].equalsIgnoreCase(day)) {
					if(0<=j-count) {
						result=str[j-count];
					}
					else if(j-count==j) {
						result=str[j];
					}
					else if(j-count<0) {
						int counts=7+(j-count);
						result=str[counts];
					}
				}						
			}
			try {
				String data1="INSERT INTO PastDay values('After',"+date+","+month+","+findyear+",'"+result+"')";
				statement.executeUpdate(data1);
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
			return result;
		}
}
