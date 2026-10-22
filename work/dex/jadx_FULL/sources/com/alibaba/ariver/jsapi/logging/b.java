package com.alibaba.ariver.jsapi.logging;

import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.kernel.RVConstants;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b {
    private String b;
    private Long c;
    private String d = "";
    private Map<String, Long> e = new ConcurrentHashMap();
    private Map<String, Object> f = new ConcurrentHashMap();
    private Map<String, Object> g = new ConcurrentHashMap();
    private Map<String, Object> h = new ConcurrentHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f24155a = false;

    public void a(String str, String str2, Map<String, Object> map, Map<String, Object> map2, long j, List<String> list) {
        if ((list == null || !list.contains(str)) && this.e.containsKey(str)) {
            return;
        }
        if (this.f.isEmpty() && map != null) {
            this.f.putAll(map);
            a.a("pageUrl", str2, this.f);
        }
        if (map2 != null) {
            this.g.putAll(map2);
        }
        a.a(str, Long.valueOf(j), this.e);
    }

    public void b(String str) {
        this.d = str;
    }

    public Map<String, Object> c() {
        return this.f;
    }

    public Map<String, Object> d() {
        return this.g;
    }

    public Map<String, Object> e() {
        return this.h;
    }

    public void f() {
        this.e.clear();
        this.f.clear();
        this.g.clear();
        this.h.clear();
    }

    public void b(String str, Map<String, String> map) {
        if (map == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.h.put(str, map);
    }

    public Map<String, Long> b() {
        return this.e;
    }

    public void a(String str) {
        this.b = str;
        a.a("appId", str, this.f);
    }

    public void a(Long l) {
        this.c = l;
        a.a(RVConstants.EXTRA_START_TOKEN, l, this.f);
    }

    public String a() {
        return this.d;
    }

    public void a(String str, String str2) {
        this.g.put(str, str2);
    }

    public void a(String str, Map<String, String> map) {
        if (map == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.g.put(str, map);
    }

    public void a(App app) {
        a.a(app, this.f);
    }
}
