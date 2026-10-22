package com.alipay.android.phone.mobilesdk.socketcraft.e;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f25297a;
    public Map<String, String> b;

    public d() {
        HashMap map = new HashMap();
        this.b = map;
        map.put(c.i, "17");
    }

    public d a(String str) {
        this.b.put(c.g, str);
        return this;
    }

    public d b(String str) {
        this.b.put("URL", str);
        return this;
    }

    public d c(String str) {
        this.b.put(c.k, str);
        return this;
    }

    public d d(String str) {
        this.b.put(c.l, str);
        return this;
    }

    public d e(String str) {
        this.b.put(c.m, str);
        return this;
    }

    public d f(String str) {
        this.b.put(c.n, str);
        return this;
    }

    public d g(String str) {
        if (com.alipay.android.phone.mobilesdk.socketcraft.g.c.a(str)) {
            return this;
        }
        this.b.put(c.o, str);
        return this;
    }

    public d h(String str) {
        if (com.alipay.android.phone.mobilesdk.socketcraft.g.c.a(str)) {
            return this;
        }
        this.b.put(c.p, str);
        return this;
    }

    public d i(String str) {
        if (com.alipay.android.phone.mobilesdk.socketcraft.g.c.a(str)) {
            return this;
        }
        this.b.put(c.q, str);
        return this;
    }

    public d j(String str) {
        if (com.alipay.android.phone.mobilesdk.socketcraft.g.c.a(str)) {
            return this;
        }
        this.b.put(c.r, str);
        return this;
    }

    public d k(String str) {
        if (!com.alipay.android.phone.mobilesdk.socketcraft.g.c.a(str) && !"-1".equals(str)) {
            this.b.put(c.s, str);
        }
        return this;
    }

    public d l(String str) {
        if (!com.alipay.android.phone.mobilesdk.socketcraft.g.c.a(str) && !"-1".equals(str)) {
            this.b.put(c.t, str);
        }
        return this;
    }

    public d m(String str) {
        if (!com.alipay.android.phone.mobilesdk.socketcraft.g.c.a(str) && !"-1".equals(str)) {
            this.b.put(c.u, str);
        }
        return this;
    }

    public d n(String str) {
        if (!com.alipay.android.phone.mobilesdk.socketcraft.g.c.a(str) && !"-1".equals(str)) {
            this.b.put(c.v, str);
        }
        return this;
    }

    public d o(String str) {
        if (!com.alipay.android.phone.mobilesdk.socketcraft.g.c.a(str) && !"null".equals(str)) {
            this.b.put(c.w, str);
        }
        return this;
    }

    public String toString() {
        return "MonitorModel{logTitle='" + this.f25297a + "', itemMap=" + this.b + '}';
    }

    public d a(boolean z) {
        this.b.put(c.j, z ? "T" : "F");
        return this;
    }
}
