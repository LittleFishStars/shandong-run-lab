package com.kc.aw;

import com.kc.aw.lib.interf.PtgNativeExpressAd;
import com.kc.aw.lib.model.AdError;
import com.kc.aw.lib.provider.PtgAdNative;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class _gj implements PtgAdNative.NativeExpressAdListener {
    public PtgAdNative.NativeExpressAdListener _a;

    @Keep
    public final class _a implements Runnable {
        public final AdError _a;
        public final _gj _b;

        public _a(_gj _gjVar, AdError adError) {
            this._b = _gjVar;
            this._a = adError;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this._b._a.onError(this._a);
        }
    }

    @Keep
    public final class _b implements Runnable {
        public final PtgNativeExpressAd _a;
        public final _gj _b;

        public _b(_gj _gjVar, PtgNativeExpressAd ptgNativeExpressAd) {
            this._b = _gjVar;
            this._a = ptgNativeExpressAd;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this._b._a.onNativeExpressAdLoad(this._a);
        }
    }

    public _gj(PtgAdNative.NativeExpressAdListener nativeExpressAdListener) {
        this._a = nativeExpressAdListener;
    }

    @Override // com.kc.aw.lib.interf.Error
    public void onError(AdError adError) {
        if (this._a != null) {
            com.kc.aw.lib.utils._d._c(new _a(this, adError));
        }
    }

    @Override // com.kc.aw.lib.provider.PtgAdNative.NativeExpressAdListener
    public final void onNativeExpressAdLoad(PtgNativeExpressAd ptgNativeExpressAd) {
        if (this._a != null) {
            com.kc.aw.lib.utils._d._c(new _b(this, ptgNativeExpressAd));
        }
    }
}
