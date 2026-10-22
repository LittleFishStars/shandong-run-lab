package com.kc.aw;

import com.kc.aw.lib.core.model.AdErrorImpl;
import com.kc.aw.lib.model.AdError;
import com.kc.aw.lib.utils.Logger;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _0 implements _b3<_q> {
    public final _s _a;
    public AtomicInteger _b;
    public AtomicBoolean _c = new AtomicBoolean();
    public _b3<_q> _d;

    public _0(_s _sVar, int i, _b3 _b3Var) {
        this._a = _sVar;
        this._b = new AtomicInteger(i);
        this._d = _b3Var;
    }

    public final void _a(_s _sVar, AdError adError) {
        boolean z;
        _q _qVar;
        if (adError != null) {
            _b3<_q> _b3Var = this._d;
            if (_b3Var != null) {
                _b3Var.onError(adError);
                return;
            }
            return;
        }
        _b3<_q> _b3Var2 = this._d;
        if (_b3Var2 != null) {
            _ah _ahVar = (_ah) _sVar;
            synchronized (_ahVar._b) {
                z = false;
                if (_ahVar._b.isEmpty()) {
                    _qVar = null;
                } else {
                    _qVar = (_q) _ahVar._b.remove(0);
                    z = true;
                }
            }
            if (z) {
                _ahVar._b();
            }
            _b3Var2._a(_qVar);
        }
    }

    @Override // com.kc.aw._b3
    public final void _a(_q _qVar) {
        _q _qVar2 = _qVar;
        this._b.decrementAndGet();
        if (_qVar2 != null) {
            _ah _ahVar = (_ah) this._a;
            if (_ahVar._d.get()) {
                synchronized (_ahVar._b) {
                    _ahVar._b.add(_qVar2);
                }
                _ahVar._b();
            } else {
                synchronized (_ahVar._a) {
                    _ahVar._a.add(_qVar2);
                }
                Logger.e("AdPool 初始化未完成");
            }
        }
        if (this._c.compareAndSet(false, true)) {
            _a(this._a, null);
        }
    }

    @Override // com.kc.aw._b3
    public final void onError(AdError adError) {
        if (this._b.decrementAndGet() == 0 && this._c.compareAndSet(false, true)) {
            _s _sVar = this._a;
            if (adError == null) {
                adError = new AdErrorImpl(10000, AdError.ERROR_NO_AD_STR, (Object) null);
            }
            _a(_sVar, adError);
        }
    }
}
