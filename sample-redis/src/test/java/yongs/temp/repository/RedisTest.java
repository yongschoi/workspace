package yongs.temp.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import yongs.temp.dto.Product;

@SpringBootTest
public class RedisTest {
	@Autowired
	private ProductRedisRepository repo;
/*	
	@AfterEach
	public void tearDown() throws Exception {
		repo.deleteAll();
	}
*/
	@Test
	public void 기본_등록_조회() {
		String code = "10001";
		String name = "맥프로";
		LocalDateTime refreshTime = LocalDateTime.of(2020, 12, 04, 11, 12);
		Product product = new Product(code, name, 5000L, refreshTime);
		
		repo.save(product);
		
		Product savedProduct = repo.findById(code).get();
		assertThat(savedProduct.getAmount()).isEqualTo(5000L);
		// assertThat(savedProduct.getRefreshTime()).isEqualTo(refreshTime);	
	}
	
}
