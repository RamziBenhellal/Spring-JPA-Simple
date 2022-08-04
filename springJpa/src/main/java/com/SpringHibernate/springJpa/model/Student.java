package com.SpringHibernate.springJpa.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

@Entity(name ="Student")
@Table(name = "student")
public class Student {
	
	public Student() {
	}

	public Student(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false)
	private Integer id;
	
	@Column(name="firstname", nullable = false, length = 100)
	private String firstname;
	
	@Column(name="lastname", nullable = false, length = 100)
	private String lastname;
	
	@ColumnDefault("current_timestamp")
	@Column(name="created_at", nullable = true, columnDefinition = "timestamp")
	private LocalDateTime createdAt;
	
	@Column(name="updated_at", nullable = true, columnDefinition = "timestamp on update current_timestamp ")
	private LocalDateTime updatedAt;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	
}
