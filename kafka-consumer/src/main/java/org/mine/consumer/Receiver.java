package org.mine.consumer;

import org.mine.converter.LogConverter;
import org.mine.handler.ReceiverService;
import org.mine.myThrift.Log;
import org.mine.repository.LogCassandra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * The kafka consumer listens to the consume topic and
 * passes the received log to a Receiver Service logService 
 */
@Service
public class Receiver {

	/** The log service. */
	@Autowired
	ReceiverService logService;

	@Autowired
	Converter<Log, LogCassandra> logConverter;

	/**
	 * Consume.
	 *
	 * @param log the log
	 */
	@KafkaListener(topics = "${consume.topic}")
	public void consume(Log log) {
		logService.storeLog(logConverter.convert(log));
	}
}