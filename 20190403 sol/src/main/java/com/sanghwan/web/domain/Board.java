package com.sanghwan.web.domain;

import com.sun.javafx.beans.IDProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter //이것들의 기능이 뭐징?
@NoArgsConstructor

@Entity //이제부터 입력하는건
@Table  //데이터 베이스로 알아줘?
public class Board {

    @Id//프라이머리 킷
    @Column //필드와 데이터를 맵핑시켜준다.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //데이터테이블에서 자동으로 생성되는 값이 순차적으로 된다.
    private Long idx;

    @Column
    private String title;

    @Column
    private String subTitle;

    @Column
    private String content;

    @Column
    @Enumerated(EnumType.STRING) //열거형타입은 앵간해선 정수형인데 DB에는 0, 1을 넣으면 안되므로 앵간하면 STRING으로 박아놓자
    private BoardType boardType;

    @Column
    private LocalDateTime createdDate;

    @Column
    private LocalDateTime updatedDate;

    @Builder
    public Board(String title, String subTitle, String content, BoardType boardType, LocalDateTime createdDate, LocalDateTime updatedDate) {
        this.title = title;
        this.subTitle = subTitle;
        this.content = content;
        this.boardType = boardType;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }
}
