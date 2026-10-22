package com.kc.aw;

import android.app.Activity;
import android.view.ViewGroup;
import com.kc.aw.lib.PtgAdSdk;
import com.kc.aw.lib.interf.NativeAdvertData;
import com.kc.aw.lib.interf.PtgAppDownloadListener;
import com.kc.aw.lib.interf.PtgSplashAd;
import com.kc.aw.lib.model.AdBidLossReason;
import com.kc.aw.lib.model.AdError;
import com.kc.aw.lib.model.AdSlot;
import com.kc.aw.lib.utils.Logger;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _j5 implements PtgSplashAd {
    public final AdSlot _a;
    public final PtgSplashAd _b;
    public final _nr _c;

    @Keep
    public final class _a implements PtgSplashAd.AdInteractionListener {
        public final PtgSplashAd.AdInteractionListener _a;
        public final _j5 _b;

        public _a(_j5 _j5Var, PtgSplashAd.AdInteractionListener adInteractionListener) {
            this._b = _j5Var;
            this._a = adInteractionListener;
        }

        @Override // com.kc.aw.lib.interf.PtgSplashAd.AdInteractionListener
        public final void onAdClicked() {
            _j5 _j5Var = this._b;
            _nr _nrVar = _j5Var._c;
            if (_nrVar != null) {
                _nrVar._t._b(_j5Var._a.getCt());
            }
            _nt._a()._a(this._b._a.getDispatchPolicyCustomerItem()._d(), "inAppClick", this._b._c, null);
            if (Boolean.parseBoolean(this._b._c._b())) {
                return;
            }
            this._a.onAdClicked();
        }

        @Override // com.kc.aw.lib.interf.PtgSplashAd.AdInteractionListener
        public final void onAdShow() {
            if (this._b._c._p) {
                _nt._a()._a(this._b._a.getDispatchPolicyCustomerItem()._g(), "inAppImp", this._b._c, null);
                this._b._c._p = false;
                this._a.onAdShow();
            }
        }

        @Override // com.kc.aw.lib.interf.PtgSplashAd.AdInteractionListener
        public final void onAdSkip() {
            this._a.onAdSkip();
        }

        @Override // com.kc.aw.lib.interf.PtgSplashAd.AdInteractionListener
        public final void onAdTimeOver() {
            this._a.onAdTimeOver();
        }

        @Override // com.kc.aw.lib.interf.PtgSplashAd.AdInteractionListener
        public final void onDismiss(int i) {
            this._a.onDismiss(i);
        }

        @Override // com.kc.aw.lib.interf.PtgSplashAd.AdInteractionListener
        public final void onRenderError(AdError adError) {
            AdSlot adSlot;
            _j5 _j5Var = this._b;
            if (_j5Var._c != null && (adSlot = _j5Var._a) != null && adSlot.getDispatchPolicyCustomerItem() != null) {
                this._b._c._a(adError);
                _nt._a()._a(this._b._a.getDispatchPolicyCustomerItem()._f(), "inAppErr", this._b._c, null);
            }
            this._a.onRenderError(adError);
        }

        @Override // com.kc.aw.lib.interf.PtgSplashAd.AdInteractionListener
        public final void onRenderSuccess() {
            this._a.onRenderSuccess();
        }
    }

    public _j5(PtgSplashAd ptgSplashAd, AdSlot adSlot, _nr _nrVar) {
        this._b = ptgSplashAd;
        this._a = adSlot;
        this._c = _nrVar;
    }

    @Override // com.kc.aw.lib.interf.PtgAd
    public final void destroy() {
        this._b.destroy();
    }

    @Override // com.kc.aw.lib.interf.PtgAd
    public final _l getAdFilterAdapter() {
        return this._b.getAdFilterAdapter();
    }

    @Override // com.kc.aw.lib.interf.PtgAd
    public final String getAdId() {
        return this._b.getAdId();
    }

    @Override // com.kc.aw.lib.interf.PtgSplashAd
    public final NativeAdvertData getAdvertData() {
        return this._b.getAdvertData();
    }

    @Override // com.kc.aw.lib.interf.PtgAd
    public final String getConsumer() {
        return this._b.getConsumer();
    }

    @Override // com.kc.aw.lib.interf.PtgAd
    public final long getEcpm() {
        PtgSplashAd ptgSplashAd = this._b;
        if (ptgSplashAd != null) {
            return ptgSplashAd.getEcpm();
        }
        return 0L;
    }

    @Override // com.kc.aw.lib.interf.PtgAd
    public final int getInteractionType() {
        return this._b.getInteractionType();
    }

    @Override // com.kc.aw.lib.interf.PtgAd
    public final boolean isReady() {
        return this._b.isReady();
    }

    @Override // com.kc.aw.lib.interf.PtgAd
    public final boolean isResourceLoaded() {
        return this._b.isResourceLoaded();
    }

    @Override // com.kc.aw.lib.interf.PtgSplashAd
    public final void load() {
        this._b.load();
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
        PtgSplashAd ptgSplashAd = this._b;
        if (ptgSplashAd != null) {
            ptgSplashAd.notifyBidLoss(adBidLossReason);
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
        PtgSplashAd ptgSplashAd = this._b;
        if (ptgSplashAd != null) {
            ptgSplashAd.notifyBidWin(d, d2);
        }
    }

    @Override // com.kc.aw.lib.interf.PtgSplashAd
    public final void preload() {
        PtgSplashAd ptgSplashAd = this._b;
        if (ptgSplashAd != null) {
            ptgSplashAd.preload();
        }
    }

    @Override // com.kc.aw.lib.interf.PtgAd
    public final void setAdFilterAdapter(_l _lVar) {
        this._b.setAdFilterAdapter(_lVar);
    }

    @Override // com.kc.aw.lib.interf.PtgSplashAd
    public final void setDownloadListener(PtgAppDownloadListener ptgAppDownloadListener) {
        this._b.setDownloadListener(ptgAppDownloadListener);
    }

    @Override // com.kc.aw.lib.interf.PtgSplashAd
    public final void setSplashInteractionListener(PtgSplashAd.AdInteractionListener adInteractionListener) {
        this._b.setSplashInteractionListener(new _a(this, adInteractionListener));
    }

    @Override // com.kc.aw.lib.interf.PtgSplashAd
    public final void showAd(ViewGroup viewGroup) {
        if (this._a.getAdContainer() != null) {
            Logger.e("SplashView showAd fail, slot already exists container.");
        } else if (viewGroup != null) {
            this._b.showAd(viewGroup);
        }
    }

    @Override // com.kc.aw.lib.interf.PtgSplashAd
    public final void showAd(ViewGroup viewGroup, Activity activity) {
        if (this._a.getAdContainer() != null) {
            Logger.e("SplashView showAd fail, slot already exists container.");
        } else if (viewGroup != null) {
            this._b.showAd(viewGroup, activity);
        }
    }
}
