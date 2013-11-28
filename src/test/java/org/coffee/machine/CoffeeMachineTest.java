package org.coffee.machine;

import static org.coffee.machine.pojo.DrinkType.CHOCOLATE;
import static org.coffee.machine.pojo.DrinkType.COFFEE;
import static org.coffee.machine.pojo.DrinkType.TEA;
import static org.fest.assertions.Assertions.assertThat;

import org.coffee.machine.pojo.CustomerWish;
import org.junit.Test;


public class CoffeeMachineTest {
	private final CoffeeMachine coffeeMachine = new CoffeeMachine();
	
	@Test
	public void should_convert_tea_wish_with_sugar() {
		final CustomerWish wish = new CustomerWish(TEA, 1);
		
		final String result = coffeeMachine.toDMProtocol(wish);
		
		assertThat(result).isEqualTo("T:1:0");
	}
	
	@Test
	public void should_convert_coffee_wish_with_sugars() {
		final CustomerWish wish = new CustomerWish(COFFEE, 2);
		
		final String result = coffeeMachine.toDMProtocol(wish);
		
		assertThat(result).isEqualTo("C:2:0");
	}
	
	@Test
	public void should_convert_chocolate_wish_without_sugar() {
		final CustomerWish wish = new CustomerWish(CHOCOLATE, 0);
		
		final String result = coffeeMachine.toDMProtocol(wish);
		
		assertThat(result).isEqualTo("H::");
	}

}
