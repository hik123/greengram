package com.green.greengram.user;

import com.green.greengram.ResVo;
import com.green.greengram.user.model.UserInsDto;
import com.green.greengram.user.model.UserProfileInfoVo;
import com.green.greengram.user.model.UserSigninDto;
import com.green.greengram.user.model.UserSigninVo;
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
    @PostMapping("/signin")                     // localhost:8080/api/user/signin
    public UserSigninVo login(@RequestBody UserSigninDto dto) {
        System.out.println(dto);
        return service.signin(dto);
    }

    // api/user/2/mike/3
    // api/user/3/john/45
    @GetMapping("/{targetIuser}")
    public UserProfileInfoVo getUserProfileInfo (@PathVariable int targetIuser) {
        return service.getUserProfileInfo(targetIuser);                 // 보낼 값이 여러개일때는 객체에 담아서 주소값을 보냄
    }
    // postman(get, params) >>  http://localhost:8080/api/user/{targetIuser}


    /* ----------------------------------------------------------------------------
    @GetMapping("/{iuser}/{name}/{ifeed}")   // {} 여러개일때 @PathVariable 각각 넣어야됨
    public int getUser (@PathVariable int iuser, @PathVariable String name ,@PathVariable int ifeed) {
        return 0;
    }

    @GetMapping("/{iuser}/{ifeed}")
    public int getUser (@PathVariable int iuser, @PathVariable int ifeed) {
        return 0;
    }
    */
}


