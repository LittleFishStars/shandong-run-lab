package com.byazt.ll;

import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1360, 46})
public class n implements uj {
    public com.byazt.ch.c c;
    public PluginValueSet n;
    public com.byazt.ch.tt tt;
    public int uj;
    public Map<String, Object> ve;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f28774a = -1;
    public String sp = "";

    public n(int i, PluginValueSet pluginValueSet) {
        if (pluginValueSet == null) {
            com.byazt.eu.tt.tt("AdLinkInfo", "valueset is null");
            return;
        }
        this.n = pluginValueSet;
        this.uj = i;
        com.byazt.ch.c cVar = new com.byazt.ch.c(pluginValueSet.sparseArray(), com.byazt.vxy.c.tt());
        this.c = cVar;
        this.tt = cVar.md();
    }

    @Override // com.byazt.ll.uj
    public void a(int i) {
        this.f28774a = i;
    }

    @Override // com.byazt.ll.uj
    public String bx() {
        com.byazt.ch.c cVar = this.c;
        if (cVar != null) {
            return cVar.h();
        }
        return null;
    }

    @Override // com.byazt.ll.uj
    public Map<String, Object> cu() {
        Map<String, Object> map = this.ve;
        if (map != null) {
            return map;
        }
        if (this.tt != null) {
            this.ve = new ConcurrentHashMap();
            Map<String, Object> mapA = this.tt.a();
            if (mapA != null && mapA.size() > 0) {
                for (Map.Entry<String, Object> entry : mapA.entrySet()) {
                    if (entry.getKey() != null && entry.getValue() != null) {
                        this.ve.put(entry.getKey(), entry.getValue());
                    }
                }
            }
        }
        if (this.ve == null) {
            this.ve = new ConcurrentHashMap();
        }
        return this.ve;
    }

    @Override // com.byazt.ll.uj
    public int d() {
        com.byazt.ch.c cVar = this.c;
        if (cVar != null) {
            return cVar.z();
        }
        return 0;
    }

    @Override // com.byazt.ll.uj
    public boolean eo() {
        com.byazt.ch.tt ttVar = this.tt;
        if (ttVar != null) {
            return ttVar.ve();
        }
        return false;
    }

    @Override // com.byazt.ll.uj
    public int gr() {
        com.byazt.ch.c cVar = this.c;
        if (cVar != null) {
            return cVar.t();
        }
        return 1;
    }

    @Override // com.byazt.ll.uj
    public String gt() {
        if (!TextUtils.isEmpty(this.sp)) {
            return this.sp;
        }
        com.byazt.ch.c cVar = this.c;
        return cVar != null ? cVar.uj() : "";
    }

    @Override // com.byazt.ll.uj
    public int gu() {
        com.byazt.ch.c cVar = this.c;
        if (cVar != null) {
            return cVar.sp();
        }
        return 0;
    }

    @Override // com.byazt.ll.uj
    public String h() {
        com.byazt.ch.c cVar = this.c;
        return cVar != null ? cVar.yp() : "";
    }

    @Override // com.byazt.ll.uj
    public int m() {
        return this.f28774a;
    }

    @Override // com.byazt.ll.uj
    public String md() {
        com.byazt.ch.c cVar = this.c;
        return cVar != null ? cVar.u() : "";
    }

    @Override // com.byazt.ll.uj
    public int my() {
        return this.uj;
    }

    @Override // com.byazt.ll.uj
    public Map<String, Object> nb() {
        com.byazt.ch.c cVar = this.c;
        if (cVar != null) {
            return cVar.d();
        }
        return null;
    }

    @Override // com.byazt.ll.uj
    public boolean nu() {
        com.byazt.ch.tt ttVar = this.tt;
        if (ttVar != null) {
            return ttVar.i();
        }
        return false;
    }

    @Override // com.byazt.ll.uj
    public boolean or() {
        com.byazt.ch.tt ttVar = this.tt;
        if (ttVar != null) {
            return ttVar.sp();
        }
        return false;
    }

    @Override // com.byazt.ll.uj
    public int p() {
        com.byazt.ch.tt ttVar;
        com.byazt.ch.c cVar = this.c;
        int iZm = cVar != null ? cVar.zm() : 0;
        return (iZm != 0 || (ttVar = this.tt) == null) ? iZm : ttVar.z();
    }

    @Override // com.byazt.ll.uj
    public SparseArray<Object> qp() {
        PluginValueSet pluginValueSet = this.n;
        if (pluginValueSet != null) {
            return pluginValueSet.sparseArray();
        }
        return null;
    }

    @Override // com.byazt.ll.uj
    public int qy() {
        com.byazt.ch.c cVar = this.c;
        if (cVar != null) {
            return cVar.a();
        }
        return 0;
    }

    @Override // com.byazt.ll.uj
    public com.byazt.ch.c rh() {
        return this.c;
    }

    @Override // com.byazt.ll.uj
    public String rl() {
        com.byazt.ch.tt ttVar = this.tt;
        return ttVar != null ? ttVar.x() : "";
    }

    @Override // com.byazt.ll.uj
    public void sp(int i) {
        this.uj = i;
    }

    @Override // com.byazt.ll.uj
    public boolean sv() {
        com.byazt.ch.c cVar = this.c;
        if (cVar != null) {
            return cVar.p();
        }
        return false;
    }

    @Override // com.byazt.ll.uj
    public float u() {
        com.byazt.ch.c cVar = this.c;
        if (cVar != null) {
            return cVar.x();
        }
        return 0.0f;
    }

    @Override // com.byazt.ll.uj
    public void uj(String str) {
        this.sp = str;
    }

    @Override // com.byazt.ll.uj
    public float yp() {
        com.byazt.ch.c cVar = this.c;
        if (cVar != null) {
            return cVar.i();
        }
        return 0.0f;
    }

    @Override // com.byazt.ll.uj
    public String yv() {
        com.byazt.ch.tt ttVar;
        com.byazt.ch.c cVar = this.c;
        String strGr = cVar != null ? cVar.gr() : "";
        return (!TextUtils.isEmpty(strGr) || (ttVar = this.tt) == null) ? strGr : ttVar.yp();
    }

    @Override // com.byazt.ll.uj
    public boolean z() {
        com.byazt.ch.c cVar = this.c;
        if (cVar != null) {
            return cVar.sl();
        }
        return false;
    }

    @Override // com.byazt.ll.uj
    public String zb() {
        Map<String, Object> mapA;
        com.byazt.ch.tt ttVar = this.tt;
        if (ttVar == null || (mapA = ttVar.a()) == null) {
            return "";
        }
        Object obj = mapA.get("testToolSlotId");
        return obj instanceof String ? (String) obj : "";
    }

    @Override // com.byazt.ll.uj
    public boolean zm() {
        com.byazt.ch.c cVar = this.c;
        if (cVar != null) {
            return cVar.da();
        }
        return false;
    }
}
