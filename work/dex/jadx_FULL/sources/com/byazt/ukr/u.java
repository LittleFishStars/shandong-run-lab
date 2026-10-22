package com.byazt.ukr;

import android.text.TextUtils;
import com.byazt.aas.nb;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1081, 67})
public class u implements com.byazt.nv.c {
    public static final u c = new u();

    private u() {
    }

    @Override // com.byazt.nv.c
    public void c(final com.byazt.ee.c cVar, final String str, final boolean z) {
        com.byazt.bzd.x.tt(new Runnable() { // from class: com.byazt.ukr.u.1
            @Override // java.lang.Runnable
            public void run() {
                if (n.c(str, 1.0d) || !z) {
                    u.this.c(cVar, z);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.byazt.ee.c cVar, boolean z) {
        JSONObject jSONObject;
        try {
            JSONObject jSONObjectC = cVar.c().c();
            if (jSONObjectC != null) {
                String strOptString = jSONObjectC.optString("event_extra");
                if (TextUtils.isEmpty(strOptString)) {
                    jSONObject = new JSONObject();
                } else {
                    jSONObject = new JSONObject(strOptString);
                }
                int iIncrementAndGet = tt.tt.incrementAndGet();
                jSONObject.put("stats_index", iIncrementAndGet);
                jSONObject.put("sdk_session_id", tt.c);
                jSONObject.put("csj_type", com.byazt.omf.x.m().bx() ? 1 : 0);
                jSONObject.put("create_ts", System.currentTimeMillis());
                if (!TextUtils.isEmpty(nb.i)) {
                    jSONObject.put("wrong_stats_url", nb.i);
                }
                if (!TextUtils.isEmpty(nb.da)) {
                    jSONObject.put("wrong_applog_url", nb.da);
                }
                try {
                    jSONObject.put("device_score", Double.parseDouble(com.byazt.whk.c.c().c("DeviceRate", "bytebench_value", com.byazt.vxy.c.uj())));
                } catch (Exception unused) {
                }
                try {
                    jSONObject.put("abtest_version", com.byazt.omf.x.m().q());
                } catch (Exception unused2) {
                }
                if (com.byazt.omf.x.m().a()) {
                    jSONObject.putOpt("first_of_two", 1);
                }
                jSONObjectC.put("event_extra", jSONObject.toString());
                com.byazt.fo.c cVar2 = new com.byazt.fo.c(UUID.randomUUID().toString(), jSONObjectC);
                cVar2.ve((byte) 0);
                if (tt.uj.get()) {
                    cVar2.tt((byte) 3);
                    cVar2.c((byte) 1);
                } else {
                    cVar2.tt((byte) 2);
                    cVar2.c((byte) 1);
                }
                tt.c(cVar2, jSONObjectC.optString("type"), iIncrementAndGet);
            }
        } catch (Throwable unused3) {
        }
    }
}
