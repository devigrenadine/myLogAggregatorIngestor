package org.mine.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.java.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.mapping.BasicCassandraMappingContext;
import org.springframework.data.cassandra.mapping.CassandraMappingContext;

/**
 * The Class CassandraConfig.
 */
@Configuration
public class CassandraConfig extends AbstractCassandraConfiguration {

	@Value("${spring.data.cassandra.keyspace-name}")
	private String keySpaceName;

	@Value("${spring.data.cassandra.contact-points}")
	private String contactpoints;
	
	@Value("${spring.data.cassandra.port}")
	private int cassandraport;

	/**
	 * Gets the keyspace name.
	 *
	 * @return the keyspace name
	 */
	@Override
	protected String getKeyspaceName() {
		return keySpaceName;
	}

	/**
	 * Cluster.
	 *
	 * @return the cassandra cluster factory bean
	 */
	@Bean
	public CassandraClusterFactoryBean cluster() {
		CassandraClusterFactoryBean cluster = new CassandraClusterFactoryBean();
		cluster.setContactPoints(contactpoints);
		cluster.setPort(cassandraport);
		return cluster;
	}

	/**
	 * Cassandra mapping.
	 *
	 * @return the cassandra mapping context
	 * @throws ClassNotFoundException the class not found exception
	 */
	@Bean
	public CassandraMappingContext cassandraMapping() throws ClassNotFoundException {
		return new BasicCassandraMappingContext();
	}
}