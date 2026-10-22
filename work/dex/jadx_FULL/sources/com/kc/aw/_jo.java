package com.kc.aw;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.kc.aw.lib.constants.AdConstant;
import com.kc.aw.lib.constants.PtgErrorCode;
import com.kc.aw.lib.core.model.AdErrorImpl;
import com.kc.aw.lib.interf.NativeAdvertData;
import com.kc.aw.lib.interf.PtgAppDownloadListener;
import com.kc.aw.lib.interf.PtgNativeExpressAd;
import com.kc.aw.lib.interf.PtgVideoAdListener;
import com.kc.aw.lib.model.AdBidLossReason;
import com.kc.aw.lib.model.AdSlot;
import com.kc.aw.provider.PtgApiProvider;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _jo implements PtgNativeExpressAd {
    public AdSlot _a;
    public _h _b;
    public PtgNativeExpressAd.AdInteractionListener _c;
    public _dn _d;
    public _dp _e;

    public _jo(Context context, _h _hVar, AdSlot adSlot) {
        _a(context, _hVar, adSlot);
    }

    public final void _a(Context context, _h _hVar, AdSlot adSlot) {
        this._a = adSlot;
        this._b = _hVar;
        if (adSlot.isSelfRender()) {
            this._d = new _dn(context, _hVar, adSlot);
            return;
        }
        _dp _dpVar = new _dp(context);
        this._e = _dpVar;
        _dpVar.setAdvertSlot(adSlot);
        this._e.setAdvertInfo(_hVar);
    }

    @Override // com.kc.aw.lib.interf.PtgNativeExpressAd, com.kc.aw.lib.interf.PtgAd
    public final void destroy() {
        _dp _dpVar = this._e;
        if (_dpVar != null) {
            _dpVar._e();
        }
        _dn _dnVar = this._d;
        if (_dnVar != null) {
            _dnVar._a();
            this._d = null;
        }
        if (this._c != null) {
            this._c = null;
        }
    }

    @Override // com.kc.aw.lib.interf.PtgAd
    public final _l getAdFilterAdapter() {
        return null;
    }

    @Override // com.kc.aw.lib.interf.PtgAd
    public final String getAdId() {
        return null;
    }

    @Override // com.kc.aw.lib.interf.PtgNativeExpressAd
    public final NativeAdvertData getAdvertData() {
        return null;
    }

    @Override // com.kc.aw.lib.interf.PtgAd
    public final String getConsumer() {
        return PtgApiProvider.providerName;
    }

    @Override // com.kc.aw.lib.interf.PtgNativeExpressAd
    public final PtgNativeExpressAd.CustomizeVideo getCustomizeVideo() {
        _dn _dnVar;
        _er _erVar;
        if (!this._a.isSelfRender() || (_dnVar = this._d) == null || (_erVar = _dnVar._h) == null) {
            return null;
        }
        return _erVar.getCustomizeVideo();
    }

    @Override // com.kc.aw.lib.interf.PtgAd
    public final long getEcpm() {
        _h _hVar = this._b;
        if (_hVar != null) {
            return _hVar._l;
        }
        return 0L;
    }

    @Override // com.kc.aw.lib.interf.PtgNativeExpressAd
    public final View getExpressAdView() {
        if (this._a.isSelfRender()) {
            _dn _dnVar = this._d;
            if (_dnVar != null) {
                return _dnVar._d;
            }
            return null;
        }
        _dp _dpVar = this._e;
        if (_dpVar != null) {
            return _dpVar;
        }
        return null;
    }

    @Override // com.kc.aw.lib.interf.PtgNativeExpressAd
    public final List<Object> getFilterWords() {
        return null;
    }

    @Override // com.kc.aw.lib.interf.PtgNativeExpressAd
    public final int getImageMode() {
        _h _hVar = this._b;
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
        _h _hVar = this._b;
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
        return null;
    }

    @Override // com.kc.aw.lib.interf.PtgNativeExpressAd
    public final View getMediaView() {
        _dn _dnVar;
        _er _erVar;
        if (!this._a.isSelfRender() || (_dnVar = this._d) == null || (_erVar = _dnVar._h) == null) {
            return null;
        }
        return _erVar._c();
    }

    @Override // com.kc.aw.lib.interf.PtgAd
    public final boolean isReady() {
        _h _hVar = this._b;
        return _hVar != null && _hVar._r();
    }

    @Override // com.kc.aw.lib.interf.PtgAd
    public final boolean isResourceLoaded() {
        _h _hVar = this._b;
        return _hVar != null && _hVar._H;
    }

    @Override // com.kc.aw.lib.interf.PtgNativeExpressAd
    public final boolean isSelfRender() {
        return this._a.isSelfRender();
    }

    @Override // com.kc.aw.lib.interf.PtgNativeExpressAd
    public final boolean isVideo() {
        _dn _dnVar;
        _h _hVar;
        return this._a.isSelfRender() && (_dnVar = this._d) != null && (_hVar = _dnVar._c) != null && _hVar._s();
    }

    @Override // com.kc.aw.lib.interf.PtgAd
    public final void notifyBidLoss(AdBidLossReason adBidLossReason) {
    }

    @Override // com.kc.aw.lib.interf.PtgAd
    public final void notifyBidWin(double d, double d2) {
    }

    @Override // com.kc.aw.lib.interf.PtgNativeExpressAd
    public final void pauseVideo() {
        _dn _dnVar;
        _er _erVar;
        if (!this._a.isSelfRender() || (_dnVar = this._d) == null || (_erVar = _dnVar._h) == null) {
            return;
        }
        _erVar.pauseVideo();
    }

    @Override // com.kc.aw.lib.interf.PtgNativeExpressAd
    public final void registerAdvertViews(ViewGroup viewGroup, List<View> list, List<View> list2, View view) {
        AdSlot adSlot = this._a;
        if (adSlot != null && !adSlot.isSelfRender()) {
            PtgNativeExpressAd.AdInteractionListener adInteractionListener = this._c;
            if (adInteractionListener != null) {
                AdErrorImpl adErrorImpl = new AdErrorImpl();
                adErrorImpl._c = PtgApiProvider.providerName;
                adErrorImpl._d = PtgErrorCode.SDK_RENDER_ERROR;
                adErrorImpl._e = "请使用模板渲染！或配置为自渲染";
                adErrorImpl._a = PtgErrorCode.SDK_RENDER_ERROR;
                adErrorImpl._b = "请使用模板渲染！或配置为自渲染";
                adInteractionListener.onRenderFail(adErrorImpl);
                return;
            }
            return;
        }
        _dn _dnVar = this._d;
        if (_dnVar != null) {
            if (viewGroup == null) {
                throw new IllegalArgumentException("container不能为null");
            }
            if (list == null || list.isEmpty()) {
                throw new IllegalArgumentException("clickView不能为null");
            }
            AdSlot adSlot2 = _dnVar._b;
            if (adSlot2 != null && !adSlot2.isSelfRender()) {
                PtgNativeExpressAd.AdInteractionListener adInteractionListener2 = _dnVar._a;
                if (adInteractionListener2 != null) {
                    AdErrorImpl adErrorImpl2 = new AdErrorImpl();
                    adErrorImpl2._c = PtgApiProvider.providerName;
                    adErrorImpl2._d = PtgErrorCode.SDK_RENDER_ERROR;
                    adErrorImpl2._e = "请使用模板渲染！或配置为自渲染";
                    adErrorImpl2._a = PtgErrorCode.SDK_RENDER_ERROR;
                    adErrorImpl2._b = "请使用模板渲染！或配置为自渲染";
                    adInteractionListener2.onRenderFail(adErrorImpl2);
                    return;
                }
                return;
            }
            _dnVar._d = viewGroup;
            _dnVar._e = list;
            _dnVar._f = list2;
            _dnVar._g = view;
            _gu _guVar = _dnVar._i;
            if (_guVar != null) {
                _guVar._f = viewGroup;
                _guVar._g = list;
                _guVar._b();
            }
            View view2 = _dnVar._g;
            if (view2 != null) {
                view2.setOnClickListener(new _dm(_dnVar));
            }
            _er _erVar = _dnVar._h;
            if (_erVar != null) {
                _erVar._a(_dnVar._d);
                _dnVar._h._a(new _dl(_dnVar));
                _dnVar._h._b();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x01ea  */
    /* JADX WARN: Code duplicated, block: B:103:0x0225  */
    /* JADX WARN: Code duplicated, block: B:117:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:118:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:66:0x011e  */
    /* JADX WARN: Code duplicated, block: B:96:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:98:0x01d5  */
    @Override // com.kc.aw.lib.interf.PtgNativeExpressAd
    public final void render() {
        AdErrorImpl adErrorImpl;
        PtgNativeExpressAd.AdInteractionListener adInteractionListener;
        _am _adVar;
        float f;
        ViewGroup.LayoutParams layoutParams;
        _dp._a _aVar;
        _h _hVar = this._b;
        if (_hVar == null) {
            return;
        }
        if (!_hVar._r()) {
            PtgNativeExpressAd.AdInteractionListener adInteractionListener2 = this._c;
            if (adInteractionListener2 != null) {
                AdErrorImpl adErrorImpl2 = new AdErrorImpl();
                adErrorImpl2._c = PtgApiProvider.providerName;
                adErrorImpl2._d = PtgErrorCode.SDK_RENDER_ERROR;
                adErrorImpl2._e = PtgErrorCode.SDK_RENDER_ERROR_5;
                adErrorImpl2._a = PtgErrorCode.SDK_RENDER_ERROR;
                adErrorImpl2._b = PtgErrorCode.SDK_RENDER_ERROR_5;
                adInteractionListener2.onRenderFail(adErrorImpl2);
                return;
            }
            return;
        }
        if (this._a.isSelfRender()) {
            _dn _dnVar = this._d;
            if (_dnVar != null) {
                PtgNativeExpressAd.AdInteractionListener adInteractionListener3 = this._c;
                _dnVar._a = adInteractionListener3;
                _er _erVar = _dnVar._h;
                if (_erVar != null) {
                    _erVar._a(adInteractionListener3);
                }
                _gu _guVar = _dnVar._i;
                if (_guVar != null) {
                    _guVar._e = adInteractionListener3;
                }
                this._d.getClass();
                return;
            }
            return;
        }
        _dp _dpVar = this._e;
        if (_dpVar != null) {
            _dpVar.setExpressInteractionListener(this._c);
            _dp _dpVar2 = this._e;
            _h _hVar2 = _dpVar2._c;
            if (_hVar2 == null) {
                _dp._a _aVar2 = _dpVar2._N;
                if (_aVar2 == null) {
                    return;
                }
                adErrorImpl = new AdErrorImpl(PtgErrorCode.SDK_RENDER_ERROR, PtgErrorCode.SDK_RENDER_ERROR_6, (Object) null);
                adErrorImpl._c = PtgApiProvider.providerName;
                adErrorImpl._d = PtgErrorCode.SDK_RENDER_ERROR;
                adErrorImpl._e = PtgErrorCode.SDK_RENDER_ERROR_6;
                adInteractionListener = _aVar2._a._a;
                if (adInteractionListener == null) {
                    return;
                }
            } else {
                int i = _hVar2._y;
                ConcurrentHashMap<String, Long> concurrentHashMap = _ib._a;
                float f2 = 0.66f;
                if (i == 8) {
                    String str_j = _hVar2._j();
                    if (!TextUtils.isEmpty(str_j)) {
                        if (AdConstant.NATIVE_TYPE.TOP_TEXT.equals(str_j)) {
                            _adVar = new _gz(_dpVar2.getContext());
                        } else if (AdConstant.NATIVE_TYPE.TOP_IMAGE.equals(str_j)) {
                            _adVar = new _gy(_dpVar2.getContext());
                        } else if (AdConstant.NATIVE_TYPE.TEXT_FLOAT.equals(str_j)) {
                            _adVar = new _gw(_dpVar2.getContext());
                        } else {
                            if (AdConstant.NATIVE_TYPE.LEFT_IMAGE.equals(str_j)) {
                                _adVar = new _gs(_dpVar2.getContext());
                            } else if (AdConstant.NATIVE_TYPE.LEFT_TEXT.equals(str_j)) {
                                _adVar = new _gt(_dpVar2.getContext());
                            } else {
                                if (AdConstant.NATIVE_TYPE.THREE_IMAGES.equals(str_j)) {
                                    _adVar = new _gx(_dpVar2.getContext());
                                }
                                _dpVar2._G = _adVar;
                                if (_adVar != null) {
                                    _dpVar2._H = true;
                                    _dpVar2._G.setVideoProgressListener(_dpVar2._E);
                                    _dpVar2._G.setVideoStateListener(_dpVar2._F);
                                    _dpVar2._G.setOnErrorListener(_dpVar2._D);
                                    _dpVar2._G.setOnCompletionListener(_dpVar2._C);
                                    _dpVar2._G.setExpressAdInteractionListener(_dpVar2._N);
                                    _dpVar2._G.setAdvertSlot(_dpVar2._d);
                                    _dpVar2._G.setAd(_dpVar2._c);
                                    layoutParams = _dpVar2._G.getLayoutParams();
                                    if (layoutParams == null) {
                                        layoutParams = new FrameLayout.LayoutParams(-1, -2);
                                    }
                                    _dpVar2._G.setLayoutParams(layoutParams);
                                    _m1._a(_dpVar2, _dpVar2._G.getAdRootView(), null);
                                    _dpVar2.addView(_dpVar2._G);
                                    return;
                                }
                                _aVar = _dpVar2._N;
                                if (_aVar == null) {
                                    return;
                                }
                                adErrorImpl = new AdErrorImpl(PtgErrorCode.SDK_RENDER_ERROR, PtgErrorCode.SDK_RENDER_ERROR_8, (Object) null);
                                adErrorImpl._c = PtgApiProvider.providerName;
                                adErrorImpl._d = PtgErrorCode.SDK_RENDER_ERROR;
                                adErrorImpl._e = PtgErrorCode.SDK_RENDER_ERROR_8;
                                adInteractionListener = _aVar._a._a;
                                if (adInteractionListener == null) {
                                    return;
                                }
                            }
                            _adVar.setNativeRatio(f2);
                            _dpVar2._G = _adVar;
                            if (_adVar != null) {
                                _dpVar2._H = true;
                                _dpVar2._G.setVideoProgressListener(_dpVar2._E);
                                _dpVar2._G.setVideoStateListener(_dpVar2._F);
                                _dpVar2._G.setOnErrorListener(_dpVar2._D);
                                _dpVar2._G.setOnCompletionListener(_dpVar2._C);
                                _dpVar2._G.setExpressAdInteractionListener(_dpVar2._N);
                                _dpVar2._G.setAdvertSlot(_dpVar2._d);
                                _dpVar2._G.setAd(_dpVar2._c);
                                layoutParams = _dpVar2._G.getLayoutParams();
                                if (layoutParams == null) {
                                    layoutParams = new FrameLayout.LayoutParams(-1, -2);
                                }
                                _dpVar2._G.setLayoutParams(layoutParams);
                                _m1._a(_dpVar2, _dpVar2._G.getAdRootView(), null);
                                _dpVar2.addView(_dpVar2._G);
                                return;
                            }
                            _aVar = _dpVar2._N;
                            if (_aVar == null) {
                                return;
                            }
                            adErrorImpl = new AdErrorImpl(PtgErrorCode.SDK_RENDER_ERROR, PtgErrorCode.SDK_RENDER_ERROR_8, (Object) null);
                            adErrorImpl._c = PtgApiProvider.providerName;
                            adErrorImpl._d = PtgErrorCode.SDK_RENDER_ERROR;
                            adErrorImpl._e = PtgErrorCode.SDK_RENDER_ERROR_8;
                            adInteractionListener = _aVar._a._a;
                            if (adInteractionListener == null) {
                                return;
                            }
                        }
                        f = 0.55f;
                        _adVar.setNativeRatio(f);
                        _dpVar2._G = _adVar;
                        if (_adVar != null) {
                            _dpVar2._H = true;
                            _dpVar2._G.setVideoProgressListener(_dpVar2._E);
                            _dpVar2._G.setVideoStateListener(_dpVar2._F);
                            _dpVar2._G.setOnErrorListener(_dpVar2._D);
                            _dpVar2._G.setOnCompletionListener(_dpVar2._C);
                            _dpVar2._G.setExpressAdInteractionListener(_dpVar2._N);
                            _dpVar2._G.setAdvertSlot(_dpVar2._d);
                            _dpVar2._G.setAd(_dpVar2._c);
                            layoutParams = _dpVar2._G.getLayoutParams();
                            if (layoutParams == null) {
                                layoutParams = new FrameLayout.LayoutParams(-1, -2);
                            }
                            _dpVar2._G.setLayoutParams(layoutParams);
                            _m1._a(_dpVar2, _dpVar2._G.getAdRootView(), null);
                            _dpVar2.addView(_dpVar2._G);
                            return;
                        }
                        _aVar = _dpVar2._N;
                        if (_aVar == null) {
                            return;
                        }
                        adErrorImpl = new AdErrorImpl(PtgErrorCode.SDK_RENDER_ERROR, PtgErrorCode.SDK_RENDER_ERROR_8, (Object) null);
                        adErrorImpl._c = PtgApiProvider.providerName;
                        adErrorImpl._d = PtgErrorCode.SDK_RENDER_ERROR;
                        adErrorImpl._e = PtgErrorCode.SDK_RENDER_ERROR_8;
                        adInteractionListener = _aVar._a._a;
                        if (adInteractionListener == null) {
                            return;
                        }
                    }
                    _adVar = null;
                    _dpVar2._G = _adVar;
                    if (_adVar != null) {
                        _dpVar2._H = true;
                        _dpVar2._G.setVideoProgressListener(_dpVar2._E);
                        _dpVar2._G.setVideoStateListener(_dpVar2._F);
                        _dpVar2._G.setOnErrorListener(_dpVar2._D);
                        _dpVar2._G.setOnCompletionListener(_dpVar2._C);
                        _dpVar2._G.setExpressAdInteractionListener(_dpVar2._N);
                        _dpVar2._G.setAdvertSlot(_dpVar2._d);
                        _dpVar2._G.setAd(_dpVar2._c);
                        layoutParams = _dpVar2._G.getLayoutParams();
                        if (layoutParams == null) {
                            layoutParams = new FrameLayout.LayoutParams(-1, -2);
                        }
                        _dpVar2._G.setLayoutParams(layoutParams);
                        _m1._a(_dpVar2, _dpVar2._G.getAdRootView(), null);
                        _dpVar2.addView(_dpVar2._G);
                        return;
                    }
                    _aVar = _dpVar2._N;
                    if (_aVar == null) {
                        return;
                    }
                    adErrorImpl = new AdErrorImpl(PtgErrorCode.SDK_RENDER_ERROR, PtgErrorCode.SDK_RENDER_ERROR_8, (Object) null);
                    adErrorImpl._c = PtgApiProvider.providerName;
                    adErrorImpl._d = PtgErrorCode.SDK_RENDER_ERROR;
                    adErrorImpl._e = PtgErrorCode.SDK_RENDER_ERROR_8;
                    adInteractionListener = _aVar._a._a;
                    if (adInteractionListener == null) {
                        return;
                    }
                } else {
                    if (i == 5) {
                        AdSlot adSlot = _dpVar2._d;
                        String str_j2 = _hVar2._j();
                        if (TextUtils.isEmpty(str_j2)) {
                            _adVar = null;
                        } else {
                            float expressViewAcceptedWidth = adSlot.getExpressViewAcceptedWidth();
                            float expressViewAcceptedHeight = adSlot.getExpressViewAcceptedHeight();
                            if (expressViewAcceptedWidth <= 0.0f || expressViewAcceptedHeight <= 0.0f) {
                                if ("501".equals(str_j2)) {
                                    _adVar = new _af(_dpVar2.getContext());
                                    f2 = 0.5f;
                                } else if ("502".equals(str_j2)) {
                                    _adVar = new _af(_dpVar2.getContext());
                                } else if ("503".equals(str_j2)) {
                                    _adVar = new _af(_dpVar2.getContext());
                                    f2 = 0.83f;
                                } else if ("504".equals(str_j2)) {
                                    _adVar = new _ae(_dpVar2.getContext());
                                } else if ("505".equals(str_j2)) {
                                    _adVar = new _ac(_dpVar2.getContext());
                                } else if ("506".equals(str_j2)) {
                                    _adVar = new _ac(_dpVar2.getContext());
                                    f2 = 0.57f;
                                } else if ("507".equals(str_j2)) {
                                    _adVar = new _ad(_dpVar2.getContext());
                                    f = 0.56f;
                                    _adVar.setNativeRatio(f);
                                } else {
                                    _adVar = null;
                                }
                                _adVar.setNativeRatio(f2);
                            } else {
                                _adVar = new _ab(_dpVar2.getContext());
                                _adVar.setAdLayoutParams(adSlot);
                            }
                        }
                        _dpVar2._G = _adVar;
                        if (_adVar != null) {
                            _dpVar2._H = true;
                            _dpVar2._G.setVideoProgressListener(_dpVar2._E);
                            _dpVar2._G.setVideoStateListener(_dpVar2._F);
                            _dpVar2._G.setOnErrorListener(_dpVar2._D);
                            _dpVar2._G.setOnCompletionListener(_dpVar2._C);
                            _dpVar2._G.setExpressAdInteractionListener(_dpVar2._N);
                            _dpVar2._G.setAdvertSlot(_dpVar2._d);
                            _dpVar2._G.setAd(_dpVar2._c);
                            layoutParams = _dpVar2._G.getLayoutParams();
                            if (layoutParams == null) {
                                layoutParams = new FrameLayout.LayoutParams(-1, -2);
                            }
                            _dpVar2._G.setLayoutParams(layoutParams);
                            _m1._a(_dpVar2, _dpVar2._G.getAdRootView(), null);
                            _dpVar2.addView(_dpVar2._G);
                            return;
                        }
                        _aVar = _dpVar2._N;
                        if (_aVar == null) {
                            return;
                        }
                        adErrorImpl = new AdErrorImpl(PtgErrorCode.SDK_RENDER_ERROR, PtgErrorCode.SDK_RENDER_ERROR_8, (Object) null);
                        adErrorImpl._c = PtgApiProvider.providerName;
                        adErrorImpl._d = PtgErrorCode.SDK_RENDER_ERROR;
                        adErrorImpl._e = PtgErrorCode.SDK_RENDER_ERROR_8;
                        adInteractionListener = _aVar._a._a;
                        if (adInteractionListener == null) {
                            return;
                        }
                    } else {
                        _dp._a _aVar3 = _dpVar2._N;
                        if (_aVar3 == null) {
                            return;
                        }
                        adErrorImpl = new AdErrorImpl(PtgErrorCode.SDK_RENDER_ERROR, PtgErrorCode.SDK_RENDER_ERROR_7, (Object) null);
                        adErrorImpl._c = PtgApiProvider.providerName;
                        adErrorImpl._d = PtgErrorCode.SDK_RENDER_ERROR;
                        adErrorImpl._e = PtgErrorCode.SDK_RENDER_ERROR_7;
                        adInteractionListener = _aVar3._a._a;
                        if (adInteractionListener == null) {
                            return;
                        }
                    }
                }
            }
            adInteractionListener.onRenderFail(adErrorImpl);
        }
    }

    @Override // com.kc.aw.lib.interf.PtgAd
    public final void setAdFilterAdapter(_l _lVar) {
    }

    @Override // com.kc.aw.lib.interf.PtgNativeExpressAd
    public final void setCanInterruptVideoPlay(boolean z) {
    }

    @Override // com.kc.aw.lib.interf.PtgNativeExpressAd
    @Deprecated
    public final void setDownloadListener(PtgAppDownloadListener ptgAppDownloadListener) {
    }

    @Override // com.kc.aw.lib.interf.PtgNativeExpressAd
    public final void setExpressInteractionListener(PtgNativeExpressAd.AdInteractionListener adInteractionListener) {
        this._c = adInteractionListener;
        if (!this._a.isSelfRender()) {
            _dp _dpVar = this._e;
            if (_dpVar != null) {
                _dpVar.setExpressInteractionListener(adInteractionListener);
                return;
            }
            return;
        }
        _dn _dnVar = this._d;
        if (_dnVar != null) {
            _dnVar._a = adInteractionListener;
            _er _erVar = _dnVar._h;
            if (_erVar != null) {
                _erVar._a(adInteractionListener);
            }
            _gu _guVar = _dnVar._i;
            if (_guVar != null) {
                _guVar._e = adInteractionListener;
            }
        }
    }

    @Override // com.kc.aw.lib.interf.PtgNativeExpressAd
    public final void setExpressViewColor(String str) {
        AdSlot adSlot = this._a;
        if (adSlot != null) {
            adSlot.setExpressViewColor(str);
        }
        _dp _dpVar = this._e;
        if (_dpVar != null) {
            _dpVar.setExpressViewColor(str);
        }
    }

    @Override // com.kc.aw.lib.interf.PtgNativeExpressAd
    public final void setSlideIntervalTime(int i) {
    }

    @Override // com.kc.aw.lib.interf.PtgNativeExpressAd
    public final void setVideoAdListener(PtgVideoAdListener ptgVideoAdListener) {
        _er _erVar;
        if (!this._a.isSelfRender()) {
            _dp _dpVar = this._e;
            if (_dpVar != null) {
                _dpVar.setVideoAdListener(ptgVideoAdListener);
                return;
            }
            return;
        }
        _dn _dnVar = this._d;
        if (_dnVar == null || (_erVar = _dnVar._h) == null) {
            return;
        }
        _erVar.setVideoAdListener(ptgVideoAdListener);
    }

    @Override // com.kc.aw.lib.interf.PtgNativeExpressAd
    public final void showInteractionExpressAd(Activity activity) {
    }

    @Override // com.kc.aw.lib.interf.PtgNativeExpressAd
    public final void startVideo() {
        _dn _dnVar;
        _er _erVar;
        if (!this._a.isSelfRender() || (_dnVar = this._d) == null || (_erVar = _dnVar._h) == null) {
            return;
        }
        _erVar.startVideo();
    }
}
