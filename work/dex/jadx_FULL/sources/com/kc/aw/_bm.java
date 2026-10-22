package com.kc.aw;

import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import com.kc.aw.lib.core.model.AdErrorImpl;
import com.kc.aw.lib.interf.PtgSplashAd;
import com.kc.aw.lib.model.AdError;
import com.kc.aw.lib.provider.PtgAdNative;
import com.kc.aw.lib.utils.Logger;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.SortedSet;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _bm extends _bh implements PtgAdNative.SplashAdListener {
    public ViewGroup _h;
    public ViewGroup _i;
    public PtgAdNative.SplashAdListener _j;
    public volatile Integer _k;
    public volatile boolean _l;
    public volatile PtgSplashAd _m;

    @Keep
    public final class _a implements Runnable {
        public final _bm _a;

        public _a(_bm _bmVar) {
            this._a = _bmVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            StringBuilder sb_a = _jf._a("doOnLoad--");
            sb_a.append(this._a._b());
            Logger.e("TrackingManager:", sb_a.toString());
            try {
                if (this._a._m == null) {
                    PtgAdNative.SplashAdListener splashAdListener = this._a._j;
                    if (splashAdListener != null) {
                        splashAdListener.onError(new AdErrorImpl(10000, "no ad in concurrent", (Object) null));
                        return;
                    }
                    return;
                }
                ViewGroup viewGroup = this._a._h;
                if (viewGroup != null) {
                    viewGroup.removeAllViews();
                    _bm _bmVar = this._a;
                    _bmVar._h.addView(_bmVar._i);
                }
                this._a._m.getInteractionType();
                this._a._m.load();
                _bm _bmVar2 = this._a;
                PtgAdNative.SplashAdListener splashAdListener2 = _bmVar2._j;
                if (splashAdListener2 != null) {
                    splashAdListener2.onSplashAdLoad(_bmVar2._m);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public _bm(SortedSet sortedSet, _cl _clVar, ViewGroup viewGroup, ViewGroup viewGroup2, AtomicInteger atomicInteger, PtgAdNative.SplashAdListener splashAdListener) {
        super(sortedSet, _clVar, atomicInteger);
        this._h = viewGroup;
        this._i = viewGroup2;
        this._j = splashAdListener;
    }

    @Override // com.kc.aw._bh
    public final void _a() {
        new Handler(Looper.getMainLooper()).post(new _a(this));
    }

    @Override // com.kc.aw._bh
    public final void _a(AdErrorImpl adErrorImpl) {
        StringBuilder sb_a = _jf._a("onError--");
        sb_a.append(_b());
        sb_a.append("--onError:");
        sb_a.append(adErrorImpl._a);
        sb_a.append("|message:");
        sb_a.append(adErrorImpl._b);
        Logger.e("TrackingManager:", sb_a.toString());
        PtgAdNative.SplashAdListener splashAdListener = this._j;
        if (splashAdListener != null) {
            splashAdListener.onError(adErrorImpl);
        }
    }

    @Override // com.kc.aw._bh
    public final boolean _f() {
        return this._k != null || this._l;
    }

    @Override // com.kc.aw._bh
    public final boolean _g() {
        return this._m != null;
    }

    @Override // com.kc.aw.lib.interf.Error
    public final void onError(AdError adError) {
        StringBuilder sb_a = _jf._a("onError--");
        sb_a.append(_b());
        sb_a.append("--onError:");
        sb_a.append(adError.getErrorCode());
        sb_a.append("|message:");
        sb_a.append(adError.getMessage());
        Logger.e("TrackingManager:", sb_a.toString());
        this._k = Integer.valueOf(adError.getErrorCode());
        adError.getMessage();
        this._a.add(this);
    }

    @Override // com.kc.aw.lib.provider.PtgAdNative.SplashAdListener
    public final void onSplashAdLoad(PtgSplashAd ptgSplashAd) {
        StringBuilder sb_a = _jf._a("onSplashAdLoad--");
        sb_a.append(_b());
        Logger.e("TrackingManager:", sb_a.toString());
        this._m = ptgSplashAd;
        this._a.add(this);
    }

    @Override // com.kc.aw.lib.provider.PtgAdNative.SplashAdListener
    public final void onTimeout() {
        StringBuilder sb_a = _jf._a("onTimeout--");
        sb_a.append(_b());
        Logger.e("TrackingManager:", sb_a.toString());
        this._l = true;
        this._a.add(this);
    }
}
