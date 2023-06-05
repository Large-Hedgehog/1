package com.green.boardver4.utils;

import com.green.boardver4.Board.model.BoardPageIdxDto;

import java.util.UUID;

public class FileUtils {
    // 확장자 리턴하는 메소드
    public static String getExp(String fileNm){
        String exp = fileNm.substring(fileNm.lastIndexOf(".") + 1);
        return exp;
    }

    //파일명 리턴하는 메소드
    public static String getFileNm(String fileNm){
        int Idx = fileNm.lastIndexOf(".");
        String fileNmout = fileNm.substring(0,Idx);
        return fileNmout;
    }

    //uuid이용해서 랜덤값 파일명 리턴
    public static String makeRandomFileNm(String fileNm){
        String uuid = UUID.randomUUID().toString();
        return uuid + fileNm;
    }

}
