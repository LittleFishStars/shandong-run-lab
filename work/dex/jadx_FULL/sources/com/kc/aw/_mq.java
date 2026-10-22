package com.kc.aw;

import com.kc.aw.lib.interf.PtgSplashAd;
import com.kc.aw.lib.model.AdError;
import com.kc.aw.lib.provider.PtgAdNative;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class _mq implements PtgAdNative.SplashAdListener {
    public final PtgAdNative.SplashAdListener _a;

    @Keep
    public final class _a implements Runnable {
        public final AdError _a;
        public final _mq _b;

        public _a(_mq _mqVar, AdError adError) {
            this._b = _mqVar;
            this._a = adError;
        }

        @Override // java.lang.Runnable
        public final void run() {
            PtgAdNative.SplashAdListener splashAdListener = this._b._a;
            if (splashAdListener != null) {
                splashAdListener.onError(this._a);
            }
        }
    }

    @Keep
    public final class _b implements Runnable {
        public final _mq _a;

        public _b(_mq _mqVar) {
            this._a = _mqVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            PtgAdNative.SplashAdListener splashAdListener = this._a._a;
            if (splashAdListener != null) {
                splashAdListener.onTimeout();
            }
        }
    }

    @Keep
    public final class _c implements Runnable {
        public final PtgSplashAd _a;
        public final _mq _b;

        public _c(_mq _mqVar, PtgSplashAd ptgSplashAd) {
            this._b = _mqVar;
            this._a = ptgSplashAd;
        }

        @Override // java.lang.Runnable
        public final void run() {
            PtgSplashAd ptgSplashAd;
            PtgAdNative.SplashAdListener splashAdListener = this._b._a;
            if (splashAdListener == null || (ptgSplashAd = this._a) == null) {
                return;
            }
            splashAdListener.onSplashAdLoad(ptgSplashAd);
        }
    }

    public _mq(PtgAdNative.SplashAdListener splashAdListener) {
        this._a = splashAdListener;
    }

    @Override // com.kc.aw.lib.interf.Error
    public void onError(AdError adError) {
        if (this._a != null) {
            com.kc.aw.lib.utils._d._c(new _a(this, adError));
        }
    }

    @Override // com.kc.aw.lib.provider.PtgAdNative.SplashAdListener
    public void onSplashAdLoad(PtgSplashAd ptgSplashAd) {
        if (this._a != null) {
            com.kc.aw.lib.utils._d._c(new _c(this, ptgSplashAd));
        }
    }

    @Override // com.kc.aw.lib.provider.PtgAdNative.SplashAdListener
    public final void onTimeout() {
        if (this._a != null) {
            com.kc.aw.lib.utils._d._c(new _b(this));
        }
    }
}
