package com.byazt.ddx;

import android.text.TextUtils;
import com.byazt.aas.nb;
import com.byazt.bv.BaseConstants;
import com.byazt.nr.m;
import com.byazt.nr.rh;
import com.byazt.omf.gt;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 483, 20})
public class c implements com.byazt.fo.tt {
    public static final AtomicLong ve = new AtomicLong(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f28385a;
    public final String c;
    public com.byazt.ya.c da;
    public String i;
    public String n;
    public String sl;
    public String sp;
    public long t;
    public final JSONObject tt;
    public long u;
    public JSONObject uj;
    public String x;
    public AtomicBoolean yp = new AtomicBoolean(false);

    /* JADX INFO: renamed from: com.byazt.ddx.c$c, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, 483, 44})
    public static final class C0382c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f28386a;
        public String c;
        public com.byazt.axo.c da;
        public JSONObject i;
        public String n;
        public com.byazt.ya.c sl;
        public String sp;
        public String tt;
        public String uj;
        public String ve;
        public String x;

        public C0382c a(String str) {
            this.sp = str;
            return this;
        }

        public C0382c n(String str) {
            this.f28386a = str;
            return this;
        }

        public C0382c sp(String str) {
            this.x = str;
            return this;
        }

        public C0382c tt(String str) {
            this.ve = str;
            return this;
        }

        public C0382c uj(String str) {
            this.n = str;
            return this;
        }

        public C0382c ve(String str) {
            this.uj = str;
            return this;
        }

        public C0382c c(String str) {
            this.tt = str;
            return this;
        }

        public C0382c c(JSONObject jSONObject) {
            if (jSONObject == null) {
                return this;
            }
            this.i = jSONObject;
            return this;
        }

        public void c(com.byazt.ya.c cVar) {
            if (com.byazt.ukr.n.c(this.ve, 1.0d)) {
                if (this.n != null) {
                    com.byazt.qw.ve.ve().c(this.ve, this.f28386a, this.x, (JSONObject) null, this.n);
                }
                this.sl = cVar;
                c cVar2 = new c(this);
                try {
                    com.byazt.axo.c cVar3 = this.da;
                    if (cVar3 != null) {
                        cVar3.c(cVar2.tt);
                    } else {
                        new com.byazt.axo.tt().c(cVar2.tt);
                    }
                } catch (Throwable th) {
                    m.tt("AdEvent", th);
                }
                com.byazt.ukr.tt.c(cVar2, this.ve);
            }
        }
    }

    public c(C0382c c0382c) {
        this.uj = new JSONObject();
        this.c = TextUtils.isEmpty(c0382c.c) ? UUID.randomUUID().toString() : c0382c.c;
        this.da = c0382c.sl;
        this.sl = c0382c.n;
        this.n = c0382c.tt;
        this.f28385a = c0382c.ve;
        if (TextUtils.isEmpty(c0382c.uj)) {
            this.sp = "app_union";
        } else {
            this.sp = c0382c.uj;
        }
        this.x = c0382c.f28386a;
        this.i = c0382c.sp;
        this.uj = c0382c.i = c0382c.i != null ? c0382c.i : new JSONObject();
        this.u = System.currentTimeMillis();
        this.tt = new JSONObject();
        try {
            sp();
        } catch (Exception e) {
            m.c(e);
        }
    }

    private void sp() {
        this.t = ve.incrementAndGet();
    }

    private void x() throws JSONException {
        this.tt.putOpt("tag", this.n);
        this.tt.putOpt("label", this.f28385a);
        this.tt.putOpt("category", this.sp);
        if (!TextUtils.isEmpty(this.x)) {
            try {
                this.tt.putOpt("value", Long.valueOf(Long.parseLong(this.x)));
            } catch (NumberFormatException unused) {
                this.tt.putOpt("value", 0L);
            }
        }
        if (!TextUtils.isEmpty(this.i)) {
            this.tt.putOpt("ext_value", this.i);
        }
        if (!TextUtils.isEmpty(this.sl)) {
            this.tt.putOpt("log_extra", this.sl);
        }
        if (!TextUtils.equals(this.f28385a, "pangle_live_sdk_monitor")) {
            this.tt.putOpt(BaseConstants.EVENT_LABEL_IS_AD_EVENT, "1");
        }
        this.tt.putOpt("nt", Integer.valueOf(rh.ve(gt.getContext())));
        this.tt.putOpt("tob_ab_sdk_version", com.byazt.omf.x.m().ic());
        Iterator<String> itKeys = this.uj.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            this.tt.putOpt(next, this.uj.opt(next));
        }
    }

    public boolean a() {
        JSONObject jSONObject = this.tt;
        if (jSONObject == null) {
            return false;
        }
        String strOptString = jSONObject.optString("label");
        if (!TextUtils.isEmpty(strOptString)) {
            return ve.c.contains(strOptString);
        }
        if (TextUtils.isEmpty(this.f28385a)) {
            return false;
        }
        return ve.c.contains(this.f28385a);
    }

    @Override // com.byazt.fo.tt
    public long c() {
        return this.u;
    }

    public JSONObject n() {
        if (this.yp.get()) {
            return this.tt;
        }
        try {
            x();
            com.byazt.ya.c cVar = this.da;
            if (cVar != null) {
                cVar.onSend(this.tt);
            }
            c(this.tt);
            this.yp.set(true);
        } catch (Throwable th) {
            m.tt("AdEvent", th);
        }
        return this.tt;
    }

    @Override // com.byazt.fo.tt
    public long tt() {
        return this.t;
    }

    public String uj() {
        return this.c;
    }

    public String ve() {
        if (!TextUtils.isEmpty(this.f28385a)) {
            return this.f28385a;
        }
        JSONObject jSONObject = this.tt;
        return jSONObject != null ? jSONObject.optString("label") : "";
    }

    @Override // com.byazt.fo.tt
    public JSONObject c(String str) {
        JSONObject jSONObject;
        JSONObject jSONObjectN = n();
        try {
            String strOptString = jSONObjectN.optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA);
            if (TextUtils.isEmpty(strOptString)) {
                jSONObject = new JSONObject();
                if (gt.tt().zb() && !TextUtils.isEmpty(str)) {
                    jSONObject.put("will_save_labels", str);
                }
            } else {
                JSONObject jSONObject2 = new JSONObject(strOptString);
                if (gt.tt().zb() && TextUtils.isEmpty(jSONObject2.optString("will_save_labels")) && !TextUtils.isEmpty(str)) {
                    jSONObject2.put("will_save_labels", str);
                }
                jSONObject = jSONObject2;
            }
            String strSp = com.byazt.apd.tt.c().sp();
            if (strSp != null) {
                jSONObject.putOpt("live_plugin_version", strSp.replaceAll("\\.", ""));
            }
            if (com.byazt.omf.x.m().a()) {
                jSONObject.putOpt("first_of_two", 1);
            }
            jSONObjectN.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject.toString());
        } catch (Exception e) {
            m.c(e);
        }
        return jSONObjectN;
    }

    private void c(JSONObject jSONObject) {
        try {
            if (this.t != 0) {
                String strOptString = jSONObject.optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA);
                if (!TextUtils.isEmpty(strOptString)) {
                    JSONObject jSONObject2 = new JSONObject(strOptString);
                    if (jSONObject2.optInt("sdk_event_index") == 0) {
                        jSONObject2.put("sdk_event_index", this.t);
                    }
                    if (jSONObject2.optInt("sdk_event_self_count") == 0) {
                        jSONObject2.put("sdk_event_self_count", com.byazt.ml.c.c(this.f28385a));
                    }
                    jSONObject2.put("create_ts", System.currentTimeMillis());
                    jSONObject2.put("csj_type", com.byazt.omf.x.m().bx() ? 1 : 0);
                    jSONObject2.put("sdk_boost_type", com.byazt.xo.c.n());
                    try {
                        jSONObject2.put("device_score", Double.parseDouble(com.byazt.whk.c.c().c("DeviceRate", "bytebench_value", com.byazt.vxy.c.uj())));
                    } catch (Throwable unused) {
                    }
                    jSONObject2.put("sdk_session_id", com.byazt.ukr.tt.c);
                    if (!TextUtils.isEmpty(nb.i)) {
                        jSONObject2.put("wrong_stats_url", nb.i);
                    }
                    if (!TextUtils.isEmpty(nb.da)) {
                        jSONObject2.put("wrong_applog_url", nb.da);
                    }
                    com.byazt.la.c.c().c(jSONObject2);
                    jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                    return;
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("sdk_event_index", this.t);
                jSONObject3.put("sdk_event_self_count", com.byazt.ml.c.c(this.f28385a));
                jSONObject3.put("sdk_session_id", com.byazt.ukr.tt.c);
                jSONObject3.put("csj_type", com.byazt.omf.x.m().bx() ? 1 : 0);
                jSONObject3.put("sdk_boost_type", com.byazt.xo.c.n());
                try {
                    jSONObject3.put("device_score", Double.parseDouble(com.byazt.whk.c.c().c("DeviceRate", "bytebench_value", com.byazt.vxy.c.uj())));
                } catch (Throwable unused2) {
                }
                jSONObject3.put("create_ts", System.currentTimeMillis());
                if (!TextUtils.isEmpty(nb.i)) {
                    jSONObject3.put("wrong_stats_url", nb.i);
                }
                if (!TextUtils.isEmpty(nb.da)) {
                    jSONObject3.put("wrong_applog_url", nb.da);
                }
                com.byazt.la.c.c().c(jSONObject3);
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject3.toString());
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
