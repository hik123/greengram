package com.green.greengram.user;

import com.green.greengram.user.model.UserInsDto;
import com.green.greengram.user.model.UserSigninDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    int userIns(UserInsDto dto);

    String selUserByUid(String uid);
}
