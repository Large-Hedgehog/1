package com.green.boardver4.Board.model;

import com.green.boardver4.cmt.model.CmtRes;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class BoardDetailAll {
    private BoardDetail iboard;
    private CmtRes cmtResList;
}
