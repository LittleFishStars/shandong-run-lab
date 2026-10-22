package com.zj.adlib;

import java.lang.ref.SoftReference;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class f66<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SoftReference<T> f41607a = null;
    public SoftReference<T> b = null;
    public SoftReference<T> c = null;

    public void a() {
        SoftReference<T> softReference = this.f41607a;
        if (softReference != null) {
            softReference.clear();
            this.f41607a = null;
        }
        SoftReference<T> softReference2 = this.b;
        if (softReference2 != null) {
            softReference2.clear();
            this.b = null;
        }
        SoftReference<T> softReference3 = this.c;
        if (softReference3 != null) {
            softReference3.clear();
            this.c = null;
        }
    }

    @Nullable
    public T b() {
        SoftReference<T> softReference = this.f41607a;
        if (softReference == null) {
            return null;
        }
        return softReference.get();
    }

    public void c(@Nonnull T t) {
        this.f41607a = new SoftReference<>(t);
        this.b = new SoftReference<>(t);
        this.c = new SoftReference<>(t);
    }
}
