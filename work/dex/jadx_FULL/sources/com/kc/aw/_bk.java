package com.kc.aw;

import com.kc.aw.lib.core.model.AdErrorImpl;
import com.kc.aw.lib.interf.PtgNativeExpressAd;
import com.kc.aw.lib.model.AdError;
import com.kc.aw.lib.provider.PtgAdNative;
import com.kc.aw.lib.utils.Logger;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.SortedSet;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _bk extends _bh implements PtgAdNative.NativeExpressAdListener {
    public PtgAdNative.NativeExpressAdListener _h;
    public volatile Integer _i;
    public volatile PtgNativeExpressAd _j;

    public _bk(SortedSet sortedSet, _cl _clVar, AtomicInteger atomicInteger, PtgAdNative.NativeExpressAdListener nativeExpressAdListener) {
        super(sortedSet, _clVar, atomicInteger);
        this._h = nativeExpressAdListener;
    }

    @Override // com.kc.aw._bh
    public final void _a() {
        StringBuilder sb_a = _jf._a("doOnLoad--");
        sb_a.append(_b());
        Logger.e("TrackingManager:", sb_a.toString());
        if (this._j != null) {
            this._h.onNativeExpressAdLoad(this._j);
        } else {
            this._h.onError(new AdErrorImpl(10000, "no ad in concurrent", (Object) null));
        }
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
        this._h.onError(adErrorImpl);
    }

    @Override // com.kc.aw._bh
    public final boolean _f() {
        return this._i != null;
    }

    @Override // com.kc.aw._bh
    public final boolean _g() {
        return this._j != null;
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
        this._i = Integer.valueOf(adError.getErrorCode());
        adError.getMessage();
        this._a.add(this);
    }

    @Override // com.kc.aw.lib.provider.PtgAdNative.NativeExpressAdListener
    public final void onNativeExpressAdLoad(PtgNativeExpressAd ptgNativeExpressAd) {
        StringBuilder sb_a = _jf._a("onNativeExpressAdLoad--");
        sb_a.append(_b());
        Logger.e("TrackingManager:", sb_a.toString());
        this._j = ptgNativeExpressAd;
        this._a.add(this);
    }
}
