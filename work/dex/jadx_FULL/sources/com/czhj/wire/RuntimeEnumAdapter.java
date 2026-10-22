package com.czhj.wire;

import com.czhj.wire.WireEnum;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
final class RuntimeEnumAdapter<E extends WireEnum> extends EnumAdapter<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class<E> f29514a;
    private Method b;

    public RuntimeEnumAdapter(Class<E> cls) {
        super(cls);
        this.f29514a = cls;
    }

    private Method a() {
        Method method = this.b;
        if (method != null) {
            return method;
        }
        try {
            Method method2 = this.f29514a.getMethod("fromValue", Integer.TYPE);
            this.b = method2;
            return method2;
        } catch (NoSuchMethodException e) {
            throw new AssertionError(e);
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof RuntimeEnumAdapter) && ((RuntimeEnumAdapter) obj).f29514a == this.f29514a;
    }

    @Override // com.czhj.wire.EnumAdapter
    public E fromValue(int i) {
        try {
            return (E) a().invoke(null, Integer.valueOf(i));
        } catch (Throwable th) {
            throw new AssertionError(th);
        }
    }

    public int hashCode() {
        return this.f29514a.hashCode();
    }
}
