package com.kwad.components.ad.reward;

import android.app.Activity;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy;
import com.kwad.sdk.api.KsInnerAd;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.api.model.KSAdInfoData;
import com.kwad.sdk.core.response.model.AdGlobalConfigInfo;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class KsRewardVideoAdControl implements com.kwad.components.core.internal.api.a, KsRewardVideoAd {
    private final AdInfo mAdInfo;

    @NonNull
    private final AdResultData mAdResultData;

    @NonNull
    private final AdTemplate mAdTemplate;
    private final AdGlobalConfigInfo sk;
    private com.kwad.components.ad.reward.e.h sl;
    private com.kwad.components.core.j.d sm;
    private com.kwad.components.ad.reward.retryReward.e sn;
    private boolean so;
    private com.kwad.components.core.internal.api.c bz = new com.kwad.components.core.internal.api.c();
    public int rewardType = 1;

    public KsRewardVideoAdControl(@NonNull AdResultData adResultData) {
        this.mAdResultData = adResultData;
        AdTemplate adTemplateR = com.kwad.sdk.core.response.helper.c.r(adResultData);
        this.mAdTemplate = adTemplateR;
        this.mAdInfo = com.kwad.sdk.core.response.helper.e.eO(adTemplateR);
        this.sk = adResultData.adGlobalConfigInfo;
        gC();
    }

    private void gC() {
        com.kwad.components.ad.i.b.gd().a(this);
        AdGlobalConfigInfo adGlobalConfigInfo = this.sk;
        boolean z = adGlobalConfigInfo != null && adGlobalConfigInfo.isNeoScan();
        this.mAdTemplate.isNativeRewardPreview = com.kwad.sdk.core.response.helper.a.cm(this.mAdInfo) && !z;
    }

    private void gD() {
        AdInfo adInfo;
        if (com.kwad.components.ad.reward.c.c.a(this.sl) || (adInfo = this.mAdInfo) == null) {
            return;
        }
        adInfo.adBaseInfo.extraClickReward = false;
    }

    @Override // com.kwad.components.core.internal.api.a
    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public int getECPM() {
        return com.kwad.sdk.core.response.helper.a.aX(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public int getInteractionType() {
        return com.kwad.sdk.core.response.helper.a.aW(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public List<KSAdInfoData> getKSAdInfoDatas() {
        AdResultData adResultData;
        ArrayList arrayList = new ArrayList();
        if (com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aPU) && (adResultData = this.mAdResultData) != null && adResultData.getAdTemplateList().size() > 0) {
            Iterator<AdTemplate> it = this.mAdResultData.getAdTemplateList().iterator();
            while (it.hasNext()) {
                arrayList.add(com.kwad.sdk.core.response.helper.a.dr(com.kwad.sdk.core.response.helper.e.eO(it.next())));
            }
        }
        return arrayList;
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public int getMaterialType() {
        return com.kwad.sdk.core.response.helper.a.bk(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.BaseKSAd
    public Map<String, Object> getMediaExtraInfo() {
        HashMap map = new HashMap();
        if (com.kwad.sdk.core.config.e.JP()) {
            map.put("llsid", Long.valueOf(this.mAdTemplate.llsid));
        }
        return map;
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public boolean isAdEnable() {
        if (com.kwad.sdk.core.response.helper.e.fe(this.mAdTemplate) >= 0) {
            return true;
        }
        return com.kwad.components.core.video.k.bh(this.mAdTemplate);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public void reportAdExposureFailed(int i, AdExposureFailedReason adExposureFailedReason) {
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, i, adExposureFailedReason);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public void setBidEcpm(int i) {
        setBidEcpm(i, -1L);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public void setInnerAdInteractionListener(KsInnerAd.KsInnerAdInteractionListener ksInnerAdInteractionListener) {
        this.sm = new com.kwad.components.core.j.d(ksInnerAdInteractionListener);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public void setRewardAdInteractionListener(KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        if (this.sl == null) {
            this.sl = new com.kwad.components.ad.reward.e.h() { // from class: com.kwad.components.ad.reward.KsRewardVideoAdControl.1
                @Override // com.kwad.components.ad.reward.e.h, com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public final void onAdClicked() {
                    super.onAdClicked();
                    if (KsRewardVideoAdControl.this.sn == null || !com.kwad.sdk.core.response.helper.a.dp(KsRewardVideoAdControl.this.mAdInfo) || KsRewardVideoAdControl.this.so || !com.kwad.components.ad.reward.retryReward.e.kJ() || KsRewardVideoAdControl.this.mAdTemplate.isCheatingFlow()) {
                        return;
                    }
                    KSAdInfoData kSAdInfoDataDr = com.kwad.sdk.core.response.helper.a.dr(KsRewardVideoAdControl.this.mAdInfo);
                    int i = KsRewardVideoAdControl.this.mAdInfo.adRewardInfo.rewardRetryTaskInfo.retryMaxTime;
                    String strValueOf = String.valueOf(KsRewardVideoAdControl.this.mAdTemplate.llsid);
                    kSAdInfoDataDr.setLlisd(strValueOf);
                    com.kwad.components.ad.reward.retryReward.f fVar = new com.kwad.components.ad.reward.retryReward.f(strValueOf, KsRewardVideoAdControl.this.mAdTemplate, i);
                    com.kwad.components.ad.reward.retryReward.d.kF().a(strValueOf, fVar);
                    KsRewardVideoAdControl.this.sn.onAdRewardRetryTaskNotify(kSAdInfoDataDr);
                    com.kwad.components.ad.reward.retryReward.b.a(fVar);
                    KsRewardVideoAdControl.a(KsRewardVideoAdControl.this, true);
                }

                @Override // com.kwad.components.ad.reward.e.h, com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public final void onPageDismiss() {
                    super.onPageDismiss();
                    KsRewardVideoAdControl.this.bz.i(KsRewardVideoAdControl.this);
                }

                @Override // com.kwad.components.ad.reward.e.h, com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public final void onRewardVerify(Map<String, Object> map) {
                    super.onRewardVerify(map);
                }

                @Override // com.kwad.components.ad.reward.e.h, com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public final void onVideoPlayStart() {
                    super.onVideoPlayStart();
                    KsRewardVideoAdControl.this.bz.h(KsRewardVideoAdControl.this);
                }
            };
        }
        this.sl.b(rewardAdInteractionListener);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public void setRewardAdRetryTaskCallback(KsRewardVideoAd.KSAdRewardRetryTaskListener kSAdRewardRetryTaskListener) {
        if (kSAdRewardRetryTaskListener == null) {
            return;
        }
        com.kwad.components.ad.reward.retryReward.e eVarKI = com.kwad.components.ad.reward.retryReward.e.kI();
        this.sn = eVarKI;
        if (eVarKI != null) {
            eVarKI.e(kSAdRewardRetryTaskListener);
        }
    }

    @Keep
    public void setRewardPlayAgainInteractionListener(KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public void showRewardVideoAd(Activity activity, KsVideoPlayConfig ksVideoPlayConfig) {
        if (activity == null || activity.isFinishing()) {
            com.kwad.sdk.core.d.c.e("KsRewardVideoAdControl", "showRewardVideoAd error, activity is null or finished");
            com.kwad.components.ad.reward.monitor.d.b(true, this.mAdTemplate, "illegal_activity");
            return;
        }
        com.kwad.components.ad.reward.monitor.d.h(true, this.mAdTemplate);
        com.kwad.sdk.commercial.convert.c.cg(this.mAdTemplate);
        if (!com.kwad.sdk.core.config.e.KB() && !isAdEnable()) {
            com.kwad.sdk.core.d.c.i("KsRewardVideoAdControl", "isAdEnable is false");
            com.kwad.components.ad.reward.monitor.d.b(true, this.mAdTemplate, "cache_not_ready");
        } else {
            if (ksVideoPlayConfig == null) {
                ksVideoPlayConfig = new KsVideoPlayConfig.Builder().build();
            }
            a(activity, ksVideoPlayConfig);
        }
    }

    @Override // com.kwad.components.core.internal.api.a
    public final boolean supportPushAd() {
        return true;
    }

    public static /* synthetic */ boolean a(KsRewardVideoAdControl ksRewardVideoAdControl, boolean z) {
        ksRewardVideoAdControl.so = true;
        return true;
    }

    @Override // com.kwad.components.core.internal.api.a
    public final void b(com.kwad.components.core.internal.api.b bVar) {
        this.bz.b(bVar);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public void setBidEcpm(long j, long j2) {
        AdTemplate adTemplate = this.mAdTemplate;
        adTemplate.mBidEcpm = j;
        com.kwad.sdk.core.adlog.c.m(adTemplate, j2);
    }

    @Override // com.kwad.components.core.internal.api.a
    public final void a(com.kwad.components.core.internal.api.b bVar) {
        this.bz.a(bVar);
    }

    private void a(Activity activity, @NonNull KsVideoPlayConfig ksVideoPlayConfig) {
        gD();
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate.isNativeRewardPreview) {
            AdRewardPreviewActivityProxy.launch(activity, this.mAdResultData, adTemplate, com.kwad.sdk.core.response.helper.a.aY(this.mAdInfo), this.sl);
        } else {
            KSRewardVideoActivityProxy.launch(activity, this.mAdResultData, ksVideoPlayConfig, this.sl, this.sm, this.rewardType);
        }
    }
}
