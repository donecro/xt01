package com.xt01.result.Setting;

public class BTResult {
    private int i;
    private String bst;
    private double mprice;
    private double qprice;
    private double sprice;
    private double yprice;
    private String remark;

    public BTResult() {
    }

    public BTResult(int i, String bst, double mprice, double qprice, double sprice, double yprice, String remark) {
        this.i = i;
        this.bst = bst;
        this.mprice = mprice;
        this.qprice = qprice;
        this.sprice = sprice;
        this.yprice = yprice;
        this.remark = remark;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public String getBst() {
        return bst;
    }

    public void setBst(String bst) {
        this.bst = bst;
    }

    public double getMprice() {
        return mprice;
    }

    public void setMprice(double mprice) {
        this.mprice = mprice;
    }

    public double getQprice() {
        return qprice;
    }

    public void setQprice(double qprice) {
        this.qprice = qprice;
    }

    public double getSprice() {
        return sprice;
    }

    public void setSprice(double sprice) {
        this.sprice = sprice;
    }

    public double getYprice() {
        return yprice;
    }

    public void setYprice(double yprice) {
        this.yprice = yprice;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "BTResult{" +
                "i=" + i +
                ", bst='" + bst + '\'' +
                ", mprice=" + mprice +
                ", qprice=" + qprice +
                ", sprice=" + sprice +
                ", yprice=" + yprice +
                ", remark='" + remark + '\'' +
                '}';
    }
}
