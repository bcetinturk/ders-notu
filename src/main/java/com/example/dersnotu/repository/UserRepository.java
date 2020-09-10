package com.example.dersnotu.repository;

import com.example.dersnotu.entity.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.Optional;

public interface UserRepository extends ElasticsearchRepository<User, String> {
    Optional<User> findByEmail(String email);
}
