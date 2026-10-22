package com.kc.aw;

import com.kc.aw.widget.web.AdTemplateWebView;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _1 implements Runnable {
    public final AdTemplateWebView _a;

    public _1(AdTemplateWebView adTemplateWebView) {
        this._a = adTemplateWebView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AdTemplateWebView adTemplateWebView = this._a;
        if (adTemplateWebView._b) {
            return;
        }
        adTemplateWebView.evaluateJavascript("javascript:stopTime()", null);
    }
}
