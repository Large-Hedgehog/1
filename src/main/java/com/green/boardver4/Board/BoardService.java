package com.green.boardver4.Board;

import com.green.boardver4.Board.model.*;
import com.green.boardver4.cmt.CmtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    private final BoardMapper mapper;
    private final CmtMapper cmtMapper;

    @Autowired
    public BoardService(BoardMapper mapper,CmtMapper cmtMapper) {
        this.mapper = mapper;
        this.cmtMapper = cmtMapper;
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
//        int result = cmtMapper.deleteBoardCmt();
        // 그 글에 달려있는 댓글을 전부 삭제해야 함. 실제로는 데이터베이스 삭제하는거 겁내 함
        return mapper.deleteBoard(dto);
    }
}
