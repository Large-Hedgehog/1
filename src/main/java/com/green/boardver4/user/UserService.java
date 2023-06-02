package com.green.boardver4.user;
import com.green.boardver4.user.model.*;
import com.green.boardver4.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;


@Service
public class UserService {
    private final UserMapper mapper;
    private final CommonUtils commonUtils;

    @Value("${file.dir}")
    private String fileDir;

    @Autowired
    public UserService(UserMapper mapper, CommonUtils commonUtils) {
        this.mapper = mapper;
        this.commonUtils = commonUtils;
    }

    public int UserIns(UserInsDto dto) {

        String hashedPw = CommonUtils.encodeSha256(dto.getUpw());
        dto.setUpw(hashedPw);
        return mapper.UserIns(dto);
    }

    public int login(UserLoginDto dto){
        UserLoginVo vo = mapper.selUserByUid(dto);

       if(vo == null){ return 2; }
       String hashedPw = commonUtils.encodeSha256(dto.getUpw());
       if(vo.getUpw().equals(hashedPw)){
           return 1;
       }
       return 0;
    }

    public int PwUser(UserPwDto dto){
        String hashedPw = commonUtils.encodeSha256(dto.getUpw());
        dto.setUpw(hashedPw);
        return mapper.PwUser(dto);
    }

    public int updUserPic(MultipartFile pic, UserPatchPicDto dto){
        // user/pk/uuid.jpg
        // 전체경로를 db의 mainpic에 저장

        String dicPath = String.format("%s/user/%d", fileDir, dto.getIuser());
        // D:/download/board3/user/1

        File dic = new File(dicPath);
        if(!dic.exists()){
            //해당하는 폴더가 없으면 실행
           // dic.mkdir();
            dic.mkdirs();
        }

        return 0;
    }
}
