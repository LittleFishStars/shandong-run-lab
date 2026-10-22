package com.kc.cw.ad.model;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class AdLogoInfo {
    public static int TYPE_PIC = 0;
    public static int TYPE_TEXT = 1;
    String adurl;
    int type = 0;

    public String getAdurl() {
        return this.adurl;
    }

    public int getType() {
        return this.type;
    }

    public void setAdurl(String str) {
        this.adurl = str;
    }

    public void setType(int i) {
        this.type = i;
    }
}
