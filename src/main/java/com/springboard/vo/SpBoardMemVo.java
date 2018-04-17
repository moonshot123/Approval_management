package com.springboard.vo;

import java.util.Date;

public class SpBoardMemVo {
	private int mem_seq;			//회원번호
	private String mem_id;			//멤버아이디
	private String mem_name;		//멤버이름
	private String mem_pw;			//멤버비밀번호
	private Date reg_date; 			//가입일
	private String mem_staus;		//회원상태 (일반:Y, 탈퇴:N )
	
	public SpBoardMemVo(){}
	
	public SpBoardMemVo(int mem_seq, String mem_id, String mem_name, String mem_pw, Date reg_date, String mem_staus) {
		super();
		this.mem_seq = mem_seq;
		this.mem_id = mem_id;
		this.mem_name = mem_name;
		this.mem_pw = mem_pw;
		this.reg_date = reg_date;
		this.mem_staus = mem_staus;
	}

	public int getMem_seq() {
		return mem_seq;
	}

	public void setMem_seq(int mem_seq) {
		this.mem_seq = mem_seq;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getMem_name() {
		return mem_name;
	}

	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}

	public String getMem_pw() {
		return mem_pw;
	}

	public void setMem_pw(String mem_pw) {
		this.mem_pw = mem_pw;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	public String getMem_staus() {
		return mem_staus;
	}

	public void setMem_staus(String mem_staus) {
		this.mem_staus = mem_staus;
	}

	@Override
	public String toString() {
		return "SpBoardMemVo [mem_seq=" + mem_seq + ", mem_id=" + mem_id + ", mem_name=" + mem_name + ", mem_pw="
				+ mem_pw + ", reg_date=" + reg_date + ", mem_staus=" + mem_staus + "]";
	}
	
	
	
}
