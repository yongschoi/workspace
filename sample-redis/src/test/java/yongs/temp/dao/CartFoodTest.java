package yongs.temp.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import yongs.temp.dto.Cart;
import yongs.temp.dto.Food;
import yongs.temp.servie.CartService;

@SpringBootTest
public class CartFoodTest {
    @Autowired
    CartService service;
    
	@Test
	public void 기본_Cart_조회() {
		Cart cart = service.findByCartNo(1);
		
		System.out.println("----------------------------------");

		List<Food> foodList = cart.getFood();
		for (Food food : foodList) {
			System.out.println(food.getName());
		}
		System.out.println("----------------------------------");
		
		// assertThat(cart.getColor()).isEqualTo("red");
		// assertThat(savedProduct.getRefreshTime()).isEqualTo(refreshTime);	
	}
}
