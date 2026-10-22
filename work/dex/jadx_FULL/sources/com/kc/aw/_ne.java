package com.kc.aw;

import android.content.Context;
import com.kc.aw.lib.PtgSDKConfig;
import com.kc.aw.lib.utils.dev.ScreenUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _ne implements _et {
    public final AtomicBoolean _a = new AtomicBoolean();

    /* JADX WARN: Code duplicated, block: B:14:0x0021  */
    @Override // com.kc.aw._et
    public final void _a(Context context, _cn _cnVar) {
        boolean z;
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
        if (z && !this._a.get()) {
            this._a.set(true);
        }
    }

    @Override // com.kc.aw._et
    public final void _a(Context context, PtgSDKConfig ptgSDKConfig) {
    }
}
