package com.kc.aw;

import android.app.Activity;
import android.text.TextUtils;
import com.kc.aw.activity.PtgInteractionPortraitActivity;
import com.kc.aw.lib.PtgAdSdk;
import com.kc.aw.lib.constants.PtgErrorCode;
import com.kc.aw.lib.core.model.AdErrorImpl;
import com.kc.aw.lib.interf.NativeAdvertData;
import com.kc.aw.lib.interf.PtgAppDownloadListener;
import com.kc.aw.lib.interf.PtgInteractionAd;
import com.kc.aw.lib.interf.PtgVideoAdListener;
import com.kc.aw.lib.model.AdBidLossReason;
import com.kc.aw.lib.model.AdError;
import com.kc.aw.lib.model.AdSlot;
import com.kc.aw.lib.utils.Logger;
import com.kc.aw.lib.utils.TextUtil;
import com.kc.aw.provider.PtgApiProvider;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _jb implements Runnable {
    public final _q _a;
    public final _jc _b;

    @Keep
    public final class _a implements PtgInteractionAd {
        public _l _a;
        public String _b;
        public boolean _c = false;
        public final _h _d;
        public final String _e;
        public final _jb _f;

        /* JADX INFO: renamed from: com.kc.aw._jb$_a$_a, reason: collision with other inner class name */
        @Keep
        public final class C0947_a implements PtgInteractionAd.AdInteractionListener {
            public boolean _a = false;
            public final _a _b;

            public C0947_a(_a _aVar) {
                this._b = _aVar;
            }

            @Override // com.kc.aw.lib.interf.PtgInteractionAd.AdInteractionListener
            public final void onAdClicked() {
                Logger.d("PtgInteractionAdLoader", "loadInteractionAd onAdClicked");
                PtgInteractionAd.AdInteractionListener adInteractionListener = this._b._f._b._c._a;
                if (adInteractionListener != null) {
                    adInteractionListener.onAdClicked();
                }
            }

            @Override // com.kc.aw.lib.interf.PtgInteractionAd.AdInteractionListener
            public final void onAdDismiss() {
                Logger.d("PtgInteractionAdLoader", "loadInteractionAd onAdDismiss");
                PtgInteractionAd.AdInteractionListener adInteractionListener = this._b._f._b._c._a;
                if (adInteractionListener != null) {
                    adInteractionListener.onAdDismiss();
                }
            }

            @Override // com.kc.aw.lib.interf.PtgInteractionAd.AdInteractionListener
            public final void onAdShow() {
                Logger.d("PtgInteractionAdLoader", "loadInteractionAd onAdShow");
                _a _aVar = this._b;
                _h _hVar = _aVar._d;
                if (_hVar != null) {
                    _hVar._x = true;
                }
                PtgInteractionAd.AdInteractionListener adInteractionListener = _aVar._f._b._c._a;
                if (adInteractionListener != null) {
                    adInteractionListener.onAdShow();
                }
                if (this._a) {
                    return;
                }
                this._a = true;
                _nt _ntVar_a = _nt._a();
                _a _aVar2 = this._b;
                _h _hVar2 = _aVar2._d;
                AdSlot adSlot = _aVar2._f._b._b;
                _l0 _l0Var = _ntVar_a._b;
                if (_l0Var == null) {
                    _l0Var = new _l0();
                    _ntVar_a._b = _l0Var;
                }
                _l0Var._a(_hVar2);
            }

            @Override // com.kc.aw.lib.interf.PtgInteractionAd.AdInteractionListener
            public final void onRenderError(AdError adError) {
                Logger.d("PtgInteractionAdLoader", "loadInteractionAd onRenderError");
                PtgInteractionAd.AdInteractionListener adInteractionListener = this._b._f._b._c._a;
                if (adInteractionListener != null) {
                    adInteractionListener.onRenderError(adError);
                }
            }
        }

        @Keep
        public final class _b implements PtgVideoAdListener {
            public final PtgVideoAdListener _a;

            public _b(PtgVideoAdListener ptgVideoAdListener) {
                this._a = ptgVideoAdListener;
            }

            @Override // com.kc.aw.lib.interf.PtgVideoAdListener
            public final void onVideoComplete() {
                PtgVideoAdListener ptgVideoAdListener = this._a;
                if (ptgVideoAdListener != null) {
                    ptgVideoAdListener.onVideoComplete();
                }
            }

            @Override // com.kc.aw.lib.interf.PtgVideoAdListener
            public final void onVideoError(int i, String str) {
                PtgVideoAdListener ptgVideoAdListener = this._a;
                if (ptgVideoAdListener != null) {
                    ptgVideoAdListener.onVideoError(i, str);
                }
            }

            @Override // com.kc.aw.lib.interf.PtgVideoAdListener
            public final void onVideoPause() {
                PtgVideoAdListener ptgVideoAdListener = this._a;
                if (ptgVideoAdListener != null) {
                    ptgVideoAdListener.onVideoPause();
                }
            }

            @Override // com.kc.aw.lib.interf.PtgVideoAdListener
            public final void onVideoProgressUpdate(long j, long j2) {
                PtgVideoAdListener ptgVideoAdListener = this._a;
                if (ptgVideoAdListener != null) {
                    ptgVideoAdListener.onVideoProgressUpdate(j, j2);
                }
            }

            @Override // com.kc.aw.lib.interf.PtgVideoAdListener
            public final void onVideoResume() {
                PtgVideoAdListener ptgVideoAdListener = this._a;
                if (ptgVideoAdListener != null) {
                    ptgVideoAdListener.onVideoResume();
                }
            }

            @Override // com.kc.aw.lib.interf.PtgVideoAdListener
            public final void onVideoStart() {
                PtgVideoAdListener ptgVideoAdListener = this._a;
                if (ptgVideoAdListener != null) {
                    ptgVideoAdListener.onVideoStart();
                }
            }
        }

        public _a(_jb _jbVar, _h _hVar, String str) {
            this._f = _jbVar;
            this._d = _hVar;
            this._e = str;
            this._a = new _ic(_hVar, _jbVar._b._b);
        }

        @Override // com.kc.aw.lib.interf.PtgInteractionAd
        public final void closureInterstitialAd() {
            PtgInteractionPortraitActivity._c _cVar;
            _h _hVar = this._d;
            int i = PtgInteractionPortraitActivity._e;
            if (_hVar == null) {
                return;
            }
            try {
                _fk _fkVar_a = _fk._a();
                String strValueOf = String.valueOf(_hVar.hashCode());
                _fkVar_a.getClass();
                if (TextUtils.isEmpty(strValueOf) || (_cVar = _fkVar_a._f.get(strValueOf)) == null) {
                    return;
                }
                _cVar._a();
            } catch (Exception unused) {
            }
        }

        @Override // com.kc.aw.lib.interf.PtgAd
        public final void destroy() {
            _fk._a()._a(this._e);
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

        @Override // com.kc.aw.lib.interf.PtgInteractionAd
        public final NativeAdvertData getAdvertData() {
            return _hz._a(7, false, this._d);
        }

        @Override // com.kc.aw.lib.interf.PtgAd
        public final String getConsumer() {
            return PtgApiProvider.providerName;
        }

        @Override // com.kc.aw.lib.interf.PtgAd
        public final long getEcpm() {
            _h _hVar = this._d;
            if (_hVar != null) {
                return _hVar._l;
            }
            return 0L;
        }

        @Override // com.kc.aw.lib.interf.PtgAd
        public final int getInteractionType() {
            return 0;
        }

        @Override // com.kc.aw.lib.interf.PtgInteractionAd
        public final Map<String, Object> getMediaExtraInfo() {
            return Collections.emptyMap();
        }

        @Override // com.kc.aw.lib.interf.PtgAd
        public final boolean isReady() {
            _h _hVar = this._d;
            return _hVar != null && _hVar._r();
        }

        @Override // com.kc.aw.lib.interf.PtgAd
        public final boolean isResourceLoaded() {
            _h _hVar = this._d;
            return _hVar != null && _hVar._H;
        }

        @Override // com.kc.aw.lib.interf.PtgAd
        public final void notifyBidLoss(AdBidLossReason adBidLossReason) {
            if (this._d == null || this._c) {
                return;
            }
            this._c = true;
            _nt _ntVar_a = _nt._a();
            _h _hVar = this._d;
            _l0 _l0Var = _ntVar_a._b;
            if (_l0Var == null) {
                _l0Var = new _l0();
                _ntVar_a._b = _l0Var;
            }
            _l0Var._a(_hVar, adBidLossReason);
        }

        @Override // com.kc.aw.lib.interf.PtgAd
        public final void notifyBidWin(double d, double d2) {
            if (this._d == null || this._c) {
                return;
            }
            this._c = true;
            _nt _ntVar_a = _nt._a();
            _h _hVar = this._d;
            AdSlot adSlot = this._f._b._b;
            _l0 _l0Var = _ntVar_a._b;
            if (_l0Var == null) {
                _l0Var = new _l0();
                _ntVar_a._b = _l0Var;
            }
            _l0Var._b(_hVar);
        }

        @Override // com.kc.aw.lib.interf.PtgAd
        public final void setAdFilterAdapter(_l _lVar) {
            if (_lVar != null) {
                this._a = _lVar;
            }
        }

        @Override // com.kc.aw.lib.interf.PtgInteractionAd
        public final void setAdInteractionListener(PtgInteractionAd.AdInteractionListener adInteractionListener) {
            _jb _jbVar = this._f;
            _jbVar._b._c._a = new _ja(_jbVar._a, adInteractionListener);
            _fk _fkVar_a = _fk._a();
            String str = this._e;
            C0947_a c0947_a = new C0947_a(this);
            _fkVar_a.getClass();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (_fkVar_a._d.contains(str)) {
                _fkVar_a._d.remove(str);
            }
            _fkVar_a._d.put(str, c0947_a);
        }

        @Override // com.kc.aw.lib.interf.PtgInteractionAd
        public final void setDownloadListener(PtgAppDownloadListener ptgAppDownloadListener) {
        }

        @Override // com.kc.aw.lib.interf.PtgInteractionAd
        public final void setVideoAdListener(PtgVideoAdListener ptgVideoAdListener) {
            _fk _fkVar_a = _fk._a();
            String str = this._e;
            _b _bVar = new _b(ptgVideoAdListener);
            _fkVar_a.getClass();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (_fkVar_a._e.contains(str)) {
                _fkVar_a._e.remove(str);
            }
            _fkVar_a._e.put(str, _bVar);
        }

        @Override // com.kc.aw.lib.interf.PtgInteractionAd
        public final void showInteractionAd(Activity activity) {
            String str_b;
            if (!this._d._r()) {
                PtgInteractionAd.AdInteractionListener adInteractionListener = this._f._b._c._a;
                if (adInteractionListener != null) {
                    AdErrorImpl adErrorImpl = new AdErrorImpl();
                    adErrorImpl._c = PtgApiProvider.providerName;
                    adErrorImpl._d = PtgErrorCode.SDK_RENDER_ERROR;
                    adErrorImpl._e = PtgErrorCode.SDK_RENDER_ERROR_5;
                    adErrorImpl._a = PtgErrorCode.SDK_RENDER_ERROR;
                    adErrorImpl._b = PtgErrorCode.SDK_RENDER_ERROR_5;
                    adInteractionListener.onRenderError(adErrorImpl);
                    return;
                }
                return;
            }
            _h _hVar = this._d;
            AdSlot adSlot = this._f._b._b;
            int i = PtgInteractionPortraitActivity._e;
            com.kc.aw.activity._a _aVar = new com.kc.aw.activity._a(activity, _hVar, adSlot);
            try {
                if (_hVar == null) {
                    _aVar._a("资源对象为空!");
                    return;
                }
                if (!PtgAdSdk.getConfig()._b()) {
                    PtgInteractionPortraitActivity._a(activity, _hVar, _aVar);
                    return;
                }
                if (_hVar._s()) {
                    _k8 _k8Var_l = _hVar._l();
                    str_b = TextUtil.isNotEmpty(_k8Var_l._b) ? _k8Var_l._b : _k8Var_l._a;
                } else {
                    str_b = _hVar._b();
                }
                com.kc.aw.activity._b _bVar = new com.kc.aw.activity._b(_hVar, _aVar);
                AtomicBoolean atomicBoolean = _ez._a;
                if (TextUtil.isEmpty(str_b)) {
                    return;
                }
                com.kc.aw.lib.utils._d._b(new _f1(str_b, _bVar));
            } catch (Exception e) {
                StringBuilder sb_a = _jf._a("资源加载异常: ");
                sb_a.append(e.getMessage());
                _aVar._a(sb_a.toString());
            }
        }
    }

    public _jb(_jc _jcVar, _q _qVar) {
        this._b = _jcVar;
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
        int iHashCode = _hVar.hashCode();
        this._b._b.setConsumerPrice(_hVar._l);
        this._b._a.onInteractionAdLoad(new _a(this, _hVar, String.valueOf(iHashCode)));
    }
}
