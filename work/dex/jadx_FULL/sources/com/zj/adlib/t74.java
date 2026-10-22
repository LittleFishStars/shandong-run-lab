package com.zj.adlib;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import com.byazt.hv.TTDownloadField;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.imagepipeline.animated.factory.AnimatedImageFactory;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.ImageCacheStatsTracker;
import com.facebook.imagepipeline.core.DiskStorageFactory;
import com.facebook.imagepipeline.core.ExecutorSupplier;
import com.facebook.imagepipeline.core.FileCacheFactory;
import com.facebook.imagepipeline.decoder.ProgressiveJpegConfig;
import com.facebook.imagepipeline.decoder.SimpleProgressiveJpegConfig;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class t74 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f44862a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f19720a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Bitmap.Config f19721a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Supplier<ul5> f19722a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final MemoryTrimmableRegistry f19723a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final AnimatedImageFactory f19724a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final PlatformBitmapFactory f19725a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final CacheKeyFactory f19726a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ImageCacheStatsTracker f19727a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ExecutorSupplier f19728a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final FileCacheFactory f19729a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ProgressiveJpegConfig f19730a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final NetworkFetcher f19731a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ao2 f19732a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final mu6 f19733a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final z64 f19734a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Set<RequestListener> f19735a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f19736a;
    public final Supplier<ul5> b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final ao2 f19737b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final boolean f19738b;
    public final Supplier<Boolean> c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final boolean f19739c;
    public final boolean d;
    public final boolean e;

    public class a implements Supplier<Boolean> {
        public a() {
        }

        @Override // com.facebook.common.internal.Supplier
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean get() {
            return Boolean.TRUE;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f44864a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Context f19740a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Bitmap.Config f19741a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Supplier<ul5> f19742a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public MemoryTrimmableRegistry f19743a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public AnimatedImageFactory f19744a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public PlatformBitmapFactory f19745a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public CacheKeyFactory f19746a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public ImageCacheStatsTracker f19747a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public ExecutorSupplier f19748a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public FileCacheFactory f19749a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public ProgressiveJpegConfig f19750a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public NetworkFetcher f19751a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public ao2 f19752a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public mu6 f19753a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public z64 f19754a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Set<RequestListener> f19755a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f19756a;
        public Supplier<ul5> b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public ao2 f19757b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public boolean f19758b;
        public Supplier<Boolean> c;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        public boolean f19759c;
        public boolean d;
        public boolean e;

        public /* synthetic */ b(Context context, a aVar) {
            this(context);
        }

        public b A(AnimatedImageFactory animatedImageFactory) {
            this.f19744a = animatedImageFactory;
            return this;
        }

        public b B(Supplier<ul5> supplier) {
            this.f19742a = (Supplier) ax6.i(supplier);
            return this;
        }

        public b C(Bitmap.Config config) {
            this.f19741a = config;
            return this;
        }

        public b D(CacheKeyFactory cacheKeyFactory) {
            this.f19746a = cacheKeyFactory;
            return this;
        }

        public b E(boolean z) {
            this.f19759c = z;
            return this;
        }

        public b F(boolean z) {
            this.d = z;
            return this;
        }

        @Deprecated
        public b G(DiskStorageFactory diskStorageFactory) {
            K(new do2(diskStorageFactory));
            return this;
        }

        public b H(boolean z) {
            this.f19756a = z;
            return this;
        }

        public b I(Supplier<ul5> supplier) {
            this.b = (Supplier) ax6.i(supplier);
            return this;
        }

        public b J(ExecutorSupplier executorSupplier) {
            this.f19748a = executorSupplier;
            return this;
        }

        public b K(FileCacheFactory fileCacheFactory) {
            this.f19749a = fileCacheFactory;
            return this;
        }

        public b L(int i) {
            this.f44864a = i;
            return this;
        }

        public b M(ImageCacheStatsTracker imageCacheStatsTracker) {
            this.f19747a = imageCacheStatsTracker;
            return this;
        }

        public b N(z64 z64Var) {
            this.f19754a = z64Var;
            return this;
        }

        public b O(Supplier<Boolean> supplier) {
            this.c = supplier;
            return this;
        }

        public b P(ao2 ao2Var) {
            this.f19752a = ao2Var;
            return this;
        }

        public b Q(MemoryTrimmableRegistry memoryTrimmableRegistry) {
            this.f19743a = memoryTrimmableRegistry;
            return this;
        }

        public b R(NetworkFetcher networkFetcher) {
            this.f19751a = networkFetcher;
            return this;
        }

        public b S(PlatformBitmapFactory platformBitmapFactory) {
            this.f19745a = platformBitmapFactory;
            return this;
        }

        public b T(mu6 mu6Var) {
            this.f19753a = mu6Var;
            return this;
        }

        public b U(ProgressiveJpegConfig progressiveJpegConfig) {
            this.f19750a = progressiveJpegConfig;
            return this;
        }

        public b V(Set<RequestListener> set) {
            this.f19755a = set;
            return this;
        }

        public b W(boolean z) {
            this.e = z;
            return this;
        }

        public b X(ao2 ao2Var) {
            this.f19757b = ao2Var;
            return this;
        }

        public b Y(boolean z) {
            this.f19758b = z;
            return this;
        }

        public t74 z() {
            return new t74(this, null);
        }

        public b(Context context) {
            this.f19756a = false;
            this.f19758b = false;
            this.f19759c = false;
            this.f44864a = 0;
            this.e = true;
            this.f19740a = (Context) ax6.i(context);
        }
    }

    public /* synthetic */ t74(b bVar, a aVar) {
        this(bVar);
    }

    public static ao2 e(Context context) {
        return ao2.k(context).l();
    }

    public static b z(Context context) {
        return new b(context, null);
    }

    @Nullable
    public AnimatedImageFactory a() {
        return this.f19724a;
    }

    public Bitmap.Config b() {
        return this.f19721a;
    }

    public Supplier<ul5> c() {
        return this.f19722a;
    }

    public CacheKeyFactory d() {
        return this.f19726a;
    }

    public Supplier<ul5> f() {
        return this.b;
    }

    public ExecutorSupplier g() {
        return this.f19728a;
    }

    public Context getContext() {
        return this.f19720a;
    }

    public FileCacheFactory h() {
        return this.f19729a;
    }

    public int i() {
        return this.f44862a;
    }

    public ImageCacheStatsTracker j() {
        return this.f19727a;
    }

    @Nullable
    public z64 k() {
        return this.f19734a;
    }

    public Supplier<Boolean> l() {
        return this.c;
    }

    public ao2 m() {
        return this.f19732a;
    }

    public MemoryTrimmableRegistry n() {
        return this.f19723a;
    }

    public NetworkFetcher o() {
        return this.f19731a;
    }

    @Nullable
    public PlatformBitmapFactory p() {
        return this.f19725a;
    }

    public mu6 q() {
        return this.f19733a;
    }

    public ProgressiveJpegConfig r() {
        return this.f19730a;
    }

    public Set<RequestListener> s() {
        return Collections.unmodifiableSet(this.f19735a);
    }

    public ao2 t() {
        return this.f19737b;
    }

    public boolean u() {
        return this.f19739c;
    }

    public boolean v() {
        return this.d;
    }

    public boolean w() {
        return this.f19736a;
    }

    public boolean x() {
        return this.e;
    }

    public boolean y() {
        return this.f19738b;
    }

    public t74(b bVar) {
        this.f19724a = bVar.f19744a;
        this.f19722a = bVar.f19742a == null ? new te2((ActivityManager) bVar.f19740a.getSystemService(TTDownloadField.TT_ACTIVITY)) : bVar.f19742a;
        this.f19721a = bVar.f19741a == null ? Bitmap.Config.ARGB_8888 : bVar.f19741a;
        this.f19726a = bVar.f19746a == null ? ye2.d() : bVar.f19746a;
        this.f19720a = (Context) ax6.i(bVar.f19740a);
        this.f19739c = bVar.f19756a && bVar.f19759c;
        this.d = bVar.d;
        this.f19729a = bVar.f19749a == null ? new do2(new qt2()) : bVar.f19749a;
        this.f19736a = bVar.f19756a;
        this.f19738b = bVar.f19758b && yu9.d;
        this.b = bVar.b == null ? new wf2() : bVar.b;
        this.f44862a = bVar.f44864a;
        this.f19727a = bVar.f19747a == null ? mz5.n() : bVar.f19747a;
        this.f19734a = bVar.f19754a;
        this.c = bVar.c == null ? new a() : bVar.c;
        ao2 ao2VarE = bVar.f19752a == null ? e(bVar.f19740a) : bVar.f19752a;
        this.f19732a = ao2VarE;
        this.f19723a = bVar.f19743a == null ? nz5.c() : bVar.f19743a;
        this.f19731a = bVar.f19751a == null ? new com.facebook.imagepipeline.producers.a() : bVar.f19751a;
        this.f19725a = bVar.f19745a;
        mu6 mu6Var = bVar.f19753a == null ? new mu6(lu6.i().i()) : bVar.f19753a;
        this.f19733a = mu6Var;
        this.f19730a = bVar.f19750a == null ? new SimpleProgressiveJpegConfig() : bVar.f19750a;
        this.f19735a = bVar.f19755a == null ? new HashSet<>() : bVar.f19755a;
        this.e = bVar.e;
        this.f19737b = bVar.f19757b != null ? bVar.f19757b : ao2VarE;
        this.f19728a = bVar.f19748a == null ? new yf2(mu6Var.c()) : bVar.f19748a;
    }
}
