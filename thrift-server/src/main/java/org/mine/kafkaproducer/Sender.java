package org.mine.kafkaproducer;

import org.mine.myThrift.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

/** 
 * The kafka producer sends data to a specified kafka topic
 * 
 * *NOTE* : default-topic is configurable as all value annotated parameters in
 * our module application.properties 
 *
 */
@Service
public class Sender {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);

	/** The kafka template. */
	@Autowired
	private KafkaTemplate<String, Log> kafkaTemplate;

	/** The topic. */
	@Value("${spring.kafka.template.default-topic}")
	private String topic;

	/**
	 * Send.
	 *
	 * @param log the log
	 * @return the listenable future
	 */
	public ListenableFuture<SendResult<String, Log>> send(Log log) {
		LOGGER.info("sending log='{}' to topic='{}'", log, topic);
		return kafkaTemplate.send(topic, log);
	}
}
