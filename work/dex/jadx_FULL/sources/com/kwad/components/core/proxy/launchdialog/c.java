package com.kwad.components.core.proxy.launchdialog;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.proxy.n;
import com.kwad.sdk.utils.by;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class c implements n {
    private static long aiY = 7000;
    private DetectEventType aiZ;

    @Nullable
    private WeakReference<com.kwad.components.core.proxy.a> aja;

    @NonNull
    private List<g> ajb = new ArrayList();
    private a ajc = new a(this, 0);
    private boolean started = false;

    public class a implements f {
        private f aje;
        private boolean ajf;

        private a() {
            this.ajf = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void stop() {
            vG();
            this.aje = null;
        }

        private void vG() {
            this.ajf = true;
        }

        @Override // com.kwad.components.core.proxy.launchdialog.f
        public final void j(com.kwad.components.core.proxy.a aVar) {
            f fVar = this.aje;
            if (fVar == null) {
                return;
            }
            fVar.j(aVar);
        }

        @Override // com.kwad.components.core.proxy.launchdialog.f
        public final void k(com.kwad.components.core.proxy.a aVar) {
            f fVar;
            if (this.ajf || (fVar = this.aje) == null) {
                return;
            }
            fVar.k(aVar);
            vG();
        }

        @Override // com.kwad.components.core.proxy.launchdialog.f
        public final void l(com.kwad.components.core.proxy.a aVar) {
            f fVar;
            if (this.ajf || (fVar = this.aje) == null) {
                return;
            }
            fVar.l(aVar);
            vG();
        }

        @Override // com.kwad.components.core.proxy.launchdialog.f
        public final void m(com.kwad.components.core.proxy.a aVar) {
            f fVar;
            if (this.ajf || (fVar = this.aje) == null) {
                return;
            }
            fVar.m(aVar);
            vG();
        }

        public /* synthetic */ a(c cVar, byte b) {
            this();
        }
    }

    public c(DetectEventType detectEventType, com.kwad.components.core.proxy.a aVar, g... gVarArr) {
        this.aiZ = detectEventType;
        this.aja = new WeakReference<>(aVar);
        this.ajb.addAll(Arrays.asList(gVarArr));
    }

    private d vB() {
        com.kwad.components.core.proxy.a aVar;
        WeakReference<com.kwad.components.core.proxy.a> weakReference = this.aja;
        if (weakReference == null || weakReference.get() == null || (aVar = this.aja.get()) == null) {
            return null;
        }
        return aVar.vB();
    }

    private boolean vE() {
        if (this.ajb.size() != 0) {
            return false;
        }
        this.ajc.k(vF());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.kwad.components.core.proxy.a vF() {
        WeakReference<com.kwad.components.core.proxy.a> weakReference = this.aja;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    @Override // com.kwad.components.core.proxy.k
    public final void d(com.kwad.components.core.proxy.a aVar) {
        com.kwad.sdk.core.d.c.d("LifecycleSequence", this.started + " LifecycleSequence onPause: " + aVar.getPageName() + " , type:" + this.aiZ);
        if (this.started) {
            a(vB());
        }
    }

    @Override // com.kwad.components.core.proxy.k
    public final void e(com.kwad.components.core.proxy.a aVar) {
        com.kwad.sdk.core.d.c.d("LifecycleSequence", this.started + " LifecycleSequence onStop: " + aVar.getPageName() + " , type:" + this.aiZ);
        if (this.started) {
            a(vB());
        }
    }

    @Override // com.kwad.components.core.proxy.k
    public final void f(com.kwad.components.core.proxy.a aVar) {
        if (this.started) {
            a(vB());
        }
    }

    @Override // com.kwad.components.core.proxy.n
    public final boolean g(com.kwad.components.core.proxy.a aVar) {
        WeakReference<com.kwad.components.core.proxy.a> weakReference;
        if (aVar == null || (weakReference = this.aja) == null || weakReference.get() == null) {
            return false;
        }
        return this.aja.get().equals(aVar);
    }

    public final void start() {
        this.started = true;
        com.kwad.sdk.core.d.c.d("LifecycleSequence", "start call: " + this.aiZ);
        by.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.core.proxy.launchdialog.c.1
            @Override // java.lang.Runnable
            public final void run() {
                c.this.ajc.l(c.this.vF());
                com.kwad.sdk.core.d.c.d("LifecycleSequence", "DETECT_TIMEOUT call: " + c.this.aiZ);
                c.this.stop();
            }
        }, aiY);
        d dVarVB = vB();
        com.kwad.sdk.core.d.c.d("LifecycleSequence", "start call current: " + dVarVB + this.aiZ);
        a(dVarVB);
    }

    public final void stop() {
        com.kwad.sdk.core.d.c.d("LifecycleSequence", "stop call: " + this.aiZ);
        this.ajc.stop();
        this.started = false;
    }

    public final void a(f fVar) {
        this.ajc.aje = fVar;
    }

    public final boolean b(DetectEventType detectEventType) {
        return detectEventType != null && detectEventType.equals(this.aiZ);
    }

    @Override // com.kwad.components.core.proxy.k
    public final void c(com.kwad.components.core.proxy.a aVar) {
        com.kwad.sdk.core.d.c.d("LifecycleSequence", "LifecycleSequence onResume: " + aVar.getPageName() + " , type:" + this.aiZ);
        if (this.started) {
            a(vB());
        }
    }

    private void a(d dVar) {
        com.kwad.sdk.core.d.c.d("LifecycleSequence", "checkMatch event: " + dVar);
        WeakReference<com.kwad.components.core.proxy.a> weakReference = this.aja;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        if (this.ajb.size() == 0) {
            this.ajc.k(vF());
            return;
        }
        g gVar = this.ajb.get(0);
        if (gVar instanceof g.a) {
            if (this.ajb.size() < 2) {
                this.ajc.m(vF());
                return;
            }
            g gVar2 = this.ajb.get(1);
            if (!(gVar2 instanceof g.b)) {
                this.ajc.m(vF());
                return;
            }
            d dVarVA = this.aja.get().vA();
            g.b bVar = (g.b) gVar2;
            long jVI = dVarVA.vI();
            com.kwad.sdk.core.d.c.d("LifecycleSequence", "checkMatch last: " + dVarVA);
            g.a aVar = (g.a) gVar;
            if (aVar.Q(jVI) && bVar.b(dVar.vH())) {
                this.ajb.remove(gVar);
                this.ajb.remove(gVar2);
                com.kwad.sdk.core.d.c.d("LifecycleSequence", "DurationMoreThanItem remove first: " + gVar + this.aiZ);
                com.kwad.sdk.core.d.c.d("LifecycleSequence", "DurationMoreThanItem remove second: " + gVar2 + this.aiZ);
                if (vE()) {
                    return;
                }
                this.ajc.j(vF());
                return;
            }
            com.kwad.sdk.core.d.c.d("LifecycleSequence", "DurationMoreThanItem not match two: " + aVar.Q(jVI) + ", " + bVar.b(dVar.vH()));
            this.ajc.m(vF());
            return;
        }
        if (gVar instanceof g.b) {
            if (((g.b) gVar).b(dVar.vH())) {
                this.ajb.remove(gVar);
                com.kwad.sdk.core.d.c.d("LifecycleSequence", "PageEventItem remove: " + gVar);
                if (vE()) {
                    return;
                }
                this.ajc.j(vF());
                return;
            }
            this.ajc.m(vF());
        }
    }

    @Override // com.kwad.components.core.proxy.k
    public final void b(com.kwad.components.core.proxy.a aVar) {
        if (this.started) {
            a(vB());
        }
    }

    @Override // com.kwad.components.core.proxy.k
    public final void a(com.kwad.components.core.proxy.a aVar) {
        if (this.started) {
            a(vB());
        }
    }
}
