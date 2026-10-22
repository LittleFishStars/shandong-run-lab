package com.kc.aw;

import android.text.TextUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _hq implements _hl {
    @Override // com.kc.aw._hl
    public final boolean _a(_cl _clVar) {
        return (_clVar == null || TextUtils.isEmpty(_clVar._c) || !_i2._f._c.contains(_clVar._c)) ? false : true;
    }

    @Override // com.kc.aw._hl
    public final boolean start() {
        return true;
    }
}
