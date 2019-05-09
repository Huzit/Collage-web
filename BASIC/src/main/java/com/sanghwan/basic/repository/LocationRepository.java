package com.sanghwan.basic.repository;

import com.sanghwan.basic.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
    Location findByAddress(String location);
}
