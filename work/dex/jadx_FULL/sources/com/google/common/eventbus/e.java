package com.google.common.eventbus;

import com.google.common.base.i;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f32036a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Object f6252a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Method f6253a;
    public final Object b;

    public e(c cVar, Object obj, Object obj2, Method method) {
        this.f32036a = (c) i.E(cVar);
        this.f6252a = i.E(obj);
        this.b = i.E(obj2);
        this.f6253a = (Method) i.E(method);
    }

    public Object a() {
        return this.f6252a;
    }

    public c b() {
        return this.f32036a;
    }

    public Object c() {
        return this.b;
    }

    public Method d() {
        return this.f6253a;
    }
}
