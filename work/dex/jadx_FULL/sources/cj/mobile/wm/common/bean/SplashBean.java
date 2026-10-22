package cj.mobile.wm.common.bean;

import cj.mobile.wm.dexc;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class SplashBean {
    public String wmDesc;
    public String wmTitle;

    public SplashBean(String str, String str2) {
        this.wmTitle = str;
        this.wmDesc = str2;
    }

    public String getWmDesc() {
        return this.wmDesc;
    }

    public String getWmTitle() {
        return this.wmTitle;
    }

    public void setWmDesc(String str) {
        this.wmDesc = str;
    }

    public void setWmTitle(String str) {
        this.wmTitle = str;
    }

    public String toString() {
        return dexc.dexa("TqmbtiCfbo|xnUjumf>(") + this.wmTitle + '\'' + dexc.dexa("-!xnEftd>(") + this.wmDesc + "'}";
    }
}
