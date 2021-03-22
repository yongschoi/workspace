package yongs.temp.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import yongs.temp.vo.Member;
import yongs.temp.vo.Product;
import yongs.temp.vo.User;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yogschoi@gmail.com on 2020-12-01
 * Github : http://github.com/yogschoi
 */
@SpringBootTest
public class RedisConfigMultiTest {
    @Autowired
    ObjectMapper mapper;
    @Autowired
    RedisTemplate<String, String> strTemplate;
    @Autowired
    RedisTemplate<String, Member> memberTemplate;

    @Test
    public void REDIS_멀티_Member_GET_SET() {
        final String key = "multi-data";

        Product p1 = new Product("101", "노트북");
        Product p2 = new Product("102", "마스크");
        List<Product> pList = new ArrayList<>();
        pList.add(p1);
        pList.add(p2);
        Member value1 = new Member("hong", "홍길동", LocalDate.now(), pList);
        Member value2 = new Member("kang", "강길동", LocalDate.now(), pList);
        Member value3 = new Member("park", "박길동", LocalDate.now(), pList);

        ListOperations<String, Member> listOperations = memberTemplate.opsForList();
        listOperations.rightPush(key, value1);
        listOperations.rightPush(key, value2);
        listOperations.rightPush(key, value3);

        Member value4 = new Member("kim", "김길동", LocalDate.now(), pList);
        Member value5 = new Member("lee", "이길동", LocalDate.now(), pList);
        listOperations.rightPushAll(key, value4, value5);

        Assertions.assertThat(listOperations.size(key)).isEqualTo(5);
    }
    /*
     * 저장은 JSON Type으로 저장되고
     * Object 로 그냥 저장하면 get 해오면 Hash type이 된다.
     */
    @Test
    public void REDIS_멀티_JSON_STRING_GET_SET() throws IOException {
        Product p1 = new Product("101", "노트북");
        Product p2 = new Product("102", "마스크");
        List<Product> pList = new ArrayList<>();
        pList.add(p1);
        pList.add(p2);

        Member value = new Member("kim", "김길동", LocalDate.now(), pList);

        String memberStr = mapper.writeValueAsString(value);
        ValueOperations<String, String> redis = strTemplate.opsForValue();
        redis.set("test", memberStr);
        Member result = mapper.readValue(redis.get("test"), Member.class);
        Assertions.assertThat(result.toString()).isEqualTo(value.toString());
    }
}
