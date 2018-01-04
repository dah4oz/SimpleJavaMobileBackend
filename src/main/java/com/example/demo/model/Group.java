package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "group_type")
public class Group {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
    private Long mId;
	
	@Column(name = "name")
	private String mName;
	
	/*
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User mUser;
	*/
	
	@ManyToMany(mappedBy = "mGroups")
	@JsonIgnore
	private Set<User> mUsers = new HashSet<>();
	
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
	
	@JsonIgnore
	public Set<User> getUser() {
		return mUsers;
	}
	
	public void setUser(Set<User> users) {
		this.mUsers = users;
	}
	
}
