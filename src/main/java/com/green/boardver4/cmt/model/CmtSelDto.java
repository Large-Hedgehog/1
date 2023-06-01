package com.green.boardver4.cmt.model;

import lombok.Data;

@Data
public class CmtSelDto {
    private int iboardCmt;
    private int iboard;
    private int iuser;
    private String writer;
    private String writerMainPic;
    private String ctnt;
    private String createdAt;
}
