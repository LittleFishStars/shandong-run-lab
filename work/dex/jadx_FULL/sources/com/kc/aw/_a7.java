package com.kc.aw;

import android.app.Application;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;
import java.util.UUID;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _a7 implements _oe<Application> {
    public final _of _a;
    public final ArrayList _b = new ArrayList();

    public _a7() {
        UUID.randomUUID().toString();
        _of _ofVar = new _of();
        this._a = _ofVar;
        _ofVar._a(null, this);
    }

    @Override // com.kc.aw._oe
    public final _oe _a(_og _ogVar) {
        synchronized (this._b) {
            if (!this._b.contains(_ogVar)) {
                this._b.add(_ogVar);
            }
        }
        this._a._a(_ogVar);
        return this;
    }

    @Override // com.kc.aw._oe
    public final _of _a() {
        return this._a;
    }
}
