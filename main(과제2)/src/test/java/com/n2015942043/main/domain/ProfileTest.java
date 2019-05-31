package com.n2015942043.main.domain;

import com.n2015942043.main.repository.ProfileRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProfileTest {
    @Autowired
    private ProfileRepository profileRepository;

    private Profile savedProfile;

    @Before
    public void createProfile() {
        savedProfile = profileRepository.save(Profile.builder()
                .url("인스타")
                .username("@rung")
                .network("www.instragram.com")
                .createDat(LocalDateTime.now())
                .build());

        profileRepository.save(Profile.builder()
                .url("페이스북")
                .username("@rung")
                .network("www.facebook.com")
                .createDat(LocalDateTime.now())
                .build());

        profileRepository.save(Profile.builder()
                .url("트위터")
                .username("@rung")
                .network("www.twitter.com")
                .createDat(LocalDateTime.now())
                .build());
    }

    @Test
    public void readProfileId(){
        Profile foundProfile = profileRepository.findById(savedProfile.getIdx()).orElse(null);
        assertThat(foundProfile.getIdx()).isEqualTo(savedProfile.getIdx());
    }

    @Test
    public void readProfileUrl(){
        Profile foundProfile = profileRepository.findByUrl("인스타");
        assertThat(foundProfile.getUrl()).isEqualTo("인스타");
    }

    @Test
    public void updateProfile(){
        Profile updateProfile = profileRepository.findByUrl("페이스북");
        updateProfile.setUrl("디시인사이드");
        updateProfile = profileRepository.save(updateProfile);

        assertThat(updateProfile.getUrl()).isEqualTo("디시인사이드");
    }

    @Test
    public void deleteProfile(){
        Profile deleteProfile = profileRepository.findByUrl("인스타");
        profileRepository.delete(deleteProfile);

        Profile foundProfile = profileRepository.findByUrl("인스타");
        assertThat(foundProfile).isNull();

    }
}
