package com.zj.adlib;

import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.imagepipeline.memory.PoolStatsTracker;
import javax.annotation.concurrent.Immutable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Immutable
public class lu6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MemoryTrimmableRegistry f43152a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final PoolStatsTracker f18049a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final nu6 f18050a;
    public final PoolStatsTracker b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final nu6 f18051b;
    public final PoolStatsTracker c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final nu6 f18052c;
    public final nu6 d;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public MemoryTrimmableRegistry f43153a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public PoolStatsTracker f18053a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public nu6 f18054a;
        public PoolStatsTracker b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public nu6 f18055b;
        public PoolStatsTracker c;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        public nu6 f18056c;
        public nu6 d;

        public lu6 i() {
            return new lu6(this);
        }

        public b j(nu6 nu6Var) {
            this.f18054a = (nu6) ax6.i(nu6Var);
            return this;
        }

        public b k(PoolStatsTracker poolStatsTracker) {
            this.f18053a = (PoolStatsTracker) ax6.i(poolStatsTracker);
            return this;
        }

        public b l(nu6 nu6Var) {
            this.f18055b = nu6Var;
            return this;
        }

        public b m(MemoryTrimmableRegistry memoryTrimmableRegistry) {
            this.f43153a = memoryTrimmableRegistry;
            return this;
        }

        public b n(nu6 nu6Var) {
            this.f18056c = (nu6) ax6.i(nu6Var);
            return this;
        }

        public b o(PoolStatsTracker poolStatsTracker) {
            this.b = (PoolStatsTracker) ax6.i(poolStatsTracker);
            return this;
        }

        public b p(nu6 nu6Var) {
            this.d = (nu6) ax6.i(nu6Var);
            return this;
        }

        public b q(PoolStatsTracker poolStatsTracker) {
            this.c = (PoolStatsTracker) ax6.i(poolStatsTracker);
            return this;
        }

        public b() {
        }
    }

    public static b i() {
        return new b();
    }

    public nu6 a() {
        return this.f18050a;
    }

    public PoolStatsTracker b() {
        return this.f18049a;
    }

    public nu6 c() {
        return this.f18051b;
    }

    public MemoryTrimmableRegistry d() {
        return this.f43152a;
    }

    public nu6 e() {
        return this.f18052c;
    }

    public PoolStatsTracker f() {
        return this.b;
    }

    public nu6 g() {
        return this.d;
    }

    public PoolStatsTracker h() {
        return this.c;
    }

    public lu6(b bVar) {
        this.f18050a = bVar.f18054a == null ? ue2.a() : bVar.f18054a;
        this.f18049a = bVar.f18053a == null ? oz5.h() : bVar.f18053a;
        this.f18051b = bVar.f18055b == null ? gg2.b() : bVar.f18055b;
        this.f43152a = bVar.f43153a == null ? nz5.c() : bVar.f43153a;
        this.f18052c = bVar.f18056c == null ? fh2.a() : bVar.f18056c;
        this.b = bVar.b == null ? oz5.h() : bVar.b;
        this.d = bVar.d == null ? ve2.a() : bVar.d;
        this.c = bVar.c == null ? oz5.h() : bVar.c;
    }
}
