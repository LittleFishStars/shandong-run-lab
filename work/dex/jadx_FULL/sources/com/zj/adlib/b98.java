package com.zj.adlib;

import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.memory.MemoryTrimmable;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.references.ResourceReleaser;
import java.util.concurrent.Semaphore;
import javax.annotation.concurrent.ThreadSafe;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@ThreadSafe
public class b98 implements MemoryTrimmable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    public final int f40701a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ResourceReleaser<byte[]> f15468a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @VisibleForTesting
    public final f66<byte[]> f15469a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @VisibleForTesting
    public final Semaphore f15470a;

    @VisibleForTesting
    public final int b;

    public class a implements ResourceReleaser<byte[]> {
        public a() {
        }

        @Override // com.facebook.common.references.ResourceReleaser
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(byte[] bArr) {
            b98.this.f15470a.release();
        }
    }

    public b98(MemoryTrimmableRegistry memoryTrimmableRegistry, nu6 nu6Var) {
        ax6.i(memoryTrimmableRegistry);
        ax6.d(nu6Var.c > 0);
        ax6.d(nu6Var.d >= nu6Var.c);
        this.b = nu6Var.d;
        this.f40701a = nu6Var.c;
        this.f15469a = new f66<>();
        this.f15470a = new Semaphore(1);
        this.f15468a = new a();
        memoryTrimmableRegistry.b(this);
    }

    public final synchronized byte[] b(int i) {
        byte[] bArr;
        this.f15469a.a();
        bArr = new byte[i];
        this.f15469a.c(bArr);
        return bArr;
    }

    public rm1<byte[]> c(int i) {
        ax6.e(i > 0, "Size must be greater than zero");
        ax6.e(i <= this.b, "Requested size is too big");
        this.f15470a.acquireUninterruptibly();
        try {
            return rm1.J(f(i), this.f15468a);
        } catch (Throwable th) {
            this.f15470a.release();
            throw i69.d(th);
        }
    }

    @Override // com.facebook.common.memory.MemoryTrimmable
    public void d(MemoryTrimType memoryTrimType) {
        if (this.f15470a.tryAcquire()) {
            try {
                this.f15469a.a();
            } finally {
                this.f15470a.release();
            }
        }
    }

    @VisibleForTesting
    public int e(int i) {
        return Integer.highestOneBit(Math.max(i, this.f40701a) - 1) * 2;
    }

    public final byte[] f(int i) {
        int iE = e(i);
        byte[] bArrB = this.f15469a.b();
        return (bArrB == null || bArrB.length < iE) ? b(iE) : bArrB;
    }
}
