package com.google.android.exoplayer2.upstream.cache;

import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.zj.adlib.aa1;
import com.zj.adlib.wu1;
import java.io.File;
import java.io.IOException;
import java.util.NavigableSet;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface Cache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f31130a = -1;

    public static class CacheException extends IOException {
        public CacheException(String str) {
            super(str);
        }

        public CacheException(Throwable th) {
            super(th);
        }

        public CacheException(String str, Throwable th) {
            super(str, th);
        }
    }

    public interface Listener {
        void a(Cache cache, aa1 aa1Var);

        void b(Cache cache, aa1 aa1Var);

        void c(Cache cache, aa1 aa1Var, aa1 aa1Var2);
    }

    @Nullable
    @WorkerThread
    aa1 a(String str, long j, long j2) throws CacheException;

    NavigableSet<aa1> b(String str, Listener listener);

    ContentMetadata c(String str);

    @WorkerThread
    void commitFile(File file, long j) throws CacheException;

    void d(String str, Listener listener);

    void e(aa1 aa1Var);

    @WorkerThread
    void f(String str, wu1 wu1Var) throws CacheException;

    @WorkerThread
    aa1 g(String str, long j, long j2) throws InterruptedException, CacheException;

    long getCacheSpace();

    long getCachedBytes(String str, long j, long j2);

    long getCachedLength(String str, long j, long j2);

    NavigableSet<aa1> getCachedSpans(String str);

    Set<String> getKeys();

    long getUid();

    @WorkerThread
    void h(aa1 aa1Var);

    boolean isCached(String str, long j, long j2);

    @WorkerThread
    void release();

    @WorkerThread
    void removeResource(String str);

    @WorkerThread
    File startFile(String str, long j, long j2) throws CacheException;
}
