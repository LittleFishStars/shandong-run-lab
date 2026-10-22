package com.kwad.components.offline.d;

import android.content.Context;
import androidx.annotation.NonNull;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.core.request.h;
import com.kwad.components.offline.api.IOfflineCompo;
import com.kwad.components.offline.api.InitCallBack;
import com.kwad.components.offline.api.obiwan.IObiwanOfflineCompo;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.service.ServiceProvider;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class b extends com.kwad.components.core.offline.b.a<IObiwanOfflineCompo> {

    public static final class a {
        private static final b axR = new b(0);
    }

    public /* synthetic */ b(byte b) {
        this();
    }

    private static b Ar() {
        return a.axR;
    }

    @InvokeBy(invokerClass = com.kwad.components.core.offline.b.b.class, methodId = "initOC")
    public static void aV(Context context) {
        Ar().init(context);
    }

    @Override // com.kwad.components.core.offline.b.a
    public final /* bridge */ /* synthetic */ void a(Context context, boolean z, IOfflineCompo iOfflineCompo) {
        a(context, (IObiwanOfflineCompo) iOfflineCompo);
    }

    @Override // com.kwad.components.core.offline.b.a
    public final String getTag() {
        return "ObiwanInitModule";
    }

    @Override // com.kwad.components.core.offline.b.a
    public final boolean isEnabled() {
        return ((Boolean) e.b(com.kwad.sdk.core.config.c.aOT)).booleanValue();
    }

    @Override // com.kwad.components.core.offline.b.a
    public final String tA() {
        return "3.3.56";
    }

    @Override // com.kwad.components.core.offline.b.a
    public final String tB() {
        return "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/offline_components/obiwan/ks_so-obiwanNoSoRelease-3.3.56-445ef4f109-409.zip";
    }

    @Override // com.kwad.components.core.offline.b.a
    public final String tC() {
        return "d4a07cc878d997efd944c0182236fa7c";
    }

    @Override // com.kwad.components.core.offline.b.a
    public final String tD() {
        return "ks_obiwan_3356";
    }

    @Override // com.kwad.components.core.offline.b.a
    public final String tE() {
        return IObiwanOfflineCompo.IMPL;
    }

    @Override // com.kwad.components.core.offline.b.a
    public final String ty() {
        return "OBIWAN";
    }

    @Override // com.kwad.components.core.offline.b.a
    public final String tz() {
        return IObiwanOfflineCompo.PACKAGE_NAME;
    }

    private b() {
    }

    private void a(Context context, final IObiwanOfflineCompo iObiwanOfflineCompo) {
        iObiwanOfflineCompo.init(context, new d(), new InitCallBack() { // from class: com.kwad.components.offline.d.b.1
            @Override // com.kwad.components.offline.api.InitCallBack
            public final void onError(int i) {
                b.this.bq(i);
            }

            @Override // com.kwad.components.offline.api.InitCallBack
            public final void onSuccess(boolean z) {
                try {
                    final com.kwad.components.offline.d.a aVar = new com.kwad.components.offline.d.a(iObiwanOfflineCompo);
                    com.kwad.sdk.components.d.a(com.kwad.components.core.offline.a.e.a.class, aVar);
                    com.kwad.sdk.core.d.c.a(new c(aVar.getLog()));
                    b.this.tx();
                    h.b(new h.a() { // from class: com.kwad.components.offline.d.b.1.1
                        private void updateConfigs() {
                            com.kwad.sdk.core.d.c.a(e.a(com.kwad.sdk.core.config.c.aOT) ? new c(aVar.getLog()) : null);
                            aVar.updateConfigs();
                        }

                        @Override // com.kwad.components.core.request.h.a
                        public final void d(@NonNull SdkConfigData sdkConfigData) {
                            updateConfigs();
                        }

                        @Override // com.kwad.components.core.request.h.a
                        public final void vZ() {
                            updateConfigs();
                        }
                    });
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        });
    }
}
