package yongs.temp.db;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import yongs.temp.dto.Food;

@Mapper
public interface FoodMapper {
	public List<Food> findByCartNo(int cartno);
}