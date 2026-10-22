package com.kc.aw;

import com.kc.aw.lib.PtgAdSdk;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _g7 implements Runnable {
    public final _g8 _a;

    public _g7(_g8 _g8Var) {
        this._a = _g8Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this._a._f = true;
        _i appLifecycleListener = PtgAdSdk.getAppLifecycleListener();
        _g8 _g8Var = _g8._b._a;
        if (_g8Var != null) {
            appLifecycleListener._a.add(_g8Var);
        } else {
            appLifecycleListener.getClass();
        }
        this._a._c();
    }
}
