package com.kc.aw;

import android.os.Looper;
import com.kc.aw.lib.core.model.AdErrorImpl;
import com.kc.aw.lib.model.AdError;
import com.kc.aw.lib.model.AdSlot;
import com.kc.aw.lib.provider.PtgAdNative;
import com.kc.aw.provider.PtgApiProvider;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _jr implements _b3<_q> {
    public final AdSlot _a;
    public final _js _b;

    @Keep
    public final class _a implements Runnable {
        public final AdError _a;
        public final _jr _b;

        public _a(_jr _jrVar, AdError adError) {
            this._b = _jrVar;
            this._a = adError;
        }

        @Override // java.lang.Runnable
        public final void run() {
            PtgAdNative.RewardVideoAdListener rewardVideoAdListener = this._b._b._a;
            if (rewardVideoAdListener != null) {
                AdErrorImpl adErrorImpl = new AdErrorImpl(this._a.getErrorCode(), this._a.getMessage(), (Object) null);
                adErrorImpl._c = PtgApiProvider.providerName;
                rewardVideoAdListener.onError(adErrorImpl);
            }
        }
    }

    public _jr(_js _jsVar, AdSlot adSlot) {
        this._b = _jsVar;
        this._a = adSlot;
    }

    @Override // com.kc.aw._b3
    public final void _a(_q _qVar) {
        com.kc.aw.lib.utils._d._c(new _jq(this, _qVar));
    }

    @Override // com.kc.aw._b3
    public final void onError(AdError adError) {
        _a _aVar = new _a(this, adError);
        _fz _fzVar = _fz._a;
        if (Looper.getMainLooper().equals(Looper.myLooper())) {
            _aVar.run();
        } else {
            _fz._a.post(_aVar);
        }
    }
}
