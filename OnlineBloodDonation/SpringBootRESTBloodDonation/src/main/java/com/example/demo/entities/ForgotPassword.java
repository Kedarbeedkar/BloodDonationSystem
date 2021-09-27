package com.example.demo.entities;

public class ForgotPassword {
	
	String emailid;
	String answer;
	public ForgotPassword() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ForgotPassword(String emailid, String answer) {
		super();
		this.emailid = emailid;
		this.answer = answer;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	@Override
	public String toString() {
		return "ForgotPassword [emailid=" + emailid + ", answer=" + answer + "]";
	}
	
	
	
	

}
