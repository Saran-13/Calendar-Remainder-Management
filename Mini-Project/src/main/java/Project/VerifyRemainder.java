package Project;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class VerifyRemainder  {
	Scanner s=new Scanner(System.in);
	int variable;
	int count;
	SetRemainder [] remainder;
	int date;
	Connection can;
	Statement statement;
	int permit;
	public VerifyRemainder(int variable,SetRemainder[] remainder,int count) {
		this.variable=variable;
		this.remainder=remainder;
		this.count=count;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			can=DriverManager.getConnection("jdbc:mysql://localhost:3306/Calendar","root","Saran@123");
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void calculate() {
		//System.out.println("date");
		System.out.println("Press 1 to search in the console \n"
				+ "Press 2 to search in the DataBase");
		permit=s.nextInt();
		switch(permit) {
		case 1:{
			for(int  i=0;i<count;i++) {
				if(remainder[i].date==variable){
					System.out.println("The remainder of the given date is "+
				remainder[i].date+" "+remainder[i].month+" "+remainder[i].year+" is "+remainder[i].message);
				}
			}
		}break;
		case 2:{	
			try {
				PreparedStatement pred=can.prepareStatement("select * from Remainder where Date = ?");
				pred.setInt(1, variable);
				ResultSet res=pred.executeQuery();
				while(res.next()) {
					System.out.print(res.getInt("Date")+" ");
					System.out.print(res.getInt("Month")+" ");
					System.out.print(res.getInt("year")+" ");
					System.out.print(res.getString("Remainder")+"\n");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}break;
		default:
			System.out.println("Enter the Valid Option");
		}	
	}
	public void calculate1(int month) {
		
		System.out.println("Press 1 to search in the console \n"
				+ "Press 2 to search in the DataBase");
		permit=s.nextInt();
		switch(permit) {
		case 1:{
			for(int  i=0;i<count;i++) {
				
				if(remainder[i].month==variable){
					System.out.println("The remainder of the given date is "+
				remainder[i].date+" "+remainder[i].month+" "+remainder[i].year+" is "+remainder[i].message);
				}
			}
		}break;
		case 2:{
			try {
				PreparedStatement pred=can.prepareStatement("select * from Remainder where Month = ?");
				pred.setInt(1, variable);
				ResultSet res=pred.executeQuery();
				while(res.next()) {
					System.out.print(res.getInt("Date")+" ");
					System.out.print(res.getInt("Month")+" ");
					System.out.print(res.getInt("year")+" ");
					System.out.print(res.getString("Remainder")+"\n");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}break;
		default:
			System.out.println("Enter the valid option");
		}
		
	}
	public void calculate2(int year) {
		//System.out.println("Year");
		System.out.println("Press 1 to search in the console \n"
				+ "Press 2 to search in the DataBase");
		permit=s.nextInt();
		switch(permit) {
		case 1:{
			for(int  i=0;i<count;i++) {
				if(remainder[i].year==variable){
					System.out.println("The remainder of the given date is "+
				remainder[i].date+" "+remainder[i].month+" "+remainder[i].year+" is "+remainder[i].message);
				}
			}
		}break;
		case 2:{
			try {
				PreparedStatement pred=can.prepareStatement("select * from Remainder where Year = ?");
				pred.setInt(1, variable);
				ResultSet res=pred.executeQuery();
				while(res.next()) {
					System.out.print(res.getInt("Date")+" ");
					System.out.print(res.getInt("Month")+" ");
					System.out.print(res.getInt("year")+" ");
					System.out.print(res.getString("Remainder")+"\n");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}break;
		default:
			System.out.println("Enter the valid option");
		}
	}
}
