package com.pos.vo;

public class menuVO {
	private String menuseq;		//메뉴번호
	private String name;		//메뉴이름
	private String type; 		//음식종류 (H:한식, J:일식, W:양식, D:음료 및 후식)
	private int price;			//메뉴가격
	
	public menuVO(){}
	public menuVO(String menuseq, String name, String type, int price) {
		super();
		this.menuseq = menuseq;
		this.name = name;
		this.type = type;
		this.price = price;
	}
	public String getMenuseq() {
		return menuseq;
	}
	public void setMenuseq(String menuseq) {
		this.menuseq = menuseq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "menuVO [menuseq=" + menuseq + ", name=" + name + ", type=" + type + ", price=" + price + "]";
	}
	
	
	
	
}
