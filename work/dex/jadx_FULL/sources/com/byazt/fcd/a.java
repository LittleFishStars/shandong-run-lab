package com.byazt.fcd;

import android.app.Dialog;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.byazt.ete.ic;
import com.byazt.ete.kp;
import com.byazt.ete.pf;
import com.byazt.ete.pu;
import com.byazt.ete.tk;
import com.byazt.ete.to;
import com.byazt.lcf.TTBaseVideoActivity;
import com.byazt.nr.m;
import com.byazt.omf.gr;
import com.byazt.omf.gt;
import com.byazt.omf.gu;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_INIT_RTT, 34})
public class a extends c {
    public com.byazt.hkv.c cu;
    public boolean d;
    public final AtomicBoolean eo;
    public com.byazt.rpt.tt or;
    public boolean zb;

    public a(TTBaseVideoActivity tTBaseVideoActivity, ic icVar) {
        super(tTBaseVideoActivity, icVar);
        this.d = false;
        this.eo = new AtomicBoolean(false);
    }

    private JSONObject dz() {
        JSONObject jSONObject = new JSONObject();
        pf pfVarGt = this.tt.gt();
        if (pfVarGt == null) {
            return jSONObject;
        }
        String strUj = pfVarGt.uj();
        if (TextUtils.isEmpty(strUj)) {
            return jSONObject;
        }
        try {
            String strOptString = new JSONObject(strUj).optString("token");
            jSONObject.put("req_id", pfVarGt.a());
            jSONObject.put("token", strOptString);
            jSONObject.put("action", "query_box");
        } catch (JSONException e) {
            m.c(e);
        }
        return jSONObject;
    }

    private void ma() {
        com.byazt.hkv.n nVar;
        if (this.d || (nVar = this.x) == null) {
            return;
        }
        if (((com.byazt.nat.c) nVar.c(com.byazt.nat.c.class)).tt().sl()) {
            this.d = true;
            tt(8, 0);
            return;
        }
        if (to.c(this.tt)) {
            int iN = to.n(this.tt);
            if (this.tt.by() == 2) {
                tt(0, -1);
            }
            if (iN != 3) {
                return;
            }
            long jSp = ((long) to.sp(this.tt)) * 1000;
            if (this.my.h() < jSp) {
                tt(0, (int) ((jSp - this.my.h()) / 1000));
                return;
            }
            tt(8, 0);
            yf();
            this.d = true;
        }
    }

    public static int tt(ic icVar) {
        return 2;
    }

    private void uj(int i) {
        com.byazt.hkv.n nVar = this.x;
        if (nVar != null) {
            ((com.byazt.nat.c) nVar.c(com.byazt.nat.c.class)).c(i);
        }
        com.byazt.ouz.n nVar2 = this.gu;
        if (nVar2 != null) {
            ((com.byazt.nat.c) nVar2.c(com.byazt.nat.c.class)).c(i);
        }
        com.byazt.ouz.a aVar = this.qy;
        if (aVar != null) {
            ((com.byazt.nat.c) aVar.c(com.byazt.nat.c.class)).c(i);
        }
    }

