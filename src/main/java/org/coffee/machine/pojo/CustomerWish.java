package org.coffee.machine.pojo;

public class CustomerWish {
	private final DrinkType drinkType;
	private final int sugars;
	private final double amount;

	public CustomerWish(final DrinkType drinkType, final int sugars, final double amount) {
		this.drinkType = drinkType;
		this.sugars = sugars;
		this.amount = amount;
	}
	
	public DrinkType getDrinkType() {
		return drinkType;
	}

	public int getSugars() {
		return sugars;
	}

	public double getAmount() {
		return amount;
	}

	public boolean hasSugar() {
		return sugars > 0;
	}
}
