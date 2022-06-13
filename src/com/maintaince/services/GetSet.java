package com.maintaince.services;

public class GetSet {
	static String email,password,demail,dpassword,dname,departemail,departname;

	public static String getDepartname() {
		return departname;
	}

	public static void setDepartname(String departname) {
		GetSet.departname = departname;
	}

	public static String getDname() {
		return dname;
	}

	public static void setDname(String dname) {
		GetSet.dname = dname;
	}

	public static String getDemail() {
		return demail;
	}

	public static String getDepartemail() {
		return departemail;
	}

	public static void setDepartemail(String departemail) {
		GetSet.departemail = departemail;
	}

	public static void setDemail(String demail) {
		GetSet.demail = demail;
	}

	public static String getDpassword() {
		return dpassword;
	}

	public static void setDpassword(String dpassword) {
		GetSet.dpassword = dpassword;
	}

	public static String getEmail() {
		return email;
	}

	public static void setEmail(String email) {
		GetSet.email = email;
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		GetSet.password = password;
	}

	
}
