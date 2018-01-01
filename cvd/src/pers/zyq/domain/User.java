package pers.zyq.domain;

import java.sql.Date;

public class User {

	private int id;
	private String name;
	private String password;
	private String sex;
	private String idcard;
	private String phone;
	private Date regdate;
	public User() {
		super();
	}
	public User(String name, String sex, String idcard,String phone) {
		super();
		this.name = name;
		this.sex = sex;
		this.idcard = idcard;
		this.phone = phone;
	}
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
}
