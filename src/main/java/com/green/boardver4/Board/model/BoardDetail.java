package com.green.boardver4.Board.model;

import lombok.Data;

@Data
public class BoardDetail {
    private int iboard;
    private String title;
    private String ctnt;
    private int iuser;
    private String createAt;
    private String updateAt;
}
