package com.green.boardver4.cmt;

import com.green.boardver4.cmt.model.CmtSelDto;
import com.green.boardver4.cmt.model.CmtEntity;
import com.green.boardver4.cmt.model.CmtVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CmtMapper {
    int insertBoardCmt(CmtEntity entity);
    List<CmtVo>selectBoardCmt(CmtSelDto dto);
}
