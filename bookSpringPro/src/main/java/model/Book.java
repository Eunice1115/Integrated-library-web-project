package model;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class Book {
	
	private int booknum;
	private String bookname;
	private String author;
	private String publisher;
	private int publicdate;
	private String stockdate;
	private String library;
	private String bookstate;
	private int borrowcount;
	private String bookpicture;
	
	private MultipartFile f;
	
	
	@Override
	public String toString() {
		return "Book [booknum=" + booknum + ", bookname=" + bookname + ", author=" + author + ", publisher=" + publisher
				+ ", publicdate=" + publicdate + ", stockdate=" + stockdate + ", library=" + library + ", bookstate="
				+ bookstate + ", borrowcount=" + borrowcount + ", bookpicture=" + bookpicture + ", f=" + f + "]";
	}
	public MultipartFile getF() {
		return f;
	}
	public void setF(MultipartFile f) {
		this.f = f;
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
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getPublicdate() {
		return publicdate;
	}
	public void setPublicdate(int publicdate) {
		this.publicdate = publicdate;
	}
	public String getStockdate() {
		return stockdate;
	}
	public void setStockdate(String stockdate) {
		this.stockdate = stockdate;
	}
	public String getLibrary() {
		return library;
	}
	public void setLibrary(String library) {
		this.library = library;
	}
	public String getBookstate() {
		return bookstate;
	}
	public void setBookstate(String bookstate) {
		this.bookstate = bookstate;
	}
	public int getBorrowcount() {
		return borrowcount;
	}
	public void setBorrowcount(int borrowcount) {
		this.borrowcount = borrowcount;
	}
	public String getBookpicture() {
		return bookpicture;
	}
	public void setBookpicture(String bookpicture) {
		this.bookpicture = bookpicture;
	}
	
	
	
	
	

}
