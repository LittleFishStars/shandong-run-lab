package com.byazt.ng;

import android.content.Context;
import android.content.Intent;
import com.byazt.nr.m;
import com.byazt.vx.eo;
import com.byazt.vx.gr;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_INTERRUPT, 54})
public class ve {
    public static volatile boolean c = false;
    public static final AtomicLong tt = new AtomicLong(0);
    public static long ve;

    public static void c() {
        c = true;
    }

    private static void n() {
        if (com.byazt.bp.tt.getContext() != null) {
            try {
                Intent intent = new Intent();
                intent.setPackage(eo.c());
                intent.setAction("com.bytedance.msdk.sdkinit.EventMultiFlushReceiver");
                intent.putExtra("b_msg_id", 1);
                com.byazt.bp.tt.getContext().sendBroadcast(intent, com.byazt.sx.ve.tt.c);
            } catch (Throwable th) {
                m.c(th);
            }
        }
    }

    public static boolean tt() {
        return c;
    }

    public static void uj() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - ve < 3000) {
            com.byazt.eu.tt.tt(MediationConstant.TAG, "badkground too frequently ms: " + (jCurrentTimeMillis - ve));
        } else if (tt()) {
            ve = jCurrentTimeMillis;
            if (gr.c(com.byazt.bp.tt.getContext())) {
                ve();
            } else {
                n();
            }
        }
    }

    public static void ve() {
        com.byazt.epi.c.ve("csj_mediation");
    }

    public static void c(Context context, JSONObject jSONObject) {
        int iQp = com.byazt.bp.tt.tt().qp();
        com.byazt.tjo.a.c(jSONObject, "s-adlog_pre");
        com.byazt.epi.c.c(new com.byazt.vb.c.C0555c().c(new i()).tt(com.byazt.rz.c.c(iQp, iQp, 172800000L)).tt(com.byazt.bp.c.t().yp()).c(new da()).c(sl.c).c("csj_mediation").c(context).tt(com.byazt.xo.c.n()).c());
        com.byazt.epi.c.c("csj_mediation", true);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0067 A[Catch: JSONException -> 0x006e, TRY_LEAVE, TryCatch #0 {JSONException -> 0x006e, blocks: (B:10:0x001a, B:11:0x0022, B:13:0x0028, B:14:0x003c, B:16:0x0067), top: B:26:0x001a }] */
    public static void c(Context context, uj ujVar, Map<String, Object> map) {
        if (com.byazt.bp.tt.tt().gu()) {
            Context context2 = context == null ? com.byazt.bp.tt.getContext() : context;
            JSONObject jSONObject = new JSONObject();
            if (map != null) {
                try {
                    for (Map.Entry<String, Object> entry : map.entrySet()) {
                        jSONObject.put(entry.getKey(), entry.getValue());
                    }
                    jSONObject.put("eventIndex", tt.getAndIncrement());
                    jSONObject.put("is_main_process", gr.c(context));
                    jSONObject.put("is_cypher_v4", com.byazt.bp.tt.c().c());
                    if (com.byazt.bp.c.t().i()) {
                        jSONObject.put("e2e_test_flag", "1");
                    }
                } catch (JSONException unused) {
                }
            } else {
                jSONObject.put("eventIndex", tt.getAndIncrement());
                jSONObject.put("is_main_process", gr.c(context));
                jSONObject.put("is_cypher_v4", com.byazt.bp.tt.c().c());
                if (com.byazt.bp.c.t().i()) {
                    jSONObject.put("e2e_test_flag", "1");
                }
            }
            if (ujVar != null) {
                ujVar.c("event_id", UUID.randomUUID().toString());
            }
            if (!c) {
                tt.c().c(ujVar, jSONObject);
            } else {
                c(context2, ujVar, c.c(ujVar, jSONObject));
            }
        }
    }

    public static void c(Context context) {
        try {
            List<tt.c> listTt = tt.c().tt();
            if (listTt != null) {
                for (tt.c cVar : listTt) {
                    if (cVar != null) {
                        c(context, cVar.c(), cVar.tt());
                    }
                }
            }
            tt.c().ve();
        } catch (Throwable th) {
            m.c(th);
        }
    }

    private static void c(Context context, uj ujVar, JSONObject jSONObject) {
        if (com.byazt.epi.c.c("csj_mediation")) {
            c(context, null);
        }
        sp spVarC = sp.c(context, ujVar, jSONObject);
        com.byazt.jj.ve.c(spVarC, true);
        com.byazt.fo.c cVar = new com.byazt.fo.c(spVarC.c, spVarC);
        cVar.c((byte) 3);
        cVar.tt((byte) 2);
        com.byazt.epi.c.c(cVar, "csj_mediation");
    }
}
