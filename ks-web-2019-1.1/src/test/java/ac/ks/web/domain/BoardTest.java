package ac.ks.web.domain;

import ac.ks.web.repository.BoardRepository;
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
    }

    @Test
    public void testFindBoard() {
        Board foundBoard = boardRepository.findById(savedBoard.getIdx()).orElse(null);
        assertThat(foundBoard.getIdx()).isEqualTo(savedBoard.getIdx());

    }
}
