package com.kwad.components.ad.reward.g;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.ad.b.h;
import com.kwad.components.ad.reward.retryReward.d;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.network.e;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a extends com.kwad.components.ad.c implements h {
    @Override // com.kwad.sdk.components.b
    public final Class getComponentsType() {
        return h.class;
    }

    @Override // com.kwad.sdk.components.b
    public final void init(Context context) {
        d.kF().kG();
    }

    @Override // com.kwad.components.ad.b.h
    public final void loadRewardVideoAd(final KsScene ksScene, @NonNull final KsLoadManager.RewardVideoAdListener rewardVideoAdListener) {
        a(new com.kwad.sdk.g.a<Boolean>() { // from class: com.kwad.components.ad.reward.g.a.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void accept(Boolean bool) {
                if (bool.booleanValue()) {
                    KsScene ksScene2 = ksScene;
                    b.a(ksScene2, new c(ksScene2.getPosId(), rewardVideoAdListener));
                } else {
                    KsLoadManager.RewardVideoAdListener rewardVideoAdListener2 = rewardVideoAdListener;
                    e eVar = e.aTn;
                    rewardVideoAdListener2.onError(eVar.errorCode, eVar.msg);
                }
            }
        });
    }

    @Override // com.kwad.components.ad.b.h
    public final void notifyRewardVerify() {
        com.kwad.components.ad.reward.b.gw().notifyRewardVerify();
    }
}
