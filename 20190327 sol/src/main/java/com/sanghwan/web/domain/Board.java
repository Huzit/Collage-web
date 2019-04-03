package com.sanghwan.web.domain;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class Board {
    private Long idx;
    private String title;
    private String subTitle;
    private String content;
    private BoardType boardType;
    private LocalDateTime createdDate;
    private ZonedDateTime updatedDate;
}
