package yongs.temp.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import yongs.temp.db.ProductMapper;
import yongs.temp.dto.Product;

@SpringBootTest
public class MysqlTest {
    @Autowired
    private ProductMapper mapper;
    
	@Test
	public void 기본_등록_조회() {
		String code = "10001";
		String name = "맥프로";
		LocalDateTime refreshTime = LocalDateTime.of(2020, 12, 04, 11, 12);
		Product product = new Product(code, name, 50L, refreshTime);		
		mapper.save(product);
		
		Product savedProduct = mapper.findByCode(code);
		assertThat(savedProduct.getAmount()).isEqualTo(50L);
		// assertThat(savedProduct.getRefreshTime()).isEqualTo(refreshTime);	
	}

	@Test
	public void Product_멀티_등록() {
		IntStream.rangeClosed(1, 10000).forEach(i -> {			
			LocalDateTime refreshTime = LocalDateTime.now();
			Product product = new Product("code-"+i, "note-"+i, 50L+i, refreshTime);
			mapper.save(product);
        });
		
		
	}
	
	@Test
	public void Product_조회() {
		List<Product> list = mapper.findByName("note");
		for (Product product : list) {
			System.out.println(product.getName() + "  " + product.getRefreshTime().getHour());	
		}
	}
}
