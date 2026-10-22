package com.kwad.components.ad.splashscreen.presenter;

import android.os.SystemClock;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.by;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class j extends e {
    /* JADX INFO: Access modifiers changed from: private */
    public void di() {
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(this.HC.mAdTemplate);
        a(new b(), true);
        a(new c(), true);
        if (com.kwad.sdk.core.response.helper.a.bi(adInfoEO)) {
            a(new d(), true);
            a(new u(), true);
        } else {
            a(new h(), true);
        }
        if (this.HC.GV) {
            a(new t(), true);
        } else {
            boolean zEd = com.kwad.sdk.core.response.helper.b.ed(adInfoEO);
            boolean zEh = com.kwad.sdk.core.response.helper.b.eh(adInfoEO);
            boolean zEq = com.kwad.sdk.core.response.helper.b.eq(adInfoEO);
            if (com.kwad.sdk.core.response.helper.b.ej(adInfoEO)) {
                a(new r(), true);
            } else if (zEd) {
                a(new o(), true);
            } else if (zEh) {
                a(new m(), true);
            } else if (zEq) {
                a(new t(), true);
            } else {
                a(new t(), true);
            }
        }
        if (com.kwad.sdk.core.response.helper.a.aV(adInfoEO)) {
            a(new f(), true);
        }
        if (!this.HC.bY) {
            a(new com.kwad.components.ad.splashscreen.presenter.playcard.b(), true);
        }
        a(new a(), true);
        a(new g(), true);
        try {
            com.kwad.components.ad.splashscreen.h hVar = this.HC;
            if (hVar.mStartRenderTime > 0) {
                com.kwad.sdk.commercial.convert.d.b(com.kwad.sdk.core.response.helper.e.eI(hVar.mAdTemplate), 1, SystemClock.elapsedRealtime() - this.HC.mStartRenderTime);
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        by.postOnUiThread(new bi() { // from class: com.kwad.components.ad.splashscreen.presenter.j.1
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                j.this.di();
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        findViewById(R.id.splash_play_card_view).setVisibility(0);
    }
}
