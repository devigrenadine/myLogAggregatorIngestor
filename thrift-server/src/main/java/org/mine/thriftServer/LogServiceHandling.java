package org.mine.thriftServer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.thrift.TException;
import org.mine.kafkaproducer.Sender;
import org.mine.myThrift.Log;
import org.mine.myThrift.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * The Class LogServiceHandling implements the LogService Interface
 * and sends the Log received from Thrift Client
 * using the sender i.e. our Kafka Producer
 * 
 */
@Service
public class LogServiceHandling implements LogService.Iface {
	
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(LogServiceHandling.class);
    
	/** The sender. */
	@Autowired
	Sender sender;

	/**
	 * Gets the log.
	 *
	 * @param log the log
	 * @return the log
	 */
	@Override
	public void getLog(Log log) {

		ListenableFuture<SendResult<String, Log>> future = sender.send(log);
		future.addCallback(new ListenableFutureCallback<SendResult<String, Log>>() {
			@Override
			public void onFailure(Throwable ex) {
				LOGGER.info("Failure while sending log: ", log +" to Kafka");
			}

			@Override
			public void onSuccess(SendResult<String, Log> result) {
				LOGGER.info("Success for sending log ", log +" to Kafka");
			}
		});

	}
}
