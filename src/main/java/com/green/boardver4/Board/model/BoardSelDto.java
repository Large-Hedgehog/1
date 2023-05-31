package com.green.boardver4.Board.model;


import lombok.Builder;
import lombok.Data;
@Builder
@Data
public class BoardSelDto {
    private int startIdx;
    private int row;
    private int page;

}
