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

}
