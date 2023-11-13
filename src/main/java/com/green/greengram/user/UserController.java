package com.green.greengram.user;

import com.green.greengram.ResVo;
import com.green.greengram.user.model.UserInsDto;
import com.green.greengram.user.model.UserSigninDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor // 멤버필드에 final이 붙은 필드의 생성자를 자동생성.
@RequestMapping("/api/user") // url프리픽스? 모든 메소드에 주소값 붙여줌  / 뒷쪽에붙이는건 서브픽스?
public class UserController {
    //콘트롤러 > 서비스    서비스> 다오
    private final UserService service;


    @PostMapping
    public ResVo insUser(@RequestBody UserInsDto dto) {
        System.out.println(dto);
        int result = service.insUser(dto);
        return new ResVo(result);
    }
    @PostMapping("/signin")
    public ResVo login(@RequestBody UserSigninDto dto) {
        System.out.println(dto);
        return service.signin(dto);
    }


    // http://localhost:8080/api/user/signin
    //1: 아이디/비번 맞췄음, 2: 아이디 없음, 3: 비밀번호 다름

}
    //

