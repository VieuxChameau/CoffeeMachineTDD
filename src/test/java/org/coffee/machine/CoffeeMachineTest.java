package org.coffee.machine;

import static org.coffee.machine.pojo.DrinkType.CHOCOLATE;
import static org.coffee.machine.pojo.DrinkType.COFFEE;
import static org.coffee.machine.pojo.DrinkType.ORANGE;
import static org.coffee.machine.pojo.DrinkType.TEA;
import static org.fest.assertions.Assertions.assertThat;

import java.util.Map;

import org.coffee.machine.pojo.CustomerWish;
import org.coffee.machine.pojo.DrinkType;
import org.junit.Test;


public class CoffeeMachineTest {
	private final CoffeeMachine coffeeMachine = new CoffeeMachine();
	
	@Test
	public void should_convert_tea_wish_with_sugar() {
		final CustomerWish wish = new CustomerWish(TEA, 1, 0.4);
		
		final String result = coffeeMachine.toDMProtocol(wish);
		
		assertThat(result).isEqualTo("T:1:0");
	}
	
	@Test
	public void should_convert_coffee_wish_with_sugars() {
		final CustomerWish wish = new CustomerWish(COFFEE, 2, 0.6);
		
		final String result = coffeeMachine.toDMProtocol(wish);
		
		assertThat(result).isEqualTo("C:2:0");
	}
	
	@Test
	public void should_convert_chocolate_wish_without_sugar() {
		final CustomerWish wish = new CustomerWish(CHOCOLATE, 0, 0.5);
		
		final String result = coffeeMachine.toDMProtocol(wish);
		
		assertThat(result).isEqualTo("H::");
	}

	@Test
	public void should_reject_wish_without_enough_money(){
		final CustomerWish wish = new CustomerWish(CHOCOLATE, 0, 0.3);
		
		final String result = coffeeMachine.toDMProtocol(wish);
		
		assertThat(result).isEqualTo("M:0.2");
	}
	
	@Test
	public void should_make_drink_with_more_money(){
		final CustomerWish wish = new CustomerWish(COFFEE, 0, 0.7);
		
		final String result = coffeeMachine.toDMProtocol(wish);
		
		assertThat(result).isEqualTo("C::");
	}

	@Test
	public void should_make_orange_juice(){
		final CustomerWish wish = new CustomerWish(ORANGE, 0, 0.6);
		
		final String result = coffeeMachine.toDMProtocol(wish);
		
		assertThat(result).isEqualTo("O::");
	}
	
	@Test
	public void should_deliver_extra_hot_coffee_with_no_sugar(){
		final CustomerWish wish = new CustomerWish(COFFEE, 0, 0.6, true);
		
		final String result = coffeeMachine.toDMProtocol(wish);
		
		assertThat(result).isEqualTo("Ch::");
	}
	
	@Test
	public void should_deliver_extra_hot_chocolate_with_one_sugar_and_stick(){
		final CustomerWish wish = new CustomerWish(CHOCOLATE, 1, 0.5, true);
		
		final String result = coffeeMachine.toDMProtocol(wish);
		
		assertThat(result).isEqualTo("Hh:1:0");
	}
	
	@Test
	public void should_deliver_extra_hot_tea_with_two_sugar_and_sitck(){
		final CustomerWish wish = new CustomerWish(TEA, 2, 0.4, true);
		
		final String result = coffeeMachine.toDMProtocol(wish);
		
		assertThat(result).isEqualTo("Th:2:0");
	}
	
	@Test
	public void should_generate_report() {
		coffeeMachine.toDMProtocol(new CustomerWish(CHOCOLATE, 1, 0.5, true));
		coffeeMachine.toDMProtocol(new CustomerWish(ORANGE, 0, 0.6));
		coffeeMachine.toDMProtocol(new CustomerWish(TEA, 2, 0.4, true));
		coffeeMachine.toDMProtocol(new CustomerWish(CHOCOLATE, 1, 0.5, true));
		coffeeMachine.toDMProtocol(new CustomerWish(TEA, 2, 0.4, true));
		
		final Report report = coffeeMachine.getReport();
		
		assertThat(report).isNotNull();
		
		assertThat(report.getMoneyInTheBank().doubleValue()).isEqualTo(2.4);
		
		final Map<DrinkType, Integer> numberSoldByDrink = report.getNumberSoldByDrink();
		assertThat(numberSoldByDrink.get(ORANGE)).isEqualTo(1);
		assertThat(numberSoldByDrink.get(CHOCOLATE)).isEqualTo(2);
		assertThat(numberSoldByDrink.get(TEA)).isEqualTo(2);
	}
}
