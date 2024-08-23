package com.bean;

public class Student {

	private int id;
	private String name;
	private String course;
	private String address;
	private String mobile;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Student(int id, String name, String course, String address, String mobile) {
		super();
		this.id = id;
		this.name = name;
		this.course = course;
		this.address = address;
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", course=" + course + ", address=" + address + ", mobile="
				+ mobile + "]";
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
