package org.mine.thriftClient;

import java.util.Calendar;
import java.util.UUID;

import org.apache.thrift.TException;
import org.mine.myThrift.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * The Class LogServiceThriftController.
 */

@Service
public class LogServiceThriftController {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(LogServiceThriftController.class);

	/** The log service thrift client. */
	@Autowired
	LogServiceThriftClient logServiceThriftClient;

	/**
	 * Send random log on a fixedRateString of milliseconds specified in the
	 * application.properties file
	 */
	@Scheduled(fixedRateString = "${millis.between.messages}")
	public void sendRandomLog() {
		final Log log = createLog();
		try {
			System.out.println("log: " + log);
			logServiceThriftClient.send(log);
		} catch (TException e) {
			LOGGER.error(String.format("An error occurred while sending the log: [%s]", log.toString()), e);
		}
	}

	/**
	 * Creates the log.
	 *
	 * @return the log
	 */
	public Log createLog() {

		// version value is '1' for our project
		// TODO add it as an argument
		final short version = 1;

		Log log = new Log();
		// The following three setters were automatically created and their definition
		// lies on Log.java
		log.setV(version);
		log.setTime(Calendar.getInstance().getTimeInMillis());
		log.setM(UUID.randomUUID().toString());

		return log;

	}
}
