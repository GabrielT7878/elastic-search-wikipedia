package com.javainuse.boot_elasticsearch_crud.repository;

import com.javainuse.boot_elasticsearch_crud.model.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.Optional;

public interface UserRepository extends ElasticsearchRepository<User, String> {
    Optional<User> findByEmail(String email);
}
