package com.green.boardver4.Board.model;

import lombok.Data;

@Data
public class BoardDto{
    private int page;
    private int startIdx;
    private int rowLen;
    private int row;
}