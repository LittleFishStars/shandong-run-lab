package com.kc.aw.lib;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _c implements Runnable {
    public final _d _a;

    public _c(_d _dVar) {
        this._a = _dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PtgAdSdk.Callback callback = this._a._a;
        if (callback != null) {
            callback.success();
        }
    }
}
