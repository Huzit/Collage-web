package ac.ks.web.Repository;

import ac.ks.web.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> { //oop??? 강제인터페이싱한다. 인터페이스에서 인터페이스를 받으려면 상속을 해야한다
}//자바에서 타입은 클래스와 인터페이스 밖에 없다.
