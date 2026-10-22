package com.ltmb.beiziadapter;

import android.content.Context;
import com.ltmb.beiziadapter.unified.UnifiedRender;
import com.ltmb.ltsdk.core.LTAdSdk;
import com.ltmb.ltsdk.core.load.draw.LTAdDrawLoadListener;
import com.ltmb.ltsdk.core.load.draw.LTDrawAd;
import com.ltmb.ltsdk.core.load.slot.LTAdSlot;
import java.util.ArrayList;
import xyz.adscope.amps.ad.unified.adapter.AMPSUnifiedNativeAdAdapterListener;
import xyz.adscope.amps.ad.unified.adapter.AMPSUnifiedNativeAdapter;
import xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem;
import xyz.adscope.amps.ad.unified.inter.AMPSVideoConfig;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.init.inter.IAMPSChannelInitCallBack;
import xyz.adscope.amps.inner.AMPSAdBiddingListener;
import xyz.adscope.amps.model.AMPSAdapterModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class BeiziUnifiedNativeAdapter extends AMPSUnifiedNativeAdapter<LTDrawAd> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public UnifiedRender f40258a;
    public LTDrawAd b;

    /* JADX INFO: Access modifiers changed from: private */
    public void callLoadAdFail(String str, String str2) {
        onAdFailed(str, str2);
    }

    private LTAdSlot createLTAdSlot() {
        return new LTAdSlot.Builder().setAdId(((AMPSUnifiedNativeAdapter) this).mSpaceId).setAdCount(1).setRequestAdSize(((AMPSUnifiedNativeAdapter) this).mContext.getResources().getDisplayMetrics().widthPixels, (int) (((AMPSUnifiedNativeAdapter) this).mContext.getResources().getDisplayMetrics().widthPixels * 0.4f)).build();
    }

    private void initSDK() {
        BeiziInitAdapter.getInstance().initSDK(((AMPSUnifiedNativeAdapter) this).mInitAdapterConfig, new IAMPSChannelInitCallBack() { // from class: com.ltmb.beiziadapter.BeiziUnifiedNativeAdapter.1
            public void failCallBack(AMPSError aMPSError) {
                BeiziUnifiedNativeAdapter.this.callLoadAdFail(aMPSError.getCode(), aMPSError.getMessage());
            }

            public void successCallBack() {
                BeiziUnifiedNativeAdapter.this.loadAd();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAd() {
        LTAdSdk.getInstance().getLTAdDrawLoader(createLTAdSlot(), new LTAdDrawLoadListener() { // from class: com.ltmb.beiziadapter.BeiziUnifiedNativeAdapter.2
            public void onAdLoadFailed(int i, String str) {
                BeiziUnifiedNativeAdapter.this.callLoadAdFail(String.valueOf(i), str);
            }

            public void onLoaded(LTDrawAd lTDrawAd) {
                if (lTDrawAd == null) {
                    BeiziUnifiedNativeAdapter.this.callLoadAdFail("0", "广告为空");
                    return;
                }
                if (lTDrawAd.isExpress() || lTDrawAd.getDrawAdDataSource() == null) {
                    BeiziUnifiedNativeAdapter.this.callLoadAdFail("0", "非自渲染广告，请检查广告类型。");
                    return;
                }
                BeiziUnifiedNativeAdapter.this.b = lTDrawAd;
                ArrayList arrayList = new ArrayList();
                arrayList.add(lTDrawAd);
                BeiziUnifiedNativeAdapter.this.convertAdapterResponse(arrayList);
                BeiziUnifiedNativeAdapter beiziUnifiedNativeAdapter = BeiziUnifiedNativeAdapter.this;
                if (((AMPSUnifiedNativeAdapter) beiziUnifiedNativeAdapter).isBidding) {
                    beiziUnifiedNativeAdapter.onC2SBiddingSuccess((int) lTDrawAd.getEcpm());
                } else {
                    beiziUnifiedNativeAdapter.onAdLoad();
                }
            }
        });
    }

    public boolean isValid() {
        LTDrawAd lTDrawAd = this.b;
        return (lTDrawAd == null || !lTDrawAd.isReady() || this.b.isDestroy()) ? false : true;
    }

    public void startBid(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSAdBiddingListener aMPSAdBiddingListener) {
        super.startBid(context, aMPSAdapterModel, aMPSAdBiddingListener);
        initSDK();
    }

    public AMPSUnifiedNativeItem convertEntryFromAdapterResponse(LTDrawAd lTDrawAd) {
        if (this.f40258a == null) {
            this.f40258a = new UnifiedRender(lTDrawAd, ((AMPSUnifiedNativeAdapter) this).mContext, (int) lTDrawAd.getEcpm(), new AMPSVideoConfig(false, 0), this);
        }
        return this.f40258a;
    }

    public void loadNetworkAd(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSUnifiedNativeAdAdapterListener aMPSUnifiedNativeAdAdapterListener) {
        super.loadNetworkAd(context, aMPSAdapterModel, aMPSUnifiedNativeAdAdapterListener);
        if (((AMPSUnifiedNativeAdapter) this).isBidding) {
            onAdLoad();
        } else {
            initSDK();
        }
    }
}
