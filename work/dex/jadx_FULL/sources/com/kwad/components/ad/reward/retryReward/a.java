package com.kwad.components.ad.reward.retryReward;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.api.manager.RewardRetryTaskManager;
import com.kwad.sdk.o;
import com.kwad.sdk.utils.bz;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a {
    @InvokeBy(invokerClass = com.kwad.sdk.service.c.class, methodId = "initModeImplForInvoker")
    public static void register() {
        try {
            if (bz.aE(o.Gs().getApiVersion(), "4.9.20.1")) {
                com.kwad.sdk.service.c.a(RewardRetryTaskManager.class, RewardRetryTaskManagerImpl.class);
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
    }
}