    private void yf() {
        if (this.x == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put("is_auto_click", Boolean.TRUE);
        ((com.byazt.vis.c) this.x.c(com.byazt.vis.c.class)).c(map);
        this.x.c(null, new com.byazt.ete.da());
    }

    @Override // com.byazt.fcd.tt
    public boolean b() {
        return q() && pu.c(this.tt) == 1;
    }

    @Override // com.byazt.fcd.c
    public int eo() {
        return tt(this.tt);
    }

    @Override // com.byazt.fcd.c
    public View i() {
        if (this.uj != 100.0f) {
            return com.byazt.vfu.a.gu(this.c);
        }
        return this.ve == 2 ? com.byazt.vfu.a.z(this.c) : com.byazt.vfu.a.m(this.c);
    }

    public void j() {
        if (to.c(this.tt)) {
            pf pfVarGt = this.tt.gt();
            if (pfVarGt != null || com.byazt.apd.tt.c().tt(this.tt)) {
                int iPf = pf();
                if (pfVarGt != null) {
                    pfVarGt.c(iPf);
                }
                uj(iPf);
            }
        }
    }

    @Override // com.byazt.fcd.tt
    public boolean kk() {
        return kp.ve(this.tt, sp());
    }

    @Override // com.byazt.fcd.c
    public void nu() {
        super.nu();
        this.i.ve(0);
    }

    @Override // com.byazt.fcd.tt
    public boolean q() {
        return true;
    }

    @Override // com.byazt.fcd.c
    public boolean rh() {
        if (this.zb) {
            return true;
        }
        return (com.byazt.apd.tt.c().tt(this.tt) || to.ve(this.tt)) ? false : true;
    }

    @Override // com.byazt.fcd.c
    public void rl() {
        super.rl();
        j();
        if (this.da.a()) {
            return;
        }
        if (com.byazt.apd.tt.c().tt(this.tt)) {
            ma();
            return;
        }
        if (to.c(this.tt) && this.or == null && !com.byazt.omf.tt.c().get("is_reward_deep_link_to_live", false) && to.n(this.tt) != 1 && this.my.h() >= ((long) to.sp(this.tt)) * 1000) {
            this.eo.set(true);
            com.byazt.kcl.a aVar = this.my;
            if (aVar != null && aVar.tt()) {
                this.c.sv();
            }
            this.or = new com.byazt.rpt.tt(this.c, this.tt, new com.byazt.rpt.tt.c() { // from class: com.byazt.fcd.a.2
                @Override // com.byazt.rpt.tt.c
                public void c(Dialog dialog) {
                    a.this.or.dismiss();
                    a.this.c.aw();
                    a.this.eo.set(false);
                }

                @Override // com.byazt.rpt.tt.c
                public void tt(Dialog dialog) {
                    if (a.this.cu != null) {
                        HashMap map = new HashMap();
                        map.put("is_auto_click", Boolean.TRUE);
                        ((com.byazt.vis.c) a.this.cu.c(com.byazt.vis.c.class)).c(map);
                        a.this.cu.c(null, new com.byazt.ete.da());
                    }
                }
            });
            com.byazt.hkv.c cVar = new com.byazt.hkv.c(this.c, this.tt, this.t, 7) { // from class: com.byazt.fcd.a.3
                @Override // com.byazt.hkv.tt, com.byazt.hkv.uj
                public void c(View view, com.byazt.ete.da daVar) {
                    super.c(view, daVar);
                    a.this.or.dismiss();
                }
            };
            this.cu = cVar;
            this.c.c((com.byazt.vis.ve) cVar.c(com.byazt.vis.ve.class));
            this.or.c(this.cu);
            if (this.c.isFinishing()) {
                return;
            }
            this.or.show();
        }
    }

    @Override // com.byazt.fcd.tt
    public void s() {
        if (a()) {
            this.rh.tt(false);
            this.rh.n(false);
            this.i.a(8);
            this.i.n(8);
            this.i.ve(8);
        } else {
            this.rh.tt(this.tt.fe());
            this.rh.n(true);
            this.i.a(0);
            this.i.n(0);
            this.i.ve(0);
        }
        this.c.bm();
    }

    @Override // com.byazt.fcd.tt
    public boolean v() {
        return true;
    }

    @Override // com.byazt.fcd.c
    public boolean zb() {
        return this.eo.get();
    }

    @Override // com.byazt.fcd.c
    public void tt(boolean z) {
        super.tt(z);
        if (!com.byazt.omf.tt.c().get("is_reward_deep_link_to_live", false) || to.ve(this.tt) || z) {
            return;
        }
        gt.c().c(dz(), new gu.uj() { // from class: com.byazt.fcd.a.1
            @Override // com.byazt.omf.gu.uj
            public void c(int i, String str) {
                a.this.i(false);
            }

            @Override // com.byazt.omf.gu.uj
            public void c(gr.ve veVar) {
                tk tkVar = veVar.ve;
                if (tkVar == null) {
                    return;
                }
                boolean zC = tkVar.c();
                a.this.i(zC);
                if (zC) {
                    a.this.c.uj(0);
                }
            }
        });
    }

    public static boolean c(ic icVar) {
        return com.byazt.ex.c.c(icVar);
    }

    @Override // com.byazt.fcd.c
    public com.byazt.dqg.tt c(boolean z) {
        if (this.uj != 100.0f) {
            this.i = new com.byazt.dqg.sp(this.c, this.tt, z);
        } else {
            this.i = new com.byazt.dqg.x(this.c, this.tt, z);
        }
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("showSkip", z);
            com.byazt.dqg.n nVar = this.da;
            if (nVar != null) {
                nVar.c("showSkipInLiveScene", jSONObject);
            }
        } catch (JSONException e) {
            m.c(e);
        }
    }

    private void tt(int i, int i2) {
        com.byazt.dqg.tt ttVar = this.i;
        if (ttVar != null && (ttVar instanceof com.byazt.dqg.x)) {
            ((com.byazt.dqg.x) ttVar).c(i, i2);
        }
    }

    @Override // com.byazt.fcd.c
    public void c(int i, int i2, Intent intent) {
        super.c(i, i2, intent);
        if (to.ve(this.tt) || i != 1 || intent == null || intent.getExtras() == null || this.zb) {
            return;
        }
        long j = intent.getExtras().getLong("csj.reward_countdown_duration_ms");
        int iPf = (int) (((long) pf()) - j);
        this.c.c(iPf, false);
        if (j <= 0) {
            i(true);
            uj(0);
            this.zb = true;
            return;
        }
        c(iPf);
    }

    private void c(long j) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("showTime", j);
            com.byazt.dqg.n nVar = this.da;
            if (nVar == null || !nVar.a()) {
                return;
            }
            this.da.c("rewardInnerLiveShowTime", jSONObject);
        } catch (JSONException e) {
            m.c(e);
        }
    }
}
