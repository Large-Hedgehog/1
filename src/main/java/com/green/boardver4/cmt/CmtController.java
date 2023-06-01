package com.green.boardver4.cmt;

import com.green.boardver4.cmt.model.*;
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
    public int PostBoardCmt(@PathVariable int iboard,
            @RequestBody CmtInsDto dto){
        CmtEntity entity = new CmtEntity();
        entity.setIboard(iboard);
        entity.setIuser(dto.getIuser());
        entity.setCtnt(dto.getCtnt());
        return service.insertBoardCmt(entity);
    }

    @GetMapping("/{iboard}/cmt")
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
    public int DelBoardCmt(@PathVariable int iboardCmt,
                           @RequestParam int iuser
                           ){
        CmtDelDto dto= new CmtDelDto();
        dto.setIboard_cmt(iboardCmt);
        dto.setIuser(iuser);
        return service.deleteBoardCmt(dto);
    }
}
