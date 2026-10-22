package com.ltmb.gromoreadapter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.camera.video.AudioStats;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationViewBinder;
import com.bytedance.sdk.openadsdk.mediation.bridge.custom.banner.MediationCustomBannerLoader;
import com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomServiceConfig;
import com.ltmb.ltsdk.core.LTAdSdk;
import com.ltmb.ltsdk.core.load.banner.LTAdBannerEventListener;
import com.ltmb.ltsdk.core.load.banner.LTAdBannerLoadListener;
import com.ltmb.ltsdk.core.load.banner.LTBannerAd;
import com.ltmb.ltsdk.core.load.slot.LTAdSlot;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class LTAdBannerGroMoreLoader extends MediationCustomBannerLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LTBannerAd f40266a;
    public Context b;

    public static class AdViewHolder {
        private AdViewHolder() {
        }
    }

    public static class GroupAdViewHolder extends AdViewHolder {
        private GroupAdViewHolder() {
            super();
        }
    }

    public static class LargeAdViewHolder extends AdViewHolder {
        private LargeAdViewHolder() {
            super();
        }
    }

    public static class SmallAdViewHolder extends AdViewHolder {
        private SmallAdViewHolder() {
            super();
        }
    }

    public static class VerticalAdViewHolder extends AdViewHolder {
        private VerticalAdViewHolder() {
            super();
        }
    }

    public static class VideoAdViewHolder extends AdViewHolder {
        private VideoAdViewHolder() {
            super();
        }
    }

    private void bindData(View view, AdViewHolder adViewHolder, IMediationNativeAdInfo iMediationNativeAdInfo, MediationViewBinder mediationViewBinder) {
        setDownLoadAppInfo(iMediationNativeAdInfo, adViewHolder);
        ArrayList arrayList = new ArrayList();
        arrayList.add(view);
        adViewHolder.getClass();
        arrayList.add(null);
        arrayList.add(null);
        arrayList.add(null);
        arrayList.add(null);
        if (adViewHolder instanceof LargeAdViewHolder) {
            arrayList.add(null);
        } else if (adViewHolder instanceof SmallAdViewHolder) {
            arrayList.add(null);
        } else if (adViewHolder instanceof VerticalAdViewHolder) {
            arrayList.add(null);
        } else if (adViewHolder instanceof VideoAdViewHolder) {
            arrayList.add(null);
        } else if (adViewHolder instanceof GroupAdViewHolder) {
            arrayList.add(null);
            arrayList.add(null);
            arrayList.add(null);
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(null);
        iMediationNativeAdInfo.registerView((Activity) this.b, (ViewGroup) view, arrayList, arrayList2, null, mediationViewBinder);
        iMediationNativeAdInfo.getTitle();
        throw null;
    }

    private String getPermissionsContent(Map<String, String> map) {
        if (map == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : map.keySet()) {
            stringBuffer.append(str + " : " + map.get(str) + " \n");
        }
        return stringBuffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$load$0(Context context, MediationCustomServiceConfig mediationCustomServiceConfig) {
        this.b = context;
        LTAdSdk.getInstance().getLTAdBannerLoader(new LTAdSlot.Builder().setAdId(mediationCustomServiceConfig.getADNNetworkSlotId()).build(), new LTAdBannerLoadListener() { // from class: com.ltmb.gromoreadapter.LTAdBannerGroMoreLoader.1
            public void onAdLoadFailed(int i, String str) {
                LTAdBannerGroMoreLoader.this.callLoadFail(i, str);
                Log.d("TAG..", str);
            }

            public void onLoaded(LTBannerAd lTBannerAd) {
                LTAdBannerGroMoreLoader.this.f40266a = lTBannerAd;
                lTBannerAd.setLTAdEventListener(new LTAdBannerEventListener() { // from class: com.ltmb.gromoreadapter.LTAdBannerGroMoreLoader.1.1
                    public void onAdClicked() {
                        LTAdBannerGroMoreLoader.this.callBannerAdClick();
                    }

                    public void onAdRenderFail(int i, String str) {
                        LTAdBannerGroMoreLoader.this.callLoadFail(i, str);
                    }

                    public void onAdShow() {
                        LTAdBannerGroMoreLoader.this.callBannerAdShow();
                    }

                    public void onClosed() {
                        LTAdBannerGroMoreLoader.this.callBannerAdClosed();
                    }
                });
                if (lTBannerAd.getEcpm() >= AudioStats.AUDIO_AMPLITUDE_NONE) {
                    LTAdBannerGroMoreLoader.this.callLoadSuccess(lTBannerAd.getEcpm());
                } else {
                    LTAdBannerGroMoreLoader.this.callLoadSuccess();
                }
                Log.e("广告加载成功", "ecpm=" + lTBannerAd.getEcpm());
            }
        });
    }

    private void setDownLoadAppInfo(IMediationNativeAdInfo iMediationNativeAdInfo, AdViewHolder adViewHolder) {
        if (adViewHolder == null) {
            return;
        }
        if (iMediationNativeAdInfo != null && iMediationNativeAdInfo.getNativeAdAppInfo() != null) {
            throw null;
        }
        throw null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.banner.MediationCustomBannerLoader
    public View getAdView() {
        if (this.f40266a != null) {
            return new BannerAdKeView(this.b, this.f40266a);
        }
        return null;
    }

    public boolean isClientBidding() {
        LTBannerAd lTBannerAd = this.f40266a;
        return lTBannerAd != null && lTBannerAd.getEcpm() > AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomAdBaseLoader
    public void load(final Context context, AdSlot adSlot, final MediationCustomServiceConfig mediationCustomServiceConfig) {
        ThreadUtils.runOnThreadPool(new Runnable() { // from class: com.zj.adlib.au4
            @Override // java.lang.Runnable
            public final void run() {
                this.f15397a.lambda$load$0(context, mediationCustomServiceConfig);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomAdBaseLoader
    public void onDestroy() {
        super.onDestroy();
        Log.i("KsCustomerBanner", "onDestroy");
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomAdBaseLoader
    public void onPause() {
        super.onPause();
        Log.i("KsCustomerBanner", "onPause");
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomAdBaseLoader
    public void onResume() {
        super.onResume();
        Log.i("KsCustomerBanner", "onResume");
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomAdBaseLoader
    public void receiveBidResult(boolean z, double d, int i, Map<String, Object> map) {
        super.receiveBidResult(z, d, i, map);
        Log.d("KsCustomerBanner", "receiveBidResult: win: " + z + ", winnerPrice: " + d + ", loseReason: " + i + ", extra: " + map);
    }

    public void removeSelfFromParent(View view) {
        if (view != null) {
            try {
                ViewParent parent = view.getParent();
                if (parent == null || !(parent instanceof ViewGroup)) {
                    return;
                }
                ((ViewGroup) parent).removeView(view);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
