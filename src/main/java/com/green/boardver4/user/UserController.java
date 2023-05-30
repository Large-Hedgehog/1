package com.green.boardver4.user;
import com.green.boardver4.user.model.UserInsDto;
import com.green.boardver4.user.model.UserLoginDto;
import com.green.boardver4.user.model.UserPwDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
            summary = "회원가입", description = " "+
            "uid\": [20] 회원 아이디\", <br>"+
            "upw\": [100] 회원 비밀번호\", <br>"+
            "nm\": [30] 회원 이름\", <br>"+
            "gender\": [1] m:남자 f:여자 \", <br>"+
            "addr\": [100] 주소")
    public int boardPost(@RequestBody UserInsDto dto) {

        return service.UserIns(dto);
    }

    //로그인
    @PostMapping("/login")
    @Operation(summary = "로그인", description = " " +
            "리턴값:" +
            "(1)로그인 성공, " +
            "(2)아이디 없음, " +
            "(3)비밀번호 다름, ")
    public int postLoginUser(@RequestBody UserLoginDto dto){
        return service.login(dto);
    }

    // 비밀번호 수정
    @PatchMapping("/pw")
    public int patchPwUser(@RequestBody UserPwDto dto){
        return service.PwUser(dto);
    }
}
