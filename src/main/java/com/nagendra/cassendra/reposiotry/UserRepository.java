package com.nagendra.cassendra.reposiotry;

import com.nagendra.cassendra.model.User;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CassandraRepository<User, Integer> {
}
