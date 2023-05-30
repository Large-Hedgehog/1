package com.green.boardver4.Board;

import com.green.boardver4.Board.model.BoardInsDto;
import com.green.boardver4.user.UserMapper;
import com.green.boardver4.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
