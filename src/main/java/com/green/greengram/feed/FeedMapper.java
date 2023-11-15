package com.green.greengram.feed;

import com.green.greengram.feed.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FeedMapper {
    int insFeed(FeedInsProcDto dto);
    List<FeedSelVo> selFeed(FeedSelDto dto);
    // select 전체 출력 할때 List 사용
    // 1개를 출력할 경우 List< > 뺴고 사용
    // insert, update, delete 는 int형

    //t_feed_pics
    int insFeedPic(FeedPicsInsProcDto dto);
    List<FeedPicsVo> selFeedPics(List<Integer> list);

    //t_favorite
    int delFeedFav(FeedFavProcDto dto);
    int insFeedFav(FeedFavProcDto dto);
}
