package com.green.greengram.user;

import com.green.greengram.user.model.UserInsDto;
import com.green.greengram.user.model.UserProfileInfoVo;
import com.green.greengram.user.model.UserSigninProcVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    int insUser(UserInsDto dto);

    UserSigninProcVo selUserByUid(String uid);

    // UserSigninProcVo selUserByUid2(String uid);

    // 메소드 호출해서 받을수 있는 값 1개

    // select는 대부분 객체 타입
    UserProfileInfoVo selUserProfileInfo(int iuser);
}
