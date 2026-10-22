package com.byazt.ll;

import android.util.SparseArray;
import androidx.camera.video.AudioStats;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1360, 13})
public class tt implements uj, ve {
    public uj c;
    public String n;
    public com.byazt.nbs.tt tt;
    public boolean uj;
    public ve ve;

    public tt(int i, PluginValueSet pluginValueSet, String str) {
        c(i, pluginValueSet, null);
        this.n = str;
    }

    private void c(int i, PluginValueSet pluginValueSet, ve veVar) {
        this.c = new n(i, pluginValueSet);
        this.ve = new c();
    }

    @Override // com.byazt.ll.uj
    public void a(int i) {
        uj ujVar = this.c;
        if (ujVar != null) {
            ujVar.a(i);
        }
    }

    public long aw() {
        com.byazt.nbs.tt ttVar = this.tt;
        if (ttVar != null) {
            return ttVar.h();
        }
        return 0L;
    }

    public int bm() {
        com.byazt.nbs.tt ttVar = this.tt;
        if (ttVar != null) {
            return ttVar.pu();
        }
        return 0;
    }

    @Override // com.byazt.ll.uj
    public String bx() {
        uj ujVar = this.c;
        if (ujVar != null) {
            return ujVar.bx();
        }
        return null;
    }

    @Override // com.byazt.ll.uj
    public Map<String, Object> cu() {
        uj ujVar = this.c;
        return ujVar != null ? ujVar.cu() : new ConcurrentHashMap();
    }

    @Override // com.byazt.ll.uj
    public int d() {
        uj ujVar = this.c;
        if (ujVar != null) {
            return ujVar.d();
        }
        return 0;
    }

    @Override // com.byazt.ll.ve
    public String da() {
        ve veVar = this.ve;
        if (veVar != null) {
            return veVar.da();
        }
        return null;
    }

    @Override // com.byazt.ll.uj
    public boolean eo() {
        uj ujVar = this.c;
        if (ujVar != null) {
            return ujVar.eo();
        }
        return false;
    }

    @Override // com.byazt.ll.uj
    public int gr() {
        uj ujVar;
        if (5 != my() && 9 != my()) {
            return 1;
        }
        com.byazt.nbs.tt ttVar = this.tt;
        int iGt = ttVar != null ? ttVar.gt() : 0;
        if (iGt == 0 && (ujVar = this.c) != null) {
            iGt = ujVar.gr();
        }
        if (iGt <= 0) {
            return 1;
        }
        if (iGt >= 3) {
            return 3;
        }
        return iGt;
    }

    @Override // com.byazt.ll.uj
    public String gt() {
        uj ujVar = this.c;
        return ujVar != null ? ujVar.gt() : "";
    }

    @Override // com.byazt.ll.uj
    public int gu() {
        uj ujVar = this.c;
        if (ujVar != null) {
            return ujVar.gu();
        }
        return 0;
    }

    @Override // com.byazt.ll.uj
    public String h() {
        uj ujVar = this.c;
        return ujVar != null ? ujVar.h() : "";
    }

