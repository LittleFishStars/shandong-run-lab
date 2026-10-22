package com.byazt.fcd;

import com.byazt.ete.b;
import com.byazt.ete.ic;
import com.byazt.ete.kp;
import com.byazt.lcf.TTBaseVideoActivity;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_INIT_RTT, 71})
public class x extends c {
    public final com.byazt.zd.tt bx;
    public final AtomicBoolean cu;
    public final AtomicLong d;
    public final int eo;
    public final AtomicBoolean nb;
    public final AtomicBoolean or;
    public com.byazt.yqb.c pf;
    public final AtomicBoolean qp;
    public long zb;

    public x(TTBaseVideoActivity tTBaseVideoActivity, ic icVar) {
        super(tTBaseVideoActivity, icVar);
        this.eo = 4;
        this.zb = 4L;
        this.or = new AtomicBoolean(false);
        this.cu = new AtomicBoolean(false);
        this.qp = new AtomicBoolean(false);
        this.nb = new AtomicBoolean(false);
        this.d = new AtomicLong();
        this.bx = new com.byazt.zd.tt() { // from class: com.byazt.fcd.x.1
            @Override // com.byazt.zd.tt
            public boolean a() {
                return x.this.rl.a();
            }

            @Override // com.byazt.zd.tt
            public boolean c() {
                if (!x.this.qp.get() && !b.tt(x.this.tt)) {
                    return false;
                }
                x.this.dz();
                return true;
            }

            @Override // com.byazt.zd.tt
            public void da() {
                TTBaseVideoActivity tTBaseVideoActivity2 = x.this.c;
                if (tTBaseVideoActivity2 != null) {
                    tTBaseVideoActivity2.sl();
                }
            }

            @Override // com.byazt.zd.tt
            public void i() {
                x.this.c.aw();
            }

            @Override // com.byazt.zd.tt
            public long n() {
                return x.this.d.get();
            }

            @Override // com.byazt.zd.tt
            public int sl() {
                return x.this.qp.get() ? 1 : 2;
            }

            @Override // com.byazt.zd.tt
            public Map<String, Object> sp() {
                HashMap map = new HashMap();
                map.put("refer", "in_video");
                return map;
            }

            @Override // com.byazt.zd.tt
            public void tt() {
                x.this.qp.set(false);
                x.this.i.n(8);
                if (!x.this.sp()) {
                    x.this.c.aw();
                }
                x.this.c.gu();
            }

            @Override // com.byazt.zd.tt
            public boolean uj() {
                return x.this.nb.get();
            }

            @Override // com.byazt.zd.tt
            public void ve() {
                x.this.cu();
                x.this.nb.set(true);
                x.this.c.t();
            }

            @Override // com.byazt.zd.tt
            public void x() {
                x.this.ma();
            }

            @Override // com.byazt.zd.tt
            public void c(long j, long j2) {
                x.this.my.tt(j);
                x.this.rl();
                x.this.d.set(j);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dz() {
        this.i.n(0);
        this.c.sv();
        this.pf.ve();
        this.c.qy();
    }

    private void f() {
        if (this.or.get()) {
            j();
            ir();
        }
    }

    private void ir() {
        if (this.cu.get()) {
            long j = this.zb - 1;
            this.zb = j;
            if (j != 0) {
                if (j > 0) {
                    this.pf.c(j);
                }
            } else {
                this.pf.c(j);
                this.qp.set(true);
                if (sp()) {
                    this.pf.c(this.gu);
                } else {
                    this.pf.c(this.x);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ma() {
        this.or.set(false);
    }

    public static int tt(ic icVar) {
        return 10;
    }

    private void yf() {
        this.cu.set(true);
        this.pf.c();
    }

    @Override // com.byazt.fcd.tt
    public boolean b() {
        return true;
    }

    @Override // com.byazt.fcd.c
    public void cu() {
        super.cu();
        this.rh.c(false, "奖励已领取", "跳过", false, true);
    }

    @Override // com.byazt.fcd.c
    public int eo() {
        return tt(this.tt);
    }

    public void j() {
        if (this.cu.get()) {
            return;
        }
        int iH = (int) this.my.h();
        int iGt = (int) this.my.gt();
        int iVe = b.ve(this.tt);
        if (iVe == 1) {
            c(b.uj(this.tt), iGt, 1000 * ((long) this.h.n()), false);
        } else if (iVe == 2) {
            c((int) (iGt * 0.001f * 0.01f * b.uj(this.tt)), iGt, iH, false);
        } else {
            if (iVe != 3) {
                return;
            }
            c(pf(), iGt, iH, true);
        }
    }

    @Override // com.byazt.fcd.tt
    public boolean kk() {
        return true;
    }

    @Override // com.byazt.fcd.tt
    public boolean os() {
        return true;
    }

    @Override // com.byazt.fcd.tt
    public boolean oz() {
        return kp.nu(this.tt);
    }

    @Override // com.byazt.fcd.tt
    public boolean q() {
        return true;
    }

    @Override // com.byazt.fcd.c
    public com.byazt.zd.tt qp() {
        return this.bx;
    }

    @Override // com.byazt.fcd.tt
    public void r() {
        f();
        if (kp.nu(this.tt)) {
            this.c.ve(0);
            if (yv() > ic() || this.z) {
                com.byazt.fh.a.c = 0;
            }
            tt(a(true));
            com.byazt.fh.a.c = sv();
        }
    }

    @Override // com.byazt.fcd.c
    public void rl() {
        super.rl();
        this.m = false;
        boolean z = ((int) (this.my.h() / 1000)) >= this.h.ve() || this.c.lo();
        if (this.my.eo()) {
            this.rh.c(false, null, "跳过", false, true);
            return;
        }
        int iMd = this.my.md();
        if (this.my.c()) {
            return;
        }
        this.rh.c(false, iMd + "s", z ? "跳过" : "", false, z);
    }

    @Override // com.byazt.fcd.tt
    public void s() {
        this.i.n(8);
        this.i.a(0);
        this.rh.n(true);
        this.rh.ve(true);
        this.rh.tt(true);
        this.rh.c(true);
        this.c.bm();
    }

    @Override // com.byazt.fcd.tt
    public boolean tx() {
        return true;
    }

    @Override // com.byazt.fcd.tt
    public void y() {
        com.byazt.ouz.n nVar = this.gu;
        if (nVar != null) {
            ((com.byazt.nat.c) nVar.c(com.byazt.nat.c.class)).c(this.bx);
            ((com.byazt.vis.c) this.gu.c(com.byazt.vis.c.class)).c(this.bx);
        }
        com.byazt.hkv.n nVar2 = this.x;
        if (nVar2 != null) {
            ((com.byazt.nat.c) nVar2.c(com.byazt.nat.c.class)).c(this.bx);
            ((com.byazt.vis.c) this.x.c(com.byazt.vis.c.class)).c(this.bx);
        }
        com.byazt.yqb.c cVar = new com.byazt.yqb.c(this.c, this.tt, this.bx);
        this.pf = cVar;
        cVar.c(this.c.or().getSceneFrameContainer(), this.c.or().getSceneFrame());
        this.or.set(b.ve(this.tt) != 0);
        if (this.or.get()) {
            this.m = true;
        }
    }

    @Override // com.byazt.fcd.c
    public void zm() {
        super.zm();
        this.rh.c(false, "奖励已领取", "跳过", false, true);
    }

    public static boolean c(ic icVar) {
        return b.c(icVar);
    }

    private void c(int i, long j, long j2, boolean z) {
        if (z) {
            if (i <= 3) {
                yf();
            }
        } else if (i > 0) {
            long j3 = ((long) i) * 1000;
            if (j3 > j) {
                return;
            }
            long j4 = j3 - j2;
            if (j4 <= 0 || Math.abs(j4) > 3200) {
                return;
            }
            yf();
        }
    }
}
