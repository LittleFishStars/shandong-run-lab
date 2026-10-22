package com.byazt.fcd;

import android.view.View;
import com.byazt.ete.ic;
import com.byazt.ete.kp;
import com.byazt.ete.xd;
import com.byazt.lcf.TTBaseVideoActivity;
import com.byazt.omf.gt;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_INIT_RTT, 46})
public class n extends c {
    public n(TTBaseVideoActivity tTBaseVideoActivity, ic icVar) {
        super(tTBaseVideoActivity, icVar);
    }

    public static int tt(ic icVar) {
        return 3;
    }

    @Override // com.byazt.fcd.tt
    public boolean b() {
        return false;
    }

    @Override // com.byazt.fcd.c
    public com.byazt.dqg.tt c(boolean z) {
        if (this.uj != 100.0f) {
            this.i = new com.byazt.dqg.sp(this.c, this.tt, z);
        } else {
            this.i = new com.byazt.dqg.a(this.c, this.tt, z);
        }
        return this.i;
    }

    @Override // com.byazt.fcd.c
    public int eo() {
        return tt(this.tt);
    }

    @Override // com.byazt.fcd.c
    public View i() {
        if (this.uj != 100.0f) {
            return kp();
        }
        if (this.ve == 2) {
            int iId = this.tt.id();
            if (iId != 3) {
                return iId != 33 ? com.byazt.vfu.a.my(this.c) : com.byazt.vfu.a.rh(this.c);
            }
            return com.byazt.vfu.a.nu(this.c);
        }
        int iId2 = this.tt.id();
        if (iId2 != 3) {
            return iId2 != 33 ? com.byazt.vfu.a.qy(this.c) : com.byazt.vfu.a.rl(this.c);
        }
        return com.byazt.vfu.a.gt(this.c);
    }

    @Override // com.byazt.fcd.c
    public int ic() {
        if (x(false)) {
            return (int) Math.min(kp.c() / 1000, (int) xd.sp(this.tt));
        }
        return kp.nu(this.tt) ? super.ic() : (int) xd.sp(this.tt);
    }

    @Override // com.byazt.fcd.tt
    public boolean kk() {
        if (!gt.tt().ys()) {
            return kp.ve(this.tt, sp()) && xd.t(this.tt);
        }
        if (this.tt.fr() != 100.0f) {
            return ic.ve(this.tt) || com.byazt.bzd.t.c(this.tt);
        }
        if (this.da.a()) {
            return this.da.sl();
        }
        return true;
    }

    @Override // com.byazt.fcd.tt
    public boolean os() {
        return this.yp;
    }

    @Override // com.byazt.fcd.tt
    public boolean oz() {
        if (!kp.ve(this.tt, sp())) {
            return false;
        }
        if (kp.nu(this.tt)) {
            return true;
        }
        return (gt.tt().ys() || kk()) ? false : true;
    }

    @Override // com.byazt.fcd.tt
    public boolean q() {
        return false;
    }

    @Override // com.byazt.fcd.tt
    public void r() {
        super.r();
        if (oz()) {
            int iP = p();
            int iYv = yv();
            if (!gt.tt().ys() && !kk() && kp.ve(this.tt, sp()) && iP > xd.sp(this.tt)) {
                this.c.kk();
            }
            this.c.ve(0);
            if (x(false)) {
                if (this.gt.cu()) {
                    return;
                }
                if (iYv > ic() || this.z) {
                    com.byazt.fh.a.c = 0;
                    this.c.bm();
                    if (this.da == null || gr() != 7) {
                        return;
                    }
                    this.da.c("0", iYv, 0, false);
                    return;
                }
                int iA = a(true);
                int iA2 = a(false);
                com.byazt.fh.a.c = iA;
                this.c.bm();
                tt(iA);
                if (this.da == null || gr() != 7) {
                    return;
                }
                this.da.c(String.valueOf(iA2), iYv, 0, false);
                return;
            }
            if (iYv > ic() || this.z) {
                this.c.l();
                com.byazt.fh.a.c = 0;
                com.byazt.kcl.n nVar = this.rh;
                boolean z = this.yp;
                nVar.c(z, z ? "领取成功" : "", null, true, true);
                if (this.da == null || gr() != 7) {
                    return;
                }
                this.da.c("0", iYv, 0, false);
                return;
            }
            int iA3 = a(true);
            int iA4 = a(false);
            com.byazt.fh.a.c = iA3;
            boolean z2 = iYv > this.h.ve() || this.c.lo();
            com.byazt.kcl.n nVar2 = this.rh;
            boolean z3 = this.yp;
            StringBuilder sb = new StringBuilder();
            sb.append(iA4);
            sb.append("s");
            sb.append(this.yp ? "后可领取奖励" : "");
            nVar2.c(z3, sb.toString(), null, z2, z2);
            tt(iA3);
            if (this.da == null || gr() != 7) {
                return;
            }
            this.da.c(String.valueOf(iA4), iYv, 0, false);
        }
    }

    @Override // com.byazt.fcd.tt
    public void s() {
        this.i.n(8);
        this.i.a(8);
        this.rh.n(kk());
        this.rh.tt(this.tt.fe());
        this.c.bm();
    }

    @Override // com.byazt.fcd.tt
    public boolean v() {
        return true;
    }

    @Override // com.byazt.fcd.tt
    public boolean x(boolean z) {
        if (gt.tt().ys()) {
            return false;
        }
        return (z || !kp.nu(this.tt)) && !kk() && oz();
    }

    public static boolean c(ic icVar) {
        return (icVar == null || ic.ve(icVar)) ? false : true;
    }
}
