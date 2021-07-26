package dev.nowalk.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reimbursements")
public class Reimbursement {

	@Id
	@Column(name="r_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int r_id;
	@Column(name="value")
	private double value;
	@Column(name="ben_co_approval")
	private boolean ben_co_approval;
	@Column(name="grade")
	private double grade;
	@Column(name="employee_id")
	private int employee_id;
	@Column(name="event_id")
	private int event_id;
	
	public Reimbursement() {
		super();
	}

	public Reimbursement(int r_id, double value, boolean ben_co_approval, double grade, int employee_id, int event_id) {
		super();
		this.r_id = r_id;
		this.value = value;
		this.ben_co_approval = ben_co_approval;
		this.grade = grade;
		this.employee_id = employee_id;
		this.event_id = event_id;
	}

	public Reimbursement(double value, boolean ben_co_approval, double grade, int employee_id, int event_id) {
		super();
		this.value = value;
		this.ben_co_approval = ben_co_approval;
		this.grade = grade;
		this.employee_id = employee_id;
		this.event_id = event_id;
	}

	public int getR_id() {
		return r_id;
	}

	public void setR_id(int r_id) {
		this.r_id = r_id;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public boolean isBen_co_approval() {
		return ben_co_approval;
	}

	public void setBen_co_approval(boolean ben_co_approval) {
		this.ben_co_approval = ben_co_approval;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public int getEvent_id() {
		return event_id;
	}

	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}

	@Override
	public String toString() {
		return "Reimbursement [r_id=" + r_id + ", value=" + value + ", ben_co_approval=" + ben_co_approval + ", grade="
				+ grade + ", employee_id=" + employee_id + ", event_id=" + event_id + "]";
	}
	
	
}
