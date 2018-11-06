package org.mine.repository;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.cassandra.core.Ordering;
import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * The Class LogCassandra.
 * the Cassandra DB log table structure
 */
@Table
@Getter
@Setter
@ToString
public class LogCassandra {

	/** The time. */
	@PrimaryKeyColumn(name = "time", ordinal = 0, type = PrimaryKeyType.PARTITIONED, ordering = Ordering.ASCENDING)
	private LocalDateTime time;

	/** The id. */
	@PrimaryKeyColumn(name = "id", ordinal = 1, type = PrimaryKeyType.PARTITIONED)
	private UUID id;

	/** The version. */
	@Column("v")
	private short version;

	/** The log. */
	@Column("m")
	private String log;

	/**
	 * Instantiates a new log cassandra.
	 *
	 * @param time    the time
	 * @param id      the id
	 * @param version the version
	 * @param log     the log
	 */
	public LogCassandra(LocalDateTime time, UUID id, short version, String log) {
		this.time = time;
		this.version = version;
		this.id = id;
		this.log = log;
	}

}