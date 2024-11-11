package lms;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;
public class MainProg {
	static LeaveDetailsBal bal = new LeaveDetailsBal();
	static Scanner sc = new Scanner(System.in);
	
	public static void showLeaveDetails() {
		List<LeaveDetails> leaveDetails = bal.showLeaveBal();
		for (LeaveDetails ld : leaveDetails) {
			System.out.println(ld);
		}
	}
	public static void addLeaveDetails() throws ParseException, LeaveDetailsException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		LeaveDetails leaveDetails = new LeaveDetails();
		System.out.println("Enter Employ Id  ");
		leaveDetails.setEmpId(sc.nextInt());
		System.out.println("Enter Leave-StartDate (yyyy-MM-dd)  ");
		leaveDetails.setLeaveStartDate(sdf.parse(sc.next()));
		System.out.println("Enter Leave-EndDate  (yyyy-MM-dd)  ");
		leaveDetails.setLeaveEndDate(sdf.parse(sc.next()));
		System.out.println("Enter LeaveType (EL/PL/ML)  ");
		leaveDetails.setLeaveType(sc.next());
		System.out.println(bal.applyLeaveBal(leaveDetails));
	}
	public static void main(String[] args) {
		int choice;
		do {
			System.out.println("O P T I O N S");
			System.out.println("--------------");
			System.out.println("1. Apply Leave ");
			System.out.println("2. Show Leave ");
			System.out.println("Enter Your Choice   ");
			choice = sc.nextInt();
			switch(choice) {
			case 1 : 
				try {
					addLeaveDetails();
				} catch (ParseException | LeaveDetailsException e) {
					e.printStackTrace();
				}
				break;
			case 2 : 
				showLeaveDetails();
				break;
			case 6 : 
				return;
			}
		}while(choice!=6);
	}


}
