package com.green.boardver4.board;

import com.green.boardver4.board.model.*;
import com.green.boardver4.cmt.CmtService;
import com.green.boardver4.cmt.model.CmtDelDto;
import com.green.boardver4.cmt.model.CmtRes;
import com.green.boardver4.cmt.model.CmtSelDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BoardService {

    private final BoardMapper mapper;
    private final CmtService cmtservice;

    @Autowired
    public BoardService(BoardMapper mapper,CmtService cmtservice) {
        this.mapper = mapper;
        this.cmtservice = cmtservice;
    }

    public int InsBoard(BoardInsDto dto){
        BoardEntity entity = new BoardEntity();
        entity.setTitle(dto.getTitle());
        entity.setCtnt(dto.getCtnt());
        entity.setIuser(dto.getIuser());
        entity.setIuser(dto.getIuser());
        int result = mapper.insBoard(entity);
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

    public BoardDetailAll BoardDetail(BoardSelDto dto){
        CmtSelDto cmtdto = new CmtSelDto();
        cmtdto.setIboard(dto.getIboard());
        cmtdto.setPage(1);
        cmtdto.setRow(5);
        CmtRes cmtRes = cmtservice.selBoardCmt(cmtdto);
        BoardDetail boardDetail = mapper.selBoardDetail(dto);

        return BoardDetailAll.builder().iboard(boardDetail).cmtResList(cmtRes).build();
    }
    public int updateBoard (BoardUpdateDto dto){
        return mapper.updateBoard(dto);
    }
    @Transactional(rollbackFor = Exception.class)
    public int deleteBoard(BoardDetail dto) throws Exception {
         CmtDelDto cmtDto = new CmtDelDto();
        cmtDto.setIboard(dto.getIboard());
        cmtservice.deleteBoardCmt(cmtDto);
        // 그 글에 달려있는 댓글을 전부 삭제해야 함.
        int result = 0;
        result = mapper.deleteBoard(dto);
        if (result == 0) {
            throw new Exception("삭제 권한 없음");
        }
        return result;
    }
}
