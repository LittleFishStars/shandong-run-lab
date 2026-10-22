package com.kc.aw;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _e8 implements Runnable {
    public final _a3 _a;
    public final String _b;

    public _e8(_a3 _a3Var, String str) {
        this._a = _a3Var;
        this._b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this._a._a(this._b);
    }
}
