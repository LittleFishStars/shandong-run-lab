package com.kwad.components.core.e.a;

import android.app.Activity;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.by;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class e {
    private final List<b> Qb;
    private final Stack<AdTemplate> Qc;
    private final AtomicBoolean Qd;
    private final Set<String> Qe;
    private final String TAG;
    private final AtomicBoolean rR;

    public static class a {
        private static final e Qi = new e(0);
    }

    public /* synthetic */ e(byte b) {
        this();
    }

    private void aF(final AdTemplate adTemplate) {
        if (!this.Qd.get() && !this.rR.get()) {
            com.kwad.sdk.core.d.c.d("InstalledActivateManager", "showInstalledActivate");
            this.Qd.set(true);
            by.runOnUiThreadDelay(new bi() { // from class: com.kwad.components.core.e.a.e.1
                /* JADX INFO: Access modifiers changed from: private */
                public void pw() {
                    com.kwad.sdk.core.c.b.LW();
                    if (!com.kwad.sdk.core.c.b.isEnable()) {
                        e.this.Qd.set(false);
                        return;
                    }
                    com.kwad.sdk.core.c.b.LW();
                    if (com.kwad.sdk.core.c.b.getCurrentActivity() != null) {
                        com.kwad.sdk.core.c.b.LW();
                        if (com.kwad.sdk.core.c.b.isAppOnForeground()) {
                            px();
                            return;
                        }
                    }
                    com.kwad.sdk.core.c.b.LW();
                    com.kwad.sdk.core.c.b.a(new com.kwad.sdk.core.c.d() { // from class: com.kwad.components.core.e.a.e.1.2
                        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
                        /* JADX INFO: renamed from: onActivityResumed */
                        public final void d(Activity activity) {
                            super.d(activity);
                            com.kwad.sdk.core.c.b.LW();
                            com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) this);
                            com.kwad.sdk.core.d.c.d("InstalledActivateManager", "startShow onBackToForeground");
                            px();
                        }
                    });
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void px() {
                    com.kwad.sdk.core.d.c.d("InstalledActivateManager", "startShow");
                    e.this.aG(adTemplate);
                    e.this.Qd.set(false);
                    e.this.Qe.remove(com.kwad.sdk.core.response.helper.a.aE(com.kwad.sdk.core.response.helper.e.eO(adTemplate)));
                }

                @Override // com.kwad.sdk.utils.bi
                public final void doTask() {
                    final com.kwad.components.ad.b.a.a aVar = (com.kwad.components.ad.b.a.a) com.kwad.sdk.components.d.f(com.kwad.components.ad.b.a.a.class);
                    if (aVar == null || !aVar.X()) {
                        pw();
                    } else {
                        aVar.a(new com.kwad.components.ad.b.a.c() { // from class: com.kwad.components.core.e.a.e.1.1
                            @Override // com.kwad.components.ad.b.a.c, com.kwad.components.ad.b.a.b
                            public final void Z() {
                                aVar.b(this);
                                pw();
                                com.kwad.sdk.core.d.c.d("InstalledActivateManager", "startShow onPushAdClose");
                            }
                        });
                    }
                }
            }, com.kwad.sdk.core.response.helper.b.ee(adTemplate));
        } else {
            com.kwad.sdk.core.d.c.d("InstalledActivateManager", "mLoadDisable: " + this.rR.get() + ", mLoadDisable: " + this.Qd.get());
            this.Qc.add(adTemplate);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aG(AdTemplate adTemplate) {
        if (a(adTemplate, new b() { // from class: com.kwad.components.core.e.a.e.2
            @Override // com.kwad.components.core.e.a.b
            public final void gk() {
                com.kwad.sdk.core.d.c.d("InstalledActivateManager", "onViewClose");
                e.this.eS();
                e.this.pv();
            }

            @Override // com.kwad.components.core.e.a.b
            public final void ps() {
                com.kwad.sdk.core.d.c.d("InstalledActivateManager", "onViewShow");
                e.this.fh();
            }
        })) {
            return;
        }
        pv();
    }

    public static e pu() {
        return a.Qi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void pv() {
        if (this.Qc.isEmpty()) {
            return;
        }
        aF(this.Qc.pop());
    }

    public final synchronized void aE(AdTemplate adTemplate) {
        String strAE = com.kwad.sdk.core.response.helper.a.aE(com.kwad.sdk.core.response.helper.e.eO(adTemplate));
        if (com.kwad.sdk.core.response.helper.b.ed(adTemplate) && !this.Qe.contains(strAE)) {
            this.Qe.add(strAE);
            aF(adTemplate);
        }
    }

    public final void eS() {
        this.rR.set(false);
        Iterator<b> it = this.Qb.iterator();
        while (it.hasNext()) {
            it.next().gk();
        }
    }

    public final void fh() {
        this.rR.set(true);
        Iterator<b> it = this.Qb.iterator();
        while (it.hasNext()) {
            it.next().ps();
        }
    }

    public final boolean isShowing() {
        return this.rR.get();
    }

    private e() {
        this.TAG = "InstalledActivateManager";
        this.Qb = new CopyOnWriteArrayList();
        this.Qc = new Stack<>();
        this.rR = new AtomicBoolean();
        this.Qd = new AtomicBoolean();
        this.Qe = new HashSet();
    }

    public final void b(b bVar) {
        this.Qb.remove(bVar);
    }

    public final void a(b bVar) {
        this.Qb.add(bVar);
    }

    private static boolean a(AdTemplate adTemplate, b bVar) {
        com.kwad.sdk.core.d.c.d("InstalledActivateManager", "showToActivityWindow");
        return new h().b(adTemplate, bVar);
    }
}
