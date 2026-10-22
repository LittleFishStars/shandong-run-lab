package com.kc.dw.core.webview;

import android.webkit.ValueCallback;
import com.kc.dw.core.utils.LogUtil;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class m extends com.kc.dw.core.safe.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f39448a;
    public final l b;

    @Keep
    public class a implements ValueCallback<String> {
        public a(m mVar) {
        }

        @Override // android.webkit.ValueCallback
        public void onReceiveValue(String str) {
            LogUtil.e("WebViewUtil", "onReceiveValue:" + str);
        }
    }

    public m(l lVar, String str) {
        this.b = lVar;
        this.f39448a = str;
    }

    @Override // com.kc.dw.core.safe.j
    public void safeRun() {
        try {
            this.b.f39444a.evaluateJavascript(String.format("javascript:window.ADMateJSBridge.updateTempState('%s')", this.f39448a), new a(this));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
