package org.coffee.machine;

import java.math.BigDecimal;
import java.util.Map;

import org.coffee.machine.pojo.DrinkType;

public class Report {
	private final Map<DrinkType, Integer> counter;
	private final BigDecimal moneyInTheBank;
	
	public Report(Map<DrinkType, Integer> counter, BigDecimal bigDecimal) {
		this.counter = counter;
		this.moneyInTheBank = bigDecimal;
	}
	
	public Map<DrinkType, Integer> getNumberSoldByDrink() {
		return counter;
	}
	
	public BigDecimal getMoneyInTheBank() {
		return moneyInTheBank;
	}
}
