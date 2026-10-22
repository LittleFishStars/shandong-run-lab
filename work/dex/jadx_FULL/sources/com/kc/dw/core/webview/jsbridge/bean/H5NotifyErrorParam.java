package com.kc.dw.core.webview.jsbridge.bean;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class H5NotifyErrorParam extends UUIDParam {
    private static final long serialVersionUID = 1;
    private int code;
    private String message;

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
