package org.coffee.machine;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.coffee.machine.pojo.DrinkType;

public class CashRegister {
	private final Map<DrinkType, Integer> counter = new HashMap<DrinkType, Integer>();
	
	private BigDecimal getMoneyInTheBank() {
		BigDecimal money = new BigDecimal(0);
		for(Entry<DrinkType, Integer> nextCounter : counter.entrySet()) {
			money = money.add(new BigDecimal(nextCounter.getKey().getPrice()).multiply(new BigDecimal(nextCounter.getValue())));
		}
		return money;
	}

	public void pay(final DrinkType drinkType) {
		Integer nbDrink = counter.get(drinkType);
		if(nbDrink == null) {
			nbDrink = 0;
		}
		counter.put(drinkType, ++nbDrink);
	}

	public Report generateReport() {
		return new Report(new HashMap<DrinkType, Integer>(counter), getMoneyInTheBank());
	}
}
