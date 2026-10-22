package com.byazt.lo;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.byazt.ddx.sp;
import com.byazt.ete.ic;
import com.byazt.kt.RecyclerView;
import com.byazt.omf.rh;
import com.byazt.pj.a;
import com.byazt.pj.n;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_IGNORE_BACKGROUND_RENDERSTALL, 15})
public class uj extends com.byazt.ux.c {
    public boolean gr;
    public int gu;
    public List<com.byazt.pj.ve> qy;

    public uj(Context context, ViewGroup viewGroup, sp spVar, ic icVar, String str, int i) {
        super(context, viewGroup, spVar, icVar, str, i);
    }

    @Override // com.byazt.ouz.sl
    public void a() {
    }

    public void a(int i) {
        this.gu = i;
        if (i < 0) {
            return;
        }
        final String str = String.format("浏览%d秒可领金币", Integer.valueOf(i));
        if (this.sp instanceof a) {
            rh.a().post(new Runnable() { // from class: com.byazt.lo.uj.1
                @Override // java.lang.Runnable
                public void run() {
                    if (uj.this.sp != null) {
                        try {
                            RecyclerView recyclerView = (RecyclerView) ((a) uj.this.sp).c();
                            if (recyclerView.getScrollState() != 0 || recyclerView.yp()) {
                                return;
                            }
                            ((a) uj.this.sp).c(0, "header");
                        } catch (Exception unused) {
                        }
                    }
                }
            });
            ((a) this.sp).c(new n.uj() { // from class: com.byazt.lo.uj.2
                @Override // com.byazt.pj.n.uj
                public void c(RecyclerView.gu guVar, int i2) {
                    com.byazt.xj.ve veVarUj = ((n.C0502n) guVar).p().uj("count_down");
                    if (veVarUj instanceof com.byazt.sm.tt) {
                        ((com.byazt.sm.tt) veVarUj).t(str);
                    }
                }
            });
        }
    }

    @Override // com.byazt.ouz.sl
    public long c() {
        return 0L;
    }

    @Override // com.byazt.ouz.sl
    public void c(float f) {
    }

    @Override // com.byazt.ouz.sl
    public void c(float f, float f2, float f3, float f4, int i) {
    }

    @Override // com.byazt.ouz.sl
    public void c(int i) {
    }

    @Override // com.byazt.ouz.sl
    public void c(int i, String str) {
    }

    @Override // com.byazt.ouz.sl
    public void c(ic icVar) {
    }

    @Override // com.byazt.ux.uj
    public void c(RecyclerView recyclerView, int i) {
    }

    @Override // com.byazt.ouz.sl
    public void c(boolean z) {
    }

    @Override // com.byazt.ouz.sl
    public void da() {
    }

    @Override // com.byazt.ouz.sl
    public void i() {
    }

    @Override // com.byazt.ouz.sl
    public void n() {
    }

    @Override // com.byazt.ouz.sl
    public void n(int i) {
    }

    @Override // com.byazt.ux.uj
    public void n(com.byazt.xj.ve<View> veVar) {
        if (veVar == null) {
            return;
        }
        if (this.gu <= 0 && !this.gr && TextUtils.equals(veVar.eo(), "header")) {
            a(0);
            this.gr = true;
        }
        JSONObject jSONObjectDa = veVar.da();
        if (jSONObjectDa == null) {
            return;
        }
        com.byazt.sa.uj ujVarUj = veVar.uj("video_".concat(String.valueOf(jSONObjectDa.optInt("image_mode"))));
        if (ujVarUj instanceof com.byazt.qzm.tt) {
            com.byazt.qzm.tt ttVar = (com.byazt.qzm.tt) ujVarUj;
            ttVar.c(this.u);
            ttVar.b();
        }
    }

    @Override // com.byazt.ouz.sl
    public void setPauseFromExpressView(boolean z) {
    }

    @Override // com.byazt.ux.c
    public List<com.byazt.pj.ve> sl() {
        this.qy = new ArrayList();
        JSONObject jSONObjectYg = this.n.yg();
        this.qy.add(0, new com.byazt.pj.ve(jSONObjectYg, -1221270899));
        this.qy.add(new com.byazt.pj.ve(jSONObjectYg, -2134548432));
        return this.qy;
    }

    @Override // com.byazt.ouz.sl
    public void sp() {
    }

    @Override // com.byazt.ouz.sl
    public int tt() {
        return 0;
    }

    @Override // com.byazt.ouz.sl
    public void tt(int i) {
    }

    @Override // com.byazt.ouz.sl
    public void uj() {
    }

    @Override // com.byazt.ouz.sl
    public void uj(int i) {
    }

    @Override // com.byazt.ux.uj
    public void uj(com.byazt.xj.ve<View> veVar) {
        c(veVar);
    }

    @Override // com.byazt.ouz.sl
    public int ve() {
        return 0;
    }

    @Override // com.byazt.ouz.sl
    public void ve(int i) {
    }

    @Override // com.byazt.ouz.sl
    public void x() {
    }

    @Override // com.byazt.ux.uj
    public void c(int i, int i2) {
        if (i2 > 0) {
            this.da.set(1);
        }
    }

    @Override // com.byazt.ux.ve
    public void ve(com.byazt.xj.ve veVar) {
        ic icVarC;
        if (veVar == null || (icVarC = com.byazt.omf.c.c(veVar.da())) == null) {
            return;
        }
        c(icVarC, veVar);
    }

    @Override // com.byazt.ux.uj
    public void c(com.byazt.xj.ve veVar, int i, View view, com.byazt.pj.ve veVar2) {
        if (veVar2 == null || veVar2.c() == null) {
            return;
        }
        int iHashCode = veVar2.c().hashCode();
        if (this.sl.get(Integer.valueOf(iHashCode)) != null && this.sl.containsKey(Integer.valueOf(iHashCode)) && this.sl.get(Integer.valueOf(iHashCode)).booleanValue()) {
            return;
        }
        c(veVar2.c());
        this.sl.put(Integer.valueOf(iHashCode), Boolean.TRUE);
    }

    @Override // com.byazt.ux.uj
    public void a(com.byazt.xj.ve<View> veVar) {
        JSONObject jSONObjectDa;
        if (veVar == null || (jSONObjectDa = veVar.da()) == null) {
            return;
        }
        com.byazt.sa.uj ujVarUj = veVar.uj("video_".concat(String.valueOf(jSONObjectDa.optInt("image_mode"))));
        if (ujVarUj instanceof com.byazt.qzm.tt) {
            ((com.byazt.qzm.tt) ujVarUj).tx();
        }
    }
}
