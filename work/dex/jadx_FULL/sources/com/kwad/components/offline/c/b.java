package com.kwad.components.offline.c;

import android.content.Context;
import android.os.Build;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.offline.api.IOfflineCompo;
import com.kwad.components.offline.api.InitCallBack;
import com.kwad.components.offline.api.adWaynePlayer.IAdWaynePlayerOfflineCompo;
import com.kwad.sdk.components.d;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.service.ServiceProvider;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class b extends com.kwad.components.core.offline.b.a<IAdWaynePlayerOfflineCompo> {

    public static final class a {
        private static final b axy = new b(0);
    }

    public /* synthetic */ b(byte b) {
        this();
    }

    private static b Ap() {
        return a.axy;
    }

    @InvokeBy(invokerClass = com.kwad.components.core.offline.b.b.class, methodId = "initOC")
    public static void aV(Context context) {
        Ap().init(context);
    }

    @Override // com.kwad.components.core.offline.b.a
    public final /* bridge */ /* synthetic */ void a(Context context, boolean z, IOfflineCompo iOfflineCompo) {
        a(context, (IAdWaynePlayerOfflineCompo) iOfflineCompo);
    }

    @Override // com.kwad.components.core.offline.b.a
    public final String getTag() {
        return "AdWaynePlayerInitModule";
    }

    @Override // com.kwad.components.core.offline.b.a
    public final boolean isEnabled() {
        return Build.VERSION.SDK_INT >= e.a(com.kwad.sdk.core.config.c.aQt) && ((Boolean) e.b(com.kwad.sdk.core.config.c.aQq)).booleanValue();
    }

    @Override // com.kwad.components.core.offline.b.a
    public final String tA() {
        return "5.4.10.1";
    }

    @Override // com.kwad.components.core.offline.b.a
    public final String tB() {
        return "https://p3-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/offline_components/adWaynePlayer/ks_so-adWaynePlayerNoSoRelease-5.4.10.1-d7b01836ac-303.zip";
    }

    @Override // com.kwad.components.core.offline.b.a
    public final String tC() {
        return "0d54546e8c718b53e84fe64e88f2b7e7";
    }

    @Override // com.kwad.components.core.offline.b.a
    public final String tD() {
        return "ks_wayne_player_54101";
    }

    @Override // com.kwad.components.core.offline.b.a
    public final String tE() {
        return IAdWaynePlayerOfflineCompo.IMPL;
    }

    @Override // com.kwad.components.core.offline.b.a
    public final String ty() {
        return "WAYNEPLAYER";
    }

    @Override // com.kwad.components.core.offline.b.a
    public final String tz() {
        return IAdWaynePlayerOfflineCompo.PACKAGE_NAME;
    }

    private b() {
    }

    private void a(Context context, final IAdWaynePlayerOfflineCompo iAdWaynePlayerOfflineCompo) {
        iAdWaynePlayerOfflineCompo.init(context, new c(), new InitCallBack() { // from class: com.kwad.components.offline.c.b.1
            @Override // com.kwad.components.offline.api.InitCallBack
            public final void onError(int i) {
                b.this.bq(i);
            }

            @Override // com.kwad.components.offline.api.InitCallBack
            public final void onSuccess(boolean z) {
                try {
                    d.a(com.kwad.components.core.offline.a.b.a.class, new com.kwad.components.offline.c.a(iAdWaynePlayerOfflineCompo));
                    b.this.tx();
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        });
    }
}
