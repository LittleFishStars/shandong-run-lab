package com.byazt.ol;

import android.webkit.JavascriptInterface;
import com.byazt.pct.zm;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 41, 15})
public class uj {
    public WeakReference<zm> c;

    public uj(zm zmVar) {
        this.c = new WeakReference<>(zmVar);
    }

    public void c(zm zmVar) {
        this.c = new WeakReference<>(zmVar);
    }

    @JavascriptInterface
    public void invokeMethod(String str) {
        WeakReference<zm> weakReference = this.c;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.c.get().invokeMethod(str);
    }
}
