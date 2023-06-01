package com.green.boardver4.cmt;

import com.green.boardver4.cmt.model.CmtDto;
import com.green.boardver4.cmt.model.CmtSelDto;
import com.green.boardver4.cmt.model.CmtEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CmtMapper {
    int insertBoardCmt(CmtEntity entity);
    //int selectBoardCmt(CmtSelDto dto);
    List<CmtSelDto>selectBoardCmt(CmtDto dto);
}
