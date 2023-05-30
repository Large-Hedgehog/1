package com.green.boardver4.user.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserLoginVo {
    private int iuser;
    private String uid;
    private String upw;
    private String nm;
    private char gender;
    private String addr;
    private String mainPic;
}
