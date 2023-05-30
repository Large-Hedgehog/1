package com.green.boardver4.Board.model;

import lombok.Data;

@Data
public class BoardEntity extends BoardSelDto{
    private int page;
    private int row;
    private int rowlen;
    private int startIdx;
}
