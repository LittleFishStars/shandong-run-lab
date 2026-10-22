package com.byazt.fcd;

import android.view.View;
import com.byazt.aas.rl;
import com.byazt.ete.ic;
import com.byazt.ete.kp;
import com.byazt.ete.lo;
import com.byazt.ete.my;
import com.byazt.go.RewardJointEndCardFrameLayout;
import com.byazt.lcf.TTBaseVideoActivity;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_INIT_RTT, 91})
public class sp extends c {
    public int d;
    public int eo;
    public boolean zb;

    public sp(TTBaseVideoActivity tTBaseVideoActivity, ic icVar) {
        super(tTBaseVideoActivity, icVar);
        this.d = 0;
        this.eo = 0;
        this.zb = false;
    }

    public static boolean c(ic icVar) {
        return rl.ve(icVar);
    }

    @Override // com.byazt.fcd.c
    public boolean a() {
        return false;
    }

    @Override // com.byazt.fcd.tt
    public boolean b() {
        return true;
    }

    @Override // com.byazt.fcd.c
    public int bx() {
        if (my.u(this.tt) || this.d == 0) {
            return 0;
        }
        return Math.max(0, ((int) Math.min((this.d * this.tt.cs()) / 100.0f, 27.0f)) - yv());
    }

    @Override // com.byazt.fcd.c
    public View da() {
        if (my.uj(this.tt)) {
            this.sl = new RewardJointEndCardFrameLayout(this.c, this.tt);
        }
        return super.da();
    }

    @Override // com.byazt.fcd.c
    public int eo() {
        return tt(this.tt);
    }

    @Override // com.byazt.fcd.c
    public View i() {
        return com.byazt.vfu.a.c(this.c);
    }

    public void j() {
        int iKa = this.tt.ka();
        if (iKa == 0) {
            this.i.n(0);
            this.rh.n(true);
            this.rh.tt(this.tt.fe());
        } else {
            if (iKa != 1) {
                if (iKa != 3) {
                    return;
                }
                this.rh.n(false);
                this.rh.tt(false);
                this.rh.c(false, null, null, true, true);
                return;
            }
            this.i.n(0);
            this.rh.tt(this.tt.fe());
            if (my.uj(this.tt)) {
                this.rh.n(ic.ve(this.tt));
            } else {
                this.rh.n(com.byazt.bzd.t.c(this.tt));
            }
        }
    }

    @Override // com.byazt.fcd.tt
    public boolean kk() {
        return my.uj(this.tt) && ic.ve(this.tt);
    }

    @Override // com.byazt.fcd.c
    public void m() {
        super.m();
        com.byazt.ab.tt.c().tt(this.tt);
    }

    @Override // com.byazt.fcd.c
    public boolean or() {
        if (pf() > 0) {
            return false;
        }
        if (!my.uj(this.tt) && lo.c(this.tt) == 0) {
            return this.gt.rl();
        }
        return true;
    }

    @Override // com.byazt.fcd.tt
    public boolean os() {
        return my.uj(this.tt);
    }

    @Override // com.byazt.fcd.tt
    public boolean oz() {
        return kp.nu(this.tt);
    }

    @Override // com.byazt.fcd.tt
    public boolean q() {
        return true;
    }

    @Override // com.byazt.fcd.tt
    public void r() {
        if (my.u(this.tt)) {
            return;
        }
        int iYv = yv();
        int i = this.d;
        int i2 = i - iYv;
        if (iYv >= i) {
            this.rh.c(false, null, null, true, true);
            if (!my.u(this.tt)) {
                this.c.t();
            }
        } else {
            int i3 = this.eo;
            if (i3 >= i) {
                this.rh.c(false, String.valueOf(i2), null, false, false);
            } else if (iYv >= i3) {
                this.rh.c(false, String.valueOf(i2), "跳过", false, true);
            } else {
                this.rh.c(false, String.valueOf(i2), (this.eo - iYv) + "s后可跳过", false, false);
            }
        }
        this.c.ve(0);
    }

    @Override // com.byazt.fcd.tt
    public void s() {
        this.rh.c(true);
        this.i.a(8);
        if (my.c(this.tt)) {
            j();
        } else {
            this.rh.n(true);
            this.rh.tt(this.tt.fe());
        }
    }

    @Override // com.byazt.fcd.c
    public int sp(boolean z) {
        int i;
        if (my.u(this.tt) || (i = this.d) == 0) {
            return 0;
        }
        return Math.max(0, ((int) Math.min(i, 27.0f)) - yv());
    }

    @Override // com.byazt.fcd.c
    public void tt(boolean z) {
        super.tt(z);
    }

    @Override // com.byazt.fcd.c, com.byazt.fcd.tt
    public void ve() {
        this.rh.c(4);
        this.gt.tt();
        this.c.rh();
        if (my.u(this.tt)) {
            this.rh.tt(true);
        }
        this.d = rl.n(this.tt);
        this.eo = rl.a(this.tt);
        if (my.uj(this.tt)) {
            this.c.a();
        }
    }

    @Override // com.byazt.fcd.c
    public void x() {
        super.x();
        com.byazt.ab.tt.c().c(this.tt);
    }

    @Override // com.byazt.fcd.c
    public void yp() {
        super.yp();
        this.c.bx();
    }

    public static int tt(ic icVar) {
        return my.c(icVar) ? 6 : 0;
    }

    @Override // com.byazt.fcd.c
    public com.byazt.qq.tt.c c(ic icVar, final com.byazt.qq.da daVar) {
        if (this.rl.n()) {
            return new com.byazt.qq.tt.c(false, 0, "");
        }
        this.c.sv();
        this.c.bx();
        com.byazt.qq.x xVar = new com.byazt.qq.x(this.c, icVar);
        xVar.c(this.gt.rl());
        xVar.c(sv());
        return xVar.tt(new com.byazt.qq.da() { // from class: com.byazt.fcd.sp.1
            @Override // com.byazt.qq.da
            public void c() {
                com.byazt.qq.da daVar2 = daVar;
                if (daVar2 != null) {
                    daVar2.c();
                }
                sp.this.c.aw();
            }

            @Override // com.byazt.qq.da
            public void tt() {
                com.byazt.qq.da daVar2 = daVar;
                if (daVar2 != null) {
                    daVar2.tt();
                }
            }
        });
    }
}
