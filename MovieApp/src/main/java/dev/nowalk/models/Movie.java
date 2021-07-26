package dev.nowalk.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//this is our data layer (we make our models here to represent our data)
//entity makrs a class as an entity by Hibernate and a table will be associated with it
@Entity
//table allows us to add more information to our table, but table doesnt mark this for a table representation in our DB
@Table(name="movies")
public class Movie {
	
	//field used to identify our objects with a unique identifier
	@Id
	@Column(name="m_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="title", nullable=false)
	private String title;
	
	@Column(name="price")
	private double price;
	
	@Column(name="available", columnDefinition="boolean")
	private boolean available;
	
	@Column(name="return_date")
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
