package com.sell.vo;

public class orderProduct {
	private String orderseq; 	//주문번호	
	private int sellseq; 		//물건번호
	private String selldone; 	//주문완료  (Y: 주문완료   N:주문취소)
	
	
	public orderProduct(){}	

	public orderProduct(String orderseq, int sellseq, String selldone) {
		super();
		this.orderseq = orderseq;
		this.sellseq = sellseq;
		this.selldone = selldone;
	}
	
	public String getOrderseq() {
		return orderseq;
	}
	public void setOrderseq(String orderseq) {
		this.orderseq = orderseq;
	}
	public int getSellseq() {
		return sellseq;
	}
	public void setSellseq(int sellseq) {
		this.sellseq = sellseq;
	}
	public String getSelldone() {
		return selldone;
	}
	public void setSelldone(String selldone) {
		this.selldone = selldone;
	}
	@Override
	public String toString() {
		return "orderProduct [orderseq=" + orderseq + ", sellseq=" + sellseq + ", selldone=" + selldone + "]";
	}
	
	
	
}
