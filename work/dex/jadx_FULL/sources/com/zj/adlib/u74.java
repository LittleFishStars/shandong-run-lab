package com.zj.adlib;

import android.content.Context;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.disk.DiskStorage;
import com.facebook.cache.disk.FileCache;
import com.facebook.cache.disk.b;
import com.facebook.imagepipeline.animated.factory.AnimatedFactory;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.cache.a;
import com.facebook.imagepipeline.cache.c;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.memory.PooledByteBuffer;
import com.facebook.imagepipeline.platform.PlatformDecoder;
import javax.annotation.concurrent.NotThreadSafe;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@NotThreadSafe
public class u74 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static u74 f45080a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public FileCache f19985a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public AnimatedFactory f19986a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public PlatformBitmapFactory f19987a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public CountingMemoryCache<CacheKey, CloseableImage> f19988a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public MemoryCache<CacheKey, CloseableImage> f19989a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public PlatformDecoder f19990a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final k59 f19991a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public l11 f19992a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public s07 f19993a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public s74 f19994a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final t74 f19995a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public u07 f19996a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public z64 f19997a;
    public FileCache b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public CountingMemoryCache<CacheKey, PooledByteBuffer> f19998b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public MemoryCache<CacheKey, PooledByteBuffer> f19999b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public l11 f20000b;

    public u74(t74 t74Var) {
        this.f19995a = (t74) ax6.i(t74Var);
        this.f19991a = new k59(t74Var.g().e());
    }

    @Deprecated
    public static b a(ao2 ao2Var, DiskStorage diskStorage) {
        return do2.b(ao2Var, diskStorage);
    }

    public static PlatformBitmapFactory b(mu6 mu6Var, PlatformDecoder platformDecoder) {
        return new kb0(mu6Var.a());
    }

    public static PlatformDecoder c(mu6 mu6Var, boolean z, boolean z2) {
        return new lb0(mu6Var.a(), mu6Var.c());
    }

    public static u74 k() {
        return (u74) ax6.j(f45080a, "ImagePipelineFactory was not initialized!");
    }

    public static void v(Context context) {
        w(t74.z(context).z());
    }

    public static void w(t74 t74Var) {
        f45080a = new u74(t74Var);
    }

    public static void x() {
        u74 u74Var = f45080a;
        if (u74Var != null) {
            u74Var.f().c(a60.b());
            f45080a.h().c(a60.b());
            f45080a = null;
        }
    }

    public AnimatedFactory d() {
        if (this.f19986a == null) {
            this.f19986a = o60.a(o(), this.f19995a.g());
        }
        return this.f19986a;
    }

    public CountingMemoryCache<CacheKey, CloseableImage> e() {
        if (this.f19988a == null) {
            this.f19988a = a.a(this.f19995a.c(), this.f19995a.n());
        }
        return this.f19988a;
    }

    public MemoryCache<CacheKey, CloseableImage> f() {
        if (this.f19989a == null) {
            this.f19989a = hw0.a(e(), this.f19995a.j());
        }
        return this.f19989a;
    }

    public CountingMemoryCache<CacheKey, PooledByteBuffer> g() {
        if (this.f19998b == null) {
            this.f19998b = c.a(this.f19995a.f(), this.f19995a.n());
        }
        return this.f19998b;
    }

    public MemoryCache<CacheKey, PooledByteBuffer> h() {
        if (this.f19999b == null) {
            this.f19999b = r13.a(g(), this.f19995a.j());
        }
        return this.f19999b;
    }

    public final z64 i() {
        if (this.f19997a == null) {
            if (this.f19995a.k() != null) {
                this.f19997a = this.f19995a.k();
            } else {
                this.f19997a = new z64(d() != null ? d().a() : null, p(), this.f19995a.b());
            }
        }
        return this.f19997a;
    }

    public s74 j() {
        if (this.f19994a == null) {
            this.f19994a = new s74(r(), this.f19995a.s(), this.f19995a.l(), f(), h(), l(), s(), this.f19995a.d(), this.f19991a);
        }
        return this.f19994a;
    }

    public final l11 l() {
        if (this.f19992a == null) {
            this.f19992a = new l11(n(), this.f19995a.q().e(), this.f19995a.q().f(), this.f19995a.g().a(), this.f19995a.g().c(), this.f19995a.j());
        }
        return this.f19992a;
    }

    @Deprecated
    public FileCache m() {
        return n();
    }

    public FileCache n() {
        if (this.f19985a == null) {
            this.f19985a = this.f19995a.h().a(this.f19995a.m());
        }
        return this.f19985a;
    }

    public PlatformBitmapFactory o() {
        if (this.f19987a == null) {
            this.f19987a = b(this.f19995a.q(), p());
        }
        return this.f19987a;
    }

    public PlatformDecoder p() {
        if (this.f19990a == null) {
            this.f19990a = c(this.f19995a.q(), this.f19995a.v(), this.f19995a.y());
        }
        return this.f19990a;
    }

    public final s07 q() {
        if (this.f19993a == null) {
            this.f19993a = new s07(this.f19995a.getContext(), this.f19995a.q().h(), i(), this.f19995a.r(), this.f19995a.w(), this.f19995a.x(), this.f19995a.g(), this.f19995a.q().e(), f(), h(), l(), s(), this.f19995a.d(), o(), this.f19995a.u(), this.f19995a.i());
        }
        return this.f19993a;
    }

    public final u07 r() {
        if (this.f19996a == null) {
            this.f19996a = new u07(q(), this.f19995a.o(), this.f19995a.x(), this.f19995a.w(), this.f19995a.y(), this.f19991a);
        }
        return this.f19996a;
    }

    public final l11 s() {
        if (this.f20000b == null) {
            this.f20000b = new l11(u(), this.f19995a.q().e(), this.f19995a.q().f(), this.f19995a.g().a(), this.f19995a.g().c(), this.f19995a.j());
        }
        return this.f20000b;
    }

    @Deprecated
    public FileCache t() {
        return u();
    }

    public FileCache u() {
        if (this.b == null) {
            this.b = this.f19995a.h().a(this.f19995a.t());
        }
        return this.b;
    }
}
