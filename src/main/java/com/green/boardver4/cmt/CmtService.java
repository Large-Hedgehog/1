package com.green.boardver4.cmt;

import com.green.boardver4.cmt.model.CmtEntity;
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
        CmtEntity entity = new CmtEntity();
        entity.setIboard(dto.getIboard());
        entity.setIuser(dto.getIuser());
        entity.setCtnt(dto.getCtnt());
        return mapper.insertBoardCmt(entity);
    }
}
