package com.green.boardver4.cmt;

import com.green.boardver4.cmt.model.CmtInsDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CmtMapper {

    //int insertBoardCmt(CmtInsDto dto);
    int insertBoardCmt(CmtInsDto dto);
}
