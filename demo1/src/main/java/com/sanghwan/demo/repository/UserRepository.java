package com.sanghwan.demo.repository;

import com.sanghwan.demo.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
