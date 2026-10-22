package com.ali.auth.third.ui.support;

import android.app.Activity;
import android.content.Intent;
import android.webkit.WebView;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface ActivityResultHandler {
    public static final int CALLBACK_CONTEXT = 1;
    public static final String REQUEST_CODE_KEY = "requestCodeKey";
    public static final int TAE_SDK_ACTIVITY = 2;

    void onActivityResult(int i, int i2, int i3, Intent intent, Activity activity, Map<Class<?>, Object> map, WebView webView);
}
