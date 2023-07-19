package com.mis.domain;

public class ProductVO {

	private String name;
	private double price;

	 // 게터와 세터는 mabatis가 접근하기 위해 private으로 선언해준 컬럼들을 불러오고 설정
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	//toString을 안하면 메모리값을 가져오기 때문에 선언해줌
	@Override
	public String toString() {
		return "ProductVO [name=" + name + ", price=" + price + "]";
	}

}
