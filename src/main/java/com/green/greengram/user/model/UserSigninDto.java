package com.green.greengram.user.model;

import lombok.Data;

@Data
public class UserSigninDto {
    private String uid;
    private String upw;
}

// http통신  연속성이 없다