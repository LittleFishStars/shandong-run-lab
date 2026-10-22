package com.kc.aw;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import com.kc.aw.lib.constants.PtgErrorCode;
import com.kc.aw.lib.core.model.AdErrorImpl;
import com.kc.aw.lib.interf.PtgSplashAd;
import com.kc.aw.lib.model.AdError;
import com.kc.aw.lib.model.AdSlot;
import com.kc.aw.lib.provider.PtgAdNative;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _me extends _m8 implements PtgAdNative.SplashAdListener {
    public _j3 _a;
    public PtgAdNative.SplashAdListener _b;
    public WeakReference<Context> _c;
    public ViewGroup _d;
    public ViewGroup _e;
    public PtgAdNative _f;
    public PtgSplashAd _g;
    public AdSlot _h;
    public AtomicBoolean _i = new AtomicBoolean();
    public _cl _j;

    @Keep
    public final class _a implements Runnable {
        public final _me _a;

        public _a(_me _meVar) {
            this._a = _meVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            PtgSplashAd ptgSplashAd;
            try {
                this._a._d.removeAllViews();
                _me _meVar = this._a;
                _meVar._d.addView(_meVar._e);
                this._a._g.getInteractionType();
                this._a._g.load();
                _me _meVar2 = this._a;
                PtgAdNative.SplashAdListener splashAdListener = _meVar2._b;
                if (splashAdListener == null || (ptgSplashAd = _meVar2._g) == null) {
                    return;
                }
                splashAdListener.onSplashAdLoad(ptgSplashAd);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public _me(_j3 _j3Var, _cl _clVar, PtgAdNative ptgAdNative, Context context, AdSlot adSlot, ViewGroup viewGroup, ViewGroup viewGroup2, PtgAdNative.SplashAdListener splashAdListener) {
        this._a = _j3Var;
        this._d = viewGroup;
        this._e = viewGroup2;
        this._f = ptgAdNative;
        this._b = splashAdListener;
        this._c = new WeakReference<>(context);
        this._h = adSlot;
        this._j = _clVar;
    }

    @Override // com.kc.aw._m8
    public final void _a() {
        new Handler(Looper.getMainLooper()).post(new _a(this));
    }

    @Override // com.kc.aw._m8
    public final void _a(AdErrorImpl adErrorImpl) {
        PtgAdNative.SplashAdListener splashAdListener = this._b;
        if (splashAdListener != null) {
            splashAdListener.onError(adErrorImpl);
        }
    }

    @Override // com.kc.aw._m8
    public final boolean _b() {
        AdSlot adSlot;
        Context context = this._c.get();
        if (context == null || (adSlot = this._h) == null) {
            onError(new AdErrorImpl(PtgErrorCode.SDK_REQUEST_INTERRUPT_BECAUSE_PARAMS_MISS, "params miss, request is interrupted", (Object) null));
            return false;
        }
        this._f.loadSplashAd(context, adSlot, this);
        return true;
    }

    @Override // com.kc.aw._m8
    public final String _c() {
        return this._j._c;
    }

    @Override // com.kc.aw._m8
    public final long _d() {
        return this._j._h;
    }

    @Override // com.kc.aw._m8
    public final _nr _e() {
        AdSlot adSlot = this._h;
        if (adSlot == null) {
            return null;
        }
        return adSlot.getTrackingData();
    }

    @Override // com.kc.aw._m8
    public final int _f() {
        return this._j._e;
    }

    @Override // com.kc.aw._m8
    public final boolean _g() {
        return this._g != null;
    }

    @Override // com.kc.aw.lib.interf.Error
    public final void onError(AdError adError) {
        _j3 _j3Var;
        if (!this._i.compareAndSet(false, true) || (_j3Var = this._a) == null) {
            return;
        }
        _j3Var._a(this, adError);
    }

    @Override // com.kc.aw.lib.provider.PtgAdNative.SplashAdListener
    public final void onSplashAdLoad(PtgSplashAd ptgSplashAd) {
        if (this._i.compareAndSet(false, true)) {
            this._g = ptgSplashAd;
            if (ptgSplashAd == null) {
                onError(new AdErrorImpl(10000, "no ad", (Object) null));
            } else {
                this._a._b(this);
            }
        }
    }

    @Override // com.kc.aw.lib.provider.PtgAdNative.SplashAdListener
    public final void onTimeout() {
        PtgAdNative.SplashAdListener splashAdListener = this._b;
        if (splashAdListener != null) {
            splashAdListener.onTimeout();
        }
    }
}
