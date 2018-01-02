package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long mId;
	private String mName;
	private String mAge;
	private String mEmail;
	private String mUsername;
	private String mPassword;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "mUser", fetch = FetchType.LAZY)
	private Set<Plot> mPlots = new HashSet<>();
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "mUSer", fetch = FetchType.LAZY)
	private Set<Group> mGroups = new HashSet<>();
	
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
	public String getAge() {
		return mAge;
	}
	public void setAge(String age) {
		this.mAge = age;
	}
	public String getEmail() {
		return mEmail;
	}
	public void setEmail(String mail) {
		this.mEmail = mail;
	}
	public String getUsername() {
		return mUsername;
	}
	public void setUsername(String username) {
		this.mUsername = username;
	}
	public String getPassword() {
		return mPassword;
	}
	public void setPassword(String password) {
		this.mPassword = password;
	}
	
	public Set<Group> getUserGroups() {
		return mGroups;
	}
	
	public Set<Plot> getUserPlots() {
		return mPlots;
	}
	
}
