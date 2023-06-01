package com.green.boardver4.cmt;

import com.green.boardver4.cmt.model.CmtDto;
import com.green.boardver4.cmt.model.CmtEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CmtMapper {
    int insertBoardCmt(CmtEntity entity);
    int selectBoardCmt(CmtDto dto);
}
