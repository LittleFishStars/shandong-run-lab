package com.alibaba.ariver.websocket.core;

import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f24534a;
    private String b;
    private Map<String, String> c;
    private c d;

    public a(String str, String str2, Map<String, String> map, c cVar) {
        a();
        this.f24534a = str;
        this.b = str2;
        this.c = map;
        this.d = cVar;
    }

    public void a() {
    }

    public String b() {
        return this.f24534a;
    }

    public String c() {
        return this.b;
    }

    public Map<String, String> d() {
        return this.c;
    }

    public c e() {
        return this.d;
    }
}
