package com.green.boardver4.cmt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
public class MoreCmtVo {
    private int iboardCmt;
    private int iboard;
    private int iuser;
    private String ctnt;
    private String createdAt;
    private String writer;
    private String writerMainPic;
    private int cmtIdx;

}
