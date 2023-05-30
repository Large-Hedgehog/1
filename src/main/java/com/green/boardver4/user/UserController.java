package com.green.boardver4.user;
import com.green.boardver4.user.model.UserInsDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    @Operation(
            summary = "회원가입", description = ""+
            "uid\": [20] 회원 아이디\", <br>"+
            "upw\": [100] 회원 비밀번호\", <br>"+
            "nm\": [30] 회원 이름\", <br>"+
            "gender\": [1] m:남자 f:여자 \", <br>"+
            "addr\": [100] 주소")
    public int boardPost(@RequestBody UserInsDto dto) {
        return service.UserIns(dto);
    }
}
