package ac.ks.web;

import ac.ks.web.domain.Board;
import ac.ks.web.domain.BoardType;
import ac.ks.web.repository.BoardRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.persistence.Basic;
import java.time.LocalDateTime;
import java.util.stream.IntStream;

@SpringBootApplication
public class WebApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}

	//자료를 때려박을라면 이렇게 해야된다.
	@Bean//어노테이션은 등록시키기위해서만들어놓은거다 이거 매우중요!!!!!! 우리가 만드는경우는 극~~~~~히 드물다. 보면 뭐하는놈인지를 알자.
	public CommandLineRunner runner(BoardRepository boardRepository) {
		return (args) -> {
			IntStream.rangeClosed(1, 200).forEach(index ->//정수형 스트림에서 범위를 0에서 199가 아니라 1에서 200까지로 하자 다음에 포이치로 해서 람다에 보드레포객체를 저장하고  반환한다.
					boardRepository.save(Board.builder()
							.title("게시글" + index)
							.subTitle("순서" + index)
							.content("콘텐츠")
							.boardType(BoardType.free)
							.createdDate(LocalDateTime.now())
							.updatedDate(LocalDateTime.now())
							.build()
					)
			);
		};
	}
}
