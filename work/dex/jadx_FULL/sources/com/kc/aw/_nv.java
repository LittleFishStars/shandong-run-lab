package com.kc.aw;

import android.content.Context;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _nv implements Runnable {
    public final Context _a;
    public final _nw._a _b;

    public _nv(Context context, _nu _nuVar) {
        this._a = context;
        this._b = _nuVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            try {
                _nw._b.incrementAndGet();
                String str_a = _nw._a(this._a);
                _nw._c = str_a;
                _jw._a(this._a, "ptg_ua", str_a);
                _nw._a(this._b, str_a);
            } catch (Exception unused) {
                _nw._a(this._b, "");
            }
        } finally {
            _nw._a.set(false);
        }
    }
}
