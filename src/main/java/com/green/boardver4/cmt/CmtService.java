package com.green.boardver4.cmt;

import com.green.boardver4.cmt.model.*;
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
    public List<CmtVo> selectBoardCmt(CmtSelDto dto){
        int startIdx = (dto.getPage() - 1) * dto.getRow();
        dto.setStartIdx(startIdx);
        return mapper.selectBoardCmt(dto);
    }

    public int deleteBoardCmt (CmtDelDto dto){
      return mapper.deleteBoardCmt(dto);
    }

    public int updateBoardCmt(CmtUpdateDto dto){
        return mapper.updateBoardCmt(dto);
    }
}
