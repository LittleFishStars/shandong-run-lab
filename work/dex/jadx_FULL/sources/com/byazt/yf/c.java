package com.byazt.yf;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 508, 20})
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public t f29200a;
    public String c;
    public Map<String, Object> da;
    public a i;
    public boolean n;
    public boolean sl;
    public x sp;
    public JSONObject t;
    public String tt;
    public Map<String, Object> u;
    public String uj;
    public boolean ve;
    public uj x;
    public PluginValueSet yp;
    public boolean z;

    /* JADX INFO: renamed from: com.byazt.yf.c$c, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, 508, 44})
    public static class C0585c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public t f29201a;
        public String c;
        public Map<String, Object> da;
        public a i;
        public x sp;
        public JSONObject t;
        public String tt;
        public Map<String, Object> u;
        public uj x;
        public PluginValueSet yp;
        public boolean z;
        public boolean ve = false;
        public String uj = "";
        public boolean n = false;
        public boolean sl = false;

        public C0585c c(String str) {
            this.c = str;
            return this;
        }

        public C0585c tt(String str) {
            this.tt = str;
            return this;
        }

        public C0585c uj(boolean z) {
            this.z = z;
            return this;
        }

        public C0585c ve(@NonNull String str) {
            this.uj = str;
            return this;
        }

        public C0585c c(boolean z) {
            this.ve = z;
            return this;
        }

        public C0585c tt(boolean z) {
            this.n = z;
            return this;
        }

        public C0585c ve(boolean z) {
            this.sl = z;
            return this;
        }

        public C0585c c(@NonNull t tVar) {
            this.f29201a = tVar;
            return this;
        }

        public C0585c c(@NonNull x xVar) {
            this.sp = xVar;
            return this;
        }

        public C0585c c(@NonNull a aVar) {
            this.i = aVar;
            return this;
        }

        public C0585c c(Map<String, Object> map) {
            if (map != null && !map.isEmpty()) {
                if (this.da == null) {
                    this.da = new HashMap();
                }
                this.da.putAll(map);
            }
            return this;
        }

        public C0585c c(JSONObject jSONObject) {
            this.t = jSONObject;
            return this;
        }

        public C0585c c(PluginValueSet pluginValueSet) {
            this.yp = pluginValueSet;
            return this;
        }

        public c c() {
            return new c(this);
        }
    }

    @NonNull
    public t a() {
        return this.f29200a;
    }

    @Nullable
    public String c() {
        return this.c;
    }

    @Nullable
    public Map<String, Object> da() {
        return this.da;
    }

    @NonNull
    public a i() {
        return this.i;
    }

    public boolean n() {
        return this.n;
    }

    public boolean sl() {
        return this.sl;
    }

    @NonNull
    public x sp() {
        return this.sp;
    }

    @Nullable
    public JSONObject t() {
        return this.t;
    }

    @Nullable
    public String tt() {
        return this.tt;
    }

    @Nullable
    public Map<String, Object> u() {
        return this.u;
    }

    @Nullable
    public String uj() {
        return this.uj;
    }

    public boolean ve() {
        return this.ve;
    }

    @Nullable
    public uj x() {
        return this.x;
    }

    public PluginValueSet yp() {
        return this.yp;
    }

    public boolean z() {
        return this.z;
    }

    private c(C0585c c0585c) {
        this.c = c0585c.c;
        this.tt = c0585c.tt;
        this.ve = c0585c.ve;
        this.uj = c0585c.uj;
        this.n = c0585c.n;
        if (c0585c.f29201a != null) {
            this.f29200a = c0585c.f29201a;
        } else {
            this.f29200a = new t.c().c();
        }
        if (c0585c.sp != null) {
            this.sp = c0585c.sp;
        } else {
            this.sp = new x.c().c();
        }
        if (c0585c.x != null) {
            this.x = c0585c.x;
        } else {
            this.x = new uj.c().c();
        }
        if (c0585c.i != null) {
            this.i = c0585c.i;
        } else {
            this.i = new a();
        }
        this.da = c0585c.da;
        this.sl = c0585c.sl;
        this.t = c0585c.t;
        this.u = c0585c.u;
        this.yp = c0585c.yp;
        this.z = c0585c.z;
    }
}
