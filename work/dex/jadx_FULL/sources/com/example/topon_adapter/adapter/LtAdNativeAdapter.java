package com.example.topon_adapter.adapter;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.ATCustomLoadListener;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.nativead.unitgroup.api.CustomNativeAdapter;
import com.ltmb.ltsdk.core.LTAdSdk;
import com.ltmb.ltsdk.core.load.draw.LTAdDrawLoadListener;
import com.ltmb.ltsdk.core.load.draw.LTDrawAd;
import com.ltmb.ltsdk.core.load.slot.LTAdSlot;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class LtAdNativeAdapter extends CustomNativeAdapter {
    private LTDrawAd ltDrawAd;
    private String mAdId;
    private int mUnitType;

    private void beforeLoader(final Context context, Map<String, Object> map, final boolean z) {
        this.mUnitType = ATInitMediation.getIntFromMap(map, "unit_type", 2);
        String stringFromMap = ATInitMediation.getStringFromMap(map, "slot_id");
        this.mAdId = stringFromMap;
        if (TextUtils.isEmpty(stringFromMap)) {
            notifyATLoadFail("0", "Ltmb appId or adId is empty.");
        } else {
            LtAdInitManager.getInstance().initSDK(context, map, new MediationInitCallback() { // from class: com.example.topon_adapter.adapter.LtAdNativeAdapter.1
                public void onFail(String str) {
                    LtAdNativeAdapter.this.notifyATLoadFail("0", str);
                }

                public void onSuccess() {
                    LtAdNativeAdapter.this.startLoadAd(context, z);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadCustomDrawAd(LTDrawAd lTDrawAd, boolean z) {
        if (z) {
            if (((CustomNativeAdapter) this).mBiddingListener != null) {
                ((CustomNativeAdapter) this).mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(lTDrawAd.getEcpm(), String.valueOf(System.currentTimeMillis()), new LtAdBiddingNotice(lTDrawAd), ATAdConst.CURRENCY.RMB_CENT), new LtAdNativeAd(null, lTDrawAd));
            }
        } else {
            ATCustomLoadListener aTCustomLoadListener = ((CustomNativeAdapter) this).mLoadListener;
            if (aTCustomLoadListener != null) {
                aTCustomLoadListener.onAdCacheLoaded(new BaseAd[]{new LtAdNativeAd(null, lTDrawAd)});
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadExpressAd(LTDrawAd lTDrawAd, boolean z) {
        if (z) {
            if (((CustomNativeAdapter) this).mBiddingListener != null) {
                ((CustomNativeAdapter) this).mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(lTDrawAd.getEcpm(), String.valueOf(System.currentTimeMillis()), new LtAdBiddingNotice(lTDrawAd), ATAdConst.CURRENCY.RMB_CENT), new LtAdNativeAd(null, lTDrawAd));
            }
        } else {
            ATCustomLoadListener aTCustomLoadListener = ((CustomNativeAdapter) this).mLoadListener;
            if (aTCustomLoadListener != null) {
                aTCustomLoadListener.onAdCacheLoaded(new BaseAd[]{new LtAdNativeAd(null, lTDrawAd)});
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLoadAd(Context context, final boolean z) {
        LTAdSdk.getInstance().getLTAdDrawLoader(new LTAdSlot.Builder().setAdId(this.mAdId).setRequestAdSize(1080, 1920).setAdCount(1).build(), new LTAdDrawLoadListener() { // from class: com.example.topon_adapter.adapter.LtAdNativeAdapter.2
            public void onAdLoadFailed(int i, String str) {
                LtAdNativeAdapter.this.notifyATLoadFail(String.valueOf(i), str);
            }

            public void onLoaded(LTDrawAd lTDrawAd) {
                LtAdNativeAdapter.this.ltDrawAd = lTDrawAd;
                if (lTDrawAd == null) {
                    LtAdNativeAdapter.this.notifyATLoadFail(String.valueOf(0), "draw ad = null");
                } else if (lTDrawAd.isExpress()) {
                    LtAdNativeAdapter.this.loadExpressAd(lTDrawAd, z);
                } else {
                    LtAdNativeAdapter.this.loadCustomDrawAd(lTDrawAd, z);
                }
            }
        });
    }

    public void destory() {
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
        return LtAdInitManager.getInstance().getNetworkSDKVersion();
    }

    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        beforeLoader(context, map, false);
    }

    public boolean setUserDataConsent(Context context, boolean z, boolean z2) {
        return LtAdInitManager.getInstance().setUserDataConsent(context, z, z2);
    }

    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        beforeLoader(context, map, true);
        return true;
    }
}
