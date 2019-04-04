package ac.ks.web.domain;

import ac.ks.web.Repository.BoardRepository;
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

    private Board savedBoard; //스코프가 막혔기 때문에 스코프를 열어주었다.
    @Before //읽기테스트를 위해 여기서 만들어놓는다.
    public void init(){
        Board board = Board.builder()
                .title("제목1")
                .subTitle("부제목1")
                .content("Hello")
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build();//id는 디비에서 자동으로 생성해준다.
        savedBoard = boardRepository.save(board);
    }

    @Test //Runnable methods에 대응책
    public void testRead() {
        Board findBoard = boardRepository.findById(savedBoard.getIdx()).orElse(null);

        //findBoard.getIdx() == savedBoard.getIdx();  우리의 목표
        //findBoard.getContent() == savedBoard.getContent();

        assertThat(findBoard.getIdx()).isEqualTo(savedBoard.getIdx());

    }
    /*public void testCreateObject(){
        List<Board> all = boardRepository.findAll();
        if(all.size() == 1){
            System.out.println("saved");
        } else{
            System.out.println("not saved");
        }*/


}
