package com.byazt.xjc;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 511, 54})
public class ve {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f29182a;
    public String c;
    public int da;
    public String i;
    public boolean n;
    public boolean sl;
    public JSONArray sp;
    public int tt;
    public int uj;
    public int ve;
    public boolean x;

    @com.byazt.zqa.c(c = {0, 1, 511, 24})
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f29183a;
        public String c;
        public com.byazt.cjm.c da;
        public boolean i;
        public JSONArray n;
        public int sp;
        public int tt;
        public boolean uj;
        public int ve;
        public int x;

        public ve c() {
            return new ve(this.c, this.tt, this.ve, this.x, this.uj, this.n, this.f29183a, this.da, this.sp, this.i);
        }

        public c tt(int i) {
            this.ve = i;
            return this;
        }

        public c uj(int i) {
            this.x = i;
            return this;
        }

        public c ve(int i) {
            this.sp = i;
            return this;
        }

        public c c(String str) {
            this.c = str;
            return this;
        }

        public c tt(boolean z) {
            this.f29183a = z;
            return this;
        }

        public c ve(boolean z) {
            this.i = z;
            return this;
        }

        public c c(int i) {
            this.tt = i;
            return this;
        }

        public c c(boolean z) {
            this.uj = z;
            return this;
        }

        public c c(Set<Integer> set) {
            this.n = new JSONArray((Collection) set);
            return this;
        }

        public c c(com.byazt.cjm.c cVar) {
            this.da = cVar;
            return this;
        }
    }

    public String a() {
        return this.i;
    }

    public String c() {
        return this.c;
    }

    public int da() {
        return this.uj;
    }

    public JSONObject i() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("meta_md5", this.c);
            jSONObject.put("consume_time", this.tt);
            jSONObject.put("reduce_time", this.ve);
            jSONObject.put("is_video_completed", this.n);
            jSONObject.put("is_user_interacted", this.f29182a);
            jSONObject.put("reward_verify_array", this.sp);
            jSONObject.put("is_mute", this.x);
            jSONObject.put("play_again_string", this.i);
            jSONObject.put("carousel_type", this.da);
            jSONObject.put("eternal_global_time", this.uj);
            jSONObject.put("first_ad_is_video", this.sl);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public boolean n() {
        return this.x;
    }

    public boolean sl() {
        return this.sl;
    }

    public int sp() {
        return this.da;
    }

    public int tt() {
        return this.tt;
    }

    public boolean uj() {
        return this.n;
    }

    public int ve() {
        return this.ve;
    }

    public Map<Integer, Boolean> x() {
        HashMap map = new HashMap();
        for (int i = 0; i < this.sp.length(); i++) {
            try {
                map.put((Integer) this.sp.get(i), Boolean.TRUE);
            } catch (Exception unused) {
            }
        }
        return map;
    }

    private ve(String str, int i, int i2, int i3, boolean z, JSONArray jSONArray, boolean z2, com.byazt.cjm.c cVar, int i4, boolean z3) {
        this.c = str;
        this.tt = i;
        this.ve = i2;
        this.uj = i3;
        this.n = z;
        this.sp = jSONArray;
        this.x = z2;
        this.i = cVar.x();
        this.da = i4;
        this.sl = z3;
    }

    public ve(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.c = jSONObject.optString("meta_md5");
            this.tt = jSONObject.optInt("consume_time");
            this.ve = jSONObject.optInt("reduce_time");
            this.n = jSONObject.optBoolean("is_video_completed");
            this.sp = jSONObject.optJSONArray("reward_verify_array");
            this.x = jSONObject.optBoolean("is_mute");
            this.i = jSONObject.optString("play_again_string");
            this.da = jSONObject.optInt("carousel_type");
            this.uj = jSONObject.optInt("eternal_global_time");
            this.sl = jSONObject.optBoolean("first_ad_is_video");
        } catch (Exception unused) {
        }
    }
}
