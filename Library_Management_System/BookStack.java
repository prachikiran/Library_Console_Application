import java.util.*

public class BookStack {

	private String name;
	private String barcode;
	private String author;
	private String publication;
	private String publish_date;
	private String edition;
	private double cost;
	private String category;
	private String supplier;
	private int shelf_number;
	
	public BookStack(String name, String barcode, String author, String publication, String publish_date2, String edition, double cost, String category, String supplier, int shelf_number) 
	{
		this.name = name;
		this.barcode = barcode;
		this.author= author;
		this.publication = publication;
		this.publish_date = publish_date2;
		this.edition = edition;
		this.cost = cost;
		this.category = category;
		this.shelf_number = shelf_number;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getCode()
	{
		return barcode;
	}
	
	public String getAuthor()
	{
		return author;
	}
	
	public String getPublication()
	{
		return publication;
	}
	
	public String getPublishDate()
	{
		return publish_date;
	}
	
	public String getEdition()
	{
		return edition;
	}
	
	public Double getCost()
	{
		return cost;
	}
	
	public String getCategory()
	{
		return category;
	}
	
	public String getSupplier()
	{
		return supplier;
	}
	
	public int getShelfNumber()
	{
		return shelf_number;
	}
}