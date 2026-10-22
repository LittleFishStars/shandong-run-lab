package com.kc.aw;

import android.view.View;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _n8 implements Runnable {
    public final _k _a;
    public final View _b;
    public final _n9 _c;

    public _n8(_n9 _n9Var, _k _kVar, View view) {
        this._c = _n9Var;
        this._a = _kVar;
        this._b = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this._c._a(this._a)) {
            this._c._f.set(true);
            _o6._a(this._b, 6);
        }
    }
}
