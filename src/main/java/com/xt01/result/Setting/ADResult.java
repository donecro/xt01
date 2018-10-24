package com.xt01.result.Setting;

public class ADResult {
    private int i;
    private String build;


    public ADResult() {
    }

    public ADResult(int i, String build) {
        this.i = i;
        this.build = build;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public String getBuild() {
        return build;
    }

    public void setBuild(String build) {
        this.build = build;
    }

    @Override
    public String toString() {
        return "ADResult{" +
                "i=" + i +
                ", build='" + build + '\'' +
                '}';
    }
}
