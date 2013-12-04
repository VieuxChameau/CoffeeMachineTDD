package org.coffee.machine;

import org.coffee.machine.pojo.CustomerWish;
import org.coffee.machine.pojo.DrinkType;

public class CoffeeMachine {
	private static final String SEPARATOR = ":";
	
	public String toDMProtocol(final CustomerWish wish) {
		final DrinkType drinkType = wish.getDrinkType();
		final double price = drinkType.getPrice();
		final double amount = wish.getAmount();
		if(amount < price) {
			return "M:" + (price - amount);
		}
		
		final StringBuilder sb = new StringBuilder();
		sb.append(drinkType.getCode());
		if (wish.isExtraHot() && drinkType.canBeExtraHot()) {
			sb.append('h');
		}
		sb.append(SEPARATOR);
		if(wish.hasSugar()) {
			sb.append(wish.getSugars()).append(SEPARATOR).append("0");
		}
		else {
			sb.append(SEPARATOR);
		}
		
		return sb.toString();
	}
}
