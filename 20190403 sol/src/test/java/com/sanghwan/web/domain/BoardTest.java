package com.sanghwan.web.domain;

import com.sanghwan.web.repository.BoardRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class BoardTest {

    @Autowired
    private BoardRepository boardRepository;

    private Board savedBoard;
    @Before
    public void init(){
    Board board= Board.builder()
            .title("title 0")
            .subTitle("title 1")
            .content("hello")
            .createdDate(LocalDateTime.now())
            .updatedDate(LocalDateTime.now())
            .build();//ID는 자동으로 생성해준다 따라서 우리가 안만듬 ㅇㅋ?
        savedBoard = boardRepository.save(board);
    }

    @Test
    public void testRead(){
        Board findBoard = boardRepository.findById(savedBoard.getIdx()).orElse(null);
        assertThat(findBoard.getIdx()).isEqualTo(savedBoard.getIdx());
    }
    /*public void testRead(){ //매우 조악한 방법을 이용했드아
        List<Board> all = boardRepository.findAll();
        if (all.size() ==1 )
            System.out.println("saved");
        else
            System.out.println("not saved");
    }*/
}
