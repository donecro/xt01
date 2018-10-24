package com.xt01.enums;

public enum AdminPowerEnum {

    SUPER(40001, "超级管理员"),
    GENERAL(40002, "普通管理员");

    private int power;

    private String powerInfo;

    private AdminPowerEnum(int power , String powerInfo) {
        this.power = power;
        this.powerInfo = powerInfo;
    }

    public int getPower() {

        return power;
    }


    public String getPowerInfo() {

        return powerInfo;
    }


}
