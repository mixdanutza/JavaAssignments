package com.daniela.Lookify.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="songs")
public class Song {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	@Size(min=2, max=20)
	private String title;
	
	@Column
	@Size(min=2, max=20)
	private String artist;
	
	@Column
	@Min(1)
	@Max(10)
	private Long rating;
	
	@Column
	@DateTimeFormat(pattern="MM/dd/yyyy HH:mm:ss")
	private Date createdat;
	
	@Column
	@DateTimeFormat(pattern="MM/dd/yyyy HH:mm:ss")
	private Date updatedat;
	
	
	@PrePersist
	protected void onCreate() {
		this.createdat= new Date();
	}
	@PreUpdate
	protected void onUpdate() {
		this.updatedat=new Date();
	}
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public Long getRating() {
		return rating;
	}

	public void setRating(Long rating) {
		this.rating = rating;
	}

	public Date getCreatedAt() {
		return createdat;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdat = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedat;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedat = updatedAt;
	}
	
	
	public Song(String title, String artist, Long rating) {
		this.title=title;
		this.artist=artist;
		this.rating=rating;
	}
	public Song() {
		
	}

}
