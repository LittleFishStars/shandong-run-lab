package com.kc.aw;

import com.kc.aw.lib.interf.PtgAppDownloadListener;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _d1 implements Runnable {
    public final String _a;
    public final String _b;

    public _d1(String str, String str2) {
        this._a = str;
        this._b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (!_d2._c.get() || _d2._b.get()) {
            _d2._c.set(true);
            _d2._b.set(false);
            PtgAppDownloadListener ptgAppDownloadListener_a = _d2._a(this._a);
            if (ptgAppDownloadListener_a != null) {
                ptgAppDownloadListener_a.onInstalled(this._b);
            }
        }
    }
}
