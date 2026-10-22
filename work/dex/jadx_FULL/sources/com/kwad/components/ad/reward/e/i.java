package com.kwad.components.ad.reward.e;

import com.kwad.components.ad.reward.monitor.RewardInteractionCallbackType;
import com.kwad.components.ad.reward.monitor.RewardMonitorInfo;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class i extends c {
    private static String vt = "IS_FRAUD";
    private static String vu = "IS_FRAUD_ERROR_CODE";
    private AdTemplate mAdTemplate;
    private com.kwad.components.ad.reward.g uj;
    private String vr;
    private Map<String, Object> vs = new HashMap();

    private String getUniqueId() {
        return this.vr;
    }

    private KsRewardVideoAd.RewardAdInteractionListener io() {
        return f.O(getUniqueId());
    }

    public final void S(String str) {
        this.vr = str;
    }

    @Override // com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
    public void dc() {
        super.dc();
        KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListenerIo = io();
        if (rewardAdInteractionListenerIo != null) {
            rewardAdInteractionListenerIo.onAdClicked();
        }
        com.kwad.components.ad.reward.monitor.d.a(true, (com.kwad.components.ad.reward.monitor.a) RewardInteractionCallbackType.AD_CLICK, this.mAdTemplate, (com.kwad.sdk.g.a<RewardMonitorInfo>) null);
    }

    @Override // com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
    public void i(boolean z) {
        super.i(z);
        KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListenerIo = io();
        if (rewardAdInteractionListenerIo != null) {
            rewardAdInteractionListenerIo.onPageDismiss();
        }
        com.kwad.components.ad.reward.monitor.d.a(true, (com.kwad.components.ad.reward.monitor.a) RewardInteractionCallbackType.PAGE_DISMISS, this.mAdTemplate, (com.kwad.sdk.g.a<RewardMonitorInfo>) null);
    }

    public final boolean in() {
        KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListenerIo = io();
        if (rewardAdInteractionListenerIo != null) {
            if (com.kwad.sdk.core.response.helper.a.m1063do(com.kwad.sdk.core.response.helper.e.eO(this.uj.mAdTemplate))) {
                this.vs.put(vt, Boolean.valueOf(this.uj.sW == 3));
                this.vs.put(vu, Integer.valueOf(this.uj.sX));
                com.kwad.components.ad.reward.g gVar = this.uj;
                com.kwad.components.ad.reward.monitor.d.j(gVar.mAdTemplate, gVar.sW, gVar.sX);
            }
            try {
                rewardAdInteractionListenerIo.onRewardVerify(this.vs);
            } catch (Throwable unused) {
            }
            rewardAdInteractionListenerIo.onRewardVerify();
        }
        com.kwad.components.ad.reward.monitor.d.a(true, (com.kwad.components.ad.reward.monitor.a) RewardInteractionCallbackType.REWARD_VERIFY, this.mAdTemplate, (com.kwad.sdk.g.a<RewardMonitorInfo>) null);
        return rewardAdInteractionListenerIo != null;
    }

    @Override // com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
    public void onRewardVerify() {
        super.onRewardVerify();
    }

    @Override // com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
    public final void onVideoPlayEnd() {
        super.onVideoPlayEnd();
        KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListenerIo = io();
        if (rewardAdInteractionListenerIo != null) {
            rewardAdInteractionListenerIo.onVideoPlayEnd();
        }
        com.kwad.components.ad.reward.monitor.d.a(true, (com.kwad.components.ad.reward.monitor.a) RewardInteractionCallbackType.VIDEO_PLAY_END, this.mAdTemplate, (com.kwad.sdk.g.a<RewardMonitorInfo>) null);
    }

    @Override // com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
    public final void onVideoPlayError(int i, int i2) {
        super.onVideoPlayError(i, i2);
        KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListenerIo = io();
        if (rewardAdInteractionListenerIo != null) {
            rewardAdInteractionListenerIo.onVideoPlayError(i, i2);
        }
        com.kwad.components.ad.reward.monitor.d.a(true, (com.kwad.components.ad.reward.monitor.a) RewardInteractionCallbackType.VIDEO_PLAY_ERROR, this.mAdTemplate, (com.kwad.sdk.g.a<RewardMonitorInfo>) null);
    }

    @Override // com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
    public final void onVideoPlayStart() {
        super.onVideoPlayStart();
        KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListenerIo = io();
        if (rewardAdInteractionListenerIo != null) {
            rewardAdInteractionListenerIo.onVideoPlayStart();
        }
        com.kwad.components.ad.reward.monitor.d.a(true, (com.kwad.components.ad.reward.monitor.a) RewardInteractionCallbackType.VIDEO_PLAY_START, this.mAdTemplate, (com.kwad.sdk.g.a<RewardMonitorInfo>) null);
    }

    @Override // com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
    public final void onVideoSkipToEnd(long j) {
        super.onVideoSkipToEnd(j);
        try {
            KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListenerIo = io();
            if (rewardAdInteractionListenerIo != null) {
                rewardAdInteractionListenerIo.onVideoSkipToEnd(j);
            }
            com.kwad.components.ad.reward.monitor.d.a(true, (com.kwad.components.ad.reward.monitor.a) RewardInteractionCallbackType.VIDEO_SKIP_TO_END, this.mAdTemplate, (com.kwad.sdk.g.a<RewardMonitorInfo>) null);
        } catch (Throwable unused) {
        }
    }

    public final void setAdTemplate(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }

    public final void setCallerContext(com.kwad.components.ad.reward.g gVar) {
        this.uj = gVar;
    }

    public final boolean i(final int i, final int i2) {
        KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListenerIo = io();
        if (rewardAdInteractionListenerIo != null) {
            rewardAdInteractionListenerIo.onRewardStepVerify(i, i2);
        }
        com.kwad.components.ad.reward.monitor.d.a(true, (com.kwad.components.ad.reward.monitor.a) RewardInteractionCallbackType.REWARD_STEP_VERIFY, this.mAdTemplate, new com.kwad.sdk.g.a<RewardMonitorInfo>() { // from class: com.kwad.components.ad.reward.e.i.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void accept(RewardMonitorInfo rewardMonitorInfo) {
                rewardMonitorInfo.setTaskType(i).setTaskStep(i2);
            }
        });
        return rewardAdInteractionListenerIo != null;
    }
}
