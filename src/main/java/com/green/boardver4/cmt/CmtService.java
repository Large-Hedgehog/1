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
                return entity.getIboard_cmt();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
    public CmtRes selectBoardCmt(CmtSelDto dto){
        int startIdx = (dto.getPage() - 1) * dto.getRow();
        int lastIdx = startIdx + dto.getRow();
        int cmtIdx = dto.getCmtIdx();
        dto.setStartIdx(startIdx);
        List<CmtVo> list = mapper.selectBoardCmt(dto);


        //    private int isMore; // 0이면 댓글 더 없음, 1이면 댓글 더 있음


        if((lastIdx - cmtIdx) < 0){
            return CmtRes.builder()
                    .list(list)
                    .isMore(0)
                    .build();
        }

        return CmtRes.builder()
                .list(list)
                .isMore(1)
                .build();
    }

    public int deleteBoardCmt (CmtDelDto dto){
      return mapper.deleteBoardCmt(dto);
    }

    public int updateBoardCmt(CmtEntity entity){
        return mapper.updateBoardCmt(entity);
    }
}
