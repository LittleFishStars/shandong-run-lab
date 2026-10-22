package com.kc.aw;

import android.app.Activity;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.kc.aw.lib.core.model.AdErrorImpl;
import com.kc.aw.lib.interf.NativeAdvertData;
import com.kc.aw.lib.interf.PtgAppDownloadListener;
import com.kc.aw.lib.interf.PtgSplashAd;
import com.kc.aw.lib.model.AdBidLossReason;
import com.kc.aw.lib.model.AdError;
import com.kc.aw.lib.model.AdSlot;
import com.kc.aw.lib.provider.PtgAdNative;
import com.kc.aw.lib.utils.Logger;
import com.kc.aw.provider.PtgApiProvider;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _k0 implements Runnable {
    public final _q _a;
    public final _k1 _b;

    @Keep
    public final class _a implements PtgSplashAd {
        public boolean _a = false;
        public boolean _b = false;
        public _l _c;
        public String _d;
        public final _h _e;
        public final _k3 _f;
        public final List _g;
        public final _k0 _h;

        /* JADX INFO: renamed from: com.kc.aw._k0$_a$_a, reason: collision with other inner class name */
        @Keep
        public final class C0950_a implements PtgSplashAd.AdInteractionListener {
            public final PtgSplashAd.AdInteractionListener _a;
            public final _a _b;

            public C0950_a(_a _aVar, _jz _jzVar) {
                this._b = _aVar;
                this._a = _jzVar;
            }

            @Override // com.kc.aw.lib.interf.PtgSplashAd.AdInteractionListener
            public final void onAdClicked() {
                Logger.d("PtgSplashAdManager", "onAdClicked ad on click");
                this._a.onAdClicked();
            }

            @Override // com.kc.aw.lib.interf.PtgSplashAd.AdInteractionListener
            public final void onAdShow() {
                Logger.d("PtgSplashAdManager", "onAdShow ad on show");
                this._b._e._x = true;
                this._a.onAdShow();
                _a _aVar = this._b;
                if (_aVar._a) {
                    return;
                }
                _aVar._a = true;
                _nt _ntVar_a = _nt._a();
                _a _aVar2 = this._b;
                _h _hVar = _aVar2._e;
                AdSlot adSlot = _aVar2._h._b._b;
                _l0 _l0Var = _ntVar_a._b;
                if (_l0Var == null) {
                    _l0Var = new _l0();
                    _ntVar_a._b = _l0Var;
                }
                _l0Var._a(_hVar);
            }

            @Override // com.kc.aw.lib.interf.PtgSplashAd.AdInteractionListener
            public final void onAdSkip() {
                Logger.d("PtgSplashAdManager", "onAdSkip ad on skip");
                this._a.onAdSkip();
            }

            @Override // com.kc.aw.lib.interf.PtgSplashAd.AdInteractionListener
            public final void onAdTimeOver() {
                Logger.d("PtgSplashAdManager", "onAdTimeOver ad on timeOver");
                this._a.onAdTimeOver();
            }

            @Override // com.kc.aw.lib.interf.PtgSplashAd.AdInteractionListener
            public final void onDismiss(int i) {
                Logger.d("PtgSplashAdManager", "onDismiss ad on onDismiss 关闭类型=" + i);
                this._a.onDismiss(i);
            }

            @Override // com.kc.aw.lib.interf.PtgSplashAd.AdInteractionListener
            public final void onRenderError(AdError adError) {
                Logger.d("PtgSplashAdManager", "onRenderError ad on RenderError");
                this._a.onRenderError(adError);
            }

            @Override // com.kc.aw.lib.interf.PtgSplashAd.AdInteractionListener
            public final void onRenderSuccess() {
                Logger.d("PtgSplashAdManager", "onAdTimeOver ad onRenderSuccess");
                this._a.onRenderSuccess();
            }
        }

        public _a(_k0 _k0Var, _h _hVar, _k3 _k3Var, ArrayList arrayList) {
            this._h = _k0Var;
            this._e = _hVar;
            this._f = _k3Var;
            this._g = arrayList;
            this._c = new _ic(_hVar, _k0Var._b._b);
        }

        @Override // com.kc.aw.lib.interf.PtgAd
        public final void destroy() {
            _mz _mzVar = this._f._a;
            if (_mzVar != null) {
                _mzVar._a();
            }
        }

        @Override // com.kc.aw.lib.interf.PtgAd
        public final _l getAdFilterAdapter() {
            return this._c;
        }

        @Override // com.kc.aw.lib.interf.PtgAd
        public final String getAdId() {
            _o _oVar_a;
            if (TextUtils.isEmpty(this._d) && (_oVar_a = ((_mj) this._c)._a()) != null) {
                this._d = _oVar_a._p;
            }
            return this._d;
        }

        @Override // com.kc.aw.lib.interf.PtgSplashAd
        public final NativeAdvertData getAdvertData() {
            return this._f.getAdvertData();
        }

        @Override // com.kc.aw.lib.interf.PtgAd
        public final String getConsumer() {
            return PtgApiProvider.providerName;
        }

        @Override // com.kc.aw.lib.interf.PtgAd
        public final long getEcpm() {
            _h _hVar = this._e;
            if (_hVar != null) {
                return _hVar._l;
            }
            return 0L;
        }

        @Override // com.kc.aw.lib.interf.PtgAd
        public final int getInteractionType() {
            this._f._a(this._g);
            return this._f.getInteractionType();
        }

        @Override // com.kc.aw.lib.interf.PtgAd
        public final boolean isReady() {
            _h _hVar = this._e;
            return _hVar != null && _hVar._r();
        }

        @Override // com.kc.aw.lib.interf.PtgAd
        public final boolean isResourceLoaded() {
            _h _hVar = this._e;
            return _hVar != null && _hVar._H;
        }

        @Override // com.kc.aw.lib.interf.PtgSplashAd
        public final void load() {
            if (this._h._b._b.getAdContainer() != null) {
                this._h._b._b.getAdContainer().removeAllViews();
                _mz _mzVar = this._f._a;
                if (_mzVar == null || _mzVar.getParent() != null) {
                    return;
                }
                ViewGroup originalAdContainer = this._h._b._b.getOriginalAdContainer();
                if (originalAdContainer == null || originalAdContainer.getParent() == null) {
                    originalAdContainer = this._h._b._b.getAdContainer();
                }
                if (originalAdContainer != null) {
                    originalAdContainer.addView(this._f._a);
                }
            }
        }

        @Override // com.kc.aw.lib.interf.PtgAd
        public final void notifyBidLoss(AdBidLossReason adBidLossReason) {
            if (this._e == null || this._b) {
                return;
            }
            this._b = true;
            _nt _ntVar_a = _nt._a();
            _h _hVar = this._e;
            _l0 _l0Var = _ntVar_a._b;
            if (_l0Var == null) {
                _l0Var = new _l0();
                _ntVar_a._b = _l0Var;
            }
            _l0Var._a(_hVar, adBidLossReason);
        }

        @Override // com.kc.aw.lib.interf.PtgAd
        public final void notifyBidWin(double d, double d2) {
            if (this._e == null || this._b) {
                return;
            }
            this._b = true;
            _nt _ntVar_a = _nt._a();
            _h _hVar = this._e;
            AdSlot adSlot = this._h._b._b;
            _l0 _l0Var = _ntVar_a._b;
            if (_l0Var == null) {
                _l0Var = new _l0();
                _ntVar_a._b = _l0Var;
            }
            _l0Var._b(_hVar);
        }

        @Override // com.kc.aw.lib.interf.PtgSplashAd
        public final void preload() {
            this._f.preload();
        }

        @Override // com.kc.aw.lib.interf.PtgAd
        public final void setAdFilterAdapter(_l _lVar) {
            if (_lVar != null) {
                this._c = _lVar;
            }
        }

        @Override // com.kc.aw.lib.interf.PtgSplashAd
        public final void setDownloadListener(PtgAppDownloadListener ptgAppDownloadListener) {
            this._f.setDownloadListener(ptgAppDownloadListener);
        }

        @Override // com.kc.aw.lib.interf.PtgSplashAd
        public final void setSplashInteractionListener(PtgSplashAd.AdInteractionListener adInteractionListener) {
            this._f.setSplashInteractionListener(new C0950_a(this, new _jz(this._h._a, adInteractionListener)));
        }

        @Override // com.kc.aw.lib.interf.PtgSplashAd
        public final void showAd(ViewGroup viewGroup) {
            if (this._h._b._b.getAdContainer() != null) {
                Logger.e("SplashView showAd fail, slot already exists container.");
            } else if (viewGroup != null) {
                this._f._a(this._g);
                this._f.showAd(viewGroup);
            }
        }

        @Override // com.kc.aw.lib.interf.PtgSplashAd
        public final void showAd(ViewGroup viewGroup, Activity activity) {
            if (this._h._b._b.getAdContainer() != null) {
                Logger.e("SplashView showAd fail, slot already exists container.");
            } else if (viewGroup != null) {
                this._f._a(this._g);
                this._f.showAd(viewGroup, activity);
            }
        }
    }

    public _k0(_k1 _k1Var, _q _qVar) {
        this._b = _k1Var;
        this._a = _qVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        List<_h> list;
        ArrayList arrayList = new ArrayList();
        _q _qVar = this._a;
        if (_qVar != null && (list = _qVar._a) != null && !list.isEmpty()) {
            arrayList.addAll(this._a._a);
        }
        if (arrayList.isEmpty()) {
            PtgAdNative.SplashAdListener splashAdListener = this._b._a;
            if (splashAdListener != null) {
                splashAdListener.onError(new AdErrorImpl(10000, AdError.ERROR_NO_AD_STR, (Object) null));
                return;
            }
            return;
        }
        _h _hVar = (_h) arrayList.get(0);
        this._b._b.setConsumerPrice(_hVar._l);
        _k1 _k1Var = this._b;
        _k3 _k3Var = new _k3(_k1Var._c, _k1Var._a);
        _k3Var._b = _hVar;
        _mz _mzVar = _k3Var._a;
        if (_mzVar != null) {
            _mzVar.setAdvertInfo(_hVar);
        }
        AdSlot adSlot = this._b._b;
        _k3Var._c = adSlot;
        _mz _mzVar2 = _k3Var._a;
        if (_mzVar2 != null) {
            _mzVar2.setAdSlot(adSlot);
        }
        _a _aVar = new _a(this, _hVar, _k3Var, arrayList);
        PtgAdNative.SplashAdListener splashAdListener2 = this._b._a;
        if (splashAdListener2 != null) {
            splashAdListener2.onSplashAdLoad(_aVar);
        }
        _k1 _k1Var2 = this._b;
        _k2 _k2Var = _k1Var2._d;
        AdSlot adSlot2 = _k1Var2._b;
        _k2Var.getClass();
        if (adSlot2.getAdContainer() != null) {
            ViewGroup adContainer = adSlot2.getAdContainer();
            if (adContainer.getParent() != null) {
                _k3Var._a(arrayList);
                adContainer.removeAllViews();
                adContainer.addView(_k3Var._a);
            }
        }
    }
}
