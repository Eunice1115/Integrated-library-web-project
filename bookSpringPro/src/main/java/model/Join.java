package model;

import java.util.Date;

public class Join {
	private int rentalnum;
	private String memberid;
	private int booknum;
	private String bookname;
	private String author;
	private String library;
	private Date rentaldate;
	private Date returndate_sch;
	public int getRentalnum() {
		return rentalnum;
	}
	public void setRentalnum(int rentalnum) {
		this.rentalnum = rentalnum;
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
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getLibrary() {
		return library;
	}
	public void setLibrary(String library) {
		this.library = library;
	}
	public Date getRentaldate() {
		return rentaldate;
	}
	public void setRentaldate(Date rentaldate) {
		this.rentaldate = rentaldate;
	}
	public Date getReturndate_sch() {
		return returndate_sch;
	}
	public void setReturndate_sch(Date returndate_sch) {
		this.returndate_sch = returndate_sch;
	}
	
	
	
}
