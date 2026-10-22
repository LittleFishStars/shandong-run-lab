package com.kc.aw;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.kc.aw.lib.PtgAdSdk;
import com.kc.aw.lib.core.model.AdErrorImpl;
import com.kc.aw.lib.interf.NativeAdvertData;
import com.kc.aw.lib.interf.PtgAppDownloadListener;
import com.kc.aw.lib.interf.PtgRewardVideoAd;
import com.kc.aw.lib.model.AdBidLossReason;
import com.kc.aw.lib.model.AdError;
import com.kc.aw.lib.model.AdSlot;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _j4 implements PtgRewardVideoAd {
    public AdSlot _a;
    public PtgRewardVideoAd _b;
    public _nr _c;

    @Keep
    public final class _a implements PtgRewardVideoAd.RewardAdInteractionListener {
        public final PtgRewardVideoAd.RewardAdInteractionListener _a;
        public final _j4 _b;

        public _a(_j4 _j4Var, PtgRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
            this._b = _j4Var;
            this._a = rewardAdInteractionListener;
        }

        @Override // com.kc.aw.lib.interf.PtgRewardVideoAd.RewardAdInteractionListener
        public final void onAdClose() {
            this._a.onAdClose();
        }

        @Override // com.kc.aw.lib.interf.PtgRewardVideoAd.RewardAdInteractionListener
        public final void onAdShow() {
            if (this._b._c._p) {
                _nt._a()._a(this._b._a.getDispatchPolicyCustomerItem()._g(), "inAppImp", this._b._c, null);
                this._b._c._p = false;
                this._a.onAdShow();
            }
        }

        @Override // com.kc.aw.lib.interf.PtgRewardVideoAd.RewardAdInteractionListener
        public final void onAdVideoBarClick() {
            _j4 _j4Var = this._b;
            _nr _nrVar = _j4Var._c;
            if (_nrVar != null) {
                _nrVar._t._b(_j4Var._a.getCt());
            }
            if (this._b._a.isAdExposed()) {
                _nt._a()._a(this._b._a.getDispatchPolicyCustomerItem()._d(), "inAppClick", this._b._c, null);
            }
            if (!Boolean.parseBoolean(this._b._c._b())) {
                this._a.onAdVideoBarClick();
                return;
            }
            _nr _nrVar2 = this._b._c;
            synchronized (_nrVar2._s) {
                if (!TextUtils.isEmpty("iReportM")) {
                    _nrVar2._s.put("iReportM", String.valueOf(false));
                }
            }
        }

        @Override // com.kc.aw.lib.interf.PtgRewardVideoAd.RewardAdInteractionListener
        public final void onRenderError(AdError adError) {
            AdSlot adSlot;
            _j4 _j4Var = this._b;
            if (_j4Var._c != null && (adSlot = _j4Var._a) != null && adSlot.getDispatchPolicyCustomerItem() != null) {
                this._b._c._a(adError);
                _nt._a()._a(this._b._a.getDispatchPolicyCustomerItem()._f(), "inAppErr", this._b._c, null);
            }
            this._a.onRenderError(adError);
        }

        @Override // com.kc.aw.lib.interf.PtgRewardVideoAd.RewardAdInteractionListener
        public final void onRewardVerify(boolean z, Bundle bundle) {
            this._a.onRewardVerify(z, bundle);
        }

        @Override // com.kc.aw.lib.interf.PtgRewardVideoAd.RewardAdInteractionListener
        public final void onSkippedVideo() {
            this._a.onSkippedVideo();
        }

        @Override // com.kc.aw.lib.interf.PtgRewardVideoAd.RewardAdInteractionListener
        public final void onVideoComplete() {
            this._a.onVideoComplete();
        }

        @Override // com.kc.aw.lib.interf.PtgRewardVideoAd.RewardAdInteractionListener
        public final void onVideoError(int i, String str) {
            AdSlot adSlot;
            _j4 _j4Var = this._b;
            if (_j4Var._c != null && (adSlot = _j4Var._a) != null && adSlot.getDispatchPolicyCustomerItem() != null) {
                _nr _nrVar = this._b._c;
                AdErrorImpl adErrorImpl = new AdErrorImpl();
                adErrorImpl._a = i;
                adErrorImpl._b = str;
                _nrVar._a(adErrorImpl);
                _nt._a()._a(this._b._a.getDispatchPolicyCustomerItem()._f(), "inAppErr", this._b._c, null);
            }
            this._a.onVideoError(i, str);
        }

        @Override // com.kc.aw.lib.interf.PtgRewardVideoAd.RewardAdInteractionListener
        public final void onVideoPause() {
            this._a.onVideoPause();
        }

        @Override // com.kc.aw.lib.interf.PtgRewardVideoAd.RewardAdInteractionListener
        public final void onVideoProgressUpdate(long j, long j2) {
            this._a.onVideoProgressUpdate(j, j2);
        }

        @Override // com.kc.aw.lib.interf.PtgRewardVideoAd.RewardAdInteractionListener
        public final void onVideoResume() {
            this._a.onVideoResume();
        }

        @Override // com.kc.aw.lib.interf.PtgRewardVideoAd.RewardAdInteractionListener
        public final void onVideoStart() {
            this._a.onVideoStart();
        }
    }

    public _j4(PtgRewardVideoAd ptgRewardVideoAd, AdSlot adSlot, _nr _nrVar) {
        this._b = ptgRewardVideoAd;
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

    @Override // com.kc.aw.lib.interf.PtgRewardVideoAd
    public final NativeAdvertData getAdvertData() {
        return this._b.getAdvertData();
    }

    @Override // com.kc.aw.lib.interf.PtgAd
    public final String getConsumer() {
        return this._b.getConsumer();
    }

    @Override // com.kc.aw.lib.interf.PtgAd
    public final long getEcpm() {
        PtgRewardVideoAd ptgRewardVideoAd = this._b;
        if (ptgRewardVideoAd != null) {
            return ptgRewardVideoAd.getEcpm();
        }
        return 0L;
    }

    @Override // com.kc.aw.lib.interf.PtgAd
    public final int getInteractionType() {
        return this._b.getInteractionType();
    }

    @Override // com.kc.aw.lib.interf.PtgRewardVideoAd
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
        PtgRewardVideoAd ptgRewardVideoAd = this._b;
        if (ptgRewardVideoAd != null) {
            ptgRewardVideoAd.notifyBidLoss(adBidLossReason);
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
        PtgRewardVideoAd ptgRewardVideoAd = this._b;
        if (ptgRewardVideoAd != null) {
            ptgRewardVideoAd.notifyBidWin(d, d2);
        }
    }

    @Override // com.kc.aw.lib.interf.PtgAd
    public final void setAdFilterAdapter(_l _lVar) {
        this._b.setAdFilterAdapter(_lVar);
    }

    @Override // com.kc.aw.lib.interf.PtgRewardVideoAd
    public final void setDownloadListener(PtgAppDownloadListener ptgAppDownloadListener) {
        this._b.setDownloadListener(ptgAppDownloadListener);
    }

    @Override // com.kc.aw.lib.interf.PtgRewardVideoAd
    public final void setRewardAdInteractionListener(PtgRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        this._b.setRewardAdInteractionListener(new _a(this, rewardAdInteractionListener));
    }

    @Override // com.kc.aw.lib.interf.PtgRewardVideoAd
    public final void showRewardVideoAd(Activity activity) {
        this._b.showRewardVideoAd(activity);
    }
}
