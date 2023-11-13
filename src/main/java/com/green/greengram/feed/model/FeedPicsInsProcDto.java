package com.green.greengram.feed.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor   // 멤버필드를 파라미터값으로 받는 생성자를 만들어준다
public class FeedPicsInsProcDto {
    private int ifeed;
    private List<String> pics;
}
