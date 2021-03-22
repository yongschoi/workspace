package yongs.temp.servie;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import yongs.temp.db.CartMapper;
import yongs.temp.db.FoodMapper;
import yongs.temp.dto.Cart;
import yongs.temp.dto.Food;

@Service
public class CartService {
	@Autowired
	CartMapper cartMapper;
	@Autowired
	FoodMapper foodMapper;
	
	public List<Cart> findAll() {
		List<Cart> cartList = cartMapper.findAll();
		cartList.forEach(i -> {
			List<Food> foodList = foodMapper.findByCartNo(i.getCartno());
			i.setFood(foodList);
		});

		return cartList; 
	}
	@Cacheable(key = "#cartno", value = "findByCartNo", cacheManager = "generic")
	public Cart findByCartNo(int cartno) {
		Cart cart = cartMapper.findByCartNo(cartno);
		List<Food> foodList = foodMapper.findByCartNo(cartno);
		cart.setFood(foodList);
		
		return cart;
	}
}
