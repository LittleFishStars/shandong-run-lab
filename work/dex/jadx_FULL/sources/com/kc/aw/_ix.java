package com.kc.aw;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _ix implements Runnable {
    public final _bh _a;

    public _ix(_bh _bhVar) {
        this._a = _bhVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        _bh _bhVar = this._a;
        if (_bhVar != null) {
            _bhVar._a();
        }
    }
}
