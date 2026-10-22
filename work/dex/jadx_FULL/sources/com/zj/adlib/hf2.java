package com.zj.adlib;

import android.util.SparseArray;
import com.google.android.exoplayer2.g;
import com.google.android.exoplayer2.offline.DownloadRequest;
import com.google.android.exoplayer2.offline.Downloader;
import com.google.android.exoplayer2.offline.DownloaderFactory;
import com.google.android.exoplayer2.offline.b;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource;
import java.lang.reflect.Constructor;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class hf2 implements DownloaderFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SparseArray<Constructor<? extends Downloader>> f42114a = c();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final CacheDataSource.b f16978a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Executor f16979a;

    @Deprecated
    public hf2(CacheDataSource.b bVar) {
        this(bVar, new z07());
    }

    public static SparseArray<Constructor<? extends Downloader>> c() {
        SparseArray<Constructor<? extends Downloader>> sparseArray = new SparseArray<>();
        try {
            sparseArray.put(0, d(b62.class));
        } catch (ClassNotFoundException unused) {
        }
        try {
            sparseArray.put(2, d(q04.class));
        } catch (ClassNotFoundException unused2) {
        }
        try {
            sparseArray.put(1, d(zo8.class));
        } catch (ClassNotFoundException unused3) {
        }
        return sparseArray;
    }

    public static Constructor<? extends Downloader> d(Class<?> cls) {
        try {
            return cls.asSubclass(Downloader.class).getConstructor(g.class, CacheDataSource.b.class, Executor.class);
        } catch (NoSuchMethodException e) {
            throw new IllegalStateException("Downloader constructor missing", e);
        }
    }

    @Override // com.google.android.exoplayer2.offline.DownloaderFactory
    public Downloader a(DownloadRequest downloadRequest) {
        int iF0 = gj9.F0(downloadRequest.uri, downloadRequest.mimeType);
        if (iF0 == 0 || iF0 == 1 || iF0 == 2) {
            return b(downloadRequest, iF0);
        }
        if (iF0 == 4) {
            return new b(new g.c().L(downloadRequest.uri).l(downloadRequest.customCacheKey).a(), this.f16978a, this.f16979a);
        }
        throw new IllegalArgumentException("Unsupported type: " + iF0);
    }

    public final Downloader b(DownloadRequest downloadRequest, int i) {
        Constructor<? extends Downloader> constructor = f42114a.get(i);
        if (constructor == null) {
            throw new IllegalStateException("Module missing for content type " + i);
        }
        try {
            return constructor.newInstance(new g.c().L(downloadRequest.uri).H(downloadRequest.streamKeys).l(downloadRequest.customCacheKey).a(), this.f16978a, this.f16979a);
        } catch (Exception unused) {
            throw new IllegalStateException("Failed to instantiate downloader for content type " + i);
        }
    }

    public hf2(CacheDataSource.b bVar, Executor executor) {
        this.f16978a = (CacheDataSource.b) sb0.g(bVar);
        this.f16979a = (Executor) sb0.g(executor);
    }
}
