package com.byazt.vvt;

import android.text.TextUtils;
import com.byazt.ete.x;
import com.byazt.ukr.yp;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 210, 34})
public class a {
    public static final Map<String, c> c = new ConcurrentHashMap();

    @com.byazt.zqa.c(c = {0, 1, 210, 464})
    public static class c {
        public final int c;

        public c(x.uj ujVar) {
            this.c = ujVar.sp();
        }

        public int c(int i, x.uj ujVar) {
            int i2 = this.c - i;
            if (i2 < 0) {
                return 0;
            }
            LinkedHashMap<Integer, Integer> linkedHashMapA = ujVar.a();
            int i3 = -1;
            if (linkedHashMapA == null) {
                return -1;
            }
            for (Map.Entry<Integer, Integer> entry : linkedHashMapA.entrySet()) {
                int iIntValue = entry.getKey().intValue();
                if (entry.getValue().intValue() + i2 <= 0 && iIntValue > i3) {
                    i3 = iIntValue;
                }
            }
            return i3;
        }

        public void c(final int i, final com.byazt.dj.tt ttVar, final x.uj ujVar, final String str, final String str2) {
            yp.c().tt(new com.byazt.ee.c() { // from class: com.byazt.vvt.a.c.1
                @Override // com.byazt.ee.c
                public com.byazt.qal.c c() throws Exception {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.putOpt("slot_type", Integer.valueOf(i));
                    jSONObject.putOpt("rit", ttVar.uj());
                    jSONObject.putOpt(MediationConstant.KEY_REASON, str);
                    jSONObject.putOpt("reason_value", str2);
                    jSONObject.putOpt("score", Integer.valueOf(c.this.c));
                    jSONObject.putOpt("score_threshold", Integer.valueOf(ujVar.uj()));
                    return com.byazt.qal.tt.tt().c("load_score_cache").tt(jSONObject.toString());
                }
            }, "load_score_cache");
        }
    }

    public static c c(String str, x.uj ujVar) {
        if (TextUtils.isEmpty(str)) {
            return new c(ujVar);
        }
        Map<String, c> map = c;
        c cVar = map.get(str);
        if (cVar != null) {
            return cVar;
        }
        c cVar2 = new c(ujVar);
        map.put(str, cVar2);
        return cVar2;
    }
}
