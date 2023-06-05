package com.green.boardver4.board;

import com.green.boardver4.board.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    int insBoard(BoardEntity dto);
    List<BoardVo>selBoard(BoardSelDto dto);
    int selBoardMaxPage(int row);
    BoardDetail selBoardDetail(BoardSelDto dto);
    int deleteBoard(BoardDetail dto);
    int updateBoard(BoardUpdateDto dto);
    BoardDetailAll BoardDetailAll(BoardDetailAll detail);
}
