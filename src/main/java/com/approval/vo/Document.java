package com.approval.vo;

import java.util.Date;

public class Document {
	
	private int DOMSEQ;				//글번호
	private String EMPID;			//작성자아이디
	private String DOMSUB;			//문서제목
	private String DOMCONT;			//문서내용
	private Date DOMREGDATE;		//작성일자
<<<<<<< HEAD
	private Date APPROVALDATE;		//결재일자
	private String APPROVALEMP;		//결재자
	private String APPROVALSTATUS;	//결재상태  (임시저장:temp , 결재대기:wait, 결재중:app , 결재완료:done, 반려:ban)
=======
	private Date APPROVALDATE;		//결제일자
	private String APPROVALEMP;		//결제자
	private String APPROVALSTATUS;	//결제상태  (임시저장:temp , 결재대기:wait, 결재중:app , 결재완료:done, 반려:ban)
>>>>>>> 9c4572edbe00ea94482a76c956f2cc587eb636ad
	
	public Document(int dOMSEQ, String eMPID, String dOMSUB, String dOMCONT, Date dOMREGDATE, Date aPPROVALDATE,
			String aPPROVALEMP, String aPPROVALSTATUS) {
		super();
		DOMSEQ = dOMSEQ;
		EMPID = eMPID;
		DOMSUB = dOMSUB;
		DOMCONT = dOMCONT;
		DOMREGDATE = dOMREGDATE;
		APPROVALDATE = aPPROVALDATE;
		APPROVALEMP = aPPROVALEMP;
		APPROVALSTATUS = aPPROVALSTATUS;
	}
	public Document() {
		super();
	}
	public int getDOMSEQ() {
		return DOMSEQ;
	}
	public void setDOMSEQ(int dOMSEQ) {
		DOMSEQ = dOMSEQ;
	}
	public String getEMPID() {
		return EMPID;
	}
	public void setEMPID(String eMPID) {
		EMPID = eMPID;
	}
	public String getDOMSUB() {
		return DOMSUB;
	}
	public void setDOMSUB(String dOMSUB) {
		DOMSUB = dOMSUB;
	}
	public String getDOMCONT() {
		return DOMCONT;
	}
	public void setDOMCONT(String dOMCONT) {
		DOMCONT = dOMCONT;
	}
	public Date getDOMREGDATE() {
		return DOMREGDATE;
	}
	public void setDOMREGDATE(Date dOMREGDATE) {
		DOMREGDATE = dOMREGDATE;
	}
	public Date getAPPROVALDATE() {
		return APPROVALDATE;
	}
	public void setAPPROVALDATE(Date aPPROVALDATE) {
		APPROVALDATE = aPPROVALDATE;
	}
	public String getAPPROVALEMP() {
		return APPROVALEMP;
	}
	public void setAPPROVALEMP(String aPPROVALEMP) {
		APPROVALEMP = aPPROVALEMP;
	}
	public String getAPPROVALSTATUS() {
		return APPROVALSTATUS;
	}
	public void setAPPROVALSTATUS(String aPPROVALSTATUS) {
		APPROVALSTATUS = aPPROVALSTATUS;
	}
	
	
	
	
	
	
}
