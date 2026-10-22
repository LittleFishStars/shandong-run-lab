package com.kc.bw.common.bean;

import com.kc.bw.dexg;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
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
        return dexg.dexa("TqmbtiCfbo|xnUjumf>(") + this.wmTitle + '\'' + dexg.dexa("-!xnEftd>(") + this.wmDesc + "'}";
    }
}
