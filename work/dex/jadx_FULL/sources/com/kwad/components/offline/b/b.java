package com.kwad.components.offline.b;

import android.content.Context;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.offline.api.IOfflineCompo;
import com.kwad.components.offline.api.InitCallBack;
import com.kwad.components.offline.api.adLive.IAdLiveOfflineCompo;
import com.kwad.sdk.components.d;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.service.ServiceProvider;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class b extends com.kwad.components.core.offline.b.a<IAdLiveOfflineCompo> {

    public static final class a {
        private static final b axq = new b(0);
    }

    public /* synthetic */ b(byte b) {
        this();
    }

    private static b An() {
        return a.axq;
    }

    @InvokeBy(invokerClass = com.kwad.components.core.offline.b.b.class, methodId = "initOC")
    public static void aV(Context context) {
        An().init(context);
    }

    @Override // com.kwad.components.core.offline.b.a
    public final /* bridge */ /* synthetic */ void a(Context context, boolean z, IOfflineCompo iOfflineCompo) {
        a(context, (IAdLiveOfflineCompo) iOfflineCompo);
    }

    @Override // com.kwad.components.core.offline.b.a
    public final String getTag() {
        return "AdLiveInitModule";
    }

    @Override // com.kwad.components.core.offline.b.a
    public final boolean isEnabled() {
        return ((Boolean) e.b(com.kwad.sdk.core.config.c.aOq)).booleanValue();
    }

    @Override // com.kwad.components.core.offline.b.a
    public final String tA() {
        return "4.8.13";
    }

    @Override // com.kwad.components.core.offline.b.a
    public final String tB() {
        return "https://p5-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/offline_components/adLive/ks_so-adLiveNoSoRelease-4.8.13-9cf471c757-289.zip";
    }

    @Override // com.kwad.components.core.offline.b.a
    public final String tC() {
        return "0fbf552d09e097f1684d4cea957d070e";
    }

    @Override // com.kwad.components.core.offline.b.a
    public final String tD() {
        return "ks_live_4810";
    }

    @Override // com.kwad.components.core.offline.b.a
    public final String tE() {
        return IAdLiveOfflineCompo.IMPL;
    }

    @Override // com.kwad.components.core.offline.b.a
    public final String ty() {
        return "LIVE";
    }

    @Override // com.kwad.components.core.offline.b.a
    public final String tz() {
        return IAdLiveOfflineCompo.PACKAGE_NAME;
    }

    private b() {
    }

    private void a(Context context, final IAdLiveOfflineCompo iAdLiveOfflineCompo) {
        iAdLiveOfflineCompo.init(context, new c(), new InitCallBack() { // from class: com.kwad.components.offline.b.b.1
            @Override // com.kwad.components.offline.api.InitCallBack
            public final void onError(int i) {
                b.this.bq(i);
            }

            @Override // com.kwad.components.offline.api.InitCallBack
            public final void onSuccess(boolean z) {
                try {
                    d.a(com.kwad.components.core.offline.a.c.a.class, new com.kwad.components.offline.b.a(iAdLiveOfflineCompo));
                    b.this.tx();
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        });
    }
}
