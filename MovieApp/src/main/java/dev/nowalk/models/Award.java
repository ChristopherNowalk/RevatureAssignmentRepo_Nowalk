package dev.nowalk.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="awards")
public class Award {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name", nullable = false)
	private String name;
	
	private int year;
	
	@ManyToOne
	@JoinColumn(name="winner")
	private Actor winner;

	
	public Award() {
		super();
	}

	public Award(int id, String name, int year, Actor winner) {
		super();
		this.id = id;
		this.name = name;
		this.year = year;
		this.winner = winner;
	}

	public Award(String name, int year, Actor winner) {
		super();
		this.name = name;
		this.year = year;
		this.winner = winner;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Actor getWinner() {
		return winner;
	}

	public void setWinner(Actor winner) {
		this.winner = winner;
	}

	@Override
	public String toString() {
		return "Award [id=" + id + ", name=" + name + ", year=" + year + ", winner=" + winner + "]";
	}
	
	
	
}
