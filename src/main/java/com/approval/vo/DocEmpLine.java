package com.approval.vo;

import java.util.Date;

public class DocEmpLine {
	private int DOMSEQ;				//글번호
	private String EMPID;			//작성자아이디 //
	private String DOMSUB;			//문서제목
	private String DOMCONT;			//문서내용
	private Date DOMREGDATE;		//작성일자
	private Date APPROVALDATE;		//결제일자
	private String APPROVALEMP;		//결제자
	private String APPROVALSTATUS;	//결제상태
	private int EMPSEQ;				//사원번호
	private String EMPNAME;			//사원이름
	private String EMPGRADE;		//사원직급
	private String EMPPW;			//비밀번호
	private int LINESEQ;			//라인번호
	private String PPROVALSTATUS;	//결제상태
	
	public DocEmpLine(){}
	public DocEmpLine(int dOMSEQ, String eMPID, String dOMSUB, String dOMCONT, Date dOMREGDATE, Date aPPROVALDATE,
			String aPPROVALEMP, String aPPROVALSTATUS, int eMPSEQ, String eMPNAME, String eMPGRADE, String eMPPW,
			int lINESEQ, String pPROVALSTATUS) {
		super();
		DOMSEQ = dOMSEQ;
		EMPID = eMPID;
		DOMSUB = dOMSUB;
		DOMCONT = dOMCONT;
		DOMREGDATE = dOMREGDATE;
		APPROVALDATE = aPPROVALDATE;
		APPROVALEMP = aPPROVALEMP;
		APPROVALSTATUS = aPPROVALSTATUS;
		EMPSEQ = eMPSEQ;
		EMPNAME = eMPNAME;
		EMPGRADE = eMPGRADE;
		EMPPW = eMPPW;
		LINESEQ = lINESEQ;
		PPROVALSTATUS = pPROVALSTATUS;
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
	public int getEMPSEQ() {
		return EMPSEQ;
	}
	public void setEMPSEQ(int eMPSEQ) {
		EMPSEQ = eMPSEQ;
	}
	public String getEMPNAME() {
		return EMPNAME;
	}
	public void setEMPNAME(String eMPNAME) {
		EMPNAME = eMPNAME;
	}
	public String getEMPGRADE() {
		return EMPGRADE;
	}
	public void setEMPGRADE(String eMPGRADE) {
		EMPGRADE = eMPGRADE;
	}
	public String getEMPPW() {
		return EMPPW;
	}
	public void setEMPPW(String eMPPW) {
		EMPPW = eMPPW;
	}
	public int getLINESEQ() {
		return LINESEQ;
	}
	public void setLINESEQ(int lINESEQ) {
		LINESEQ = lINESEQ;
	}
	public String getPPROVALSTATUS() {
		return PPROVALSTATUS;
	}
	public void setPPROVALSTATUS(String pPROVALSTATUS) {
		PPROVALSTATUS = pPROVALSTATUS;
	}
	
	
	
}
