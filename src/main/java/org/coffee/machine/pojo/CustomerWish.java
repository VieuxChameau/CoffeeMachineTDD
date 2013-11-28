package org.coffee.machine.pojo;

public class CustomerWish {
	private final DrinkType drinkType;
	private final int sugars;


	public CustomerWish(final DrinkType drinkType, final int sugars) {
		this.drinkType = drinkType;
		this.sugars = sugars;
	}
	
	public DrinkType getDrinkType() {
		return drinkType;
	}

	public int getSugars() {
		return sugars;
	}

	
	public boolean hasSugar() {
		return sugars > 0;
	}
}
