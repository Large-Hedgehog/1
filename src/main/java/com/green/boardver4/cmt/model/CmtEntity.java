package com.green.boardver4.cmt.model;

import lombok.Data;

@Data
public class CmtEntity {
    private int iboard_cmt;
    private int iboard;
    private int iuser;
    private String ctnt;
    private String createdAt;
    private String updatedAt;
}