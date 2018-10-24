package com.xt01.result.Setting;

public class UGResult {
    private int i;
    private String s;

    public UGResult() {
    }

    public UGResult(int i, String s) {
        this.i = i;
        this.s = s;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return "SettingResult{" +
                "i=" + i +
                ", s='" + s + '\'' +
                '}';
    }
}
