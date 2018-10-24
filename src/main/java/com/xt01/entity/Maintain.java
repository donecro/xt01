package com.xt01.entity;

import java.util.Date;

public class Maintain {
    private int id;
    private String username;
    private String account;
    private long callnum;
    private String campus;
    private String address;
    private String content;
    private String date;

    public Maintain() {
    }

    public Maintain(String username, String account, long callnum, String campus, String address, String content, String date) {
        this.username = username;
        this.account = account;
        this.callnum = callnum;
        this.campus = campus;
        this.address = address;
        this.content = content;
        this.date = date;
    }

    public Maintain(int id, String username, String account, long callnum, String campus, String address, String content, String date) {
        this.id = id;
        this.username = username;
        this.account = account;
        this.callnum = callnum;
        this.campus = campus;
        this.address = address;
        this.content = content;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public long getCallnum() {
        return callnum;
    }

    public void setCallnum(long callnum) {
        this.callnum = callnum;
    }

    public String getCampus() {
        return campus;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Maintain{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", account='" + account + '\'' +
                ", callnum=" + callnum +
                ", campus='" + campus + '\'' +
                ", address='" + address + '\'' +
                ", content='" + content + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
