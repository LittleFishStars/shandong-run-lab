package com.kwad.sdk.commercial.g;

import android.content.Context;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.core.c.b;
import com.kwad.sdk.core.c.d;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.i.g;
import com.kwad.sdk.i.h;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.utils.bf;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.i;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class a implements com.kwad.sdk.core.d.a.a {
    private final AtomicBoolean mHasInit;

    /* JADX INFO: renamed from: com.kwad.sdk.commercial.g.a$a, reason: collision with other inner class name */
    public static final class C1270a {
        private static final a aKz = new a(0);
    }

    public /* synthetic */ a(byte b) {
        this();
    }

    public static a Iv() {
        return C1270a.aKz;
    }

    @InvokeBy(invokerClass = c.class, methodId = "registerLogger")
    public static void register() {
        c.a(Iv());
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void d(String str, String str2) {
        h.RQ().g("d", str, str2);
    }

    public final void dC(String str) {
        try {
            if (this.mHasInit.get()) {
                return;
            }
            Context contextUd = ServiceProvider.Ud();
            final f fVar = (f) ServiceProvider.get(f.class);
            h.RQ().a(str, g.RL().gP(ServiceProvider.getSDKConfig().appId).gQ(ServiceProvider.getSdkVersion()).gR(bf.getOaid()).gU(bf.dO(contextUd)).gS(bf.getDeviceId()).gT(bf.dP(contextUd)).n(fVar.FC()).cd(com.kwad.sdk.components.g.encryptDisable()).gV(fVar.FB()).i(fVar.FE()).o(fVar.FD()), new com.kwad.sdk.i.f() { // from class: com.kwad.sdk.commercial.g.a.1
                @Override // com.kwad.sdk.i.f
                public final void a(String str2, Map<String, String> map, String str3) {
                    fVar.a(str2, map, str3);
                }

                @Override // com.kwad.sdk.i.f
                public final String ax(String str2) {
                    return fVar.ax(str2);
                }
            });
            b.LW();
            b.a(new d() { // from class: com.kwad.sdk.commercial.g.a.2
                @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
                public final void onBackToBackground() {
                    super.onBackToBackground();
                }

                @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
                public final void onBackToForeground() {
                    super.onBackToForeground();
                    i.schedule(new bi() { // from class: com.kwad.sdk.commercial.g.a.2.1
                        @Override // com.kwad.sdk.utils.bi
                        public final void doTask() {
                            h.RQ().RR();
                        }
                    }, 3L, TimeUnit.SECONDS);
                }
            });
            this.mHasInit.set(true);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void e(String str, String str2) {
        h.RQ().g("e", str, str2);
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void i(String str, String str2) {
        h.RQ().g("i", str, str2);
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void printStackTraceOnly(Throwable th) {
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void v(String str, String str2) {
        h.RQ().g("v", str, str2);
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void w(String str, String str2) {
        h.RQ().g("w", str, str2);
    }

    private a() {
        this.mHasInit = new AtomicBoolean(false);
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void v(String str, String str2, boolean z) {
        h.RQ().g("v", str, str2);
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void w(String str, String str2, boolean z) {
        h.RQ().g("w", str, str2);
    }
}
