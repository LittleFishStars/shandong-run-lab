package com.kc.aw;

import android.os.Handler;
import android.os.Looper;
import com.kc.aw.lib.core.model.AdErrorImpl;
import com.kc.aw.lib.interf.PtgRewardVideoAd;
import com.kc.aw.lib.model.AdError;
import com.kc.aw.lib.provider.PtgAdNative;
import com.kc.aw.lib.utils.Logger;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.SortedSet;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _bl extends _bh implements PtgAdNative.RewardVideoAdListener {
    public PtgRewardVideoAd _h;
    public PtgAdNative.RewardVideoAdListener _i;
    public Integer _j;

    @Keep
    public final class _a implements Runnable {
        public final _bl _a;

        public _a(_bl _blVar) {
            this._a = _blVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            StringBuilder sb_a = _jf._a("doOnLoad--");
            sb_a.append(this._a._b());
            Logger.e("TrackingManager:", sb_a.toString());
            _bl _blVar = this._a;
            PtgRewardVideoAd ptgRewardVideoAd = _blVar._h;
            PtgAdNative.RewardVideoAdListener rewardVideoAdListener = _blVar._i;
            if (ptgRewardVideoAd != null) {
                rewardVideoAdListener.onRewardVideoAdLoad(ptgRewardVideoAd);
            } else {
                rewardVideoAdListener.onError(new AdErrorImpl(10000, "no ad in concurrent", (Object) null));
            }
        }
    }

    public _bl(SortedSet sortedSet, _cl _clVar, AtomicInteger atomicInteger, PtgAdNative.RewardVideoAdListener rewardVideoAdListener) {
        super(sortedSet, _clVar, atomicInteger);
        this._i = rewardVideoAdListener;
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
        this._i.onError(adErrorImpl);
    }

    @Override // com.kc.aw._bh
    public final boolean _f() {
        return this._j != null;
    }

    @Override // com.kc.aw._bh
    public final boolean _g() {
        return this._h != null;
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
        this._j = Integer.valueOf(adError.getErrorCode());
        adError.getMessage();
        this._a.add(this);
    }

    @Override // com.kc.aw.lib.provider.PtgAdNative.RewardVideoAdListener
    public final void onRewardVideoAdLoad(PtgRewardVideoAd ptgRewardVideoAd) {
        StringBuilder sb_a = _jf._a("onRewardVideoAdLoad--");
        sb_a.append(_b());
        Logger.e("TrackingManager:", sb_a.toString());
        this._h = ptgRewardVideoAd;
        this._a.add(this);
    }
}
