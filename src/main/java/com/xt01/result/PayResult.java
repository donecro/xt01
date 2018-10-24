package com.xt01.result;

public class PayResult {

    private String username;
    private String sex;
    private long uid;
    private long callnum;
    private String usergroup;
    private String address;
    private String bst;
    private int forlong;
    private String identity;
    private int acode;
    private String password;
    private String applytime;
    private double totalfee;

    public PayResult(String username, String sex, long uid, long callnum, String usergroup, String address, String bst, int forlong, String identity, int acode, String password, String applytime, double totalfee) {
        this.username = username;
        this.sex = sex;
        this.uid = uid;
        this.callnum = callnum;
        this.usergroup = usergroup;
        this.address = address;
        this.bst = bst;
        this.forlong = forlong;
        this.identity = identity;
        this.acode = acode;
        this.password = password;
        this.applytime = applytime;
        this.totalfee = totalfee;
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

    public String getBst() {
        return bst;
    }

    public void setBst(String bst) {
        this.bst = bst;
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

    public int getAcode() {
        return acode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getApplytime() {
        return applytime;
    }

    public double getTotalfee() {
        return totalfee;
    }

    @Override
    public String toString() {
        return "PayResult{" +
                "username='" + username + '\'' +
                ", sex='" + sex + '\'' +
                ", uid=" + uid +
                ", callnum=" + callnum +
                ", usergroup='" + usergroup + '\'' +
                ", address='" + address + '\'' +
                ", bst='" + bst + '\'' +
                ", forlong=" + forlong +
                ", identity='" + identity + '\'' +
                ", acode=" + acode +
                ", password='" + password + '\'' +
                ", applytime='" + applytime + '\'' +
                ", totalfee=" + totalfee +
                '}';
    }
}
