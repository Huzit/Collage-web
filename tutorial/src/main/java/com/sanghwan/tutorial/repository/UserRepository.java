package com.sanghwan.tutorial.repository;

import com.sanghwan.tutorial.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
