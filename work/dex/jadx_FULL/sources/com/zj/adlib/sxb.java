package com.zj.adlib;

import com.amap.api.col.p0003l.fh;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class sxb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, Boolean> f44807a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public AtomicBoolean f19680a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static sxb f44808a = new sxb(0);
    }

    public /* synthetic */ sxb(byte b) {
        this();
    }

    public static sxb a() {
        return a.f44808a;
    }

    public final void b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String strOptString = jSONObject.optString("mvt_able");
        fh.x(strOptString, true);
        this.f44807a.put("feature_mvt", Boolean.valueOf(fh.x(strOptString, true)));
        this.f44807a.put("feature_gltf", Boolean.valueOf(fh.x(jSONObject.optString("gltf_able"), false)));
        this.f44807a.put("feature_terrain", Boolean.valueOf(fh.x(jSONObject.optString("terrain_able"), false)));
        this.f19680a.set(true);
    }

    public final boolean c(String str) {
        if (this.f44807a.containsKey(str)) {
            return this.f44807a.get(str).booleanValue();
        }
        return false;
    }

    public final boolean d() {
        return this.f19680a.get();
    }

    public final void e() {
        this.f44807a.put("feature_mvt", Boolean.TRUE);
        Map<String, Boolean> map = this.f44807a;
        Boolean bool = Boolean.FALSE;
        map.put("feature_gltf", bool);
        this.f44807a.put("feature_terrain", bool);
    }

    public sxb() {
        this.f44807a = new ConcurrentHashMap();
        this.f19680a = new AtomicBoolean(false);
        e();
    }
}
