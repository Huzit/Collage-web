package com.sanghwan.basic.repository;

import com.sanghwan.basic.domain.Work;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkRepository extends JpaRepository<Work, Long> {
    Work findByCompany(String company);
}
