package com.green.greengram.user.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSigninProcVo {  //DB에서 가져온 데이터를 담기위함
    private int iuser;
    private String upw;
    private String nm;
    private String pic;
}
