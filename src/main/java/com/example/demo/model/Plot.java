package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "plot")
public class Plot {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
    private Long mId;
	
	@Column(name = "name")
	private String mName;
	
	@Column(name = "coordinates")
	private String mCoordinates;
	
	@Column(name = "crop")
	private String mCrop;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	@JsonIgnore
	private User mUser;
	
	public void setId(Long id) {
		this.mId = id;
	}
	
	public Long getId() {
		return mId;
	}
	
	public String getName() {
		return mName;
	}
	
	public void setName(String name) {
		this.mName = name;
	}
	
	public String getCoordinates() {
		return mCoordinates;
	}
	
	public void setCoordinates(String coordinates) {
		this.mCoordinates = coordinates;
	}
	
	public String getCrop() {
		return mCrop;
	}
	
	public void setCrop(String crop) {
		this.mCrop = crop;
	}
	
	@JsonIgnore
	public User getUser() {
		return mUser;
	}
	
	public void setUser(User user) {
		this.mUser = user;
	}
}
