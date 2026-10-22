package com.kc.aw;

import com.kc.aw.lib.constants.PtgErrorCode;
import com.kc.aw.lib.utils.Logger;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _cu implements Runnable {
    public final AtomicBoolean _a;
    public final _cw._a _b;
    public final _cw _c;

    public _cu(_cw _cwVar, AtomicBoolean atomicBoolean, _d6 _d6Var) {
        this._c = _cwVar;
        this._a = atomicBoolean;
        this._b = _d6Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this._a.getAndSet(true)) {
            return;
        }
        Logger.d("PTG_QM_TAG timeout");
        _cw._a(this._c, this._b, 0, PtgErrorCode.SDK_REQUEST_OVER_TIME, "Operation timeout");
    }
}
