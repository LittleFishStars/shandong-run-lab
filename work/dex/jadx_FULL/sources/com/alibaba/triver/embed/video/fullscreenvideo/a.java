package com.alibaba.triver.embed.video.fullscreenvideo;

import java.util.HashMap;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f24863a = "URL_KEY_DEFAULT";
    public int b;
    public LinkedHashMap c;
    public String d;
    public HashMap e;
    public boolean f;
    public Object[] g;

    public a(String str) {
        this.c = new LinkedHashMap();
        this.d = "";
        this.e = new HashMap();
        this.f = false;
        this.c.put(f24863a, str);
        this.b = 0;
    }

    public Object a() {
        return b(this.b);
    }

    public Object b() {
        return a(this.b);
    }

    public String a(int i) {
        int i2 = 0;
        for (Object obj : this.c.keySet()) {
            if (i2 == i) {
                return obj.toString();
            }
            i2++;
        }
        return null;
    }

    public Object b(int i) {
        int i2 = 0;
        for (Object obj : this.c.keySet()) {
            if (i2 == i) {
                return this.c.get(obj);
            }
            i2++;
        }
        return null;
    }

    public boolean a(Object obj) {
        if (obj != null) {
            return this.c.containsValue(obj);
        }
        return false;
    }

    public a(String str, String str2, boolean z) {
        this.c = new LinkedHashMap();
        this.d = "";
        this.e = new HashMap();
        this.f = false;
        this.c.put(f24863a, str);
        this.d = str2;
        this.b = 0;
        this.f = z;
    }

    public a(String str, String str2) {
        this.c = new LinkedHashMap();
        this.d = "";
        this.e = new HashMap();
        this.f = false;
        this.c.put(f24863a, str);
        this.d = str2;
        this.b = 0;
    }

    public a(Object obj) {
        this.c = new LinkedHashMap();
        this.d = "";
        this.e = new HashMap();
        this.f = false;
        this.c.put(f24863a, obj);
        this.b = 0;
    }

    public a(LinkedHashMap linkedHashMap) {
        this.c = new LinkedHashMap();
        this.d = "";
        this.e = new HashMap();
        this.f = false;
        this.c.clear();
        this.c.putAll(linkedHashMap);
        this.b = 0;
    }

    public a(LinkedHashMap linkedHashMap, String str) {
        this.c = new LinkedHashMap();
        this.d = "";
        this.e = new HashMap();
        this.f = false;
        this.c.clear();
        this.c.putAll(linkedHashMap);
        this.d = str;
        this.b = 0;
    }
}
