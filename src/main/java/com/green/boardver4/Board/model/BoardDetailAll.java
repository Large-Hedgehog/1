package com.green.boardver4.Board.model;

import com.green.boardver4.cmt.model.CmtRes;
import lombok.Data;

import java.util.List;

@Data
public class BoardDetailAll {
    private int iboard;
    private String title;
    private String ctnt;
    private int iuser;
    private String createAt;
    private String updateAt;
    private List<CmtRes> cmtResList;
}
