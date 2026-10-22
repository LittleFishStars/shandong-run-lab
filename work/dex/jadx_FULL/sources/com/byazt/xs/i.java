package com.byazt.xs;

import com.byazt.sz.m;
import com.byazt.sz.rh;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 468, 42})
public class i extends com.byazt.lv.tt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile c f29191a;

    @com.byazt.zqa.c(c = {0, 1, 468, 64})
    public class c implements com.byazt.nd.tt {
        public rh.c c;
        public rh.tt uj;
        public m ve;

        public c() {
        }

        public void c(m mVar) {
            this.ve = mVar;
        }

        public void c(rh.tt ttVar) {
            this.uj = ttVar;
        }

        public void c(rh.c cVar) {
            this.c = cVar;
        }

        @Override // com.byazt.nd.tt
        public void c() {
            i.this.tt(this.ve, this.uj, this.c);
        }
    }

    public i(rh rhVar) {
        super(rhVar);
    }

    private c tt() {
        if (this.f29191a != null) {
            return this.f29191a;
        }
        synchronized (c.class) {
            if (this.f29191a != null) {
                return this.f29191a;
            }
            this.f29191a = new c();
            return this.f29191a;
        }
    }

    @Override // com.byazt.lv.tt
    public void ve(m mVar, rh.tt ttVar, rh.c cVar) {
        if (this.f29191a == null) {
            this.f29191a = tt();
        }
        this.f29191a.c(mVar);
        this.f29191a.c(ttVar);
        this.f29191a.c(cVar);
        JSONObject jSONObjectVe = mVar.ve();
        if (jSONObjectVe == null) {
            return;
        }
        com.byazt.ppf.ve.c(jSONObjectVe.optString("type"), (JSONObject) null, (Map<String, Object>) null, new com.byazt.nd.ve() { // from class: com.byazt.xs.i.1
            @Override // com.byazt.nd.ve
            public void c(com.byazt.cq.c cVar2) {
                i.this.c(cVar2);
            }

            @Override // com.byazt.nd.ve
            public void c(com.byazt.cq.tt ttVar2) {
            }
        }, this.uj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.byazt.cq.c cVar) {
        if (this.n) {
            return;
        }
        c cVarTt = tt();
        cVarTt.c(c(cVarTt.ve, cVar));
        cVar.c(cVarTt);
    }

    public m c(m mVar, com.byazt.cq.c cVar) {
        com.byazt.bh.c cVar2;
        if (mVar == null || cVar == null) {
            return mVar;
        }
        m mVar2 = new m();
        com.byazt.xj.ve veVarC = mVar.c();
        if (veVarC == null) {
            return mVar;
        }
        mVar2.c(mVar.tt());
        com.byazt.bh.c cVarX = cVar.x();
        JSONObject jSONObjectC = c(veVarC, mVar2, cVarX);
        com.byazt.bh.ve veVarC2 = com.byazt.bh.tt.INSTANCE.c(cVar.uj());
        List<com.byazt.bh.c> listC = veVarC2.c(cVarX, veVarC.da(), new HashMap());
        mVar2.c(jSONObjectC);
        if (!listC.isEmpty()) {
            com.byazt.bh.c cVar3 = listC.get(0);
            if (cVar3 == null) {
                return mVar2;
            }
            m mVar3 = new m();
            mVar3.c(c(veVarC, mVar3, cVar3));
            mVar3.c(veVarC);
            mVar2.c(mVar3);
        }
        List<com.byazt.bh.c> listTt = veVarC2.tt(cVarX, veVarC.da(), new HashMap());
        if (listTt.isEmpty() || (cVar2 = listTt.get(0)) == null) {
            return mVar2;
        }
        m mVar4 = new m();
        mVar4.c(c(veVarC, mVar4, cVar2));
        mVar4.c(veVarC);
        mVar2.tt(mVar4);
        return mVar2;
    }

    private JSONObject c(com.byazt.xj.ve veVar, m mVar, com.byazt.bh.c cVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (cVar == null) {
                return jSONObject;
            }
            Map<String, String> mapA = cVar.a();
            String strC = cVar.c();
            mVar.c(veVar);
            jSONObject.put("type", strC);
            if (mapA != null && !mapA.isEmpty()) {
                for (Map.Entry<String, String> entry : mapA.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            }
            return jSONObject;
        } catch (JSONException unused) {
            return new JSONObject();
        }
    }
}
