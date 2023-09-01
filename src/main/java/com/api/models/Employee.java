package com.api.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;

@Entity
@Table(name="employees", catalog="employees_db", schema="")
public class Employee {



	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // This generates an auto-incremented ID
    @Column
    private Integer id; // Use a Long or Integer type for the ID
    
	@Column
	private String name;
	
	@Column
	private String last_name;
	
	@Column
	private Long age;
	
	@Column
	private String date_of_admission;
	
	@Column(nullable = true)
	private String comment;
	
	@Column(nullable = true) 
	private Integer status = 1; 
	
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public String getDate_of_admission() {
		return date_of_admission;
	}

	public void setDate_of_admission(String date_of_admission) {
		this.date_of_admission = date_of_admission;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}


}
