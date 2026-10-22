package com.alibaba.triver.preload.b.e;

import com.alibaba.fastjson.JSONArray;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONArray f25135a;
    private com.alibaba.triver.triver_worker.v8worker.jsi.d b;

    public c(com.alibaba.triver.triver_worker.v8worker.jsi.d dVar, JSONArray jSONArray) {
        this.b = dVar;
        this.f25135a = jSONArray;
    }

    public JSONArray a() {
        return this.f25135a;
    }

    public com.alibaba.triver.triver_worker.v8worker.jsi.d b() {
        return this.b;
    }

    public void a(JSONArray jSONArray) {
        this.f25135a = jSONArray;
    }

    public void a(com.alibaba.triver.triver_worker.v8worker.jsi.d dVar) {
        this.b = dVar;
    }
}
