package org.mine.consumer;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.mine.myThrift.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * The Kafka consumer configuration.
 */
@EnableKafka
@Configuration
public class ReceiverConfig {

	/** The bootstrap servers. */
	@Value("${spring.kafka.bootstrap-servers}")
	private String bootstrapServers;

	/**
	 * Consumer factory.
	 *
	 * @return the consumer factory
	 */
	@Bean
	public ConsumerFactory<String, Log> consumerFactory() {
		return new DefaultKafkaConsumerFactory<>(this.consumerConfig());
	}

	/**
	 * Kafka listener container factory.
	 *
	 * @return the concurrent kafka listener container factory
	 */
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, Log> kafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, Log> containerFactory = new ConcurrentKafkaListenerContainerFactory<>();
		containerFactory.setConsumerFactory(consumerFactory());
		return containerFactory;
	}

	/**
	 * Consumer config.
	 *
	 * @return the Kafka related properties map
	 */
	@Bean
	public Map<String, Object> consumerConfig() {
		Map<String, Object> props = new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		props.put(ConsumerConfig.GROUP_ID_CONFIG, UUID.randomUUID().toString());
		props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, LogDeserializer.class);
		return props;
	}

	/**
	 * Receiver.
	 *
	 * @return the receiver i.e. the Kafka Consumer
	 */
	@Bean
	public Receiver receiver() {
		return new Receiver();
	}
}
