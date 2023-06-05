package com.green.boardver4.board.model;

import com.green.boardver4.cmt.model.CmtRes;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BoardDetailAll {
    private BoardDetail iboard;
    private CmtRes cmtResList;
}
