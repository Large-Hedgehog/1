package com.green.boardver4.Board;

import com.green.boardver4.Board.model.BoardEntity;
import com.green.boardver4.Board.model.BoardInsDto;
import com.green.boardver4.Board.model.BoardSelDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    int InsBoard(BoardInsDto dto);
    List<BoardSelDto>selBoard(BoardEntity entity);
}
