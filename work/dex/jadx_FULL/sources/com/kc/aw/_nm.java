package com.kc.aw;

import android.os.Handler;
import android.os.Looper;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _nm implements _ho, Runnable {
    public final Handler _a = new Handler(Looper.getMainLooper());
    public final _ho _b;
    public final _ch _c;
    public volatile long _d;

    public _nm(_ch _chVar, com.kc.aw.lib._e _eVar) {
        this._c = _chVar;
        this._b = _eVar;
    }

    @Override // com.kc.aw._ho
    public final void _a(_cj _cjVar, _cn _cnVar) {
        this._b._a(_cjVar, _cnVar);
        if (_cnVar._k * 1000 != this._d) {
            long j = _cnVar._k;
            if (j > 0) {
                this._d = j * 1000;
            } else {
                this._d = 0L;
            }
        }
        this._a.removeCallbacks(this);
        if (this._d > 0) {
            this._a.postDelayed(this, this._d);
        }
    }

    @Override // com.kc.aw._ho
    public final void _a(String str) {
        this._b._a(str);
    }

    @Override // com.kc.aw._ho
    public final void _b(String str) {
        this._b._b(str);
    }

    @Override // com.kc.aw._ho
    public final void _c(String str) {
        this._b._c(str);
    }

    @Override // java.lang.Runnable
    public final void run() {
        _ch _chVar = this._c;
        if (_chVar != null) {
            _chVar._a._a(new _cg(_chVar, _chVar, this));
        }
    }
}
