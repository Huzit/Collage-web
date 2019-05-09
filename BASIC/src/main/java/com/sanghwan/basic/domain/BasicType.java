package com.sanghwan.basic.domain;

public enum BasicType {
    notice("공지사항"),
    free("자유게시판");

    private String value;

    public String getValue() {return value;}
    BasicType(String value) {this.value = value;}
}
