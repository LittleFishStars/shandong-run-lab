package com.zj.adlib;

import com.facebook.imagepipeline.core.ExecutorSupplier;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class yf2 implements ExecutorSupplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f46021a = 2;
    public static final int b = 1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Executor f20847a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Executor f20848b;
    public final Executor c;
    public final Executor d;

    public yf2(int i) {
        ty6 ty6Var = new ty6(10);
        this.f20847a = Executors.newFixedThreadPool(2);
        this.f20848b = Executors.newFixedThreadPool(i, ty6Var);
        this.c = Executors.newFixedThreadPool(i, ty6Var);
        this.d = Executors.newFixedThreadPool(1, ty6Var);
    }

    @Override // com.facebook.imagepipeline.core.ExecutorSupplier
    public Executor a() {
        return this.f20847a;
    }

    @Override // com.facebook.imagepipeline.core.ExecutorSupplier
    public Executor b() {
        return this.f20848b;
    }

    @Override // com.facebook.imagepipeline.core.ExecutorSupplier
    public Executor c() {
        return this.f20847a;
    }

    @Override // com.facebook.imagepipeline.core.ExecutorSupplier
    public Executor d() {
        return this.c;
    }

    @Override // com.facebook.imagepipeline.core.ExecutorSupplier
    public Executor e() {
        return this.d;
    }
}
