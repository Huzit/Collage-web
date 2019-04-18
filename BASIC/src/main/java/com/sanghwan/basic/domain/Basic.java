package com.sanghwan.basic.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@NoArgsConstructor

@Entity
@Table(name="Basic")
public class Basic implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idx;

    @Column
    private String name;

    @Column
    private String label;

    @Column
    private String email;

    @Column
    private String phone;

    @Builder
    public Basic(Long idx, String name, String label, String email, String phone) {
        //this.idx = idx;
        this.name = name;
        this.label = label;
        this.email = email;
        this.phone = phone;
    }
}