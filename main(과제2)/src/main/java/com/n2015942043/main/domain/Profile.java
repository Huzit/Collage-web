package com.n2015942043.main.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "PROFILE")
public class Profile implements Serializable {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column
    private String network;

    @Column
    private String username;

    @Column
    private String url;

    @Column
    private LocalDateTime createDat;

    @Builder

    public Profile(String network, String username, String url, LocalDateTime createDat) {
        this.network = network;
        this.username = username;
        this.url = url;
        this.createDat = createDat;
    }
}
