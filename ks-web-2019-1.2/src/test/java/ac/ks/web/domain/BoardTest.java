package ac.ks.web.domain;

import ac.ks.web.repository.BoardRepository;
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
    public void init() {
        savedBoard = boardRepository.save(Board.builder()
                .title("제목1")
                .subTitle("부제목1")
                .content("내용1")
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build());

        boardRepository.save(Board.builder()
                .title("제목2")
                .subTitle("부제목2")
                .content("내용2")
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build());

        boardRepository.save(Board.builder()
                .title("제목3")
                .subTitle("부제목3")
                .content("내용3")
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build());

        boardRepository.save(Board.builder()
                .title("제목3")
                .subTitle("부제목3")
                .content("내용3")
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build());
    }

    @Test
    public void testFindIDBoard() {
        Board foundBoard = boardRepository.findById(savedBoard.getIdx()).orElse(null);
        assertThat(foundBoard.getIdx()).isEqualTo(savedBoard.getIdx());
    }

    @Test
    public void testFindAllBoard() {
        List<Board> findAllBoard = boardRepository.findAllByTitle("제목3");
        assertThat(findAllBoard.size()).isEqualTo(2);
    }

    @Test
    public void testFindTitleBoard() {
        Board findTitleBoard = boardRepository.findFirstByTitle("제목1");
        assertThat(findTitleBoard.getTitle()).isEqualTo("제목1");
    }

    @Test
    public void testUpdateTitleBoard() {
        Board updateTitleBoard = boardRepository.findFirstByTitle("제목1");
        updateTitleBoard.setTitle("제목1-수정");
        updateTitleBoard = boardRepository.save(updateTitleBoard);

        assertThat(updateTitleBoard.getTitle()).isEqualTo("제목1-수정");
    }

    @Test
    public void testDeleteTitleBoard() {
        Board deleteTitleBoard = boardRepository.findFirstByTitle("제목1");
        boardRepository.delete(deleteTitleBoard);

        Board findTitleBoard = boardRepository.findFirstByTitle("제목1");

        assertThat(findTitleBoard).isNull();
    }
    
}
