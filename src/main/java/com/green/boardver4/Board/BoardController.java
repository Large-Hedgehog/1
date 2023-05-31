package com.green.boardver4.Board;


import com.green.boardver4.Board.model.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/board")
@RestController
@Tag(name="게시판", description = "")
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

    @GetMapping("/")
    public List<BoardVo> getBoard(@RequestParam(defaultValue = "1") int page
    , @RequestParam(defaultValue = "30") int row){
        BoardSelDto dto = new BoardSelDto();
        dto.setPage(page);
        dto.setRow(row);
        return service.selBoard(dto);
    }

    @GetMapping("/maxpage")
    public int getBoardMaxPage(@RequestParam int row){
        return service.selBoardMaxPage(row);
    }

    @GetMapping("/{iboard}")
    public BoardDetail getBoardDetail(@PathVariable int iboard){
        BoardDetail dto = new BoardDetail();
        dto.setIboard(iboard);
        return service.getBoardDetail(dto);
    }
    @DeleteMapping
    public int deleteBoard (@RequestParam int iboard, @RequestParam int iuser){
        BoardDetail dto = new BoardDetail();
        dto.setIboard(iboard);
        dto.setIuser(iuser);
        return service.deleteBoard(dto);
    }

    @PutMapping
    public int updateBoard(@RequestBody BoardUpdateDto dto){
        return service.updateBoard(dto);
    }
}
