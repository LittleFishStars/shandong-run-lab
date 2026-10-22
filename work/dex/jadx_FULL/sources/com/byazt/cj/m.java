package com.byazt.cj;

import android.text.TextUtils;
import com.byazt.aas.nb;
import com.byazt.ete.ic;
import java.util.HashSet;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.ls.tt
@com.byazt.zqa.c(c = {0, 1, 55, 130})
public class m implements com.byazt.kkb.ve {

    @com.byazt.ls.c(c = "type")
    public String c;

    @com.byazt.ls.c(c = "log_extra")
    public String tt;

    @com.byazt.ls.c(c = "material_meta")
    public ic ve;

    @Override // com.byazt.kkb.ve
    public boolean c(Map<String, Object> map, Map<String, Object> map2, com.byazt.cq.c cVar) {
        if (!c()) {
            com.byazt.nr.m.uj("UChain_ReportStatsAction", "ifHasAllRequiredParam = false");
            cVar.c(map2, (com.byazt.qb.c) null);
            return false;
        }
        final JSONObject jSONObjectC = c(map);
        final int iSl = nb.sl(this.ve);
        com.byazt.ukr.yp.c().tt(new com.byazt.ee.c() { // from class: com.byazt.cj.m.1
            @Override // com.byazt.ee.c
            public com.byazt.qal.c c() throws Exception {
                return com.byazt.qal.tt.tt().c(m.this.c).x(m.this.tt).c(iSl).tt(jSONObjectC.toString());
            }
        }, this.c);
        cVar.c(map2);
        return true;
    }

    private JSONObject c(Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            HashSet hashSet = new HashSet();
            hashSet.add("type");
            hashSet.add("log_extra");
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                if (!hashSet.contains(entry.getKey())) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            }
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    private boolean c() {
        return (TextUtils.isEmpty(this.c) || TextUtils.isEmpty(this.tt)) ? false : true;
    }
}
