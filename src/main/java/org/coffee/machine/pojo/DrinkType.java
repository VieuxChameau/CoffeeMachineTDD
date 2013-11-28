package org.coffee.machine.pojo;

public enum DrinkType {
	TEA("T"), COFFEE("C"), CHOCOLATE("H");

	private final String code;
	
	private DrinkType(final String code) {
		this.code = code;
	}


	public String getCode() {
		return code;
	}
}