package com.green.boardver4.Board;


import com.green.boardver4.Board.model.BoardInsDto;
import com.green.boardver4.user.UserService;
import com.green.boardver4.user.model.UserInsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/board")
@RestController
public class BoardController {
    private final BoardService service;

    @Autowired
    public BoardController(BoardService service) {
        this.service = service;
    }

    @PostMapping
    public int boardPost(@RequestBody BoardInsDto dto) {

        return service.InsBoard(dto);
    }

}
