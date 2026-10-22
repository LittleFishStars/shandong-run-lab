package com.alibaba.alibclinkpartner.linkpartner.param;

import android.webkit.WebView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ALPJumpFailedStrategy {
    public String degradeH5Url;
    public OnFailureListener failureListener;
    public int mode = 4;
    public WebView webView;

    public interface OnFailureListener {
        void onFailure(int i, String str);
    }
}
