package com.kwad.sdk.core.b.a;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.ad.feed.monitor.FeedErrorInfo;
import com.kwad.components.ad.feed.monitor.FeedPageInfo;
import com.kwad.components.ad.feed.monitor.FeedWebViewInfo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class da {
    @InvokeBy(invokerClass = hl.class, methodId = "registerHolder")
    public static void LS() {
        hl.LT().put(FeedWebViewInfo.class, new fd());
        hl.LT().put(FeedPageInfo.a.class, new io());
        hl.LT().put(FeedPageInfo.class, new fb());
        hl.LT().put(FeedErrorInfo.class, new ey());
    }
}
