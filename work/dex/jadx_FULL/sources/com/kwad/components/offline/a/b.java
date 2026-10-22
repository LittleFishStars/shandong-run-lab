package com.kwad.components.offline.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.offline.api.IOfflineCompo;
import com.kwad.components.offline.api.InitCallBack;
import com.kwad.components.offline.api.adInnerEc.IAdInnerEcOfflineCompo;
import com.kwad.sdk.components.d;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.utils.bz;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class b extends com.kwad.components.core.offline.b.a<IAdInnerEcOfflineCompo> {
    private static Handler jk;

    public static final class a {
        private static final b awM = new b();
    }

    private static b Aj() {
        return a.awM;
    }

    @InvokeBy(invokerClass = com.kwad.components.core.offline.b.b.class, methodId = "initOC")
    public static void aV(Context context) {
        Aj().init(context);
    }

    @Override // com.kwad.components.core.offline.b.a
    public final String getTag() {
        return "AdInnerEcInitModule";
    }

    @Override // com.kwad.components.core.offline.b.a
    public final boolean isEnabled() {
        return ((Boolean) e.b(com.kwad.sdk.core.config.c.aQv)).booleanValue() && bz.aE(((f) ServiceProvider.get(f.class)).getApiVersion(), (String) e.b(com.kwad.sdk.core.config.c.aQA));
    }

    @Override // com.kwad.components.core.offline.b.a
    public final String tA() {
        return "5.3.11";
    }

    @Override // com.kwad.components.core.offline.b.a
    public final String tB() {
        return "https://p4-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/offline_components/adInnerEc/ks_so-adInnerEcNoSoRelease-5.3.11-49e860ead1-316.zip";
    }

    @Override // com.kwad.components.core.offline.b.a
    public final String tC() {
        return "c83175d4d1c849edf401288424862e74";
    }

    @Override // com.kwad.components.core.offline.b.a
    public final String tD() {
        return "ks_adinnerec_410302";
    }

    @Override // com.kwad.components.core.offline.b.a
    public final String tE() {
        return IAdInnerEcOfflineCompo.IMPL;
    }

    @Override // com.kwad.components.core.offline.b.a
    public final String ty() {
        return "INNEREC";
    }

    @Override // com.kwad.components.core.offline.b.a
    public final String tz() {
        return IAdInnerEcOfflineCompo.PACKAGE_NAME;
    }

    @Override // com.kwad.components.core.offline.b.a
    public final /* bridge */ /* synthetic */ void a(Context context, boolean z, IOfflineCompo iOfflineCompo) {
        a(context, (IAdInnerEcOfflineCompo) iOfflineCompo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(com.kwad.components.core.offline.a.a.a aVar) {
        com.kwad.sdk.core.d.c.d("AdInnerEcInitModule", ": setHostProvider 执行：");
        if (ServiceProvider.Ud() != null) {
            aVar.ts();
        }
    }

    private void a(Context context, final IAdInnerEcOfflineCompo iAdInnerEcOfflineCompo) {
        iAdInnerEcOfflineCompo.init(context, new c(), new InitCallBack() { // from class: com.kwad.components.offline.a.b.1
            @Override // com.kwad.components.offline.api.InitCallBack
            public final void onError(int i) {
                b.this.bq(i);
            }

            @Override // com.kwad.components.offline.api.InitCallBack
            public final void onSuccess(boolean z) {
                try {
                    com.kwad.sdk.core.d.c.d("AdInnerEcInitModule", "onOfflineCompoLoaded: 电商内循环离线组件初始化成功");
                    final com.kwad.components.offline.a.a aVar = new com.kwad.components.offline.a.a(iAdInnerEcOfflineCompo);
                    d.a(com.kwad.components.core.offline.a.a.a.class, aVar);
                    b.this.tx();
                    if (b.jk == null) {
                        Handler unused = b.jk = new Handler(Looper.getMainLooper());
                    }
                    b.jk.postDelayed(new Runnable() { // from class: com.kwad.components.offline.a.b.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            b bVar = b.this;
                            b.a(aVar);
                        }
                    }, 3000L);
                    com.kwad.sdk.core.d.c.d("AdInnerEcInitModule", "onOfflineCompoLoaded: 电商内循环离线组件 注册 完成：");
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.d("AdInnerEcInitModule", "onOfflineCompoLoaded: 电商内循环离线组件 异常：" + th.getMessage());
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        });
    }
}
