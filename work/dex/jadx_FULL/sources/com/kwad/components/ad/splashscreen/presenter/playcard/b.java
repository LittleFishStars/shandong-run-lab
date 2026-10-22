package com.kwad.components.ad.splashscreen.presenter.playcard;

import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.ad.splashscreen.presenter.e;
import com.kwad.components.ad.splashscreen.presenter.t;
import com.kwad.components.core.webview.tachikoma.f.g;
import com.kwad.sdk.utils.by;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class b extends e {
    private com.kwad.components.core.offline.a.f.b Kj;
    private long Kk;
    private volatile boolean Kl = false;
    private g mU = new g() { // from class: com.kwad.components.ad.splashscreen.presenter.playcard.b.1
        @Override // com.kwad.components.core.webview.tachikoma.f.g
        public final void a(String str, long j, long j2, long j3) {
            if (TextUtils.isEmpty(str) || !str.equals(com.kwad.sdk.core.response.helper.b.em(b.this.HC.mAdTemplate))) {
                return;
            }
            com.kwad.components.ad.splashscreen.monitor.b.mv();
            com.kwad.components.ad.splashscreen.monitor.b.a(b.this.HC.mAdTemplate, b.this.HC.GO, b.this.HC.GX, b.this.HC.GZ, b.this.HC.GY, b.this.HC.Ha, j, j2, j3, SystemClock.elapsedRealtime() - b.this.Kk);
            b.this.HC.Hb = j;
            b.this.HC.Hc = j2;
            b.this.HC.Hd = j3;
            by.b(b.this.Km);
        }

        @Override // com.kwad.components.core.webview.tachikoma.f.b
        public final void x(String str) {
            b.this.HC.bY = true;
            if ("tk_splash".equals(str)) {
                b.this.nG();
            }
        }
    };
    private final Runnable Km = new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.playcard.b.2
        @Override // java.lang.Runnable
        public final void run() {
            if (!b.this.Kl) {
                b.this.nF();
                return;
            }
            b.this.HC.bY = true;
            b.this.nG();
            com.kwad.components.ad.splashscreen.monitor.b.mv();
            com.kwad.components.ad.splashscreen.monitor.b.c(b.this.HC.mAdTemplate, b.this.HC.GO);
        }
    };
    private com.kwad.components.core.offline.a.f.a Kn = new com.kwad.components.core.offline.a.f.a() { // from class: com.kwad.components.ad.splashscreen.presenter.playcard.b.3
        @Override // com.kwad.components.core.offline.a.f.a
        public final void a(int i, int i2, long j, long j2) {
            b.this.HC.GX = i;
            b.this.HC.GY = i2;
            b.this.HC.GZ = j;
            b.this.HC.Ha = j2;
            com.kwad.components.ad.splashscreen.monitor.b.mv();
            com.kwad.components.ad.splashscreen.monitor.b.g(b.this.HC.mAdTemplate, SystemClock.elapsedRealtime() - b.this.Kk);
            b.this.nF();
        }
    };

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
        if (nH()) {
            by.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.playcard.b.4
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.a(new d(), true);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nG() {
        if (com.kwad.sdk.core.response.helper.b.ek(com.kwad.sdk.core.response.helper.e.eO(this.HC.mAdTemplate))) {
            h hVar = this.HC;
            if (hVar.GU) {
                return;
            }
            hVar.GU = true;
            by.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.playcard.b.5
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.a(new t(), true);
                }
            });
        }
    }

    private boolean nH() {
        if (com.kwad.sdk.core.config.e.JM()) {
            return com.kwad.sdk.core.response.helper.b.dO(com.kwad.sdk.core.response.helper.e.eO(this.HC.mAdTemplate));
        }
        return false;
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.Kk = SystemClock.elapsedRealtime();
        if (nH()) {
            com.kwad.components.ad.splashscreen.monitor.b.mv();
            h hVar = this.HC;
            com.kwad.components.ad.splashscreen.monitor.b.a(hVar.mAdTemplate, hVar.GO);
            h hVar2 = this.HC;
            hVar2.GW = this.Kk;
            by.runOnUiThreadDelay(this.Km, com.kwad.sdk.core.response.helper.b.dT(com.kwad.sdk.core.response.helper.e.eO(hVar2.mAdTemplate)));
            com.kwad.components.core.webview.tachikoma.e.c.zG().a(this.mU);
        }
        if (com.kwad.sdk.core.config.e.JM()) {
            nE();
        } else {
            nG();
        }
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
        if (nH()) {
            by.b(this.Km);
            com.kwad.components.core.webview.tachikoma.e.c.zG().b(this.mU);
        }
    }
}
