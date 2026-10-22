package com.kc.aw;

import android.content.Context;
import com.kc.aw.lib.constants.PtgErrorCode;
import com.kc.aw.lib.core.model.AdErrorImpl;
import com.kc.aw.lib.interf.PtgInteractionAd;
import com.kc.aw.lib.model.AdError;
import com.kc.aw.lib.model.AdSlot;
import com.kc.aw.lib.provider.PtgAdNative;
import com.kc.aw.lib.utils.Logger;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _mb extends _m8 implements PtgAdNative.InteractionExpressAdListener {
    public _j3 _a;
    public PtgAdNative.InteractionExpressAdListener _b;
    public WeakReference<Context> _c;
    public PtgAdNative _d;
    public PtgInteractionAd _e;
    public AdSlot _f;
    public AtomicBoolean _g = new AtomicBoolean();
    public _cl _h;

    public _mb(_j3 _j3Var, _cl _clVar, PtgAdNative ptgAdNative, Context context, AdSlot adSlot, PtgAdNative.InteractionExpressAdListener interactionExpressAdListener) {
        this._a = _j3Var;
        this._d = ptgAdNative;
        this._h = _clVar;
        this._b = interactionExpressAdListener;
        this._c = new WeakReference<>(context);
        this._f = adSlot;
    }

    @Override // com.kc.aw._m8
    public final void _a() {
        PtgInteractionAd ptgInteractionAd;
        PtgAdNative.InteractionExpressAdListener interactionExpressAdListener = this._b;
        if (interactionExpressAdListener == null || (ptgInteractionAd = this._e) == null) {
            return;
        }
        interactionExpressAdListener.onInteractionAdLoad(ptgInteractionAd);
    }

    @Override // com.kc.aw._m8
    public final void _a(AdErrorImpl adErrorImpl) {
        PtgAdNative.InteractionExpressAdListener interactionExpressAdListener = this._b;
        if (interactionExpressAdListener != null) {
            interactionExpressAdListener.onError(adErrorImpl);
        }
    }

    @Override // com.kc.aw._m8
    public final boolean _b() {
        AdSlot adSlot;
        Context context = this._c.get();
        if (context == null || (adSlot = this._f) == null) {
            Logger.d("err interaction ad serial request, ");
            onError(new AdErrorImpl(PtgErrorCode.SDK_REQUEST_INTERRUPT_BECAUSE_PARAMS_MISS, "params miss, request is interrupted", (Object) null));
            return false;
        }
        this._d.loadInteractionExpressAd(context, adSlot, this);
        Logger.d("do interaction ad serial request, ");
        return true;
    }

    @Override // com.kc.aw._m8
    public final String _c() {
        return this._h._c;
    }

    @Override // com.kc.aw._m8
    public final long _d() {
        return this._h._h;
    }

    @Override // com.kc.aw._m8
    public final _nr _e() {
        AdSlot adSlot = this._f;
        if (adSlot == null) {
            return null;
        }
        return adSlot.getTrackingData();
    }

    @Override // com.kc.aw._m8
    public final int _f() {
        return this._h._e;
    }

    @Override // com.kc.aw._m8
    public final boolean _g() {
        return this._e != null;
    }

    @Override // com.kc.aw.lib.interf.Error
    public final void onError(AdError adError) {
        if (!this._g.compareAndSet(false, true)) {
            Logger.d("err interaction ad serial request, ");
            return;
        }
        _j3 _j3Var = this._a;
        if (_j3Var != null) {
            _j3Var._a(this, adError);
        }
    }

    @Override // com.kc.aw.lib.provider.PtgAdNative.InteractionExpressAdListener
    public final void onInteractionAdLoad(PtgInteractionAd ptgInteractionAd) {
        if (this._g.compareAndSet(false, true)) {
            this._e = ptgInteractionAd;
            if (ptgInteractionAd == null) {
                onError(new AdErrorImpl(10000, "no ad", (Object) null));
            } else {
                this._a._b(this);
            }
        }
    }
}
