package com.green.boardver4.cmt.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class CmtRes {
    private int isMore; // 0이면 댓글 더 없음, 1이면 댓글 더 있음
    private List<CmtVo> list;
}
