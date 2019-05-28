package com.n2015942043.main.repository;

import com.n2015942043.main.domain.Basic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasicRepository extends JpaRepository<Basic, Long> {
    Basic findByName(final String name);
    Basic findByIdx(final Long idx);
}
