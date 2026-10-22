package com.example.topon_adapter.adapter;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.splashad.unitgroup.api.CustomSplashAdapter;
import com.anythink.splashad.unitgroup.api.CustomSplashEventListener;
import com.ltmb.ltsdk.core.LTAdSdk;
import com.ltmb.ltsdk.core.load.slot.LTAdSlot;
import com.ltmb.ltsdk.core.load.splash.LTAdSplashEventListener;
import com.ltmb.ltsdk.core.load.splash.LTAdSplashLoadListener;
import com.ltmb.ltsdk.core.load.splash.LTSplashAd;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class LtAdSplashAdapter extends CustomSplashAdapter {
    private Context context;
    private LTAdSlot ltAdSlot;
    private String mAdId;
    private LTSplashAd mSplashView;

    private void beforeLoader(Context context, Map<String, Object> map, final boolean z) {
        String stringFromMap = ATInitMediation.getStringFromMap(map, "slot_id");
        this.mAdId = stringFromMap;
        if (TextUtils.isEmpty(stringFromMap)) {
            notifyATLoadFail("", "LTMB adId is empty.");
        } else {
            final Context applicationContext = context.getApplicationContext();
            LtAdInitManager.getInstance().initSDK(context, map, new MediationInitCallback() { // from class: com.example.topon_adapter.adapter.LtAdSplashAdapter.1
                public void onFail(String str) {
                    LtAdSplashAdapter.this.notifyATLoadFail("0", str);
                }

                public void onSuccess() {
                    LtAdSplashAdapter.this.startLoadAd(applicationContext, z);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$show$0(ViewGroup viewGroup, Activity activity) {
        try {
            if (viewGroup instanceof FrameLayout) {
                viewGroup.removeAllViews();
                this.mSplashView.showAd(viewGroup);
                return;
            }
            FrameLayout frameLayout = new FrameLayout(activity);
            ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            viewGroup.removeAllViews();
            viewGroup.addView(frameLayout, layoutParams);
            this.mSplashView.showAd(frameLayout);
        } catch (Throwable unused) {
            CustomSplashEventListener customSplashEventListener = ((CustomSplashAdapter) this).mImpressionListener;
            if (customSplashEventListener != null) {
                ((CustomSplashAdapter) this).mDismissType = 99;
                customSplashEventListener.onSplashAdShowFail(ErrorCode.getErrorCode("4006", "", "LTMB Splash show with exception"));
                ((CustomSplashAdapter) this).mImpressionListener.onSplashAdDismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEventListener() {
        this.mSplashView.setLTAdEventListener(new LTAdSplashEventListener() { // from class: com.example.topon_adapter.adapter.LtAdSplashAdapter.3
            public void onAdClicked() {
                if (((CustomSplashAdapter) LtAdSplashAdapter.this).mImpressionListener != null) {
                    ((CustomSplashAdapter) LtAdSplashAdapter.this).mImpressionListener.onSplashAdClicked();
                }
            }

            public void onAdRenderFail(int i, String str) {
                if (((CustomSplashAdapter) LtAdSplashAdapter.this).mImpressionListener != null) {
                    ((CustomSplashAdapter) LtAdSplashAdapter.this).mDismissType = 99;
                    ((CustomSplashAdapter) LtAdSplashAdapter.this).mImpressionListener.onSplashAdShowFail(ErrorCode.getErrorCode("4006", "" + i, str));
                    ((CustomSplashAdapter) LtAdSplashAdapter.this).mImpressionListener.onSplashAdDismiss();
                }
            }

            public void onAdShow() {
                if (((CustomSplashAdapter) LtAdSplashAdapter.this).mImpressionListener != null) {
                    ((CustomSplashAdapter) LtAdSplashAdapter.this).mImpressionListener.onSplashAdShow();
                }
            }

            public void onAdSkip() {
                if (((CustomSplashAdapter) LtAdSplashAdapter.this).mImpressionListener != null) {
                    ((CustomSplashAdapter) LtAdSplashAdapter.this).mImpressionListener.onSplashAdDismiss();
                }
            }

            public void onClosed() {
                if (((CustomSplashAdapter) LtAdSplashAdapter.this).mImpressionListener != null) {
                    ((CustomSplashAdapter) LtAdSplashAdapter.this).mImpressionListener.onSplashAdDismiss();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLoadAd(Context context, final boolean z) {
        this.context = context;
        this.ltAdSlot = new LTAdSlot.Builder().setAdId(this.mAdId).setRequestAdSize(getWidth(), getHeight()).setTimeout(((CustomSplashAdapter) this).mFetchAdTimeout).build();
        LTAdSdk.getInstance().getLTAdSplashLoader(this.ltAdSlot, new LTAdSplashLoadListener() { // from class: com.example.topon_adapter.adapter.LtAdSplashAdapter.2
            public void onAdLoadFailed(int i, String str) {
                if (((CustomSplashAdapter) LtAdSplashAdapter.this).mImpressionListener != null) {
                    ((CustomSplashAdapter) LtAdSplashAdapter.this).mDismissType = 99;
                    ((CustomSplashAdapter) LtAdSplashAdapter.this).mImpressionListener.onSplashAdShowFail(ErrorCode.getErrorCode("4006", "" + i, str));
                    ((CustomSplashAdapter) LtAdSplashAdapter.this).mImpressionListener.onSplashAdDismiss();
                }
                LtAdSplashAdapter.this.notifyATLoadFail(String.valueOf(i), str);
            }

            public void onLoaded(LTSplashAd lTSplashAd) {
                LtAdSplashAdapter.this.mSplashView = lTSplashAd;
                if (!z) {
                    if (((CustomSplashAdapter) LtAdSplashAdapter.this).mLoadListener != null) {
                        ((CustomSplashAdapter) LtAdSplashAdapter.this).mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                        LtAdSplashAdapter.this.setEventListener();
                        return;
                    }
                    return;
                }
                LtAdSplashAdapter ltAdSplashAdapter = LtAdSplashAdapter.this;
                if (((CustomSplashAdapter) ltAdSplashAdapter).mBiddingListener != null) {
                    LtAdBiddingNotice ltAdBiddingNotice = new LtAdBiddingNotice(ltAdSplashAdapter.mSplashView);
                    ((CustomSplashAdapter) LtAdSplashAdapter.this).mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(lTSplashAd.getEcpm(), String.valueOf(System.currentTimeMillis()), ltAdBiddingNotice, ATAdConst.CURRENCY.RMB_CENT), (BaseAd) null);
                    LtAdSplashAdapter.this.setEventListener();
                }
            }
        });
    }

    public void destory() {
        LTSplashAd lTSplashAd = this.mSplashView;
        if (lTSplashAd != null) {
            lTSplashAd.destroy();
        }
    }

    public int getHeight() {
        return this.context.getResources().getDisplayMetrics().heightPixels;
    }

    public ATInitMediation getMediationInitManager() {
        return LtAdInitManager.getInstance();
    }

    public String getNetworkName() {
        return LtAdInitManager.getInstance().getNetworkName();
    }

    public String getNetworkPlacementId() {
        return this.mAdId;
    }

    public String getNetworkSDKVersion() {
        return LtAdInitManager.getInstance().getNetworkVersion();
    }

    public int getWidth() {
        return this.context.getResources().getDisplayMetrics().widthPixels;
    }

    public boolean isAdReady() {
        LTSplashAd lTSplashAd = this.mSplashView;
        return (lTSplashAd == null || lTSplashAd.isDestroy() || this.mSplashView.isExpired() || !this.mSplashView.isReady()) ? false : true;
    }

    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        beforeLoader(context, map, false);
    }

    public void show(final Activity activity, final ViewGroup viewGroup) {
        if (viewGroup == null) {
            CustomSplashEventListener customSplashEventListener = ((CustomSplashAdapter) this).mImpressionListener;
            if (customSplashEventListener != null) {
                ((CustomSplashAdapter) this).mDismissType = 99;
                customSplashEventListener.onSplashAdShowFail(ErrorCode.getErrorCode("4006", "", "Container is null"));
                ((CustomSplashAdapter) this).mImpressionListener.onSplashAdDismiss();
                return;
            }
            return;
        }
        LTSplashAd lTSplashAd = this.mSplashView;
        if (lTSplashAd != null && lTSplashAd.isReady()) {
            viewGroup.post(new Runnable() { // from class: com.zj.adlib.u45
                @Override // java.lang.Runnable
                public final void run() {
                    this.f19961a.lambda$show$0(viewGroup, activity);
                }
            });
            return;
        }
        CustomSplashEventListener customSplashEventListener2 = ((CustomSplashAdapter) this).mImpressionListener;
        if (customSplashEventListener2 != null) {
            ((CustomSplashAdapter) this).mDismissType = 99;
            customSplashEventListener2.onSplashAdShowFail(ErrorCode.getErrorCode("4006", "", "LTMB Splash is not ready"));
            ((CustomSplashAdapter) this).mImpressionListener.onSplashAdDismiss();
        }
    }

    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        beforeLoader(context, map, true);
        return true;
    }
}
