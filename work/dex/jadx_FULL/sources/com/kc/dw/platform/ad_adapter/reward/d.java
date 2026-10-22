package com.kc.dw.platform.ad_adapter.reward;

import com.kc.dw.core.ad.reward.RewardVideoAdListener;
import com.kc.dw.core.safe.j;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class d extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c.b f39540a;

    public d(c.b bVar) {
        this.f39540a = bVar;
    }

    @Override // com.kc.dw.core.safe.j
    public void safeRun() {
        c cVar = this.f39540a.d;
        RewardVideoAdListener rewardVideoAdListener = cVar.l;
        if (rewardVideoAdListener != null) {
            rewardVideoAdListener.onAdReady(cVar.h);
        }
    }
}
