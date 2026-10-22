package com.fl.saas;

import androidx.arch.core.util.Function;
import java.util.NoSuchElementException;
import java.util.Objects;

/* JADX INFO: renamed from: com.fl.saas.p0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class C1428p0 {
    private static final C1428p0 b = new C1428p0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f30186a;

    private C1428p0() {
        this.f30186a = null;
    }

    public static C1428p0 a() {
        return b;
    }

    public Object b() {
        Object obj = this.f30186a;
        if (obj != null) {
            return obj;
        }
        throw new NoSuchElementException("No value present");
    }

    public boolean c() {
        return this.f30186a != null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C1428p0) {
            return Objects.equals(this.f30186a, ((C1428p0) obj).f30186a);
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(this.f30186a);
    }

    public String toString() {
        Object obj = this.f30186a;
        return obj != null ? String.format("Optional[%s]", obj) : "Optional.empty";
    }

    private C1428p0(Object obj) {
        Objects.requireNonNull(obj);
        this.f30186a = obj;
    }

    public static C1428p0 b(Object obj) {
        return obj == null ? a() : a(obj);
    }

    public C1428p0 a(InterfaceC1444x0 interfaceC1444x0) {
        Objects.requireNonNull(interfaceC1444x0);
        if (c() && !interfaceC1444x0.a(this.f30186a)) {
            return a();
        }
        return this;
    }

    public Object c(Object obj) {
        Object obj2 = this.f30186a;
        return obj2 != null ? obj2 : obj;
    }

    public void a(B b2) {
        Object obj = this.f30186a;
        if (obj != null) {
            b2.a(obj);
        }
    }

    public Object b(b1 b1Var) {
        Object obj = this.f30186a;
        return obj != null ? obj : b1Var.a();
    }

    public void a(B b2, Runnable runnable) {
        Object obj = this.f30186a;
        if (obj != null) {
            b2.a(obj);
        } else {
            runnable.run();
        }
    }

    public C1428p0 a(Function function) {
        Objects.requireNonNull(function);
        return !c() ? a() : b(function.apply(this.f30186a));
    }

    public static C1428p0 a(Object obj) {
        return new C1428p0(obj);
    }

    public C1428p0 a(b1 b1Var) {
        Objects.requireNonNull(b1Var);
        if (c()) {
            return this;
        }
        C1428p0 c1428p0 = (C1428p0) b1Var.a();
        Objects.requireNonNull(c1428p0);
        return c1428p0;
    }
}
