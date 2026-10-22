package com.kwad.sdk.core.b.a;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.crash.message.BackTraceElement;
import com.kwad.sdk.crash.message.Backtrace;
import com.kwad.sdk.crash.message.JavaBackTraceElement;
import com.kwad.sdk.crash.message.NativeBackTraceElement;
import com.kwad.sdk.crash.model.message.AnrReason;
import com.kwad.sdk.crash.online.monitor.block.BlockEvent;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class fh {
    @InvokeBy(invokerClass = hl.class, methodId = "registerHolder")
    public static void LS() {
        hl.LT().put(AnrReason.class, new bj());
        hl.LT().put(com.kwad.sdk.crash.online.monitor.block.d.class, new ch());
        hl.LT().put(com.kwad.sdk.crash.model.b.class, new er());
        hl.LT().put(com.kwad.sdk.crash.online.monitor.a.a.class, new cf());
        hl.LT().put(JavaBackTraceElement.class, new hj());
        hl.LT().put(NativeBackTraceElement.class, new je());
        hl.LT().put(com.kwad.sdk.crash.online.monitor.a.b.class, new ew());
        hl.LT().put(BackTraceElement.class, new bw());
        hl.LT().put(com.kwad.sdk.crash.a.class, new Cdo());
        hl.LT().put(BlockEvent.a.class, new nk());
        hl.LT().put(com.kwad.sdk.crash.online.monitor.a.c.class, new ix());
        hl.LT().put(BlockEvent.class, new cg());
        hl.LT().put(Backtrace.class, new bx());
    }
}
