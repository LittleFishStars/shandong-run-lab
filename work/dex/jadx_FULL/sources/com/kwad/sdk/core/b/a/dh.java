package com.kwad.sdk.core.b.a;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.core.request.InnerEcLocalLoginInfo;
import com.kwad.components.core.request.model.ImpInfo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class dh {
    @InvokeBy(invokerClass = hl.class, methodId = "registerHolder")
    public static void LS() {
        hl.LT().put(InnerEcLocalLoginInfo.class, new gq());
        hl.LT().put(ImpInfo.class, new gm());
        hl.LT().put(com.kwad.components.core.request.model.b.a.class, new bq());
    }
}
