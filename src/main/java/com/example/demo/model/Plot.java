package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "plot")
public class Plot {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long mId;
	private String mName;
	private String mCoordinates;
	private String mCrop;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
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
	
	public User getUser() {
		return mUser;
	}
	
	public void setUser(User user) {
		this.mUser = user;
	}
}
