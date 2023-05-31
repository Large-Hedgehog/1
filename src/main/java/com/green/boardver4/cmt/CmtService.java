package com.green.boardver4.cmt;

import com.green.boardver4.cmt.model.CmtInsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CmtService {
    private final CmtMapper mapper;

    @Autowired
    public CmtService(CmtMapper mapper) {
        this.mapper = mapper;
    }

    public int insertBoardCmt(CmtInsDto dto){
        return mapper.insertBoardCmt(dto);
    }
}
