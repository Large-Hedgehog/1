package com.green.boardver4.Board.model;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {
    int InsBoard(BoardInsDto dto);
}
