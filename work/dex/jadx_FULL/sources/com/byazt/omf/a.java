package com.byazt.omf;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.alipay.sdk.m.o.b;
import com.byazt.nys.PluginConstants;
import com.zj.adlib.xh9;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 31, 34})
public class a {
    public volatile String c;
    public String tt;
    public com.byazt.aas.c.tt uj;
    public AtomicBoolean ve;

    @com.byazt.zqa.c(c = {0, 1, 31, 464})
    public static final class c {
        public static final a c = new a();
    }

    private void x() {
        final boolean zSp = x.m().sp();
        boolean zX = x.m().x();
        com.byazt.gj.c.c(zSp && !zX);
        final boolean zDa = x.m().da();
        com.byazt.gj.c.c(new com.byazt.gj.n() { // from class: com.byazt.omf.a.3
            @Override // com.byazt.gj.n
            public void c(com.byazt.gj.n.c cVar) {
                if (cVar != null) {
                    com.byazt.aas.gu.c(cVar.c);
                }
                if (zDa || !zSp || a.this.ve.get()) {
                    return;
                }
                a.this.c(new com.byazt.qh.uj(cVar));
            }
        });
        if (zX) {
            com.byazt.nr.da.c().post(new Runnable() { // from class: com.byazt.omf.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.c(new com.byazt.qh.uj(com.byazt.aas.gu.ve(((com.byazt.dna.ve) com.byazt.ut.uj.getService("embed_applog")).getOAID(false))));
                }
            });
        } else {
            if (zDa || !zSp) {
                return;
            }
            com.byazt.nr.da.c().postDelayed(new Runnable() { // from class: com.byazt.omf.a.5
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.ve.get()) {
                        return;
                    }
                    a.this.c(new com.byazt.qh.uj(b.r0));
                }
            }, 3000L);
        }
    }

    public String a() {
        return "164362";
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String n() {
        return (String) com.byazt.gj.c.c("sdk_version_name", "");
    }

    public String sp() {
        return "unionser_slardar_applog";
    }

    public void tt() {
        com.byazt.gj.c.c(x.m().sp());
        com.byazt.gj.c.c();
    }

    public String uj() {
        if (TextUtils.isEmpty(this.tt)) {
            this.tt = com.byazt.gj.c.sl();
        }
        return this.tt;
    }

    public String ve() {
        if (TextUtils.isEmpty(this.c)) {
            this.c = com.byazt.gj.c.i();
            com.byazt.zlb.ve.ve(16, this.c);
            com.byazt.by.uj.c().da(this.c == null ? "" : this.c);
        }
        return this.c;
    }

    private a() {
        this.c = null;
        this.tt = null;
        this.ve = new AtomicBoolean(false);
        c(gt.getContext());
    }

    private void c(Context context) {
        com.byazt.dj.uj ujVarNu = x.m().nu();
        com.byazt.gj.x xVar = new com.byazt.gj.x("164362", "unionser_slardar_applog");
        if (ujVarNu != null) {
            boolean zIsCanUsePhoneState = ujVarNu.isCanUsePhoneState();
            xVar.uj(zIsCanUsePhoneState);
            if (!zIsCanUsePhoneState) {
                xVar.tt(ujVarNu.getDevImei());
            }
            xVar.ve(ujVarNu.isCanUseWifiState());
            xVar.n(ujVarNu.isCanUseAndroidId());
            if (p.x()) {
                xVar.c(ujVarNu.getAndroidId());
            }
        }
        xVar.a(!com.byazt.xo.c.tt());
        xVar.c(new com.byazt.gj.sp() { // from class: com.byazt.omf.a.1
            @Override // com.byazt.gj.sp
            public String c(Context context2) {
                return com.byazt.nr.gt.tt(context2);
            }

            @Override // com.byazt.gj.sp
            public boolean tt() {
                return com.byazt.aas.u.c();
            }

            @Override // com.byazt.gj.sp
            public Looper uj() {
                return com.byazt.nr.da.c().getLooper();
            }

            @Override // com.byazt.gj.sp
            public Looper ve() {
                return com.byazt.nr.da.c().getLooper();
            }

            @Override // com.byazt.gj.sp
            public boolean c() {
                return gt.tt().pu();
            }

            @Override // com.byazt.gj.sp
            public String c(String str) {
                return com.byazt.aas.zm.c(str);
            }

            @Override // com.byazt.gj.sp
            public JSONObject c(JSONObject jSONObject) {
                if (jSONObject != null) {
                    JSONArray jSONArrayC = com.byazt.aas.my.c(com.byazt.vxy.c.n());
                    try {
                        if (jSONArrayC.length() != 0) {
                            jSONObject.put("ipv6_list", jSONArrayC);
                        }
                    } catch (Exception unused) {
                    }
                }
                return jSONObject;
            }

            @Override // com.byazt.gj.sp
            public void c(String[] strArr, int[] iArr, boolean z) {
                com.byazt.la.c.c().c(iArr);
            }

            @Override // com.byazt.gj.sp
            public void c(JSONObject jSONObject, JSONObject jSONObject2) {
                com.byazt.ukr.yp.c().c(jSONObject, jSONObject2);
            }
        });
        xVar.tt(gt.tt().qp());
        xVar.c(true);
        xVar.tt(0);
        x();
        com.byazt.gj.c.c(context, xVar);
        HashMap map = new HashMap();
        String strRl = x.m().rl();
        map.put("host_appid", TextUtils.isEmpty(strRl) ? "164362" : strRl);
        map.put("is_plugin", Boolean.valueOf(p.c()));
        map.put("sdk_version", "7.6.1.1");
        map.put(PluginConstants.KEY_PLUGIN_VERSION, "7.6.1.1");
        map.put("sdk_api_version", p.n);
        map.put(xh9.WEBSITE_PARAMS_CHANNEL, p.a());
        if (gt.tt().h()) {
            map.put("use_apm_sdk", "1");
        }
        com.byazt.gj.c.c((HashMap<String, Object>) map);
        this.uj = new com.byazt.aas.c.tt() { // from class: com.byazt.omf.a.2
            @Override // com.byazt.aas.c.tt
            public void onAppBackground() {
                com.byazt.gj.c.yp();
            }

            @Override // com.byazt.aas.c.tt
            public void onAppExit() {
            }

            @Override // com.byazt.aas.c.tt
            public void onAppForeground() {
                com.byazt.gj.c.z();
            }

            @Override // com.byazt.aas.c.tt
            public void onAppStart() {
            }
        };
        com.byazt.aas.c cVarVe = x.m().ve();
        if (cVarVe != null) {
            cVarVe.c(this.uj);
        }
    }

    public static void tt(String str, JSONObject jSONObject) {
        com.byazt.gj.c.c(str, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.byazt.qh.uj ujVar) {
        this.ve.set(true);
        com.byazt.aas.gu.c(ujVar);
    }

    public static a c() {
        return c.c;
    }

    public void c(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str) || jSONObject == null) {
            return;
        }
        com.byazt.gj.c.tt(str, jSONObject);
    }
}
