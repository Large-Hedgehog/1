package com.green.boardver4.Board.model;

import lombok.Data;

@Data
public class BoardEntity {
    private int iboard;
    private String title;
    private String ctnt;
    private int iuser;
    private String createdAt;
    private String updateAt;
}
