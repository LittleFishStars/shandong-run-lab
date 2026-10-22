package com.byazt.fcd;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.byazt.aas.pf;
import com.byazt.dna.u;
import com.byazt.ete.bx;
import com.byazt.ete.ic;
import com.byazt.ete.kp;
import com.byazt.ete.to;
import com.byazt.ete.xd;
import com.byazt.lcf.TTBaseVideoActivity;
import com.byazt.nr.m;
import com.byazt.omf.gt;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_INIT_RTT, 42})
public class i extends c {
    public boolean d;
    public boolean eo;

    public i(TTBaseVideoActivity tTBaseVideoActivity, ic icVar) {
        super(tTBaseVideoActivity, icVar);
        this.d = false;
        this.eo = false;
        this.eo = com.byazt.glq.tt.c(icVar) == 1;
    }

    public static int c(ic icVar) {
        return 9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (this.d) {
            return;
        }
        this.d = true;
        i(false);
        this.c.finish();
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
    public int eo() {
        return c(this.tt);
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

    @Override // com.byazt.fcd.tt
    public boolean q() {
        return false;
    }

    @Override // com.byazt.fcd.tt
    public void s() {
    }

    @Override // com.byazt.fcd.c, com.byazt.fcd.tt
    public void ve() {
        com.byazt.dqg.n nVar;
        this.c.tt(true, true);
        this.i.ve(true);
        this.da.ve(false);
        this.rh.c(false);
        int displayDpi = ((u) com.byazt.ut.uj.getService("device_info_new")).getDisplayDpi();
        com.byazt.ete.i.c cVarTt = new com.byazt.ete.i.c().a(-1.0f).n(-1.0f).uj(-1.0f).ve(-1.0f).tt(-1L).c(-1L).uj(-1).n(-1).a(-1024).ve(com.byazt.omf.x.m().tt() ? 1 : 2).tt(displayDpi).c(pf.a(gt.getContext())).tt(pf.sp(gt.getContext()));
        ic icVar = this.tt;
        if (icVar != null && icVar.by() == 1 && (nVar = this.da) != null) {
            cVarTt.c(nVar.a() ? this.da.da() : (byte) 0);
        }
        cVarTt.c(com.byazt.wz.x.tt(this.tt));
        com.byazt.ddx.uj.c("click", this.tt, cVarTt.c(), this.t, true, this.c.ic(), -1, false, false);
    }

    public static boolean c(Context context, ic icVar) {
        long jSp;
        if (!to.uj(icVar)) {
            return false;
        }
        if (bx.c(icVar)) {
            jSp = ((long) bx.tt(icVar)) * 1000;
        } else {
            jSp = xd.z(icVar) != null ? (long) (xd.sp(icVar) * 1000.0d) : 0L;
        }
        long jMin = Math.min(kp.c(), (long) (jSp * (icVar.cs() / 100.0f)));
        HashMap map = new HashMap(3);
        map.put("reward_countdown", Long.valueOf(jMin));
        map.put("event_tag", "rewarded_video");
        map.put("reward_live_scene", Integer.valueOf(com.byazt.glq.tt.c(icVar)));
        return com.byazt.apd.tt.c().c(context, icVar, (Map<String, Object>) map) == 0;
    }

    private void i(final boolean z) {
        if (this.i instanceof com.byazt.dqg.i) {
            com.byazt.bzd.x.c(new Runnable() { // from class: com.byazt.fcd.i.2
                @Override // java.lang.Runnable
                public void run() {
                    com.byazt.dqg.tt ttVar = i.this.i;
                    if (ttVar == null) {
                        return;
                    }
                    com.byazt.dqg.i iVar = (com.byazt.dqg.i) ttVar;
                    if (z) {
                        iVar.tt();
                    } else {
                        iVar.ve();
                    }
                }
            });
        }
    }

    @Override // com.byazt.fcd.c
    public com.byazt.dqg.tt c(boolean z) {
        com.byazt.dqg.i iVar = new com.byazt.dqg.i(this.c, this.tt, z);
        this.i = iVar;
        return iVar;
    }

    @Override // com.byazt.fcd.c
    public void c(int i, int i2, Intent intent) {
        super.c(i, i2, intent);
        if (i != 1) {
            this.c.finish();
            return;
        }
        if (intent == null || intent.getExtras() == null) {
            this.c.finish();
            return;
        }
        if (intent.getExtras().getLong("csj.reward_countdown_duration_ms") <= 0) {
            int i3 = intent.getExtras().getInt("csj.reward_auth_status", 0);
            if (this.eo && i3 == 1) {
                this.c.finish();
                return;
            }
            m.uj("rewardAuthFlag", "verify rew....");
            this.c.uj(0);
            i(true);
            this.c.nb().postDelayed(new Runnable() { // from class: com.byazt.fcd.i.1
                @Override // java.lang.Runnable
                public void run() {
                    i.this.j();
                }
            }, 2000L);
            return;
        }
        this.c.finish();
    }

    @Override // com.byazt.fcd.c
    public void c(int i) {
        super.c(i);
        if (i == 0) {
            j();
        }
    }
}
