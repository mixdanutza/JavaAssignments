package com.daniela.belt.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="teams")
public class Team {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column 
	@Size(min=2, max=20)
	private String name;
	
	@Column
	@Min(1)
	@Max(100)
	private int size;
	
	@CreationTimestamp
	private Date createdAt;
	
	@UpdateTimestamp
	private Date  updatedAt;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="users_teams",
			joinColumns=@JoinColumn(name="teamId"),
			inverseJoinColumns=@JoinColumn(name="userId")
			)
	private List<User> users;

	public Team(String name, int size) {
		this.name = name;
		this.size = size;
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}
	
	public Team() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
}
