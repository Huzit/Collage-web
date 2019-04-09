package com.sanghwan.web.domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BoardTest {
    private final String title = "테스트";
    private final String email = "test@gmail.com";

    private Board board;

    @Before
    public void init(){
        board = board.builder()
                .title(title)
                .subTitle("서브타이틀")
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build();
    }
    @Test
    public void printBoard(){System.out.println(board);}

}
