package com.byazt.fcd;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.byazt.aas.nb;
import com.byazt.ete.h;
import com.byazt.ete.ic;
import com.byazt.ete.lt;
import com.byazt.lcf.TTBaseVideoActivity;
import com.byazt.nr.m;
import com.byazt.ukr.yp;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_INIT_RTT, 72})
public class da extends c {
    public final List<com.byazt.msx.c> d;
    public int eo;

    public da(TTBaseVideoActivity tTBaseVideoActivity, ic icVar) {
        super(tTBaseVideoActivity, icVar);
        this.d = new ArrayList();
        this.eo = 0;
    }

    public static boolean c(ic icVar) {
        if (icVar == null || !h.c(icVar)) {
            return false;
        }
        if (!com.byazt.dl.uj.c(String.valueOf(nb.t(icVar)))) {
            return true;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cid", icVar.gu());
        } catch (JSONException e) {
            m.c(e);
        }
        yp.c().c(icVar, "refresh_max", jSONObject);
        com.byazt.ddx.uj.sp(icVar, nb.tt(icVar), "refresh_max", null);
        return false;
    }

    private com.byazt.dqg.da ma() {
        com.byazt.dqg.tt ttVar = this.i;
        if (ttVar instanceof com.byazt.dqg.da) {
            return (com.byazt.dqg.da) ttVar;
        }
        return null;
    }

    public static int tt(ic icVar) {
        return 11;
    }

    private int yf() {
        int iN;
        com.byazt.msx.c cVar;
        ic icVarC;
        h hVarZo;
        com.byazt.dqg.da daVar = (com.byazt.dqg.da) this.i;
        if (daVar == null || (iN = daVar.n()) < 0 || iN >= this.d.size() || (cVar = this.d.get(iN)) == null || (icVarC = cVar.c()) == null || (hVarZo = icVarC.zo()) == null) {
            return 0;
        }
        return hVarZo.ve();
    }

    @Override // com.byazt.fcd.c
    public boolean a() {
        return false;
    }

    @Override // com.byazt.fcd.c
    public int aw() {
        return this.eo;
    }

    @Override // com.byazt.fcd.tt
    public boolean b() {
        return false;
    }

    @Override // com.byazt.fcd.c
    public int bx() {
        return lt.ve(this.tt) - this.eo;
    }

    @Override // com.byazt.fcd.c
    public void cu() {
        super.cu();
        com.byazt.dqg.tt ttVar = this.i;
        if (ttVar instanceof com.byazt.dqg.da) {
            ((com.byazt.dqg.da) ttVar).uj();
        }
    }

    public void dz() {
        ((com.byazt.dqg.da) this.i).a();
    }

    @Override // com.byazt.fcd.c
    public int eo() {
        return tt(this.tt);
    }

    @Override // com.byazt.fcd.c
    public void gu() {
        ((com.byazt.dqg.da) this.i).ve();
    }

    @Override // com.byazt.fcd.c
    public View i() {
        FrameLayout frameLayout = new FrameLayout(this.c);
        frameLayout.setId(2114387959);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        frameLayout.setBackgroundColor(0);
        return frameLayout;
    }

    public void j() {
        ((com.byazt.dqg.da) this.i).uj();
    }

    @Override // com.byazt.fcd.tt
    public boolean kk() {
        return true;
    }

    @Override // com.byazt.fcd.c
    public void m() {
        super.m();
        this.i.da();
        List<com.byazt.msx.c> list = this.d;
        if (list != null) {
            Iterator<com.byazt.msx.c> it = list.iterator();
            while (it.hasNext()) {
                it.next().x();
            }
        }
    }

    @Override // com.byazt.fcd.c
    public void n(boolean z) {
        super.n(z);
    }

    @Override // com.byazt.fcd.tt
    public boolean q() {
        return true;
    }

    @Override // com.byazt.fcd.c
    public void qy() {
        ((com.byazt.dqg.da) this.i).tt();
    }

