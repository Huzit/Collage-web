package ac.ks.web.repository;

import ac.ks.web.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
//기능 추가를 위해서 JPA를 내려받아 하이버네이트가 하는일을 추가시켜준다.
public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findAllByTitle(final String title); // 모르겠으면 여러개 받아
    Board findFirstByTitle(final  String title); //큰 깨닳음 리스트로 받으면 안된다.
    //나중에 받을떄 정렬을 넣어줘야 된다.
    //그냥 파인드 하면 온것중에 아무거나 하나를 가져온다.
}