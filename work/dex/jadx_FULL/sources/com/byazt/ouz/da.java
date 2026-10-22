package com.byazt.ouz;

import com.byazt.ete.ic;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 27, 72})
public class da implements com.byazt.sz.qy, com.byazt.xl.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f28918a;
    public com.byazt.rbg.c c;
    public long n;
    public com.byazt.zb.x sp;
    public String tt;
    public String uj;
    public ic ve;

    public da(com.byazt.rbg.c cVar, String str, ic icVar, String str2) {
        this.c = cVar;
        this.tt = str;
        this.uj = str2;
        this.ve = icVar;
    }

    @Override // com.byazt.xl.i
    public void a() {
        this.c.c();
    }

    @Override // com.byazt.sz.qy
    public void c(boolean z) {
    }

    @Override // com.byazt.xl.i
    public void da() {
        this.c.c(true);
        this.c.n();
        com.byazt.bwm.n.ve(new com.byazt.bwm.sp("native_success") { // from class: com.byazt.ouz.da.2
            @Override // java.lang.Runnable
            public void run() {
                i.c(da.this.tt, da.this.uj, da.this.ve);
                com.byazt.ddx.uj.sp(da.this.ve, da.this.tt, "dynamic_backup_render", null);
            }
        });
    }

    @Override // com.byazt.xl.i
    public void i() {
        this.c.ve();
    }

    @Override // com.byazt.sz.qy
    public void n() {
    }

    @Override // com.byazt.xl.i
    public void n(int i) {
        if (i == 3) {
            this.c.tt("dynamic_sub_render2_end");
        } else {
            this.c.tt("dynamic_sub_render_end");
        }
    }

    @Override // com.byazt.xl.i
    public void sl() {
        this.c.c(true);
        this.c.u();
    }

    @Override // com.byazt.xl.i
    public void sp() {
        com.byazt.zb.x xVar = this.sp;
        if (xVar == null) {
            return;
        }
        xVar.a(yv.c(this.ve));
    }

    @Override // com.byazt.xl.i
    public void t() {
        this.c.yp();
    }

    @Override // com.byazt.xl.i
    public void u() {
        this.c.tt();
    }

    @Override // com.byazt.sz.qy
    public void uj() {
    }

    @Override // com.byazt.xl.i
    public void uj(int i) {
        if (i == 3) {
            this.c.tt("dynamic_sub_render2_start");
        } else {
            this.c.tt("dynamic_sub_render_start");
        }
    }

    @Override // com.byazt.xl.i
    public void x() {
        this.c.tt();
        com.byazt.zb.x xVar = this.sp;
        if (xVar == null) {
            return;
        }
        xVar.sp(yv.c(this.ve));
    }

    public void yp() {
        this.c.z();
        this.c.m();
    }

    @Override // com.byazt.xl.i
    public void a(int i) {
        final String str;
        this.f28918a = System.currentTimeMillis();
        if (i == 3) {
            this.c.ve("dynamic_render2_success");
            str = "dynamic2_render";
        } else {
            this.c.ve("dynamic_render_success");
            str = "dynamic_backup_native_render";
        }
        this.c.c(true);
        com.byazt.bwm.n.ve(new com.byazt.bwm.sp("dynamic_success") { // from class: com.byazt.ouz.da.1
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.ddx.uj.sp(da.this.ve, da.this.tt, str, null);
            }
        });
    }

    @Override // com.byazt.xl.i
    public void c(int i, String str) {
        this.c.c(i, str);
        i.c(i, this.tt, this.uj, this.ve);
        com.byazt.zb.x xVar = this.sp;
        if (xVar == null) {
            return;
        }
        xVar.c(true, yv.c(this.ve), 105);
    }

    @Override // com.byazt.xl.i
    public void tt(boolean z) {
        this.c.c(z ? 1 : 0);
    }

    @Override // com.byazt.xl.i
    public void ve(int i) {
        if (i == 3) {
            this.c.tt("dynamic_sub_analysis2_end");
        } else {
            this.c.tt("dynamic_sub_analysis_end");
        }
    }

    @Override // com.byazt.xl.i
    public void tt(int i) {
        if (i == 3) {
            this.c.tt("dynamic_sub_analysis2_start");
        } else {
            this.c.tt("dynamic_sub_analysis_start");
        }
    }

    @Override // com.byazt.sz.qy
    public void ve() {
        this.c.uj("ugen_sub_render_start");
    }

    @Override // com.byazt.sz.qy
    public void tt() {
        this.c.uj("ugen_sub_analysis_end");
    }

    @Override // com.byazt.xl.i
    public void c(int i) {
        this.n = System.currentTimeMillis();
        if (i == 3) {
            this.c.c("dynamic_render2_start");
        } else {
            this.c.c("dynamic_render_start");
        }
    }

    @Override // com.byazt.xl.i
    public void c(int i, int i2, String str, boolean z) {
        this.c.c(true);
        if (i == 3) {
            this.c.tt(i2, "dynamic_render2_error");
        } else {
            this.c.tt(i2, "dynamic_render_error");
        }
        i.c(i2, this.tt, this.uj, this.ve);
    }

    public void c(com.byazt.zb.x xVar) {
        this.sp = xVar;
    }

    @Override // com.byazt.sz.qy
    public void c() {
        this.c.uj("ugen_render_start");
        this.c.uj("ugen_sub_analysis_start");
    }

    @Override // com.byazt.sz.qy
    public void c(com.byazt.sz.rl rlVar) {
        if (rlVar.c() == 0) {
            this.c.uj("ugen_sub_render_end");
            this.c.n("ugen_render_success");
        } else {
            this.c.ve(rlVar.c(), "ugen_render_error");
        }
        this.c.c(true);
    }

    @Override // com.byazt.sz.qy
    public void c(JSONObject jSONObject) {
        this.c.c(jSONObject);
    }
}
