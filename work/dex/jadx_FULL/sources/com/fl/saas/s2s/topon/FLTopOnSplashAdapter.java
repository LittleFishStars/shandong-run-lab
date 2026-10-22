package com.fl.saas.s2s.topon;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.camera.video.AudioStats;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATBiddingNotice;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.ATCustomLoadListener;
import com.anythink.core.api.BaseAd;
import com.anythink.splashad.unitgroup.api.CustomSplashAdapter;
import com.fl.saas.base.interfaces.AdViewSpreadListener;
import com.fl.saas.base.interfaces.SpreadLoadListener;
import com.fl.saas.common.util.CommConstant;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.LogcatUtil;
import com.fl.saas.ydsdk.YdSpread;
import com.igexin.assist.sdk.AssistPushConsts;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class FLTopOnSplashAdapter extends CustomSplashAdapter implements ATBiddingNotice {
    private static final String TAG = CommConstant.getClassTag("FL", FLTopOnSplashAdapter.class);
    private long loadSuccessTime;
    private Context mContext;
    private SpreadLoadListener.SpreadAd mSpreadAd;
    private String slotId;
    private YdSpread ydSpread;

    /* JADX INFO: Access modifiers changed from: private */
    public void startLoad(final ATBiddingListener aTBiddingListener) {
        LogcatUtil.d(TAG, "startLoad");
        YdSpread ydSpreadBuild = new YdSpread.Builder(this.mContext).setKey(this.slotId).setSpreadLoadListener(new SpreadLoadListener() { // from class: com.fl.saas.s2s.topon.FLTopOnSplashAdapter.3
            @Override // com.fl.saas.base.interfaces.SpreadLoadListener
            public void onADLoaded(SpreadLoadListener.SpreadAd spreadAd) {
                LogcatUtil.d(FLTopOnSplashAdapter.TAG, "onSplashAdLoad");
                FLTopOnSplashAdapter.this.loadSuccessTime = System.currentTimeMillis();
                FLTopOnSplashAdapter.this.mSpreadAd = spreadAd;
                if (aTBiddingListener != null) {
                    String str = System.currentTimeMillis() + "";
                    FLTopOnInitManager.getInstance().putBidAdObject(str, FLTopOnSplashAdapter.this.mSpreadAd);
                    aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(FLTopOnSplashAdapter.this.mSpreadAd.getEcpm() == 0 ? AudioStats.AUDIO_AMPLITUDE_NONE : ((double) FLTopOnSplashAdapter.this.mSpreadAd.getEcpm()) / 100.0d, str, (ATBiddingNotice) null, ATAdConst.CURRENCY.RMB), (BaseAd) null);
                }
                if (FLTopOnSplashAdapter.this.mLoadListener != null) {
                    FLTopOnSplashAdapter.this.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
            }
        }).setSpreadListener(new AdViewSpreadListener() { // from class: com.fl.saas.s2s.topon.FLTopOnSplashAdapter.2
            @Override // com.fl.saas.base.base.listener.InnerSpreadListener
            public void onAdClick(String str) {
                if (FLTopOnSplashAdapter.this.mImpressionListener != null) {
                    FLTopOnSplashAdapter.this.mImpressionListener.onSplashAdClicked();
                }
            }

            @Override // com.fl.saas.base.base.listener.InnerSpreadListener
            public void onAdClose() {
                if (FLTopOnSplashAdapter.this.mImpressionListener != null) {
                    FLTopOnSplashAdapter.this.mImpressionListener.onSplashAdDismiss();
                }
            }

            @Override // com.fl.saas.base.base.listener.InnerSpreadListener
            public void onAdDisplay() {
                if (FLTopOnSplashAdapter.this.mImpressionListener != null) {
                    FLTopOnSplashAdapter.this.mImpressionListener.onSplashAdShow();
                }
            }

            @Override // com.fl.saas.base.interfaces.AdViewListener
            public void onAdFailed(YdError ydError) {
                if (FLTopOnSplashAdapter.this.mLoadListener != null) {
                    FLTopOnSplashAdapter.this.mLoadListener.onAdLoadError("", ydError.toString());
                }
                ATBiddingListener aTBiddingListener2 = aTBiddingListener;
                if (aTBiddingListener2 != null) {
                    aTBiddingListener2.onC2SBiddingResultWithCache(ATBiddingResult.fail(ydError.toString()), (BaseAd) null);
                }
            }
        }).build();
        this.ydSpread = ydSpreadBuild;
        ydSpreadBuild.requestSpread();
    }

    public void destory() {
        YdSpread ydSpread = this.ydSpread;
        if (ydSpread != null) {
            ydSpread.destroy();
            this.ydSpread = null;
            this.mSpreadAd = null;
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
                FLTopOnInitManager.getInstance().initSDK(context, map, new FLTopOnInitManager.InitCallback() { // from class: com.fl.saas.s2s.topon.FLTopOnSplashAdapter.4
                    @Override // com.fl.saas.s2s.topon.FLTopOnInitManager.InitCallback
                    public void onFinish() {
                        FLTopOnSplashAdapter.this.startLoad(null);
                    }
                });
                return;
            }
            String str3 = (String) map.get(AssistPushConsts.MSG_TYPE_PAYLOAD);
            if (TextUtils.isEmpty(str3)) {
                return;
            }
            Object objPopBidAdObject = FLTopOnInitManager.getInstance().popBidAdObject(str3);
            if (objPopBidAdObject instanceof SpreadLoadListener.SpreadAd) {
                if (this.mSpreadAd == null) {
                    this.mSpreadAd = (SpreadLoadListener.SpreadAd) objPopBidAdObject;
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
        YdSpread ydSpread = this.ydSpread;
        if (ydSpread != null) {
            ydSpread.biddingResultUpload(false, (int) (d * 100.0d), 0);
        }
    }

    public void notifyBidWin(double d, double d2, Map<String, Object> map) {
        YdSpread ydSpread = this.ydSpread;
        if (ydSpread != null) {
            ydSpread.biddingResultUpload(true, (int) (d * 100.0d), (int) (d2 * 100.0d));
        }
    }

    public void show(Activity activity, ViewGroup viewGroup) {
        SpreadLoadListener.SpreadAd spreadAd = this.mSpreadAd;
        if (spreadAd == null || viewGroup == null) {
            return;
        }
        spreadAd.show(activity, viewGroup);
    }

    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, final ATBiddingListener aTBiddingListener) {
        String str = TAG;
        LogcatUtil.d(str, "startBiddingRequest");
        this.mContext = context;
        String str2 = (String) map.get("slot_id");
        this.slotId = str2;
        if (!TextUtils.isEmpty(str2)) {
            FLTopOnInitManager.getInstance().initSDK(context, map, new FLTopOnInitManager.InitCallback() { // from class: com.fl.saas.s2s.topon.FLTopOnSplashAdapter.1
                @Override // com.fl.saas.s2s.topon.FLTopOnInitManager.InitCallback
                public void onFinish() {
                    FLTopOnSplashAdapter.this.startLoad(aTBiddingListener);
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
