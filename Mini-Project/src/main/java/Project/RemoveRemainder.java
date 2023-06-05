package Project;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RemoveRemainder extends baseClass{
	Scanner s=new Scanner(System.in);
	int Date;
	int Month;
	int Year;
	int Count;
	SetRemainder [] remainder;
	Connection can;
	PreparedStatement statement;
	public RemoveRemainder(int date,int month,int year,SetRemainder [] remainder, int Count) {
		this.Date=date;
		this.Month=month;
		this.Year=year;
		this.remainder=remainder;
		this.Count=Count;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			can =DriverManager.getConnection("jdbc:mysql://localhost:3306/Calendar","root","Saran@123");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void display() {
		System.out.println("Press 1 to Delete in the console \n"
				+ "Press 2 to delete in the DataBase");
		int permit=s.nextInt();
		switch(permit) {
		case 1:{
			for(int i=0;i<Count;i++) {
				if(remainder[i].date==Date&&remainder[i].month==Month&&remainder[i].year==Year) {
					for(int j=i;j<Count-1;j++) {
						remainder[j].date=remainder[j+1].date;
						remainder[j].month=remainder[j+1].date;
						remainder[j].year=remainder[j+1].date;
						remainder[j].message=remainder[j+1].message;	
					}
					i--;
					Count-=1;
				}
		}
			System.out.println("Remainder message is removed ");
		}break;
		case 2:{
			try {
				PreparedStatement statement=can.prepareStatement("delete from remainder where Date=? AND Month=? AND Year=?");
				statement.setInt(1, Date);
				statement.setInt(2, Month);
				statement.setInt(3, Year);
				int res=statement.executeUpdate();
				if(res==1) {
					System.out.println("Remainder is Deleted");
				}
				else {
					System.out.println("Remainder is not Deleted");
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
