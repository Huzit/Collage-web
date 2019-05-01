package com.sanghwan.basic.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor

@Entity
@Table(name = "work")
public class Work implements Serializable {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idx;

    @Column
    private String company;

    @Column
    private String position;

    @Column
    private String website;

    @Column
    private LocalDateTime startdate;

    @Column
    private LocalDateTime enddate;

    @Column
    private String summry;

    @Builder
    public Work(String company, String position, String website, LocalDateTime startdate, LocalDateTime enddate, String summry) {
        this.company = company;
        this.position = position;
        this.website = website;
        this.startdate = startdate;
        this.enddate = enddate;
        this.summry = summry;
    }
}
