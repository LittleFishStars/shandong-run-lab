package com.beizi.fusion;

import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class x4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List f28022a;
    private String b;

    public List a() {
        return this.f28022a;
    }

    public String b() {
        return this.b;
    }

    public String toString() {
        return "{\"version\":\"" + this.b + "\", \"list\":" + oo.a(this.f28022a) + '}';
    }

    public void a(List list) {
        this.f28022a = list;
    }

    public void a(String str) {
        this.b = str;
    }
}
