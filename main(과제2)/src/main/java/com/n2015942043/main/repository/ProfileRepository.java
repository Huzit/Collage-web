package com.n2015942043.main.repository;

import com.n2015942043.main.domain.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
    Profile findProfileByNetwork(final String network);
}
