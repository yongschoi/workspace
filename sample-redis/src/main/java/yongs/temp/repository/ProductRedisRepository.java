package yongs.temp.repository;

import org.springframework.data.repository.CrudRepository;

import yongs.temp.dto.Product;

public interface ProductRedisRepository extends CrudRepository<Product, String> {

}
