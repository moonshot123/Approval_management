package com.board.vo;

import java.util.Date;

public class boardVO {
	//임의로 변수를 바꿀수 없도록 
	//private로 함 접근지정자를 넣음
	//public 모든패키지
	//protected 현재패키지
	private int seq;
	private String mem_id;
	private String mem_name;
	private String board_subject;
	private String board_content;
	private Date reg_date; //utill 데이트
	private Date upt_date;
	private int view_cnt;
	
	public boardVO(){}
	
	public boardVO(int seq, String mem_id, String mem_name, String board_subject, String board_content, Date reg_date,
			Date upt_date, int view_cnt) {
		super();
		this.seq = seq;
		this.mem_id = mem_id;
		this.mem_name = mem_name;
		this.board_subject = board_subject;
		this.board_content = board_content;
		this.reg_date = reg_date;
		this.upt_date = upt_date;
		this.view_cnt = view_cnt;
	}
	
	public int getSeq() {
		return seq;
	}
	
	public void setSeq(int seq) {
		this.seq = seq;
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
	
	public String getBoard_subject() {
		return board_subject;
	}
	
	public void setBoard_subject(String board_subject) {
		this.board_subject = board_subject;
	}
	
	public String getBoard_content() {
		return board_content;
	}
	
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	
	public Date getReg_date() {
		return reg_date;
	}
	
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	
	public Date getUpt_date() {
		return upt_date;
	}
	
	public void setUpt_date(Date upt_date) {
		this.upt_date = upt_date;
	}
	
	public int getView_cnt() {
		return view_cnt;
	}
	
	public void setView_cnt(int view_cnt) {
		this.view_cnt = view_cnt;
	}
	
	
	
}
