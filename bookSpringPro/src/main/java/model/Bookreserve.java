package model;

import java.util.Date;

public class Bookreserve {
	
	private int rsvnum;
	private String memberid;
	private int booknum;
	private Date rsvdate;
	private String bookname ;
	private String library;
	private String author;
	
	
	
	
	
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getLibrary() {
		return library;
	}
	public void setLibrary(String library) {
		this.library = library;
	}
	public int getRsvnum() {
		return rsvnum;
	}
	public void setRsvnum(int rsvnum) {
		this.rsvnum = rsvnum;
	}
	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	public int getBooknum() {
		return booknum;
	}
	public void setBooknum(int booknum) {
		this.booknum = booknum;
	}
	public Date getRsvdate() {
		return rsvdate;
	}
	public void setRsvdate(Date rsvdate) {
		this.rsvdate = rsvdate;
	}
	
	

}
