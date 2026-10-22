package com.kc.aw;

import com.kc.aw.lib.model.AdSlot;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _h3 implements Runnable {
    public final AdSlot _a;
    public final _b3 _b;

    public _h3(AdSlot adSlot, _b3 _b3Var) {
        this._a = adSlot;
        this._b = _b3Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        _l4._b(this._a, this._b);
    }
}
