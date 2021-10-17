package model;

import java.util.Date;

public class Rental {
	private int rentalnum;
	private String memberid;
	private int booknum;
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
	@Override
	public String toString() {
		return "Rental [rentalnum=" + rentalnum + ", memberid=" + memberid + ", booknum=" + booknum + ", rentaldate="
				+ rentaldate + ", returndate_sch=" + returndate_sch + "]";
	}
	
	
}
