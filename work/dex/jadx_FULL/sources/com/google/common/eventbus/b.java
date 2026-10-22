package com.google.common.eventbus;

import com.google.common.base.i;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f32031a;
    public final Object b;

    public b(Object obj, Object obj2) {
        this.f32031a = i.E(obj);
        this.b = i.E(obj2);
    }

    public Object a() {
        return this.b;
    }

    public Object b() {
        return this.f32031a;
    }

    public String toString() {
        return com.google.common.base.e.c(this).f("source", this.f32031a).f("event", this.b).toString();
    }
}
