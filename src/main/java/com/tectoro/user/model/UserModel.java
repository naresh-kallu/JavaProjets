package com.tectoro.user.model;

public class UserModel {
	
	private int id;
	private long uid;
	private String fname;
	private String lname;
	private String email;
	private String contact;
	private String username;
	private String password;
	
	public UserModel(int id, String fname, String lname, String email, String contact, String username,String password) {
		
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.contact = contact;
		this.username = username;
		this.password = password;
		System.out.println(uid+" "+fname+" "+lname+" "+email+""+contact+""+username+""+password);
	}
public UserModel( String fname, String lname, String email, String contact, String username,String password) {
		
		
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.contact = contact;
		this.username = username;
		this.password = password;
		System.out.println(uid+" "+fname+" "+lname+" "+email+""+contact+""+username+""+password);
	}
	
	
	
	
	
	public UserModel(int id,long uid, String fname, String lname, String email, String contact, String username,String password) {
		this.id=id;
		this.uid = uid;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.contact = contact;
		this.username = username;
		this.password = password;
		
	}
	public UserModel() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public long getUid() {
		return uid;
	}
	public void setUid(long uid) {
		this.uid = uid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	/*
	 * @Override public String toString() { return "UserModel [uid=" + uid +
	 * ", fname=" + fname + ", lname=" + lname + ", email=" + email + ", contact=" +
	 * contact + ", username=" + username + ", password=" + password + "]"; }
	 */
	
	

}
