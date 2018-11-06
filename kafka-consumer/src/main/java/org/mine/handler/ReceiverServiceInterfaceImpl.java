package org.mine.handler;

import org.mine.repository.LogCassandra;
import org.mine.repository.LogRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * The Class ReceiverServiceInterfaceImpl.
 * The implementation of the ReceiverService
 */
@Service
public class ReceiverServiceInterfaceImpl implements ReceiverService {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(ReceiverServiceInterfaceImpl.class);

	/** The log repo. */
	@Autowired
	LogRepo logRepo;

	/**
	 * Store logCassandra to Cassandra DB using LogRepo.
	 * We catch a RuntimeException for logging purposes and re-throw it
	 * as a best practice 
	 *
	 * @param logCassandra the log cassandra
	 */
	@Override
	public void storeLog(LogCassandra logCassandra) {
		LOGGER.info("Commiting log: [{}]", logCassandra);
		try {
			logRepo.save(logCassandra);
		} catch (RuntimeException e) {
			LOGGER.error(String.format("An error occurred while commiting log: [%s]", logCassandra.toString()), e);
			throw(e);
		}
	}
}