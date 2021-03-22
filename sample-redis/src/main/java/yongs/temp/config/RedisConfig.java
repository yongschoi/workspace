package yongs.temp.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.*;
import yongs.temp.vo.Member;
import yongs.temp.vo.User;

/**
 * Created by yogschoi@gmail.com on 2020-11-30
 * Github : http://github.com/yogschoi
 */
@Configuration
public class RedisConfig {
    @Autowired
    ObjectMapper mapper;
    // RedisTemplate<String, String>는 default로 제공함.
    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        LettuceConnectionFactory lettuceConnectionFactory = new LettuceConnectionFactory();
        return lettuceConnectionFactory;
    }
    @Bean
    public RedisTemplate<String, User> redisUserTemplate() {
        RedisTemplate<String, User> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory());

        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(User.class));

        return redisTemplate;
    }
    @Bean
    public RedisTemplate<String, Member> redisMemberTemplate() {
        RedisTemplate<String, Member> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory());

        redisTemplate.setKeySerializer(new StringRedisSerializer());

        Jackson2JsonRedisSerializer serializer = new Jackson2JsonRedisSerializer(Member.class);
        serializer.setObjectMapper(mapper);
        redisTemplate.setValueSerializer(serializer);

        // Hash Operation 사용 시
        // redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        // redisTemplate.setHashValueSerializer(new Jackson2JsonRedisSerializer<>(Member.class));

        return redisTemplate;
    }

    // 불완전한 ValueSerializer
    @Bean
    public <T> RedisTemplate<String, T> redisTypeTemplate() {
        RedisTemplate<String, T> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory());

        RedisSerializer<String> serializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(serializer);
        redisTemplate.setHashKeySerializer(serializer);

        // redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        // redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());

        return redisTemplate;
    }
    /*
    // 결국은 StringRedisSerializer
    @Bean
    public RedisTemplate<String, Object> redisObjectTemplate() {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory());

        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());

        // Hash Operation 사용 시
        redisTemplate.setHashValueSerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new StringRedisSerializer());

        // Jackson2JsonRedisSerializer serializer = new Jackson2JsonRedisSerializer(Object.class);
        // serializer.setObjectMapper(mapper);
        // redisTemplate.setValueSerializer(serializer);


        return redisTemplate;
    }
    */

}
