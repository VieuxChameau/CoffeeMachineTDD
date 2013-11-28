package org.coffee.machine.pojo;

public enum DrinkType {
	TEA("T", 0.4), COFFEE("C", 0.6), CHOCOLATE("H", 0.5);

	private final String code;
	private final double price;
	
	private DrinkType(final String code, final double price) {
		this.code = code;
		this.price = price;
	}


	public String getCode() {
		return code;
	}
	
	public double getPrice() {
		return price;
	}
}