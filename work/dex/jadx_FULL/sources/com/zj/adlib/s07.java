package com.zj.adlib;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.core.ExecutorSupplier;
import com.facebook.imagepipeline.decoder.ProgressiveJpegConfig;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.memory.ByteArrayPool;
import com.facebook.imagepipeline.memory.PooledByteBuffer;
import com.facebook.imagepipeline.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.producers.DecodeProducer;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.ThumbnailProducer;
import com.facebook.imagepipeline.producers.b;
import com.facebook.imagepipeline.producers.c;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class s07 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f44578a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ContentResolver f19467a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public AssetManager f19468a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Resources f19469a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final PlatformBitmapFactory f19470a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final CacheKeyFactory f19471a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final MemoryCache<CacheKey, PooledByteBuffer> f19472a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ExecutorSupplier f19473a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ProgressiveJpegConfig f19474a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ByteArrayPool f19475a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final PooledByteBufferFactory f19476a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final l11 f19477a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final z64 f19478a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f19479a;
    public final MemoryCache<CacheKey, CloseableImage> b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final l11 f19480b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final boolean f19481b;
    public final boolean c;

    public s07(Context context, ByteArrayPool byteArrayPool, z64 z64Var, ProgressiveJpegConfig progressiveJpegConfig, boolean z, boolean z2, ExecutorSupplier executorSupplier, PooledByteBufferFactory pooledByteBufferFactory, MemoryCache<CacheKey, CloseableImage> memoryCache, MemoryCache<CacheKey, PooledByteBuffer> memoryCache2, l11 l11Var, l11 l11Var2, CacheKeyFactory cacheKeyFactory, PlatformBitmapFactory platformBitmapFactory, boolean z3, int i) {
        this.f44578a = i;
        this.f19467a = context.getApplicationContext().getContentResolver();
        this.f19469a = context.getApplicationContext().getResources();
        this.f19468a = context.getApplicationContext().getAssets();
        this.f19475a = byteArrayPool;
        this.f19478a = z64Var;
        this.f19474a = progressiveJpegConfig;
        this.f19479a = z;
        this.f19481b = z2;
        this.f19473a = executorSupplier;
        this.f19476a = pooledByteBufferFactory;
        this.b = memoryCache;
        this.f19472a = memoryCache2;
        this.f19477a = l11Var;
        this.f19480b = l11Var2;
        this.f19471a = cacheKeyFactory;
        this.f19470a = platformBitmapFactory;
        this.c = z3;
    }

    public static l10 a(Producer<q13> producer) {
        return new l10(producer);
    }

    public static yz0 f(Producer<q13> producer, Producer<q13> producer2) {
        return new yz0(producer, producer2);
    }

    public static <T> c46<T> t() {
        return new c46<>();
    }

    public static <T> xx8<T> x(Producer<T> producer) {
        return new xx8<>(producer);
    }

    public zu9 A(Producer<q13> producer) {
        return new zu9(this.f19473a.d(), this.f19476a, producer);
    }

    public <T> j59<T> b(Producer<T> producer, k59 k59Var) {
        return new j59<>(producer, k59Var);
    }

    public iw0 c(Producer<rm1<CloseableImage>> producer) {
        return new iw0(this.b, this.f19471a, producer);
    }

    public kw0 d(Producer<rm1<CloseableImage>> producer) {
        return new kw0(this.f19471a, producer);
    }

    public lw0 e(Producer<rm1<CloseableImage>> producer) {
        return new lw0(this.b, this.f19471a, producer);
    }

    public u62 g() {
        return new u62(this.f19476a, this.c);
    }

    public DecodeProducer h(Producer<q13> producer) {
        return new DecodeProducer(this.f19475a, this.f19473a.b(), this.f19478a, this.f19474a, this.f19479a, this.f19481b, producer);
    }

    public bo2 i(Producer<q13> producer) {
        return new bo2(this.f19477a, this.f19480b, this.f19471a, producer, this.f44578a);
    }

    public o13 j(Producer<q13> producer) {
        return new o13(this.f19471a, producer);
    }

    public s13 k(Producer<q13> producer) {
        return new s13(this.f19472a, this.f19471a, producer);
    }

    public bz4 l() {
        return new bz4(this.f19473a.a(), this.f19476a, this.f19468a, this.c);
    }

    public ez4 m() {
        return new ez4(this.f19473a.a(), this.f19476a, this.f19467a, this.c);
    }

    public fz4 n() {
        return new fz4(this.f19473a.a(), this.f19476a, this.f19467a, this.c);
    }

    public hz4 o() {
        return new hz4(this.f19473a.a(), this.f19476a, this.f19467a);
    }

    public iz4 p() {
        return new iz4(this.f19473a.a(), this.f19476a, this.c);
    }

    public oz4 q() {
        return new oz4(this.f19473a.a(), this.f19476a, this.f19469a, this.c);
    }

    public rz4 r() {
        return new rz4(this.f19473a.a());
    }

    public b s(NetworkFetcher networkFetcher) {
        return new b(this.f19476a, this.f19475a, networkFetcher);
    }

    public uv6 u(Producer<rm1<CloseableImage>> producer) {
        return new uv6(this.b, this.f19471a, producer);
    }

    public vv6 v(Producer<rm1<CloseableImage>> producer) {
        return new vv6(producer, this.f19470a, this.f19473a.d());
    }

    public c w(Producer<q13> producer) {
        return new c(this.f19473a.d(), this.f19476a, producer);
    }

    public <T> f69<T> y(int i, Producer<T> producer) {
        return new f69<>(i, this.f19473a.e(), producer);
    }

    public m69 z(ThumbnailProducer<q13>[] thumbnailProducerArr) {
        return new m69(thumbnailProducerArr);
    }
}
