package com.byazt.nt;

import android.content.Context;
import android.text.TextUtils;
import com.ali.auth.third.login.LoginConstants;
import com.byazt.aas.nb;
import com.byazt.ete.a;
import com.byazt.ete.gt;
import com.byazt.ete.hq;
import com.byazt.ete.ic;
import com.byazt.ete.nu;
import com.byazt.ete.zb;
import com.byazt.nr.m;
import com.byazt.wz.sp;
import com.byazt.wz.x;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1392, 13})
public class tt implements uj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.byazt.pop.c f28851a;
    public final ic c;
    public final ve tt;
    public boolean ve;
    public final Map<String, com.byazt.pop.ve> uj = new HashMap();
    public boolean n = true;
    public boolean sp = false;
    public boolean x = false;

    private tt(ve veVar, ic icVar, boolean z) {
        this.tt = veVar;
        this.c = icVar;
        this.ve = z;
    }

    @Override // com.byazt.nt.uj
    public void ve() {
        tt();
        for (com.byazt.pop.ve veVar : this.uj.values()) {
            if (veVar != null) {
                veVar.ve();
            }
        }
        this.uj.clear();
    }

    public static tt c(ve veVar, ic icVar, boolean z) {
        return new tt(veVar, icVar, z);
    }

    @Override // com.byazt.nt.uj
    public void tt() {
        Iterator<com.byazt.pop.ve> it = this.uj.values().iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    @Override // com.byazt.nt.uj
    public void c() {
        for (com.byazt.pop.ve veVar : this.uj.values()) {
            if (veVar != null) {
                veVar.tt();
            }
        }
    }

    @Override // com.byazt.nt.uj
    public void tt(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null || this.tt == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("data")) == null) {
            return;
        }
        com.byazt.pop.ve veVar = this.uj.get(c(this.c, jSONObjectOptJSONObject, (String) null).z().tt());
        if (veVar != null) {
            veVar.n();
        }
    }

    public static ic c(ic icVar, JSONObject jSONObject, String str) {
        String strOptString;
        boolean z;
        ic icVarC;
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        if (jSONObject != null) {
            strOptString = jSONObject.optString("download_url");
            z = true;
        } else {
            strOptString = "";
            z = false;
        }
        if (TextUtils.isEmpty(strOptString)) {
            z = false;
        }
        boolean z2 = (icVar.z() == null || icVar.z().tt() == null || !icVar.z().tt().equals(strOptString)) ? z : false;
        if (jSONObject != null && (jSONObjectOptJSONObject2 = jSONObject.optJSONObject("download_config_json")) != null && !jSONObjectOptJSONObject2.optBoolean("has_valid_download_url", true)) {
            z2 = true;
        }
        if (z2) {
            icVarC = new ic();
            icVarC.qp(icVar.jl());
            icVarC.a(icVar.eo());
            icVarC.zb(icVar.en());
            icVarC.eo(icVar.st());
            icVarC.zb(jSONObject.optInt("lp_down_rule"));
            icVarC.nb(4);
            icVarC.gu(jSONObject.optString("id"));
            icVarC.m(jSONObject.optString("source"));
            com.byazt.ete.n nVar = new com.byazt.ete.n();
            nVar.uj(jSONObject.optString("pkg_name"));
            nVar.ve(jSONObject.optString("name"));
            nVar.tt(strOptString);
            icVarC.c(nVar);
            JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("download_config_json");
            if (jSONObjectOptJSONObject3 != null) {
                icVarC.c(new gt(jSONObjectOptJSONObject3));
                if (!jSONObjectOptJSONObject3.optBoolean("has_valid_download_url", true)) {
                    icVarC.u(true);
                }
            }
            String strOptString2 = jSONObject.optString("market_url");
            if (!TextUtils.isEmpty(strOptString2)) {
                icVarC.h(strOptString2);
            }
            JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("app_manage_json");
            if (jSONObjectOptJSONObject4 != null) {
                a aVarRh = icVarC.rh();
                if (aVarRh == null) {
                    aVarRh = new a();
                }
                aVarRh.c(jSONObjectOptJSONObject4.optInt("score"));
                aVarRh.c(jSONObjectOptJSONObject4.optJSONArray("creative_tags"));
                icVarC.c(aVarRh);
                icVarC.z(jSONObjectOptJSONObject4.toString());
                zb zbVarTe = icVarC.te();
                if (zbVarTe == null) {
                    zbVarTe = new zb();
                }
                zbVarTe.c(jSONObjectOptJSONObject4.optString("icon_url"));
                icVarC.c(zbVarTe);
                icVarC.rl(jSONObjectOptJSONObject4.optString("desc"));
            }
            JSONObject jSONObjectOptJSONObject5 = jSONObject.optJSONObject("app_manage_type_json");
            if (jSONObjectOptJSONObject5 != null) {
                icVarC.eo(jSONObjectOptJSONObject5.optInt("app_manage_type"));
            }
            int iOptInt = jSONObject.optInt("live_interaction_type");
            String strOptString3 = jSONObject.optString("live_room_id");
            if (iOptInt > 0 && !TextUtils.isEmpty(strOptString3)) {
                icVarC.v(iOptInt);
                icVarC.pf(strOptString3);
            }
            icVarC.tx(jSONObject.optInt("ad_type"));
            hq hqVarC = hq.c(jSONObject.optJSONObject("wc_miniapp_info"));
            if (hqVarC != null) {
                icVarC.c(hqVarC);
            }
            String strOptString4 = jSONObject.optString("quick_app_url");
            if (!TextUtils.isEmpty(strOptString4)) {
                com.byazt.ete.n nVarZ = icVarC.z() != null ? icVarC.z() : new com.byazt.ete.n();
                nVarZ.c(strOptString4);
                icVarC.c(nVarZ);
            }
        } else {
            icVarC = com.byazt.omf.c.c(icVar.yg());
        }
        if (!TextUtils.isEmpty(str)) {
            icVarC.gr(str);
        }
        if (jSONObject != null && (jSONObjectOptJSONObject = jSONObject.optJSONObject("deep_link")) != null) {
            nu nuVar = new nu();
            if (icVar.yp() != null) {
                nuVar.c(icVar.yp());
            }
            nuVar.c(new nu(jSONObjectOptJSONObject));
            icVarC.c(nuVar);
        }
        return icVarC;
    }

    @Override // com.byazt.nt.uj
    public void ve(boolean z) {
        this.x = z;
    }

    @com.byazt.zqa.c(c = {0, 1, 1392, MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY})
    public static class c {
        public static ConcurrentHashMap<String, JSONObject> c = new ConcurrentHashMap<>();

        public static synchronized JSONObject c(String str) {
            if (TextUtils.isEmpty(str)) {
                return new JSONObject();
            }
            ConcurrentHashMap<String, JSONObject> concurrentHashMap = c;
            if (concurrentHashMap == null) {
                return new JSONObject();
            }
            JSONObject jSONObject = concurrentHashMap.get(str);
            if (jSONObject != null) {
                return jSONObject;
            }
            return new JSONObject();
        }

        public static synchronized void c(String str, int i, int i2) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (c == null) {
                c = new ConcurrentHashMap<>();
            }
            JSONObject jSONObject = c.get(str);
            if (jSONObject == null) {
                jSONObject = new JSONObject();
                c.put(str, jSONObject);
            }
            try {
                jSONObject.put("downloadStatus", i);
                jSONObject.put("downloadProcessRate", i2);
                jSONObject.put("code", 0);
                jSONObject.put("codeMsg", "get ad_down_load_id success");
            } catch (Exception e) {
                m.c(e);
            }
        }
    }

    @Override // com.byazt.nt.uj
    public void tt(boolean z) {
        this.sp = z;
    }

    @Override // com.byazt.nt.uj
    public void c(Context context, JSONObject jSONObject, String str, int i, boolean z, boolean z2) {
        JSONObject jSONObjectOptJSONObject;
        if (context == null || jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("data")) == null) {
            return;
        }
        ic icVarC = c(this.c, jSONObjectOptJSONObject, c(jSONObjectOptJSONObject, str));
        c(context, icVarC, jSONObjectOptJSONObject, i, z ? x.c(icVarC) : 0, z2);
    }

    private void c(Context context, ic icVar, JSONObject jSONObject, int i, int i2, boolean z) {
        if (context == null || icVar == null || icVar.z() == null || jSONObject == null || this.tt == null) {
            return;
        }
        com.byazt.pop.ve veVar = this.uj.get(icVar.z().tt());
        if (veVar != null) {
            veVar.c(i2);
            return;
        }
        String strC = nb.c(i);
        if (TextUtils.isEmpty(strC)) {
            return;
        }
        com.byazt.pop.ve veVarC = c(context, icVar, jSONObject, strC);
        veVarC.c(i2);
        if (veVarC instanceof com.byazt.wz.n) {
            ((com.byazt.wz.n) veVarC).a(z);
        }
        this.uj.put(icVar.z().tt(), veVarC);
    }

    @Override // com.byazt.nt.uj
    public void c(Context context, JSONObject jSONObject, String str, String str2) {
        JSONObject jSONObjectOptJSONObject;
        if (context == null || jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("data")) == null) {
            return;
        }
        c(context, c(this.c, jSONObjectOptJSONObject, c(jSONObjectOptJSONObject, str2)), str);
    }

    private String c(JSONObject jSONObject, String str) {
        String strOptString = jSONObject != null ? jSONObject.optString(LoginConstants.EXT) : null;
        return TextUtils.isEmpty(strOptString) ? str : strOptString;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void c(Context context, ic icVar, String str) {
        if (context == 0 || icVar == null) {
            return;
        }
        if (icVar.z() == null) {
            com.byazt.pop.ve veVarTt = com.byazt.yih.x.tt(context, icVar, str);
            if (veVarTt instanceof com.byazt.wz.c) {
                ((com.byazt.wz.c) veVarTt).a(this.ve);
                veVarTt.uj(this.x);
            }
            veVarTt.c(icVar, false);
        } else {
            final String strUj = icVar.uj();
            com.byazt.pop.ve veVar = this.uj.get(icVar.z().tt());
            if (veVar != null) {
                veVar.tt(this.sp);
                veVar.uj(this.x);
                if (veVar instanceof com.byazt.wz.c) {
                    ((com.byazt.wz.c) veVar).x().c(this.n);
                } else if (veVar instanceof sp) {
                    ((sp) veVar).x().c(this.n);
                }
                veVar.c(icVar, false);
                veVar.c(new com.byazt.pop.c() { // from class: com.byazt.nt.tt.1
                    @Override // com.byazt.pop.c
                    public void c() {
                        com.byazt.nt.c.c(strUj);
                    }

                    @Override // com.byazt.pop.c
                    public void tt(long j, long j2, String str2, String str3) {
                        com.byazt.nt.c.tt(strUj, j, j2);
                    }

                    @Override // com.byazt.pop.c
                    public void ve(long j, long j2, String str2, String str3) {
                        com.byazt.nt.c.ve(strUj, j, j2);
                    }

                    @Override // com.byazt.pop.c
                    public void c(long j, long j2, String str2, String str3) {
                        com.byazt.nt.c.c(strUj, j, j2);
                    }

                    @Override // com.byazt.pop.c
                    public void c(long j, String str2, String str3) {
                        com.byazt.nt.c.tt(strUj);
                    }

                    @Override // com.byazt.pop.c
                    public void c(String str2, String str3) {
                        com.byazt.nt.c.ve(strUj);
                    }
                });
            }
        }
        if (context instanceof com.byazt.fh.tt) {
            ((com.byazt.fh.tt) context).c(1);
        }
    }

    @Override // com.byazt.nt.uj
    public void c(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("data")) == null) {
            return;
        }
        c(c(this.c, jSONObjectOptJSONObject, (String) null), jSONObjectOptJSONObject);
    }

    private void c(ic icVar, JSONObject jSONObject) {
        if (this.tt == null || icVar == null || icVar.z() == null) {
            return;
        }
        String strTt = icVar.z().tt();
        if (this.uj.containsKey(strTt)) {
            com.byazt.pop.ve veVarRemove = this.uj.remove(strTt);
            if (veVarRemove != null) {
                try {
                    veVarRemove.ve();
                } catch (JSONException e) {
                    m.c(e);
                    return;
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("message", "success");
            jSONObject2.put("status", "unsubscribed");
            jSONObject2.put("appad", jSONObject);
            this.tt.tt("app_ad_event", jSONObject2);
        }
    }

    @Override // com.byazt.nt.uj
    public void c(boolean z) {
        this.n = z;
    }

    @Override // com.byazt.nt.uj
    public void c(String str, boolean z) {
        com.byazt.pop.ve veVar;
        if (TextUtils.isEmpty(str) || (veVar = this.uj.get(str)) == null) {
            return;
        }
        veVar.c(z);
    }

    private com.byazt.pop.ve c(Context context, ic icVar, final JSONObject jSONObject, String str) {
        com.byazt.pop.ve veVarTt = com.byazt.yih.x.tt(context, icVar, str);
        if (veVarTt instanceof com.byazt.wz.c) {
            ((com.byazt.wz.c) veVarTt).a(this.ve);
        }
        final String strUj = icVar.uj();
        veVarTt.c(new com.byazt.pop.c() { // from class: com.byazt.nt.tt.2
            @Override // com.byazt.pop.c
            public void c() {
                com.byazt.nt.c.c(strUj);
                c("status", "idle");
                if (tt.this.f28851a == null) {
                    return;
                }
                tt.this.f28851a.c();
            }

            @Override // com.byazt.pop.c
            public void tt(long j, long j2, String str2, String str3) {
                com.byazt.nt.c.tt(strUj, j, j2);
                c("status", "download_paused", "total_bytes", String.valueOf(j), "current_bytes", String.valueOf(j2));
                if (tt.this.f28851a == null) {
                    return;
                }
                tt.this.f28851a.tt(j, j2, str2, str3);
            }

            @Override // com.byazt.pop.c
            public void ve(long j, long j2, String str2, String str3) {
                com.byazt.nt.c.ve(strUj, j, j2);
                c("status", "download_failed", "total_bytes", String.valueOf(j), "current_bytes", String.valueOf(j2));
                if (tt.this.f28851a == null) {
                    return;
                }
                tt.this.f28851a.ve(j, j2, str2, str3);
            }

            @Override // com.byazt.pop.c
            public void c(long j, long j2, String str2, String str3) {
                com.byazt.nt.c.c(strUj, j, j2);
                c("status", "download_active", "total_bytes", String.valueOf(j), "current_bytes", String.valueOf(j2));
                if (tt.this.f28851a == null) {
                    return;
                }
                tt.this.f28851a.c(j, j2, str2, str3);
            }

            @Override // com.byazt.pop.c
            public void c(long j, String str2, String str3) {
                com.byazt.nt.c.tt(strUj);
                c("status", "download_finished", "total_bytes", String.valueOf(j), "current_bytes", String.valueOf(j));
                if (tt.this.f28851a == null) {
                    return;
                }
                tt.this.f28851a.c(j, str2, str3);
            }

            @Override // com.byazt.pop.c
            public void c(String str2, String str3) {
                com.byazt.nt.c.ve(strUj);
                c("status", "installed");
                if (tt.this.f28851a == null) {
                    return;
                }
                tt.this.f28851a.c(str2, str3);
            }

            private void c(String... strArr) {
                if (strArr == null || strArr.length % 2 != 0) {
                    return;
                }
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("message", "success");
                    jSONObject2.put("appad", jSONObject);
                    for (int i = 0; i < strArr.length; i += 2) {
                        jSONObject2.put(strArr[i], strArr[i + 1]);
                    }
                    tt.this.tt.tt("app_ad_event", jSONObject2);
                } catch (JSONException unused) {
                }
            }
        });
        return veVarTt;
    }
}
