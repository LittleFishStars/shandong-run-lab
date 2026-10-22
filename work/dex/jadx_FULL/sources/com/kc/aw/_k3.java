package com.kc.aw;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.kc.aw.lib.constants.PtgErrorCode;
import com.kc.aw.lib.core.model.AdErrorImpl;
import com.kc.aw.lib.interf.NativeAdvertData;
import com.kc.aw.lib.interf.PtgAppDownloadListener;
import com.kc.aw.lib.interf.PtgSplashAd;
import com.kc.aw.lib.model.AdBidLossReason;
import com.kc.aw.lib.model.AdSlot;
import com.kc.aw.lib.provider.PtgAdNative;
import com.kc.aw.provider.PtgApiProvider;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _k3 implements PtgSplashAd {
    public _mz _a;
    public _h _b;
    public AdSlot _c;

    public _k3(Context context, PtgAdNative.SplashAdListener splashAdListener) {
        _a(context, splashAdListener);
    }

    public final void _a(Context context, PtgAdNative.SplashAdListener splashAdListener) {
        _mz _mzVar = new _mz(context);
        this._a = _mzVar;
        _mzVar.setAdListener(splashAdListener);
    }

    public final void _a(List<_h> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        this._b = list.get(0);
        ViewGroup adContainer = this._c.getAdContainer();
        if (adContainer == null) {
            adContainer = this._c.getOriginalAdContainer();
        }
        this._a._a(this._b, adContainer, null);
    }

    @Override // com.kc.aw.lib.interf.PtgAd
    public final void destroy() {
    }

    @Override // com.kc.aw.lib.interf.PtgAd
    public final _l getAdFilterAdapter() {
        return null;
    }

    @Override // com.kc.aw.lib.interf.PtgAd
    public final String getAdId() {
        return null;
    }

    @Override // com.kc.aw.lib.interf.PtgSplashAd
    public final NativeAdvertData getAdvertData() {
        return _hz._a(6, false, this._b);
    }

    @Override // com.kc.aw.lib.interf.PtgAd
    public final String getConsumer() {
        return PtgApiProvider.providerName;
    }

    @Override // com.kc.aw.lib.interf.PtgAd
    public final long getEcpm() {
        _h _hVar = this._b;
        if (_hVar != null) {
            return _hVar._l;
        }
        return 0L;
    }

    @Override // com.kc.aw.lib.interf.PtgAd
    public final int getInteractionType() {
        int i = this._b._a;
        if (i == 0) {
            return 0;
        }
        if (i != 1) {
            return i != 2 ? -1 : 3;
        }
        return 1;
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

    @Override // com.kc.aw.lib.interf.PtgSplashAd
    public final void load() {
        _mz _mzVar = this._a;
        if (_mzVar != null) {
            _mzVar.setAdSlot(this._c);
        }
    }

    @Override // com.kc.aw.lib.interf.PtgAd
    public final void notifyBidLoss(AdBidLossReason adBidLossReason) {
    }

    @Override // com.kc.aw.lib.interf.PtgAd
    public final void notifyBidWin(double d, double d2) {
    }

    @Override // com.kc.aw.lib.interf.PtgSplashAd
    public final void preload() {
        _i6 _i6Var;
        _mz _mzVar = this._a;
        if (_mzVar != null) {
            _i4 _i4Var = _i4._c._a;
            _h _hVar = _mzVar._m;
            _n1 _n1Var = new _n1(_mzVar);
            _i4Var.getClass();
            if (_hVar != null) {
                try {
                    _i6Var = _hVar._z;
                } catch (Exception e) {
                    e.getMessage();
                    return;
                }
            } else {
                _i6Var = null;
            }
            if (_i6Var != null) {
                if (_i6Var._a()) {
                    _k8 _k8Var = _i6Var._f;
                    String str = _k8Var._b;
                    if (TextUtils.isEmpty(str)) {
                        _i4Var._a(_k8Var._a, true, _n1Var);
                        return;
                    } else {
                        _i4Var._a(str, false, _n1Var);
                        return;
                    }
                }
                List<_j9> list = _i6Var._e;
                if (list == null || list.isEmpty()) {
                    return;
                }
                int size = list.size();
                int i = 0;
                while (i < size) {
                    _i4Var._a(list.get(i)._a, false, i == 0 ? _n1Var : null);
                    i++;
                }
            }
        }
    }

    @Override // com.kc.aw.lib.interf.PtgAd
    public final void setAdFilterAdapter(_l _lVar) {
    }

    @Override // com.kc.aw.lib.interf.PtgSplashAd
    public final void setDownloadListener(PtgAppDownloadListener ptgAppDownloadListener) {
        _mz _mzVar = this._a;
        if (_mzVar != null) {
            _mzVar.setDownloadListener(ptgAppDownloadListener);
        }
    }

    @Override // com.kc.aw.lib.interf.PtgSplashAd
    public final void setSplashInteractionListener(PtgSplashAd.AdInteractionListener adInteractionListener) {
        _mz _mzVar = this._a;
        if (_mzVar != null) {
            _mzVar.setAdInteractionListener(adInteractionListener);
        }
    }

    @Override // com.kc.aw.lib.interf.PtgSplashAd
    public final void showAd(ViewGroup viewGroup) {
        showAd(viewGroup, viewGroup.getContext() instanceof Activity ? (Activity) viewGroup.getContext() : null);
    }

    @Override // com.kc.aw.lib.interf.PtgSplashAd
    public final void showAd(ViewGroup viewGroup, Activity activity) {
        _h _hVar = this._b;
        if (_hVar == null) {
            PtgSplashAd.AdInteractionListener adInteractionListener = this._a.getAdInteractionListener();
            if (adInteractionListener != null) {
                AdErrorImpl adErrorImpl = new AdErrorImpl();
                adErrorImpl._c = PtgApiProvider.providerName;
                adErrorImpl._d = PtgErrorCode.SDK_RENDER_ERROR;
                adErrorImpl._e = "because ad is null.";
                adErrorImpl._a = PtgErrorCode.SDK_RENDER_ERROR;
                adErrorImpl._b = "because ad is null.";
                adInteractionListener.onRenderError(adErrorImpl);
                return;
            }
            return;
        }
        if (!_hVar._r()) {
            PtgSplashAd.AdInteractionListener adInteractionListener2 = this._a.getAdInteractionListener();
            if (adInteractionListener2 != null) {
                AdErrorImpl adErrorImpl2 = new AdErrorImpl();
                adErrorImpl2._c = PtgApiProvider.providerName;
                adErrorImpl2._d = PtgErrorCode.SDK_RENDER_ERROR;
                adErrorImpl2._e = PtgErrorCode.SDK_RENDER_ERROR_5;
                adErrorImpl2._a = PtgErrorCode.SDK_RENDER_ERROR;
                adErrorImpl2._b = PtgErrorCode.SDK_RENDER_ERROR_5;
                adInteractionListener2.onRenderError(adErrorImpl2);
                return;
            }
            return;
        }
        if (this._c == null) {
            PtgSplashAd.AdInteractionListener adInteractionListener3 = this._a.getAdInteractionListener();
            if (adInteractionListener3 != null) {
                AdErrorImpl adErrorImpl3 = new AdErrorImpl();
                adErrorImpl3._c = PtgApiProvider.providerName;
                adErrorImpl3._d = PtgErrorCode.SDK_RENDER_ERROR;
                adErrorImpl3._e = "because adSlot is null.";
                adErrorImpl3._a = PtgErrorCode.SDK_RENDER_ERROR;
                adErrorImpl3._b = "because adSlot is null.";
                adInteractionListener3.onRenderError(adErrorImpl3);
                return;
            }
            return;
        }
        _mz _mzVar = this._a;
        if (_mzVar != null) {
            if (_mzVar.getParent() == null) {
                this._a._a(this._b, viewGroup, activity);
                viewGroup.addView(this._a);
                return;
            }
            PtgSplashAd.AdInteractionListener adInteractionListener4 = this._a.getAdInteractionListener();
            if (adInteractionListener4 != null) {
                AdErrorImpl adErrorImpl4 = new AdErrorImpl();
                adErrorImpl4._c = PtgApiProvider.providerName;
                adErrorImpl4._d = PtgErrorCode.SDK_RENDER_ERROR;
                adErrorImpl4._e = "The ad has already been rendered. Please destroy it and try again.";
                adErrorImpl4._a = PtgErrorCode.SDK_RENDER_ERROR;
                adErrorImpl4._b = "The ad has already been rendered. Please destroy it and try again.";
                adInteractionListener4.onRenderError(adErrorImpl4);
            }
        }
    }
}
