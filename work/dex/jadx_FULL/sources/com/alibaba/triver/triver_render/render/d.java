package com.alibaba.triver.triver_render.render;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.alibaba.ariver.engine.api.bridge.model.ScrollChangedCallback;
import com.uc.webview.export.WebChromeClient;
import com.uc.webview.export.WebViewClient;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface d extends android.taobao.windvane.d.b {

    public interface a {
        void a();
    }

    void a(Object obj);

    void a(String str);

    void b(String str);

    boolean canGoBack();

    View d();

    void e();

    void f();

    void g();

    String getAppId();

    String getClientId();

    void goBack();

    void h();

    boolean i();

    void onActivityResult(int i, int i2, Intent intent);

    void setAppId(String str);

    void setLoadCallback(a aVar);

    void setOuterCtx(Context context);

    void setScrollListener(ScrollChangedCallback scrollChangedCallback);

    void setWebChromeClient(WebChromeClient webChromeClient);

    void setWebViewClient(WebViewClient webViewClient);
}
