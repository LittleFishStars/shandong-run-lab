package com.byazt.bb;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.NativeModel;
import com.byazt.aas.bx;
import com.byazt.aas.nb;
import com.byazt.ddx.i;
import com.byazt.eia.sl;
import com.byazt.ete.ic;
import com.byazt.ete.nu;
import com.byazt.ete.pf;
import com.byazt.ete.qy;
import com.byazt.omf.gt;
import com.byazt.omf.or;
import com.byazt.omf.p;
import com.byazt.ukr.yp;
import com.igexin.push.core.b;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 147, 54})
public class ve implements com.byazt.hl.c {
    public com.byazt.hl.c c;
    public final sl da;
    public com.byazt.zd.tt i;
    public final Map<String, Object> sl;
    public com.byazt.pop.ve sp;
    public boolean t;
    public String tt;
    public com.byazt.ny.n.c u;
    public nu uj;
    public Context ve;
    public String x;
    public final boolean yp;
    public boolean n = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f28314a = false;

    public ve(com.byazt.hl.c cVar, sl slVar, String str, nu nuVar, Context context, Map<String, Object> map, boolean z) {
        this.c = cVar;
        this.da = slVar;
        this.tt = str;
        this.ve = context;
        this.uj = nuVar;
        this.sl = map;
        this.yp = z;
    }

    public void tt(boolean z) {
        this.f28314a = z;
    }

    public void ve(boolean z) {
        this.t = z;
    }

