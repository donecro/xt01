package com.xt01.entity;

import com.xt01.enums.FLInfoEnum;

import java.util.Date;

public class Apply{

    private long rid;
    private String username;
    private String sex;
    private long uid;
    private long callnum;
    private String usergroup;
    private String address;
    private String businesstype;
    private int forlong;
    private String identity;
    private String password;
    private Date applytime;
    private double pay;

    public Apply() {

    }

    public Apply(long rid, String username, String sex, long uid, long callnum, String usergroup, String address, String businesstype, int forlong, String identity, String password, Date applytime, double pay) {
        this.rid = rid;
        this.username = username;
        this.sex = sex;
        this.uid = uid;
        this.callnum = callnum;
        this.usergroup = usergroup;
        this.address = address;
        this.businesstype = businesstype;
        this.forlong = forlong;
        this.identity = identity;
        this.password = password;
        this.applytime = applytime;
        this.pay = pay;
    }

    public long getRid() {
        return rid;
    }

    public void setRid(long rid) {
        this.rid = rid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public long getCallnum() {
        return callnum;
    }

    public void setCallnum(long callnum) {
        this.callnum = callnum;
    }

    public String getUsergroup() {
        return usergroup;
    }

    public void setUsergroup(String usergroup) {
        this.usergroup = usergroup;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBusinesstype() {
        return businesstype;
    }

    public void setBusinesstype(String businesstype) {
        this.businesstype = businesstype;
    }

    public int getForlong() {
        return forlong;
    }

    public void setForlong(int forlong) {
        this.forlong = forlong;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getApplytime() {
        return applytime;
    }

    public void setApplytime(Date applytime) {
        this.applytime = applytime;
    }

    public double getPay() {
        return pay;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }

    @Override
    public String toString() {
        return "Apply{" +
                "rid=" + rid +
                ", username='" + username + '\'' +
                ", sex='" + sex + '\'' +
                ", uid=" + uid +
                ", callnum=" + callnum +
                ", usergroup='" + usergroup + '\'' +
                ", address='" + address + '\'' +
                ", businesstype='" + businesstype + '\'' +
                ", forlong='" + FLInfoEnum.getFlInfo(forlong) + '\'' +
                ", identity='" + identity + '\'' +
                ", password='" + password + '\'' +
                ", applytime=" + applytime +
                ", pay=" + pay +
                '}';
    }
}
