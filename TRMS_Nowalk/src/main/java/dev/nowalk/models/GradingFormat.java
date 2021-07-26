package dev.nowalk.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="grading_formats")
public class GradingFormat {
	
	@Id
	@Column(name="g_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int g_id;
	@Column(name="description")
	private String description;
	@Column(name="grading_type")
	private String grading_type;
	@Column(name="passing_grade")
	private String passing_grade;
	
	public GradingFormat() {
		super();
	}

	public GradingFormat(int g_id, String description, String grading_type, String passing_grade) {
		super();
		this.g_id = g_id;
		this.description = description;
		this.grading_type = grading_type;
		this.passing_grade = passing_grade;
	}

	public GradingFormat(String description, String grading_type, String passing_grade) {
		super();
		this.description = description;
		this.grading_type = grading_type;
		this.passing_grade = passing_grade;
	}

	public int getG_id() {
		return g_id;
	}

	public void setG_id(int g_id) {
		this.g_id = g_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGrading_type() {
		return grading_type;
	}

	public void setGrading_type(String grading_type) {
		this.grading_type = grading_type;
	}

	public String getPassing_grade() {
		return passing_grade;
	}

	public void setPassing_grade(String passing_grade) {
		this.passing_grade = passing_grade;
	}

	@Override
	public String toString() {
		return "GradingFormat [g_id=" + g_id + ", description=" + description + ", grading_type=" + grading_type
				+ ", passing_grade=" + passing_grade + "]";
	}
	
	
}
