package com.kwad.components.ad.splashscreen.presenter;

import android.os.SystemClock;
import android.view.View;
import android.view.ViewTreeObserver;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.cb;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class k extends e implements com.kwad.sdk.core.j.c {
    private View HZ;
    private View Ia;
    private ViewTreeObserver.OnGlobalLayoutListener qE;
    private boolean HY = false;
    private boolean Ib = false;

    private static boolean u(View view) {
        if (view == null) {
            return false;
        }
        com.kwad.sdk.core.c.b.LW();
        if (!com.kwad.sdk.core.c.b.isEnable()) {
            return cb.a(view, 70, true);
        }
        com.kwad.sdk.core.c.b.LW();
        return com.kwad.sdk.core.c.b.isAppOnForeground() && cb.a(view, 70, true);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.HC.mAdTemplate.addStartTime = SystemClock.elapsedRealtime();
        this.HC.GP.a(this);
        com.kwad.components.ad.splashscreen.monitor.b.mv();
        com.kwad.components.ad.splashscreen.monitor.b.f(this.HC.mAdTemplate, SystemClock.elapsedRealtime() - this.HC.mAdTemplate.showStartTime);
        com.kwad.components.ad.splashscreen.monitor.b.mv();
        com.kwad.components.ad.splashscreen.monitor.b.aw(this.HC.mAdTemplate);
        if (com.kwad.sdk.core.response.helper.a.cM(com.kwad.sdk.core.response.helper.e.eO(this.HC.mAdTemplate))) {
            this.HC.U(getContext());
        }
        try {
            this.Ia = getRootView();
            this.qE = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kwad.components.ad.splashscreen.presenter.k.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public final void onGlobalLayout() {
                    try {
                        if (k.this.HZ == null || k.this.Ia == null || k.this.HZ.getVisibility() != 0 || k.this.HY) {
                            return;
                        }
                        k.a(k.this, true);
                        com.kwad.components.ad.splashscreen.monitor.b.mv();
                        com.kwad.components.ad.splashscreen.monitor.b.aq(k.this.HC.mAdTemplate);
                        k.this.Ia.postDelayed(new bi() { // from class: com.kwad.components.ad.splashscreen.presenter.k.1.1
                            @Override // com.kwad.sdk.utils.bi
                            public final void doTask() {
                                if (k.this.Ia.getVisibility() != 0) {
                                    com.kwad.components.ad.splashscreen.monitor.b.mv();
                                    com.kwad.components.ad.splashscreen.monitor.b.at(k.this.HC.mAdTemplate);
                                    return;
                                }
                                if (k.this.HC.mAdTemplate.mPvReported) {
                                    com.kwad.components.ad.splashscreen.monitor.b.mv();
                                    com.kwad.components.ad.splashscreen.monitor.b.ar(k.this.HC.mAdTemplate);
                                    return;
                                }
                                if (k.this.HC.GP.Ae()) {
                                    com.kwad.components.ad.splashscreen.monitor.b.mv();
                                    com.kwad.components.ad.splashscreen.monitor.b.as(k.this.HC.mAdTemplate);
                                    return;
                                }
                                k kVar = k.this;
                                boolean zA = k.a(kVar, kVar.Ia);
                                boolean z = false;
                                if (k.this.HZ != null && k.this.HZ.getVisibility() == 0) {
                                    z = true;
                                }
                                com.kwad.components.ad.splashscreen.monitor.b.mv();
                                k kVar2 = k.this;
                                com.kwad.components.ad.splashscreen.monitor.b.a(kVar2.HC.mAdTemplate, zA, z, kVar2.Ib);
                            }
                        }, 1000L);
                    } catch (Throwable unused) {
                    }
                }
            };
            if (this.Ia != null && getRootView().getParent() != null && (getRootView().getParent() instanceof View)) {
                View view = (View) getRootView().getParent();
                this.HZ = view;
                if (view.getViewTreeObserver() != null) {
                    this.HZ.getViewTreeObserver().addOnGlobalLayoutListener(this.qE);
                    return;
                }
                return;
            }
            if (this.Ia == null) {
                com.kwad.components.ad.splashscreen.monitor.b.mv();
                com.kwad.components.ad.splashscreen.monitor.b.au(this.HC.mAdTemplate);
            } else {
                com.kwad.components.ad.splashscreen.monitor.b.mv();
                com.kwad.components.ad.splashscreen.monitor.b.av(this.HC.mAdTemplate);
            }
        } catch (Exception e) {
            ServiceProvider.reportSdkCaughtException(e);
        }
    }

    @Override // com.kwad.sdk.core.j.c
    public final void bA() {
    }

    @Override // com.kwad.sdk.core.j.c
    public final void bz() {
        this.HC.U(getContext());
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.Ib = true;
        this.HC.GP.b(this);
        View view = this.HZ;
        if (view != null && view.getViewTreeObserver() != null && this.qE != null) {
            this.HZ.getViewTreeObserver().removeOnGlobalLayoutListener(this.qE);
        }
        this.HZ = null;
    }

    public static /* synthetic */ boolean a(k kVar, View view) {
        return u(view);
    }

    public static /* synthetic */ boolean a(k kVar, boolean z) {
        kVar.HY = true;
        return true;
    }
}
