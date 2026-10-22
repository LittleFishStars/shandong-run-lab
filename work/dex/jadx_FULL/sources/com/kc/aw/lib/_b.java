package com.kc.aw.lib;

import android.content.Context;
import com.kc.aw.lib.provider.PtgAdNative;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _b implements Runnable {
    public final Context _a;
    public final PtgSDKConfig _b;
    public final PtgAdNative[] _c;
    public final PtgAdSdk.Callback _d;

    public _b(Context context, PtgSDKConfig ptgSDKConfig, PtgAdSdk.Callback callback, PtgAdNative[] ptgAdNativeArr) {
        this._a = context;
        this._b = ptgSDKConfig;
        this._c = ptgAdNativeArr;
        this._d = callback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        _a._a(this._a, this._b, this._d, this._c);
    }
}
