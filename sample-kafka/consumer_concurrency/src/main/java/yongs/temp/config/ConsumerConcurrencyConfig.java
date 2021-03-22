package yongs.temp.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import yongs.temp.vo.Coffee;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yogschoi@gmail.com on 2020-11-28
 * Github : http://github.com/yogschoi
 */
@Configuration
@EnableConfigurationProperties(KafkaProperties.class)
public class ConsumerConcurrencyConfig {
    private final KafkaProperties properties;

    public ConsumerConcurrencyConfig(KafkaProperties properties) {
        this.properties = properties;
    }

    @Bean
    public Map<String, Object> concurrencyConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, properties.getBootstrapServers());
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "starbucks");
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        return props;
    }

    @Bean
    public ConsumerFactory<String, Coffee> concurrencyConsumerFactory() {
        return new DefaultKafkaConsumerFactory<>(concurrencyConfigs(), new StringDeserializer(),
                new JsonDeserializer<>(Coffee.class,false));
    }

    @Bean("concurrencyFactory")
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, Coffee>> concurrencyFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Coffee> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(concurrencyConsumerFactory());
        factory.setConcurrency(5);
        return factory;
    }
}
