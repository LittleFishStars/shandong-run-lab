package com.kc.aw;

import android.content.Context;
import com.kc.aw.lib.PtgSDKConfig;
import com.kc.aw.lib.utils.dev.ScreenUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Random;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _nf implements _et {
    @Override // com.kc.aw._et
    public final void _a(Context context, _cn _cnVar) {
        _en _enVar = _du._a;
        if (_enVar == null) {
            return;
        }
        _enVar._b();
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0020  */
    @Override // com.kc.aw._et
    public final void _a(Context context, PtgSDKConfig ptgSDKConfig) {
        boolean z;
        _en _enVar;
        Random random = com.kc.aw.lib.utils._a._a;
        if (ScreenUtils.GUBED) {
            z = true;
        } else {
            _cc._c();
            if (!_cc._e) {
                _cc._c();
                if (!_cc._f) {
                    _cc._c();
                    if (!_cc._g) {
                        z = true;
                    }
                }
            }
            z = false;
        }
        if (z && (_enVar = _du._a) != null) {
            _enVar._a();
        }
    }
}
