package model;

import java.util.Date;

public class Seat {
	private int seatNum;
	private String memberid;
	private String pass;
	private String library;
	private Date checkIn;
	private Date checkOut;
	public int getSeatNum() {
		return seatNum;
	}
	public void setSeatNum(int seatNum) {
		this.seatNum = seatNum;
	}
	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getLibrary() {
		return library;
	}
	public void setLibrary(String library) {
		this.library = library;
	}
	public Date getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}
	public Date getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}
	@Override
	public String toString() {
		return "Seat [seatNum=" + seatNum + ", memberid=" + memberid + ", pass=" + pass + ", library=" + library
				+ ", checkIn=" + checkIn + ", checkOut=" + checkOut + "]";
	}
	
	
	
	
	
	
	
}
