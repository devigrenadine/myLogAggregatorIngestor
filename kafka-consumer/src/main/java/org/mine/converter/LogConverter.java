package org.mine.converter;

import org.mine.myThrift.Log;
import org.mine.repository.LogCassandra;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

/**
 * The Class LogConverter.
 *
 */
@Component
public class LogConverter implements Converter<Log, LogCassandra> {

	/**
	 * Convert.
	 * The oblect log gets converted to a cassandra log 
	 * thus prepared for cassandra DB insertion
	 *
	 * @param log the log
	 * @return the log cassandra
	 */
	@Override
	public LogCassandra convert(Log log) {
		return new LogCassandra(
				LocalDateTime.ofInstant(Instant.ofEpochMilli(log.getTime()), ZoneId.systemDefault()),
				UUID.randomUUID(),
				log.getV(), 
				log.getM());
	}
}