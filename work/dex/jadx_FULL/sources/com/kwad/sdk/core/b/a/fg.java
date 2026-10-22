package com.kwad.sdk.core.b.a;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.contentalliance.coupon.model.ActivityInfo;
import com.kwad.sdk.core.config.item.InstallActivateReminderConfigItem;
import com.kwad.sdk.core.response.model.SdkConfigData;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class fg {
    @InvokeBy(invokerClass = hl.class, methodId = "registerHolder")
    public static void LS() {
        hl.LT().put(com.kwad.sdk.core.response.model.a.class, new kj());
        hl.LT().put(SdkConfigData.TemplateConfigMap.class, new nf());
        hl.LT().put(com.kwad.sdk.core.config.item.k.a.class, new gs());
        hl.LT().put(SdkConfigData.CouponActiveConfig.class, new dj());
        hl.LT().put(ActivityInfo.class, new f());
        hl.LT().put(InstallActivateReminderConfigItem.InstallActivateReminderConfig.class, new gt());
        hl.LT().put(com.kwad.sdk.core.config.item.i.a.class, new gk());
    }
}
