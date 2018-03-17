package com.approval.vo;

import java.util.Date;

public class Line {
	
	private int LINESEQ;			//라인번호
	private int DOMSEQ;				//문서번호
	private String APPROVALEMP;		//결제사원
	private Date APPROVALDATE;		//결제일
	private String PPROVALSTATUS;	//결제상태
	
	public Line(){}
	public Line(int lINESEQ, int dOMSEQ, String aPPROVALEMP, Date aPPROVALDATE, String pPROVALSTATUS) {
		super();
		LINESEQ = lINESEQ;
		DOMSEQ = dOMSEQ;
		APPROVALEMP = aPPROVALEMP;
		APPROVALDATE = aPPROVALDATE;
		PPROVALSTATUS = pPROVALSTATUS;
	}
	public int getLINESEQ() {
		return LINESEQ;
	}
	public void setLINESEQ(int lINESEQ) {
		LINESEQ = lINESEQ;
	}
	public int getDOMSEQ() {
		return DOMSEQ;
	}
	public void setDOMSEQ(int dOMSEQ) {
		DOMSEQ = dOMSEQ;
	}
	public String getAPPROVALEMP() {
		return APPROVALEMP;
	}
	public void setAPPROVALEMP(String aPPROVALEMP) {
		APPROVALEMP = aPPROVALEMP;
	}
	public Date getAPPROVALDATE() {
		return APPROVALDATE;
	}
	public void setAPPROVALDATE(Date aPPROVALDATE) {
		APPROVALDATE = aPPROVALDATE;
	}
	public String getPPROVALSTATUS() {
		return PPROVALSTATUS;
	}
	public void setPPROVALSTATUS(String pPROVALSTATUS) {
		PPROVALSTATUS = pPROVALSTATUS;
	}
	
	
	
	
}
