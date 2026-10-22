package com.byazt.kcl;

import android.graphics.Color;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.byazt.aas.nb;
import com.byazt.aas.pf;
import com.byazt.aas.rl;
import com.byazt.ete.h;
import com.byazt.ete.ic;
import com.byazt.ete.kp;
import com.byazt.ete.my;
import com.byazt.ete.xd;
import com.byazt.fcd.x;
import com.byazt.go.AbstractEndCardFrameLayout;
import com.byazt.lcf.TTBaseVideoActivity;
import com.byazt.omf.d;
import com.byazt.omf.gt;
import com.byazt.ukr.yp;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.huachenjie.shandong_school.splash.SplashActivity;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_PRIMING_WORK_AROUND, 13})
public class tt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f28721a;
    public final TTBaseVideoActivity c;
    public com.byazt.hkv.tt da;
    public com.byazt.kcl.c i;
    public int n;
    public boolean qy;
    public com.byazt.ac.tt sl;
    public AbstractEndCardFrameLayout sp;
    public com.byazt.ac.ve t;
    public ic tt;
    public final com.byazt.rpt.c u;
    public boolean uj;
    public String ve;
    public n x;
    public com.byazt.ac.c yp;
    public boolean z;
    public int m = -1;
    public boolean nu = false;
    public final AtomicBoolean rh = new AtomicBoolean(false);
    public final AtomicBoolean my = new AtomicBoolean(false);
    public int rl = 0;
    public boolean gt = false;

    public interface c {
        void c();
    }

    /* JADX INFO: renamed from: com.byazt.kcl.tt$tt, reason: collision with other inner class name */
    public interface InterfaceC0451tt {
        void c();

        void tt();

        n ve();
    }

    public tt(TTBaseVideoActivity tTBaseVideoActivity) {
        this.c = tTBaseVideoActivity;
        this.u = new com.byazt.rpt.c(tTBaseVideoActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aw() {
        if (this.c.isDestroyed()) {
            return;
        }
        Toast toast = new Toast(this.c);
        toast.setDuration(1);
        toast.setGravity(17, 0, 0);
        LinearLayout linearLayout = new LinearLayout(this.c);
        linearLayout.setBackgroundColor(Color.parseColor("#CC161823"));
        linearLayout.setOrientation(1);
        linearLayout.setPadding(pf.ve(this.c, 20.0f), pf.ve(this.c, 12.0f), pf.ve(this.c, 20.0f), pf.ve(this.c, 12.0f));
        TextView textView = new TextView(this.c);
        textView.setTextColor(-1);
        textView.setText("请求异常无法发放奖励，请关闭重试");
        textView.setTextSize(2, 14.0f);
        linearLayout.addView(textView);
        toast.setView(linearLayout);
        toast.show();
        this.c.nb().postDelayed(new Runnable() { // from class: com.byazt.kcl.tt.5
            @Override // java.lang.Runnable
            public void run() {
                tt.this.aw();
            }
        }, SplashActivity.f36053a);
    }

    private void ic() {
        try {
            if (!h.c(this.tt) || this.qy) {
                return;
            }
            float[] fArrC = com.byazt.biq.tt.c(this.c.getApplicationContext(), this.tt.fr(), this.tt.by());
            float f = fArrC[0];
            float f2 = fArrC[1];
            if (this.tt.fr() == 100.0f) {
                this.n = (int) f;
                this.f28721a = (int) f2;
                return;
            }
            int[] iArrC = com.byazt.biq.tt.c(this.c.getApplicationContext(), this.tt.fr(), this.tt.qe(), this.tt.by());
            int i = iArrC[0];
            int i2 = iArrC[1];
            int i3 = iArrC[2];
            int i4 = iArrC[3];
            float f3 = i;
            float f4 = i3;
            this.n = (int) ((f - f3) - f4);
            float f5 = i2;
            float f6 = i4;
            this.f28721a = (int) ((f2 - f5) - f6);
            this.c.getWindow().getDecorView().setPadding(pf.ve(this.c, f3), pf.ve(this.c, f5), pf.ve(this.c, f4), pf.ve(this.c, f6));
        } catch (Throwable unused) {
        }
    }

    public boolean bx() {
        return cu() && this.my.get();
    }

    public boolean cu() {
        return this.rh.get();
    }

    public boolean d() {
        return this.z;
    }

    public int da() {
        com.byazt.ac.c cVar = this.yp;
        if (cVar != null) {
            return cVar.da();
        }
        return 0;
    }

    public boolean eo() {
        com.byazt.ac.tt ttVar = this.sl;
        if (ttVar == null) {
            return false;
        }
        return ttVar.rl();
    }

    public void gr() {
        if (rl.ve(this.tt) || bx()) {
            return;
        }
        this.m = Math.max(c(this.tt), 0);
        c(0L);
    }

    public boolean gt() {
        com.byazt.ac.c cVar = this.yp;
        if (cVar != null) {
            return cVar.uj();
        }
        return false;
    }

    public void gu() {
        com.byazt.ac.tt ttVar = this.sl;
        if (ttVar != null) {
            ttVar.i();
        }
        com.byazt.ac.ve veVar = this.t;
        if (veVar != null) {
            veVar.i();
        }
    }

    public boolean h() {
        return this.yp instanceof com.byazt.ac.ve;
    }

    public void i() {
        com.byazt.ac.c cVar = this.yp;
        if (cVar != null) {
            cVar.yv();
        }
    }

    public void m() {
        com.byazt.ac.c cVar = this.yp;
        if (cVar != null) {
            cVar.x();
        }
    }

    public void md() {
        ve(false);
        com.byazt.ac.ve veVar = this.t;
        if (veVar != null) {
            veVar.a();
        }
        if (this.nu) {
            qp();
        }
        com.byazt.ac.tt ttVar = this.sl;
        if (ttVar != null) {
            this.yp = ttVar;
        }
    }

    public boolean my() {
        com.byazt.ac.c cVar = this.yp;
        if (cVar != null) {
            return cVar.ve();
        }
        return false;
    }

    public String nb() {
        com.byazt.ac.c cVar = this.yp;
        return cVar != null ? cVar.gr() : "endcard";
    }

    public boolean nu() {
        boolean zRh = xd.sl(this.tt) ? rh() : my();
        if (this.yp == null && !TextUtils.isEmpty(xd.i(this.tt)) && gt.tt().qi()) {
            return true;
        }
        if (gt()) {
            return zRh || rl.tt(this.tt);
        }
        return false;
    }

    public boolean or() {
        com.byazt.ac.ve veVar = this.t;
        if (veVar != null) {
            return veVar.zb();
        }
        return false;
    }

    public d p() {
        com.byazt.ac.ve veVar = this.t;
        if (veVar != null) {
            return veVar.eo();
        }
        return null;
    }

    public void pf() {
        this.rl = kp.tt(this.tt, this.c.to().pf());
        this.my.set(kp.rl(this.tt));
        com.byazt.fh.a.ve = true;
    }

    public void qp() {
        this.u.ve();
    }

    public void qy() {
        com.byazt.ac.tt ttVar = this.sl;
        if (ttVar != null) {
            this.yp = ttVar;
        }
    }

    public boolean rh() {
        com.byazt.ac.c cVar = this.yp;
        if (cVar != null) {
            return cVar.tt();
        }
        return false;
    }

    public boolean rl() {
        if (this.nu) {
            return true;
        }
        com.byazt.ac.c cVar = this.yp;
        return cVar instanceof com.byazt.ac.ve ? this.t.d() : cVar instanceof com.byazt.ac.tt;
    }

    public String sl() {
        com.byazt.ac.c cVar = this.yp;
        return cVar != null ? cVar.sl() : "";
    }

    public void sp() {
        com.byazt.ac.tt ttVar = this.sl;
        if (ttVar != null) {
            ttVar.z();
        }
        com.byazt.ac.ve veVar = this.t;
        if (veVar != null) {
            veVar.z();
        }
    }

    public int sv() {
        return this.rl;
    }

    public void t() {
        com.byazt.ac.c cVar = this.yp;
        if (cVar != null) {
            cVar.nu();
        }
    }

    public void u() {
        com.byazt.ac.c cVar = this.yp;
        if (cVar != null) {
            cVar.my();
        }
    }

    public void x() {
        com.byazt.ac.c cVar = this.yp;
        if (cVar != null) {
            cVar.m();
        }
    }

    public void yp() {
        if (!this.c.to().to()) {
            gr();
        }
        this.x.ve(false);
        this.x.a(false);
        this.x.tt(this.tt.fe());
        this.x.sp(false);
        ic();
        if (this.yp == null && gt.tt().qi() && !TextUtils.isEmpty(xd.i(this.tt))) {
            com.byazt.ac.tt ttVar = new com.byazt.ac.tt(this.c, this.tt, this.ve, this.n, this.f28721a, this.uj, this.sp);
            this.sl = ttVar;
            ttVar.c(this.uj, this.c.ic(), this.x.uj());
            this.sl.c(this.i.sp(), this.da);
            tt();
            this.yp = this.sl;
        }
        com.byazt.ac.c cVar = this.yp;
        if (cVar == null) {
            this.x.n(false);
            return;
        }
        cVar.n();
        this.yp.c(1);
        this.x.n(true ^ (this.yp instanceof com.byazt.ac.tt));
    }

    public boolean yv() {
        com.byazt.ac.ve veVar = this.t;
        return veVar != null && veVar.ve();
    }

    public boolean z() {
        com.byazt.ac.c cVar = this.yp;
        if (cVar != null) {
            return cVar.sp();
        }
        return false;
    }

    public void zb() {
        c(1000L);
    }

    public void zm() {
        ve(true);
        com.byazt.ac.ve veVar = this.t;
        if (veVar == null || !veVar.ve()) {
            n(false);
        } else {
            this.t.c(this.c.to() instanceof x ? 2 : 0);
        }
        if (this.sl != null) {
            this.yp = this.t;
        }
    }

    public void a() {
        com.byazt.ac.c cVar = this.yp;
        if (cVar != null) {
            cVar.rh();
        }
        com.byazt.ac.c cVar2 = this.yp;
        if (cVar2 != null) {
            cVar2.yp();
        }
    }

    public void c(n nVar, com.byazt.kcl.c cVar, boolean z, String str, int i, int i2) {
        this.uj = z;
        this.x = nVar;
        this.i = cVar;
        this.ve = str;
        this.n = i;
        this.f28721a = i2;
    }

    public void n() {
        com.byazt.ac.c cVar = this.yp;
        if (cVar != null) {
            cVar.u();
        }
    }

    public void tt() {
        com.byazt.ac.ve veVar = this.t;
        if (veVar != null) {
            veVar.p();
        }
        com.byazt.ac.tt ttVar = this.sl;
        if (ttVar != null) {
            ttVar.md();
        }
    }

    public void uj() {
        if (bx()) {
            return;
        }
        int i = this.m;
        if (i >= 0) {
            this.c.tt(i);
            c(0L);
        }
        com.byazt.ac.c cVar = this.yp;
        if (cVar != null) {
            cVar.zm();
        }
    }

    public void ve() {
        com.byazt.ac.c cVar = this.yp;
        if (cVar != null) {
            cVar.t();
        }
    }

    public void n(boolean z) {
        if (cu() || d()) {
            this.nu = true;
            com.byazt.ac.c cVar = this.yp;
            if (cVar != null) {
                cVar.gt();
                this.yp.a();
            }
            com.byazt.ac.ve veVar = this.t;
            if (veVar != null) {
                veVar.gu();
            }
            n nVar = this.x;
            if (nVar != null) {
                nVar.sp();
            }
            if (this.x != null && this.tt.sv()) {
                pf.c(this.x.uj(), 0);
            }
            yp.c().a(new com.byazt.ee.c() { // from class: com.byazt.kcl.tt.3
                @Override // com.byazt.ee.c
                public com.byazt.qal.c c() throws Exception {
                    com.byazt.qal.tt ttVarA = com.byazt.qal.tt.tt().c(tt.this.uj ? 7 : 8).ve(String.valueOf(nb.t(tt.this.tt))).a(nb.m(tt.this.tt));
                    ttVarA.tt(tt.this.da()).sp(tt.this.sl());
                    ttVarA.x(tt.this.tt.w_()).uj(tt.this.tt.uj());
                    return ttVarA;
                }
            });
            this.u.c();
            if (my.c(this.tt)) {
                this.c.u(8);
            }
            this.x.c(true);
            this.x.sp(false);
            this.c.nb().postDelayed(new Runnable() { // from class: com.byazt.kcl.tt.4
                @Override // java.lang.Runnable
                public void run() {
                    tt.this.x.c(true);
                    if (tt.this.x.n()) {
                        return;
                    }
                    tt.this.x.c(false, null, null, true, true);
                    if (tt.this.or() && tt.this.uj) {
                        tt.this.aw();
                    }
                }
            }, 500L);
            if (z) {
                if (!kp.nu(this.tt)) {
                    this.x.c(false, null, null, true, true);
                }
                this.x.n(false);
                this.x.tt(this.tt.fe());
            }
        }
    }

    public void ve(boolean z) {
        this.z = z;
        com.byazt.ac.ve veVar = this.t;
        if (veVar != null) {
            veVar.a(z);
        }
    }

    public void a(boolean z) {
        com.byazt.ac.ve veVar = this.t;
        if (veVar != null) {
            veVar.n(z);
        }
    }

    public void tt(boolean z) {
        if (this.m >= 0) {
            this.c.z();
        }
        com.byazt.ac.c cVar = this.yp;
        if (cVar != null) {
            cVar.uj(z);
        }
    }

    public void c(ic icVar, com.byazt.hkv.tt ttVar, com.byazt.ua.c cVar, AbstractEndCardFrameLayout abstractEndCardFrameLayout) {
        if (this.gt) {
            return;
        }
        this.gt = true;
        this.tt = icVar;
        this.da = ttVar;
        this.u.c(icVar);
        this.sp = abstractEndCardFrameLayout;
        c();
        c(cVar);
        this.qy = com.byazt.dl.uj.c(String.valueOf(nb.t(this.tt)));
    }

    public void uj(boolean z) {
        this.rh.set(z);
    }

    public void tt(int i, int i2) {
        com.byazt.ac.ve veVar = this.t;
        if (veVar != null) {
            veVar.tt(i, i2);
        }
    }

    public void c() {
        if (this.tt.tx() == 1) {
            return;
        }
        if (rl.tt(this.tt)) {
            this.t = new com.byazt.ac.ve(this.c, this.tt, this.ve, this.n, this.f28721a, this.uj, this.sp);
        }
        if (!TextUtils.isEmpty(xd.i(this.tt)) && !gt.tt().qi()) {
            this.sl = new com.byazt.ac.tt(this.c, this.tt, this.ve, this.n, this.f28721a, this.uj, this.sp);
        }
        com.byazt.ac.c cVar = this.t;
        if (cVar == null) {
            cVar = this.sl;
        }
        this.yp = cVar;
    }

    public void c(long j, long j2, int i) {
        com.byazt.ac.c cVar = this.yp;
        if (cVar != null) {
            cVar.c(j, j2, i);
        }
    }

    public void c(int i, int i2) {
        com.byazt.ac.c cVar = this.yp;
        if (cVar != null) {
            cVar.c(i, i2);
        }
    }

    public void c(boolean z) {
        com.byazt.ac.c cVar = this.yp;
        if (cVar != null) {
            cVar.tt(z);
        }
    }

    public void c(com.byazt.ua.c cVar) {
        Map<String, Object> mapIc = this.c.ic();
        this.u.c(this.da);
        com.byazt.ac.ve veVar = this.t;
        if (veVar != null) {
            veVar.c(cVar);
            this.t.c(this.uj, mapIc, this.x.uj());
            this.t.c(this.i.sp(), this.da);
            this.t.c(new c() { // from class: com.byazt.kcl.tt.1
                @Override // com.byazt.kcl.tt.c
                public void c() {
                    tt.this.n(false);
                }
            });
            this.t.c(new InterfaceC0451tt() { // from class: com.byazt.kcl.tt.2
                @Override // com.byazt.kcl.tt.InterfaceC0451tt
                public void c() {
                    tt.this.c.tt(true, true);
                }

                @Override // com.byazt.kcl.tt.InterfaceC0451tt
                public void tt() {
                    tt.this.c.t();
                }

                @Override // com.byazt.kcl.tt.InterfaceC0451tt
                public n ve() {
                    return tt.this.x;
                }
            });
        }
        com.byazt.ac.tt ttVar = this.sl;
        if (ttVar != null) {
            ttVar.c(this.uj, mapIc, this.x.uj());
            this.sl.c(this.i.sp(), this.da);
        }
    }

    public void c(Map<String, Object> map) {
        com.byazt.ac.c cVar = this.yp;
        if (cVar != null) {
            cVar.c(map);
        }
    }

    public void c(boolean z, int i, String str) {
        com.byazt.ac.c cVar = this.yp;
        if (cVar != null) {
            cVar.c(z, i, str);
        }
    }

    private int c(ic icVar) {
        return icVar.hz();
    }

    private void c(long j) {
        int i = this.m / 1000;
        if (!kp.nu(this.tt)) {
            if (i > 0) {
                this.x.c(false, i + "s", null, false, false);
            } else {
                this.x.c(false, null, null, true, true);
            }
        }
        if (i > 0) {
            this.m = (int) (((long) this.m) - j);
            this.c.c(j);
        }
    }

    public void c(ic icVar, com.byazt.hkv.tt ttVar) {
        this.tt = icVar;
        this.da = ttVar;
        this.u.c(icVar);
        this.u.c(this.da);
        if (rl.tt(icVar)) {
            if (this.t == null) {
                this.t = new com.byazt.ac.ve(this.c, icVar, this.ve, this.n, this.f28721a, this.uj, this.sp);
            }
            com.byazt.ac.ve veVar = this.t;
            this.yp = veVar;
            veVar.c(new c() { // from class: com.byazt.kcl.tt.6
                @Override // com.byazt.kcl.tt.c
                public void c() {
                    tt.this.n(false);
                }
            });
            this.t.c(new InterfaceC0451tt() { // from class: com.byazt.kcl.tt.7
                @Override // com.byazt.kcl.tt.InterfaceC0451tt
                public void c() {
                    tt.this.c.tt(true, true);
                }

                @Override // com.byazt.kcl.tt.InterfaceC0451tt
                public void tt() {
                    tt.this.c.t();
                }

                @Override // com.byazt.kcl.tt.InterfaceC0451tt
                public n ve() {
                    return tt.this.x;
                }
            });
        } else {
            this.yp = this.sl;
        }
        try {
            com.byazt.ac.c cVar = this.yp;
            if (cVar != null) {
                cVar.c(this.tt);
                this.yp.c(this.uj, this.c.ic(), this.x.uj());
                this.yp.c(this.i.sp(), this.da);
                tt();
            }
        } catch (Throwable unused) {
        }
    }

    public void c(final String str) {
        this.c.nb().post(new Runnable() { // from class: com.byazt.kcl.tt.8
            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                tt.this.u.c(str);
            }
        });
    }

    public void c(JSONObject jSONObject) {
        com.byazt.ac.c cVar = this.yp;
        if (cVar != null) {
            cVar.c(jSONObject);
        }
    }

    public void c(com.byazt.xl.yp ypVar) {
        com.byazt.ac.tt ttVar = this.sl;
        if (ttVar == null) {
            return;
        }
        ttVar.c(ypVar);
    }
}
