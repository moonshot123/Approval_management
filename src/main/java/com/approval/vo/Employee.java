package com.approval.vo;

public class Employee {
	
	private int EMPSEQ;			//사원번호
	private String EMPNAME;		//사원이름
	private String EMPGRADE;	//사원직급
	private String EMPID;		//아이디
	private String EMPPW;		//비밀번호
	
	public Employee(){}
	public Employee(int eMPSEQ, String eMPNAME, String eMPGRADE, String eMPID, String eMPPW) {
		super();
		EMPSEQ = eMPSEQ;
		EMPNAME = eMPNAME;
		EMPGRADE = eMPGRADE;
		EMPID = eMPID;
		EMPPW = eMPPW;
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
	public String getEMPID() {
		return EMPID;
	}
	public void setEMPID(String eMPID) {
		EMPID = eMPID;
	}
	public String getEMPPW() {
		return EMPPW;
	}
	public void setEMPPW(String eMPPW) {
		EMPPW = eMPPW;
	}
	

	@Override
	public String toString() {
		return "Employee [EMPSEQ=" + EMPSEQ + ", EMPNAME=" + EMPNAME + ", EMPGRADE=" + EMPGRADE + ", EMPID=" + EMPID
				+ ", EMPPW=" + EMPPW + "]";
	}
	  

}
