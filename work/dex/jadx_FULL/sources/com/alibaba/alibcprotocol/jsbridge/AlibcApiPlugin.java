package com.alibaba.alibcprotocol.jsbridge;

import android.content.Context;
import android.webkit.WebView;
import com.alibaba.alibcprotocol.base.AlibcJsEnum;
import com.alibaba.alibcprotocol.jsbridge.callback.AlibcJsCallback;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class AlibcApiPlugin {
    protected static final String CODE = "code";
    protected static final String MSG = "msg";
    protected boolean isAlive = true;
    protected WebView mWebView;
    public Object paramObj;

    public Map<String, Object> buildResult(AlibcJsEnum alibcJsEnum, Map<String, Object> map) {
        if (map == null) {
            map = new HashMap<>(16);
        }
        map.put("code", Integer.valueOf(alibcJsEnum.getCode()));
        map.put("msg", alibcJsEnum.getMsg());
        return map;
    }

    public abstract boolean execute(String str, String str2, AlibcJsCallback alibcJsCallback);

    public abstract String getPluginTag();

    public void initialize(Context context, WebView webView) {
        initialize(context, webView, null);
    }

    public void onDestroy() {
        this.isAlive = false;
    }

    public void onPause() {
        this.isAlive = false;
    }

    public void onResume() {
        this.isAlive = true;
    }

    public void initialize(Context context, WebView webView, Object obj) {
        this.mWebView = webView;
        this.paramObj = obj;
    }

    public void initialize(Context context, Object obj) {
        this.paramObj = obj;
    }
}
