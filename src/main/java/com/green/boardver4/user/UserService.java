package com.green.boardver4.user;
import com.green.boardver4.user.model.UserInsDto;
import com.green.boardver4.user.model.UserLoginDto;
import com.green.boardver4.user.model.UserLoginVo;
import com.green.boardver4.user.model.UserPwDto;
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
}