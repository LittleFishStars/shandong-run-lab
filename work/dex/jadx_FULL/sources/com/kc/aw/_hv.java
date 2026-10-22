package com.kc.aw;

import android.content.Context;
import com.kc.aw.lib.core.model.AdErrorImpl;
import com.kc.aw.lib.interf.PtgAd;
import com.kc.aw.lib.interf.PtgNativeExpressAd;
import com.kc.aw.lib.model.AdError;
import com.kc.aw.lib.model.AdSlot;
import com.kc.aw.lib.provider.PtgAdNative;
import com.kc.aw.lib.utils.Logger;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _hv implements PtgAdNative {
    public final PtgAdNative _a;
    public final String _b;

    @Keep
    public final class _a implements PtgAdNative.NativeExpressAdListener {
        public final PtgAdNative.NativeExpressAdListener _a;
        public final AdSlot _b;
        public final Context _c;

        public _a(PtgAdNative.NativeExpressAdListener nativeExpressAdListener, AdSlot adSlot, Context context) {
            this._a = nativeExpressAdListener;
            this._b = adSlot;
            this._c = context;
        }

        @Override // com.kc.aw.lib.interf.Error
        public final void onError(AdError adError) {
            this._a.onError(adError);
        }

        @Override // com.kc.aw.lib.provider.PtgAdNative.NativeExpressAdListener
        public final void onNativeExpressAdLoad(PtgNativeExpressAd ptgNativeExpressAd) {
            Collection<PtgAd> collection_c;
            if (ptgNativeExpressAd == null) {
                this._a.onError(new AdErrorImpl(10000, "no ad", (Object) null));
                return;
            }
            this._a.onNativeExpressAdLoad(ptgNativeExpressAd);
            ArrayList<PtgAd> arrayList = new ArrayList();
            if ((ptgNativeExpressAd instanceof _b1) && (collection_c = ((_b1) ptgNativeExpressAd)._c()) != null) {
                for (PtgAd ptgAd : collection_c) {
                    if (ptgAd instanceof PtgNativeExpressAd) {
                        arrayList.add((PtgNativeExpressAd) ptgAd);
                    }
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            String str = this._b.getDispatchPolicyCustomerItem()._c;
            _i1 _i1Var = _i1._c;
            Context context = this._c;
            AdSlot adSlot = this._b;
            synchronized (_i1Var._b) {
                List<_hw> list_a = _i1Var._a(context, str, adSlot);
                long jCurrentTimeMillis = System.currentTimeMillis();
                for (PtgAd ptgAd2 : arrayList) {
                    list_a.add(new _hw(ptgAd2, adSlot, ptgAd2 instanceof _b1 ? (_b1) ptgAd2 : null, adSlot.getDispatchPolicyCustomerItem()._o + jCurrentTimeMillis));
                }
            }
        }
    }

    public _hv(String str, com.kc.aw.lib.provider._b _bVar) {
        this._b = str;
        this._a = _bVar;
    }

    @Override // com.kc.aw.lib.provider.PtgAdNative
    public final String getBiddingToken(AdSlot adSlot, int i) {
        return "";
    }

    @Override // com.kc.aw.lib.provider.PtgAdNative
    public final String getName() {
        return this._a.getName();
    }

    @Override // com.kc.aw.lib.provider.PtgAdNative
    public final void init(Context context) {
        this._a.init(context);
    }

    @Override // com.kc.aw.lib.provider.PtgAdNative
    public final void loadBannerExpressAd(Context context, AdSlot adSlot, PtgAdNative.NativeExpressAdListener nativeExpressAdListener) {
        this._a.loadBannerExpressAd(context, adSlot, nativeExpressAdListener);
    }

    @Override // com.kc.aw.lib.provider.PtgAdNative
    public final void loadDrawExpressAd(Context context, AdSlot adSlot, PtgAdNative.NativeExpressAdListener nativeExpressAdListener) {
        this._a.loadDrawExpressAd(context, adSlot, nativeExpressAdListener);
    }

    @Override // com.kc.aw.lib.provider.PtgAdNative
    public final void loadInteractionExpressAd(Context context, AdSlot adSlot, PtgAdNative.InteractionExpressAdListener interactionExpressAdListener) {
        this._a.loadInteractionExpressAd(context, adSlot, interactionExpressAdListener);
    }

    @Override // com.kc.aw.lib.provider.PtgAdNative
    public final void loadNativeExpressAd(Context context, AdSlot adSlot, PtgAdNative.NativeExpressAdListener nativeExpressAdListener) {
        _hw _hwVarRemove;
        _i1 _i1Var = _i1._c;
        String str = this._b;
        synchronized (_i1Var._b) {
            List<_hw> list_a = _i1Var._a(context, str, adSlot);
            _hwVarRemove = !list_a.isEmpty() ? list_a.remove(0) : null;
        }
        if (_hwVarRemove != null) {
            PtgAd ptgAd = _hwVarRemove._a;
            if (ptgAd instanceof PtgNativeExpressAd) {
                PtgNativeExpressAd ptgNativeExpressAd = (PtgNativeExpressAd) ptgAd;
                boolean z = ptgNativeExpressAd instanceof _b1;
                if (z) {
                    ((_b1) ptgNativeExpressAd)._a();
                }
                nativeExpressAdListener.onNativeExpressAdLoad((PtgNativeExpressAd) _hwVarRemove._a);
                if (z) {
                    ((_b1) ptgNativeExpressAd)._b();
                }
                Logger.i("loadNativeExpressAd from cache");
                return;
            }
        }
        Logger.i("loadNativeExpressAd from network");
        int i = adSlot.getDispatchPolicyCustomerItem()._n;
        if (i > 1) {
            adSlot.setAdCount(i);
        }
        this._a.loadNativeExpressAd(context, adSlot, new _a(nativeExpressAdListener, adSlot, context));
    }

    @Override // com.kc.aw.lib.provider.PtgAdNative
    public final void loadRewardVideoAd(Context context, AdSlot adSlot, PtgAdNative.RewardVideoAdListener rewardVideoAdListener) {
        this._a.loadRewardVideoAd(context, adSlot, rewardVideoAdListener);
    }

    @Override // com.kc.aw.lib.provider.PtgAdNative
    public final void loadSplashAd(Context context, AdSlot adSlot, PtgAdNative.SplashAdListener splashAdListener) {
        this._a.loadSplashAd(context, adSlot, splashAdListener);
    }
}
