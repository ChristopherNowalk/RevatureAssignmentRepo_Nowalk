package dev.nowalk.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="employees")
public class Employee{
	
	@Id
	@Column(name="e_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int e_id;
	
	@Column(name="username", nullable = false)
	private String username;
	@Column(name="password", nullable = false)
	private String password;
	@Column(name="name", nullable = false)
	private String name;
	@Column(name="email")
	private String email;
	@Column(name="available_funds")
	private double available_funds;
	//these fields I think will be set somewhere else, an employee shouldn't have to rely on having a department
	@Column(name="super_id")
	private int super_id;
	@Column(name="ben_co_id")
	private int ben_co_id;
	@ManyToOne
	@JoinColumn(name="department")
	private Department dep;
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name="requests")
	private List<Request> requests;	
//	@Column(name="supervised_employees")
//	@ElementCollection(targetClass=Integer.class)
//	private List<Integer> supervised_employees;
	@Column(name="is_ben_co")
	private boolean is_ben_co;
	
	//now each employee will have a list of other employees that they supervise, and each employee 
	//will also have a boolean which denotes whether or not they are a benCo or not, this will
	//allow them to view the other employees they manage
	
	public Employee() {
		super();
	}

	public Employee(int e_id, String username, String password, String name, String email, double available_funds,
			int super_id, int ben_co_id, Department dep, List<Request> requests,
			boolean is_ben_co) {
		super();
		this.e_id = e_id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		this.available_funds = available_funds;
		this.super_id = super_id;
		this.ben_co_id = ben_co_id;
		this.dep = dep;
		this.requests = requests;
		this.is_ben_co = is_ben_co;
	}

	public Employee(String username, String password, String name, String email, double available_funds, int super_id,
			int ben_co_id, Department dep, List<Request> requests,
			boolean is_ben_co) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		this.available_funds = available_funds;
		this.super_id = super_id;
		this.ben_co_id = ben_co_id;
		this.dep = dep;
		this.requests = requests;
		this.is_ben_co = is_ben_co;
	}

	public int getE_id() {
		return e_id;
	}

	public void setE_id(int e_id) {
		this.e_id = e_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getAvailable_funds() {
		return available_funds;
	}

	public void setAvailable_funds(double available_funds) {
		this.available_funds = available_funds;
	}

	public int getSuper_id() {
		return super_id;
	}

	public void setSuper_id(int super_id) {
		this.super_id = super_id;
	}

	public int getBen_co_id() {
		return ben_co_id;
	}

	public void setBen_co_id(int ben_co_id) {
		this.ben_co_id = ben_co_id;
	}

	public Department getDep() {
		return dep;
	}

	public void setDep(Department dep) {
		this.dep = dep;
	}

	
	public List<Request> getRequests() {
		return requests;
	}

	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}

	public boolean isIs_ben_co() {
		return is_ben_co;
	}

	public void setIs_ben_co(boolean is_ben_co) {
		this.is_ben_co = is_ben_co;
	}

	@Override
	public String toString() {
		return "Employee [e_id=" + e_id + ", username=" + username + ", password=" + password + ", name=" + name
				+ ", email=" + email + ", available_funds=" + available_funds + ", super_id=" + super_id
				+ ", ben_co_id=" + ben_co_id + ", dep=" + dep + ", requests=" + requests 
				+  ", is_ben_co=" + is_ben_co + "]";
	}	
}
