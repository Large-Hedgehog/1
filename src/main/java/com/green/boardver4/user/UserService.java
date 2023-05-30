package com.green.boardver4.user;
import com.green.boardver4.user.model.UserInsDto;
import com.green.boardver4.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    private final UserMapper mapper;
    private final CommonUtils commonUtils;

    @Autowired
    public UserService(UserMapper mapper, CommonUtils commonUtils) {
        this.mapper = mapper;
        this.commonUtils = commonUtils;
    }

    public int UserIns(UserInsDto dto) {
        //성별 항상 소문자로 변경
        char gender = Character.toLowerCase(dto.getGender());
        if(!(gender=='m' || gender == 'f')){
            return -1;
        }
        dto.setGender(gender);

        //비밀번호 암호화
        String hashPw = CommonUtils.encodeSha256(dto.getUpw());
        dto.setUpw(hashPw);

        try {
            return mapper.UserIns(dto);
        } catch (Exception e){
            e.printStackTrace();
            return 0;
        }

    }
}