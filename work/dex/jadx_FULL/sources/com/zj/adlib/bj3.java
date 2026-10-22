package com.zj.adlib;

import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.imagepipeline.memory.BasePool;
import com.facebook.imagepipeline.memory.PoolStatsTracker;
import java.util.Map;
import javax.annotation.concurrent.ThreadSafe;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@ThreadSafe
public class bj3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ResourceReleaser<byte[]> f40760a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @VisibleForTesting
    public final b f15539a;

    public class a implements ResourceReleaser<byte[]> {
        public a() {
        }

        @Override // com.facebook.common.references.ResourceReleaser
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(byte[] bArr) {
            bj3.this.d(bArr);
        }
    }

    @VisibleForTesting
    public static class b extends com.facebook.imagepipeline.memory.a {
        public b(MemoryTrimmableRegistry memoryTrimmableRegistry, nu6 nu6Var, PoolStatsTracker poolStatsTracker) {
            super(memoryTrimmableRegistry, nu6Var, poolStatsTracker);
        }

        @Override // com.facebook.imagepipeline.memory.BasePool
        public t01<byte[]> j(int i) {
            return new g66(getSizeInBytes(i), ((BasePool) this).f1650a.e, 0);
        }
    }

    public bj3(MemoryTrimmableRegistry memoryTrimmableRegistry, nu6 nu6Var) {
        ax6.d(nu6Var.e > 0);
        this.f15539a = new b(memoryTrimmableRegistry, nu6Var, oz5.h());
        this.f40760a = new a();
    }

    public rm1<byte[]> a(int i) {
        return rm1.J(this.f15539a.get(i), this.f40760a);
    }

    public int b() {
        return this.f15539a.n();
    }

    public Map<String, Integer> c() {
        return this.f15539a.f();
    }

    public void d(byte[] bArr) {
        this.f15539a.a(bArr);
    }
}
