package com.kc.aw;

import android.content.Context;
import com.kc.aw.lib.PtgAdSdk;
import com.kc.aw.lib.constants.PtgErrorCode;
import com.kc.aw.lib.core.model.AdErrorImpl;
import com.kc.aw.lib.interf.Error;
import com.kc.aw.lib.interf.PtgInteractionAd;
import com.kc.aw.lib.interf.PtgNativeExpressAd;
import com.kc.aw.lib.interf.PtgRewardVideoAd;
import com.kc.aw.lib.interf.PtgSplashAd;
import com.kc.aw.lib.model.AdError;
import com.kc.aw.lib.model.AdSlot;
import com.kc.aw.lib.provider.PtgAdNative;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _k6 implements PtgAdNative {
    public PtgAdNative _a;

    @Keep
    public final class _a implements PtgAdNative.SplashAdListener {
        public final _nr _a;
        public final _cl _b;
        public final PtgAdNative.SplashAdListener _c;
        public final AdSlot _d;
        public final _k6 _e;

        /* JADX INFO: renamed from: com.kc.aw._k6$_a$_a, reason: collision with other inner class name */
        @Keep
        public final class C0951_a implements PtgSplashAd.AdInteractionListener {
            @Override // com.kc.aw.lib.interf.PtgSplashAd.AdInteractionListener
            public final void onAdClicked() {
            }

            @Override // com.kc.aw.lib.interf.PtgSplashAd.AdInteractionListener
            public final void onAdShow() {
            }

            @Override // com.kc.aw.lib.interf.PtgSplashAd.AdInteractionListener
            public final void onAdSkip() {
            }

            @Override // com.kc.aw.lib.interf.PtgSplashAd.AdInteractionListener
            public final void onAdTimeOver() {
            }

            @Override // com.kc.aw.lib.interf.PtgSplashAd.AdInteractionListener
            public final void onRenderError(AdError adError) {
            }

            @Override // com.kc.aw.lib.interf.PtgSplashAd.AdInteractionListener
            public final void onRenderSuccess() {
            }
        }

        public _a(_k6 _k6Var, _nr _nrVar, _cl _clVar, PtgAdNative.SplashAdListener splashAdListener, AdSlot adSlot) {
            this._e = _k6Var;
            this._a = _nrVar;
            this._b = _clVar;
            this._c = splashAdListener;
            this._d = adSlot;
        }

        @Override // com.kc.aw.lib.interf.Error
        public final void onError(AdError adError) {
            this._a._a(adError);
            this._a._t._f(0);
            if (adError.getErrorCode() != 10000) {
                _nt._a()._a(this._b._f(), "inAppErr", this._a, null);
            }
            this._c.onError(adError);
        }

        @Override // com.kc.aw.lib.provider.PtgAdNative.SplashAdListener
        public final void onSplashAdLoad(PtgSplashAd ptgSplashAd) {
            _k6._a(this._e, ptgSplashAd.getAdFilterAdapter(), this._a);
            _oi._e._a(this._d, ptgSplashAd);
            this._a._t._b(this._b._h);
            this._a._t._a(this._b._i);
            this._a._d();
            boolean z_a = _m._a(ptgSplashAd.getAdFilterAdapter(), this._a);
            this._a._t._h(!z_a ? 1 : 0);
            _nt._a()._a(this._b._b(), "inAppBidSuc", this._a, null);
            if (!z_a) {
                if (ptgSplashAd.getAdFilterAdapter() != null && ((_mj) ptgSplashAd.getAdFilterAdapter())._a() != null) {
                    _nt._a()._a(this._b._I, "inAppFilter", this._a, ((_mj) ptgSplashAd.getAdFilterAdapter())._a()._a().toString());
                }
                onError(new AdErrorImpl(10001, "the ad prohibits display", (Object) null));
                return;
            }
            if (!this._d.isConcurrent()) {
                _nt._a()._a(this._b._a(), "bidSel", this._a, null);
            }
            _j5 _j5Var = new _j5(ptgSplashAd, this._d, this._a);
            _j5Var.setSplashInteractionListener(new C0951_a());
            this._c.onSplashAdLoad(_j5Var);
        }

        @Override // com.kc.aw.lib.provider.PtgAdNative.SplashAdListener
        public final void onTimeout() {
            this._a._a(new AdErrorImpl(PtgErrorCode.SDK_TIMEOUT, "advert time out", (Object) null));
            this._a._t._f(0);
            _nt._a()._a(this._b._f(), "inAppErr", this._a, null);
            this._c.onTimeout();
        }
    }

    @Keep
    public final class _b implements PtgAdNative.NativeExpressAdListener {
        public final _nr _a;
        public final _cl _b;
        public final PtgAdNative.NativeExpressAdListener _c;
        public final AdSlot _d;
        public final _k6 _e;

        public _b(_k6 _k6Var, _nr _nrVar, _cl _clVar, PtgAdNative.NativeExpressAdListener nativeExpressAdListener, AdSlot adSlot) {
            this._e = _k6Var;
            this._a = _nrVar;
            this._b = _clVar;
            this._c = nativeExpressAdListener;
            this._d = adSlot;
        }

        @Override // com.kc.aw.lib.interf.Error
        public final void onError(AdError adError) {
            this._a._a(adError);
            this._a._t._f(0);
            if (adError.getErrorCode() != 10000) {
                _nt._a()._a(this._b._f(), "inAppErr", this._a, null);
            }
            this._c.onError(adError);
        }

        @Override // com.kc.aw.lib.provider.PtgAdNative.NativeExpressAdListener
        public final void onNativeExpressAdLoad(PtgNativeExpressAd ptgNativeExpressAd) {
            _k6._a(this._e, ptgNativeExpressAd.getAdFilterAdapter(), this._a);
            this._a._t._b(this._b._h);
            this._a._t._a(this._b._i);
            this._a._d();
            boolean z_a = _m._a(ptgNativeExpressAd.getAdFilterAdapter(), this._a);
            this._a._t._h(!z_a ? 1 : 0);
            _nt._a()._a(this._b._b(), "inAppBidSuc", this._a, null);
            if (!z_a) {
                if (ptgNativeExpressAd.getAdFilterAdapter() != null && ((_mj) ptgNativeExpressAd.getAdFilterAdapter())._a() != null) {
                    _nt._a()._a(this._b._I, "inAppFilter", this._a, ((_mj) ptgNativeExpressAd.getAdFilterAdapter())._a()._a().toString());
                }
                onError(new AdErrorImpl(10001, "the ad prohibits display", (Object) null));
                return;
            }
            if (!this._d.isConcurrent()) {
                _nt._a()._a(this._b._a(), "bidSel", this._a, null);
            }
            _ir _irVar = new _ir(ptgNativeExpressAd, this._d, this._a);
            _irVar.setExpressInteractionListener(_p._a);
            this._c.onNativeExpressAdLoad(_irVar);
        }
    }

    @Keep
    public final class _c implements PtgAdNative.RewardVideoAdListener {
        public final _nr _a;
        public final _cl _b;
        public final PtgAdNative.RewardVideoAdListener _c;
        public final AdSlot _d;
        public final _k6 _e;

        public _c(_k6 _k6Var, _nr _nrVar, _cl _clVar, PtgAdNative.RewardVideoAdListener rewardVideoAdListener, AdSlot adSlot) {
            this._e = _k6Var;
            this._a = _nrVar;
            this._b = _clVar;
            this._c = rewardVideoAdListener;
            this._d = adSlot;
        }

        @Override // com.kc.aw.lib.interf.Error
        public final void onError(AdError adError) {
            this._a._a(adError);
            this._a._t._f(0);
            if (adError.getErrorCode() != 10000) {
                _nt._a()._a(this._b._f(), "inAppErr", this._a, null);
            }
            this._c.onError(adError);
        }

        @Override // com.kc.aw.lib.provider.PtgAdNative.RewardVideoAdListener
        public final void onRewardVideoAdLoad(PtgRewardVideoAd ptgRewardVideoAd) {
            _k6._a(this._e, ptgRewardVideoAd.getAdFilterAdapter(), this._a);
            _oi._e._a(this._d, ptgRewardVideoAd);
            this._a._t._b(this._b._h);
            this._a._t._a(this._b._i);
            this._a._d();
            boolean z_a = _m._a(ptgRewardVideoAd.getAdFilterAdapter(), this._a);
            this._a._t._h(!z_a ? 1 : 0);
            _nt._a()._a(this._b._b(), "inAppBidSuc", this._a, null);
            if (z_a) {
                if (!this._d.isConcurrent()) {
                    _nt._a()._a(this._b._a(), "bidSel", this._a, null);
                }
                this._c.onRewardVideoAdLoad(new _j4(ptgRewardVideoAd, this._d, this._a));
                return;
            }
            if (ptgRewardVideoAd.getAdFilterAdapter() != null && ((_mj) ptgRewardVideoAd.getAdFilterAdapter())._a() != null) {
                _nt._a()._a(this._b._I, "inAppFilter", this._a, ((_mj) ptgRewardVideoAd.getAdFilterAdapter())._a()._a().toString());
            }
            onError(new AdErrorImpl(10001, "the ad prohibits display", (Object) null));
        }
    }

    @Keep
    public final class _d implements PtgAdNative.NativeExpressAdListener {
        public final _nr _a;
        public final _cl _b;
        public final PtgAdNative.NativeExpressAdListener _c;
        public final AdSlot _d;
        public final _k6 _e;

        public _d(_k6 _k6Var, _nr _nrVar, _cl _clVar, PtgAdNative.NativeExpressAdListener nativeExpressAdListener, AdSlot adSlot) {
            this._e = _k6Var;
            this._a = _nrVar;
            this._b = _clVar;
            this._c = nativeExpressAdListener;
            this._d = adSlot;
        }

        @Override // com.kc.aw.lib.interf.Error
        public final void onError(AdError adError) {
            this._a._a(adError);
            this._a._t._f(0);
            if (adError.getErrorCode() != 10000) {
                _nt._a()._a(this._b._f(), "inAppErr", this._a, null);
            }
            this._c.onError(adError);
        }

        @Override // com.kc.aw.lib.provider.PtgAdNative.NativeExpressAdListener
        public final void onNativeExpressAdLoad(PtgNativeExpressAd ptgNativeExpressAd) {
            _k6._a(this._e, ptgNativeExpressAd.getAdFilterAdapter(), this._a);
            _oi._e._a(this._d, ptgNativeExpressAd);
            this._a._t._b(this._b._h);
            this._a._t._a(this._b._i);
            this._a._d();
            boolean z_a = _m._a(ptgNativeExpressAd.getAdFilterAdapter(), this._a);
            this._a._t._h(!z_a ? 1 : 0);
            _nt._a()._a(this._b._b(), "inAppBidSuc", this._a, null);
            if (!z_a) {
                if (ptgNativeExpressAd.getAdFilterAdapter() != null && ((_mj) ptgNativeExpressAd.getAdFilterAdapter())._a() != null) {
                    _nt._a()._a(this._b._I, "inAppFilter", this._a, ((_mj) ptgNativeExpressAd.getAdFilterAdapter())._a()._a().toString());
                }
                onError(new AdErrorImpl(10001, "the ad prohibits display", (Object) null));
                return;
            }
            if (!this._d.isConcurrent()) {
                _nt._a()._a(this._b._a(), "bidSel", this._a, null);
            }
            _ir _irVar = new _ir(ptgNativeExpressAd, this._d, this._a);
            _irVar.setExpressInteractionListener(_p._a);
            this._c.onNativeExpressAdLoad(_irVar);
        }
    }

    @Keep
    public final class _e implements PtgAdNative.InteractionExpressAdListener {
        public final _nr _a;
        public final _cl _b;
        public final PtgAdNative.InteractionExpressAdListener _c;
        public final AdSlot _d;
        public final _k6 _e;

        public _e(_k6 _k6Var, _nr _nrVar, _cl _clVar, PtgAdNative.InteractionExpressAdListener interactionExpressAdListener, AdSlot adSlot) {
            this._e = _k6Var;
            this._a = _nrVar;
            this._b = _clVar;
            this._c = interactionExpressAdListener;
            this._d = adSlot;
        }

        @Override // com.kc.aw.lib.interf.Error
        public final void onError(AdError adError) {
            this._a._a(adError);
            this._a._t._f(0);
            if (adError.getErrorCode() != 10000) {
                _nt._a()._a(this._b._f(), "inAppErr", this._a, null);
            }
            this._c.onError(adError);
        }

        @Override // com.kc.aw.lib.provider.PtgAdNative.InteractionExpressAdListener
        public final void onInteractionAdLoad(PtgInteractionAd ptgInteractionAd) {
            _k6._a(this._e, ptgInteractionAd.getAdFilterAdapter(), this._a);
            _oi._e._a(this._d, ptgInteractionAd);
            this._a._t._b(this._b._h);
            this._a._t._a(this._b._i);
            this._a._d();
            boolean z_a = _m._a(ptgInteractionAd.getAdFilterAdapter(), this._a);
            this._a._t._h(!z_a ? 1 : 0);
            _nt._a()._a(this._b._b(), "inAppBidSuc", this._a, null);
            if (!z_a) {
                if (ptgInteractionAd.getAdFilterAdapter() != null && ((_mj) ptgInteractionAd.getAdFilterAdapter())._a() != null) {
                    _nt._a()._a(this._b._I, "inAppFilter", this._a, ((_mj) ptgInteractionAd.getAdFilterAdapter())._a()._a().toString());
                }
                onError(new AdErrorImpl(10001, "the ad prohibits display", (Object) null));
                return;
            }
            if (!this._d.isConcurrent()) {
                _nt._a()._a(this._b._a(), "bidSel", this._a, null);
            }
            _iq _iqVar = new _iq(ptgInteractionAd, this._d, this._a);
            _iqVar.setAdInteractionListener(_p._b);
            this._c.onInteractionAdLoad(_iqVar);
        }
    }

    @Keep
    public final class _f implements PtgAdNative.NativeExpressAdListener {
        public final _nr _a;
        public final _cl _b;
        public final PtgAdNative.NativeExpressAdListener _c;
        public final AdSlot _d;
        public final _k6 _e;

        public _f(_k6 _k6Var, _nr _nrVar, _cl _clVar, PtgAdNative.NativeExpressAdListener nativeExpressAdListener, AdSlot adSlot) {
            this._e = _k6Var;
            this._a = _nrVar;
            this._b = _clVar;
            this._c = nativeExpressAdListener;
            this._d = adSlot;
        }

        @Override // com.kc.aw.lib.interf.Error
        public final void onError(AdError adError) {
            this._a._a(adError);
            this._a._t._f(0);
            if (adError.getErrorCode() != 10000) {
                _nt._a()._a(this._b._f(), "inAppErr", this._a, null);
            }
            this._c.onError(adError);
        }

        @Override // com.kc.aw.lib.provider.PtgAdNative.NativeExpressAdListener
        public final void onNativeExpressAdLoad(PtgNativeExpressAd ptgNativeExpressAd) {
            _k6._a(this._e, ptgNativeExpressAd.getAdFilterAdapter(), this._a);
            _oi._e._a(this._d, ptgNativeExpressAd);
            this._a._t._b(this._b._h);
            this._a._t._a(this._b._i);
            this._a._d();
            boolean z_a = _m._a(ptgNativeExpressAd.getAdFilterAdapter(), this._a);
            this._a._t._h(!z_a ? 1 : 0);
            _nt._a()._a(this._b._b(), "inAppBidSuc", this._a, null);
            if (!z_a) {
                if (ptgNativeExpressAd.getAdFilterAdapter() != null && ((_mj) ptgNativeExpressAd.getAdFilterAdapter())._a() != null) {
                    _nt._a()._a(this._b._I, "inAppFilter", this._a, ((_mj) ptgNativeExpressAd.getAdFilterAdapter())._a()._a().toString());
                }
                onError(new AdErrorImpl(10001, "the ad prohibits display", (Object) null));
                return;
            }
            if (!this._d.isConcurrent()) {
                _nt._a()._a(this._b._a(), "bidSel", this._a, null);
            }
            _ir _irVar = new _ir(ptgNativeExpressAd, this._d, this._a);
            _irVar.setExpressInteractionListener(_p._a);
            this._c.onNativeExpressAdLoad(_irVar);
        }
    }

    public _k6(com.kc.aw.lib.provider._b _bVar) {
        this._a = _bVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void _a(_k6 _k6Var, _l _lVar, _nr _nrVar) {
        _k6Var.getClass();
        if (_lVar != null) {
            T t = ((_ic) _lVar)._a;
            Map<String, String> map = t != 0 ? ((_h) t)._r : null;
            synchronized (_nrVar._s) {
                if (map != null) {
                    _nrVar._s.clear();
                    _nrVar._s.putAll(map);
                }
            }
        }
    }

    public static void _a(Object obj, AdSlot adSlot, _nr _nrVar) {
        if (obj instanceof _bh) {
            _bh _bhVar = (_bh) obj;
            _bhVar._b = adSlot;
            _bhVar._d = _nrVar;
        }
    }

    @Override // com.kc.aw.lib.provider.PtgAdNative
    public final String getBiddingToken(AdSlot adSlot, int i) {
        return "";
    }

    @Override // com.kc.aw.lib.provider.PtgAdNative
    public final String getName() {
        PtgAdNative ptgAdNative = this._a;
        return ptgAdNative == null ? "null" : ptgAdNative.getName();
    }

    @Override // com.kc.aw.lib.provider.PtgAdNative
    public final void init(Context context) {
        PtgAdNative ptgAdNative = this._a;
        if (ptgAdNative == null) {
            return;
        }
        ptgAdNative.init(context);
    }

    @Override // com.kc.aw.lib.provider.PtgAdNative
    public final void loadBannerExpressAd(Context context, AdSlot adSlot, PtgAdNative.NativeExpressAdListener nativeExpressAdListener) {
        AdErrorImpl adErrorImpl;
        if (this._a == null) {
            adErrorImpl = new AdErrorImpl(PtgErrorCode.SDK_NULL_PROVIDER, "可用SDK为空，请确认分发策略配置，以及是否引用该模块", (Object) null);
        } else {
            com.kc.aw._c._a()._b();
            _cl dispatchPolicyCustomerItem = adSlot.getDispatchPolicyCustomerItem();
            if (dispatchPolicyCustomerItem != null) {
                adSlot.setCodeID(dispatchPolicyCustomerItem._Q);
                adSlot.setStype(5);
                _nr _nrVar = new _nr(dispatchPolicyCustomerItem._c, dispatchPolicyCustomerItem._Q, adSlot);
                _d _dVar = new _d(this, _nrVar, dispatchPolicyCustomerItem, nativeExpressAdListener, adSlot);
                try {
                    _nrVar._o = dispatchPolicyCustomerItem._b;
                    _nrVar._a(adSlot.getCategoryType());
                    _nrVar._t._i(PtgAdSdk.getConfig()._a);
                    _nrVar._t._n(adSlot.getUserID());
                    _nrVar._t._m(adSlot.getPtgSlotID());
                    _nrVar._t._e(dispatchPolicyCustomerItem._Q);
                    _nrVar._t._f(dispatchPolicyCustomerItem._c);
                    _nrVar._t._c(dispatchPolicyCustomerItem._T);
                    _nrVar._t._d(dispatchPolicyCustomerItem._e);
                    _a(nativeExpressAdListener, adSlot, _nrVar);
                    _nt._a()._a(dispatchPolicyCustomerItem._c(), "inAppBid", _nrVar, null);
                    adSlot.setTrackingData(_nrVar);
                    this._a.loadBannerExpressAd(context, adSlot, _dVar);
                    return;
                } catch (Exception e) {
                    _dVar.onError(new AdErrorImpl(-1, e.getMessage(), (Object) null));
                    return;
                }
            }
            adErrorImpl = new AdErrorImpl(-1, "内部错误，无分发策略", (Object) null);
        }
        nativeExpressAdListener.onError(adErrorImpl);
    }

    @Override // com.kc.aw.lib.provider.PtgAdNative
    public final void loadDrawExpressAd(Context context, AdSlot adSlot, PtgAdNative.NativeExpressAdListener nativeExpressAdListener) {
        AdErrorImpl adErrorImpl;
        if (this._a == null) {
            adErrorImpl = new AdErrorImpl(PtgErrorCode.SDK_NULL_PROVIDER, "可用SDK为空，请确认分发策略配置，以及是否引用该模块", (Object) null);
        } else {
            com.kc.aw._c._a()._b();
            _cl dispatchPolicyCustomerItem = adSlot.getDispatchPolicyCustomerItem();
            if (dispatchPolicyCustomerItem != null) {
                adSlot.setCodeID(dispatchPolicyCustomerItem._Q);
                adSlot.setStype(101);
                _nr _nrVar = new _nr(dispatchPolicyCustomerItem._c, dispatchPolicyCustomerItem._Q, adSlot);
                _f _fVar = new _f(this, _nrVar, dispatchPolicyCustomerItem, nativeExpressAdListener, adSlot);
                try {
                    _nrVar._o = dispatchPolicyCustomerItem._b;
                    _nrVar._a(adSlot.getCategoryType());
                    _nrVar._t._i(PtgAdSdk.getConfig()._a);
                    _nrVar._t._n(adSlot.getUserID());
                    _nrVar._t._m(adSlot.getPtgSlotID());
                    _nrVar._t._e(dispatchPolicyCustomerItem._Q);
                    _nrVar._t._f(dispatchPolicyCustomerItem._c);
                    _nrVar._t._c(dispatchPolicyCustomerItem._T);
                    _nrVar._t._d(dispatchPolicyCustomerItem._e);
                    _a(nativeExpressAdListener, adSlot, _nrVar);
                    _nt._a()._a(dispatchPolicyCustomerItem._c(), "inAppBid", _nrVar, null);
                    adSlot.setTrackingData(_nrVar);
                    this._a.loadDrawExpressAd(context, adSlot, _fVar);
                    return;
                } catch (Exception e) {
                    _fVar.onError(new AdErrorImpl(-1, e.getMessage(), (Object) null));
                    return;
                }
            }
            adErrorImpl = new AdErrorImpl(-1, "内部错误，无分发策略", (Object) null);
        }
        nativeExpressAdListener.onError(adErrorImpl);
    }

    @Override // com.kc.aw.lib.provider.PtgAdNative
    public final void loadInteractionExpressAd(Context context, AdSlot adSlot, PtgAdNative.InteractionExpressAdListener interactionExpressAdListener) {
        AdErrorImpl adErrorImpl;
        if (this._a == null) {
            adErrorImpl = new AdErrorImpl(PtgErrorCode.SDK_NULL_PROVIDER, "可用SDK为空，请确认分发策略配置，以及是否引用该模块", (Object) null);
        } else {
            com.kc.aw._c._a()._b();
            _cl dispatchPolicyCustomerItem = adSlot.getDispatchPolicyCustomerItem();
            if (dispatchPolicyCustomerItem != null) {
                adSlot.setCodeID(dispatchPolicyCustomerItem._Q);
                adSlot.setStype(7);
                _nr _nrVar = new _nr(dispatchPolicyCustomerItem._c, dispatchPolicyCustomerItem._Q, adSlot);
                _e _eVar = new _e(this, _nrVar, dispatchPolicyCustomerItem, interactionExpressAdListener, adSlot);
                try {
                    _nrVar._o = dispatchPolicyCustomerItem._b;
                    _nrVar._a(adSlot.getCategoryType());
                    _nrVar._t._i(PtgAdSdk.getConfig()._a);
                    _nrVar._t._n(adSlot.getUserID());
                    _nrVar._t._m(adSlot.getPtgSlotID());
                    _nrVar._t._e(dispatchPolicyCustomerItem._Q);
                    _nrVar._t._f(dispatchPolicyCustomerItem._c);
                    _nrVar._t._c(dispatchPolicyCustomerItem._T);
                    _nrVar._t._d(dispatchPolicyCustomerItem._e);
                    _a(interactionExpressAdListener, adSlot, _nrVar);
                    _nt._a()._a(dispatchPolicyCustomerItem._c(), "inAppBid", _nrVar, null);
                    adSlot.setTrackingData(_nrVar);
                    this._a.loadInteractionExpressAd(context, adSlot, _eVar);
                    return;
                } catch (Exception e) {
                    _eVar.onError(new AdErrorImpl(-1, e.getMessage(), (Object) null));
                    return;
                }
            }
            adErrorImpl = new AdErrorImpl(-1, "内部错误，无分发策略", (Object) null);
        }
        interactionExpressAdListener.onError(adErrorImpl);
    }

    @Override // com.kc.aw.lib.provider.PtgAdNative
    public final void loadNativeExpressAd(Context context, AdSlot adSlot, PtgAdNative.NativeExpressAdListener nativeExpressAdListener) {
        AdErrorImpl adErrorImpl;
        if (this._a == null) {
            adErrorImpl = new AdErrorImpl(PtgErrorCode.SDK_NULL_PROVIDER, "可用SDK为空，请确认分发策略配置，以及是否引用该模块", (Object) null);
        } else {
            com.kc.aw._c._a()._b();
            _cl dispatchPolicyCustomerItem = adSlot.getDispatchPolicyCustomerItem();
            if (dispatchPolicyCustomerItem != null) {
                adSlot.setCodeID(dispatchPolicyCustomerItem._Q);
                adSlot.setStype(8);
                _nr _nrVar = new _nr(dispatchPolicyCustomerItem._c, dispatchPolicyCustomerItem._Q, adSlot);
                _b _bVar = new _b(this, _nrVar, dispatchPolicyCustomerItem, nativeExpressAdListener, adSlot);
                try {
                    _nrVar._o = dispatchPolicyCustomerItem._b;
                    _nrVar._a(adSlot.getCategoryType());
                    _nrVar._t._i(PtgAdSdk.getConfig()._a);
                    _nrVar._t._n(adSlot.getUserID());
                    _nrVar._t._m(adSlot.getPtgSlotID());
                    _nq _nqVar = _nrVar._t;
                    boolean zIsSelfRender = adSlot.isSelfRender();
                    _nqVar.getClass();
                    try {
                        synchronized (_nqVar._a) {
                            _nqVar._a.put("selfRender", zIsSelfRender);
                        }
                    } catch (Exception e) {
                        Error error = _nqVar._b;
                        if (error != null) {
                            error.onError(new AdErrorImpl(PtgErrorCode.SDK_INTERNAL_ERROR, e.getMessage(), (Object) null));
                        }
                    }
                    _nrVar._t._e(dispatchPolicyCustomerItem._Q);
                    _nrVar._t._f(dispatchPolicyCustomerItem._c);
                    _nrVar._t._c(dispatchPolicyCustomerItem._T);
                    _nrVar._t._d(dispatchPolicyCustomerItem._e);
                    _a(nativeExpressAdListener, adSlot, _nrVar);
                    _nt._a()._a(dispatchPolicyCustomerItem._c(), "inAppBid", _nrVar, null);
                    adSlot.setTrackingData(_nrVar);
                    this._a.loadNativeExpressAd(context, adSlot, _bVar);
                    return;
                } catch (Exception e2) {
                    _bVar.onError(new AdErrorImpl(-1, e2.getMessage(), (Object) null));
                    return;
                }
            }
            adErrorImpl = new AdErrorImpl(-1, "内部错误，无分发策略", (Object) null);
        }
        nativeExpressAdListener.onError(adErrorImpl);
    }

    @Override // com.kc.aw.lib.provider.PtgAdNative
    public final void loadRewardVideoAd(Context context, AdSlot adSlot, PtgAdNative.RewardVideoAdListener rewardVideoAdListener) {
        AdErrorImpl adErrorImpl;
        if (this._a == null) {
            adErrorImpl = new AdErrorImpl(PtgErrorCode.SDK_NULL_PROVIDER, "可用SDK为空，请确认分发策略配置，以及是否引用该模块", (Object) null);
        } else {
            com.kc.aw._c._a()._b();
            _cl dispatchPolicyCustomerItem = adSlot.getDispatchPolicyCustomerItem();
            if (dispatchPolicyCustomerItem != null) {
                adSlot.setCodeID(dispatchPolicyCustomerItem._Q);
                adSlot.setStype(100);
                _nr _nrVar = new _nr(dispatchPolicyCustomerItem._c, dispatchPolicyCustomerItem._Q, adSlot);
                _c _cVar = new _c(this, _nrVar, dispatchPolicyCustomerItem, rewardVideoAdListener, adSlot);
                try {
                    _nrVar._o = dispatchPolicyCustomerItem._b;
                    _nrVar._a(adSlot.getCategoryType());
                    _nrVar._t._i(PtgAdSdk.getConfig()._a);
                    _nrVar._t._n(adSlot.getUserID());
                    _nrVar._t._m(adSlot.getPtgSlotID());
                    _nrVar._t._e(dispatchPolicyCustomerItem._Q);
                    _nrVar._t._f(dispatchPolicyCustomerItem._c);
                    _nrVar._t._c(dispatchPolicyCustomerItem._T);
                    _nrVar._t._d(dispatchPolicyCustomerItem._e);
                    _a(rewardVideoAdListener, adSlot, _nrVar);
                    _nt._a()._a(dispatchPolicyCustomerItem._c(), "inAppBid", _nrVar, null);
                    adSlot.setTrackingData(_nrVar);
                    this._a.loadRewardVideoAd(context, adSlot, _cVar);
                    return;
                } catch (Exception e) {
                    _cVar.onError(new AdErrorImpl(-1, e.getMessage(), (Object) null));
                    return;
                }
            }
            adErrorImpl = new AdErrorImpl(-1, "内部错误，无分发策略", (Object) null);
        }
        rewardVideoAdListener.onError(adErrorImpl);
    }

    @Override // com.kc.aw.lib.provider.PtgAdNative
    public final void loadSplashAd(Context context, AdSlot adSlot, PtgAdNative.SplashAdListener splashAdListener) {
        AdErrorImpl adErrorImpl;
        if (this._a == null) {
            adErrorImpl = new AdErrorImpl(PtgErrorCode.SDK_NULL_PROVIDER, "可用SDK为空，请确认分发策略配置，以及是否引用该模块", (Object) null);
        } else {
            com.kc.aw._c._a()._b();
            _cl dispatchPolicyCustomerItem = adSlot.getDispatchPolicyCustomerItem();
            if (dispatchPolicyCustomerItem != null) {
                adSlot.setCodeID(dispatchPolicyCustomerItem._Q);
                adSlot.setStype(6);
                _nr _nrVar = new _nr(dispatchPolicyCustomerItem._c, dispatchPolicyCustomerItem._Q, adSlot);
                _a _aVar = new _a(this, _nrVar, dispatchPolicyCustomerItem, splashAdListener, adSlot);
                try {
                    _nrVar._o = dispatchPolicyCustomerItem._b;
                    _nrVar._a(adSlot.getCategoryType());
                    _nrVar._t._i(PtgAdSdk.getConfig()._a);
                    _nrVar._t._n(adSlot.getUserID());
                    _nrVar._t._m(adSlot.getPtgSlotID());
                    _nrVar._t._e(dispatchPolicyCustomerItem._Q);
                    _nrVar._t._f(dispatchPolicyCustomerItem._c);
                    _nrVar._t._c(dispatchPolicyCustomerItem._T);
                    _nrVar._t._d(dispatchPolicyCustomerItem._e);
                    _a(splashAdListener, adSlot, _nrVar);
                    _nt._a()._a(dispatchPolicyCustomerItem._c(), "inAppBid", _nrVar, null);
                    adSlot.setTrackingData(_nrVar);
                    this._a.loadSplashAd(context, adSlot, _aVar);
                    return;
                } catch (Exception e) {
                    _aVar.onError(new AdErrorImpl(-1, e.getMessage(), (Object) null));
                    return;
                }
            }
            adErrorImpl = new AdErrorImpl(-1, "内部错误，无分发策略", (Object) null);
        }
        splashAdListener.onError(adErrorImpl);
    }
}
