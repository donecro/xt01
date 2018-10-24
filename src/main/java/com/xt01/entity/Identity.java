package com.xt01.entity;

public class Identity {

    long uid;
    String username;
    String over;
    String sex;
    String email;
    String identity;
    long callnum;
    String address;

    public Identity() {
    }

    public Identity(long uid, String username, String over, String sex, String email, String identity, long callnum, String address) {
        this.uid = uid;
        this.username = username;
        this.over = over;
        this.sex = sex;
        this.email = email;
        this.identity = identity;
        this.callnum = callnum;
        this.address = address;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOver() {
        return over;
    }

    public void setOver(String over) {
        this.over = over;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public long getCallnum() {
        return callnum;
    }

    public void setCallnum(long callnum) {
        this.callnum = callnum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Identity{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", over='" + over + '\'' +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                ", identity='" + identity + '\'' +
                ", callnum=" + callnum +
                ", address='" + address + '\'' +
                '}';
    }
}
