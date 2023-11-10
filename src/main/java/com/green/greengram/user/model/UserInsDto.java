package com.green.greengram.user.model;

import lombok.Data;


@Data // getter, setter, tostring ... 다들어있음
public class UserInsDto {
    private String uid;
    private String upw;
    private String nm;
    private String pic;
}
