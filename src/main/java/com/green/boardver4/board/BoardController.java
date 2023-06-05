package com.green.boardver4.board;


import com.green.boardver4.board.model.*;
import io.swagger.v3.oas.annotations.Operation;
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

    @GetMapping
    public List<BoardVo> getBoard(@RequestParam(defaultValue = "1") int page
    , @RequestParam(defaultValue = "30") int row){
        BoardSelDto dto = new BoardSelDto();
        dto.setPage(page);
        dto.setRow(row);
        List<BoardVo> list = service.selBoard(dto);
        return list;
    }

    @GetMapping("/maxpage")
    public int getBoardMaxPage(@RequestParam int row){
        return service.selBoardMaxPage(row);
    }

    @GetMapping("/{iboard}")
    @Operation(summary = "자세히보기")
    public BoardDetailAll getBoardDetail(@PathVariable int iboard){
        BoardSelDto dto = new BoardSelDto();
        dto.setIboard(iboard);
        return service.BoardDetail(dto);
    }
    @DeleteMapping
    @Operation(summary = "삭제")
    public int deleteBoard (@RequestParam int iboard, @RequestParam int iuser) throws Exception {
        BoardDetail dto = new BoardDetail();
        dto.setIboard(iboard);
        dto.setIuser(iuser);
        return service.deleteBoard(dto);
    }

    @PutMapping
    @Operation(summary = "수정")
    public int updateBoard(@RequestBody BoardUpdateDto dto){
        return service.updateBoard(dto);
    }

}
