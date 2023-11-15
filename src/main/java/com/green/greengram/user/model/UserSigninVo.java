package com.green.greengram.user.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSigninVo { //JSON으로 응답할때 씀
    private int result; //로그인 성공(1), 아이디없음(2), 비밀번호가 다름(3)
    private int iuser;
    private String nm;
    private String pic;
}
