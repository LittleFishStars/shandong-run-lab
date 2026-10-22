package com.kc.aw;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.kc.aw.lib.PtgAdSdk;
import com.kc.aw.lib.interf.NativeAdvertData;
import com.kc.aw.lib.interf.PtgAppDownloadListener;
import com.kc.aw.lib.interf.PtgNativeExpressAd;
import com.kc.aw.lib.interf.PtgVideoAdListener;
import com.kc.aw.lib.model.AdBidLossReason;
import com.kc.aw.lib.model.AdError;
import com.kc.aw.lib.model.AdSlot;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _ir implements PtgNativeExpressAd {
    public AdSlot _a;
    public PtgNativeExpressAd _b;
    public _nr _c;

    @Keep
    public final class _a implements PtgNativeExpressAd.AdInteractionListener {
        public final PtgNativeExpressAd.AdInteractionListener _a;
        public final _ir _b;

        public _a(_ir _irVar, PtgNativeExpressAd.AdInteractionListener adInteractionListener) {
            this._b = _irVar;
            this._a = adInteractionListener;
        }

        @Override // com.kc.aw.lib.interf.PtgNativeExpressAd.ExpressAdInteractionListener
        public final void onAdClicked() {
            _ir _irVar = this._b;
            _nr _nrVar = _irVar._c;
            if (_nrVar != null) {
                _nrVar._t._b(_irVar._a.getCt());
            }
            _nt._a()._a(this._b._a.getDispatchPolicyCustomerItem()._d(), "inAppClick", this._b._c, null);
            if (!Boolean.parseBoolean(this._b._c._b())) {
                this._a.onAdClicked();
                return;
            }
            _nr _nrVar2 = this._b._c;
            synchronized (_nrVar2._s) {
                if (!TextUtils.isEmpty("iReportM")) {
                    _nrVar2._s.put("iReportM", String.valueOf(false));
                }
            }
        }

        @Override // com.kc.aw.lib.interf.PtgNativeExpressAd.ExpressAdInteractionListener
        public final void onAdDismiss() {
            this._a.onAdDismiss();
        }

        @Override // com.kc.aw.lib.interf.PtgNativeExpressAd.ExpressAdInteractionListener
        public final void onAdShow() {
            _ir _irVar = this._b;
            if (_irVar._b != null && _irVar._c._p) {
                _nt._a()._a(this._b._a.getDispatchPolicyCustomerItem()._g(), "inAppImp", this._b._c, null);
                this._b._c._p = false;
                this._a.onAdShow();
            }
        }

        @Override // com.kc.aw.lib.interf.PtgNativeExpressAd.ExpressAdInteractionListener
        public final void onRenderFail(AdError adError) {
            AdSlot adSlot;
            _ir _irVar = this._b;
            if (_irVar._c != null && (adSlot = _irVar._a) != null && adSlot.getDispatchPolicyCustomerItem() != null) {
                this._b._c._a(adError);
                _nt._a()._a(this._b._a.getDispatchPolicyCustomerItem()._f(), "inAppErr", this._b._c, null);
            }
            this._a.onRenderFail(adError);
        }

        @Override // com.kc.aw.lib.interf.PtgNativeExpressAd.ExpressAdInteractionListener
        public final void onRenderSuccess(View view) {
            this._a.onRenderSuccess(view);
        }
    }

    @Keep
    public final class _b implements Runnable {
        public final _ir _a;

        public _b(_ir _irVar) {
            this._a = _irVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            PtgNativeExpressAd ptgNativeExpressAd = this._a._b;
            if (ptgNativeExpressAd != null) {
                ptgNativeExpressAd.destroy();
                this._a._b = null;
            }
        }
    }

    public _ir(PtgNativeExpressAd ptgNativeExpressAd, AdSlot adSlot, _nr _nrVar) {
        this._b = ptgNativeExpressAd;
        this._a = adSlot;
        this._c = _nrVar;
    }

    @Override // com.kc.aw.lib.interf.PtgNativeExpressAd, com.kc.aw.lib.interf.PtgAd
    public final void destroy() {
        com.kc.aw.lib.utils._d._c(new _b(this));
    }

    @Override // com.kc.aw.lib.interf.PtgAd
    public final _l getAdFilterAdapter() {
        PtgNativeExpressAd ptgNativeExpressAd = this._b;
        if (ptgNativeExpressAd == null) {
            return null;
        }
        return ptgNativeExpressAd.getAdFilterAdapter();
    }

    @Override // com.kc.aw.lib.interf.PtgAd
    public final String getAdId() {
        PtgNativeExpressAd ptgNativeExpressAd = this._b;
        return ptgNativeExpressAd == null ? "" : ptgNativeExpressAd.getAdId();
    }

    @Override // com.kc.aw.lib.interf.PtgNativeExpressAd
    public final NativeAdvertData getAdvertData() {
        PtgNativeExpressAd ptgNativeExpressAd = this._b;
        if (ptgNativeExpressAd == null) {
            return null;
        }
        return ptgNativeExpressAd.getAdvertData();
    }

    @Override // com.kc.aw.lib.interf.PtgAd
    public final String getConsumer() {
        PtgNativeExpressAd ptgNativeExpressAd = this._b;
        return ptgNativeExpressAd == null ? "" : ptgNativeExpressAd.getConsumer();
    }

    @Override // com.kc.aw.lib.interf.PtgNativeExpressAd
    public final PtgNativeExpressAd.CustomizeVideo getCustomizeVideo() {
        PtgNativeExpressAd ptgNativeExpressAd = this._b;
        if (ptgNativeExpressAd == null) {
            return null;
        }
        return ptgNativeExpressAd.getCustomizeVideo();
    }

    @Override // com.kc.aw.lib.interf.PtgAd
    public final long getEcpm() {
        PtgNativeExpressAd ptgNativeExpressAd = this._b;
        if (ptgNativeExpressAd != null) {
            return ptgNativeExpressAd.getEcpm();
        }
        return 0L;
    }

    @Override // com.kc.aw.lib.interf.PtgNativeExpressAd
    public final View getExpressAdView() {
        PtgNativeExpressAd ptgNativeExpressAd = this._b;
        if (ptgNativeExpressAd == null) {
            return null;
        }
        return ptgNativeExpressAd.getExpressAdView();
    }

    @Override // com.kc.aw.lib.interf.PtgNativeExpressAd
    public final List<Object> getFilterWords() {
        PtgNativeExpressAd ptgNativeExpressAd = this._b;
        if (ptgNativeExpressAd == null) {
            return null;
        }
        return ptgNativeExpressAd.getFilterWords();
    }

    @Override // com.kc.aw.lib.interf.PtgNativeExpressAd
    public final int getImageMode() {
        PtgNativeExpressAd ptgNativeExpressAd = this._b;
        if (ptgNativeExpressAd == null) {
            return -1;
        }
        return ptgNativeExpressAd.getImageMode();
    }

    @Override // com.kc.aw.lib.interf.PtgAd
    public final int getInteractionType() {
        PtgNativeExpressAd ptgNativeExpressAd = this._b;
        if (ptgNativeExpressAd == null) {
            return -1;
        }
        return ptgNativeExpressAd.getInteractionType();
    }

    @Override // com.kc.aw.lib.interf.PtgNativeExpressAd
    public final Map<String, Object> getMediaExtraInfo() {
        PtgNativeExpressAd ptgNativeExpressAd = this._b;
        if (ptgNativeExpressAd == null) {
            return null;
        }
        return ptgNativeExpressAd.getMediaExtraInfo();
    }

    @Override // com.kc.aw.lib.interf.PtgNativeExpressAd
    public final View getMediaView() {
        PtgNativeExpressAd ptgNativeExpressAd = this._b;
        if (ptgNativeExpressAd == null) {
            return null;
        }
        return ptgNativeExpressAd.getMediaView();
    }

    @Override // com.kc.aw.lib.interf.PtgAd
    public final boolean isReady() {
        PtgNativeExpressAd ptgNativeExpressAd = this._b;
        if (ptgNativeExpressAd == null) {
            return false;
        }
        return ptgNativeExpressAd.isReady();
    }

    @Override // com.kc.aw.lib.interf.PtgAd
    public final boolean isResourceLoaded() {
        PtgNativeExpressAd ptgNativeExpressAd = this._b;
        if (ptgNativeExpressAd == null) {
            return false;
        }
        return ptgNativeExpressAd.isResourceLoaded();
    }

    @Override // com.kc.aw.lib.interf.PtgNativeExpressAd
    public final boolean isSelfRender() {
        PtgNativeExpressAd ptgNativeExpressAd = this._b;
        if (ptgNativeExpressAd == null) {
            return false;
        }
        return ptgNativeExpressAd.isSelfRender();
    }

    @Override // com.kc.aw.lib.interf.PtgNativeExpressAd
    public final boolean isVideo() {
        PtgNativeExpressAd ptgNativeExpressAd = this._b;
        if (ptgNativeExpressAd == null) {
            return false;
        }
        return ptgNativeExpressAd.isVideo();
    }

    @Override // com.kc.aw.lib.interf.PtgAd
    public final void notifyBidLoss(AdBidLossReason adBidLossReason) {
        _cl dispatchPolicyCustomerItem;
        AdSlot adSlot = this._a;
        if (adSlot != null && (dispatchPolicyCustomerItem = adSlot.getDispatchPolicyCustomerItem()) != null) {
            _nr _nrVar = new _nr(dispatchPolicyCustomerItem._c, dispatchPolicyCustomerItem._Q, this._a);
            _nrVar._o = dispatchPolicyCustomerItem._b;
            _nrVar._a(this._a.getCategoryType());
            _nq _nqVar = _nrVar._t;
            if (_nqVar != null) {
                _nqVar._f(dispatchPolicyCustomerItem._c);
                _nqVar._e(dispatchPolicyCustomerItem._Q);
                _nqVar._b(dispatchPolicyCustomerItem._h);
                _nqVar._a(dispatchPolicyCustomerItem._i);
                _nqVar._i(PtgAdSdk.getConfig()._a);
                _nqVar._n(this._a.getUserID());
                _nqVar._m(this._a.getPtgSlotID());
                _nqVar._c(dispatchPolicyCustomerItem._T);
                _nqVar._d(dispatchPolicyCustomerItem._e);
                if (adBidLossReason != null) {
                    _nqVar._d(adBidLossReason.getReason());
                }
            }
            _nt._a()._a(dispatchPolicyCustomerItem._J, "inAppBidLoss", _nrVar, null);
        }
        PtgNativeExpressAd ptgNativeExpressAd = this._b;
        if (ptgNativeExpressAd != null) {
            ptgNativeExpressAd.notifyBidLoss(adBidLossReason);
        }
    }

    @Override // com.kc.aw.lib.interf.PtgAd
    public final void notifyBidWin(double d, double d2) {
        _cl dispatchPolicyCustomerItem;
        AdSlot adSlot = this._a;
        if (adSlot != null && (dispatchPolicyCustomerItem = adSlot.getDispatchPolicyCustomerItem()) != null) {
            _nr _nrVar = new _nr(dispatchPolicyCustomerItem._c, dispatchPolicyCustomerItem._Q, this._a);
            _nrVar._o = dispatchPolicyCustomerItem._b;
            _nrVar._a(this._a.getCategoryType());
            _nq _nqVar = _nrVar._t;
            if (_nqVar != null) {
                _nqVar._f(dispatchPolicyCustomerItem._c);
                _nqVar._e(dispatchPolicyCustomerItem._Q);
                _nqVar._b(dispatchPolicyCustomerItem._h);
                _nqVar._a(dispatchPolicyCustomerItem._i);
                _nqVar._i(PtgAdSdk.getConfig()._a);
                _nqVar._n(this._a.getUserID());
                _nqVar._m(this._a.getPtgSlotID());
                _nqVar._c(dispatchPolicyCustomerItem._T);
                _nqVar._d(dispatchPolicyCustomerItem._e);
                _nqVar._a(d);
                _nqVar._b(d2);
            }
            _nt._a()._a(dispatchPolicyCustomerItem._K, "inAppBidWin", _nrVar, null);
        }
        PtgNativeExpressAd ptgNativeExpressAd = this._b;
        if (ptgNativeExpressAd != null) {
            ptgNativeExpressAd.notifyBidWin(d, d2);
        }
    }

    @Override // com.kc.aw.lib.interf.PtgNativeExpressAd
    public final void pauseVideo() {
        PtgNativeExpressAd ptgNativeExpressAd = this._b;
        if (ptgNativeExpressAd == null) {
            return;
        }
        ptgNativeExpressAd.pauseVideo();
    }

    @Override // com.kc.aw.lib.interf.PtgNativeExpressAd
    public final void registerAdvertViews(ViewGroup viewGroup, List<View> list, List<View> list2, View view) {
        PtgNativeExpressAd ptgNativeExpressAd = this._b;
        if (ptgNativeExpressAd != null) {
            ptgNativeExpressAd.registerAdvertViews(viewGroup, list, list2, view);
        }
    }

    @Override // com.kc.aw.lib.interf.PtgNativeExpressAd
    public final void render() {
        PtgNativeExpressAd ptgNativeExpressAd = this._b;
        if (ptgNativeExpressAd == null) {
            return;
        }
        ptgNativeExpressAd.render();
    }

    @Override // com.kc.aw.lib.interf.PtgAd
    public final void setAdFilterAdapter(_l _lVar) {
        PtgNativeExpressAd ptgNativeExpressAd = this._b;
        if (ptgNativeExpressAd == null) {
            return;
        }
        ptgNativeExpressAd.setAdFilterAdapter(_lVar);
    }

    @Override // com.kc.aw.lib.interf.PtgNativeExpressAd
    public final void setCanInterruptVideoPlay(boolean z) {
        PtgNativeExpressAd ptgNativeExpressAd = this._b;
        if (ptgNativeExpressAd == null) {
            return;
        }
        ptgNativeExpressAd.setCanInterruptVideoPlay(z);
    }

    @Override // com.kc.aw.lib.interf.PtgNativeExpressAd
    public final void setDownloadListener(PtgAppDownloadListener ptgAppDownloadListener) {
        PtgNativeExpressAd ptgNativeExpressAd = this._b;
        if (ptgNativeExpressAd == null) {
            return;
        }
        ptgNativeExpressAd.setDownloadListener(ptgAppDownloadListener);
    }

    @Override // com.kc.aw.lib.interf.PtgNativeExpressAd
    public final void setExpressInteractionListener(PtgNativeExpressAd.AdInteractionListener adInteractionListener) {
        PtgNativeExpressAd ptgNativeExpressAd = this._b;
        if (ptgNativeExpressAd == null) {
            return;
        }
        ptgNativeExpressAd.setExpressInteractionListener(new _a(this, adInteractionListener));
    }

    @Override // com.kc.aw.lib.interf.PtgNativeExpressAd
    public final void setExpressViewColor(String str) {
        PtgNativeExpressAd ptgNativeExpressAd = this._b;
        if (ptgNativeExpressAd == null) {
            return;
        }
        ptgNativeExpressAd.setExpressViewColor(str);
    }

    @Override // com.kc.aw.lib.interf.PtgNativeExpressAd
    public final void setSlideIntervalTime(int i) {
        PtgNativeExpressAd ptgNativeExpressAd = this._b;
        if (ptgNativeExpressAd == null) {
            return;
        }
        ptgNativeExpressAd.setSlideIntervalTime(i);
    }

    @Override // com.kc.aw.lib.interf.PtgNativeExpressAd
    public final void setVideoAdListener(PtgVideoAdListener ptgVideoAdListener) {
        PtgNativeExpressAd ptgNativeExpressAd = this._b;
        if (ptgNativeExpressAd == null) {
            return;
        }
        ptgNativeExpressAd.setVideoAdListener(ptgVideoAdListener);
    }

    @Override // com.kc.aw.lib.interf.PtgNativeExpressAd
    public final void showInteractionExpressAd(Activity activity) {
        PtgNativeExpressAd ptgNativeExpressAd = this._b;
        if (ptgNativeExpressAd == null) {
            return;
        }
        ptgNativeExpressAd.showInteractionExpressAd(activity);
    }

    @Override // com.kc.aw.lib.interf.PtgNativeExpressAd
    public final void startVideo() {
        PtgNativeExpressAd ptgNativeExpressAd = this._b;
        if (ptgNativeExpressAd == null) {
            return;
        }
        ptgNativeExpressAd.startVideo();
    }
}
