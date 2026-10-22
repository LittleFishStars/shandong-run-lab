package com.kwad.sdk.commercial.convert;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class e {
    private static void a(final SceneImpl sceneImpl, final com.kwad.sdk.commercial.c.a aVar) {
        GlobalThreadPools.Oi().execute(new Runnable() { // from class: com.kwad.sdk.commercial.convert.e.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    com.kwad.sdk.commercial.c.d(com.kwad.sdk.commercial.d.In().m1062do(ILoggerReporter.Category.APM_LOG).g(0.001d).b(com.kwad.sdk.commercial.e.ds(sceneImpl.getAdStyle())).Q("ad_convert_method_call", "method_name").A(aVar));
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        });
    }

    public static void b(SceneImpl sceneImpl, int i) {
        try {
            a(sceneImpl, b.Iq().dt("dataReady").dA(i));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void c(SceneImpl sceneImpl, String str) {
        try {
            a(sceneImpl, b.Iq().dt("requestStart").dA(sceneImpl.getAdNum()).du(str).setPosId(sceneImpl.getPosId()));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void d(SceneImpl sceneImpl) {
        try {
            a(sceneImpl, b.Iq().dt("loadRequest").dA(sceneImpl.getAdNum()).setPosId(sceneImpl.getPosId()));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(SceneImpl sceneImpl, String str, String str2) {
        try {
            a(sceneImpl, b.Iq().dt("requestFinish").dA(sceneImpl.getAdNum()).du(str).dv(str2).setPosId(sceneImpl.getPosId()));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(int i, int i2, String str, String str2) {
        try {
            com.kwad.sdk.commercial.c.d(com.kwad.sdk.commercial.d.In().m1062do(ILoggerReporter.Category.ERROR_LOG).g(1.0d).b(com.kwad.sdk.commercial.e.ds(i)).Q("ad_convert_method_call", "method_name").A(b.Iq().dt("requestError").du(str2).setErrorCode(com.kwad.sdk.commercial.e.dt(i2)).setErrorMsg(str)));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
