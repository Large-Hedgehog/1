package com.green.boardver4.user;
import com.green.boardver4.user.model.UserInsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    private final UserMapper mapper;

    @Autowired
    public UserService(UserMapper mapper) {
        this.mapper = mapper;
    }

    public int UserIns(UserInsDto dto) {
        return mapper.UserIns(dto);

    }
}