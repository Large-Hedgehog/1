package com.green.boardver4.cmt;

import com.green.boardver4.cmt.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
@Tag(name="댓글", description = "")
public class CmtController {
    private final CmtService service;

    @Autowired
    public CmtController(CmtService service) {
        this.service = service;
    }
    @PostMapping("/{iboard}/cmt")
    @Operation(summary = "댓글쓰기")
    public int PostBoardCmt(@PathVariable int iboard,
            @RequestBody CmtInsDto dto){
        CmtEntity entity = new CmtEntity();
        entity.setIboard(iboard);
        entity.setIuser(dto.getIuser());
        entity.setCtnt(dto.getCtnt());
        return service.insertBoardCmt(entity);
    }

    @GetMapping("/{iboard}/cmt")
    @Operation(summary = "자세히보기")
    public List<CmtVo> GetBoardCmt(@PathVariable int iboard,
                                   @RequestParam int page,
                                   @RequestParam(defaultValue = "5") int row){
        CmtSelDto dto = new CmtSelDto();
        dto.setIboard(iboard);
        dto.setPage(page);
        dto.setRow(row);
        return service.selectBoardCmt(dto);
    }

    @DeleteMapping("/cmt/{iboardCmt}")
    @Operation(summary = "삭제")
    public int DelBoardCmt(@PathVariable int iboardCmt,
                           @RequestParam int iuser
                           ){
        CmtDelDto dto= new CmtDelDto();
        dto.setIboard_cmt(iboardCmt);
        dto.setIuser(iuser);
        return service.deleteBoardCmt(dto);
    }

    @PutMapping("/cmt/{iboardCmt}")
    @Operation(summary = "댓글수정")
    public int PutBoardCmt(@PathVariable int iboardCmt,
                           @RequestParam int iuser,
                           @RequestParam String ctnt){
        CmtUpdateDto dto = new CmtUpdateDto();
        dto.setIboard_cmt(iboardCmt);
        dto.setIuser(iuser);
        dto.setCtnt(ctnt);
        return service.updateBoardCmt(dto);

    }
}
