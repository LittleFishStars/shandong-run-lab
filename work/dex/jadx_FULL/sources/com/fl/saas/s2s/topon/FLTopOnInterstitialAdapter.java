package com.fl.saas.s2s.topon;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATBiddingNotice;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.ATCustomLoadListener;
import com.anythink.core.api.BaseAd;
import com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter;
import com.fl.saas.base.interfaces.AdViewInterstitialListener;
import com.fl.saas.common.util.CommConstant;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.LogcatUtil;
import com.fl.saas.ydsdk.YdInterstitial;
import com.igexin.assist.sdk.AssistPushConsts;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class FLTopOnInterstitialAdapter extends CustomInterstitialAdapter implements ATBiddingNotice {
    private static final String TAG = CommConstant.getClassTag("FL", FLTopOnInterstitialAdapter.class);
    private long loadSuccessTime;
    private Context mContext;
    private String slotId;
    private YdInterstitial ydInterstitial;

    /* JADX INFO: Access modifiers changed from: private */
    public void startLoad(final ATBiddingListener aTBiddingListener) {
        LogcatUtil.d(TAG, "startLoad");
        YdInterstitial ydInterstitialBuild = new YdInterstitial.Builder(this.mContext).setKey(this.slotId).setInterstitialListener(new AdViewInterstitialListener() { // from class: com.fl.saas.s2s.topon.FLTopOnInterstitialAdapter.2
            @Override // com.fl.saas.base.base.listener.InnerInterstitialListener
            public void onAdClick(String str) {
                LogcatUtil.d(FLTopOnInterstitialAdapter.TAG, "ydInterstitial onAdClick");
                if (FLTopOnInterstitialAdapter.this.mImpressListener != null) {
                    FLTopOnInterstitialAdapter.this.mImpressListener.onInterstitialAdClicked();
                }
            }

            @Override // com.fl.saas.base.base.listener.InnerInterstitialListener
            public void onAdClosed() {
                LogcatUtil.d(FLTopOnInterstitialAdapter.TAG, "ydInterstitial onAdClosed");
                if (FLTopOnInterstitialAdapter.this.mImpressListener != null) {
                    FLTopOnInterstitialAdapter.this.mImpressListener.onInterstitialAdClose();
                }
            }

            @Override // com.fl.saas.base.base.listener.InnerInterstitialListener
            public void onAdDisplay() {
                LogcatUtil.d(FLTopOnInterstitialAdapter.TAG, "ydInterstitial onAdDisplay");
                if (FLTopOnInterstitialAdapter.this.mImpressListener != null) {
                    FLTopOnInterstitialAdapter.this.mImpressListener.onInterstitialAdShow();
                }
            }

            @Override // com.fl.saas.base.interfaces.AdViewListener
            public void onAdFailed(YdError ydError) {
                LogcatUtil.d(FLTopOnInterstitialAdapter.TAG, "ydInterstitial onAdFailed:" + ydError.toString());
                if (FLTopOnInterstitialAdapter.this.mLoadListener != null) {
                    FLTopOnInterstitialAdapter.this.mLoadListener.onAdLoadError("", ydError.toString());
                }
                ATBiddingListener aTBiddingListener2 = aTBiddingListener;
                if (aTBiddingListener2 != null) {
                    aTBiddingListener2.onC2SBiddingResultWithCache(ATBiddingResult.fail(ydError.toString()), (BaseAd) null);
                }
            }

            @Override // com.fl.saas.base.base.listener.InnerInterstitialListener
            public void onAdReady() {
                LogcatUtil.d(FLTopOnInterstitialAdapter.TAG, "ydInterstitial onAdReady");
                FLTopOnInterstitialAdapter.this.loadSuccessTime = System.currentTimeMillis();
                if (aTBiddingListener != null) {
                    String str = System.currentTimeMillis() + "";
                    FLTopOnInitManager.getInstance().putBidAdObject(str, FLTopOnInterstitialAdapter.this.ydInterstitial);
                    aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(FLTopOnInterstitialAdapter.this.ydInterstitial.getECPM() == 0 ? AudioStats.AUDIO_AMPLITUDE_NONE : ((double) FLTopOnInterstitialAdapter.this.ydInterstitial.getECPM()) / 100.0d, str, (ATBiddingNotice) null, ATAdConst.CURRENCY.RMB), (BaseAd) null);
                }
                if (FLTopOnInterstitialAdapter.this.mLoadListener != null) {
                    FLTopOnInterstitialAdapter.this.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
            }
        }).build();
        this.ydInterstitial = ydInterstitialBuild;
        ydInterstitialBuild.requestInterstitial();
    }

    public void destory() {
        YdInterstitial ydInterstitial = this.ydInterstitial;
        if (ydInterstitial != null) {
            ydInterstitial.destroy();
            this.ydInterstitial = null;
        }
    }

    public String getNetworkName() {
        return FLTopOnInitManager.getInstance().getNetworkName();
    }

    public String getNetworkPlacementId() {
        return this.slotId;
    }

    public String getNetworkSDKVersion() {
        return FLTopOnInitManager.getInstance().getNetworkVersion();
    }

    public ATAdConst.CURRENCY getNoticePriceCurrency() {
        return ATAdConst.CURRENCY.RMB;
    }

    public boolean isAdReady() {
        YdInterstitial ydInterstitial;
        if (System.currentTimeMillis() - this.loadSuccessTime <= 1800000 && (ydInterstitial = this.ydInterstitial) != null) {
            return ydInterstitial.isReady();
        }
        return false;
    }

    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        ATCustomLoadListener aTCustomLoadListener;
        String str;
        LogcatUtil.d(TAG, "loadCustomNetworkAd");
        this.mContext = context;
        String str2 = (String) map.get("slot_id");
        this.slotId = str2;
        if (TextUtils.isEmpty(str2)) {
            if (this.mLoadListener == null) {
                return;
            }
            aTCustomLoadListener = this.mLoadListener;
            str = "slot_id is empty!";
        } else {
            if (!map.containsKey(AssistPushConsts.MSG_TYPE_PAYLOAD)) {
                FLTopOnInitManager.getInstance().initSDK(context, map, new FLTopOnInitManager.InitCallback() { // from class: com.fl.saas.s2s.topon.FLTopOnInterstitialAdapter.3
                    @Override // com.fl.saas.s2s.topon.FLTopOnInitManager.InitCallback
                    public void onFinish() {
                        FLTopOnInterstitialAdapter.this.startLoad(null);
                    }
                });
                return;
            }
            String str3 = (String) map.get(AssistPushConsts.MSG_TYPE_PAYLOAD);
            if (TextUtils.isEmpty(str3)) {
                return;
            }
            Object objPopBidAdObject = FLTopOnInitManager.getInstance().popBidAdObject(str3);
            if (objPopBidAdObject instanceof YdInterstitial) {
                if (this.ydInterstitial == null) {
                    this.ydInterstitial = (YdInterstitial) objPopBidAdObject;
                }
                if (this.mLoadListener != null) {
                    this.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                    return;
                }
                return;
            }
            if (this.mLoadListener == null) {
                return;
            }
            aTCustomLoadListener = this.mLoadListener;
            str = "FL: Bidding Cache is empty.";
        }
        aTCustomLoadListener.onAdLoadError("", str);
    }

    public void notifyBidDisplay(boolean z, double d) {
    }

    public void notifyBidLoss(String str, double d, Map<String, Object> map) {
        YdInterstitial ydInterstitial = this.ydInterstitial;
        if (ydInterstitial != null) {
            ydInterstitial.biddingResultUpload(false, (int) (d * 100.0d), 0);
        }
    }

    public void notifyBidWin(double d, double d2, Map<String, Object> map) {
        YdInterstitial ydInterstitial = this.ydInterstitial;
        if (ydInterstitial != null) {
            ydInterstitial.biddingResultUpload(true, (int) (d * 100.0d), (int) (d2 * 100.0d));
        }
    }

    public void show(Activity activity) {
        YdInterstitial ydInterstitial = this.ydInterstitial;
        if (ydInterstitial != null) {
            ydInterstitial.show(activity);
        }
    }

    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, final ATBiddingListener aTBiddingListener) {
        String str = TAG;
        LogcatUtil.d(str, "startBiddingRequest");
        this.mContext = context;
        String str2 = (String) map.get("slot_id");
        this.slotId = str2;
        if (!TextUtils.isEmpty(str2)) {
            FLTopOnInitManager.getInstance().initSDK(context, map, new FLTopOnInitManager.InitCallback() { // from class: com.fl.saas.s2s.topon.FLTopOnInterstitialAdapter.1
                @Override // com.fl.saas.s2s.topon.FLTopOnInitManager.InitCallback
                public void onFinish() {
                    FLTopOnInterstitialAdapter.this.startLoad(aTBiddingListener);
                }
            });
            return true;
        }
        LogcatUtil.d(str, "slot_id is empty!");
        if (this.mLoadListener != null) {
            this.mLoadListener.onAdLoadError("", "slot_id is empty!");
        }
        if (aTBiddingListener == null) {
            return true;
        }
        aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.fail("slot_id is empty!"), (BaseAd) null);
        return true;
    }
}
