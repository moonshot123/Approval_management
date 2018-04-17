package com.pos.vo;

import javax.xml.crypto.Data;

public class sellVO {
	private String sellseq;
	private String menuseq;
	private Data selldate;
	
	public sellVO(){}
	public sellVO(String sellseq, String menuseq, Data selldate) {
		super();
		this.sellseq = sellseq;
		this.menuseq = menuseq;
		this.selldate = selldate;
	}
	public String getSellseq() {
		return sellseq;
	}
	public void setSellseq(String sellseq) {
		this.sellseq = sellseq;
	}
	public String getMenuseq() {
		return menuseq;
	}
	public void setMenuseq(String menuseq) {
		this.menuseq = menuseq;
	}
	public Data getSelldate() {
		return selldate;
	}
	public void setSelldate(Data selldate) {
		this.selldate = selldate;
	}
		
	
	
}
