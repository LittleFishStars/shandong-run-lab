package com.ali.auth.third.core.cookies;

import com.ali.auth.third.core.WebViewProxy;
import com.ali.auth.third.core.context.KernelContext;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {
    public static WebViewProxy a() {
        WebViewProxy webViewProxy = KernelContext.mWebViewProxy;
        return webViewProxy != null ? webViewProxy : com.ali.auth.third.core.a.a.a();
    }
}
