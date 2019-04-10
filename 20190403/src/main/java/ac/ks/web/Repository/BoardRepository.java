package ac.ks.web.Repository;

import ac.ks.web.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

//27분 19초 저장하는 방법을 알아봅시다 orm을 받아서 저장하기 위함
//orm을 쓰고구현을 hibernate로 했으니까 뭔가를 추가하려면 orm을 상속받아야 한다
public interface BoardRepository extends JpaRepository<Board, Long> {
    //oop??? 강제인터페이싱한다. 인터페이스에서 인터페이스를 받으려면 상속을 해야한다
}//자바에서 타입은 클래스와 인터페이스 밖에 없다.

//orm 을 쓸라면 갖다때려박아야 되는데 어떻게 하냐? 그때는 상속을 하면된다
//이거만 있으면 의존성주입으로 하이버네이트가 돌아간다 막 뭔갈 넣어줘