package com.beizi.fusion;

import android.content.Context;
import android.text.TextUtils;
import com.beizi.fusion.asnp.adn.ad.model.impl.trace.InitTraceModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class y implements r9 {
    private final Context b;
    private final ia c;
    private final InitTraceModel d;
    private final g e;
    private v f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f28046a = "ASNPInitializeImpl";
    private a g = a.STANDBY;

    public enum a {
        STANDBY,
        INITIALING,
        SUCCESS,
        FAILED
    }

    public y(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.b = applicationContext;
        InitTraceModel initTraceModel = new InitTraceModel();
        this.d = initTraceModel;
        this.c = new x(context);
        g gVar = (g) h.a().b(applicationContext);
        this.e = gVar;
        gVar.a(initTraceModel);
    }

    private void b() {
        Runnable runnable = new Runnable() { // from class: com.zj.adlib.fyb
            @Override // java.lang.Runnable
            public final void run() {
                this.f41780a.h();
            }
        };
        fb fbVar = (fb) cn.a().b(this.b);
        if (fbVar != null) {
            fbVar.a(runnable);
        }
    }

    private void c() {
        ((fb) cn.a().b(this.b)).f(new Runnable() { // from class: com.zj.adlib.byb
            @Override // java.lang.Runnable
            public final void run() {
                this.f40863a.i();
            }
        });
    }

    private void d() {
        ((fb) cn.a().b(this.b)).f(new Runnable() { // from class: com.zj.adlib.eyb
            @Override // java.lang.Runnable
            public final void run() {
                this.f41550a.j();
            }
        });
    }

    private void e() {
        ((fb) cn.a().b(this.b)).f(new Runnable() { // from class: com.zj.adlib.dyb
            @Override // java.lang.Runnable
            public final void run() {
                this.f41308a.k();
            }
        });
    }

    private void f() {
        ((id) dh.a().b(this.b)).a(e.ASNP_AES);
    }

    private void g() {
        v vVar = this.f;
        if (vVar != null) {
            fp.a().a(this.b, vVar.v(), this.f.r(), this.f.o());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h() {
        l0.a(this.b.getApplicationContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i() {
        ((q9) p.a().b(this.b)).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j() {
        ((ko) tp.a().b(this.b)).d();
        ((q0) r0.a().b(this.b)).e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k() {
        ((com.beizi.fusion.a) com.beizi.fusion.b.a().b(this.b)).b();
    }

    private void l() {
        ((nd) e0.a().b(this.b)).a("plugins_all");
    }

    private void m() {
        f.a(this.b).b();
    }

    private void n() {
        k.a(this.b).a();
    }

    @Override // com.beizi.fusion.r9
    public void a(v vVar, qc qcVar) {
        if (a(vVar.e(), qcVar)) {
            return;
        }
        om.a(this.b);
        this.g = a.INITIALING;
        this.f = vVar;
        f();
        g();
        this.d.setInitStartTs(System.currentTimeMillis());
        c(vVar);
        c();
        a(vVar.n());
        a(vVar);
        n();
        m();
        e();
        a(vVar.b());
        b();
        d();
        b(vVar);
        l();
        a(qcVar);
    }

    public class b implements sc {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private qc f28048a;

        private b(qc qcVar) {
            this.f28048a = qcVar;
        }

        private void a(u7 u7Var, InitTraceModel initTraceModel) {
            if (u7Var == null || initTraceModel == null) {
                return;
            }
            om.a("ASNPInitializeImpl", "上报初始化事件.  " + u7Var + " 耗时 " + initTraceModel.getRoundTripTime());
            ((q9) p.a().b(y.this.b)).a(u7Var, initTraceModel);
        }

        @Override // com.beizi.fusion.sc
        public void a() {
            om.a("ASNPInitializeImpl", "初始化成功...");
            y yVar = y.this;
            yVar.g = a.SUCCESS;
            a(u7.EVENT_REPORT_INIT_CODE, yVar.d.m166deepCopy());
            y.this.d.setInitEndTs(System.currentTimeMillis());
            a(u7.EVENT_REPORT_INIT_SUCCESS_CODE, y.this.d.m166deepCopy());
            qc qcVar = this.f28048a;
            if (qcVar != null) {
                qcVar.a();
                this.f28048a = null;
            }
        }

        @Override // com.beizi.fusion.sc
        public void a(w wVar) {
            om.a("ASNPInitializeImpl", "初始化失败..." + wVar.b() + " " + wVar.c());
            y yVar = y.this;
            yVar.g = a.FAILED;
            a(u7.EVENT_REPORT_INIT_CODE, yVar.d.m166deepCopy());
            y.this.d.setInitEndTs(System.currentTimeMillis());
            a(u7.EVENT_REPORT_INIT_FAIL_CODE, y.this.d.m166deepCopy());
            qc qcVar = this.f28048a;
            if (qcVar != null) {
                qcVar.a(wVar.b(), wVar.c());
            }
        }
    }

    private void c(v vVar) {
        g gVar = this.e;
        if (gVar != null) {
            gVar.a(vVar);
        }
    }

    private void b(v vVar) {
        n nVar = (n) o.a().b(this.b);
        if (nVar == null || nVar.b() == null || vVar == null) {
            return;
        }
        nVar.b().a(vVar.m());
        nVar.b().a(s.a(vVar.p(), "isCanUseSimOperator", false), s.a(vVar.p(), "simOperator"));
    }

    private boolean a(String str, qc qcVar) {
        a aVar = this.g;
        if (aVar != a.STANDBY && aVar != a.FAILED) {
            if (aVar == a.SUCCESS) {
                if (qcVar != null) {
                    v vVar = this.f;
                    if (vVar != null && vVar.e().equals(str)) {
                        qcVar.b();
                    } else {
                        w wVar = w.ERROR_INIT_WITH_DIFFERENT_APP_ID;
                        qcVar.a(wVar.b(), wVar.c());
                    }
                }
                return true;
            }
            if (aVar == a.INITIALING && qcVar != null) {
                qcVar.c();
                return true;
            }
        }
        return false;
    }

    private void a(String str) {
        if (TextUtils.isEmpty(str)) {
            qp.a().a(this.b);
        } else {
            qp.a().a(str);
        }
    }

    private void a(v vVar) {
        p6.a().a(vVar != null ? vVar.j() : "", vVar == null || vVar.c());
    }

    private void a(boolean z) {
        kd kdVar = (kd) hh.a().b(this.b);
        if (z) {
            kdVar.b();
        }
        kdVar.a(this.f.l());
        v vVar = this.f;
        kdVar.a(s.a(vVar != null ? vVar.p() : null, "open_location_frequency", false));
        v vVar2 = this.f;
        kdVar.b(s.a(vVar2 != null ? vVar2.p() : null, "limit_location_frequency", false));
    }

    private void a(qc qcVar) {
        this.c.a(new b(qcVar));
        this.c.a(this.f);
    }

    @Override // com.beizi.fusion.r9
    public boolean a() {
        return this.g == a.SUCCESS;
    }
}
