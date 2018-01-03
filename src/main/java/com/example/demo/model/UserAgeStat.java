package com.example.demo.model;

public class UserAgeStat {
	
	private Integer mAge;
	private Long mCount;
	
	public UserAgeStat(Integer age, Long count) {
		super();
		this.mAge = age;
		this.mCount = count;
	}
	public Integer getAge() {
		return mAge;
	}
	public void setAge(Integer age) {
		this.mAge = age;
	}
	public Long getCount() {
		return mCount;
	}
	public void setCount(Long count) {
		this.mCount = count;
	}

}
