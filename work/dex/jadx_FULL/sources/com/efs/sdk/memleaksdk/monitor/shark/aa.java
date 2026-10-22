package com.efs.sdk.memleaksdk.monitor.shark;

import com.huachenjie.mine.page.dressing_table.signature.SignatureFragment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class aa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f29641a = new c();
    public List<b> b = new ArrayList();
    public List<a> c = new ArrayList();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f29642a;
        public String b;
        public String c;

        public JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("className", this.f29642a);
                jSONObject.put("instanceCount", this.b);
                jSONObject.put("leakInstanceCount", this.c);
            } catch (Exception unused) {
            }
            return jSONObject;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f29643a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public List<a> g = new ArrayList();

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public String f29644a;
        }

        public JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("instanceCount", this.f29643a);
                jSONObject.put("leakReason", this.b);
                jSONObject.put("retainedSize", this.f);
                jSONObject.put("gcRoot", this.c);
                jSONObject.put("className", this.d);
                jSONObject.put(SignatureFragment.SIGNATURE, this.e);
                JSONArray jSONArray = new JSONArray();
                for (int size = this.g.size() - 1; size > -1; size--) {
                    jSONArray.put(this.g.get(size).f29644a);
                }
                jSONObject.put("referenceChain", jSONArray);
            } catch (Exception unused) {
            }
            return jSONObject;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f29645a;
        public String b;
        public List<String> c = new ArrayList();
        public List<String> d = new ArrayList();
        public String e;
        public String f;
        public String g;
        public String h;
        public String i;
        public String j;
        public String k;
        public String l;
        public String m;
        public String n;
        public String o;
        public String p;

        public JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("threadCount", this.f29645a);
                jSONObject.put("fdCount", this.b);
                JSONArray jSONArray = new JSONArray();
                Iterator<String> it = this.c.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next());
                }
                jSONObject.put("threadList", jSONArray);
                JSONArray jSONArray2 = new JSONArray();
                Iterator<String> it2 = this.d.iterator();
                while (it2.hasNext()) {
                    jSONArray2.put(it2.next());
                }
                jSONObject.put("fdList", jSONArray2);
                jSONObject.put("sdkInt", this.e);
                jSONObject.put("manufacture", this.f);
                jSONObject.put("buildModel", this.g);
                jSONObject.put("appVersion", this.h);
                jSONObject.put("currentPage", this.i);
                jSONObject.put("usageSeconds", this.j);
                jSONObject.put("nowTime", this.k);
                jSONObject.put("dumpReason", this.l);
                jSONObject.put("analysisReason", this.m);
                jSONObject.put("sdkVersion", this.n);
                jSONObject.put("filterInstanceTime", this.o);
                jSONObject.put("findGCPathTime", this.p);
            } catch (Exception unused) {
            }
            return jSONObject;
        }
    }

    public boolean a() {
        return !this.b.isEmpty();
    }

    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("runningInfo", this.f29641a.a());
            JSONArray jSONArray = new JSONArray();
            Iterator<b> it = this.b.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().a());
            }
            jSONObject.put("gcPaths", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            Iterator<a> it2 = this.c.iterator();
            while (it2.hasNext()) {
                jSONArray2.put(it2.next().a());
            }
            jSONObject.put("classInfos", jSONArray2);
        } catch (Exception unused) {
        }
        return jSONObject;
    }
}
