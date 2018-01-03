package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user")
public class User {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
    private Long mId;
	
	@Column(name = "name")
	private String mName;
	
	@Column(name = "age")
	private int mAge;
	
	@Column(name = "email")
	private String mEmail;
	
	@Column(name = "username")
	private String mUsername;
	
	@JsonIgnore
	@Column(name = "password")
	private String mPassword;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "mUser", fetch = FetchType.LAZY)
	private Set<Plot> mPlots = new HashSet<>();
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_group", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), 
			inverseJoinColumns = @JoinColumn(name = "group_id", referencedColumnName = "id"))
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
	public int getAge() {
		return mAge;
	}
	public void setAge(int age) {
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
	
	public void addGroup(Group group) {
		this.mGroups.add(group);
	}
	
	public void removeGroup(Group group) {
		this.mGroups.remove(group);
	}
	
	public void addPlot(Plot plot) {
		this.mPlots.add(plot);
	}
	
	public void removePlot(Plot plot) {
		this.mPlots.remove(plot);
	}
	
}
