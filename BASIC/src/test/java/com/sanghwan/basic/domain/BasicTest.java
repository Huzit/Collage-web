package com.sanghwan.basic.domain;

import com.sanghwan.basic.repository.BasicRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BasicTest {

    @Autowired
    private BasicRepository basicRepository;

    private Basic savedBasic;

    @Before //C
    public void init(){
        savedBasic = basicRepository.save(Basic.builder()
                .name("홍길동")
                .label("웹 프로그래머")
                .email("홍길동@메일주소.도메인")
                .phone("000-1234-5678")
                .build());
    }

    @Test //R
    public void TestReadBasic(){
        Basic findbyId = basicRepository.findById(savedBasic.getIdx()).orElse(null);
        assertThat(findbyId.getIdx()).isEqualTo(savedBasic.getIdx());

        Basic findByName = basicRepository.findByName("홍길동");
        assertThat(findByName.getName()).isEqualTo("홍길동");
        assertThat(findByName.getName()).isNotEqualTo("박상환");
    }

}
