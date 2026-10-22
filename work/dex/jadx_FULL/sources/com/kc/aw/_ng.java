package com.kc.aw;

import android.content.Context;
import android.text.TextUtils;
import com.kc.aw.lib.PtgAdSdk;
import com.kc.aw.lib.PtgSDKConfig;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _ng {
    public final void _a(Context context, PtgSDKConfig ptgSDKConfig) {
        try {
            if (PtgAdSdk.getConfig()._c == 0) {
                String str = PtgAdSdk.getConfig()._d;
                if (!TextUtils.isEmpty(str)) {
                    if (PtgAdSdk.getConfig()._b()) {
                        _ez._a(str, (_i3) null);
                    } else {
                        _d3 _d3Var = new _d3(PtgAdSdk.getContext(), new _o4());
                        _d3Var.executeOnExecutor(_d3Var._f, str);
                    }
                }
            }
        } catch (Exception unused) {
        }
        new _hh()._a(context, ptgSDKConfig);
    }
}
