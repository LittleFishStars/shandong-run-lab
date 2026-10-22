package com.kc.dw.core.webview;

import android.webkit.WebView;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.ref.SoftReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class j extends com.kc.dw.core.safe.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SoftReference f39440a;
    public final k b;

    public j(k kVar, SoftReference softReference) {
        this.b = kVar;
        this.f39440a = softReference;
    }

    @Override // com.kc.dw.core.safe.j
    public void safeRun() {
        try {
            this.b.a((WebView) this.f39440a.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
