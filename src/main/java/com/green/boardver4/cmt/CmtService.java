package com.green.boardver4.cmt;

import com.green.boardver4.cmt.model.CmtDto;
import com.green.boardver4.cmt.model.CmtEntity;
import com.green.boardver4.cmt.model.CmtInsDto;
import com.green.boardver4.cmt.model.CmtSelDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CmtService {
    private final CmtMapper mapper;

    @Autowired
    public CmtService(CmtMapper mapper) {
        this.mapper = mapper;
    }

    public int insertBoardCmt(CmtEntity entity){
        try{
            int result = mapper.insertBoardCmt(entity);
            if (result == 1){
                return entity.getIboardCmt();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
    public List<CmtSelDto> selectBoardCmt(CmtDto dto){
        int startIdx = (dto.getPage() - 1) * dto.getRow();
        dto.setStartIdx(startIdx);
        return mapper.selectBoardCmt(dto);
    }
}
