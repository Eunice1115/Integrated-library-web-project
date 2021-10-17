package model;

import org.springframework.web.multipart.MultipartFile;

public class Boardev {
	private int eventnum;
	private String memberid;
	private String boardid_ev;
	private String content_ev;
	private String subject_ev;
	private String library;
	private String pass;
	private String startdate;
	private String lastdate;
	private int total;
	private String target;
	private String state;
	private int register;
	
	private MultipartFile f;

	@Override
	public String toString() {
		return "Board_ev [eventnum=" + eventnum + ", memberid=" + memberid + ", boardid_ev=" + boardid_ev
				+ ", content_ev=" + content_ev + ", subject_ev=" + subject_ev + ", library=" + library + ", pass="
				+ pass + ", startdate=" + startdate + ", lastdate=" + lastdate + ", total=" + total + ", target="
				+ target + ", state=" + state + ", register=" + register + ", f=" + f + "]";
	}

	public int getEventnum() {
		return eventnum;
	}

	public void setEventnum(int eventnum) {
		this.eventnum = eventnum;
	}

	public String getMemberid() {
		return memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}

	public String getBoardid_ev() {
		return boardid_ev;
	}

	public void setBoardid_ev(String boardid_ev) {
		this.boardid_ev = boardid_ev;
	}

	public String getContent_ev() {
		return content_ev;
	}

	public void setContent_ev(String content_ev) {
		this.content_ev = content_ev;
	}

	public String getSubject_ev() {
		return subject_ev;
	}

	public void setSubject_ev(String subject_ev) {
		this.subject_ev = subject_ev;
	}

	public String getLibrary() {
		return library;
	}

	public void setLibrary(String library) {
		this.library = library;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getLastdate() {
		return lastdate;
	}

	public void setLastdate(String lastdate) {
		this.lastdate = lastdate;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getRegister() {
		return register;
	}

	public void setRegister(int register) {
		this.register = register;
	}

	public MultipartFile getF() {
		return f;
	}

	public void setF(MultipartFile f) {
		this.f = f;
	}
	
	
}
