import java.util.*;
import java.sql.*;

public class Main {
	
	static Library library = new Library();
	static Scanner s = new Scanner(System.in);

	public static void main(String args[]) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		int choice;
		do {
			System.out.println("     HOME     ");
			System.out.println("1.View Library    ");
			System.out.println("2.Add Book");
			System.out.println("3.Remove Book");
			System.out.println("4.Issue");
			System.out.println("5.Return");
			System.out.println("0.EXIT");
			System.out.print("Enter your choice: ");
			choice = s.nextInt();
			System.out.println("");

			switch (choice) {
			case 1:
				library.display();
				break;
			case 2:
				library.addBook();
				break;
			case 3:
				library.removeBook();
				break;
			case 4:
				library.issueBook();
				break;
			case 5:
				library.returnBook();
				break;
			case 0:
				System.out.println("         Thank you! Visit Again..        ");
				break;
			default:
				System.out.println("Invalid Input! Please select from listed choices below.\n");
				break;
			}
		} while (choice != 0);
	}

}