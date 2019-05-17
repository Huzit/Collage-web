package ac.ks.web.controller;

import ac.ks.web.domain.Board;
import ac.ks.web.repository.BoardRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BoardJsonController {

    private BoardRepository boardRepository;

    public BoardJsonController(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @GetMapping("/json/helloworld")
    public List<Board> helloWorld() {
        return boardRepository.findAll();
    }
}
