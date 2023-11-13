package com.green.greengram.feed;


import com.green.greengram.ResVo;
import com.green.greengram.feed.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedService {
    private final FeedMapper mapper;

    public ResVo insFeed(FeedInsDto dto) {
        FeedInsProcDto pDto = new FeedInsProcDto(dto); //값전달
        System.out.println(dto);
        System.out.println(pDto);
        int result = mapper.insFeed(pDto);
        System.out.println(pDto);

        FeedPicsInsProcDto p2Dto = new FeedPicsInsProcDto(pDto.getIfeed(), dto.getPics()); //호출했을때의 결과타입
        int result2 = mapper.insFeedPic(p2Dto);
        System.out.println("result2: " + result2);
        return new ResVo(pDto.getIfeed());
    }

    public List<FeedSelVo> selFeed(int page){
        final int ROW_COUNT = 30;
        FeedSelDto dto = FeedSelDto.builder()
                .startIdx((page-1) * ROW_COUNT)
                .rowCount(ROW_COUNT)
                .build();
        List<FeedSelVo> result = mapper.selFeed(dto);
        return result;
    }
}