    public double hd() {
        com.byazt.nbs.tt ttVar = this.tt;
        return ttVar != null ? ttVar.rl() : AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    @Override // com.byazt.ll.ve
    public JSONObject i() {
        ve veVar = this.ve;
        if (veVar != null) {
            return veVar.i();
        }
        return null;
    }

    public String ic() {
        com.byazt.nbs.tt ttVar = this.tt;
        return ttVar != null ? ttVar.cu() : "";
    }

    public boolean kp() {
        return this.uj;
    }

    public String l() {
        com.byazt.nbs.tt ttVar = this.tt;
        return ttVar != null ? ttVar.lo() : "";
    }

    public int lo() {
        com.byazt.nbs.tt ttVar = this.tt;
        if (ttVar != null) {
            return ttVar.d();
        }
        return 0;
    }

    public int lr() {
        com.byazt.nbs.tt ttVar = this.tt;
        if (ttVar != null) {
            return ttVar.lt();
        }
        return 0;
    }

    public String lt() {
        com.byazt.nbs.tt ttVar = this.tt;
        return ttVar != null ? ttVar.qy() : "";
    }

    @Override // com.byazt.ll.uj
    public int m() {
        uj ujVar = this.c;
        if (ujVar != null) {
            return ujVar.m();
        }
        return -1;
    }

    @Override // com.byazt.ll.uj
    public String md() {
        uj ujVar = this.c;
        return ujVar != null ? ujVar.md() : "";
    }

    @Override // com.byazt.ll.uj
    public int my() {
        uj ujVar = this.c;
        if (ujVar != null) {
            return ujVar.my();
        }
        return 0;
    }

    @Override // com.byazt.ll.ve
    public void n(int i) {
        ve veVar = this.ve;
        if (veVar != null) {
            veVar.n(i);
        }
    }

    @Override // com.byazt.ll.uj
    public Map<String, Object> nb() {
        uj ujVar = this.c;
        if (ujVar != null) {
            return ujVar.nb();
        }
        return null;
    }

    @Override // com.byazt.ll.uj
    public boolean nu() {
        uj ujVar = this.c;
        if (ujVar != null) {
            return ujVar.nu();
        }
        return false;
    }

    @Override // com.byazt.ll.uj
    public boolean or() {
        uj ujVar = this.c;
        if (ujVar != null) {
            return ujVar.or();
        }
        return false;
    }

    @Override // com.byazt.ll.uj
    public int p() {
        uj ujVar = this.c;
        if (ujVar != null) {
            return ujVar.p();
        }
        return 0;
    }

    public com.byazt.nbs.tt pf() {
        return this.tt;
    }

    public String pu() {
        com.byazt.nbs.tt ttVar = this.tt;
        return ttVar != null ? ttVar.eo() : "";
    }

    @Override // com.byazt.ll.uj
    public SparseArray<Object> qp() {
        uj ujVar = this.c;
        return ujVar != null ? ujVar.qp() : com.byazt.rl.c.c.sparseArray();
    }

    @Override // com.byazt.ll.uj
    public int qy() {
        uj ujVar = this.c;
        if (ujVar != null) {
            return ujVar.qy();
        }
        return 0;
    }

    @Override // com.byazt.ll.uj
    public com.byazt.ch.c rh() {
        uj ujVar = this.c;
        if (ujVar != null) {
            return ujVar.rh();
        }
        return null;
    }

    @Override // com.byazt.ll.uj
    public String rl() {
        uj ujVar = this.c;
        return ujVar != null ? ujVar.rl() : "";
    }

    public ve sl() {
        return this.ve;
    }

    @Override // com.byazt.ll.uj
    public void sp(int i) {
        uj ujVar = this.c;
        if (ujVar != null) {
            ujVar.sp(i);
        }
    }

    @Override // com.byazt.ll.uj
    public boolean sv() {
        uj ujVar = this.c;
        if (ujVar != null) {
            return ujVar.sv();
        }
        return false;
    }

    public String t() {
        return this.n;
    }

    public boolean tk() {
        int iMy = my();
        Map<String, Object> mapCu = cu();
        if (mapCu == null) {
            return false;
        }
        Object obj = mapCu.get("use_share_cache");
        return (obj instanceof Boolean) && (iMy == 1 || iMy == 5 || iMy == 10 || iMy == 7) && ((Boolean) obj).booleanValue();
    }

    public int to() {
        com.byazt.nbs.tt ttVar = this.tt;
        if (ttVar != null) {
            return ttVar.c();
        }
        return 0;
    }

    @Override // com.byazt.ll.ve
    public int tt() {
        ve veVar = this.ve;
        if (veVar != null) {
            return veVar.tt();
        }
        return 0;
    }

    @Override // com.byazt.ll.uj
    public float u() {
        uj ujVar = this.c;
        if (ujVar != null) {
            return ujVar.u();
        }
        return 0.0f;
    }

    @Override // com.byazt.ll.uj
    public void uj(String str) {
        uj ujVar = this.c;
        if (ujVar != null) {
            ujVar.uj(str);
        }
    }

    @Override // com.byazt.ll.ve
    public void ve(String str) {
        ve veVar = this.ve;
        if (veVar != null) {
            veVar.ve(str);
        }
    }

    @Override // com.byazt.ll.ve
    public int x() {
        ve veVar = this.ve;
        if (veVar != null) {
            return veVar.x();
        }
        return 0;
    }

    @Override // com.byazt.ll.uj
    public float yp() {
        uj ujVar = this.c;
        if (ujVar != null) {
            return ujVar.yp();
        }
        return 0.0f;
    }

    @Override // com.byazt.ll.uj
    public String yv() {
        uj ujVar = this.c;
        return ujVar != null ? ujVar.yv() : "";
    }

    @Override // com.byazt.ll.uj
    public boolean z() {
        uj ujVar = this.c;
        if (ujVar != null) {
            return ujVar.z();
        }
        return false;
    }

    @Override // com.byazt.ll.uj
    public String zb() {
        uj ujVar = this.c;
        return ujVar != null ? ujVar.zb() : "";
    }

    @Override // com.byazt.ll.uj
    public boolean zm() {
        uj ujVar = this.c;
        if (ujVar != null) {
            return ujVar.zm();
        }
        return false;
    }

    @Override // com.byazt.ll.ve
    public String a() {
        ve veVar = this.ve;
        return veVar != null ? veVar.a() : "";
    }

    @Override // com.byazt.ll.ve
    public void c(JSONObject jSONObject) {
        ve veVar = this.ve;
        if (veVar != null) {
            veVar.c(jSONObject);
        }
    }

    @Override // com.byazt.ll.ve
    public int n() {
        ve veVar = this.ve;
        if (veVar != null) {
            return veVar.n();
        }
        return 0;
    }

    @Override // com.byazt.ll.ve
    public boolean sp() {
        ve veVar = this.ve;
        if (veVar != null) {
            return veVar.sp();
        }
        return false;
    }

    @Override // com.byazt.ll.ve
    public void tt(int i) {
        ve veVar = this.ve;
        if (veVar != null) {
            veVar.tt(i);
        }
    }

    @Override // com.byazt.ll.ve
    public int uj() {
        ve veVar = this.ve;
        if (veVar != null) {
            return veVar.uj();
        }
        return 0;
    }

    @Override // com.byazt.ll.ve
    public int ve() {
        ve veVar = this.ve;
        if (veVar != null) {
            return veVar.ve();
        }
        return 0;
    }

    public tt(tt ttVar) {
        if (ttVar != null) {
            c(ttVar.my(), com.byazt.rl.c.c(ttVar.qp()).tt(), ttVar.sl());
            this.n = ttVar.t();
        }
    }

    public void c(com.byazt.nbs.tt ttVar) {
        this.tt = ttVar;
    }

    @Override // com.byazt.ll.ve
    public void tt(String str) {
        ve veVar = this.ve;
        if (veVar != null) {
            veVar.tt(str);
        }
    }

    @Override // com.byazt.ll.ve
    public void uj(int i) {
        ve veVar = this.ve;
        if (veVar != null) {
            veVar.uj(i);
        }
    }

    @Override // com.byazt.ll.ve
    public void ve(int i) {
        ve veVar = this.ve;
        if (veVar != null) {
            veVar.ve(i);
        }
    }

    @Override // com.byazt.ll.ve
    public String c() {
        ve veVar = this.ve;
        return veVar != null ? veVar.c() : "";
    }

    @Override // com.byazt.ll.ve
    public void c(String str) {
        ve veVar = this.ve;
        if (veVar != null) {
            veVar.c(str);
        }
    }

    @Override // com.byazt.ll.ve
    public void c(int i) {
        ve veVar = this.ve;
        if (veVar != null) {
            veVar.c(i);
        }
    }

    public void c(PluginValueSet pluginValueSet) {
        if (this.c == null || pluginValueSet == null) {
            return;
        }
        this.c = new n(my(), pluginValueSet);
    }

    public void c(boolean z) {
        this.uj = z;
    }
}
