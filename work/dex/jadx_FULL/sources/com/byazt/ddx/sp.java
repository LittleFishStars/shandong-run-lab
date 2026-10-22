package com.byazt.ddx;

import android.text.TextUtils;
import com.byazt.bv.BaseConstants;
import com.byazt.ete.ic;
import com.byazt.nr.m;
import com.googlecode.mp4parser.boxes.apple.TrackLoadSettingsAtom;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 483, 91})
public class sp {
    public final ic tt;
    public volatile boolean c = false;
    public String ve = "landingpage";
    public long uj = 0;
    public long n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f28389a = 0;
    public long sp = 0;
    public long x = 0;
    public long i = 0;
    public AtomicInteger da = new AtomicInteger(0);
    public boolean sl = false;
    public AtomicBoolean t = new AtomicBoolean(false);

    public sp(ic icVar) {
        this.tt = icVar;
    }

    public void uj() {
        if (this.t.get() || !this.c) {
            return;
        }
        uj.c(this.tt, this.ve, TrackLoadSettingsAtom.TYPE, new com.byazt.ya.c() { // from class: com.byazt.ddx.sp.1
            @Override // com.byazt.ya.c
            public void onSend(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("render_type", "ugen");
                if (sp.this.tt != null && com.byazt.xs.da.x(sp.this.tt)) {
                    jSONObject.putOpt("native_lp_tpl_id", Integer.valueOf(sp.this.tt.pu()));
                }
                com.byazt.ic.c.c(jSONObject2, sp.this.tt);
                jSONObject.putOpt(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2);
                jSONObject.put("duration", Math.min(System.currentTimeMillis() - sp.this.i, 600000L));
            }
        });
    }

    public void ve() {
        this.f28389a = System.currentTimeMillis();
        this.uj = System.currentTimeMillis();
    }

    public sp c(boolean z) {
        this.sl = z;
        return this;
    }

    public void tt() {
        if (this.c) {
            return;
        }
        this.sp = System.currentTimeMillis();
        this.i = System.currentTimeMillis();
        this.c = true;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("render_type", "ugen");
            ic icVar = this.tt;
            if (icVar != null && com.byazt.xs.da.x(icVar)) {
                jSONObject.putOpt("native_lp_tpl_id", Integer.valueOf(this.tt.pu()));
            }
        } catch (Exception unused) {
        }
        c("load_start", jSONObject);
    }

    public void c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("render_type", "ugen");
            ic icVar = this.tt;
            if (icVar != null && com.byazt.xs.da.x(icVar)) {
                jSONObject.putOpt("native_lp_tpl_id", Integer.valueOf(this.tt.pu()));
            }
        } catch (JSONException e) {
            m.c(e);
        }
        c("open_url_h5", jSONObject);
    }

    public void c(int i, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("render_type", "ugen");
            ic icVar = this.tt;
            if (icVar != null && com.byazt.xs.da.x(icVar)) {
                jSONObject.putOpt("native_lp_tpl_id", Integer.valueOf(this.tt.pu()));
            }
            jSONObject.putOpt("code", Integer.valueOf(i));
            jSONObject.putOpt("msg", str);
        } catch (JSONException e) {
            m.c(e);
        }
        c("load_fail", jSONObject);
    }

    public void c(long j) {
        if (this.t.get()) {
            return;
        }
        this.t.set(true);
        this.x = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        long j2 = this.x - this.sp;
        try {
            jSONObject.putOpt("render_type", "ugen");
            jSONObject.put("net_work_duration", j);
            ic icVar = this.tt;
            if (icVar != null && com.byazt.xs.da.x(icVar)) {
                jSONObject.putOpt("native_lp_tpl_id", Integer.valueOf(this.tt.pu()));
            }
        } catch (JSONException e) {
            m.c(e);
        }
        c("load_finish", jSONObject, Math.min(j2, 600000L));
    }

    public void c(int i) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.n = jCurrentTimeMillis;
        long jMax = jCurrentTimeMillis - Math.max(this.uj, this.f28389a);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("load_status", 2);
            jSONObject.put("max_scroll_percent", this.da.get());
            jSONObject.put("is_slide", i);
            jSONObject.putOpt("render_type", "ugen");
            ic icVar = this.tt;
            if (icVar != null && com.byazt.xs.da.x(icVar)) {
                jSONObject.putOpt("native_lp_tpl_id", Integer.valueOf(this.tt.pu()));
            }
        } catch (JSONException e) {
            m.c(e);
        }
        c("stay_page", jSONObject, Math.min(jMax, 600000L));
    }

    private void c(String str, JSONObject jSONObject) {
        c(str, jSONObject, -1L);
    }

    private void c(String str, JSONObject jSONObject, long j) {
        if (!this.sl || this.tt == null || TextUtils.isEmpty(str)) {
            return;
        }
        JSONObject jSONObject2 = null;
        if (jSONObject != null) {
            try {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject.toString());
                    if (j > 0) {
                        jSONObject3.put("duration", j);
                    }
                    jSONObject2 = jSONObject3;
                } catch (JSONException e) {
                    e = e;
                    jSONObject2 = jSONObject3;
                    m.c(e);
                }
            } catch (JSONException e2) {
                e = e2;
            }
        }
        uj.ve(this.tt, this.ve, str, jSONObject2);
    }
}
