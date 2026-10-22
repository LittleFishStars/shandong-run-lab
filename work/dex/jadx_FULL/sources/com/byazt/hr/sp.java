package com.byazt.hr;

import android.text.TextUtils;
import com.byazt.nr.m;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 29, 91})
public class sp extends uj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<n> f28625a;
    public c da;
    public final String i;
    public String sp;
    public final String x;

    @com.byazt.zqa.c(c = {0, 1, 29, 180})
    public static class c {
        public String c;
        public String tt;
        public String ve;

        public c(String str, String str2, String str3) {
            this.c = str;
            this.tt = str2;
            this.ve = str3;
        }
    }

    public sp(String str, String str2, String str3, String str4, int i, String str5) {
        super(str, str2, str3, str4, i);
        this.x = "count";
        this.i = "effective_time";
        this.sp = str5;
        if (TextUtils.isEmpty(str2)) {
            this.da = new c("waterfall_show_freq", "waterfall_show_span", "waterfall_show_rule_id");
        } else {
            this.da = new c("freq", "span", "rule_id");
        }
    }

    public void c(String str, int i) {
        for (n nVar : sl()) {
            if (TextUtils.equals(nVar.ve(), str)) {
                nVar.tt(i);
                return;
            }
        }
    }

    public String da() {
        try {
            JSONArray jSONArray = new JSONArray();
            for (n nVar : sl()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(this.da.c, nVar.c());
                jSONObject.put(this.da.tt, nVar.tt());
                jSONObject.put(this.da.ve, nVar.ve());
                jSONObject.put("count", nVar.n());
                jSONObject.put("effective_time", nVar.uj());
                jSONArray.put(jSONObject);
            }
            this.sp = jSONArray.toString();
        } catch (JSONException e) {
            m.c(e);
        }
        return this.sp;
    }

    public String i() {
        try {
            JSONArray jSONArray = new JSONArray(this.sp);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                jSONObject.put("count", 0);
                jSONObject.put("effective_time", a.c(jSONObject.getLong(this.da.tt)));
            }
            this.sp = jSONArray.toString();
        } catch (JSONException e) {
            m.c(e);
        }
        return this.sp;
    }

    public synchronized List<n> sl() {
        sp spVarDa;
        List<n> list = this.f28625a;
        if (list != null && list.size() != 0) {
            return this.f28625a;
        }
        this.f28625a = new ArrayList();
        if (this.sp == null && (spVarDa = u.c().da(this.c)) != null) {
            this.sp = spVarDa.sp;
        }
        if (TextUtils.isEmpty(this.sp)) {
            return this.f28625a;
        }
        try {
            JSONArray jSONArray = new JSONArray(this.sp);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                n nVar = new n();
                String string = jSONObject.getString(this.da.ve);
                if (!TextUtils.isEmpty(string)) {
                    nVar.c(jSONObject.optInt(this.da.c));
                    nVar.c(jSONObject.optLong(this.da.tt));
                    nVar.c(string);
                    if (jSONObject.has("count")) {
                        nVar.tt(jSONObject.optInt("count"));
                    }
                    if (jSONObject.has("effective_time")) {
                        nVar.tt(jSONObject.optLong("effective_time"));
                    }
                    this.f28625a.add(nVar);
                }
            }
        } catch (JSONException e) {
            m.c(e);
        }
        if (this.f28625a.size() > 0) {
            Collections.sort(this.f28625a, new Comparator<n>() { // from class: com.byazt.hr.sp.1
                @Override // java.util.Comparator
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public int compare(n nVar2, n nVar3) {
                    long jTt = nVar2.tt() - nVar3.tt();
                    if (jTt == 0) {
                        return 0;
                    }
                    return jTt > 0 ? 1 : -1;
                }
            });
        }
        return this.f28625a;
    }

    @Override // com.byazt.hr.uj
    public String toString() {
        return "BaseIntervalBean{waterfallId='" + this.c + "', showRulesVersion='" + this.ve + "', timingMode=" + this.n + "}IntervalFreqctlBean{freqctlRules=" + this.f28625a + ", freqctlRulesJson='" + this.sp + "'}";
    }

    public void c(String str, long j) {
        for (n nVar : sl()) {
            if (TextUtils.equals(nVar.ve(), str)) {
                nVar.tt(j);
                return;
            }
        }
    }
}
