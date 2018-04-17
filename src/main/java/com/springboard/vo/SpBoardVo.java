package com.springboard.vo;

import java.util.Date;

public class SpBoardVo {
	private int seq;				//글번호
	private String mem_id;			//멤버아이디
	private String board_subject;	//글제목
	private String board_content;	//글내용
	private Date reg_date; 			//등록일
	private Date upt_date;			//수정일
	private int view_cnt;			//조회수
	private String file_name;		//파일이름
	private String file_path;		//파일경로
	
	public SpBoardVo(){}
	
	public SpBoardVo(int seq, String mem_id, String board_subject, String board_content, Date reg_date, Date upt_date,
			int view_cnt, String file_name, String file_path) {
		super();
		this.seq = seq;
		this.mem_id = mem_id;
		this.board_subject = board_subject;
		this.board_content = board_content;
		this.reg_date = reg_date;
		this.upt_date = upt_date;
		this.view_cnt = view_cnt;
		this.file_name = file_name;
		this.file_path = file_path;
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

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public String getFile_path() {
		return file_path;
	}

	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}

	@Override
	public String toString() {
		return "SpBoardVo [seq=" + seq + ", mem_id=" + mem_id + ", board_subject=" + board_subject + ", board_content="
				+ board_content + ", reg_date=" + reg_date + ", upt_date=" + upt_date + ", view_cnt=" + view_cnt
				+ ", file_name=" + file_name + ", file_path=" + file_path + "]";
	}
	
	
	
}
