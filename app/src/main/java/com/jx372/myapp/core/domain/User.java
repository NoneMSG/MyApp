package com.jx372.myapp.core.domain;

/**
 * Created by bit-user on 2017-08-12.
 */

public class User {
    private Long no;
    private String name;
    private String email;
    private String profile;

    public Long getNo() {
        return no;
    }

    public void setNo(Long no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    @Override
    public String toString() {
        return "User{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", enail='" + email + '\'' +
                ", profile='" + profile + '\'' +
                '}';
    }
}
