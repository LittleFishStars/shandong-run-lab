package com.byazt.fcd;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.byazt.aas.rl;
import com.byazt.ete.ic;
import com.byazt.ete.my;
import com.byazt.lcf.TTBaseVideoActivity;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_INIT_RTT, 158})
public class sl extends c {
    public int d;
    public int eo;
    public com.byazt.ddx.sp zb;

    public sl(TTBaseVideoActivity tTBaseVideoActivity, ic icVar) {
        super(tTBaseVideoActivity, icVar);
        this.d = 0;
        this.eo = 0;
        com.byazt.ddx.sp spVar = new com.byazt.ddx.sp(icVar);
        this.zb = spVar;
        spVar.c(true);
    }

    public static boolean c(ic icVar) {
        return icVar.tx() == 1 && my.c(icVar);
    }

    @Override // com.byazt.fcd.c
    public boolean a() {
        return false;
    }

    @Override // com.byazt.fcd.tt
    public boolean b() {
        return false;
    }

    @Override // com.byazt.fcd.c
    public int bx() {
        if ((this.gt.cu() && my.c(this.tt)) || this.d == 0) {
            return 0;
        }
        if (com.byazt.xs.da.n(this.tt) || com.byazt.xs.da.uj(this.tt)) {
            return Math.max(this.d - yv(), 0);
        }
        return Math.max(((int) Math.min((this.d * this.tt.cs()) / 100.0f, 27.0f)) - yv(), 0);
    }

    @Override // com.byazt.fcd.c
    public int eo() {
        return tt(this.tt);
    }

    @Override // com.byazt.fcd.c
    public void gu() {
        if (com.byazt.xs.da.uj(this.tt) && ((com.byazt.dqg.c) this.i).ve()) {
            ((com.byazt.dqg.c) this.i).c(false);
        }
    }

    @Override // com.byazt.fcd.c
    public View i() {
        FrameLayout frameLayout = new FrameLayout(this.c);
        frameLayout.setId(2114387959);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return frameLayout;
    }

    @Override // com.byazt.fcd.tt
    public boolean kk() {
        return false;
    }

    @Override // com.byazt.fcd.c
    public void m() {
        super.m();
        com.byazt.dqg.tt ttVar = this.i;
        if ((ttVar instanceof com.byazt.dqg.c) && ((com.byazt.dqg.c) ttVar).a()) {
            this.zb.uj();
        }
        this.i.da();
    }

    @Override // com.byazt.fcd.c
    public void n(boolean z) {
        super.n(z);
        if (com.byazt.xs.da.uj(this.tt)) {
            ((com.byazt.dqg.c) this.i).tt(z);
        }
    }

    @Override // com.byazt.fcd.c
    public boolean or() {
        if (pf() > 0) {
            return false;
        }
        if (!com.byazt.xs.da.n(this.tt)) {
            return true;
        }
        ((com.byazt.dqg.c) this.i).c(0);
        return true;
    }

    @Override // com.byazt.fcd.tt
    public boolean q() {
        return false;
    }

    @Override // com.byazt.fcd.tt
    public void r() {
        int iYv = yv();
        int iMax = Math.max(0, this.d - iYv);
        if (!this.gt.cu()) {
            int i = this.d;
            if (iYv >= i) {
                if (com.byazt.xs.da.ve(this.tt)) {
                    com.byazt.kcl.n nVar = this.rh;
                    boolean z = this.yp;
                    nVar.c(z, z ? "领取成功" : "", null, true, true);
                } else {
                    this.rh.c(false, null, null, true, true);
                }
                this.c.t();
            } else if (this.eo >= i) {
                this.rh.c(false, String.valueOf(iMax), null, false, false);
            } else if (com.byazt.xs.da.ve(this.tt)) {
                com.byazt.kcl.n nVar2 = this.rh;
                boolean z2 = this.yp;
                StringBuilder sb = new StringBuilder();
                sb.append(iMax);
                sb.append("s");
                sb.append(this.yp ? "后可领取奖励" : "");
                nVar2.c(z2, sb.toString(), null, this.eo <= iYv, true);
            } else if (com.byazt.xs.da.n(this.tt) || com.byazt.xs.da.uj(this.tt)) {
                if (iYv >= this.eo) {
                    this.rh.c(false, null, null, true, true);
                }
            } else if (iYv >= this.eo) {
                this.rh.c(false, String.valueOf(iMax), "跳过", false, true);
            } else {
                this.rh.c(false, String.valueOf(iMax), (this.eo - iYv) + "s后可跳过", false, false);
            }
        }
        this.c.ve(0);
        if (com.byazt.xs.da.n(this.tt)) {
            ((com.byazt.dqg.c) this.i).c(iMax);
        }
        if (iMax == 0) {
            com.byazt.dqg.tt ttVar = this.i;
            if (ttVar instanceof com.byazt.dqg.c) {
                ((com.byazt.dqg.c) ttVar).sp();
            }
        }
    }

