package com.green.boardver4.cmt;

import com.green.boardver4.cmt.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CmtMapper {
    int insertBoardCmt(CmtEntity entity);
    List<CmtVo>selectBoardCmt(CmtSelDto dto);
    int deleteBoardCmt(CmtDelDto dto);
    int updateBoardCmt(CmtEntity entity);
}
