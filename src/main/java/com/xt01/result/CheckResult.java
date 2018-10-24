package com.xt01.result;

public class CheckResult {
    private String username;
    private long callnum;
    private String sex;
    private long uid;
    private String identity;
    private int key;

    public CheckResult(String username, long callnum, String sex, long uid, String identity, int key) {
        this.username = username;
        this.callnum = callnum;
        this.sex = sex;
        this.uid = uid;
        this.identity = identity;
        this.key = key;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getCallnum() {
        return callnum;
    }

    public void setCallnum(long callnum) {
        this.callnum = callnum;
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

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "CheckResult{" +
                "username='" + username + '\'' +
                ", callnum=" + callnum +
                ", sex='" + sex + '\'' +
                ", uid=" + uid +
                ", identity='" + identity + '\'' +
                ", key=" + key +
                '}';
    }
}
