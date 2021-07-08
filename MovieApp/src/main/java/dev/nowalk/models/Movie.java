package dev.nowalk.models;
//this is our data layer (we make our models here to represent our data)
public class Movie {
	
	//field used to identify our objects with a unique identifier
	private int id;
	private String title;
	private double price;
	private boolean available;
	private long returnDate;
	
	//no arguments constructor
	public Movie() {
		super();
	}

	//full arguments constructor
	public Movie(int id, String title, double price, boolean available, long returnDate) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
		this.available = available;
		this.returnDate = returnDate;
	}
	//Ryan likes to add this one because we might commonly want it
	//this is what we might call an id-less constructor, because when we do a POST request, the id probably wont be known in the POST request
	public Movie(String title, double price, boolean available, long returnDate) {
		super();
		this.title = title;
		this.price = price;
		this.available = available;
		this.returnDate = returnDate;
	}

	//getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public long getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(long returnDate) {
		this.returnDate = returnDate;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", price=" + price + ", available=" + available
				+ ", returnDate=" + returnDate + "]";
	}
	
	
	
}
