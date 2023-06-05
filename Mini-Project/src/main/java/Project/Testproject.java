package Project;
import java.util.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.sql.ResultSet;
public class Testproject {
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.out.println("**************************** Welcome ****************************");
		Scanner s=new Scanner(System.in);
		char ch;
		int count=0;
		SetRemainder [] remainder=new SetRemainder[300];
		do {
			int options;
			System.out.println("Press 1 if you want to predict the future day :\n"
					+ "Press 2 if you want to predict the past day : \n"
					+ "Press 3 if you want to see the current day :\n"
					+ "Press 4 to set a reaminder in the Calendar \n"
					+ "Press 5 to view all the remainder in the Calendar  \n"
					+ "Press 6 to search for a remainder in the Calender \n"
					+ "Press 7 to remove a remainder from Calendar");
			options=s.nextInt();
				switch(options) {
				case 1:
				{
					System.out.print("Enter the date : ");int date=s.nextInt();
					System.out.print("Enter the month : ");int month=s.nextInt();
					System.out.print("Enter the year : ");int year=s.nextInt();
					System.out.print("Enter the day : ");String day=s.next();
					System.out.print("Enter the year to find : ");int findyear=s.nextInt();
					if(date!=0&&month!=0&&year!=0&&day!=null) {
						FutureDay future=new FutureDay(date,month,year,day,findyear);
						future.calculate();
						String Ans=future.day(day);
						System.out.println("The day of "+date+" "+month+" "+findyear+" is "+Ans);
						future.show();
					}
					else {
						System.err.println("Enter the valid inputs");
					}
				    //System.out.print("Enter y or Y to continue : ");
				}break;
				case 2:
				{
					System.out.print("Enter the date : ");int date=s.nextInt();
					System.out.print("Enter the month : ");int month=s.nextInt();
					System.out.print("Enter the year : ");int year=s.nextInt();
					System.out.print("Enter the day : ");String day=s.next();
					System.out.print("Enter the year to find : ");int findyear=s.nextInt();
					if(date!=0&&month!=0&&year!=0&&day!=null&&month<=12) {
						Pastday past=new Pastday(date,month,year,day,findyear);
						past.calculate();
						String ans=past.day(day);
						System.out.println("The day of "+date+" "+month+" "+findyear+" is "+ans);
					}
					else {
						System.out.println("Enter the valid inputs ");
					}
				}
				break;
				case 3:
				{
					System.out.print("Enter the date : ");int date=s.nextInt();
					System.out.print("Enter the month : ");int month=s.nextInt();
					System.out.print("Enter the year : ");int year=s.nextInt();
					if(date!=0&&month!=0&&year!=0&&month<=12) {
						CurrentDay current=new CurrentDay(date,month,year);
						current.calculate();
						String ans=current.day();
						System.out.println("The day of the given "+date+" "+month+" "+year+" is "+ans);
					}
				}break;
				case 4:
				{
					do {
						System.out.print("Enter the date : ");int date=s.nextInt();
						System.out.print("Enter the month : ");int month=s.nextInt();
						System.out.print("Enter the year : ");int year=s.nextInt();
						s.nextLine();
						System.out.print("Enter the remainder : ");String message=s.nextLine();
						if(date!=0&&month!=0&&year!=0&&month<=12&&message!=null) {
							 remainder[count]=new SetRemainder(date,month,year,message,count);
							 System.out.println("Remainder Added");
						}
						else {
							System.out.println("Enter the  valid inputs");
						}
						count+=1;
						
						System.out.print("Enter y or Y to continue if you want add another remainder ");						
						ch=s.next().charAt(0);
					}while(ch =='Y'||ch=='y');
					}break;
				case 5:
				{
					GetRemainder getremainder=new GetRemainder(count,remainder);
					System.out.println("Press 1 to view all the reamainder in console\n"
							+ "Press 2 to view all the Remainder in Databade");
					int remin=s.nextInt();
					switch(remin) {
					case 1:{
						getremainder.display();	
					}break;
					case 2:{
						getremainder.dataBase();
					}break;
					}	
				}break;
				case 6:
				{
					System.out.println("Enter 1 to check the Remainder based on Date \n"
							+ "Enter 2 to check the Remainder based on Month \n"
							+ "Enter 3 to check the Remainder based on Year \n");
					int option=s.nextInt();
					switch(option) {
					case 1:{
						System.out.print("Enter the Date : ");int date=s.nextInt();
						VerifyRemainder verify =new VerifyRemainder(date,remainder,count); 
						verify.calculate();
					}break;
					case 2:
					{
						System.out.print("Enter the Month : ");int month=s.nextInt();
						VerifyRemainder verify1=new VerifyRemainder(month,remainder,count);
						verify1.calculate1(month);
					}break;
					case 3:
					{
						System.out.print("Enter the Year : ");int year=s.nextInt();
						VerifyRemainder verify2=new VerifyRemainder(year,remainder,count);
						verify2.calculate2(year);
					}break;
					default:
						System.out.println("Enter the Valid Options ");
					}
				}break;
				case 7:
				{	
					System.out.print("Enter the Date : ");int date=s.nextInt();
					System.out.print("Enter the Month : ");int month=s.nextInt();
					System.out.print("Enter the Year : ");int year=s.nextInt();
					RemoveRemainder remove=new RemoveRemainder(date,month,year,remainder,count);
					remove.display();
					count-=1;
				}break;
				default:
					System.out.println("Enter the valid options");
					
				}
				System.out.print("Enter y or Y to continue : ");
				ch=s.next().charAt(0);
				}while(ch =='Y'||ch=='y');
					System.out.println("\n"+"**************************** Thank You ****************************");
		}
	}

