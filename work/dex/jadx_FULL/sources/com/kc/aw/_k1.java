package com.kc.aw;

import android.content.Context;
import android.os.Looper;
import com.kc.aw.lib.core.model.AdErrorImpl;
import com.kc.aw.lib.model.AdError;
import com.kc.aw.lib.model.AdSlot;
import com.kc.aw.lib.provider.PtgAdNative;
import com.kc.aw.provider.PtgApiProvider;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _k1 implements _b3<_q> {
    public final PtgAdNative.SplashAdListener _a;
    public final AdSlot _b;
    public final Context _c;
    public final _k2 _d;

    public _k1(_k2 _k2Var, PtgAdNative.SplashAdListener splashAdListener, AdSlot adSlot, Context context) {
        this._d = _k2Var;
        this._a = splashAdListener;
        this._b = adSlot;
        this._c = context;
    }

    @Override // com.kc.aw._b3
    public final void _a(_q _qVar) {
        _k0 _k0Var = new _k0(this, _qVar);
        _fz _fzVar = _fz._a;
        if (Looper.getMainLooper().equals(Looper.myLooper())) {
            _k0Var.run();
        } else {
            _fz._a.post(_k0Var);
        }
    }

    @Override // com.kc.aw._b3
    public final void onError(AdError adError) {
        PtgAdNative.SplashAdListener splashAdListener = this._a;
        if (splashAdListener != null) {
            AdErrorImpl adErrorImpl = new AdErrorImpl(adError.getErrorCode(), adError.getMessage(), (Object) null);
            adErrorImpl._c = PtgApiProvider.providerName;
            splashAdListener.onError(adErrorImpl);
        }
    }
}
