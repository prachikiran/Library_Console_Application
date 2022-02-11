public class BookStack {

	private int bookID;
	private String subject;
	private String title;
	private String author;
	private String publisher;
	private int copyright;
	private int edition;
	private String ISBN;
	private boolean availability;

	public BookStack() {
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

	public int getCopyright() {
		return copyright;
	}

	public int getEdition() {
		return edition;
	}
	
	public String getISBN() {
		return ISBN;
	}

	public boolean getAvailability() {
		return availability;
	}
}