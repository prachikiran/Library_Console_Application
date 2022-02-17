import java.util.*;
import java.sql.*;

public class Library {

	Scanner s = new Scanner(System.in);
	public String username = "root";
	public String password = "root@123";
	public String url = "jdbc:mysql://localhost:3306/librarydatabase";

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
		System.out.print("Quantity: ");
		int quantity = s.nextInt();

		try {
			Connection conn = DriverManager.getConnection(url, username, password);
			String query = "INSERT INTO librarydatabase.library_operation (bookID,subject,title,author,publisher,edition,price,quantity) VALUES (?,?,?,?,?,?,?,?);";
			PreparedStatement pS = conn.prepareStatement(query);
			pS.setInt(1, bookID);
			pS.setString(2, subject);
			pS.setString(3, title);
			pS.setString(4, author);
			pS.setString(5, publisher);
			pS.setString(6, edition);
			pS.setDouble(7, price);
			pS.setInt(8, quantity);
			pS.execute();
			System.out.println("Inserted!");
		} catch (Exception e) {
			System.out.println("Connection failure");
		}
	}

	public void removeBook() {
		System.out.print("Enter Book ID:  ");
		int bookID = s.nextInt();
		try {
			Connection conn = DriverManager.getConnection(url, username, password);
			String sql = "DELETE from librarydatabase.library_operation where bookID = (?);";
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
			String query = "SELECT * FROM librarydatabase.library_operation;";
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				int bookID = rs.getInt("bookID");
				System.out.println("Book ID = " + bookID);
				String subject = rs.getString("subject");
				System.out.println("SUbject = " + subject);
				String title = rs.getString("title");
				System.out.println("Title= " + title);
				String author = rs.getString("author");
				System.out.println("Author = " + author);
				String publisher = rs.getString("publisher");
				System.out.println("Publisher= " + publisher);
				String edition = rs.getString("edition");
				System.out.println("Edition = " + edition);
				double cost = rs.getDouble("price");
				System.out.println("MRP = " + cost);
				int quantity = rs.getInt("quantity");
				System.out.println("Quantity = " + quantity);
				System.out.println();
			}

		} catch (Exception e) {
			System.out.println("Connection failure");
		}
	}

	public void issueBook() {

		System.out.print("Enter book ID: ");
		int book_ID = s.nextInt();
		System.out.print("Enter Issue Date: ");
		s.nextLine();
		String issueDate = s.nextLine();
		System.out.print("Enter Expiry Date: ");
		String expiryDate = s.nextLine();

		try {
			Connection conn = DriverManager.getConnection(url, username, password);
			Statement st = conn.createStatement();
			String query = "SELECT bookID FROM librarydatabase.library_operation;";
			ResultSet rs = st.executeQuery(query);
			rs.next();
			System.out.println("You have successfully issued the Book #" + book_ID + "!");
			}
			catch (Exception e) {
			System.out.println("Connection failure");
		}
	}
	public void returnBook() {
		System.out.print("Enter book ID: ");
		int book_ID = s.nextInt();
		System.out.print("Enter Issue Date: ");
		s.nextLine();
		String issueDate = s.nextLine();
		System.out.print("Enter Expiry Date: ");
		String expiryDate = s.nextLine();
		System.out.print("Enter Return Date: ");
		String returnDate = s.nextLine();

		try {
			Connection conn = DriverManager.getConnection(url, username, password);
			Statement st = conn.createStatement();
			String query = "SELECT bookID FROM librarydatabase.library_operation;";
			ResultSet rs = st.executeQuery(query);
			rs.next();
			System.out.println("Book #" + book_ID + " returned successfully on "+ returnDate + "!");
			}
			catch (Exception e) {
			System.out.println("Connection failure");
		}
	}
}