package com.green.boardver4;
import com.green.boardver4.user.model.UserInsDto;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface UserMapper {
    int UserIns(UserInsDto dto);
}
