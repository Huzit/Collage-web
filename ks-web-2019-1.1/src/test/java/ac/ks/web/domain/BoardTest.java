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

    @Before //C
    public void init() {
        savedBoard = boardRepository.save(Board.builder()
                .title("제목1")
                .subTitle("부제목1")
                .content("내용1")
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build());
    }

    @Test //R
    public void testFindBoard() {
        Board foundBoard = boardRepository.findById(savedBoard.getIdx()).orElse(null);
        assertThat(foundBoard.getIdx()).isEqualTo(savedBoard.getIdx());
        //만약 boardRepository의 ID랑 savedBoard의 ID가 다르면 널 같으면 ????
        List<Board> findByTitle = boardRepository.findAllByTitle("제목1");
        //제목이 1인애를 가져와
        assertThat(findByTitle.size()).isEqualTo(1);
        //리스트 사이즈가 1이면 통과
        List<Board> findByTitle2 = boardRepository. findAllByTitle("제목2");
        //제목 2를 가져와
        assertThat (findByTitle2.size()).isEqualTo(0);
        //리스트 사이즈가 0이면 통과
    }

    @Test //U
    public void TestUpdateBoard(){
        savedBoard.setTitle("수정1");
        boardRepository.save(savedBoard);//저장은 끝
        //제대로 저장이 됬는지 확인하는 방법
        Board findFirstByTitle = boardRepository.findFirstByTitle("수정1");
        assertThat(findFirstByTitle.getTitle()).isEqualTo("수정1");
    }

    @Test //D
    public void  deleteBoard() {
        boardRepository.delete(savedBoard);
        List<Board > findAllBoard =boardRepository.findAll();
        assertThat(findAllBoard.size()).isEqualTo(0);

    }
}
