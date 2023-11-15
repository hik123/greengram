package com.green.greengram.user;

import com.green.greengram.user.model.UserInsDto;
import com.green.greengram.user.model.UserSigninProcVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    int insUser(UserInsDto dto);

    UserSigninProcVo selUserByUid(String uid);

    // UserSigninProcVo selUserByUid2(String uid);
}
