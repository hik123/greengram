package com.green.greengram.user;

import com.green.greengram.ResVo;
import com.green.greengram.user.model.UserInsDto;
import com.green.greengram.user.model.UserSigninDto;
import com.green.greengram.user.model.UserSigninProcVo;
import com.green.greengram.user.model.UserSigninVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper mapper;

    public int insUser(UserInsDto dto) {
        return mapper.insUser(dto);
    }

    public UserSigninVo signin(UserSigninDto dto) {
        /*
        int result = 3;

        String savedUpw = mapper.selUserByUid(dto.getUid());
        System.out.println("savedUpw : " + savedUpw);
        if (savedUpw == null) {
            result = 2;
        } else if (savedUpw.equals(dto.getUpw())) {
            result = 1;
        }
        return new ResVo(result);
        */
        UserSigninVo vo = new UserSigninVo();
        vo.setResult(3);

        UserSigninProcVo procVo = mapper.selUserByUid(dto.getUid());
        if(procVo == null) {
            vo.setResult(2);
        } else if(procVo.getUpw().equals(dto.getUpw())) {
            vo.setResult(1);
            vo.setIuser(procVo.getIuser());
            vo.setNm(procVo.getNm());
            vo.setPic(procVo.getPic());
        }
        return vo;
    }
    //1: 아이디/비번 맞췄음, 2: 아이디 없음, 3: 비밀번호 다름

}

