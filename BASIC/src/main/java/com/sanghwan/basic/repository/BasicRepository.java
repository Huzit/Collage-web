package com.sanghwan.basic.repository;

import com.sanghwan.basic.domain.Basic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasicRepository extends JpaRepository<Basic, Long> {
    Basic findByName(final String name);
}
