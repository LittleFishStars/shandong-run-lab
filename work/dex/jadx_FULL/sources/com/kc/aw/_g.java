package com.kc.aw;

import android.text.TextUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _g implements Runnable {
    public final _c._b _a;

    public _g(_c._b _bVar) {
        this._a = _bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str = _i2._f._a;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        new _c8(_hj._a(str.replace("__ACTION__", "syncStatus").replace("__DATA__", com.kc.aw.lib.utils._a._b("{}")), _c._a(this._a._a))).execute(new Void[0]);
    }
}
