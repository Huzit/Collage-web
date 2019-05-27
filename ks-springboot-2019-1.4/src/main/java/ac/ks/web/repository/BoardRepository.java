package ac.ks.web.repository;

import ac.ks.web.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findAllByTitle(final String title);
    Board findFirstByTitle(final String title);
}
