package com.github.ZXSkelobrine.barcode;

public class Product {
	private String barcode, name, expiry;
	private int amount, id;
	private float buy, sell, profit;

	public Product(int id, String barcode, String name, String expiry, int amount, float buy_cost, float sell_cost, float profit) {
		this.id = id;
		this.barcode = barcode;
		this.name = name;
		this.expiry = expiry;
		this.amount = amount;
		this.buy = buy_cost;
		this.sell = sell_cost;
		this.profit = profit;
	}

	public String getBarcode() {
		return barcode;
	}

	public int getAmount() {
		return amount;
	}

	public float getBuyCost() {
		return buy;
	}

	public String getExpiry() {
		return expiry;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public float getProfit() {
		return profit;
	}

	public float getSell() {
		return sell;
	}

}
