package com.kwad.components.ad.splashscreen.presenter.playcard;

import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.ad.splashscreen.presenter.e;
import com.kwad.components.ad.splashscreen.presenter.j;
import com.kwad.components.core.webview.tachikoma.f.g;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.by;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a extends e {
    private com.kwad.components.core.offline.a.f.b Kj;
    private long Kk;
    private volatile boolean Kl = false;
    private g mU = new g() { // from class: com.kwad.components.ad.splashscreen.presenter.playcard.a.1
        @Override // com.kwad.components.core.webview.tachikoma.f.g
        public final void a(String str, long j, long j2, long j3) {
            try {
                if (a.this.HC.mStartRenderTime > 0 && !TextUtils.isEmpty(str) && str.equals(com.kwad.sdk.core.response.helper.b.em(a.this.HC.mAdTemplate))) {
                    com.kwad.sdk.commercial.convert.d.b(com.kwad.sdk.core.response.helper.e.eI(a.this.HC.mAdTemplate), 2, SystemClock.elapsedRealtime() - a.this.HC.mStartRenderTime);
                }
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
            if (TextUtils.isEmpty(str) || !str.equals(com.kwad.sdk.core.response.helper.b.em(a.this.HC.mAdTemplate))) {
                return;
            }
            com.kwad.components.ad.splashscreen.monitor.b.mv();
            com.kwad.components.ad.splashscreen.monitor.b.a(a.this.HC.mAdTemplate, a.this.HC.GO, a.this.HC.GX, a.this.HC.GZ, a.this.HC.GY, a.this.HC.Ha, j, j2, j3, SystemClock.elapsedRealtime() - a.this.Kk);
            a.this.HC.Hb = j;
            a.this.HC.Hc = j2;
            a.this.HC.Hd = j3;
            by.b(a.this.Km);
        }

        @Override // com.kwad.components.core.webview.tachikoma.f.b
        public final void x(String str) {
            a.this.HC.bY = true;
            if ("tk_splash".equals(str)) {
                a.this.bb();
            }
        }
    };
    private final Runnable Km = new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.playcard.a.2
        @Override // java.lang.Runnable
        public final void run() {
            if (!a.this.Kl) {
                a.this.nF();
                return;
            }
            a.this.HC.bY = true;
            a.this.bb();
            com.kwad.components.ad.splashscreen.monitor.b.mv();
            com.kwad.components.ad.splashscreen.monitor.b.c(a.this.HC.mAdTemplate, a.this.HC.GO);
        }
    };
    private com.kwad.components.core.offline.a.f.a Kn = new com.kwad.components.core.offline.a.f.a() { // from class: com.kwad.components.ad.splashscreen.presenter.playcard.a.3
        @Override // com.kwad.components.core.offline.a.f.a
        public final void a(int i, int i2, long j, long j2) {
            a.this.HC.GX = i;
            a.this.HC.GY = i2;
            a.this.HC.GZ = j;
            a.this.HC.Ha = j2;
            com.kwad.components.ad.splashscreen.monitor.b.mv();
            com.kwad.components.ad.splashscreen.monitor.b.g(a.this.HC.mAdTemplate, SystemClock.elapsedRealtime() - a.this.Kk);
            a.this.nF();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void bb() {
        h hVar = this.HC;
        if (hVar.GV) {
            return;
        }
        hVar.GV = true;
        hVar.GU = true;
        by.postOnUiThread(new bi() { // from class: com.kwad.components.ad.splashscreen.presenter.playcard.a.5
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                a.this.a(new j(), true);
            }
        });
    }

    private void nE() {
        com.kwad.components.core.offline.a.f.b bVar = (com.kwad.components.core.offline.a.f.b) com.kwad.sdk.components.d.f(com.kwad.components.core.offline.a.f.b.class);
        this.Kj = bVar;
        if (bVar != null) {
            bVar.a(this.Kn);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nF() {
        if (this.Kl) {
            return;
        }
        this.Kl = true;
        by.postOnUiThread(new bi() { // from class: com.kwad.components.ad.splashscreen.presenter.playcard.a.4
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                a.this.a(new com.kwad.components.ad.splashscreen.presenter.a.a(), true);
            }
        });
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.Kk = SystemClock.elapsedRealtime();
        com.kwad.components.ad.splashscreen.monitor.b.mv();
        h hVar = this.HC;
        com.kwad.components.ad.splashscreen.monitor.b.a(hVar.mAdTemplate, hVar.GO);
        h hVar2 = this.HC;
        hVar2.GW = this.Kk;
        by.runOnUiThreadDelay(this.Km, com.kwad.sdk.core.response.helper.b.dX(hVar2.mAdTemplate));
        com.kwad.components.core.webview.tachikoma.e.c.zG().a(this.mU);
        nE();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.offline.a.f.b bVar = this.Kj;
        if (bVar != null) {
            bVar.b(this.Kn);
        }
        by.b(this.Km);
        com.kwad.components.core.webview.tachikoma.e.c.zG().b(this.mU);
    }
}
