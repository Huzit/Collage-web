package com.sanghwan.basic.repository;

import com.sanghwan.basic.domain.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
    Profile findByNetwork(String network);
}
