package com.byazt.kcl;

import android.widget.FrameLayout;
import com.byazt.afw.nu;
import com.byazt.bzd.sl;
import com.byazt.bzd.t;
import com.byazt.ete.ic;
import com.byazt.ete.xd;
import com.byazt.fk.sp;
import com.byazt.lcf.TTBaseVideoActivity;
import com.byazt.nr.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_PRIMING_WORK_AROUND, 34})
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f28718a;
    public TTBaseVideoActivity da;
    public com.byazt.jzl.a m;
    public int n;
    public ic sl;
    public com.byazt.dh.ve sp;
    public FrameLayout t;
    public String u;
    public long uj;
    public long x;
    public long yp;
    public com.byazt.hkv.c z;
    public final int i = 210;
    public boolean c = false;
    public boolean tt = false;
    public boolean ve = false;
    public boolean nu = false;

    public a(TTBaseVideoActivity tTBaseVideoActivity) {
        this.da = tTBaseVideoActivity;
    }

    private void sv() {
        com.byazt.dh.ve veVar = this.sp;
        if (veVar == null || veVar.nu() == null) {
            return;
        }
        this.x = this.sp.sl();
        if (this.sp.nu().isStarted() || !this.sp.nu().isCompleted()) {
            this.sp.a();
            this.sp.i();
            this.tt = true;
        }
    }

    public long a() {
        return this.x;
    }

    public void bx() {
        try {
            com.byazt.dh.ve veVar = this.sp;
            if (veVar instanceof com.byazt.zd.c) {
                ((com.byazt.zd.c) veVar).lo();
            }
        } catch (Throwable unused) {
        }
    }

    public void c(ic icVar) {
        this.sl = icVar;
    }

    public com.byazt.dh.ve cu() {
        return this.sp;
    }

    public com.byazt.zd.c d() {
        return (com.byazt.zd.c) cu();
    }

    public void da() {
        com.byazt.dh.ve veVar = this.sp;
        if (veVar != null) {
            veVar.tt();
        }
    }

    public boolean eo() {
        com.byazt.dh.ve veVar = this.sp;
        if (veVar == null) {
            return false;
        }
        return veVar.ve();
    }

    public void gr() {
        sp();
    }

    public long gt() {
        com.byazt.dh.ve veVar = this.sp;
        if (veVar != null) {
            return veVar.yp();
        }
        return 0L;
    }

    public boolean gu() {
        com.byazt.dh.ve veVar = this.sp;
        return veVar != null && veVar.nu() == null;
    }

    public long h() {
        if (sl()) {
            double dA = xd.nu(this.sl).a() * 1000.0d * ((double) d().sv());
            long j = this.uj;
            if (dA - j > 210.0d) {
                long j2 = (long) (j + dA);
                this.yp = j2;
                return j2;
            }
        }
        return Math.max(this.uj, this.yp);
    }

    public void i() {
        com.byazt.dh.ve veVar = this.sp;
        if (veVar != null) {
            veVar.da();
        }
    }

    public long m() {
        com.byazt.dh.ve veVar = this.sp;
        return veVar != null ? veVar.sl() : this.x;
    }

    public int md() {
        return this.n;
    }

    public void my() {
        com.byazt.dh.ve veVar = this.sp;
        if (veVar == null || veVar.nu() == null) {
            return;
        }
        this.sp.nu().stop();
    }

    public boolean n() {
        return this.tt;
    }

    public boolean nb() {
        return this.ve;
    }

    public long nu() {
        com.byazt.dh.ve veVar = this.sp;
        if (veVar != null) {
            return veVar.t();
        }
        return 0L;
    }

    public boolean or() {
        com.byazt.dh.ve veVar = this.sp;
        if (veVar == null || veVar.nu() == null) {
            return false;
        }
        return this.sp.nu().isFirstFrameSuccess();
    }

    public double p() {
        double dSp = xd.sp(this.sl);
        return (xd.z(this.sl) == null || this.sl.pb() <= 0 || dSp <= ((double) this.sl.pb())) ? dSp : this.sl.pb();
    }

    public void pf() {
        this.ve = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void qp() {
        boolean zC;
        nu.c cVar = new nu.c();
        cVar.tt(nu());
        cVar.n(3);
        cVar.a(rh());
        com.byazt.dh.ve veVar = this.sp;
        if (veVar instanceof com.byazt.zd.c) {
            ((com.byazt.zd.c) veVar).rl.ve(32);
            zC = ((com.byazt.zd.c) this.sp).rl.c(2);
        } else {
            zC = 0;
        }
        com.byazt.sw.uj.c(zb(), cVar, this.da.x(), !zC);
    }

    public boolean qy() {
        return this.sp != null;
    }

    public int rh() {
        com.byazt.dh.ve veVar = this.sp;
        if (veVar != null) {
            return veVar.u();
        }
        return 0;
    }

    public boolean rl() {
        com.byazt.dh.ve veVar = this.sp;
        if (veVar != null) {
            if (veVar.nu() != null) {
                sp spVarNu = this.sp.nu();
                if (spVarNu.isPaused() || spVarNu.isReleased()) {
                    ((com.byazt.zd.c) this.sp).ic();
                    return true;
                }
            } else if (n()) {
                c(false);
                ((com.byazt.zd.c) this.sp).ic();
                return true;
            }
        }
        return false;
    }

    public boolean sl() {
        com.byazt.dh.ve veVar = this.sp;
        if (veVar != null) {
            return veVar.uj();
        }
        return false;
    }

    public void sp() {
        com.byazt.dh.ve veVar = this.sp;
        if (veVar == null) {
            return;
        }
        veVar.i();
        this.sp = null;
    }

    public boolean t() {
        com.byazt.dh.ve veVar = this.sp;
        if (veVar != null) {
            return veVar.n();
        }
        return false;
    }

    public boolean tt() {
        com.byazt.dh.ve veVar = this.sp;
        return (veVar == null || veVar.nu() == null || !this.sp.nu().isPlaying()) ? false : true;
    }

    public boolean u() {
        com.byazt.dh.ve veVar = this.sp;
        if (veVar != null) {
            return veVar.my();
        }
        return false;
    }

    public boolean uj() {
        com.byazt.dh.ve veVar = this.sp;
        return veVar != null && veVar.qy();
    }

    public boolean ve() {
        com.byazt.dh.ve veVar = this.sp;
        return (veVar == null || veVar.nu() == null || !this.sp.nu().isPaused()) ? false : true;
    }

    public void x() {
        if (this.sp != null && tt()) {
            this.sp.tt(true);
        }
    }

    public long yp() {
        com.byazt.dh.ve veVar = this.sp;
        if (veVar != null) {
            return veVar.yp();
        }
        return 0L;
    }

    public void yv() {
        try {
            this.da.z(1);
        } catch (Throwable th) {
            m.uj("TTBaseVideoActivity", "onContinue throw Exception :" + th.getMessage());
        }
    }

    public int z() {
        com.byazt.dh.ve veVar = this.sp;
        if (veVar != null) {
            return veVar.z();
        }
        return 0;
    }

    public com.byazt.dh.tt zb() {
        com.byazt.dh.ve veVar = this.sp;
        if (veVar != null) {
            return veVar.rh();
        }
        return null;
    }

    public void zm() {
        try {
            this.da.yp(1);
        } catch (Throwable th) {
            m.uj("TTBaseVideoActivity", "onPause throw Exception :" + th.getMessage());
        }
    }

    public void c(FrameLayout frameLayout, String str, boolean z) {
        if (this.nu) {
            return;
        }
        this.nu = true;
        this.t = frameLayout;
        this.u = str;
        this.f28718a = z;
        if (z) {
            this.sp = new com.byazt.xh.tt(this.da, frameLayout, this.sl, this.z);
        } else {
            this.sp = new com.byazt.xh.c(this.da, frameLayout, this.sl, this.z);
        }
        this.n = (int) p();
    }

    public void tt(boolean z) {
        int i;
        if (this.sp == null) {
            return;
        }
        if (z) {
            i = or() ? 2 : 4;
        } else {
            i = or() ? 0 : 1;
        }
        nu.c cVar = new nu.c();
        cVar.tt(nu());
        cVar.ve(1 ^ (or() ? 1 : 0));
        cVar.uj(i);
        com.byazt.dh.ve veVar = this.sp;
        if (!(veVar instanceof com.byazt.zd.c) || ((com.byazt.zd.c) veVar).rl.c(128)) {
            return;
        }
        ((com.byazt.zd.c) this.sp).rl.ve(128);
        com.byazt.sw.uj.ve(this.sp.rh(), cVar);
    }

    public void ve(boolean z) {
        com.byazt.dh.ve veVar = this.sp;
        if (veVar != null) {
            veVar.tt(z);
        }
    }

    public boolean c() {
        com.byazt.dh.ve veVar = this.sp;
        return (veVar == null || veVar.nu() == null || !this.sp.nu().isCompleted()) ? false : true;
    }

    public void c(boolean z) {
        this.tt = z;
    }

    public void c(long j) {
        this.x = j;
    }

    public void c(long j, boolean z) {
        com.byazt.dh.ve veVar = this.sp;
        if (veVar == null || this.ve) {
            return;
        }
        if (j != 0) {
            veVar.c(j);
            this.sp.tt(z);
        } else {
            veVar.x();
        }
    }

    public void tt(Map<String, Object> map) {
        com.byazt.dh.ve veVar = this.sp;
        if (veVar != null) {
            veVar.tt(map);
        }
    }

    public void tt(long j) {
        this.uj = j;
        if (!t() && sl()) {
            this.n = (int) Math.max(0L, Math.round(p() - ((this.uj + (xd.nu(this.sl).a() * 1000.0d)) / 1000.0d)));
        } else {
            this.n = Math.max(0, (int) (p() - (this.uj / 1000)));
        }
    }

    public void c(Map<String, Object> map) {
        com.byazt.dh.ve veVar = this.sp;
        if (veVar == null || this.ve) {
            return;
        }
        veVar.c(map);
    }

    public void c(com.byazt.zd.c.InterfaceC0595c interfaceC0595c) {
        com.byazt.dh.ve veVar = this.sp;
        if (veVar instanceof com.byazt.zd.c) {
            ((com.byazt.zd.c) veVar).c(interfaceC0595c);
        }
    }

    public boolean c(long j, boolean z, int i) {
        if (this.sp == null || xd.z(this.sl) == null) {
            return false;
        }
        com.byazt.jzl.a aVarC = this.m;
        if (aVarC == null) {
            File file = new File(sl.c(this.sl.xx()).getRewardFullCacheDir(), xd.x(this.sl));
            if (file.exists() && file.length() > 0) {
                this.c = true;
            }
            aVarC = xd.c(1, this.sl);
            aVarC.setCid(this.sl.uj());
            FrameLayout frameLayout = this.t;
            aVarC.setWidth(frameLayout == null ? 100 : frameLayout.getWidth());
            FrameLayout frameLayout2 = this.t;
            aVarC.setHeight(frameLayout2 != null ? frameLayout2.getHeight() : 100);
            aVarC.setLogExtra(this.sl.w_());
            aVarC.setCurrent(j);
            aVarC.setQuiet(z);
            if (t.c(this.sl)) {
                aVarC.setAudio(true);
            }
        }
        return this.sp.c(aVarC);
    }

    public void c(boolean z, TTBaseVideoActivity tTBaseVideoActivity) {
        boolean zUj;
        long jN;
        boolean zA;
        if (z || this.da.kp()) {
            return;
        }
        if (ve()) {
            com.byazt.zd.tt ttVarQp = this.da.to().qp();
            if (ttVarQp != null) {
                zUj = ttVarQp.uj();
                jN = ttVarQp.n();
                zA = ttVarQp.a();
            } else {
                zUj = false;
                jN = 0;
                zA = false;
            }
            if (zUj) {
                sv();
                c(tTBaseVideoActivity);
            } else {
                c(jN, zA);
            }
            m.c("TTBaseVideoActivity", "resumeOrRestartVideo: continue play");
            return;
        }
        sv();
        c(tTBaseVideoActivity);
        m.c("TTBaseVideoActivity", "resumeOrRestartVideo: recreate video player & exec play");
    }

    public void c(TTBaseVideoActivity tTBaseVideoActivity) {
        if (!rl() || tTBaseVideoActivity == null) {
            return;
        }
        tTBaseVideoActivity.tt(a(), true);
    }

    public void c(int i) {
        com.byazt.dh.ve veVar = this.sp;
        if (veVar != null) {
            veVar.c(i);
        }
    }

    public void c(ic icVar, com.byazt.dh.ve veVar, com.byazt.jzl.a aVar) {
        this.sl = icVar;
        this.sp = veVar;
        this.m = aVar;
    }

    public void c(com.byazt.hkv.c cVar) {
        this.z = cVar;
    }

    public void c(float f) {
        if (this.sp.nu() != null) {
            this.sp.nu().setPlaySpeedRatio(f);
        }
    }
}
