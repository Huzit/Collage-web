package com.sanghwan.web.domain;

public enum BoardType {
    notice("공지사항"), free("자유게시판");

    private String value;

    public String getValue() {
        return value;
    }

    BoardType(String value) {
        this.value = value;
    }
}
