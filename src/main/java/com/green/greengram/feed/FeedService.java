package com.green.greengram.feed;


import com.green.greengram.ResVo;
import com.green.greengram.feed.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class FeedService {
    private final FeedMapper mapper;

    public ResVo insFeed(FeedInsDto dto) {
        FeedInsProcDto pDto = new FeedInsProcDto(dto);
        System.out.println(dto);
        System.out.println(pDto);
        int result = mapper.insFeed(pDto);
        System.out.println(pDto);

        FeedPicsInsProcDto p2Dto = new FeedPicsInsProcDto(pDto.getIfeed(), dto.getPics());
        int result2 = mapper.insFeedPic(p2Dto);
        System.out.println("result2 : " + result2);
        return new ResVo(pDto.getIfeed());
    }

    public List<FeedSelVo> getFeed(int page, int loginedIuser, int targetIuser) {
        final int ROW_COUNT = 30;
        FeedSelDto dto = FeedSelDto.builder()
                .targetIuser(targetIuser)
                .loginedIuser(loginedIuser)
                .startIdx((page - 1) * ROW_COUNT)
                .rowCount(ROW_COUNT)
                .build();
        List<FeedSelVo> feedSelVoList = mapper.selFeed(dto);
        // 페이지 구현
        List<Integer> iFeedList = new ArrayList(); //부분부분 페이징처리되기때문에
        Map<Integer, FeedSelVo> feedMap = new HashMap();
        for(FeedSelVo vo : feedSelVoList) {
            System.out.println(vo);
            iFeedList.add(vo.getIfeed()); //ifeed값을 계속 담고있음
            feedMap.put(vo.getIfeed(), vo); // feedMap key값과 밸류로 이루어짐
        }               //
        System.out.println("--------------");
        if(iFeedList.size() >0) {
            List<FeedPicsVo> feedPicsList = mapper.selFeedPics(iFeedList);

            for (FeedPicsVo vo : feedPicsList) {
                FeedSelVo feedVo = feedMap.get(vo.getIfeed());
                feedVo.getPics().add(vo.getPic());
                List<String> strPicsList = feedVo.getPics();
                strPicsList.add(vo.getPic());
            }
        }
        return feedSelVoList;
    }

    //좋아요:1, 취소:2 // 딜리트 먼저 해보고
    public ResVo procFav(FeedFavProcDto dto) { // 컨트롤러가 서비스에게 보낸 데이터
        /*int result = mapper.delFeedFav(dto);
        if(result == 1) { return new ResVo(2);
        } else if (result == 0) { mapper.insFeedFav(dto); }
        return null;

         */
        int affectedRow = mapper.delFeedFav(dto);
        if(affectedRow == 1) {
            return new ResVo(2);
        }

        int affectedRow2 = mapper.insFeedFav(dto);
        if(affectedRow2 == 1) {
            return new ResVo(1);
        }
        return null;
    }
}
