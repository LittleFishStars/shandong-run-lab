package com.kc.dw.core.webview.jsbridge.bean;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class InvokeDeepLinkParam extends UUIDParam {
    private static final long serialVersionUID = 1;
    private String callbackFunc;
    private String deep_link;
    private int down_x;
    private int down_y;
    private long msec;
    private int up_x;
    private int up_y;

    public String getCallbackFunc() {
        return this.callbackFunc;
    }

    public String getDeep_link() {
        return this.deep_link;
    }

    public int getDown_x() {
        return this.down_x;
    }

    public int getDown_y() {
        return this.down_y;
    }

    public long getMsec() {
        return this.msec;
    }

    public int getUp_x() {
        return this.up_x;
    }

    public int getUp_y() {
        return this.up_y;
    }
}
