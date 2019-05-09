package ac.ks.web.controller;

import ac.ks.web.domain.Board;
import ac.ks.web.repository.BoardRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

//@RestController
@Controller
public class BoardController {
    //GET /board -> 200 OK 등장해야되고 Title전체를 내보낸다.
    private BoardRepository boardRepository;
    //@Autowired 를 쓰기엔 별로 좋지가 않다.
    public BoardController(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    } //생성자를 이용해서 의존성을 주입한다.
    @GetMapping("")
    public String home(){
        return "home.html";
    }
    @GetMapping("/board")
    public List<String> getBoardTitleAll(){
        List<Board> boardList = boardRepository.findAll();
        List<String > stringList = new ArrayList<>();

        for(Board b : boardList)
            stringList.add(b.getTitle());

        return stringList;
    }
}
