package com.green.boardver4.user;
import com.green.boardver4.user.model.*;
import com.green.boardver4.utils.CommonUtils;
import com.green.boardver4.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

import static com.green.boardver4.utils.FileUtils.*;


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
            // user/1/abcd.jpg
            String centerPath = String.format("user/%d", dto.getIuser());
            String dicPath = String.format("%s/%s", fileDir, centerPath);

            File dic = new File(dicPath);
            if(!dic.exists()) {
                dic.mkdirs();
            }

            String originFileName = pic.getOriginalFilename();
            String savedFileName = FileUtils.makeRandomFileNm(originFileName);
            String savedFilePath = String.format("%s/%s", centerPath, savedFileName); // db저장
            String targetPath = String.format("%s/%s", fileDir, savedFilePath);
            File target = new File(targetPath);
            try {
                pic.transferTo(target);
            }catch (Exception e) {
                return 0;
            }
            dto.setMainPic(savedFilePath);
            try {
                int result = mapper.updUserPic(dto);
                if(result == 0) {
                    throw new Exception("프로필 사진을 등록할 수 없습니다.");
                }
            } catch (Exception e) {
                //파일 삭제
                target.delete();
                return 0;
            }
            return 1;
    }
}
