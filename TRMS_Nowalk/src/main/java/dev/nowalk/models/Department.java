package dev.nowalk.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="departments")
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int d_id;
	
	@Column(name="name", nullable=false)
	private String name;
	@Column(name="dep_head")
	private int dep_head_id;
	
//	@OneToMany
//	private List<Employee> employees;
	
	public Department() {
		super();
	}

	public Department(int d_id, String name, int dep_head_id) {
		super();
		this.d_id = d_id;
		this.name = name;
		this.dep_head_id = dep_head_id;
	}

	public Department(String name, int dep_head_id) {
		super();
		this.name = name;
		this.dep_head_id = dep_head_id;
	}

	public int getD_id() {
		return d_id;
	}

	public void setD_id(int d_id) {
		this.d_id = d_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDep_head() {
		return dep_head_id;
	}

	public void setDep_head(int dep_head_id) {
		this.dep_head_id = dep_head_id;
	}

	@Override
	public String toString() {
		return "Department [d_id=" + d_id + ", name=" + name + ", dep_head=" + dep_head_id + "]";
	}
	
	
}
