package com.facebook.cache.disk;

import com.facebook.binaryresource.BinaryResource;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheEventListener;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.WriterCallback;
import com.facebook.common.disk.DiskTrimmable;
import com.facebook.common.disk.DiskTrimmableRegistry;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.statfs.StatFsHelper;
import com.facebook.common.time.Clock;
import com.zj.adlib.ad3;
import com.zj.adlib.f38;
import com.zj.adlib.uy8;
import com.zj.adlib.xs5;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@ThreadSafe
public class b implements FileCache, DiskTrimmable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final double f29946a = 0.02d;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final int f1538a = 1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Class<?> f1539a = b.class;
    public static final long f = TimeUnit.HOURS.toMillis(2);
    public static final long g = TimeUnit.MINUTES.toMillis(30);
    public static final long h = -1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final long f1540a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final CacheErrorLogger f1541a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final CacheEventListener f1542a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DiskStorage f1543a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final EntryEvictionComparatorSupplier f1544a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final a f1545a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final StatFsHelper f1546a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Clock f1547a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Object f1548a = new Object();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @VisibleForTesting
    @GuardedBy("mLock")
    public final Map<CacheKey, String> f1549a;
    public final long b;
    public long c;

    @GuardedBy("mLock")
    public long d;
    public final long e;

    @VisibleForTesting
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f1550a = false;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f29947a = -1;
        public long b = -1;

        public synchronized long a() {
            return this.b;
        }

        public synchronized long b() {
            return this.f29947a;
        }

        public synchronized void c(long j, long j2) {
            if (this.f1550a) {
                this.f29947a += j;
                this.b += j2;
            }
        }

        public synchronized boolean d() {
            return this.f1550a;
        }

        public synchronized void e() {
            this.f1550a = false;
            this.b = -1L;
            this.f29947a = -1L;
        }

        public synchronized void f(long j, long j2) {
            this.b = j2;
            this.f29947a = j;
            this.f1550a = true;
        }
    }

    /* JADX INFO: renamed from: com.facebook.cache.disk.b$b, reason: collision with other inner class name */
    public static class C0634b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f29948a;
        public final long b;
        public final long c;

        public C0634b(long j, long j2, long j3) {
            this.f29948a = j;
            this.b = j2;
            this.c = j3;
        }
    }

    public b(DiskStorage diskStorage, EntryEvictionComparatorSupplier entryEvictionComparatorSupplier, C0634b c0634b, CacheEventListener cacheEventListener, CacheErrorLogger cacheErrorLogger, @Nullable DiskTrimmableRegistry diskTrimmableRegistry) {
        this.f1540a = c0634b.b;
        long j = c0634b.c;
        this.b = j;
        this.c = j;
        this.f1546a = StatFsHelper.c();
        this.f1543a = diskStorage;
        this.f1544a = entryEvictionComparatorSupplier;
        this.d = -1L;
        this.f1542a = cacheEventListener;
        this.e = c0634b.f29948a;
        this.f1541a = cacheErrorLogger;
        this.f1545a = new a();
        if (diskTrimmableRegistry != null) {
            diskTrimmableRegistry.b(this);
        }
        this.f1547a = uy8.a();
        this.f1549a = new HashMap();
    }

    @VisibleForTesting
    public static List<String> m(CacheKey cacheKey) {
        try {
            if (!(cacheKey instanceof xs5)) {
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(f38.f(cacheKey.toString().getBytes("UTF-8")));
                return arrayList;
            }
            List<CacheKey> listB = ((xs5) cacheKey).b();
            ArrayList arrayList2 = new ArrayList(listB.size());
            for (int i = 0; i < listB.size(); i++) {
                arrayList2.add(f38.f(listB.get(i).toString().getBytes("UTF-8")));
            }
            return arrayList2;
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // com.facebook.cache.disk.FileCache
    public DiskStorage.a a() throws IOException {
        return this.f1543a.a();
    }

    @Override // com.facebook.common.disk.DiskTrimmable
    public void b() {
        synchronized (this.f1548a) {
            p();
            long jB = this.f1545a.b();
            long j = this.e;
            if (j > 0 && jB > 0 && jB >= j) {
                double d = 1.0d - (j / jB);
                if (d > 0.02d) {
                    s(d);
                }
            }
        }
    }

    @Override // com.facebook.cache.disk.FileCache
    public long c(long j) {
        long j2;
        long jMax;
        synchronized (this.f1548a) {
            try {
                long jNow = this.f1547a.now();
                int i = 0;
                long j3 = 0;
                jMax = 0;
                for (DiskStorage.Entry entry : this.f1543a.e()) {
                    try {
                        long jMax2 = Math.max(1L, Math.abs(jNow - entry.getTimestamp()));
                        if (jMax2 >= j) {
                            long jH = this.f1543a.h(entry);
                            this.f1549a.values().remove(entry.getId());
                            if (jH > 0) {
                                i++;
                                j3 += jH;
                            }
                        } else {
                            jMax = Math.max(jMax, jMax2);
                        }
                    } catch (IOException e) {
                        e = e;
                        j2 = jMax;
                        this.f1541a.a(CacheErrorLogger.CacheErrorCategory.EVICTION, f1539a, "clearOldEntries: " + e.getMessage(), e);
                        jMax = j2;
                    }
                }
                this.f1543a.f();
                if (i > 0) {
                    p();
                    this.f1545a.c(-j3, -i);
                    q(CacheEventListener.EvictionReason.CONTENT_STALE, i, j3);
                }
            } catch (IOException e2) {
                e = e2;
                j2 = 0;
            }
        }
        return jMax;
    }

    @Override // com.facebook.cache.disk.FileCache
    public void clearAll() {
        synchronized (this.f1548a) {
            try {
                this.f1543a.clearAll();
                this.f1549a.clear();
            } catch (IOException e) {
                this.f1541a.a(CacheErrorLogger.CacheErrorCategory.EVICTION, f1539a, "clearAll: " + e.getMessage(), e);
            }
            this.f1545a.e();
        }
    }

    @Override // com.facebook.cache.disk.FileCache
    public boolean d(CacheKey cacheKey) {
        String str;
        boolean zG;
        synchronized (this.f1548a) {
            if (f(cacheKey)) {
                return true;
            }
            try {
                if (this.f1549a.containsKey(cacheKey)) {
                    str = this.f1549a.get(cacheKey);
                    zG = this.f1543a.g(str, cacheKey);
                } else {
                    List<String> listM = m(cacheKey);
                    String str2 = null;
                    boolean zG2 = false;
                    for (int i = 0; i < listM.size() && !(zG2 = this.f1543a.g((str2 = listM.get(i)), cacheKey)); i++) {
                    }
                    str = str2;
                    zG = zG2;
                }
                if (zG) {
                    this.f1549a.put(cacheKey, str);
                } else {
                    this.f1549a.remove(cacheKey);
                }
                return zG;
            } catch (IOException unused) {
                return false;
            }
        }
    }

    @Override // com.facebook.cache.disk.FileCache
    public void e(CacheKey cacheKey) {
        synchronized (this.f1548a) {
            try {
                if (this.f1549a.containsKey(cacheKey)) {
                    this.f1543a.d(this.f1549a.get(cacheKey));
                } else {
                    List<String> listM = m(cacheKey);
                    for (int i = 0; i < listM.size(); i++) {
                        this.f1543a.d(listM.get(i));
                    }
                }
                this.f1549a.remove(cacheKey);
            } catch (IOException e) {
                this.f1541a.a(CacheErrorLogger.CacheErrorCategory.DELETE_FILE, f1539a, "delete: " + e.getMessage(), e);
            }
        }
    }

    @Override // com.facebook.cache.disk.FileCache
    public boolean f(CacheKey cacheKey) {
        boolean zContainsKey;
        synchronized (this.f1548a) {
            zContainsKey = this.f1549a.containsKey(cacheKey);
        }
        return zContainsKey;
    }

    @Override // com.facebook.common.disk.DiskTrimmable
    public void g() {
        clearAll();
    }

    @Override // com.facebook.cache.disk.FileCache
    public long getSize() {
        return this.f1545a.b();
    }

    @Override // com.facebook.cache.disk.FileCache
    public BinaryResource h(CacheKey cacheKey) {
        String str;
        BinaryResource binaryResourceB;
        try {
            synchronized (this.f1548a) {
                if (this.f1549a.containsKey(cacheKey)) {
                    str = this.f1549a.get(cacheKey);
                    binaryResourceB = this.f1543a.b(str, cacheKey);
                } else {
                    List<String> listM = m(cacheKey);
                    BinaryResource binaryResourceB2 = null;
                    String str2 = null;
                    for (int i = 0; i < listM.size() && (binaryResourceB2 = this.f1543a.b((str2 = listM.get(i)), cacheKey)) == null; i++) {
                    }
                    str = str2;
                    binaryResourceB = binaryResourceB2;
                }
                if (binaryResourceB == null) {
                    this.f1542a.f();
                    this.f1549a.remove(cacheKey);
                } else {
                    this.f1542a.a();
                    this.f1549a.put(cacheKey, str);
                }
            }
            return binaryResourceB;
        } catch (IOException e) {
            this.f1541a.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, f1539a, "getResource", e);
            this.f1542a.e();
            return null;
        }
    }

    @Override // com.facebook.cache.disk.FileCache
    public boolean i(CacheKey cacheKey) {
        String str;
        boolean zC;
        try {
            synchronized (this.f1548a) {
                if (this.f1549a.containsKey(cacheKey)) {
                    str = this.f1549a.get(cacheKey);
                    zC = this.f1543a.c(str, cacheKey);
                } else {
                    List<String> listM = m(cacheKey);
                    String str2 = null;
                    boolean zC2 = false;
                    for (int i = 0; i < listM.size() && !(zC2 = this.f1543a.c((str2 = listM.get(i)), cacheKey)); i++) {
                    }
                    str = str2;
                    zC = zC2;
                }
                if (zC) {
                    this.f1549a.put(cacheKey, str);
                }
            }
            return zC;
        } catch (IOException unused) {
            this.f1542a.e();
            return false;
        }
    }

    @Override // com.facebook.cache.disk.FileCache
    public BinaryResource insert(CacheKey cacheKey, WriterCallback writerCallback) throws IOException {
        String str;
        this.f1542a.b();
        synchronized (this.f1548a) {
            str = this.f1549a.containsKey(cacheKey) ? this.f1549a.get(cacheKey) : m(cacheKey).get(0);
        }
        try {
            DiskStorage.Inserter inserterR = r(str, cacheKey);
            try {
                inserterR.b(writerCallback, cacheKey);
                return k(inserterR, cacheKey, str);
            } finally {
                if (!inserterR.c()) {
                    ad3.q(f1539a, "Failed to delete temp file");
                }
            }
        } catch (IOException e) {
            this.f1542a.d();
            ad3.r(f1539a, "Failed inserting a file into the cache", e);
            throw e;
        }
    }

    @Override // com.facebook.cache.disk.FileCache
    public boolean isEnabled() {
        return this.f1543a.isEnabled();
    }

    @GuardedBy("mLock")
    public final void j() {
        long jNow = this.f1547a.now();
        long j = f + jNow;
        try {
            long size = 0;
            boolean z = false;
            int i = 0;
            long jMax = -1;
            int i2 = 0;
            int i3 = 0;
            for (DiskStorage.Entry entry : this.f1543a.e()) {
                i2++;
                size += entry.getSize();
                if (entry.getTimestamp() > j) {
                    i3++;
                    int size2 = (int) (((long) i) + entry.getSize());
                    jMax = Math.max(entry.getTimestamp() - jNow, jMax);
                    i = size2;
                    z = true;
                }
                j = j;
            }
            if (z) {
                this.f1541a.a(CacheErrorLogger.CacheErrorCategory.READ_INVALID_ENTRY, f1539a, "Future timestamp found in " + i3 + " files , with a total size of " + i + " bytes, and a maximum time delta of " + jMax + "ms", null);
            }
            this.f1545a.f(size, i2);
        } catch (IOException e) {
            this.f1541a.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, f1539a, "calcFileCacheSize: " + e.getMessage(), e);
        }
    }

    public final BinaryResource k(DiskStorage.Inserter inserter, CacheKey cacheKey, String str) throws IOException {
        BinaryResource binaryResourceA;
        synchronized (this.f1548a) {
            binaryResourceA = inserter.a(cacheKey);
            this.f1545a.c(binaryResourceA.size(), 1L);
            this.f1549a.put(cacheKey, str);
        }
        return binaryResourceA;
    }

    @GuardedBy("mLock")
    public final void l(long j, CacheEventListener.EvictionReason evictionReason) throws IOException {
        try {
            Collection<DiskStorage.Entry> collectionN = n(this.f1543a.e());
            long jB = this.f1545a.b() - j;
            int i = 0;
            long j2 = 0;
            for (DiskStorage.Entry entry : collectionN) {
                if (j2 > jB) {
                    break;
                }
                long jH = this.f1543a.h(entry);
                this.f1549a.values().remove(entry.getId());
                if (jH > 0) {
                    i++;
                    j2 += jH;
                }
            }
            this.f1545a.c(-j2, -i);
            this.f1543a.f();
            q(evictionReason, i, j2);
        } catch (IOException e) {
            this.f1541a.a(CacheErrorLogger.CacheErrorCategory.EVICTION, f1539a, "evictAboveSize: " + e.getMessage(), e);
            throw e;
        }
    }

    public final Collection<DiskStorage.Entry> n(Collection<DiskStorage.Entry> collection) {
        long jNow = this.f1547a.now() + f;
        ArrayList arrayList = new ArrayList(collection.size());
        ArrayList arrayList2 = new ArrayList(collection.size());
        for (DiskStorage.Entry entry : collection) {
            if (entry.getTimestamp() > jNow) {
                arrayList.add(entry);
            } else {
                arrayList2.add(entry);
            }
        }
        Collections.sort(arrayList2, this.f1544a.a());
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    public final void o() throws IOException {
        synchronized (this.f1548a) {
            boolean zP = p();
            t();
            long jB = this.f1545a.b();
            if (jB > this.c && !zP) {
                this.f1545a.e();
                p();
            }
            long j = this.c;
            if (jB > j) {
                l((j * 9) / 10, CacheEventListener.EvictionReason.CACHE_FULL);
            }
        }
    }

    @GuardedBy("mLock")
    public final boolean p() {
        long jNow = this.f1547a.now();
        if (this.f1545a.d()) {
            long j = this.d;
            if (j != -1 && jNow - j <= g) {
                return false;
            }
        }
        j();
        this.d = jNow;
        return true;
    }

    public final void q(CacheEventListener.EvictionReason evictionReason, int i, long j) {
        this.f1542a.c(evictionReason, i, j);
    }

    public final DiskStorage.Inserter r(String str, CacheKey cacheKey) throws IOException {
        o();
        return this.f1543a.insert(str, cacheKey);
    }

    public final void s(double d) {
        synchronized (this.f1548a) {
            try {
                this.f1545a.e();
                p();
                long jB = this.f1545a.b();
                l(jB - ((long) (d * jB)), CacheEventListener.EvictionReason.CACHE_MANAGER_TRIMMED);
            } catch (IOException e) {
                this.f1541a.a(CacheErrorLogger.CacheErrorCategory.EVICTION, f1539a, "trimBy: " + e.getMessage(), e);
            }
        }
    }

    @GuardedBy("mLock")
    public final void t() {
        if (this.f1546a.f(StatFsHelper.StorageType.INTERNAL, this.b - this.f1545a.b())) {
            this.c = this.f1540a;
        } else {
            this.c = this.b;
        }
    }
}