    @Override // com.byazt.fcd.tt
    public void s() {
        this.i.n(0);
        this.rh.c(true);
        if (com.byazt.xs.da.uj(this.tt)) {
            this.rh.n(true);
        }
        if (com.byazt.xs.da.n(this.tt) || com.byazt.xs.da.uj(this.tt)) {
            this.rh.tt(false);
        } else {
            this.rh.tt(this.tt.fe());
        }
        if (!com.byazt.xs.da.ve(this.tt)) {
            this.rh.n(false);
            this.rh.c(false, null, null, true, true);
            return;
        }
        this.rh.ve(true);
        this.rh.n(true);
        com.byazt.kcl.n nVar = this.rh;
        boolean z = this.yp;
        StringBuilder sb = new StringBuilder();
        sb.append(pf());
        sb.append("s");
        sb.append(this.yp ? "后可领取奖励" : "");
        nVar.c(z, sb.toString(), null, true, true);
    }

    @Override // com.byazt.fcd.c
    public int sp(boolean z) {
        if ((this.gt.cu() && my.c(this.tt)) || this.d == 0) {
            return 0;
        }
        return (com.byazt.xs.da.n(this.tt) || com.byazt.xs.da.uj(this.tt)) ? Math.max(this.d - yv(), 0) : Math.max(Math.min(this.d, 27) - yv(), 0);
    }

    @Override // com.byazt.fcd.c
    public void tt(boolean z) {
        super.tt(z);
        this.zb.ve();
        com.byazt.dqg.tt ttVar = this.i;
        if (ttVar instanceof com.byazt.dqg.c) {
            ((com.byazt.dqg.c) ttVar).i();
        }
    }

    @Override // com.byazt.fcd.c
    public void ve(boolean z) {
        super.ve(z);
        com.byazt.dqg.tt ttVar = this.i;
        if (ttVar instanceof com.byazt.dqg.c) {
            if (((com.byazt.dqg.c) ttVar).a()) {
                this.zb.c(((com.byazt.dqg.c) this.i).n().get());
            }
            ((com.byazt.dqg.c) this.i).x();
        }
    }

    @Override // com.byazt.fcd.c
    public void x() {
        JSONObject jSONObjectVe;
        super.x();
        com.byazt.ab.tt.c().c(this.tt);
        if (com.byazt.xs.da.n(this.tt) || com.byazt.xs.da.uj(this.tt)) {
            com.byazt.lo.c cVarOs = this.tt.os();
            this.d = 30;
            if (cVarOs != null && (jSONObjectVe = cVarOs.ve()) != null) {
                this.d = jSONObjectVe.optInt("reward_time", 30);
            }
        } else {
            this.d = rl.n(this.tt);
        }
        this.eo = rl.a(this.tt);
    }

    @Override // com.byazt.fcd.c
    public void yp() {
        super.yp();
    }

    @Override // com.byazt.fcd.c
    public com.byazt.dqg.tt c(boolean z) {
        com.byazt.dqg.c cVar = new com.byazt.dqg.c(this.c, this.tt, z, this.zb, this.rh);
        this.i = cVar;
        return cVar;
    }

    @Override // com.byazt.fcd.c
    public com.byazt.qq.tt.c c(final ic icVar, final com.byazt.qq.da daVar) {
        this.c.sv();
        this.c.bx();
        com.byazt.qq.x xVar = new com.byazt.qq.x(this.c, icVar);
        xVar.c(this.gt.rl());
        xVar.c(sv());
        return xVar.tt(new com.byazt.qq.da() { // from class: com.byazt.fcd.sl.1
            @Override // com.byazt.qq.da
            public void c() {
                com.byazt.qq.da daVar2 = daVar;
                if (daVar2 != null) {
                    daVar2.c();
                }
                if (com.byazt.xs.da.uj(icVar) && ((com.byazt.dqg.c) sl.this.i).uj()) {
                    return;
                }
                sl.this.c.aw();
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

    public static int tt(ic icVar) {
        return com.byazt.xs.da.ve(icVar) ? 6 : 7;
    }

    @Override // com.byazt.fcd.c, com.byazt.fcd.tt
    public void ve() {
        this.rh.c(4);
        this.i.ve(true);
        if (com.byazt.xs.da.n(this.tt) || com.byazt.xs.da.uj(this.tt)) {
            ((com.byazt.dqg.c) this.i).c(Math.max(0, this.d - yv()));
        }
        this.c.tt(true, true);
    }
}
