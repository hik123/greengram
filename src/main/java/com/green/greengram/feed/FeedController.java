package com.green.greengram.feed;


import com.green.greengram.ResVo;
import com.green.greengram.feed.model.FeedInsDto;
import com.green.greengram.feed.model.FeedPicsVo;
import com.green.greengram.feed.model.FeedSelVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Controller는 요청받고 service에게 일 넘겨줌
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/feed")
public class FeedController {
    private final FeedService service;

    @PostMapping
    public ResVo insFeed(@RequestBody FeedInsDto dto) {
        System.out.println(dto);
        return service.insFeed(dto);
    }

    @GetMapping
    public List<FeedSelVo> getFeed(int page) {
        System.out.println(page);
        return service.getFeed(page);
    }
}
