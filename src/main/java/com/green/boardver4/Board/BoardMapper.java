package com.green.boardver4.Board;

import com.green.boardver4.Board.model.BoardInsDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {
    int InsBoard(BoardInsDto dto);
}
