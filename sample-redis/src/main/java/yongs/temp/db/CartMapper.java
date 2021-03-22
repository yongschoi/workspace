package yongs.temp.db;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import yongs.temp.dto.Cart;

@Mapper
public interface CartMapper {
	public List<Cart> findAll();
	public Cart findByCartNo(int cartno);
}