package com.alipay.sdk.m.c0;

import java.util.Iterator;
import java.util.Stack;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Stack<e> f25420a = new Stack<>();

    public void a(e eVar) {
        this.f25420a.push(eVar);
    }

    public boolean b() {
        return this.f25420a.isEmpty();
    }

    public e c() {
        return this.f25420a.pop();
    }

    public void a() {
        if (b()) {
            return;
        }
        Iterator<e> it = this.f25420a.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
        this.f25420a.clear();
    }
}