    @Override // com.byazt.fcd.tt
    public void s() {
        this.rh.c(false);
        this.rh.tt(false);
        this.rh.n(false);
    }

    @Override // com.byazt.fcd.c
    public int sp(boolean z) {
        return z ? bx() : lt.sp(this.tt) - this.eo;
    }

    @Override // com.byazt.fcd.c
    public void tt(boolean z) {
        super.tt(z);
        ((com.byazt.dqg.da) this.i).ve();
    }

    @Override // com.byazt.fcd.c, com.byazt.fcd.tt
    public void ve() {
        this.i.ve(true);
        if (ma() != null) {
            ma().c(this.d);
        }
        this.c.tt(false, true);
    }

    @Override // com.byazt.fcd.c
    public void x() {
        super.x();
        com.byazt.msx.c cVar = new com.byazt.msx.c(this.c, this.tt, this.t, q(), true);
        cVar.c(this.u);
        this.d.add(cVar);
        if (h.ve(this.tt)) {
            try {
                JSONArray jSONArray = new JSONArray(this.tt.hl());
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(com.byazt.omf.c.c(jSONArray.getJSONObject(i)));
                }
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(this.tt);
                arrayList2.addAll(arrayList);
                if (h.c(arrayList2)) {
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        com.byazt.msx.c cVar2 = new com.byazt.msx.c(this.c, (ic) arrayList.get(i2), this.t, q(), false);
                        cVar2.c(this.u);
                        this.d.add(cVar2);
                    }
                }
            } catch (JSONException e) {
                m.c(e);
            }
        }
    }

    @Override // com.byazt.fcd.c
    public void yp() {
        super.yp();
        ((com.byazt.dqg.da) this.i).tt();
    }

    @Override // com.byazt.fcd.c
    public void zm() {
        super.zm();
        com.byazt.dqg.tt ttVar = this.i;
        if (ttVar instanceof com.byazt.dqg.da) {
            ((com.byazt.dqg.da) ttVar).da();
        }
    }

    @Override // com.byazt.fcd.c
    public void tt(Map<String, Object> map) {
        super.tt(map);
        map.put("refresh_num", Integer.valueOf(yf()));
    }

    @Override // com.byazt.fcd.c
    public com.byazt.dqg.tt c(boolean z) {
        com.byazt.dqg.da daVar = new com.byazt.dqg.da(this.c, this.tt, z);
        daVar.c(new float[]{this.n, this.f28536a});
        this.i = daVar;
        return daVar;
    }

    @Override // com.byazt.fcd.c
    public com.byazt.qq.tt.c c(ic icVar, final com.byazt.qq.da daVar) {
        this.c.sv();
        com.byazt.qq.n nVar = new com.byazt.qq.n(this.c, icVar);
        nVar.c(sv());
        return nVar.tt(new com.byazt.qq.da() { // from class: com.byazt.fcd.da.1
            @Override // com.byazt.qq.da
            public void c() {
                super.c();
                com.byazt.qq.da daVar2 = daVar;
                if (daVar2 != null) {
                    daVar2.c();
                }
                da.this.c.aw();
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
                super.ve();
                com.byazt.qq.da daVar2 = daVar;
                if (daVar2 != null) {
                    daVar2.ve();
                }
                da.this.c.aw();
                da.this.c.lt().c("reward_retain_dialog_next", 0, "");
            }
        });
    }

    @Override // com.byazt.fcd.c
    public void c(Map<String, Object> map) {
        super.c(map);
        map.put("refresh_num", Integer.valueOf(yf()));
    }

    @Override // com.byazt.fcd.c
    public void c(JSONObject jSONObject) {
        super.c(jSONObject);
        try {
            jSONObject.put("refresh_num", yf());
        } catch (JSONException e) {
            m.c(e);
        }
    }

    @Override // com.byazt.fcd.c
    public void c(View view) {
        super.c(view);
    }
}
