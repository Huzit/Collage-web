package com.n2015942043.main.domain;

import com.n2015942043.main.repository.BasicRepository;
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


    @Before
    public void init() {
        savedBasic = basicRepository.save(Basic.builder()
                .phone("000-0000-0001")
                .name("일을룡")
                .label("주전")
                .email("rung1@nate.com")
                .build());

        basicRepository.save(Basic.builder()
                .phone("000-0000-0002")
                .name("이을룡")
                .label("중전")
                .email("rung2@nate.com")
                .build());

        basicRepository.save(Basic.builder()
                .phone("000-0000-0003")
                .name("삼을룡")
                .label("상전")
                .email("rung3@nate.com")
                .build());
    }

    @Test
    public void readIDBoard(){
        Basic foundBasic = basicRepository.findById(savedBasic.getIdx()).orElse(null);
        assertThat(foundBasic.getIdx()).isEqualTo(savedBasic.getIdx());
    }

    @Test
    public void readBasicName(){
        Basic foundName = basicRepository.findByName("일을룡");
        assertThat(foundName.getName()).isEqualTo("일을룡");
    }

    @Test
    public void updateBasicName(){
        Basic updateName = basicRepository.findByName("이을룡");
        updateName.setName("이이을롱");
        updateName = basicRepository.save(updateName);

        assertThat(updateName.getName()).isEqualTo("이이을롱");
    }

    @Test
    public void deleteBasicName(){
        Basic deleteName = basicRepository.findByName("일을룡");
        basicRepository.delete(deleteName);

        Basic foundName = basicRepository.findByName("일을룡");
        assertThat(foundName).isNull();


    }
}
