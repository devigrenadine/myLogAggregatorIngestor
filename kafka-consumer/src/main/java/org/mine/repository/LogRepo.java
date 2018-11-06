package org.mine.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

/**
 * The Interface of CassandraRepository: LogRepo.
 */
@Repository
public interface LogRepo extends CassandraRepository<LogCassandra> {
    
}