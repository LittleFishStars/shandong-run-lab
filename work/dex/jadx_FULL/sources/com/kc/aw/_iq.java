package com.kc.aw;

import android.app.Activity;
import android.text.TextUtils;
import com.kc.aw.lib.PtgAdSdk;
import com.kc.aw.lib.interf.NativeAdvertData;
import com.kc.aw.lib.interf.PtgAppDownloadListener;
import com.kc.aw.lib.interf.PtgInteractionAd;
import com.kc.aw.lib.interf.PtgVideoAdListener;
import com.kc.aw.lib.model.AdBidLossReason;
import com.kc.aw.lib.model.AdError;
import com.kc.aw.lib.model.AdSlot;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _iq implements PtgInteractionAd {
    public final AdSlot _a;
    public final PtgInteractionAd _b;
    public final _nr _c;

    @Keep
    public final class _a implements PtgInteractionAd.AdInteractionListener {
        public final PtgInteractionAd.AdInteractionListener _a;
        public final _iq _b;

        public _a(_iq _iqVar, PtgInteractionAd.AdInteractionListener adInteractionListener) {
            this._b = _iqVar;
            this._a = adInteractionListener;
        }

        @Override // com.kc.aw.lib.interf.PtgInteractionAd.AdInteractionListener
        public final void onAdClicked() {
            _iq _iqVar = this._b;
            _nr _nrVar = _iqVar._c;
            if (_nrVar != null) {
                _nrVar._t._b(_iqVar._a.getCt());
            }
            _nt._a()._a(this._b._a.getDispatchPolicyCustomerItem()._d(), "inAppClick", this._b._c, null);
            _nr _nrVar2 = this._b._c;
            if (_nrVar2 != null) {
                String str_b = _nrVar2._b();
                if (!TextUtils.isEmpty(str_b) && Boolean.parseBoolean(str_b)) {
                    _nr _nrVar3 = this._b._c;
                    synchronized (_nrVar3._s) {
                        if (!TextUtils.isEmpty("iReportM")) {
                            _nrVar3._s.put("iReportM", String.valueOf(false));
                        }
                    }
                    return;
                }
            }
            PtgInteractionAd.AdInteractionListener adInteractionListener = this._a;
            if (adInteractionListener != null) {
                adInteractionListener.onAdClicked();
            }
        }

        @Override // com.kc.aw.lib.interf.PtgInteractionAd.AdInteractionListener
        public final void onAdDismiss() {
            PtgInteractionAd.AdInteractionListener adInteractionListener = this._a;
            if (adInteractionListener != null) {
                adInteractionListener.onAdDismiss();
            }
        }

        @Override // com.kc.aw.lib.interf.PtgInteractionAd.AdInteractionListener
        public final void onAdShow() {
            if (this._b._c._p) {
                _nt._a()._a(this._b._a.getDispatchPolicyCustomerItem()._g(), "inAppImp", this._b._c, null);
                this._b._c._p = false;
                PtgInteractionAd.AdInteractionListener adInteractionListener = this._a;
                if (adInteractionListener != null) {
                    adInteractionListener.onAdShow();
                }
            }
        }

        @Override // com.kc.aw.lib.interf.PtgInteractionAd.AdInteractionListener
        public final void onRenderError(AdError adError) {
            AdSlot adSlot;
            _iq _iqVar = this._b;
            if (_iqVar._c != null && (adSlot = _iqVar._a) != null && adSlot.getDispatchPolicyCustomerItem() != null) {
                this._b._c._a(adError);
                _nt._a()._a(this._b._a.getDispatchPolicyCustomerItem()._f(), "inAppErr", this._b._c, null);
            }
            PtgInteractionAd.AdInteractionListener adInteractionListener = this._a;
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

    @Keep
    public final class _c implements Runnable {
        public final _iq _a;

        public _c(_iq _iqVar) {
            this._a = _iqVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this._a._b.destroy();
        }
    }

    public _iq(PtgInteractionAd ptgInteractionAd, AdSlot adSlot, _nr _nrVar) {
        this._b = ptgInteractionAd;
        this._a = adSlot;
        this._c = _nrVar;
    }

    @Override // com.kc.aw.lib.interf.PtgInteractionAd
    public final void closureInterstitialAd() {
        this._b.closureInterstitialAd();
    }

    @Override // com.kc.aw.lib.interf.PtgAd
    public final void destroy() {
        com.kc.aw.lib.utils._d._c(new _c(this));
    }

    @Override // com.kc.aw.lib.interf.PtgAd
    public final _l getAdFilterAdapter() {
        return this._b.getAdFilterAdapter();
    }

    @Override // com.kc.aw.lib.interf.PtgAd
    public final String getAdId() {
        return this._b.getAdId();
    }

    @Override // com.kc.aw.lib.interf.PtgInteractionAd
    public final NativeAdvertData getAdvertData() {
        return this._b.getAdvertData();
    }

    @Override // com.kc.aw.lib.interf.PtgAd
    public final String getConsumer() {
        return this._b.getConsumer();
    }

    @Override // com.kc.aw.lib.interf.PtgAd
    public final long getEcpm() {
        PtgInteractionAd ptgInteractionAd = this._b;
        if (ptgInteractionAd != null) {
            return ptgInteractionAd.getEcpm();
        }
        return 0L;
    }

    @Override // com.kc.aw.lib.interf.PtgAd
    public final int getInteractionType() {
        return this._b.getInteractionType();
    }

    @Override // com.kc.aw.lib.interf.PtgInteractionAd
    public final Map<String, Object> getMediaExtraInfo() {
        return this._b.getMediaExtraInfo();
    }

    @Override // com.kc.aw.lib.interf.PtgAd
    public final boolean isReady() {
        return this._b.isReady();
    }

    @Override // com.kc.aw.lib.interf.PtgAd
    public final boolean isResourceLoaded() {
        return this._b.isResourceLoaded();
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
        PtgInteractionAd ptgInteractionAd = this._b;
        if (ptgInteractionAd != null) {
            ptgInteractionAd.notifyBidLoss(adBidLossReason);
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
        PtgInteractionAd ptgInteractionAd = this._b;
        if (ptgInteractionAd != null) {
            ptgInteractionAd.notifyBidWin(d, d2);
        }
    }

    @Override // com.kc.aw.lib.interf.PtgAd
    public final void setAdFilterAdapter(_l _lVar) {
        this._b.setAdFilterAdapter(_lVar);
    }

    @Override // com.kc.aw.lib.interf.PtgInteractionAd
    public final void setAdInteractionListener(PtgInteractionAd.AdInteractionListener adInteractionListener) {
        this._b.setAdInteractionListener(new _a(this, adInteractionListener));
    }

    @Override // com.kc.aw.lib.interf.PtgInteractionAd
    public final void setDownloadListener(PtgAppDownloadListener ptgAppDownloadListener) {
        this._b.setDownloadListener(ptgAppDownloadListener);
    }

    @Override // com.kc.aw.lib.interf.PtgInteractionAd
    public final void setVideoAdListener(PtgVideoAdListener ptgVideoAdListener) {
        this._b.setVideoAdListener(new _b(ptgVideoAdListener));
    }

    @Override // com.kc.aw.lib.interf.PtgInteractionAd
    public final void showInteractionAd(Activity activity) {
        this._b.showInteractionAd(activity);
    }
}
