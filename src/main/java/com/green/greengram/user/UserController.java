package com.green.greengram.user;

import com.green.greengram.ResVo;
import com.green.greengram.user.model.UserInsDto;
import com.green.greengram.user.model.UserSigninDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor // 멤버필드에 final이 붙은 필드의 생성자를 자동생성.
@RequestMapping("/api/user")
public class UserController {
    //콘트롤러 > 서비스    서비스> 다오
    private final UserService service;


    @PostMapping
    public ResVo UserInsDto(@RequestBody UserInsDto dto) {
        System.out.println(dto);
        int result = service.userIns(dto);
        return new ResVo(result);
    }
    @PostMapping("/signin")
    public ResVo login(@RequestBody UserSigninDto dto) {
        System.out.println(dto);
        return service.signin(dto);
    }

    //1: 아이디/비번 맞췄음, 2: 아이디 없음, 3: 비밀번호 다름

}

