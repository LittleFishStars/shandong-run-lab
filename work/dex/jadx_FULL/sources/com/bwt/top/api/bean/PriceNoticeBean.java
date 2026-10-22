package com.bwt.top.api.bean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class PriceNoticeBean {
    private String posid;
    private String price;
    private String winOrLoss;

    public PriceNoticeBean(String str, String str2, String str3) {
        this.posid = str;
        this.winOrLoss = str2;
        this.price = str3;
    }

    public String getPosid() {
        return this.posid;
    }

    public String getPrice() {
        return this.price;
    }

    public String getWinOrLoss() {
        return this.winOrLoss;
    }

    public void setPosid(String str) {
        this.posid = str;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public void setWinOrLoss(String str) {
        this.winOrLoss = str;
    }
}
