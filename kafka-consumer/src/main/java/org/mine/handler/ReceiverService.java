package org.mine.handler;

import org.mine.repository.LogCassandra;

/**
 * The Interface ReceiverService.
 * 
 */
public interface ReceiverService {
	
	/**
	 * Store log.
	 *
	 * @param logCassandra the log cassandra
	 */
	void storeLog(LogCassandra logCassandra);
}
