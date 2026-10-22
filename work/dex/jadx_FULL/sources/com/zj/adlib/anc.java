package com.zj.adlib;

import com.google.android.gms.internal.mlkit_vision_barcode.zzev;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class anc implements zzev {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final zzev f40564a = new anc(null);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Logger f15306a = Logger.getLogger(anc.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Object f15307a;

    public anc(Object obj) {
        this.f15307a = obj;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzev
    public final void b(Runnable runnable, Executor executor) {
        throw null;
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        return false;
    }

    @Override // java.util.concurrent.Future
    public final Object get() {
        return this.f15307a;
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j, TimeUnit timeUnit) throws ExecutionException {
        timeUnit.getClass();
        return this.f15307a;
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return true;
    }

    public final String toString() {
        return super.toString() + "[status=SUCCESS, result=[" + String.valueOf(this.f15307a) + "]]";
    }
}
