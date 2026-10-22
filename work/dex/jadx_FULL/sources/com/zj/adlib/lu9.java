package com.zj.adlib;

import android.text.TextUtils;
import com.huachenjie.base.dsbridge_webview.interceptor.CloseInterceptor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class lu9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f43155a = "default";

    public static CloseInterceptor a(String closeName) {
        if (!TextUtils.isEmpty(closeName) && closeName.equals("default")) {
            return new cf2();
        }
        return null;
    }
}
