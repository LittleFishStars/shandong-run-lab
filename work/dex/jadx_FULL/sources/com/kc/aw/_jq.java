package com.kc.aw;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.kc.aw.activity.PtgRewardVideoLandscapeActivity;
import com.kc.aw.activity.PtgRewardVideoPortraitActivity;
import com.kc.aw.lib.constants.PtgErrorCode;
import com.kc.aw.lib.core.model.AdErrorImpl;
import com.kc.aw.lib.interf.NativeAdvertData;
import com.kc.aw.lib.interf.PtgAppDownloadListener;
import com.kc.aw.lib.interf.PtgRewardVideoAd;
import com.kc.aw.lib.model.AdBidLossReason;
import com.kc.aw.lib.model.AdError;
import com.kc.aw.lib.model.AdSlot;
import com.kc.aw.lib.provider.PtgAdNative;
import com.kc.aw.provider.PtgApiProvider;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _jq implements Runnable {
    public final _q _a;
    public final _jr _b;

    @Keep
    public final class _a implements PtgRewardVideoAd {
        public String _a;
        public final String _b;
        public final _h _c;
        public final _jq _d;

        /* JADX INFO: renamed from: com.kc.aw._jq$_a$_a, reason: collision with other inner class name */
        @Keep
        public final class C0949_a implements PtgRewardVideoAd.RewardAdInteractionListener {
            public boolean _a = false;
            public final PtgRewardVideoAd.RewardAdInteractionListener _b;
            public final _a _c;

            public C0949_a(_a _aVar, PtgRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
                this._c = _aVar;
                this._b = rewardAdInteractionListener;
            }

            @Override // com.kc.aw.lib.interf.PtgRewardVideoAd.RewardAdInteractionListener
            public final void onAdClose() {
                PtgRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this._b;
                if (rewardAdInteractionListener != null) {
                    rewardAdInteractionListener.onAdClose();
                }
            }

            @Override // com.kc.aw.lib.interf.PtgRewardVideoAd.RewardAdInteractionListener
            public final void onAdShow() {
                _a _aVar = this._c;
                _h _hVar = _aVar._c;
                if (_hVar != null) {
                    _hVar._x = true;
                }
                _aVar._d._b._a.setAdExposed(true);
                PtgRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this._b;
                if (rewardAdInteractionListener != null) {
                    rewardAdInteractionListener.onAdShow();
                }
                if (this._a) {
                    return;
                }
                this._a = true;
                _nt _ntVar_a = _nt._a();
                _a _aVar2 = this._c;
                _h _hVar2 = _aVar2._c;
                AdSlot adSlot = _aVar2._d._b._a;
                _l0 _l0Var = _ntVar_a._b;
                if (_l0Var == null) {
                    _l0Var = new _l0();
                    _ntVar_a._b = _l0Var;
                }
                _l0Var._a(_hVar2);
            }

            @Override // com.kc.aw.lib.interf.PtgRewardVideoAd.RewardAdInteractionListener
            public final void onAdVideoBarClick() {
                PtgRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this._b;
                if (rewardAdInteractionListener != null) {
                    rewardAdInteractionListener.onAdVideoBarClick();
                }
            }

            @Override // com.kc.aw.lib.interf.PtgRewardVideoAd.RewardAdInteractionListener
            public final void onRenderError(AdError adError) {
                PtgRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this._b;
                if (rewardAdInteractionListener != null) {
                    rewardAdInteractionListener.onRenderError(adError);
                }
            }

            @Override // com.kc.aw.lib.interf.PtgRewardVideoAd.RewardAdInteractionListener
            public final void onRewardVerify(boolean z, Bundle bundle) {
                PtgRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this._b;
                if (rewardAdInteractionListener != null) {
                    rewardAdInteractionListener.onRewardVerify(z, bundle);
                }
            }

            @Override // com.kc.aw.lib.interf.PtgRewardVideoAd.RewardAdInteractionListener
            public final void onSkippedVideo() {
                PtgRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this._b;
                if (rewardAdInteractionListener != null) {
                    rewardAdInteractionListener.onSkippedVideo();
                }
            }

            @Override // com.kc.aw.lib.interf.PtgRewardVideoAd.RewardAdInteractionListener
            public final void onVideoComplete() {
                PtgRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this._b;
                if (rewardAdInteractionListener != null) {
                    rewardAdInteractionListener.onVideoComplete();
                }
            }

            @Override // com.kc.aw.lib.interf.PtgRewardVideoAd.RewardAdInteractionListener
            public final void onVideoError(int i, String str) {
                PtgRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this._b;
                if (rewardAdInteractionListener != null) {
                    rewardAdInteractionListener.onVideoError(i, str);
                }
            }

            @Override // com.kc.aw.lib.interf.PtgRewardVideoAd.RewardAdInteractionListener
            public final void onVideoPause() {
                PtgRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this._b;
                if (rewardAdInteractionListener != null) {
                    rewardAdInteractionListener.onVideoPause();
                }
            }

            @Override // com.kc.aw.lib.interf.PtgRewardVideoAd.RewardAdInteractionListener
            public final void onVideoProgressUpdate(long j, long j2) {
                PtgRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this._b;
                if (rewardAdInteractionListener != null) {
                    rewardAdInteractionListener.onVideoProgressUpdate(j, j2);
                }
            }

            @Override // com.kc.aw.lib.interf.PtgRewardVideoAd.RewardAdInteractionListener
            public final void onVideoResume() {
                PtgRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this._b;
                if (rewardAdInteractionListener != null) {
                    rewardAdInteractionListener.onVideoResume();
                }
            }

            @Override // com.kc.aw.lib.interf.PtgRewardVideoAd.RewardAdInteractionListener
            public final void onVideoStart() {
                PtgRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this._b;
                if (rewardAdInteractionListener != null) {
                    rewardAdInteractionListener.onVideoStart();
                }
            }
        }

        public _a(_jq _jqVar, String str, _h _hVar) {
            this._d = _jqVar;
            this._b = str;
            this._c = _hVar;
        }

        @Override // com.kc.aw.lib.interf.PtgAd
        public final void destroy() {
            _la._a()._b(this._b);
            _js _jsVar = this._d._b._b;
            if (_jsVar._a != null) {
                _jsVar._a = null;
            }
        }

        @Override // com.kc.aw.lib.interf.PtgAd
        public final _l getAdFilterAdapter() {
            return null;
        }

        @Override // com.kc.aw.lib.interf.PtgAd
        public final String getAdId() {
            _nr trackingData;
            if (TextUtils.isEmpty(this._a) && (trackingData = this._d._b._a.getTrackingData()) != null) {
                this._a = trackingData._h;
            }
            return this._a;
        }

        @Override // com.kc.aw.lib.interf.PtgRewardVideoAd
        public final NativeAdvertData getAdvertData() {
            return _hz._a(100, false, this._c);
        }

        @Override // com.kc.aw.lib.interf.PtgAd
        public final String getConsumer() {
            return PtgApiProvider.providerName;
        }

        @Override // com.kc.aw.lib.interf.PtgAd
        public final long getEcpm() {
            _h _hVar = this._c;
            if (_hVar != null) {
                return _hVar._l;
            }
            return 0L;
        }

        @Override // com.kc.aw.lib.interf.PtgAd
        public final int getInteractionType() {
            return 0;
        }

        @Override // com.kc.aw.lib.interf.PtgRewardVideoAd
        public final Map<String, Object> getMediaExtraInfo() {
            return null;
        }

        @Override // com.kc.aw.lib.interf.PtgAd
        public final boolean isReady() {
            _h _hVar = this._c;
            return _hVar != null && _hVar._r();
        }

        @Override // com.kc.aw.lib.interf.PtgAd
        public final boolean isResourceLoaded() {
            _h _hVar = this._c;
            return _hVar != null && _hVar._H;
        }

        @Override // com.kc.aw.lib.interf.PtgAd
        public final void notifyBidLoss(AdBidLossReason adBidLossReason) {
            if (this._c != null) {
                _js _jsVar = this._d._b._b;
                if (_jsVar._b) {
                    return;
                }
                _jsVar._b = true;
                _nt _ntVar_a = _nt._a();
                _h _hVar = this._c;
                _l0 _l0Var = _ntVar_a._b;
                if (_l0Var == null) {
                    _l0Var = new _l0();
                    _ntVar_a._b = _l0Var;
                }
                _l0Var._a(_hVar, adBidLossReason);
            }
        }

        @Override // com.kc.aw.lib.interf.PtgAd
        public final void notifyBidWin(double d, double d2) {
            if (this._c != null) {
                _js _jsVar = this._d._b._b;
                if (_jsVar._b) {
                    return;
                }
                _jsVar._b = true;
                _nt _ntVar_a = _nt._a();
                _h _hVar = this._c;
                AdSlot adSlot = this._d._b._a;
                _l0 _l0Var = _ntVar_a._b;
                if (_l0Var == null) {
                    _l0Var = new _l0();
                    _ntVar_a._b = _l0Var;
                }
                _l0Var._b(_hVar);
            }
        }

        @Override // com.kc.aw.lib.interf.PtgAd
        public final void setAdFilterAdapter(_l _lVar) {
        }

        @Override // com.kc.aw.lib.interf.PtgRewardVideoAd
        public final void setDownloadListener(PtgAppDownloadListener ptgAppDownloadListener) {
            _la _laVar_a = _la._a();
            String str = this._b;
            synchronized (_laVar_a._d) {
                List arrayList = (List) _laVar_a._d.get(str);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    _laVar_a._d.put(str, arrayList);
                }
                if (!arrayList.contains(ptgAppDownloadListener)) {
                    arrayList.add(ptgAppDownloadListener);
                }
            }
        }

        @Override // com.kc.aw.lib.interf.PtgRewardVideoAd
        public final void setRewardAdInteractionListener(PtgRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
            _la _laVar_a = _la._a();
            String str = this._b;
            C0949_a c0949_a = new C0949_a(this, rewardAdInteractionListener);
            if (str == null) {
                _laVar_a.getClass();
                return;
            }
            synchronized (_laVar_a._c) {
                List arrayList = (List) _laVar_a._c.get(str);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    _laVar_a._c.put(str, arrayList);
                }
                if (!arrayList.contains(c0949_a)) {
                    arrayList.add(c0949_a);
                }
            }
        }

        @Override // com.kc.aw.lib.interf.PtgRewardVideoAd
        public final void showRewardVideoAd(Activity activity) {
            if (!this._c._r()) {
                _la _laVar_a = _la._a();
                String str = this._b;
                AdErrorImpl adErrorImpl = new AdErrorImpl();
                adErrorImpl._c = PtgApiProvider.providerName;
                adErrorImpl._d = PtgErrorCode.SDK_RENDER_ERROR;
                adErrorImpl._e = PtgErrorCode.SDK_RENDER_ERROR_5;
                adErrorImpl._a = PtgErrorCode.SDK_RENDER_ERROR;
                adErrorImpl._b = PtgErrorCode.SDK_RENDER_ERROR_5;
                _laVar_a._a(str, adErrorImpl);
                return;
            }
            _h _hVar = this._c;
            AdSlot adSlot = this._d._b._a;
            int i = PtgRewardVideoPortraitActivity._J;
            if (activity == null || _hVar == null || adSlot == null) {
                return;
            }
            _f4 _f4Var = _hVar._B;
            int i2 = _f4Var != null ? _f4Var._a : 0;
            _la _laVar_a2 = _la._a();
            synchronized (_laVar_a2._a) {
                _laVar_a2._a.put(String.valueOf(_hVar.hashCode()), _hVar);
            }
            synchronized (_laVar_a2._a) {
                _laVar_a2._b.put(String.valueOf(_hVar.hashCode()), adSlot);
            }
            Intent intent = i2 == 0 ? new Intent(activity, (Class<?>) PtgRewardVideoPortraitActivity.class) : new Intent(activity, (Class<?>) PtgRewardVideoLandscapeActivity.class);
            intent.putExtra("VIDEO_ADVERT_ID", String.valueOf(_hVar.hashCode()));
            intent.putExtra("VIDEO_SCREEN_TYPE", i2);
            activity.startActivity(intent);
        }
    }

    public _jq(_jr _jrVar, _q _qVar) {
        this._b = _jrVar;
        this._a = _qVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        List<_h> list;
        _q _qVar = this._a;
        List<_h> list2 = (_qVar == null || (list = _qVar._a) == null || list.isEmpty()) ? null : this._a._a;
        if (list2 == null) {
            PtgAdNative.RewardVideoAdListener rewardVideoAdListener = this._b._b._a;
            if (rewardVideoAdListener != null) {
                rewardVideoAdListener.onError(new AdErrorImpl(10000, AdError.ERROR_NO_AD_STR, (Object) null));
                return;
            }
            return;
        }
        _h _hVar = list2.get(0);
        this._b._a.setConsumerPrice(_hVar._l);
        _a _aVar = new _a(this, String.valueOf(_hVar.hashCode()), _hVar);
        PtgAdNative.RewardVideoAdListener rewardVideoAdListener2 = this._b._b._a;
        if (rewardVideoAdListener2 != null) {
            rewardVideoAdListener2.onRewardVideoAdLoad(_aVar);
        }
    }
}
