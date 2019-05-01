package com.sanghwan.basic.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@NoArgsConstructor

@Entity
@Table(name = "profile")
public class Profile implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idx;

    @Column
    private String network;

    @Column
    private String url;

    @Column
    private String userName;


    @Builder
    public Profile(String network, String url, String userName) {
        this.network = network;
        this.url = url;
        this.userName = userName;
    }
}
