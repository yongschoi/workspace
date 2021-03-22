package yongs.temp.config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;
import yongs.temp.vo.Coffee;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yogschoi@gmail.com on 2020-11-28
 * Github : http://github.com/yogschoi
 */
@Configuration
@EnableConfigurationProperties(KafkaProperties.class)
public class ProducerConfiguration {
    private final KafkaProperties properties;

    public ProducerConfiguration(KafkaProperties properties) {
        this.properties = properties;
    }

    @Bean
    public Map<String, Object> stringProducerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, properties.getBootstrapServers());
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

        return props;
    }
    @Bean
    public ProducerFactory<String, String> stringProducerFactory() {
        return new DefaultKafkaProducerFactory<>(stringProducerConfigs());
    }
    @Bean
    public KafkaTemplate<String, String> stringKafkaTemplate() {
        return new KafkaTemplate<>(stringProducerFactory());
    }

    @Bean
    public Map<String, Object> voProducerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, properties.getBootstrapServers());
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

        return props;
    }
    // 명시적으로 Type 지정
    @Bean
    public ProducerFactory<String, Coffee> voProducerFactory() {
        return new DefaultKafkaProducerFactory<>(voProducerConfigs());
    }
    @Bean
    public KafkaTemplate<String, Coffee> voKafkaTemplate() {
        return new KafkaTemplate<>(voProducerFactory());
    }

    // T type 지정
    @Bean
    public <T> ProducerFactory<String, T> tProducerFactory() {
        return new DefaultKafkaProducerFactory<>(voProducerConfigs());
    }
    @Bean
    public <T> KafkaTemplate<String, T> tKafkaTemplate() {
        return new KafkaTemplate<>(tProducerFactory());
    }
}
