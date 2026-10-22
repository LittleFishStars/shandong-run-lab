package com.byazt.cq;

import android.net.Uri;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import com.byazt.nd.a;
import com.byazt.nd.n;
import com.byazt.nd.uj;
import com.zj.adlib.u15;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 2016, 20})
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public uj f28371a;
    public JSONObject c;
    public boolean da;
    public Map<String, Object> i;
    public String n;
    public int sl;
    public uj sp;
    public com.byazt.nd.tt t;
    public Map<String, Object> tt;
    public String uj;
    public com.byazt.bh.c ve;
    public String x;

    public c(com.byazt.bh.c cVar, JSONObject jSONObject, Map<String, Object> map) {
        this.sl = 1;
        this.ve = cVar;
        this.c = jSONObject;
        this.tt = map;
    }

    private void da() {
        a aVarTt;
        a aVarTt2;
        uj ujVar = this.f28371a;
        if (ujVar != null && (aVarTt2 = ujVar.tt()) != null) {
            aVarTt2.c(this.c, this);
        }
        uj ujVar2 = this.sp;
        if (ujVar2 == null || (aVarTt = ujVar2.tt()) == null) {
            return;
        }
        aVarTt.c(this.c, this);
    }

    private void i() {
        if (this.sl != 2) {
            com.byazt.bh.c cVar = this.ve;
            if (cVar == null) {
                return;
            } else {
                this.x = cVar.tt();
            }
        }
        if (!TextUtils.isEmpty(this.x)) {
            this.uj = Uri.parse(this.x).getHost();
        }
        if (!TextUtils.isEmpty(this.uj)) {
            String str = this.uj.split(WVNativeCallbackUtil.SEPERATER)[0];
            this.uj = str;
            int iIndexOf = str.indexOf(u15.f19942b);
            if (iIndexOf == -1) {
                iIndexOf = this.uj.length();
            }
            this.uj = this.uj.substring(0, iIndexOf);
        }
        tt(this.x);
    }

    private void sl() {
        a aVarTt;
        a aVarTt2;
        uj ujVar = this.f28371a;
        if (ujVar != null && (aVarTt2 = ujVar.tt()) != null) {
            aVarTt2.c(this.tt, this);
        }
        uj ujVar2 = this.sp;
        if (ujVar2 == null || (aVarTt = ujVar2.tt()) == null) {
            return;
        }
        aVarTt.c(this.tt, this);
    }

    public boolean a() {
        return this.da;
    }

    public Map<String, Object> c() {
        return this.tt;
    }

    public uj n() {
        return this.f28371a;
    }

    public void sp() {
        i();
        sl();
        com.byazt.nd.tt ttVar = this.t;
        if (ttVar != null) {
            ttVar.c();
        } else {
            com.byazt.sxv.c.c().c(this.uj, this, new com.byazt.nd.c() { // from class: com.byazt.cq.c.1
            });
        }
    }

    public Map<String, Object> tt() {
        return this.i;
    }

    public String uj() {
        return this.n;
    }

    public JSONObject ve() {
        return this.c;
    }

    public com.byazt.bh.c x() {
        return this.ve;
    }

    private void tt(String str) {
        ve(str);
        JSONObject jSONObjectC = com.byazt.ek.tt.c(str);
        if (jSONObjectC == null) {
            return;
        }
        da();
        Iterator<String> itKeys = jSONObjectC.keys();
        this.i = new HashMap();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!TextUtils.isEmpty(next)) {
                Object objOpt = jSONObjectC.opt(next);
                if (objOpt instanceof String) {
                    objOpt = c((String) objOpt, this.c);
                }
                this.i.put(next, objOpt);
            }
        }
    }

    private void ve(String str) {
        a aVarTt;
        a aVarTt2;
        uj ujVar = this.f28371a;
        if (ujVar != null && (aVarTt2 = ujVar.tt()) != null) {
            aVarTt2.c(str, this);
        }
        uj ujVar2 = this.sp;
        if (ujVar2 == null || (aVarTt = ujVar2.tt()) == null) {
            return;
        }
        aVarTt.c(str, this);
    }

    public void c(String str) {
        this.n = str;
    }

    public void c(uj ujVar) {
        if (ujVar instanceof tt) {
            this.f28371a = ujVar;
        } else {
            this.sp = ujVar;
        }
    }

    public c(String str, int i, JSONObject jSONObject, Map<String, Object> map) {
        this.sl = 1;
        if (i == 2) {
            this.x = str;
        } else if (i == 3) {
            this.uj = str;
        }
        this.sl = i;
        this.c = jSONObject;
        this.tt = map;
    }

    public void c(boolean z) {
        this.da = z;
    }

    private static Object c(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str) || jSONObject == null) {
            return str;
        }
        try {
            return (str.startsWith("${") && str.endsWith("}")) ? com.byazt.kx.c.c(str.substring(2, str.length() - 1)).c(jSONObject) : str;
        } catch (Throwable unused) {
            return str;
        }
    }

    public void c(com.byazt.nd.tt ttVar) {
        this.t = ttVar;
    }

    public void c(Map<String, Object> map) {
        n nVarVe;
        n nVarVe2;
        da();
        uj ujVar = this.f28371a;
        if (ujVar != null && (nVarVe2 = ujVar.ve()) != null) {
            nVarVe2.c(this, map);
        }
        uj ujVar2 = this.sp;
        if (ujVar2 == null || (nVarVe = ujVar2.ve()) == null) {
            return;
        }
        nVarVe.c(this, map);
    }

    public void tt(Map<String, Object> map) {
        n nVarVe;
        n nVarVe2;
        da();
        uj ujVar = this.sp;
        if (ujVar != null && (nVarVe2 = ujVar.ve()) != null) {
            nVarVe2.c(this, map);
        }
        uj ujVar2 = this.f28371a;
        if (ujVar2 == null || (nVarVe = ujVar2.ve()) == null) {
            return;
        }
        nVarVe.c(this, map);
    }

    public void c(Map<String, Object> map, com.byazt.qb.c cVar) {
        n nVarVe;
        n nVarVe2;
        da();
        uj ujVar = this.f28371a;
        if (ujVar != null && (nVarVe2 = ujVar.ve()) != null) {
            nVarVe2.c(this, this.tt, cVar);
        }
        uj ujVar2 = this.sp;
        if (ujVar2 == null || (nVarVe = ujVar2.ve()) == null) {
            return;
        }
        nVarVe.c(this, map, cVar);
    }

    public void tt(Map<String, Object> map, com.byazt.qb.c cVar) {
        n nVarVe;
        n nVarVe2;
        da();
        uj ujVar = this.sp;
        if (ujVar != null && (nVarVe2 = ujVar.ve()) != null) {
            nVarVe2.c(this, map, cVar);
        }
        uj ujVar2 = this.f28371a;
        if (ujVar2 == null || (nVarVe = ujVar2.ve()) == null) {
            return;
        }
        nVarVe.c(this, map, cVar);
    }
}
