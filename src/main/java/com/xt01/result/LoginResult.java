package com.xt01.result;

public class LoginResult {
    private String account;
    private String username;
    private int key;

    public LoginResult(String account, String username, int key) {
        this.account = account;
        this.username = username;
        this.key = key;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "LoginResult{" +
                "account='" + account + '\'' +
                ", username='" + username + '\'' +
                ", key=" + key +
                '}';
    }
}
