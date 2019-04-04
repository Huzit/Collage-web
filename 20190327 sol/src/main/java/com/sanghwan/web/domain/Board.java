package com.sanghwan.web.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Entity
@Table

public class Board {
    private Long idx;
    private String title;
    private String subTitle;
    private String content;
    private BoardType boardType;
    private LocalDateTime createdDate;
    private ZonedDateTime updatedDate;
}
