package yongs.temp.db;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.cache.annotation.Cacheable;

import yongs.temp.dto.Product;

@Mapper
public interface ProductMapper {
	public List<Product> findAll();
	public Product findByCode(String code);
	@Cacheable(key = "#name", value = "findByName", cacheManager = "generic")
	public List<Product> findByName(String name);
	public void save(Product product);
}