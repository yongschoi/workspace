package yongs.temp.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import yongs.temp.vo.Member;
import yongs.temp.vo.Product;
import yongs.temp.vo.TObject;
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
public class RedisConfigTest {
    @Autowired
    ObjectMapper mapper;
    @Autowired
    RedisTemplate<String, String> strTemplate;
    @Autowired
    RedisTemplate<String, User> userTemplate;
    @Autowired
    RedisTemplate<String, Member> memberTemplate;
    @Autowired
    RedisTemplate<String, Product> pTemplate;
    @Autowired
    RedisTemplate<String, TObject> tTemplate;

    @Test
    public void REDIS_기본_String_GET_SET() {
        String value = "I'm 홍길동";

        ValueOperations<String, String> redis = strTemplate.opsForValue();
        redis.set("test", value);
        Assertions.assertThat(redis.get("test")).isEqualTo(value);
    }
    @Test
    public void REDIS_기본_User_GET_SET() {
        Product p1 = new Product("101", "노트북");
        Product p2 = new Product("102", "마스크");
        List<Product> pList = new ArrayList<>();
        pList.add(p1);
        pList.add(p2);

        User value = new User("hong", "홍길동", pList);

        ValueOperations<String, User> redis = userTemplate.opsForValue();
        redis.set("user", value);
        Assertions.assertThat(redis.get("user").toString()).isEqualTo(value.toString());
    }

    @Test
    public void REDIS_기본_Member_GET_SET() {
        Product p1 = new Product("101", "노트북");
        Product p2 = new Product("102", "마스크");
        List<Product> pList = new ArrayList<>();
        pList.add(p1);
        pList.add(p2);
        Member value = new Member("hong", "홍길동", LocalDate.now(), pList);

        ValueOperations<String, Member> redis = memberTemplate.opsForValue();
        redis.set("test", value);
        Assertions.assertThat(redis.get("test").toString()).isEqualTo(value.toString());
    }


    /*
     * 저장은 JSON Type으로 저장되고
     * Object 로 그냥 저장하면 get 해오면 Hash type이 된다.
     */
    @Test
    public void REDIS_기본_JSON_STRING_GET_SET() throws IOException {
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

    @Test
    public void REDIS_기본_Type_GET_SET() throws IOException {
        Product value = new Product("1001", "모자");

        ValueOperations<String, Product> redis = pTemplate.opsForValue();
        redis.set("abc", value);
        Product result = redis.get("abc");
        Assertions.assertThat(result.toString()).isEqualTo(value.toString());
    }

    @Test
    public void REDIS_Serializable_Object_Type_GET_SET() throws IOException {
        TObject value = new TObject("1001", "모자", LocalDate.now());

        ValueOperations<String, TObject> redis = tTemplate.opsForValue();
        redis.set("abc", value);
        TObject result = redis.get("abc");
        Assertions.assertThat(result.toString()).isEqualTo(value.toString());
    }

}
