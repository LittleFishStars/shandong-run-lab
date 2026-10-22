package com.fl.saas.s2s.topon;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.camera.video.AudioStats;
import com.anythink.banner.unitgroup.api.CustomBannerAdapter;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATBiddingNotice;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.ATCustomLoadListener;
import com.anythink.core.api.BaseAd;
import com.fl.saas.base.interfaces.AdViewBannerListener;
import com.fl.saas.common.util.CommConstant;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.LogcatUtil;
import com.fl.saas.ydsdk.YdBanner;
import com.igexin.assist.sdk.AssistPushConsts;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class FLTopOnBannerAdapter extends CustomBannerAdapter implements ATBiddingNotice {
    private static final String TAG = CommConstant.getClassTag("FL", FLTopOnBannerAdapter.class);
    private View bannerView;
    private long loadSuccessTime;
    private Context mContext;
    private String slotId;
    private YdBanner ydBanner;

    /* JADX INFO: Access modifiers changed from: private */
    public void startLoad(final ATBiddingListener aTBiddingListener) {
        LogcatUtil.d(TAG, "startLoad");
        YdBanner ydBannerBuild = new YdBanner.Builder(this.mContext).setKey(this.slotId).setBannerListener(new AdViewBannerListener() { // from class: com.fl.saas.s2s.topon.FLTopOnBannerAdapter.2
            @Override // com.fl.saas.base.base.listener.InnerBannerListener
            public void onAdClick(String str) {
                LogcatUtil.d(FLTopOnBannerAdapter.TAG, "onAdClick");
                if (FLTopOnBannerAdapter.this.mImpressionEventListener != null) {
                    FLTopOnBannerAdapter.this.mImpressionEventListener.onBannerAdClicked();
                }
            }

            @Override // com.fl.saas.base.base.listener.InnerBannerListener
            public void onAdExposure() {
                LogcatUtil.d(FLTopOnBannerAdapter.TAG, "onAdExposure");
                if (FLTopOnBannerAdapter.this.mImpressionEventListener != null) {
                    FLTopOnBannerAdapter.this.mImpressionEventListener.onBannerAdShow();
                }
            }

            @Override // com.fl.saas.base.interfaces.AdViewListener
            public void onAdFailed(YdError ydError) {
                LogcatUtil.d(FLTopOnBannerAdapter.TAG, "error:" + ydError.toString());
                if (FLTopOnBannerAdapter.this.mLoadListener != null) {
                    FLTopOnBannerAdapter.this.mLoadListener.onAdLoadError("", ydError.toString());
                }
                ATBiddingListener aTBiddingListener2 = aTBiddingListener;
                if (aTBiddingListener2 != null) {
                    aTBiddingListener2.onC2SBiddingResultWithCache(ATBiddingResult.fail(ydError.toString()), (BaseAd) null);
                }
            }

            @Override // com.fl.saas.base.base.listener.InnerBannerListener
            public void onClosed() {
                LogcatUtil.d(FLTopOnBannerAdapter.TAG, "onClosed");
                if (FLTopOnBannerAdapter.this.mImpressionEventListener != null) {
                    FLTopOnBannerAdapter.this.mImpressionEventListener.onBannerAdClose();
                }
            }

            @Override // com.fl.saas.base.base.listener.InnerBannerListener
            public void onReceived(View view) {
                LogcatUtil.d(FLTopOnBannerAdapter.TAG, "onReceived");
                FLTopOnBannerAdapter.this.loadSuccessTime = System.currentTimeMillis();
                FLTopOnBannerAdapter.this.bannerView = view;
                if (aTBiddingListener != null) {
                    String str = System.currentTimeMillis() + "";
                    FLTopOnInitManager.getInstance().putBidAdObject(str, FLTopOnBannerAdapter.this.bannerView);
                    aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(FLTopOnBannerAdapter.this.ydBanner.getECPM() == 0 ? AudioStats.AUDIO_AMPLITUDE_NONE : ((double) FLTopOnBannerAdapter.this.ydBanner.getECPM()) / 100.0d, str, (ATBiddingNotice) null, ATAdConst.CURRENCY.RMB), (BaseAd) null);
                }
                if (FLTopOnBannerAdapter.this.mLoadListener != null) {
                    FLTopOnBannerAdapter.this.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
            }
        }).build();
        this.ydBanner = ydBannerBuild;
        ydBannerBuild.requestBanner();
    }

    public void destory() {
        YdBanner ydBanner = this.ydBanner;
        if (ydBanner != null) {
            ydBanner.destroy();
            this.ydBanner = null;
        }
    }

    public View getBannerView() {
        return this.bannerView;
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
        return System.currentTimeMillis() - this.loadSuccessTime <= 1800000;
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
                FLTopOnInitManager.getInstance().initSDK(context, map, new FLTopOnInitManager.InitCallback() { // from class: com.fl.saas.s2s.topon.FLTopOnBannerAdapter.3
                    @Override // com.fl.saas.s2s.topon.FLTopOnInitManager.InitCallback
                    public void onFinish() {
                        FLTopOnBannerAdapter.this.startLoad(null);
                    }
                });
                return;
            }
            String str3 = (String) map.get(AssistPushConsts.MSG_TYPE_PAYLOAD);
            if (TextUtils.isEmpty(str3)) {
                return;
            }
            Object objPopBidAdObject = FLTopOnInitManager.getInstance().popBidAdObject(str3);
            if (objPopBidAdObject instanceof View) {
                if (this.bannerView == null) {
                    this.bannerView = (View) objPopBidAdObject;
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
        YdBanner ydBanner = this.ydBanner;
        if (ydBanner != null) {
            ydBanner.biddingResultUpload(false, (int) (d * 100.0d), 0);
        }
    }

    public void notifyBidWin(double d, double d2, Map<String, Object> map) {
        YdBanner ydBanner = this.ydBanner;
        if (ydBanner != null) {
            ydBanner.biddingResultUpload(true, (int) (d * 100.0d), (int) (d2 * 100.0d));
        }
    }

    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, final ATBiddingListener aTBiddingListener) {
        String str = TAG;
        LogcatUtil.d(str, "startBiddingRequest");
        this.mContext = context;
        String str2 = (String) map.get("slot_id");
        this.slotId = str2;
        if (!TextUtils.isEmpty(str2)) {
            FLTopOnInitManager.getInstance().initSDK(context, map, new FLTopOnInitManager.InitCallback() { // from class: com.fl.saas.s2s.topon.FLTopOnBannerAdapter.1
                @Override // com.fl.saas.s2s.topon.FLTopOnInitManager.InitCallback
                public void onFinish() {
                    FLTopOnBannerAdapter.this.startLoad(aTBiddingListener);
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
