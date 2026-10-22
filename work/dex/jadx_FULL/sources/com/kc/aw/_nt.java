package com.kc.aw;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _nt {
    public static _nt _c;
    public static final AtomicBoolean _d = new AtomicBoolean();
    public final HashSet _a = new HashSet();
    public _l0 _b;

    public static _nt _a() {
        _nt _ntVar;
        synchronized (_nt.class) {
            try {
                if (_c == null) {
                    _c = new _nt();
                }
                _ntVar = _c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return _ntVar;
    }

    public final void _a(Set set, String str, _nr _nrVar, String str2) {
        _l0 _l0Var = this._b;
        if (_l0Var == null) {
            _l0Var = new _l0();
            this._b = _l0Var;
        }
        _l0Var._a(set, str, _nrVar, str2);
    }
}
