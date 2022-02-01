import java.util.*;
import java.sql.*;

public class Library
{
	Scanner s = new Scanner(System.in);
	ArrayList<BookStack> library = new ArrayList<>();

	public void addBook()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/lms_db","root","root");
	        String query="INSERT INTO `lms_db`.`lms_bookDetails`(`name`,`barcode`,`author`,`publication`,`publish_date`,`edition`,`cost`,`category`,`supplier`,`shelf_number`)VALUES(?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pS = conn.prepareStatement(query);
			System.out.println("\n\t\t\t\t\t\t Title: ");
			String name = s.next();
			pS.setString(1, name);
			System.out.println("\n\t\t\t\t\t\t Code: ");
			String barcode = s.next();
			pS.setString(2, barcode);
			System.out.println("\n\t\t\t\t\t\t Author: ");
			String author = s.next();
			pS.setString(3, author);
			System.out.println("\n\t\t\t\t\t\t Publication: ");
			String publication = s.next();
			pS.setString(4, publication);
			System.out.println("\n\t\t\t\t\t\t Publish Date: ");
			String publish_date = s.next();
			pS.setString(5, publish_date);
			System.out.println("\n\t\t\t\t\t\t Edition: ");
			String edition = s.next();
			pS.setString(6, edition);
			System.out.println("\n\t\t\t\t\t\t MRP: ");
			double cost = s.nextDouble();
			pS.setDouble(7, cost);
			System.out.println("\n\t\t\t\t\t\t Category: ");
			String category = s.next();
			pS.setString(8, category);
			System.out.println("\n\t\t\t\t\t\t SUPPLIER_ID:(S##)");
			String supplier = s.next();
			pS.setString(9, supplier);
			System.out.println("\n\t\t\t\t\t\t Shelf Number: ");
			int shelf_number = s.nextInt();
			pS.setInt(0, shelf_number);
			
			BookStack book = new BookStack( name, barcode, author, publication, publish_date, edition, cost, category, supplier, shelf_number);
			library.add(book);
			pS.execute();
			conn.close();
		}
		catch(Exception exc)
		{
			exc.printStackTrace();
		}
	}

	public void removeBook()
	{
		System.out.print("\n\t\t\t\t\t\t Enter book BOOK_CODE:BL######");
		String code = s.next();
		for (int i = 0; i < library.size(); i++)
		{
			BookStack tempBook = library.get(i);
			if(tempBook.getCode()==code)
			{
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					java.sql.Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/lms_db","root","root");
					String query="DELETE FROM `lms_db`.`lms_bookDetails`WHERE book code=?";
					PreparedStatement pS = conn.prepareStatement(query);
					pS.setString (1, code);
					conn.close();
				}
				catch(Exception exc)
				{
					exc.printStackTrace();
				}
				library.remove(i);
				System.out.println("\n\t\t\t\t\t\t Book #" + code + " Removed Successfully");
			}
			else
				System.out.println("\n\t\t\t\t\t\tInvalid Input!");
		}
	}

	public void displayLibrary()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		    java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms_db","root","root");
		    Statement st = conn.createStatement();
		    ResultSet rs = st.executeQuery("SELECT * FROM lms_db.lms_bookDetails;");
		    rs.next();
			while(rs.next())
			{
				int bookEdition=rs.getInt("Edition");
				String bookName = rs.getString("Title");
				System.out.println(bookName+""+ bookEdition);
			}
			st.close();
			conn.close();
		}

		catch(Exception exc)
		{
			exc.printStackTrace();
		}
		System.out.println("\n\t\t\t                   Library                ");
		for (int i = 0; i < library.size(); i++)
		{
			BookStack temp = library.get(i);
			System.out.println(temp.toString());
		}
	}

	public void issueBook()
	{
		System.out.print("\n\t\t\t\t\t\t Enter book BOOK_CODE:#");
		String code = s.next();
		System.out.print("\n\t\t\t\t\t\t Enter your Name -  ");
		String name = s.nextLine();
		for (int i = 0; i < library.size(); i++)
		{
			BookStack temp = library.get(i);
			if(temp.getCode()==code)
			{
				String title = temp.getCode();
				System.out.println("\n\t\t\t\t\t\t Book ["+title+"] issued to [" +name+ "] successfully");
			}
			else
			{
				System.out.println("\n\t\t\t\t\t\t Invalid Input");
			}
		}
	}

	public void returnBook()
	{
		System.out.print("\n\t\t\t\t\t\t Enter book BOOK_CODE:");
		String code = s.next();
		s.nextLine();
		System.out.print("\n\t\t\t\t\t\tEnter your Name -  ");
		String name = s.nextLine();
		for (int i = 0; i < library.size(); i++)
		{
			BookStack temp = library.get(i);
			
		}
	}
}