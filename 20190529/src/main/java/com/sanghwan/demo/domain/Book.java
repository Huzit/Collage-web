package com.sanghwan.demo.domain;

import javax.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idx;
    private String name;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        if(this.category != null){
        this.category.getBook().remove(this);
        }
        this.category = category;
        if(category!=null){
            category.getBook().add(this);
        }
    }

    @ManyToOne
    private Category category;


    public Long getIdx() {
        return idx;
    }

    public void setIdx(Long idx) {
        this.idx = idx;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

}
