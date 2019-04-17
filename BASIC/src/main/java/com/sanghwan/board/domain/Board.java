package com.sanghwan.board.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@NoArgsConstructor

@Entity
@Table(name="Basic")
public class Board implements Serializable {
    @Column
    private String name;
    @Column
    private String label;
    @Column
    private String email;
    @Column
    private String phone;

    public Board(String name, String label, String email, String phone) {
        this.name = name;
        this.label = label;
        this.email = email;
        this.phone = phone;
    }
}