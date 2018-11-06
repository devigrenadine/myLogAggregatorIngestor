package org.mine.kafkaproducer;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.mine.myThrift.Log;
import org.mine.myThrift.LogService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * The Class SenderConfig.
 * Kafka Producer configuration
 */
@Configuration
@EnableKafka
public class SenderConfig {

	/** The bootstrap servers. */
	@Value("${spring.kafka.bootstrap-servers}")
	private String bootstrapServers;

	/** The default topic. */
	@Value("${spring.kafka.template.default-topic}")
	private String defaultTopic;

	/**
	 * Kafka Producer properties configuration
	 * 
	 * @return the map
	 */
	@Bean
	public Map<String, Object> producerConfigs() {
		Map<String, Object> props = new HashMap<>();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, LogSerializer.class);
		return props;
	}

	/**
	 * Producer factory.
	 *
	 * @return the producer factory
	 */
	@Bean
	public ProducerFactory<String, Log> producerFactory() {
		return new DefaultKafkaProducerFactory<>(producerConfigs());
	}

	/**
	 * Kafka template.
	 *
	 * @return the kafka template
	 */
	@Bean
	public KafkaTemplate<String, Log> kafkaTemplate() {
		final KafkaTemplate<String, Log> kafkaTemplate = new KafkaTemplate<>(producerFactory());
		kafkaTemplate.setDefaultTopic(defaultTopic);
		return kafkaTemplate;
	}

}
