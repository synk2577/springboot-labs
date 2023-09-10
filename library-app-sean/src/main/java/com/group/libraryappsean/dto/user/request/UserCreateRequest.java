package com.group.libraryappsean.dto.user.request;

public class UserCreateRequest {
    private String name;
    private Integer age; // int: null 표현 불가, Integer: null 표현 가능

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
