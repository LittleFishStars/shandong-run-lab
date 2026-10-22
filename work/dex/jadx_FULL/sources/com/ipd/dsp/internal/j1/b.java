package com.ipd.dsp.internal.j1;

import com.ipd.dsp.internal.c2.g;
import com.ipd.dsp.internal.c2.o;
import com.ipd.dsp.internal.e1.d;
import com.ipd.dsp.internal.e1.k;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f38367a;
    public a b;
    public c c;
    public long d;
    public k e;

    public b(d dVar) {
        if (dVar != null) {
            this.f38367a = dVar.b();
            this.e = dVar.u;
        } else {
            this.f38367a = new HashMap();
        }
        this.f38367a.put("uuid_o", g.a().y());
        this.f38367a.put("wx_open_sdk_status", Integer.valueOf(g.a().K()));
        this.f38367a.put("req_width", 0);
        this.f38367a.put("req_height", 0);
    }

    public void a(a aVar) {
        this.b = aVar;
    }

    public c b() {
        return this.c;
    }

    public Map<String, Object> c() {
        return a("");
    }

    public void a(c cVar) {
        this.c = cVar;
    }

    public void a(Object obj) {
        if (obj instanceof Number) {
            try {
                this.d = ((Number) obj).longValue();
            } catch (Throwable unused) {
            }
        }
    }

    public Map<String, Object> a(String str) {
        HashMap map = new HashMap(this.f38367a);
        map.put("message", o.b(str));
        c cVar = this.c;
        if (cVar != null) {
            map.putAll(cVar.g());
        }
        a aVar = this.b;
        if (aVar != null) {
            map.putAll(aVar.a());
        }
        map.put("click_up_ms", Long.valueOf(this.d));
        return map;
    }

    public k a() {
        return this.e;
    }
}
