package ac.ks.web.domain;

import org.h2.engine.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
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
        board = Board.builder()
                .title(title)
                .subTitle("서브타이틀")
                .content("콘텐츠")
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build();
    }

    @Test
    public void printBoard(){
        System.out.println(board);
    }
}
