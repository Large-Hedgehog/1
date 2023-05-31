package com.green.boardver4.cmt;

import com.green.boardver4.cmt.model.CmtEntity;
import com.green.boardver4.cmt.model.CmtInsDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Board/cmt")
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

}
