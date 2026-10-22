package com.kwad.components.offline.e;

import android.content.Context;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.core.request.h;
import com.kwad.components.offline.api.InitCallBack;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.components.offline.api.tk.ITkOfflineCompo;
import com.kwad.components.offline.api.tk.TkLoggerReporter;
import com.kwad.components.offline.api.tk.model.report.TKDownloadMsg;
import com.kwad.library.solder.lib.i;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.o;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bi;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class c extends com.kwad.components.core.offline.b.a<ITkOfflineCompo> {
    private static long axV;
    private final List<com.kwad.components.core.offline.a.f.a> axU;
    private final AtomicBoolean axW;

    /* JADX INFO: renamed from: com.kwad.components.offline.e.c$1, reason: invalid class name */
    public class AnonymousClass1 implements InitCallBack {
        final /* synthetic */ ITkOfflineCompo axX;
        final /* synthetic */ boolean axY;
        final /* synthetic */ long axZ;
        final /* synthetic */ long aya;
        final /* synthetic */ Context dK;

        public AnonymousClass1(ITkOfflineCompo iTkOfflineCompo, boolean z, long j, long j2, Context context) {
            this.axX = iTkOfflineCompo;
            this.axY = z;
            this.axZ = j;
            this.aya = j2;
            this.dK = context;
        }

        @Override // com.kwad.components.offline.api.InitCallBack
        public final void onError(int i) {
            c.this.bq(i);
        }

        @Override // com.kwad.components.offline.api.InitCallBack
        public final void onSuccess(boolean z) {
            try {
                final b bVar = new b(this.axX);
                com.kwad.sdk.components.d.a(com.kwad.components.core.offline.a.f.c.class, bVar);
                c.this.axW.set(true);
                int i = z ? 2 : 1;
                int i2 = this.axY ? 2 : 1;
                c.this.b(i, i2, SystemClock.elapsedRealtime() - this.axZ, this.aya);
                TkLoggerReporter.get().reportTKSOLoad(ILoggerReporter.Category.APM_LOG, new TKDownloadMsg().setDownloadState(3).setOfflineLoadTime(this.aya).setSoLoadTime(SystemClock.elapsedRealtime() - this.axZ).setInitSdkTimeConsuming(SystemClock.elapsedRealtime() - o.Gs().GW()).setThreadPoolCoreSize(i.DQ().DK().El()).setOfflineSource(i2).setSoSource(i).toJson());
                c.this.tx();
                h.b(new com.kwad.components.core.request.i() { // from class: com.kwad.components.offline.e.c.1.1
                    @Override // com.kwad.components.core.request.i, com.kwad.components.core.request.h.a
                    public final void d(@NonNull final SdkConfigData sdkConfigData) {
                        super.d(sdkConfigData);
                        com.kwad.sdk.utils.i.execute(new bi() { // from class: com.kwad.components.offline.e.c.1.1.1
                            @Override // com.kwad.sdk.utils.bi
                            public final void doTask() {
                                C12501 c12501 = C12501.this;
                                bVar.onConfigRefresh(AnonymousClass1.this.dK, sdkConfigData.toJson());
                            }
                        });
                    }
                });
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
    }

    public static final class a {
        private static final c ayg = new c(0);
    }

    public /* synthetic */ c(byte b) {
        this();
    }

    public static c At() {
        return a.ayg;
    }

    @InvokeBy(invokerClass = com.kwad.components.core.offline.b.b.class, methodId = "initOC")
    public static void aV(Context context) {
        axV = SystemClock.elapsedRealtime();
        At().init(context);
    }

    @Override // com.kwad.components.core.offline.b.a
    public final String getTag() {
        return "TkInitModule";
    }

    @Override // com.kwad.components.core.offline.b.a
    public final boolean isEnabled() {
        return com.kwad.sdk.core.h.a.Oy();
    }

    @Override // com.kwad.components.core.offline.b.a
    public final String tA() {
        return "5.4.10.1";
    }

    @Override // com.kwad.components.core.offline.b.a
    public final String tB() {
        return "https://p2-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/offline_components/tk/ks_so-tachikomaNoSoRelease-5.4.10.1-d7b01836ac-302.zip";
    }

    @Override // com.kwad.components.core.offline.b.a
    public final String tC() {
        return "3417a286b580c59aea51c52aac97f996";
    }

    @Override // com.kwad.components.core.offline.b.a
    public final String tD() {
        return "ks_tk_54101";
    }

    @Override // com.kwad.components.core.offline.b.a
    public final String tE() {
        return ITkOfflineCompo.IMPL;
    }

    @Override // com.kwad.components.core.offline.b.a
    public final String ty() {
        return "TK";
    }

    @Override // com.kwad.components.core.offline.b.a
    public final String tz() {
        return ITkOfflineCompo.PACKAGE_NAME;
    }

    private c() {
        this.axU = new CopyOnWriteArrayList();
        this.axW = new AtomicBoolean(false);
    }

    public final void b(com.kwad.components.core.offline.a.f.a aVar) {
        if (aVar == null) {
            return;
        }
        this.axU.remove(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, long j, long j2) {
        Iterator<com.kwad.components.core.offline.a.f.a> it = this.axU.iterator();
        while (it.hasNext()) {
            try {
                it.next().a(i, i2, j, j2);
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.core.offline.b.a
    public void a(Context context, boolean z, ITkOfflineCompo iTkOfflineCompo) {
        iTkOfflineCompo.init(context, new d(), new AnonymousClass1(iTkOfflineCompo, z, SystemClock.elapsedRealtime(), SystemClock.elapsedRealtime() - axV, context));
    }

    public final void a(com.kwad.components.core.offline.a.f.a aVar) {
        if (aVar == null) {
            return;
        }
        try {
            if (this.axW.get()) {
                aVar.a(1, 1, 0L, 0L);
            }
            this.axU.add(aVar);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
