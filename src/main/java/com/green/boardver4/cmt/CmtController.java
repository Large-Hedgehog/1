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
@RequestMapping("/board")
@Tag(name="댓글", description = "")
public class CmtController {
    private final CmtService service;

    @Autowired
    public CmtController(CmtService service) {
        this.service = service;
    }
    @PostMapping("/{iboard}")
    public int PostCmt(@PathVariable int iboard,
            @RequestBody CmtInsDto dto){
        CmtEntity entity = new CmtEntity();
        entity.setIboard(iboard);
        entity.setIuser(dto.getIuser());
        entity.setCtnt(dto.getCtnt());
        return service.insertBoardCmt(entity);
    }
    @GetMapping("/{iboard}/cmt")
    public List<CmtSelDto> GetCmt(@PathVariable int iboard, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "30") int row){
        CmtDto dto = new CmtDto();
        dto.setIboard(iboard);
        dto.setPage(page);
        dto.setRow(row);
        return service.selectBoardCmt(dto);
    }

}
