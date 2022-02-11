public class BookStack {

	private int bookID;
	private String subject;
	private String title;
	private String author;
	private String publisher;
	private int edition;
	private double price;
	private boolean availability;

	public BookStack(int bookID, String subject, String title, String author, String publisher, int edition, double price, boolean availability) {
		
		this.bookID = bookID;
		this.subject = subject;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.edition = edition;
		this.price = price;
		this.availability = availability;
	}

	public int getBookID() {
		return bookID;
	}

	public String getSubject() {
		return subject;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getPublisher() {
		return publisher;
	}

	public int getEdition() {
		return edition;
	}
	
	public double getPrice() {
		return price;
	}

	public boolean getAvailability() {
		return availability;
	}
	
	public String printDetails() {
		return "Book ID: " + bookID + "Subject: " + subject + "Title: " + title + "Author: " + author + "Publisher: " + publisher + "Edition: " + edition + "Price: " + price;
	}
}