package com.byazt.fcd;

import com.byazt.ete.ic;
import com.byazt.ete.kp;
import com.byazt.ete.pu;
import com.byazt.lcf.TTBaseVideoActivity;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_INIT_RTT, 66})
public class t extends c {
    public t(TTBaseVideoActivity tTBaseVideoActivity, ic icVar) {
        super(tTBaseVideoActivity, icVar);
    }

    public static boolean c(ic icVar) {
        return true;
    }

    public static int tt(ic icVar) {
        return 1;
    }

    @Override // com.byazt.fcd.tt
    public boolean b() {
        return q();
    }

    @Override // com.byazt.fcd.c
    public int eo() {
        return tt(this.tt);
    }

    @Override // com.byazt.fcd.tt
    public boolean kk() {
        return !sp() || kp.ve(this.tt, sp());
    }

    @Override // com.byazt.fcd.c
    public void nu() {
        super.nu();
        this.c.bm();
    }

    @Override // com.byazt.fcd.tt
    public boolean os() {
        if (!this.yp) {
            return false;
        }
        if (pu.c(this.tt) == 2 && pu.tt(this.tt) == 3) {
            return false;
        }
        return (pu.c(this.tt) == 2 && pu.tt(this.tt) == 7) ? false : true;
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
        if (kp.nu(this.tt)) {
            boolean z = !kp.ve();
            boolean zVe = kp.ve();
            this.c.ve(0);
            if (yv() > ic() || this.z) {
                com.byazt.fh.a.c = 0;
                com.byazt.kcl.n nVar = this.rh;
                boolean z2 = this.yp;
                nVar.c(z2, z2 ? "领取成功" : "", z ? "跳过" : "", zVe, true);
                this.c.l();
                return;
            }
            int iA = a(true);
            int iA2 = a(false);
            com.byazt.fh.a.c = iA;
            boolean z3 = yv() > this.h.ve() || this.c.lo();
            boolean z4 = z && z3;
            boolean z5 = zVe && z3;
            com.byazt.kcl.n nVar2 = this.rh;
            boolean z6 = this.yp;
            StringBuilder sb = new StringBuilder();
            sb.append(iA2);
            sb.append("s");
            sb.append(this.yp ? "后可领取奖励" : "");
            nVar2.c(z6, sb.toString(), z4 ? "跳过" : "", z5, z3);
            tt(iA);
        }
    }

    @Override // com.byazt.fcd.tt
    public void s() {
        this.rh.tt(this.tt.fe());
        if (a()) {
            this.i.n(8);
            this.i.a(8);
            this.rh.c(false);
        } else {
            this.i.n(0);
            this.i.a(0);
            this.rh.n(true);
        }
        this.c.bm();
    }

    @Override // com.byazt.fcd.tt
    public boolean v() {
        return true;
    }

    @Override // com.byazt.fcd.tt
    public void y() {
        com.byazt.ouz.a aVar = this.qy;
        if (aVar != null) {
            ((com.byazt.nat.c) aVar.c(com.byazt.nat.c.class)).c((Object) this.c);
        }
        com.byazt.ouz.n nVar = this.gu;
        if (nVar != null) {
            ((com.byazt.nat.c) nVar.c(com.byazt.nat.c.class)).c((Object) this.c);
        }
    }
}