    private boolean tt() {
        sl slVar = this.da;
        if (!(slVar instanceof ic)) {
            return false;
        }
        String strVe = qy.ve(slVar.u(), this.x);
        ic icVar = (ic) this.da;
        Context context = this.ve;
        String str = this.tt;
        com.byazt.szt.c cVar = new com.byazt.szt.c(icVar, context, str, nb.uj(str), new HashMap(), null, null);
        cVar.c(strVe);
        cVar.c(this.i);
        return cVar.c(new HashMap());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v36 */
    /* JADX WARN: Type inference failed for: r13v51 */
    /* JADX WARN: Type inference failed for: r13v52 */
    private boolean ve(Map<String, Object> map) {
        Boolean boolValueOf;
        Boolean boolValueOf2;
        JSONObject jSONObject = new JSONObject();
        try {
            sl slVar = this.da;
            try {
                if (!(slVar instanceof com.byazt.eia.a)) {
                    jSONObject.putOpt("uchain", Boolean.TRUE);
                    jSONObject.putOpt("live_interaction_type", Integer.valueOf(this.da.n()));
                    jSONObject.putOpt("req_id", this.da.qy());
                    boolValueOf = Boolean.valueOf(this.da.s_());
                } else {
                    int iX = ((com.byazt.eia.a) slVar).x();
                    try {
                        if (iX == 4) {
                            com.byazt.hl.c cVar = this.c;
                            boolean z = cVar != null && cVar.c(map);
                            if (z) {
                                this.u.c(true);
                            }
                            jSONObject.putOpt("uchain", Boolean.TRUE);
                            jSONObject.putOpt("live_interaction_type", Integer.valueOf(this.da.n()));
                            jSONObject.putOpt("req_id", this.da.qy());
                            boolValueOf2 = Boolean.valueOf(this.da.s_());
                            map = z;
                        } else if (iX == 1) {
                            jSONObject.putOpt("uchain", Boolean.TRUE);
                            jSONObject.putOpt("live_interaction_type", Integer.valueOf(this.da.n()));
                            jSONObject.putOpt("req_id", this.da.qy());
                            boolValueOf = Boolean.valueOf(this.da.s_());
                        } else {
                            String strVe = ((com.byazt.eia.a) this.da).ve();
                            Boolean boolC = c(map, strVe, jSONObject);
                            try {
                                if (!TextUtils.isEmpty(this.x)) {
                                    jSONObject.putOpt("dpa_sub", Boolean.TRUE);
                                    jSONObject.putOpt("tag", this.x);
                                }
                                jSONObject.putOpt("convert_type", Integer.valueOf(iX));
                                jSONObject.putOpt("dpl_result", boolC);
                                jSONObject.putOpt("url", strVe);
                            } catch (Exception unused) {
                            }
                            if (boolC != null && !this.f28314a) {
                                boolean zBooleanValue = boolC.booleanValue();
                                jSONObject.putOpt("uchain", Boolean.TRUE);
                                jSONObject.putOpt("live_interaction_type", Integer.valueOf(this.da.n()));
                                jSONObject.putOpt("req_id", this.da.qy());
                                boolValueOf2 = Boolean.valueOf(this.da.s_());
                                map = zBooleanValue;
                            } else {
                                if (this.f28314a && (boolC == null || !boolC.booleanValue())) {
                                    try {
                                        jSONObject.putOpt("uchain", Boolean.TRUE);
                                        jSONObject.putOpt("live_interaction_type", Integer.valueOf(this.da.n()));
                                        jSONObject.putOpt("req_id", this.da.qy());
                                        jSONObject.putOpt("web_meta", Boolean.valueOf(this.da.s_()));
                                    } catch (Exception unused2) {
                                    }
                                    yp.c().c("open_detail_page", "native", 0, jSONObject);
                                    return false;
                                }
                                jSONObject.putOpt("uchain", Boolean.TRUE);
                                jSONObject.putOpt("live_interaction_type", Integer.valueOf(this.da.n()));
                                jSONObject.putOpt("req_id", this.da.qy());
                                boolValueOf = Boolean.valueOf(this.da.s_());
                            }
                        }
                        jSONObject.putOpt("web_meta", boolValueOf2);
                    } catch (Exception unused3) {
                    }
                    yp.c().c("open_detail_page", "native", 0, jSONObject);
                    return map;
                }
                jSONObject.putOpt("web_meta", boolValueOf);
            } catch (Exception unused4) {
            }
            yp.c().c("open_detail_page", "native", 0, jSONObject);
            return false;
        } catch (Throwable th) {
            try {
                jSONObject.putOpt("uchain", Boolean.TRUE);
                jSONObject.putOpt("live_interaction_type", Integer.valueOf(this.da.n()));
                jSONObject.putOpt("req_id", this.da.qy());
                jSONObject.putOpt("web_meta", Boolean.valueOf(this.da.s_()));
            } catch (Exception unused5) {
            }
            yp.c().c("open_detail_page", "native", 0, jSONObject);
            throw th;
        }
    }

    @Override // com.byazt.hl.c
    public boolean c(Map<String, Object> map) {
        if (this.yp) {
            boolean zVe = ve(map);
            if (!zVe) {
                this.u.c(false);
            }
            return zVe;
        }
        return tt(map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt(final Intent intent, final boolean z) {
        sl slVar = this.da;
        if (slVar == null || this.ve == null || intent == null) {
            return;
        }
        String strVe = slVar.z() != null ? this.da.z().ve() : "";
        com.byazt.aas.n.c(this.ve, this.da.uj(), strVe, TextUtils.isEmpty(strVe) ? "是否立即打开应用" : "是否立即打开".concat(String.valueOf(strVe)), "立即打开", "退出", new com.byazt.aas.n.c() { // from class: com.byazt.bb.ve.3
            @Override // com.byazt.aas.n.c
            public void c() {
                HashMap map = new HashMap();
                map.put("source", "DeepLinkConverter");
                com.byazt.ddx.uj.c(ve.this.ve(), ve.this.tt, (Map<String, Object>) map, false);
                com.byazt.nr.tt.c(ve.this.ve, intent, new com.byazt.nr.tt.c() { // from class: com.byazt.bb.ve.3.1
                    @Override // com.byazt.nr.tt.c
                    public void c() {
                        com.byazt.ddx.uj.c(ve.this.ve(), ve.this.tt, (Throwable) null, false, true);
                        com.byazt.ddx.x.c().c(ve.this.ve(), ve.this.tt, false, z, null);
                    }

                    @Override // com.byazt.nr.tt.c
                    public void c(Throwable th) {
                        com.byazt.ddx.uj.c(ve.this.ve(), ve.this.tt, th, false, false);
                    }
                }, TextUtils.equals(p.x, "internal"));
            }

            @Override // com.byazt.aas.n.c
            public void tt() {
            }

            @Override // com.byazt.aas.n.c
            public void ve() {
            }
        });
    }

    public void c(com.byazt.zd.tt ttVar) {
        this.i = ttVar;
    }

    public void c(boolean z) {
        this.n = z;
    }

    public void c(com.byazt.pop.ve veVar) {
        this.sp = veVar;
    }

    public void c(String str) {
        this.x = str;
    }

    public void c(com.byazt.ny.n.c cVar) {
        this.u = cVar;
    }

    private nu c() {
        nu nuVar = this.uj;
        return nuVar == null ? new nu() : nuVar;
    }

    private String tt(String str) {
        sl slVar;
        pf pfVarGt;
        if (TextUtils.isEmpty(str) || (slVar = this.da) == null || slVar.z_() || (pfVarGt = this.da.gt()) == null) {
            return str;
        }
        try {
            String strVe = pfVarGt.ve();
            String strUj = pfVarGt.uj();
            Map<String, String> mapC = bx.c(str);
            mapC.put("live_short_touch_params", strVe);
            mapC.put("extra_pangle_scheme_params", strUj);
            String strC = bx.c(str, mapC);
            com.byazt.omf.tt.c().put("is_reward_deep_link_to_live", true);
            return strC;
        } catch (Exception unused) {
            return str;
        }
    }

    public Boolean c(Map<String, Object> map, String str, JSONObject jSONObject) {
        String strTt = tt(str);
        if (TextUtils.isEmpty(strTt)) {
            com.byazt.ppf.ve.c(this.sl, com.byazt.cr.n.uj);
            return null;
        }
        nu.c((String) null);
        Uri uri = Uri.parse(strTt);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        HashMap map2 = new HashMap();
        map2.put("source", "DeepLinkConverter");
        map2.put(NativeModel.JSON_KEY_SCHEME, nb.c(strTt));
        com.byazt.ddx.uj.c(ve(), this.tt, map2, this.n);
        boolean zYv = nb.yv();
        try {
            jSONObject.putOpt("is_lp", Boolean.valueOf(this.n));
            jSONObject.putOpt("can_qry_pkg", Boolean.valueOf(zYv));
        } catch (Exception unused) {
        }
        if (zYv) {
            boolean zC = nb.c(intent);
            boolean zEk = gt.tt().ek();
            try {
                jSONObject.putOpt("installed", Boolean.valueOf(zC));
                jSONObject.putOpt("ignore", Boolean.valueOf(zEk));
            } catch (Exception unused2) {
            }
            if (!zC && !zEk) {
                c(map, true, (Throwable) new RuntimeException("not installed"));
                c(1);
                return null;
            }
            return c(map, intent, true, jSONObject);
        }
        try {
            jSONObject.putOpt("installed_douyin", Boolean.valueOf(com.byazt.wu.c.c(strTt)));
            String strP = nb.p(ve());
            if (strP != null && strP.length() > 0) {
                jSONObject.putOpt("installed_other", Boolean.valueOf(nb.ve(strP)));
            }
            jSONObject.putOpt(b.aC, strP);
        } catch (Throwable unused3) {
        }
        return c(map, intent, false, jSONObject);
    }

    private boolean tt(Map<String, Object> map) {
        Object objValueOf;
        JSONObject jSONObject = new JSONObject();
        try {
            Boolean boolC = c(jSONObject);
            boolean z = true;
            try {
                if (boolC != null && boolC.booleanValue()) {
                    try {
                        jSONObject.putOpt("dpa_sub", Boolean.TRUE);
                    } catch (Exception unused) {
                    }
                    jSONObject.putOpt("uchain", Boolean.TRUE);
                    jSONObject.putOpt("live_interaction_type", Integer.valueOf(this.da.n()));
                    jSONObject.putOpt("req_id", this.da.qy());
                    objValueOf = Boolean.valueOf(this.da.s_());
                } else {
                    nu nuVarC = c();
                    if (nuVarC == null) {
                        nuVarC = this.da.yp();
                    }
                    if (nuVarC != null && !TextUtils.isEmpty(nuVarC.tt())) {
                        String strTt = nuVarC.tt();
                        Boolean boolC2 = c(map, strTt, jSONObject);
                        try {
                            jSONObject.putOpt("dpl_result", boolC2);
                            jSONObject.putOpt("url", strTt);
                        } catch (Exception unused2) {
                        }
                        if ((boolC2 == null || !boolC2.booleanValue()) && nuVarC.n() == 1) {
                            com.byazt.ddx.uj.x(ve(), this.tt, "open_fallback_url", null);
                        }
                        if (boolC2 != null && !this.f28314a) {
                            boolean zBooleanValue = boolC2.booleanValue();
                            try {
                                jSONObject.putOpt("uchain", Boolean.TRUE);
                                jSONObject.putOpt("live_interaction_type", Integer.valueOf(this.da.n()));
                                jSONObject.putOpt("req_id", this.da.qy());
                                jSONObject.putOpt("web_meta", Boolean.valueOf(this.da.s_()));
                            } catch (Exception unused3) {
                            }
                            yp.c().c("open_detail_page", "native", 0, jSONObject);
                            return zBooleanValue;
                        }
                        if (this.f28314a && (boolC2 == null || !boolC2.booleanValue())) {
                            try {
                                jSONObject.putOpt("uchain", Boolean.TRUE);
                                jSONObject.putOpt("live_interaction_type", Integer.valueOf(this.da.n()));
                                jSONObject.putOpt("req_id", this.da.qy());
                                jSONObject.putOpt("web_meta", Boolean.valueOf(this.da.s_()));
                            } catch (Exception unused4) {
                            }
                            yp.c().c("open_detail_page", "native", 0, jSONObject);
                            com.byazt.hl.c cVar = this.c;
                            return cVar != null && cVar.c(map);
                        }
                        try {
                            jSONObject.putOpt("uchain", Boolean.TRUE);
                            jSONObject.putOpt("live_interaction_type", Integer.valueOf(this.da.n()));
                            jSONObject.putOpt("req_id", this.da.qy());
                            jSONObject.putOpt("web_meta", Boolean.valueOf(this.da.s_()));
                        } catch (Exception unused5) {
                        }
                        yp.c().c("open_detail_page", "native", 0, jSONObject);
                        return false;
                    }
                    try {
                        jSONObject.putOpt("dpl_null", Boolean.TRUE);
                    } catch (Exception unused6) {
                    }
                    com.byazt.hl.c cVar2 = this.c;
                    z = cVar2 != null && cVar2.c(map);
                    jSONObject.putOpt("uchain", Boolean.TRUE);
                    jSONObject.putOpt("live_interaction_type", Integer.valueOf(this.da.n()));
                    jSONObject.putOpt("req_id", this.da.qy());
                    objValueOf = Boolean.valueOf(this.da.s_());
                }
                jSONObject.putOpt("web_meta", objValueOf);
            } catch (Exception unused7) {
            }
            yp.c().c("open_detail_page", "native", 0, jSONObject);
            return z;
        } catch (Throwable th) {
            try {
                jSONObject.putOpt("uchain", Boolean.TRUE);
                jSONObject.putOpt("live_interaction_type", Integer.valueOf(this.da.n()));
                jSONObject.putOpt("req_id", this.da.qy());
                jSONObject.putOpt("web_meta", Boolean.valueOf(this.da.s_()));
            } catch (Exception unused8) {
            }
            yp.c().c("open_detail_page", "native", 0, jSONObject);
            throw th;
        }
    }

    private Boolean c(JSONObject jSONObject) {
        Boolean boolValueOf;
        try {
            jSONObject.putOpt("tag", this.x);
        } catch (JSONException unused) {
        }
        if (TextUtils.isEmpty(this.x) || !qy.c(this.da.u(), this.x)) {
            return null;
        }
        int iTt = qy.tt(this.da.u(), this.x);
        if (iTt != 1) {
            boolValueOf = c(new HashMap(), qy.ve(this.da.u(), this.x), jSONObject);
        } else {
            boolValueOf = Boolean.valueOf(tt());
        }
        try {
            jSONObject.putOpt("convert_type", Integer.valueOf(iTt));
            jSONObject.putOpt("dpl_result", boolValueOf);
        } catch (JSONException unused2) {
        }
        return boolValueOf;
    }

    private Boolean c(final Map<String, Object> map, Intent intent, final boolean z, JSONObject jSONObject) {
        nb.ve(intent);
        final boolean zTt = com.byazt.ppf.ve.tt(map);
        c(intent, zTt);
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        com.byazt.nr.tt.c(this.ve, intent, new com.byazt.nr.tt.c() { // from class: com.byazt.bb.ve.1
            @Override // com.byazt.nr.tt.c
            public void c() {
                atomicBoolean.set(true);
                com.byazt.ddx.uj.c(ve.this.ve(), ve.this.tt, (Throwable) null, ve.this.n, true);
                com.byazt.ddx.x.c().c(ve.this.ve(), ve.this.tt, ve.this.n, zTt, new i.c() { // from class: com.byazt.bb.ve.1.1
                    @Override // com.byazt.ddx.i.c
                    public void c(long j) {
                        com.byazt.ppf.ve.c((Map<String, Object>) ve.this.sl, com.byazt.cr.n.n);
                        if (ve.this.u != null) {
                            ve.this.u.c(false);
                        }
                    }

                    @Override // com.byazt.ddx.i.c
                    public void c(String str) {
                    }

                    @Override // com.byazt.ddx.i.c
                    public void c(boolean z2) {
                        if (ve.this.u != null) {
                            ve.this.u.c(true);
                        }
                    }
                });
                ve.this.c(0);
            }

            @Override // com.byazt.nr.tt.c
            public void c(Throwable th) {
                atomicBoolean.set(false);
                ve.this.c((Map<String, Object>) map, z, th);
                ve.this.c(3);
                com.byazt.ppf.ve.c((Map<String, Object>) ve.this.sl, com.byazt.cr.n.f28375a);
            }
        }, TextUtils.equals(p.x, "internal"));
        return Boolean.valueOf(atomicBoolean.get());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ic ve() {
        return com.byazt.ppf.ve.c(this.da, this.sl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i) {
        if (ve() == null || ve().xl() != 1) {
            return;
        }
        com.byazt.ddx.uj.c(ve(), this.tt, 1, 1, i, p.x());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Map<String, Object> map, boolean z, Throwable th) {
        if (this.f28314a && !z) {
            com.byazt.ddx.uj.ve(ve(), this.tt, "open_fallback_download");
        }
        com.byazt.ddx.uj.c(ve(), this.tt, th, this.n, false);
    }

    public void c(final Intent intent, final boolean z) {
        final com.byazt.aas.c cVarVe;
        final long jCurrentTimeMillis = System.currentTimeMillis();
        sl slVar = this.da;
        if (slVar == null || intent == null || this.ve == null) {
            return;
        }
        nu nuVarYp = slVar.yp();
        if (nuVarYp != null && nuVarYp.ve() == 2 && !nuVarYp.c() && com.byazt.omf.tt.c().get("dpl_reject_by_dialog", false)) {
            or.c(ve(), this.tt, z);
        } else if (this.da.nu() && (cVarVe = com.byazt.omf.x.m().ve()) != null) {
            cVarVe.c(new com.byazt.aas.c.ve() { // from class: com.byazt.bb.ve.2
                @Override // com.byazt.aas.c.ve, com.byazt.aas.c.InterfaceC0346c
                public void c() {
                    if (System.currentTimeMillis() - jCurrentTimeMillis <= 3000) {
                        ve.this.tt(intent, z);
                    }
                    com.byazt.aas.c cVar = cVarVe;
                    if (cVar != null) {
                        cVar.ve();
                    }
                }
            });
        }
    }
}
