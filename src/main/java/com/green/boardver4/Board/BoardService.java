package com.green.boardver4.Board;

import com.green.boardver4.Board.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    private final BoardMapper mapper;

    @Autowired
    public BoardService(BoardMapper mapper) {
        this.mapper = mapper;
    }

    public int InsBoard(BoardInsDto dto){
        BoardEntity entity = new BoardEntity();
        entity.setTitle(dto.getTitle());
        entity.setCtnt(dto.getCtnt());
        entity.setIuser(dto.getIuser());
        entity.setIuser(dto.getIuser());
        int result = mapper.InsBoard(entity);
        if (result == 1){
            return entity.getIboard();
        }
        return result;
    }
    public List<BoardVo>selBoard(BoardSelDto dto){
        int startIdx = (dto.getPage()-1)*dto.getRow();
        dto.setStartIdx(startIdx);
        return mapper.selBoard(dto);
    }

    public int selBoardMaxPage(int row){
        return mapper.selBoardMaxPage(row);
    }

    public BoardDetail getBoardDetail(BoardDetail detail){
        return mapper.selBoardDetail(detail);
    }
    public int updateBoard (BoardUpdateDto dto){
        return mapper.updateBoard(dto);
    }

    public int deleteBoard(BoardDetail dto){
        return mapper.deleteBoard(dto);
    }
}
