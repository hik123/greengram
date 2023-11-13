package com.green.greengram.feed;

import com.green.greengram.feed.model.FeedInsProcDto;
import com.green.greengram.feed.model.FeedPicsInsProcDto;
import com.green.greengram.feed.model.FeedSelDto;
import com.green.greengram.feed.model.FeedSelVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FeedMapper {
    int insFeed (FeedInsProcDto dto);

    int insFeedPic (FeedPicsInsProcDto pDto);
    // select 전체 출력 할때 List 사용
    // 1개를 출력할 경우 List< > 뺴고 사용
    // insert, update, delete 는 int형
    List<FeedSelVo> selFeed (FeedSelDto dto);

}
