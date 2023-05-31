package com.green.boardver4.Board;

import com.green.boardver4.Board.model.BoardInsDto;
import com.green.boardver4.Board.model.BoardPageIdxDto;
import com.green.boardver4.Board.model.BoardSelDto;
import com.green.boardver4.Board.model.BoardVo;
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
        return mapper.InsBoard(dto);
    }

    public List<BoardVo>selBoard(BoardSelDto dto){
        int startIdx = (dto.getPage()-1)*dto.getRow();
        dto.setStartIdx(startIdx);
        return mapper.selBoard(dto);
    }

    public int boardPageIdx(int row){
        return mapper.boardPageIdx(row);
    }

}
