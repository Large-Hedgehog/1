package com.green.boardver4.Board;

import com.green.boardver4.Board.model.BoardInsDto;
import com.green.boardver4.Board.model.BoardSelDto;
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

    public List<BoardSelDto>selBoard(BoardSelDto dto){
        int startIdx = (dto.getPage()-1)*dto.getRow();
        dto.setStartIdx(startIdx);
        return mapper.selBoard(dto);
    }

}
