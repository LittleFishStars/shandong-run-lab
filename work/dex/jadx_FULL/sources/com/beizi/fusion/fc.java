package com.beizi.fusion;

import android.view.View;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.report.ReportModel3;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class fc implements va {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f27291a;
    private gc b;
    private ReportModel3 c;
    private c d;
    private a e = a.VIEW_PAUSE;

    public enum a {
        VIEW_RESUME,
        VIEW_PAUSE
    }

    public class b implements Runnable {
        private b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (gn.a.a(fc.this.f27291a, 10)) {
                fc fcVar = fc.this;
                if (fcVar.e == a.VIEW_PAUSE) {
                    fcVar.a(gc.a.AD_VIEW_SHOWN, fcVar.f27291a, null);
                }
                fc.this.e = a.VIEW_RESUME;
            } else {
                fc fcVar2 = fc.this;
                if (fcVar2.e == a.VIEW_RESUME) {
                    fcVar2.a(gc.a.AD_VIEW_PAUSE, fcVar2.f27291a, null);
                }
                fc.this.e = a.VIEW_PAUSE;
            }
            ReportModel3 reportModel3 = fc.this.c;
            if (gn.a.a(fc.this.f27291a, (reportModel3 == null || reportModel3.getShow() == null) ? 0 : fc.this.c.getShow().getAv())) {
                fc fcVar3 = fc.this;
                fcVar3.a(gc.a.ADN_RECOGNIZE, fcVar3.f27291a, null);
                fc fcVar4 = fc.this;
                fcVar4.a(gc.a.AD_EXPOSURE, fcVar4.f27291a, null);
            }
        }
    }

    public static final class c extends be {
        private ScheduledExecutorService d;

        public c(Runnable runnable) {
            super(runnable);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d() {
            a(0L, 100L, TimeUnit.MILLISECONDS);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e() {
            c();
        }

        @Override // com.beizi.fusion.be, com.beizi.fusion.cb
        public ScheduledExecutorService b() {
            ScheduledExecutorService scheduledExecutorService;
            synchronized (this) {
                if (this.d == null) {
                    fb fbVar = (fb) cn.a().b(null);
                    if (fbVar instanceof bn) {
                        this.d = ((bn) fbVar).b();
                    }
                }
                scheduledExecutorService = this.d;
            }
            return scheduledExecutorService;
        }
    }

    public fc(View view) {
        this.f27291a = view;
    }

    public void b() {
        c cVar = this.d;
        if (cVar != null) {
            cVar.e();
        }
    }

    public void a(ReportModel3 reportModel3) {
        this.c = reportModel3;
    }

    @Override // com.beizi.fusion.va
    public void a() {
        if (this.d == null) {
            this.d = new c(new b());
        }
        this.d.d();
    }

    public void a(xa xaVar, View view, Object obj) {
        gc gcVar = this.b;
        if (gcVar != null) {
            if (xaVar == gc.a.AD_EXPOSURE) {
                gcVar.b(xaVar, view);
            }
            if (xaVar == gc.a.ADN_RECOGNIZE) {
                this.b.b(view);
            }
            if (xaVar == gc.a.AD_VIEW_SHOWN) {
                this.b.c(xaVar, view);
            }
            if (xaVar == gc.a.AD_VIEW_PAUSE) {
                this.b.a(view);
            }
        }
    }

    @Override // com.beizi.fusion.va
    public void a(gc gcVar) {
        this.b = gcVar;
        gcVar.a(this);
    }
}
