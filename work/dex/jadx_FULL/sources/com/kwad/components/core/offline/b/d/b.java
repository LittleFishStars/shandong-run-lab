package com.kwad.components.core.offline.b.d;

import android.content.Context;
import com.kwad.components.offline.api.core.webview.BaseKsWebView;
import com.kwad.components.offline.api.core.webview.IWebView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class b implements IWebView {
    @Override // com.kwad.components.offline.api.core.webview.IWebView
    public final BaseKsWebView createWebView(Context context) {
        return new a(context);
    }
}
