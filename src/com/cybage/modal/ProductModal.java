package com.cybage.modal;

public class ProductModal {
	private int productId;
	private String productName;
	private int price;
	private int userId;

	public ProductModal(int productId, String productName, int price, int userId) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.userId = userId;
	}

	public ProductModal() {
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
