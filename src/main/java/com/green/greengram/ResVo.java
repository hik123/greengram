package com.green.greengram;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter                 // private 멤버필드 있으면 무조건 getter
@AllArgsConstructor
public class ResVo {
    private int result;
}
