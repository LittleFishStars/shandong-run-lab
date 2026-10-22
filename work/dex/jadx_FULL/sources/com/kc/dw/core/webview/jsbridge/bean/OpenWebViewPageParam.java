package com.kc.dw.core.webview.jsbridge.bean;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class OpenWebViewPageParam extends UUIDParam {
    public static final int USE_BROWSER = 1;
    private static final long serialVersionUID = 1;
    private int open_type;
    private String url;

    public int getOpen_type() {
        return this.open_type;
    }

    public String getUrl() {
        return this.url;
    }
}
