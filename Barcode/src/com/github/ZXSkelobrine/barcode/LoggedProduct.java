package com.github.ZXSkelobrine.barcode;


public class LoggedProduct {
	private Product product;
	private boolean needed;

	public LoggedProduct(Product product, boolean needed) {
		this.product = product;
		this.needed = needed;
	}

	public Product getProduct() {
		return product;
	}

	public boolean isNeeded() {
		return needed;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setNeeded(boolean needed) {
		this.needed = needed;
	}
}
