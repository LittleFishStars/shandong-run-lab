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
import com.kc.aw.provider.PtgApiProvider;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _ie implements Runnable {
    public final _q _a;
    public final _if _b;

    @Keep
    public final class _a implements PtgNativeExpressAd {
        public boolean _a = false;
        public boolean _b = false;
        public _l _c;
        public String _d;
        public final _h _e;
        public final _jo _f;
        public final _ie _g;

        /* JADX INFO: renamed from: com.kc.aw._ie$_a$_a, reason: collision with other inner class name */
        @Keep
        public final class C0946_a implements PtgNativeExpressAd.AdInteractionListener {
            public final PtgNativeExpressAd.AdInteractionListener _a;
            public final _a _b;

            public C0946_a(_a _aVar, _jk _jkVar) {
                this._b = _aVar;
                this._a = _jkVar;
            }

            @Override // com.kc.aw.lib.interf.PtgNativeExpressAd.ExpressAdInteractionListener
            public final void onAdClicked() {
                this._a.onAdClicked();
            }

            @Override // com.kc.aw.lib.interf.PtgNativeExpressAd.ExpressAdInteractionListener
            public final void onAdDismiss() {
                this._a.onAdDismiss();
            }

            @Override // com.kc.aw.lib.interf.PtgNativeExpressAd.ExpressAdInteractionListener
            public final void onAdShow() {
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
                AdSlot adSlot = _aVar2._g._b._b;
                _l0 _l0Var = _ntVar_a._b;
                if (_l0Var == null) {
                    _l0Var = new _l0();
                    _ntVar_a._b = _l0Var;
                }
                _l0Var._a(_hVar);
            }

            @Override // com.kc.aw.lib.interf.PtgNativeExpressAd.ExpressAdInteractionListener
            public final void onRenderFail(AdError adError) {
                this._a.onRenderFail(adError);
            }

            @Override // com.kc.aw.lib.interf.PtgNativeExpressAd.ExpressAdInteractionListener
            public final void onRenderSuccess(View view) {
                this._a.onRenderSuccess(view);
            }
        }

        public _a(_ie _ieVar, _h _hVar, _jo _joVar) {
            this._g = _ieVar;
            this._e = _hVar;
            this._f = _joVar;
            this._c = new _ic(_hVar, _ieVar._b._b);
        }

        @Override // com.kc.aw.lib.interf.PtgNativeExpressAd, com.kc.aw.lib.interf.PtgAd
        public final void destroy() {
            _jo _joVar = this._f;
            if (_joVar != null) {
                _joVar.destroy();
            }
        }

        @Override // com.kc.aw.lib.interf.PtgAd
        public final _l getAdFilterAdapter() {
            return this._c;
        }

        @Override // com.kc.aw.lib.interf.PtgAd
        public final String getAdId() {
            _nr trackingData;
            if (TextUtils.isEmpty(this._d) && (trackingData = this._g._b._b.getTrackingData()) != null) {
                this._d = trackingData._h;
            }
            return this._d;
        }

        @Override // com.kc.aw.lib.interf.PtgNativeExpressAd
        public final NativeAdvertData getAdvertData() {
            return _hz._a(5, isSelfRender(), this._e);
        }

        @Override // com.kc.aw.lib.interf.PtgAd
        public final String getConsumer() {
            return PtgApiProvider.providerName;
        }

        @Override // com.kc.aw.lib.interf.PtgNativeExpressAd
        public final PtgNativeExpressAd.CustomizeVideo getCustomizeVideo() {
            return null;
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
            return null;
        }

        @Override // com.kc.aw.lib.interf.PtgNativeExpressAd
        public final int getImageMode() {
            return 0;
        }

        @Override // com.kc.aw.lib.interf.PtgAd
        public final int getInteractionType() {
            return this._f.getInteractionType();
        }

        @Override // com.kc.aw.lib.interf.PtgNativeExpressAd
        public final Map<String, Object> getMediaExtraInfo() {
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
            return false;
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
        }

        @Override // com.kc.aw.lib.interf.PtgNativeExpressAd
        public final void registerAdvertViews(ViewGroup viewGroup, List<View> list, List<View> list2, View view) {
            this._f.registerAdvertViews(viewGroup, list, list2, view);
        }

        @Override // com.kc.aw.lib.interf.PtgNativeExpressAd
        public final void render() {
            if (!this._e._r()) {
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
            if (this._g._b._b.isSelfRender()) {
                PtgNativeExpressAd.AdInteractionListener adInteractionListener2 = this._g._b._d._a;
                if (adInteractionListener2 != null) {
                    adInteractionListener2.onRenderFail(new AdErrorImpl(PtgErrorCode.SDK_RENDER_ERROR, "selfRender 非法，请联系相关人员处理", (Object) null));
                    return;
                }
                return;
            }
            _jo _joVar = this._f;
            _h _hVar = this._e;
            _joVar._b = _hVar;
            if (_joVar._a.isSelfRender()) {
                _dn _dnVar = _joVar._d;
                if (_dnVar != null) {
                    _dnVar._c = _hVar;
                }
            } else {
                _dp _dpVar = _joVar._e;
                if (_dpVar != null) {
                    _dpVar.setAdvertInfo(_hVar);
                }
            }
            this._f.render();
        }

        @Override // com.kc.aw.lib.interf.PtgAd
        public final void setAdFilterAdapter(_l _lVar) {
            if (_lVar != null) {
                this._c = _lVar;
            }
        }

        @Override // com.kc.aw.lib.interf.PtgNativeExpressAd
        public final void setCanInterruptVideoPlay(boolean z) {
        }

        @Override // com.kc.aw.lib.interf.PtgNativeExpressAd
        public final void setDownloadListener(PtgAppDownloadListener ptgAppDownloadListener) {
            this._f.getClass();
        }

        @Override // com.kc.aw.lib.interf.PtgNativeExpressAd
        public final void setExpressInteractionListener(PtgNativeExpressAd.AdInteractionListener adInteractionListener) {
            _ie _ieVar = this._g;
            _ieVar._b._d._a = adInteractionListener;
            this._f.setExpressInteractionListener(new C0946_a(this, new _jk(_ieVar._a, adInteractionListener)));
        }

        @Override // com.kc.aw.lib.interf.PtgNativeExpressAd
        public final void setExpressViewColor(String str) {
            this._f.setExpressViewColor(str);
        }

        @Override // com.kc.aw.lib.interf.PtgNativeExpressAd
        public final void setSlideIntervalTime(int i) {
        }

        @Override // com.kc.aw.lib.interf.PtgNativeExpressAd
        public final void setVideoAdListener(PtgVideoAdListener ptgVideoAdListener) {
        }

        @Override // com.kc.aw.lib.interf.PtgNativeExpressAd
        public final void showInteractionExpressAd(Activity activity) {
        }

        @Override // com.kc.aw.lib.interf.PtgNativeExpressAd
        public final void startVideo() {
        }
    }

    public _ie(_if _ifVar, _q _qVar) {
        this._b = _ifVar;
        this._a = _qVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        List<_h> list;
        _q _qVar = this._a;
        List<_h> list2 = (_qVar == null || (list = _qVar._a) == null || list.isEmpty()) ? null : this._a._a;
        if (list2 == null) {
            this._b._a.onError(new AdErrorImpl(10000, AdError.ERROR_NO_AD_STR, (Object) null));
            return;
        }
        _h _hVar = list2.get(0);
        _hVar.getClass();
        this._b._b.setConsumerPrice(_hVar._l);
        _if _ifVar = this._b;
        _jo _joVar = new _jo(_ifVar._c, _hVar, _ifVar._b);
        _a _aVar = new _a(this, _hVar, _joVar);
        AdSlot adSlot = this._b._b;
        _joVar._a = adSlot;
        if (adSlot.isSelfRender()) {
            _dn _dnVar = _joVar._d;
            if (_dnVar != null) {
                _dnVar._b = adSlot;
            }
        } else {
            _dp _dpVar = _joVar._e;
            if (_dpVar != null) {
                _dpVar.setAdvertSlot(adSlot);
            }
        }
        this._b._a.onNativeExpressAdLoad(_aVar);
    }
}
