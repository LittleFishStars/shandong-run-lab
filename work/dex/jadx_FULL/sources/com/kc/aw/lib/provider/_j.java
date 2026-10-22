package com.kc.aw.lib.provider;

import android.os.Handler;
import android.os.Looper;
import com.kc.aw._g1;
import com.kc.aw._mq;
import com.kc.aw.lib.constants.PtgErrorCode;
import com.kc.aw.lib.core.model.AdErrorImpl;
import com.kc.aw.lib.interf.PtgSplashAd;
import com.kc.aw.lib.model.AdError;
import com.kc.aw.lib.model.AdSlot;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _j extends _mq {
    public final _mq _b;
    public final AdSlot _c;

    @Keep
    public final class _a implements Runnable {
        public final PtgSplashAd _a;
        public final _j _b;

        public _a(_j _jVar, PtgSplashAd ptgSplashAd) {
            this._b = _jVar;
            this._a = ptgSplashAd;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                this._a.load();
                this._b._b.onSplashAdLoad(this._a);
            } catch (Exception e) {
                this._b._b._a.onError(new AdErrorImpl(PtgErrorCode.SDK_SPLASH_SINGLE_ERROR, e.getMessage(), (Object) null));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public _j(PtgAdNative.SplashAdListener splashAdListener, _mq _mqVar, AdSlot adSlot) {
        super(splashAdListener);
        this._b = _mqVar;
        this._c = adSlot;
    }

    @Override // com.kc.aw._mq, com.kc.aw.lib.interf.Error
    public final void onError(AdError adError) {
        _g1._a(adError, this._c);
        super.onError(adError);
    }

    @Override // com.kc.aw._mq, com.kc.aw.lib.provider.PtgAdNative.SplashAdListener
    public final void onSplashAdLoad(PtgSplashAd ptgSplashAd) {
        new Handler(Looper.getMainLooper()).post(new _a(this, ptgSplashAd));
    }
}
