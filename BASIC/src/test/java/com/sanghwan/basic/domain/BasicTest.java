package com.sanghwan.basic.domain;

import com.sanghwan.basic.repository.BasicRepository;
import com.sanghwan.basic.repository.LocationRepository;
import com.sanghwan.basic.repository.ProfileRepository;
import com.sanghwan.basic.repository.WorkRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.Table;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BasicTest {

    @Autowired
    private BasicRepository basicRepository;
    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private WorkRepository workRepository;

    private Basic savedBasic;
    private Location savedLocation;
    private Profile savedprofile;
    private Work savedwork;

    @Before //C
    public void init(){
        savedBasic = basicRepository.save(Basic.builder()
                .name("홍길동")
                .label("웹 프로그래머")
                .email("홍길동@메일주소.도메인")
                .phone("000-1234-5678")
                .build());

        savedLocation = locationRepository.save(Location.builder()
                .address("부산광역시 OO구 OO번길 OOO")
                .postcode("12345")
                .build());

        savedprofile = profileRepository.save(Profile.builder()
                .network("Twitter")
                .userName("홍길동")
                .url("http://www.twitter.com/홍길동")
                .build());

        savedwork = workRepository.save(Work.builder()
                .company("(주)홍길동")
                .position("개발자")
                .website("http://www.company.domain")
                .startdate(LocalDateTime.now())
                .enddate(LocalDateTime.now())
                .summry("...요약").build());
    }

    @Test //R
    public void TestReadBasic(){
        //Basic
        Basic findbyId = basicRepository.findById(savedBasic.getIdx()).orElse(null);
        assertThat(findbyId.getIdx()).isEqualTo(savedBasic.getIdx());

        Basic findByName = basicRepository.findByName("홍길동");
        assertThat(findByName.getName()).isEqualTo("홍길동");
        assertThat(findByName.getName()).isNotEqualTo("박상환");
    }

    @Test
    public void TestReadLocation(){
        //Location
        Location findbyId1 = locationRepository.findById(savedLocation.getIdx()).orElse(null);
        assertThat(findbyId1.getIdx()).isEqualTo(savedLocation.getIdx());

        Location findbyAddress = locationRepository.findByAddress("부산광역시 OO구 OO번길 OOO");
        assertThat(findbyAddress.getAddress()).isEqualTo("부산광역시 OO구 OO번길 OOO");
        assertThat(findbyAddress.getAddress()).isNotEqualTo("부산광역시 사하구 27번길 102");
    }

    @Test
    public void TestReadProfile(){
        //Profile
        Profile findById2 = profileRepository.findById(savedprofile.getIdx()).orElse(null);
        assertThat(findById2.getIdx()).isEqualTo(savedprofile.getIdx());

        Profile findByNetwork = profileRepository.findByNetwork(savedprofile.getNetwork());
        assertThat(findByNetwork.getNetwork()).isEqualTo("Twitter");
        assertThat(findByNetwork.getNetwork()).isNotEqualTo("Facebook");
    }

    @Test
    public void TestReadWork(){
        //Work
        Work findById3 = workRepository.findById(savedwork.getIdx()).orElse(null);
        assertThat(findById3.getIdx()).isEqualTo(savedwork.getIdx());

        Work findByCompany = workRepository.findByCompany(savedwork.getCompany());
        assertThat(findByCompany.getCompany()).isEqualTo("(주)홍길동");
        assertThat(findByCompany.getCompany()).isNotEqualTo("(주)고길동");
    }

}
