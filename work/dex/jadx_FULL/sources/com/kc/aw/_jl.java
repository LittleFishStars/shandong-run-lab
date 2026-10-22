package com.kc.aw;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.kc.aw.lib.constants.PtgErrorCode;
import com.kc.aw.lib.core.model.AdErrorImpl;
import com.kc.aw.lib.interf.NativeAdvertData;
import com.kc.aw.lib.interf.PtgAppDownloadListener;
import com.kc.aw.lib.interf.PtgNativeExpressAd;
import com.kc.aw.lib.interf.PtgVideoAdListener;
import com.kc.aw.lib.model.AdBidLossReason;
import com.kc.aw.lib.model.AdError;
import com.kc.aw.lib.model.AdSlot;
import com.kc.aw.lib.provider.PtgAdNative;
import com.kc.aw.provider.PtgApiProvider;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _jl implements Runnable {
    public final _q _a;
    public final _jm _b;

    @Keep
    public final class _a implements PtgNativeExpressAd {
        public _l _a;
        public String _b;
        public boolean _c = false;
        public boolean _d = false;
        public final _h _e;
        public final _jo _f;
        public final _jl _g;

        /* JADX INFO: renamed from: com.kc.aw._jl$_a$_a, reason: collision with other inner class name */
        @Keep
        public final class C0948_a implements PtgNativeExpressAd.AdInteractionListener {
            public final PtgNativeExpressAd.AdInteractionListener _a;
            public final _a _b;

            public C0948_a(_a _aVar, PtgNativeExpressAd.AdInteractionListener adInteractionListener) {
                this._b = _aVar;
                this._a = adInteractionListener;
            }

            @Override // com.kc.aw.lib.interf.PtgNativeExpressAd.ExpressAdInteractionListener
            public final void onAdClicked() {
                PtgNativeExpressAd.AdInteractionListener adInteractionListener = this._a;
                if (adInteractionListener != null) {
                    adInteractionListener.onAdClicked();
                }
            }

            @Override // com.kc.aw.lib.interf.PtgNativeExpressAd.ExpressAdInteractionListener
            public final void onAdDismiss() {
                PtgNativeExpressAd.AdInteractionListener adInteractionListener = this._a;
                if (adInteractionListener != null) {
                    adInteractionListener.onAdDismiss();
                }
            }

            @Override // com.kc.aw.lib.interf.PtgNativeExpressAd.ExpressAdInteractionListener
            public final void onAdShow() {
                _h _hVar = this._b._e;
                if (_hVar != null) {
                    _hVar._x = true;
                }
                PtgNativeExpressAd.AdInteractionListener adInteractionListener = this._a;
                if (adInteractionListener != null) {
                    adInteractionListener.onAdShow();
                }
                _a _aVar = this._b;
                if (_aVar._c) {
                    return;
                }
                _aVar._c = true;
                _nt _ntVar_a = _nt._a();
                _a _aVar2 = this._b;
                _h _hVar2 = _aVar2._e;
                AdSlot adSlot = _aVar2._g._b._b;
                _l0 _l0Var = _ntVar_a._b;
                if (_l0Var == null) {
                    _l0Var = new _l0();
                    _ntVar_a._b = _l0Var;
                }
                _l0Var._a(_hVar2);
            }

            @Override // com.kc.aw.lib.interf.PtgNativeExpressAd.ExpressAdInteractionListener
            public final void onRenderFail(AdError adError) {
                PtgNativeExpressAd.AdInteractionListener adInteractionListener = this._a;
                if (adInteractionListener != null) {
                    adInteractionListener.onRenderFail(adError);
                }
            }

            @Override // com.kc.aw.lib.interf.PtgNativeExpressAd.ExpressAdInteractionListener
            public final void onRenderSuccess(View view) {
                PtgNativeExpressAd.AdInteractionListener adInteractionListener = this._a;
                if (adInteractionListener != null) {
                    adInteractionListener.onRenderSuccess(view);
                }
            }
        }

        public _a(_jl _jlVar, _h _hVar, _jo _joVar) {
            this._g = _jlVar;
            this._e = _hVar;
            this._f = _joVar;
            this._a = new _ic(_hVar, _jlVar._b._b);
        }

        @Override // com.kc.aw.lib.interf.PtgNativeExpressAd, com.kc.aw.lib.interf.PtgAd
        public final void destroy() {
            this._f.destroy();
            this._g._b._d._a = null;
        }

        @Override // com.kc.aw.lib.interf.PtgAd
        public final _l getAdFilterAdapter() {
            return this._a;
        }

        @Override // com.kc.aw.lib.interf.PtgAd
        public final String getAdId() {
            _o _oVar_a;
            if (TextUtils.isEmpty(this._b) && (_oVar_a = ((_mj) this._a)._a()) != null) {
                this._b = _oVar_a._p;
            }
            return this._b;
        }

        @Override // com.kc.aw.lib.interf.PtgNativeExpressAd
        public final NativeAdvertData getAdvertData() {
            return _hz._a(8, isSelfRender(), this._e);
        }

        @Override // com.kc.aw.lib.interf.PtgAd
        public final String getConsumer() {
            return PtgApiProvider.providerName;
        }

        @Override // com.kc.aw.lib.interf.PtgNativeExpressAd
        public final PtgNativeExpressAd.CustomizeVideo getCustomizeVideo() {
            return this._f.getCustomizeVideo();
        }

        @Override // com.kc.aw.lib.interf.PtgAd
        public final long getEcpm() {
            _h _hVar = this._e;
            if (_hVar != null) {
                return _hVar._l;
            }
            return 0L;
        }

        @Override // com.kc.aw.lib.interf.PtgNativeExpressAd
        public final View getExpressAdView() {
            return this._f.getExpressAdView();
        }

        @Override // com.kc.aw.lib.interf.PtgNativeExpressAd
        public final List<Object> getFilterWords() {
            this._f.getClass();
            return null;
        }

        @Override // com.kc.aw.lib.interf.PtgNativeExpressAd
        public final int getImageMode() {
            _h _hVar = this._e;
            if (_hVar == null) {
                return -1;
            }
            try {
                return Integer.parseInt(_hVar._j());
            } catch (Exception unused) {
                return 0;
            }
        }

        @Override // com.kc.aw.lib.interf.PtgAd
        public final int getInteractionType() {
            _h _hVar = this._e;
            if (_hVar != null) {
                int i = _hVar._a;
                if (i == 0) {
                    return 0;
                }
                if (i == 1) {
                    return 1;
                }
                if (i == 2) {
                    return 3;
                }
            }
            return -1;
        }

        @Override // com.kc.aw.lib.interf.PtgNativeExpressAd
        public final Map<String, Object> getMediaExtraInfo() {
            this._f.getClass();
            return null;
        }

        @Override // com.kc.aw.lib.interf.PtgNativeExpressAd
        public final View getMediaView() {
            return this._f.getMediaView();
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

        @Override // com.kc.aw.lib.interf.PtgNativeExpressAd
        public final boolean isSelfRender() {
            return this._f._a.isSelfRender();
        }

        @Override // com.kc.aw.lib.interf.PtgNativeExpressAd
        public final boolean isVideo() {
            return this._f.isVideo();
        }

        @Override // com.kc.aw.lib.interf.PtgAd
        public final void notifyBidLoss(AdBidLossReason adBidLossReason) {
            if (this._e == null || this._d) {
                return;
            }
            this._d = true;
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
            if (this._e == null || this._d) {
                return;
            }
            this._d = true;
            _nt _ntVar_a = _nt._a();
            _h _hVar = this._e;
            AdSlot adSlot = this._g._b._b;
            _l0 _l0Var = _ntVar_a._b;
            if (_l0Var == null) {
                _l0Var = new _l0();
                _ntVar_a._b = _l0Var;
            }
            _l0Var._b(_hVar);
        }

        @Override // com.kc.aw.lib.interf.PtgNativeExpressAd
        public final void pauseVideo() {
            this._f.pauseVideo();
        }

        @Override // com.kc.aw.lib.interf.PtgNativeExpressAd
        public final void registerAdvertViews(ViewGroup viewGroup, List<View> list, List<View> list2, View view) {
            this._f.registerAdvertViews(viewGroup, list, list2, view);
        }

        @Override // com.kc.aw.lib.interf.PtgNativeExpressAd
        public final void render() {
            _h _hVar = this._e;
            if (_hVar != null && !_hVar._r()) {
                PtgNativeExpressAd.AdInteractionListener adInteractionListener = this._g._b._d._a;
                if (adInteractionListener != null) {
                    AdErrorImpl adErrorImpl = new AdErrorImpl();
                    adErrorImpl._c = PtgApiProvider.providerName;
                    adErrorImpl._d = PtgErrorCode.SDK_RENDER_ERROR;
                    adErrorImpl._e = PtgErrorCode.SDK_RENDER_ERROR_5;
                    adErrorImpl._a = PtgErrorCode.SDK_RENDER_ERROR;
                    adErrorImpl._b = PtgErrorCode.SDK_RENDER_ERROR_5;
                    adInteractionListener.onRenderFail(adErrorImpl);
                    return;
                }
                return;
            }
            _jo _joVar = this._f;
            _h _hVar2 = this._e;
            _joVar._b = _hVar2;
            if (_joVar._a.isSelfRender()) {
                _dn _dnVar = _joVar._d;
                if (_dnVar != null) {
                    _dnVar._c = _hVar2;
                }
            } else {
                _dp _dpVar = _joVar._e;
                if (_dpVar != null) {
                    _dpVar.setAdvertInfo(_hVar2);
                }
            }
            this._f.render();
        }

        @Override // com.kc.aw.lib.interf.PtgAd
        public final void setAdFilterAdapter(_l _lVar) {
            if (_lVar != null) {
                this._a = _lVar;
            }
        }

        @Override // com.kc.aw.lib.interf.PtgNativeExpressAd
        public final void setCanInterruptVideoPlay(boolean z) {
            this._f.getClass();
        }

        @Override // com.kc.aw.lib.interf.PtgNativeExpressAd
        public final void setDownloadListener(PtgAppDownloadListener ptgAppDownloadListener) {
            this._f.getClass();
        }

        @Override // com.kc.aw.lib.interf.PtgNativeExpressAd
        public final void setExpressInteractionListener(PtgNativeExpressAd.AdInteractionListener adInteractionListener) {
            this._g._b._d._a = adInteractionListener;
            this._f.setExpressInteractionListener(new C0948_a(this, adInteractionListener));
        }

        @Override // com.kc.aw.lib.interf.PtgNativeExpressAd
        public final void setExpressViewColor(String str) {
            this._f.setExpressViewColor(str);
        }

        @Override // com.kc.aw.lib.interf.PtgNativeExpressAd
        public final void setSlideIntervalTime(int i) {
            this._f.getClass();
        }

        @Override // com.kc.aw.lib.interf.PtgNativeExpressAd
        public final void setVideoAdListener(PtgVideoAdListener ptgVideoAdListener) {
            this._f.setVideoAdListener(ptgVideoAdListener);
        }

        @Override // com.kc.aw.lib.interf.PtgNativeExpressAd
        public final void showInteractionExpressAd(Activity activity) {
            this._f.getClass();
        }

        @Override // com.kc.aw.lib.interf.PtgNativeExpressAd
        public final void startVideo() {
            this._f.startVideo();
        }
    }

    public _jl(_jm _jmVar, _q _qVar) {
        this._b = _jmVar;
        this._a = _qVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        List<_h> list = this._a._a;
        if (list == null || list.isEmpty()) {
            this._b._a.onError(new AdErrorImpl(10000, AdError.ERROR_NO_AD_STR, (Object) null));
            return;
        }
        _h _hVar = list.get(0);
        this._b._b.setConsumerPrice(_hVar._l);
        _jm _jmVar = this._b;
        _a _aVar = new _a(this, _hVar, new _jo(_jmVar._c, _hVar, _jmVar._b));
        PtgAdNative.NativeExpressAdListener nativeExpressAdListener = this._b._a;
        if (nativeExpressAdListener != null) {
            nativeExpressAdListener.onNativeExpressAdLoad(_aVar);
        }
    }
}
