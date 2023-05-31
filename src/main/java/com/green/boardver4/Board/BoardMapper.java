package com.green.boardver4.Board;

import com.green.boardver4.Board.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    int InsBoard(BoardInsDto dto);
    List<BoardVo>selBoard(BoardSelDto dto);
    int boardPageIdx(int row);
}
