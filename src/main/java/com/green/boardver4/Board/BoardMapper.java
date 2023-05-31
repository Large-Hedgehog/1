package com.green.boardver4.Board;

import com.green.boardver4.Board.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    int InsBoard(BoardEntity dto);
    List<BoardVo>selBoard(BoardSelDto dto);
    int selBoardMaxPage(int row);
    BoardDetail selBoardDetail(BoardDetail dto);
    int deleteBoard(BoardDetail dto);
    int updateBoard(BoardUpdateDto dto);
}
