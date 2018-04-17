package com.sell.vo;

public class product {
	private int sellseq; 	//물건번호	
	private int price; 		//물건가격
	private String name; 	//물건이름
	private String story; 	//물건설명
	private String imgpath; //물건이미지
	
	public product(){}
	public product(int sellseq, int price, String name, String story, String imgpath) {
		super();
		this.sellseq = sellseq;
		this.price = price;
		this.name = name;
		this.story = story;
		this.imgpath = imgpath;
	}
	public int getSellseq() {
		return sellseq;
	}
	public void setSellseq(int sellseq) {
		this.sellseq = sellseq;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStory() {
		return story;
	}
	public void setStory(String story) {
		this.story = story;
	}
	public String getImgpath() {
		return imgpath;
	}
	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}
	
	@Override
	public String toString() {
		return "product [sellseq=" + sellseq + ", price=" + price + ", name=" + name + ", story=" + story + ", imgpath="
				+ imgpath + "]";
	}
	
	
	
	
}


