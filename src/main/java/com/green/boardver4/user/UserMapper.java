package com.green.boardver4.user;
import com.green.boardver4.user.model.UserInsDto;
import com.green.boardver4.user.model.UserLoginDto;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface UserMapper {
    int UserIns(UserInsDto dto);
    int UserSel(UserLoginDto dto);
}
