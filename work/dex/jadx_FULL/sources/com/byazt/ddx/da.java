package com.byazt.ddx;

import android.text.TextUtils;
import com.baidu.mapapi.SDKInitializer;
import com.byazt.aas.nb;
import com.byazt.ete.ic;
import com.byazt.ete.ma;
import com.byazt.ete.pu;
import com.byazt.nr.m;
import com.byazt.omf.gt;
import com.byazt.ukr.yp;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 483, 72})
public class da implements com.byazt.rbg.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Boolean f28387a;
    public String c;
    public JSONArray da;
    public JSONArray i;
    public volatile boolean m;
    public Boolean n;
    public boolean sl;
    public Boolean sp;
    public int t;
    public String tt;
    public AtomicLong u;
    public JSONObject uj;
    public ic ve;
    public JSONObject x;
    public JSONObject yp;
    public volatile int z;

    public da(String str, ic icVar, JSONObject jSONObject, JSONObject jSONObject2) {
        this.tt = com.byazt.dyf.tt.AD_TAG_FEED;
        Boolean bool = Boolean.FALSE;
        this.n = bool;
        this.f28387a = bool;
        this.sp = bool;
        this.sl = false;
        this.u = new AtomicLong();
        this.z = 0;
        this.m = false;
        this.tt = str;
        this.ve = icVar;
        this.x = jSONObject;
        this.i = new JSONArray();
        this.da = new JSONArray();
        this.uj = jSONObject2;
        this.c = icVar == null ? com.byazt.vxy.c.uj() : icVar.jl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject nu() {
        JSONObject jSONObject = this.uj;
        if (jSONObject != null && jSONObject.has("xSize")) {
            Object objOpt = this.uj.opt("xSize");
            if (objOpt instanceof JSONObject) {
                JSONObject jSONObject2 = (JSONObject) objOpt;
                if (jSONObject2.has("width") && jSONObject2.has("height")) {
                    JSONObject jSONObject3 = new JSONObject();
                    try {
                        jSONObject3.putOpt("width", Double.valueOf(((JSONObject) objOpt).optDouble("width")));
                        jSONObject3.putOpt("height", Double.valueOf(((JSONObject) objOpt).optDouble("height")));
                        return jSONObject3;
                    } catch (Throwable unused) {
                    }
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean rh() {
        if (this.sp.booleanValue()) {
            return true;
        }
        return this.f28387a.booleanValue() && this.n.booleanValue();
    }

    @Override // com.byazt.rbg.c
    public void m() {
        try {
            com.byazt.nr.da.c().post(new Runnable() { // from class: com.byazt.ddx.da.25
                @Override // java.lang.Runnable
                public void run() {
                    if (da.this.rh() && !da.this.sl) {
                        if (da.this.i != null && da.this.i.length() != 0) {
                            try {
                                da.this.x.put("native_switchBackgroundAndForeground", da.this.i);
                            } catch (Exception unused) {
                            }
                        }
                        if (da.this.da != null && da.this.da.length() != 0) {
                            try {
                                da.this.x.put("intercept_source", da.this.da);
                            } catch (Exception unused2) {
                            }
                        }
                        HashMap map = new HashMap();
                        map.put("webview_time_track", da.this.x);
                        com.byazt.omf.x.m().hd();
                        uj.sp(da.this.ve, da.this.tt, "webview_time_track", map);
                        da.this.sl = true;
                    }
                }
            });
        } catch (Throwable th) {
            m.tt("WebviewTimeTrack", th.getMessage());
        }
    }

    public void sl() {
        try {
            com.byazt.nr.da.c().post(new Runnable() { // from class: com.byazt.ddx.da.15
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    da.this.c(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    da.this.c(jSONObject, "type", "native_enterBackground");
                    da daVar = da.this;
                    daVar.c(daVar.i, jSONObject);
                }
            });
        } catch (Throwable th) {
            m.tt("WebviewTimeTrack", th.getMessage());
        }
    }

    public void t() {
        try {
            com.byazt.nr.da.c().post(new Runnable() { // from class: com.byazt.ddx.da.16
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    da.this.c(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    da.this.c(jSONObject, "type", "native_enterForeground");
                    da daVar = da.this;
                    daVar.c(daVar.i, jSONObject);
                }
            });
        } catch (Throwable th) {
            m.tt("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.byazt.yw.tt
    public void u() {
        try {
            com.byazt.nr.da.c().post(new Runnable() { // from class: com.byazt.ddx.da.21
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    da.this.c(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    da daVar = da.this;
                    daVar.c(daVar.x, "no_native_render", jSONObject);
                }
            });
        } catch (Throwable th) {
            m.tt("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.byazt.yw.ve
    public void yp() {
        try {
            com.byazt.nr.da.c().post(new Runnable() { // from class: com.byazt.ddx.da.22
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    da.this.c(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    da daVar = da.this;
                    daVar.c(daVar.x, "render_failed", jSONObject);
                }
            });
        } catch (Throwable th) {
            m.tt("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.byazt.rbg.c
    public void z() {
        this.n = Boolean.TRUE;
    }

    @Override // com.byazt.yw.uj
    public void a() {
        try {
            com.byazt.nr.da.c().post(new Runnable() { // from class: com.byazt.ddx.da.9
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    da.this.c(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    da daVar = da.this;
                    daVar.c(daVar.x, "webview_load_start", (Object) jSONObject, false);
                }
            });
        } catch (Throwable th) {
            m.tt("WebviewTimeTrack", th.getMessage());
        }
    }

    public void da() {
        try {
            com.byazt.nr.da.c().post(new Runnable() { // from class: com.byazt.ddx.da.14
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    da.this.c(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    da daVar = da.this;
                    daVar.c(daVar.x, "native_endcard_close", jSONObject);
                }
            });
        } catch (Throwable th) {
            m.tt("WebviewTimeTrack", th.getMessage());
        }
    }

    public void i() {
        try {
            com.byazt.nr.da.c().post(new Runnable() { // from class: com.byazt.ddx.da.13
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    da.this.c(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    da daVar = da.this;
                    daVar.c(daVar.x, "native_endcard_show", jSONObject);
                }
            });
        } catch (Throwable th) {
            m.tt("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.byazt.yw.c
    public void n(final String str) {
        try {
            com.byazt.nr.da.c().post(new Runnable() { // from class: com.byazt.ddx.da.3
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    da.this.c(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    da daVar = da.this;
                    daVar.c(daVar.x, str, jSONObject);
                    if (da.this.tt.equals("splash_ad") || da.this.tt.equals("cache_splash_ad")) {
                        return;
                    }
                    com.byazt.whk.c.c().c("ugen_render", "native_render_success", String.valueOf(jCurrentTimeMillis) + "0", da.this.c);
                }
            });
        } catch (Throwable th) {
            m.tt("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.byazt.yw.uj
    public void sp() {
        try {
            com.byazt.nr.da.c().post(new Runnable() { // from class: com.byazt.ddx.da.10
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    da.this.c(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    da daVar = da.this;
                    daVar.c(daVar.x, "webview_load_success", jSONObject);
                }
            });
        } catch (Throwable th) {
            m.tt("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.byazt.yw.ve
    public void tt() {
        try {
            com.byazt.nr.da.c().post(new Runnable() { // from class: com.byazt.ddx.da.12
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    da.this.c(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    da daVar = da.this;
                    daVar.c(daVar.x, "render_success", jSONObject);
                    if (da.this.tt.equals("splash_ad") || da.this.tt.equals("cache_splash_ad")) {
                        return;
                    }
                    if (da.this.x.optInt("webview_source", -1) == 2) {
                        m.c(da.this.tt, "no count ENDCARD_SOURCE");
                        return;
                    }
                    com.byazt.whk.c.c().c("ugen_render", "h5_render_success", String.valueOf(jCurrentTimeMillis) + "0", da.this.c);
                }
            });
        } catch (Throwable th) {
            m.tt("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.byazt.yw.c
    public void uj(final String str) {
        try {
            com.byazt.nr.da.c().post(new Runnable() { // from class: com.byazt.ddx.da.2
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    da.this.c(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    da daVar = da.this;
                    daVar.c(daVar.x, str, jSONObject);
                }
            });
        } catch (Throwable th) {
            m.tt("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.byazt.yw.tt
    public void ve() {
        try {
            com.byazt.nr.da.c().post(new Runnable() { // from class: com.byazt.ddx.da.27
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    da.this.c(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    da daVar = da.this;
                    daVar.c(daVar.x, "native_render_start", jSONObject);
                }
            });
        } catch (Throwable th) {
            m.tt("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.byazt.yw.uj
    public void x() {
        tt((JSONObject) null);
    }

    @Override // com.byazt.yw.uj
    public void a(final String str) {
        try {
            com.byazt.nr.da.c().post(new Runnable() { // from class: com.byazt.ddx.da.19
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    da.this.c(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    da.this.c(jSONObject, "jsb", str);
                    da daVar = da.this;
                    daVar.c(daVar.x, "webview_jsb_start", jSONObject);
                }
            });
        } catch (Throwable th) {
            m.tt("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.byazt.yw.tt
    public void n() {
        try {
            com.byazt.nr.da.c().post(new Runnable() { // from class: com.byazt.ddx.da.8
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    da.this.c(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    da daVar = da.this;
                    daVar.c(daVar.x, "native_render_end", jSONObject);
                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                    JSONObject jSONObject2 = new JSONObject();
                    da.this.c(jSONObject2, "ts", Long.valueOf(jCurrentTimeMillis2));
                    da daVar2 = da.this;
                    daVar2.c(daVar2.x, "render_success", jSONObject2);
                }
            });
        } catch (Throwable th) {
            m.tt("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.byazt.yw.uj
    public void sp(final String str) {
        try {
            com.byazt.nr.da.c().post(new Runnable() { // from class: com.byazt.ddx.da.20
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    da.this.c(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    da.this.c(jSONObject, "jsb", str);
                    da daVar = da.this;
                    daVar.c(daVar.x, "webview_jsb_end", jSONObject);
                }
            });
        } catch (Throwable th) {
            m.tt("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.byazt.yw.c
    public void tt(final String str) {
        try {
            com.byazt.nr.da.c().post(new Runnable() { // from class: com.byazt.ddx.da.29
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    da.this.c(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    da daVar = da.this;
                    daVar.c(daVar.x, str, jSONObject);
                }
            });
        } catch (Throwable th) {
            m.tt("WebviewTimeTrack", th.getMessage());
        }
    }

    public void uj() {
        try {
            com.byazt.nr.da.c().post(new Runnable() { // from class: com.byazt.ddx.da.7
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    da.this.c(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    da daVar = da.this;
                    daVar.c(daVar.x, "native_render_end", jSONObject);
                }
            });
        } catch (Throwable th) {
            m.tt("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.byazt.yw.c
    public void ve(final String str) {
        try {
            com.byazt.nr.da.c().post(new Runnable() { // from class: com.byazt.ddx.da.30
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    da.this.c(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    da daVar = da.this;
                    daVar.c(daVar.x, str, jSONObject);
                    if (da.this.tt.equals("splash_ad") || da.this.tt.equals("cache_splash_ad")) {
                        return;
                    }
                    com.byazt.whk.c.c().c("ugen_render", "native_render_success", String.valueOf(jCurrentTimeMillis) + "0", da.this.c);
                }
            });
        } catch (Throwable th) {
            m.tt("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.byazt.yw.ve
    public void c() {
        try {
            com.byazt.nr.da.c().post(new Runnable() { // from class: com.byazt.ddx.da.1
                @Override // java.lang.Runnable
                public void run() {
                    da.this.u.set(System.currentTimeMillis());
                    JSONObject jSONObject = new JSONObject();
                    da daVar = da.this;
                    daVar.c(jSONObject, "ts", Long.valueOf(daVar.u.get()));
                    da daVar2 = da.this;
                    daVar2.c(jSONObject, "render_sequence", Integer.valueOf(pu.tt(daVar2.ve)));
                    da daVar3 = da.this;
                    daVar3.c(jSONObject, "render_timeout", Integer.valueOf(daVar3.t));
                    da.this.c(jSONObject, "webview_count", Integer.valueOf(com.byazt.ol.n.c().n()));
                    da.this.c(jSONObject, "available_cache_count", Integer.valueOf(com.byazt.ol.n.c().ve()));
                    ma maVarSp = pu.sp(da.this.ve);
                    if (maVarSp != null) {
                        da.this.c(jSONObject, "rule_id", maVarSp.x());
                    } else {
                        da.this.c(jSONObject, "rule_id", "0");
                    }
                    JSONObject jSONObjectNu = da.this.nu();
                    if (jSONObjectNu != null) {
                        da.this.c(jSONObject, "size", jSONObjectNu);
                    }
                    da daVar4 = da.this;
                    daVar4.c(daVar4.x, "render_start", jSONObject);
                }
            });
        } catch (Throwable th) {
            m.tt("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.byazt.yw.c
    public void tt(final int i, final String str) {
        try {
            com.byazt.nr.da.c().post(new Runnable() { // from class: com.byazt.ddx.da.31
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    da.this.c(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    da.this.c(jSONObject, "code", Integer.valueOf(i));
                    da daVar = da.this;
                    daVar.c(daVar.x, str, jSONObject);
                    if (da.this.tt.equals("splash_ad") || da.this.tt.equals("cache_splash_ad")) {
                        return;
                    }
                    com.byazt.whk.c.c().c("ugen_render", "native_render_fail", String.valueOf(jCurrentTimeMillis) + "1", da.this.c);
                }
            });
        } catch (Throwable th) {
            m.tt("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.byazt.rbg.c
    public void uj(final JSONObject jSONObject) {
        try {
            com.byazt.nr.da.c().post(new Runnable() { // from class: com.byazt.ddx.da.24
                @Override // java.lang.Runnable
                public void run() {
                    JSONObject jSONObject2;
                    if (da.this.x == null || (jSONObject2 = jSONObject) == null) {
                        return;
                    }
                    Iterator<String> itKeys = jSONObject2.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        da daVar = da.this;
                        daVar.c(daVar.x, next, jSONObject.opt(next));
                    }
                    da.this.f28387a = Boolean.TRUE;
                    da.this.m();
                }
            });
        } catch (Throwable th) {
            m.tt("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.byazt.yw.c
    public void ve(final int i, final String str) {
        try {
            com.byazt.nr.da.c().post(new Runnable() { // from class: com.byazt.ddx.da.4
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    da.this.c(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    da.this.c(jSONObject, "code", Integer.valueOf(i));
                    da daVar = da.this;
                    daVar.c(daVar.x, str, jSONObject);
                    if (da.this.tt.equals("splash_ad") || da.this.tt.equals("cache_splash_ad")) {
                        return;
                    }
                    com.byazt.whk.c.c().c("ugen_render", "native_render_fail", String.valueOf(jCurrentTimeMillis) + "1", da.this.c);
                }
            });
        } catch (Throwable th) {
            m.tt("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.byazt.yw.ve
    public void c(final int i, final String str) {
        try {
            com.byazt.nr.da.c().post(new Runnable() { // from class: com.byazt.ddx.da.26
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    da.this.c(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    da.this.c(jSONObject, "code", Integer.valueOf(i));
                    String str2 = str;
                    if (str2 != null) {
                        da.this.c(jSONObject, MediationConstant.KEY_REASON, str2);
                    }
                    da daVar = da.this;
                    daVar.c(daVar.x, "render_error", jSONObject);
                }
            });
        } catch (Throwable th) {
            m.tt("WebviewTimeTrack", th.getMessage());
        }
    }

    public void tt(final JSONObject jSONObject) {
        try {
            com.byazt.nr.da.c().post(new Runnable() { // from class: com.byazt.ddx.da.11
                @Override // java.lang.Runnable
                public void run() {
                    JSONObject jSONObject2 = jSONObject;
                    if (jSONObject2 == null) {
                        jSONObject2 = new JSONObject();
                    }
                    da.this.c(jSONObject2, "ts", Long.valueOf(System.currentTimeMillis()));
                    da daVar = da.this;
                    daVar.c(daVar.x, "webview_load_error", jSONObject2);
                }
            });
        } catch (Throwable th) {
            m.tt("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.byazt.yw.ve
    public void ve(final JSONObject jSONObject) {
        try {
            com.byazt.nr.da.c().post(new Runnable() { // from class: com.byazt.ddx.da.23
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject2 = jSONObject;
                    if (jSONObject2 == null) {
                        jSONObject2 = new JSONObject();
                    }
                    da.this.c(jSONObject2, "ts", Long.valueOf(jCurrentTimeMillis));
                    da daVar = da.this;
                    daVar.c(daVar.x, "render_did_finish", jSONObject2);
                }
            });
        } catch (Throwable th) {
            m.tt("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.byazt.yw.c
    public void c(final String str) {
        try {
            com.byazt.nr.da.c().post(new Runnable() { // from class: com.byazt.ddx.da.28
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    da.this.c(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    da daVar = da.this;
                    daVar.c(daVar.x, str, jSONObject);
                }
            });
        } catch (Throwable th) {
            m.tt("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.byazt.yw.uj
    public void tt(final String str, final long j, final long j2, final int i) {
        try {
            com.byazt.nr.da.c().post(new Runnable() { // from class: com.byazt.ddx.da.18
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.isEmpty(str) || j2 < j) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject();
                    da.this.c(jSONObject, "start_ts", Long.valueOf(j));
                    da.this.c(jSONObject, "end_ts", Long.valueOf(j2));
                    da.this.c(jSONObject, "intercept_type", Integer.valueOf(i));
                    da.this.c(jSONObject, "type", "intercept_js");
                    da.this.c(jSONObject, "url", str);
                    da.this.c(jSONObject, "duration", Long.valueOf(j2 - j));
                    da daVar = da.this;
                    daVar.c(daVar.da, jSONObject);
                }
            });
        } catch (Throwable th) {
            m.tt("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.byazt.yw.c
    public void c(final JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            com.byazt.nr.da.c().post(new Runnable() { // from class: com.byazt.ddx.da.5
                @Override // java.lang.Runnable
                public void run() {
                    da.this.c(jSONObject, "ts", Long.valueOf(System.currentTimeMillis()));
                    da daVar = da.this;
                    daVar.c(daVar.x, "render_exception", jSONObject);
                }
            });
        } catch (Throwable th) {
            m.tt("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.byazt.rbg.c
    public void tt(boolean z) {
        try {
            if (!this.m && this.ve != null) {
                this.m = true;
                if (pu.tt(this.ve) == 0 && this.z != 0) {
                    if (this.yp == null) {
                        this.yp = new JSONObject();
                    }
                    this.yp.put("render_sequence", pu.tt(this.ve));
                    this.yp.put("render_control", pu.c(this.ve));
                    this.yp.put("fetch_tpl_time_out", gt.tt().c(this.tt, pu.tt(this.ve)));
                    this.yp.put("req_id", this.ve.qy());
                    this.yp.put(MediationConstant.EXTRA_ADID, this.ve.uj());
                    this.yp.put("ad_slot_type", nb.sl(this.ve));
                    if (z) {
                        this.yp.put("webview_time_cost", System.currentTimeMillis() - this.u.get());
                        this.yp.put("webview_result", 2);
                    }
                    yp.c().c(this.yp);
                }
            }
        } catch (Exception e) {
            m.c(e);
        }
    }

    @Override // com.byazt.yw.uj
    public void c(final int i) {
        try {
            com.byazt.nr.da.c().post(new Runnable() { // from class: com.byazt.ddx.da.6
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    da.this.c(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    da.this.c(jSONObject, "isWebViewCache", Integer.valueOf(i));
                    if (da.this.ve != null) {
                        if (pu.x(da.this.ve)) {
                            da.this.c(jSONObject, "engine_version", "v3");
                        } else {
                            da.this.c(jSONObject, "engine_version", com.alipay.sdk.m.c0.c.c);
                        }
                    }
                    da daVar = da.this;
                    daVar.c(daVar.x, "before_webview_request", jSONObject);
                }
            });
        } catch (Throwable th) {
            m.tt("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.byazt.yw.uj
    public void c(final String str, final long j, final long j2, final int i) {
        try {
            com.byazt.nr.da.c().post(new Runnable() { // from class: com.byazt.ddx.da.17
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.isEmpty(str) || j2 < j) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject();
                    da.this.c(jSONObject, "start_ts", Long.valueOf(j));
                    da.this.c(jSONObject, "end_ts", Long.valueOf(j2));
                    da.this.c(jSONObject, "intercept_type", Integer.valueOf(i));
                    da.this.c(jSONObject, "type", "intercept_html");
                    da.this.c(jSONObject, "url", str);
                    da.this.c(jSONObject, "duration", Long.valueOf(j2 - j));
                    da daVar = da.this;
                    daVar.c(daVar.da, jSONObject);
                }
            });
        } catch (Throwable th) {
            m.tt("WebviewTimeTrack", th.getMessage());
        }
    }

    public da() {
        this.tt = com.byazt.dyf.tt.AD_TAG_FEED;
        Boolean bool = Boolean.FALSE;
        this.n = bool;
        this.f28387a = bool;
        this.sp = bool;
        this.sl = false;
        this.u = new AtomicLong();
        this.z = 0;
        this.m = false;
    }

    @Override // com.byazt.rbg.c
    public void c(boolean z) {
        this.sp = Boolean.valueOf(z);
    }

    @Override // com.byazt.rbg.c
    public void c(boolean z, int i) {
        try {
            if (this.yp == null) {
                this.yp = new JSONObject();
            }
            this.yp.put(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE, i);
            this.yp.put("webview_time_cost", System.currentTimeMillis() - this.u.get());
            this.yp.put("webview_result", z ? 0 : 1);
        } catch (Exception e) {
            m.c(e);
        }
    }

    @Override // com.byazt.rbg.c
    public void c(int i, int i2, String str) {
        try {
            this.z = i;
            if (this.yp == null) {
                this.yp = new JSONObject();
            }
            this.yp.put("render_type", i);
            this.yp.put(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE, i2);
        } catch (Exception e) {
            m.c(e);
        }
    }

    public void tt(int i) {
        this.t = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(JSONObject jSONObject, String str, Object obj, boolean z) {
        if (jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (!z) {
            try {
                if (jSONObject.has(str)) {
                    return;
                }
            } catch (Exception e) {
                m.tt("WebviewTimeTrack", e.getMessage());
                return;
            }
        }
        jSONObject.put(str, obj);
    }

    public void c(JSONObject jSONObject, String str, Object obj) {
        c(jSONObject, str, obj, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(JSONArray jSONArray, Object obj) {
        if (jSONArray == null || jSONArray.length() >= 10) {
            return;
        }
        try {
            jSONArray.put(obj);
        } catch (Exception e) {
            m.tt("WebviewTimeTrack", e.getMessage());
        }
    }
}
