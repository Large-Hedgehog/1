package com.green.boardver4.Board.model;

import com.green.boardver4.cmt.model.CmtEntity;
import lombok.Data;

import java.util.List;

@Data
public class BoardDetail {
    private int iboard;
    private String title;
    private String ctnt;
    private int iuser;
    private String createAt;
    private String updateAt;
}
