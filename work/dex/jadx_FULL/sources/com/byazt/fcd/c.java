package com.byazt.fcd;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.camera.video.AudioStats;
import com.acse.ottn.v;
import com.byazt.aas.md;
import com.byazt.aas.nb;
import com.byazt.aas.pf;
import com.byazt.aas.rl;
import com.byazt.ete.ic;
import com.byazt.ete.kp;
import com.byazt.ete.my;
import com.byazt.ete.pu;
import com.byazt.ete.xd;
import com.byazt.go.AbstractEndCardFrameLayout;
import com.byazt.go.CommonEndCardFrameLayout;
import com.byazt.lcf.TTBaseVideoActivity;
import com.byazt.omf.gt;
import com.byazt.ukr.yp;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_INIT_RTT, 20})
public abstract class c extends tt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f28536a;
    public final TTBaseVideoActivity c;
    public com.byazt.dqg.n da;
    public com.byazt.kcl.c gr;
    public com.byazt.kcl.tt gt;
    public com.byazt.ouz.n gu;
    public com.byazt.biq.ve h;
    public com.byazt.dqg.tt i;
    public boolean m;
    public com.byazt.kcl.a my;
    public int n;
    public boolean nu;
    public com.byazt.ouz.a qy;
    public com.byazt.kcl.n rh;
    public com.byazt.kcl.uj rl;
    public AbstractEndCardFrameLayout sl;
    public String t;
    public ic tt;
    public boolean u;
    public float uj;
    public int ve;
    public com.byazt.hkv.n x;
    public boolean yp;
    public boolean z;
    public int sp = -1;
    public int zm = -5;
    public boolean yv = false;
    public boolean p = false;
    public int md = Integer.MIN_VALUE;
    public final com.byazt.ouz.sl d = new com.byazt.ouz.sl() { // from class: com.byazt.fcd.c.1
        @Override // com.byazt.ouz.sl
        public void a() {
            yp.c().uj(c.this.tt, "stats_reward_full_click_express_close");
            c.this.rh.c();
        }

        @Override // com.byazt.ouz.sl
        public void c(int i, String str) {
        }

        @Override // com.byazt.ouz.sl
        public void c(boolean z) {
            c cVar = c.this;
            if (cVar.u != z) {
                cVar.u = z;
                cVar.rh.tt();
            }
        }

        @Override // com.byazt.ouz.sl
        public void da() {
            c.this.c.x(3);
        }

        @Override // com.byazt.ouz.sl
        public void i() {
            c.this.rh.ve();
        }

        @Override // com.byazt.ouz.sl
        public void n(int i) {
            c.this.c.i(i);
        }

        @Override // com.byazt.ouz.sl
        public void setPauseFromExpressView(boolean z) {
            c.this.c.m(1);
        }

        @Override // com.byazt.ouz.sl
        public void sp() {
            yp.c().uj(c.this.tt, "stats_reward_full_click_express_close");
            c.this.c.finish();
        }

        @Override // com.byazt.ouz.sl
        public int tt() {
            if (c.this.x(true)) {
                int i = c.this.c.kp() ? 3 : 2;
                if (c.this.c.oz()) {
                    return 5;
                }
                return i;
            }
            if (c.this.da.tt()) {
                return 4;
            }
            if (c.this.da.ve()) {
                return 5;
            }
            if (c.this.my.uj()) {
                return 1;
            }
            if (c.this.my.tt()) {
                return 2;
            }
            c.this.my.ve();
            return 3;
        }

        @Override // com.byazt.ouz.sl
        public void uj() {
            c.this.yv = true;
        }

        @Override // com.byazt.ouz.sl
        public int ve() {
            return c.this.yv();
        }

        @Override // com.byazt.ouz.sl
        public void x() {
            c.this.c.q();
        }

        @Override // com.byazt.ouz.sl
        public void n() {
            c.this.yv = false;
        }

        @Override // com.byazt.ouz.sl
        public void uj(int i) {
            c.this.c.ve(i);
        }

        @Override // com.byazt.ouz.sl
        public void ve(int i) {
            c cVar = c.this;
            cVar.p = true;
            cVar.c.rh(i);
        }

        @Override // com.byazt.ouz.sl
        public void c(int i) {
            if (i != 1) {
                if (i == 2) {
                    c.this.my.zm();
                    return;
                }
                if (i == 3) {
                    c.this.my.yv();
                    return;
                } else if (i == 4) {
                    c.this.my.sp();
                    return;
                } else if (i != 5) {
                    return;
                }
            }
            if (c.this.my.tt() || c.this.my.ve() || c.this.my.nb()) {
                return;
            }
            c.this.c.tt(0L, false);
        }

        @Override // com.byazt.ouz.sl
        public long c() {
            if (c.this.x(true)) {
                hashCode();
                return ((long) c.this.yv()) * 1000;
            }
            c cVar = c.this;
            cVar.tt(cVar.a(true));
            return c.this.h.c();
        }

        @Override // com.byazt.ouz.sl
        public void tt(int i) {
            if (kp.n(c.this.tt)) {
                c.this.c.uj(1);
            } else {
                c.this.c.c(i, false);
            }
        }

        @Override // com.byazt.ouz.sl
        public void c(float f, float f2, float f3, float f4, int i) {
            c.this.c.c(f, f2, f3, f4, i);
        }

        @Override // com.byazt.ouz.sl
        public void c(float f) {
            com.byazt.biq.ve veVar = c.this.h;
            if (veVar != null) {
                veVar.ve((int) (1000.0f / f));
            }
            c.this.c.pu().c(f);
        }

        @Override // com.byazt.ouz.sl
        public void c(ic icVar) {
            c cVar = c.this;
            if (cVar.gt == null || cVar.c == null) {
                return;
            }
            c cVar2 = c.this;
            com.byazt.hkv.c cVar3 = new com.byazt.hkv.c(cVar2.c, icVar, cVar2.t, 7);
            c.this.gt.c(icVar, cVar3);
            ((com.byazt.vis.c) cVar3.c(com.byazt.vis.c.class)).c(c.this.c.c(icVar));
        }
    };

    public c(TTBaseVideoActivity tTBaseVideoActivity, ic icVar) {
        this.c = tTBaseVideoActivity;
        this.tt = icVar;
        this.ve = icVar.by();
        this.uj = icVar.fr();
    }

    private int dz() {
        long jMax = Math.max(((long) (this.my.p() * 1000.0d)) - this.my.h(), 0L);
        return Math.max((((int) (jMax / 1000)) + (((int) (jMax % 1000)) > 500 ? 1 : 0)) - l(), 0);
    }

    private void j() {
        this.rh.c(false);
        this.i.a(8);
        this.i.n(8);
        this.i.ve(8);
        s();
    }

    public boolean a() {
        return pu.c(this.tt) == 2;
    }

    public int aw() {
        return (int) (this.my.h() / 1000);
    }

    public boolean bm() {
        return !this.yp && this.ve == 1 && kp.gu(this.tt) && this.tt.fr() != 100.0f;
    }

    public int bx() {
        return da(true);
    }

    public void c(int i) {
    }

    public void c(int i, int i2, Intent intent) {
    }

    public void c(View view) {
    }

    public void c(com.byazt.kcl.n nVar, com.byazt.kcl.a aVar, com.byazt.kcl.tt ttVar, com.byazt.kcl.uj ujVar, com.byazt.kcl.c cVar) {
        this.rh = nVar;
        this.my = aVar;
        this.gt = ttVar;
        this.rl = ujVar;
        this.gr = cVar;
    }

    public void c(Map<String, Object> map) {
    }

    public void c(JSONObject jSONObject) {
    }

    public void cu() {
    }

    public void d() {
        this.z = true;
    }

    public View da() {
        if (this.sl == null) {
            this.sl = new CommonEndCardFrameLayout(this.c, this.tt);
        }
        return this.sl;
    }

    public int eo() {
        return 0;
    }

    public final int gr() {
        return this.sp;
    }

    public float[] gt() {
        TTBaseVideoActivity tTBaseVideoActivity = this.c;
        int iUj = pf.uj(tTBaseVideoActivity, pf.da((Context) tTBaseVideoActivity));
        float f = this.f28536a;
        float f2 = this.n;
        int i = this.ve;
        if ((i == 1) != (f > f2)) {
            float f3 = f + f2;
            f2 = f3 - f2;
            f = f3 - f2;
        }
        if (i == 1) {
            f -= iUj;
        } else {
            f2 -= iUj;
        }
        return new float[]{f2, f};
    }

    public void gu() {
    }

    public void h() {
        if (this.zm < 0) {
            this.zm = this.gt.sv();
        }
        int i = this.zm;
        if (i <= 0) {
            if (i == 0) {
                this.c.uj(0);
                this.rh.c(false, "奖励已领取", null, true, true);
                return;
            }
            return;
        }
        this.zm = i - 1;
        this.rh.c(false, this.zm + "s", null, true, true);
    }

    public void hd() {
        if (this.nu || Build.VERSION.SDK_INT == 26) {
            return;
        }
        Window window = this.c.getWindow();
        if (window != null) {
            this.c.requestWindowFeature(1);
            window.setBackgroundDrawable(new ColorDrawable(v.f));
            window.setStatusBarColor(-16777216);
            window.clearFlags(TTAdConstant.KEY_CLICK_AREA);
        }
        pf.sp((Activity) this.c);
        this.nu = true;
    }

    public View i() {
        if (this.uj != 100.0f) {
            return kp();
        }
        int iCf = this.tt.cf();
        if (iCf != 1) {
            return iCf != 3 ? com.byazt.vfu.a.c(this.c) : com.byazt.vfu.a.uj(this.c);
        }
        return com.byazt.vfu.a.ve(this.c);
    }

    public int ic() {
        return rl.ve(this.tt) ? rl.n(this.tt) : kp.z(this.tt);
    }

    public View kp() {
        int i = (int) (this.uj * 1000.0f);
        if (this.ve == 1) {
            if (i == 666) {
                return com.byazt.vfu.a.gr(this.c);
            }
            if (i == 1000) {
                return com.byazt.vfu.a.yv(this.c);
            }
            if (i != 1500) {
                return i != 1777 ? com.byazt.vfu.a.md(this.c) : com.byazt.vfu.a.p(this.c);
            }
            return com.byazt.vfu.a.zm(this.c);
        }
        if (i == 562) {
            return com.byazt.vfu.a.eo(this.c);
        }
        if (i == 666) {
            return com.byazt.vfu.a.h(this.c);
        }
        if (i != 1000) {
            return i != 1500 ? com.byazt.vfu.a.zb(this.c) : com.byazt.vfu.a.d(this.c);
        }
        return com.byazt.vfu.a.yv(this.c);
    }

    public int l() {
        return this.h.tt();
    }

    public int lo() {
        return this.h.ve();
    }

    public com.byazt.ouz.sl lr() {
        return this.d;
    }

    public void lt() {
    }

    public void m() {
        AbstractEndCardFrameLayout abstractEndCardFrameLayout = this.sl;
        if (abstractEndCardFrameLayout != null) {
            abstractEndCardFrameLayout.tt();
        }
        com.byazt.dqg.n nVar = this.da;
        if (nVar != null) {
            nVar.uj();
        }
        if (q() || this.gt.cu()) {
            return;
        }
        this.gt.gu();
    }

    public int md() {
        return this.h.a();
    }

    public FrameLayout my() {
        com.byazt.dqg.n nVar;
        if (my.uj(this.tt)) {
            return this.sl.getVideoArea();
        }
        return (a() && (nVar = this.da) != null && nVar.a()) ? this.da.c() : this.i.t();
    }

    public void n() {
        this.c.sp(0);
        this.rh.c(tx());
        float f = this.n;
        float f2 = this.f28536a;
        float[] fArrGt = {f, f2};
        if (f < 10.0f || f2 < 10.0f) {
            fArrGt = gt();
        }
        this.da.c(this.tt, md.c(this.c.yv() ? 7 : 8, String.valueOf(nb.t(this.tt)), fArrGt[0], fArrGt[1], this.tt), this.t, this.u, this.c.c());
        this.i.ve(false);
        this.da.ve(true);
        this.da.c(this.d);
        this.da.c(new com.byazt.ouz.c() { // from class: com.byazt.fcd.c.4
            @Override // com.byazt.ouz.c
            public void c(View view, int i) {
            }

            @Override // com.byazt.ouz.c
            public void c(View view, String str, int i) {
                if (c.this.gt.cu()) {
                    return;
                }
                c.this.gt.tt();
                c.this.c.gt();
                c.this.c.sp(8);
                c.this.rh.c(true);
                com.byazt.nr.da.tt().post(new Runnable() { // from class: com.byazt.fcd.c.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.c.rh();
                    }
                });
            }

            @Override // com.byazt.ouz.c
            public void tt(View view, int i) {
            }

            @Override // com.byazt.ouz.c
            public void c(View view, float f3, float f4) {
                if (c.this.gt.cu()) {
                    return;
                }
                c.this.gt.tt();
                c.this.c.gt();
                c.this.c.sp(8);
                c cVar = c.this;
                cVar.sp = cVar.da.i();
                c cVar2 = c.this;
                if (cVar2.sp == 0) {
                    kp.tt(cVar2.tt, true);
                }
                c.this.ve();
            }
        });
        ((com.byazt.vis.c) this.qy.c(com.byazt.vis.c.class)).c(this.c.ic());
        ((com.byazt.vis.c) this.gu.c(com.byazt.vis.c.class)).c(this.c.ic());
        this.c.c((com.byazt.vis.ve) this.qy.c(com.byazt.vis.ve.class));
        this.c.c((com.byazt.vis.ve) this.gu.c(com.byazt.vis.ve.class));
        this.da.c(this.qy, this.gu);
        this.da.x();
    }

    public int nb() {
        return oz() ? yv() : aw() + l();
    }

    public void nu() {
        this.i.m();
        this.rh.tt(this.tt.fe());
        this.rh.n(kk());
        this.i.a(0);
        this.i.n(0);
    }

    public boolean or() {
        return true;
    }

    public int p() {
        return this.h.n();
    }

    public int pf() {
        int i;
        if (v() && this.gt.bx() && (i = this.zm) >= 0) {
            return i;
        }
        if (oz()) {
            return x(false) ? i(true) : (int) Math.max((ic() * (this.tt.cs() / 100.0f)) - yv(), 0.0f);
        }
        return bx();
    }

    public boolean pu() {
        return this.p;
    }

    public com.byazt.zd.tt qp() {
        return null;
    }

    public void qy() {
    }

    public boolean rh() {
        return false;
    }

    public void rl() {
        com.byazt.dqg.n nVar = this.da;
        if (nVar != null) {
            nVar.c(this.h);
        }
        if (this.yp) {
            this.i.tt((int) (this.my.h() / 1000));
        }
    }

    public View sl() {
        return com.byazt.vfu.a.n(this.c);
    }

    public boolean sp() {
        com.byazt.dqg.n nVar;
        return a() && (nVar = this.da) != null && nVar.a();
    }

    public int sv() {
        int i = this.md;
        return i == Integer.MIN_VALUE ? a(true) : i;
    }

    public com.byazt.dqg.n t() {
        com.byazt.dqg.n nVar = new com.byazt.dqg.n(this.c);
        this.da = nVar;
        return nVar;
    }

    public void tk() {
        com.byazt.dqg.n nVar = this.da;
        if (nVar != null) {
            nVar.c(this.h);
        }
        if (v() && this.gt.bx()) {
            h();
        } else {
            r();
        }
    }

    @Override // com.byazt.fcd.tt
    public boolean to() {
        return kp.nu(this.tt) || this.gt.bx();
    }

    public void tt() {
        y();
        if (os()) {
            kp.c(this.tt, true);
        }
        j();
        if (b()) {
            this.gt.tt();
        }
        if (a()) {
            n();
        } else {
            this.c.gt();
            ve();
        }
    }

    public void tt(Map<String, Object> map) {
    }

    public AbstractEndCardFrameLayout u() {
        return this.sl;
    }

    public void uj() {
        boolean zA = this.da.a();
        if (!this.gt.cu() && !zA) {
            nu();
        }
        this.gt.c(this.da.t());
        if (zA) {
            this.da.c().setBackgroundColor(-16777216);
        }
        this.i.ve(!zA);
        this.da.ve(zA);
        this.rh.c(tx() || !zA);
        this.c.a();
    }

    @Override // com.byazt.fcd.tt
    public void ve() {
        uj();
    }

    public void x() {
        boolean z;
        if (this.yp) {
            z = false;
        } else {
            boolean z2 = this instanceof da;
            z = true;
            if (kp.gu(this.tt)) {
                z2 = true;
            }
            if (this.uj == 100.0f) {
                z = z2;
            }
        }
        if (z) {
            hd();
        } else {
            this.c.or().setBackgroundColor(-16777216);
        }
        if ((this instanceof da) || this.uj == 100.0f) {
            return;
        }
        try {
            final View decorView = this.c.getWindow().getDecorView();
            decorView.post(new Runnable() { // from class: com.byazt.fcd.c.5
                @Override // java.lang.Runnable
                public void run() {
                    int iDa = (int) (pf.da((Context) c.this.c) / 2.0f);
                    int paddingLeft = decorView.getPaddingLeft();
                    int paddingRight = decorView.getPaddingRight();
                    int paddingTop = decorView.getPaddingTop();
                    int paddingBottom = decorView.getPaddingBottom();
                    if (c.this.ve == 1 && !pf.tt()) {
                        paddingTop += iDa;
                        paddingBottom += iDa;
                    }
                    if (c.this.ve == 2 && !pf.tt()) {
                        paddingLeft += iDa;
                        paddingRight += iDa;
                    }
                    decorView.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
                }
            });
        } catch (Throwable unused) {
        }
    }

    public void yp() {
    }

    public int yv() {
        return this.h.n() + this.h.tt();
    }

    public void z() {
        com.byazt.dqg.n nVar = this.da;
        if (nVar != null) {
            nVar.z();
        }
    }

    public boolean zb() {
        return false;
    }

    public void zm() {
        to();
    }

    public int a(boolean z) {
        if (v() && this.gt.bx()) {
            return this.zm;
        }
        if (oz()) {
            return x(false) ? i(z) : Math.max(ic() - yv(), 0);
        }
        return sp(z);
    }

    public int sp(boolean z) {
        return z ? da(false) : dz();
    }

    public void ve(boolean z) {
        if (this.tt.fr() != 100.0f) {
            if (gt.tt().da(nb.t(this.tt)) || this.yp) {
                if (com.byazt.yzg.a.ve && com.byazt.yzg.a.tt && c(this.tt)) {
                    com.byazt.yzg.a.tt = false;
                    com.byazt.yzg.a.ve = false;
                    this.c.finish();
                } else if (z && !com.byazt.yzg.a.ve) {
                    this.c.finish();
                } else {
                    if (!this.gt.eo() || com.byazt.yzg.a.ve) {
                        return;
                    }
                    this.c.finish();
                }
            }
        }
    }

    private int da(boolean z) {
        long jH = this.my.h();
        if (z) {
            long jMax = Math.max(Math.min(kp.c(), (long) ((this.my.p() * 1000.0d) * ((double) (this.tt.cs() / 100.0f)))) - (jH + (((long) l()) * 1000)), 0L);
            return (int) Math.max(((long) ((int) (jMax / 1000))) + (((int) (jMax % 1000)) > 500 ? 1L : 0L), 0L);
        }
        long jMin = Math.min(kp.c(), (long) (this.my.p() * 1000.0d));
        long jL = ((long) l()) * 1000;
        long jP = (long) ((this.my.p() % 1.0d) * 1000.0d);
        if (jP > 0) {
            jH -= 1000 - jP;
        }
        return Math.round((jMin - (jH + jL)) / 1000.0f);
    }

    public void c(String str, boolean z, boolean z2, com.byazt.biq.ve veVar) {
        this.t = str;
        this.u = z;
        this.yp = z2;
        this.h = veVar;
    }

    private int i(boolean z) {
        double dMax;
        float fCs = this.tt.cs() / 100.0f;
        if (z) {
            dMax = Math.max(Math.min(xd.sp(this.tt) * ((double) fCs), kp.c() / 1000) - ((double) yv()), AudioStats.AUDIO_AMPLITUDE_NONE);
        } else {
            dMax = Math.max(xd.sp(this.tt) - ((double) yv()), AudioStats.AUDIO_AMPLITUDE_NONE);
        }
        return (int) dMax;
    }

    public com.byazt.kcl.n c() {
        return this.rh;
    }

    public void uj(boolean z) {
        float f = this.uj;
        if (f != 100.0f) {
            int i = (int) (f * 1000.0f);
            if (this.ve == 1) {
                if (i != 666 && i != 1000 && i != 1500 && i != 1777) {
                    this.i.uj(z ? 0 : 8);
                    return;
                } else {
                    this.i.uj(8);
                    return;
                }
            }
        } else {
            if (z) {
                if (this.ve == 1) {
                    this.i.uj(0);
                }
                if (com.byazt.ex.c.c(this.tt)) {
                    this.i.a(0);
                    return;
                }
                return;
            }
            if (this.ve != 1) {
                return;
            }
        }
        this.i.uj(8);
    }

    public final void c(com.byazt.hkv.n nVar) {
        this.x = nVar;
        TTBaseVideoActivity tTBaseVideoActivity = this.c;
        ic icVar = this.tt;
        String str = this.t;
        this.qy = new com.byazt.ouz.a(tTBaseVideoActivity, icVar, str, nb.uj(str)) { // from class: com.byazt.fcd.c.2
            @Override // com.byazt.ouz.a, com.byazt.hkv.tt, com.byazt.hkv.uj
            public void c(View view, com.byazt.ete.da daVar) {
                if (ic.a(this.c)) {
                    return;
                }
                super.c(view, daVar);
                c.this.c.c(2);
            }
        };
        TTBaseVideoActivity tTBaseVideoActivity2 = this.c;
        ic icVar2 = this.tt;
        String str2 = this.t;
        this.gu = new com.byazt.ouz.n(tTBaseVideoActivity2, icVar2, str2, nb.uj(str2)) { // from class: com.byazt.fcd.c.3
            @Override // com.byazt.ouz.n, com.byazt.hkv.tt, com.byazt.hkv.uj
            public void c(View view, com.byazt.ete.da daVar) {
                if (ic.a(this.c)) {
                    return;
                }
                super.c(view, daVar);
                com.byazt.zo.tt ttVar = (com.byazt.zo.tt) this.x.c(com.byazt.zo.tt.class);
                if (ttVar == null || !ttVar.tt(view)) {
                    return;
                }
                c.this.c.c(2);
            }
        };
        this.sl.setClickListener(this.x);
    }

    public void tt(boolean z) {
        com.byazt.dqg.n nVar = this.da;
        if (nVar != null) {
            nVar.n();
        }
    }

    public void tt(int i) {
        this.md = i;
    }

    public void ve(int i) {
        this.h.c(i);
    }

    public com.byazt.dqg.tt c(boolean z) {
        if (this.uj != 100.0f) {
            this.i = new com.byazt.dqg.sp(this.c, this.tt, z);
        } else {
            this.i = new com.byazt.dqg.ve(this.c, this.tt, z);
        }
        return this.i;
    }

    public void c(int i, int i2) {
        this.n = i;
        this.f28536a = i2;
    }

    private boolean c(ic icVar) {
        return (icVar.i() == 4) && !TextUtils.isEmpty(icVar.gr());
    }

    public void n(boolean z) {
        this.u = z;
        this.my.ve(z);
    }

    public com.byazt.qq.tt.c c(ic icVar, final com.byazt.qq.da daVar) {
        com.byazt.qq.ve veVar = new com.byazt.qq.ve(this.c, icVar);
        veVar.c(sv());
        veVar.tt(nb());
        veVar.ve(this.c.eo());
        veVar.uj(this.c.zb());
        veVar.ve(this.yv);
        veVar.uj(kp.p(icVar) && !this.c.f28770a.get());
        this.c.sv();
        return veVar.tt(new com.byazt.qq.da() { // from class: com.byazt.fcd.c.6
            @Override // com.byazt.qq.da
            public void c() {
                com.byazt.qq.da daVar2 = daVar;
                if (daVar2 != null) {
                    daVar2.c();
                }
                c.this.c.aw();
            }

            @Override // com.byazt.qq.da
            public void tt() {
                com.byazt.qq.da daVar2 = daVar;
                if (daVar2 != null) {
                    daVar2.tt();
                }
            }

            @Override // com.byazt.qq.da
            public void ve() {
                com.byazt.qq.da daVar2 = daVar;
                if (daVar2 != null) {
                    daVar2.ve();
                }
            }

            @Override // com.byazt.qq.da
            public void c(int i) {
                com.byazt.qq.da daVar2 = daVar;
                if (daVar2 != null) {
                    daVar2.c(i);
                }
            }
        });
    }
}
