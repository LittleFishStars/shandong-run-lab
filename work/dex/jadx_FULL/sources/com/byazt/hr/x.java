package com.byazt.hr;

import com.ali.auth.third.login.LoginConstants;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 29, 71})
public class x {
    public static final String c = "TTMediationSDK_" + x.class.getSimpleName();
    public Map<String, sp> tt;
    public com.byazt.jd.c<sp> ve;

    @com.byazt.zqa.c(c = {0, 1, 29, 62})
    public static class c {
        public static x c = new x();
    }

    public static x c() {
        return c.c;
    }

    public sp tt(String str) {
        if (this.ve != null) {
            Map<String, sp> map = this.tt;
            sp spVar = map != null ? map.get(str) : null;
            if (spVar != null) {
                return spVar;
            }
            sp spVarQuery = this.ve.query(str);
            if (spVarQuery != null) {
                Map<String, sp> map2 = this.tt;
                if (map2 != null) {
                    map2.put(spVarQuery.uj(), spVarQuery);
                }
                return spVarQuery;
            }
        }
        return null;
    }

    private x() {
        this.ve = new com.byazt.jd.tt(com.byazt.bp.tt.getContext());
        this.tt = new ConcurrentHashMap();
    }

    public void c(String str) {
        if (this.ve != null) {
            Map<String, sp> map = this.tt;
            if (map != null) {
                map.remove(str);
            }
            this.ve.delete(str);
        }
    }

    public void c(String str, String str2) {
        if (this.ve != null) {
            Map<String, sp> map = this.tt;
            if (map != null) {
                map.remove(str + LoginConstants.UNDER_LINE + str2);
            }
            this.ve.delete(str, str2);
        }
    }

    public sp tt(String str, String str2) {
        sp spVar;
        if (this.ve != null) {
            Map<String, sp> map = this.tt;
            if (map != null) {
                spVar = map.get(str + LoginConstants.UNDER_LINE + str2);
            } else {
                spVar = null;
            }
            if (spVar != null) {
                return spVar;
            }
            sp spVarQuery = this.ve.query(str, str2);
            if (spVarQuery != null) {
                Map<String, sp> map2 = this.tt;
                if (map2 != null) {
                    map2.put(spVarQuery.uj(), spVarQuery);
                }
                return spVarQuery;
            }
        }
        return null;
    }

    public void c(sp spVar) {
        sp spVarTt;
        n nVar;
        if (spVar.c()) {
            spVarTt = tt(spVar.tt(), spVar.ve());
        } else {
            spVarTt = tt(spVar.tt());
        }
        if (spVarTt == null) {
            if (this.ve != null) {
                Map<String, sp> map = this.tt;
                if (map != null) {
                    map.put(spVar.uj(), spVar);
                }
                this.ve.tt(spVar);
                return;
            }
            return;
        }
        HashMap map2 = new HashMap();
        for (n nVar2 : spVarTt.sl()) {
            map2.put(nVar2.ve(), nVar2);
        }
        for (n nVar3 : spVar.sl()) {
            if (map2.containsKey(nVar3.ve()) && (nVar = (n) map2.get(nVar3.ve())) != null) {
                nVar3.c(nVar);
            }
        }
        Map<String, sp> map3 = this.tt;
        if (map3 != null) {
            map3.put(spVar.uj(), spVar);
        }
        tt(spVar);
    }

    public void tt(sp spVar) {
        if (this.ve != null) {
            Map<String, sp> map = this.tt;
            if (map != null) {
                map.put(spVar.uj(), spVar);
            }
            this.ve.c(spVar);
        }
    }

    public void c(sp spVar, String str, int i) {
        if (this.ve != null) {
            spVar.c(str, i);
            Map<String, sp> map = this.tt;
            if (map != null) {
                map.put(spVar.uj(), spVar);
            }
            this.ve.c(spVar);
        }
    }

    public void c(sp spVar, String str, long j) {
        if (this.ve != null) {
            spVar.c(str, j);
            Map<String, sp> map = this.tt;
            if (map != null) {
                map.put(spVar.uj(), spVar);
            }
            this.ve.c(spVar);
        }
    }
}
