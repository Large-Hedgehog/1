package com.green.boardver4.cmt.model;

import lombok.Data;

@Data
public class CmtDto extends CmtSelDto{
    private int startIdx;
    private int page;
    private int row;
}
