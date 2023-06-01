package com.green.boardver4.cmt;

import com.green.boardver4.cmt.model.CmtDto;
import com.green.boardver4.cmt.model.CmtEntity;
import com.green.boardver4.cmt.model.CmtInsDto;
import com.green.boardver4.cmt.model.CmtSelDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board/cmt")
@Tag(name="댓글", description = "")
public class CmtController {
    private final CmtService service;

    @Autowired
    public CmtController(CmtService service) {
        this.service = service;
    }
    @PostMapping
    public int PostCmt(@RequestBody CmtInsDto dto){
        return service.insertBoardCmt(dto);
    }
    @GetMapping("/{iboard}")
    public List<CmtSelDto> GetCmt(@PathVariable int iboard, @RequestParam int page, @RequestParam int row){
        CmtDto dto = new CmtDto();
        dto.setIboard(iboard);
        dto.setPage(page);
        dto.setRow(row);
        return service.selectBoardCmt(dto);
    }

}
