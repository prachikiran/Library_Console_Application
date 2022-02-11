import java.util.*;
import java.sql.*;

public class Library {

	Scanner s = new Scanner(System.in);
	ArrayList<BookStack> bookList = new ArrayList<>();
	public String user = "root";
	public String password = "root@123";
	public String url = "jdbc:mysql://localhost:3306/library_schema";

	public void addBook() {

		System.out.println("Book Id: ");
		int bookId = s.nextInt();
		s.nextLine();
		System.out.println("Subject: ");
		String subject = s.nextLine();
		System.out.println("Title: ");
		String title = s.nextLine();
		System.out.println("Author: ");
		String author = s.nextLine();
		System.out.println("Publisher: ");
		String publisher = s.nextLine();
		System.out.print("Edition: ");
		int edition = s.nextInt();
		System.out.println("Price: ");
		double price = s.nextInt();
		System.out.println("Availability: ");
		boolean availability = s.hasNext();

		try {
			Connection conn = DriverManager.getConnection(url, user, password);
			Statement st = conn.createStatement();
			String sql = "insert into  library_schema.library_table (Book_id,Title,Author,Cost,Quantity)values(?,?,?,?,?);";
			PreparedStatement pS = conn.prepareStatement(sql);
			pS.setInt(1, bookId);
			pS.setString(2, subject);
			pS.setString(3, title);
			pS.setString(4, author);
			pS.setString(5, publisher);
			pS.setInt(6, edition);
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
		int id = s.nextInt();
		try {
			Connection conn = DriverManager.getConnection(url, user, password);
			Statement st = conn.createStatement();
			String sql = "delete from library_schema.library_table where Book_id = (?);";
			PreparedStatement pS = conn.prepareStatement(sql);
			pS.setInt(1, id);
			pS.execute();
			System.out.println("Deleted!");
		} catch (Exception e) {
			System.out.println("Connection failure");
		}

	}

	public void showLibrary() throws ClassNotFoundException, SQLException {
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM library_schema.library_table;");
			while (rs.next()) {
				System.out.println("ID= " + rs.getInt("Book_id") + "  Title= "
						+ rs.getString("Title") + "  Author= " + rs.getString("Author") + "  Cost= "
						+ rs.getString("Cost") + "  Quantity= " + rs.getInt("Quantity"));
				System.out.println();
			}

		} catch (Exception e) {
			System.out.println("Connection failure");
		}
	}

	public void issueBook() {
		System.out.println("Enter Your id:");
		int cust_id = s.nextInt();
		System.out.print("Enter book id:");
		int id = s.nextInt();
		s.nextLine();
		System.out.print("\nEnter your Name -  ");
		String name = s.nextLine();

		try {
			Connection con = DriverManager.getConnection(url, user, password);
			Statement st = con.createStatement();
			String sql = "insert into  library_schema.issued_book(Cust_id,Book_id,Student_name,Issued_date,Expiry_date)values(?,?,?,CURDATE(),CURDATE());";
			PreparedStatement preparedStmt = con.prepareStatement(sql);
			preparedStmt.setInt(1, cust_id);
			preparedStmt.setInt(2, id);
			preparedStmt.setString(3, name);
			preparedStmt.execute();
			System.out.println("Your Book Issued Successfully!");
		} catch (Exception e) {
			System.out.println("Connection failure");
		}
	}

	public void returnBook() {
		System.out.print("Enter your id:");
		int cust_id = sc.nextInt();
		System.out.print("Enter book id:");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.print("\nEnter your Name -  ");
		String name = sc.nextLine();
		System.out.print("\nEnter Book Name -  ");
		String title = sc.nextLine();

		try {
			Connection con = DriverManager.getConnection(url, user, password);
			Statement st = con.createStatement();
			String sql = "insert into  library_schema.return_books(Cust_id,Book_id,Stu_name,Title)values(?,?,?,?);";
			PreparedStatement preparedStmt = con.prepareStatement(sql);
			preparedStmt.setInt(1, cust_id);
			preparedStmt.setInt(2, id);
			preparedStmt.setString(3, name);
			preparedStmt.setString(4, title);
			preparedStmt.execute();
			System.out.println(" Your Book Issued Successfully!");
		} catch (Exception e) {
			System.out.println("Connection failure");
		}
	}
}