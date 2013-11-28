package org.coffee.machine;

import org.coffee.machine.pojo.CustomerWish;
import org.coffee.machine.pojo.DrinkType;

public class CoffeeMachine {
	private static final String SEPARATOR = ":";
	
	public String toDMProtocol(final CustomerWish wish) {
		final DrinkType drinkType = wish.getDrinkType();
		final StringBuilder result = new StringBuilder();
		final double price = drinkType.getPrice();
		final double amount = wish.getAmount();
		if(amount < price) {
			return "M:" + (price - amount);
		}
		
		result.append(drinkType.getCode()).append(SEPARATOR);
		if(wish.hasSugar()) {
			result.append(wish.getSugars()).append(SEPARATOR).append("0");
		}
		else {
			result.append(SEPARATOR);
		}
		
		return result.toString();
	}
}
