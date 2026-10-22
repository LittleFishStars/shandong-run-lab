package com.kc.aw;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _nz implements Runnable {
    public final boolean _a;

    public _nz(boolean z) {
        this._a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        _o1._b(_o1._a(this._a));
    }
}
