package com.xt01.enums;

public enum FLInfoEnum {

    MONTH(3000,"一个月"),
    QUARTER(3050,"一个季度"),
    SEMESTER(3001,"一个学期"),
    YEAR(3002,"一个学年");

    private int fl;

    private String flInfo;

    FLInfoEnum(int fl, String flInfo) {
        this.fl = fl;
        this.flInfo = flInfo;
    }

    public int getFl() {
        return fl;
    }

    public static int getFl(String s) {
        for (FLInfoEnum f : FLInfoEnum.values()) {
            if (f.getFlInfo() == s) {
                return f.fl;
            }
        }
        return 0;
    }

    public String getFlInfo() {
        return flInfo;
    }

    public static String getFlInfo(int i) {
        for (FLInfoEnum f : FLInfoEnum.values()) {
            if (f.getFl() == i) {
                return f.flInfo;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.fl + "_" + this.flInfo;
    }
}
