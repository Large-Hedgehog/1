package com.green.boardver4.user;
import com.green.boardver4.user.model.*;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface UserMapper {
    int UserIns(UserInsDto dto);
    UserLoginVo selUserByUid(UserLoginDto dto);
    int PwUser(UserPwDto dto);
    int updUserPic(UserPatchPicDto dto);

}
