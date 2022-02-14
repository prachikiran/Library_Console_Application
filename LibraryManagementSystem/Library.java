import java.util.*;
import java.sql.*;

public class Library {

	Scanner s = new Scanner(System.in);
	ArrayList<BookStack> bookList = new ArrayList<>();
	public String username = "root";
	public String password = "root@123";
	public String url = "jdbc:mysql://localhost:3306/libraryDatabase";

	public void addBook() {

		System.out.print("Enter Book ID: ");
		int bookID = s.nextInt();
		s.nextLine();
		System.out.print("Subject: ");
		String subject = s.nextLine();
		System.out.print("Title: ");
		String title = s.nextLine();
		System.out.print("Author: ");
		String author = s.nextLine();
		System.out.print("Publisher: ");
		String publisher = s.nextLine();
		System.out.print("Edition: ");
		String edition = s.nextLine();
		System.out.print("Price: ");
		double price = s.nextInt();
		System.out.print("Availability: ");
		boolean availability = s.hasNext();

		try {
			Connection conn = DriverManager.getConnection(url, username, password);
			String query = "INSERT INTO librarydatabase.library_operation (bookID,subject,title,author,publisher,edition,price,availability) VALUES (?,?,?,?,?,?,?,?);";
			PreparedStatement pS = conn.prepareStatement(query);
			pS.setInt(1, bookID);
			pS.setString(2, subject);
			pS.setString(3, title);
			pS.setString(4, author);
			pS.setString(5, publisher);
			pS.setString(6, edition);
			pS.setDouble(7, price);
			pS.setBoolean(8, availability);
			pS.execute();
			System.out.println("Inserted!");
		} catch (Exception e) {
			System.out.println("Connection failure");
		}
	}

	public void removeBook() {
		System.out.print("Enter the book ID:  ");
		int bookID = s.nextInt();
		try {
			Connection conn = DriverManager.getConnection(url, username, password);
			String sql = "DELETE from libraryDatabase.library_operation where bookID = (?);";
			PreparedStatement pS = conn.prepareStatement(sql);
			pS.setInt(1, bookID);
			pS.execute();
			System.out.println("Deleted!");
		} catch (Exception e) {
			System.out.println("Connection failure");
		}

	}

	public void display() throws ClassNotFoundException, SQLException {
		try {
			Connection conn = DriverManager.getConnection(url, username, password);
			Statement st = conn.createStatement();
			String query = "SELECT * FROM libraryDatabase.library_operation";
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				System.out.println("ID= " + rs.getInt("bookID") + "  Title= "
						+ rs.getString("title") + "  Author= " + rs.getString("author")
						+ "  Publisher= " + rs.getInt("publisher") + "  Edition= "
						+ rs.getInt("edition") + "  MRP= " + rs.getString("price")
						+ "  Availability= " + rs.getInt("availability"));
				System.out.println();
			}

		} catch (Exception e) {
			System.out.println("Connection failure");
		}
	}

	public void issueBook() {
		System.out.println("Enter Your id:");
		int custID = s.nextInt();
		System.out.println("Enter your Name:  ");
		String cust_name = s.nextLine();
		System.out.print("Enter book id:");
		int bookID = s.nextInt();
		System.out.print("Enter Issued Date:");
		String issueDate = s.nextLine();
		System.out.print("Enter Expiry Date:");
		String expiryDate = s.nextLine();
		s.nextLine();

		try {
			Connection conn = DriverManager.getConnection(url, username, password);
			String query = "INSERT INTO librarydatabase.library_operation (bookID,subject,title,author,publisher,edition,price,availability) VALUES (?,?,?,?,?,?,?,?);";
			PreparedStatement pS = conn.prepareStatement(query);
			pS.setInt(1, custID);
			pS.setString(2, cust_name);
			pS.setInt(3, bookID);
			pS.setString(4, issueDate);
			pS.setString(5, expiryDate);
			pS.execute();
			System.out.println("You have successfully issued the Book!");
		} catch (Exception e) {
			System.out.println("Connection failure");
		}
	}

	public void returnBook() {
		System.out.print("Enter your id:");
		int custID = s.nextInt();
		System.out.print("\nEnter your Name: ");
		String cust_name = s.nextLine();
		System.out.print("Enter book ID:");
		int bookID = s.nextInt();
		System.out.print("Enter Issued Date:");
		String issueDate = s.nextLine();
		System.out.print("Enter Expiry Date:");
		String dueDate = s.nextLine();
		System.out.print("Enter Return Date:");
		String returnDate = s.nextLine();
		s.nextLine();

		try {
			Connection conn = DriverManager.getConnection(url, username, password);
			String query = "INSERT INTO librarydatabase.library_operation (bookID,subject,title,author,publisher,edition,price,availability) VALUES (?,?,?,?,?,?,?,?);";
			PreparedStatement pS = conn.prepareStatement(query);
			pS.setInt(1, custID);
			pS.setString(2, cust_name);
			pS.setInt(3, bookID);
			pS.setString(4, issueDate);
			pS.setString(5, dueDate);
			pS.setString(6, returnDate);
			pS.execute();
			System.out.println("Book returned Successfully!");
		} catch (Exception e) {
			System.out.println("Connection failure");
		}
	}
}