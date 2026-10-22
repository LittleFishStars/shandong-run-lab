package com.zj.adlib;

import android.content.Context;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheEventListener;
import com.facebook.cache.disk.EntryEvictionComparatorSupplier;
import com.facebook.common.disk.DiskTrimmableRegistry;
import com.facebook.common.internal.Supplier;
import java.io.File;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class ao2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f40567a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final long f15308a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final CacheErrorLogger f15309a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final CacheEventListener f15310a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final EntryEvictionComparatorSupplier f15311a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DiskTrimmableRegistry f15312a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Supplier<File> f15313a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f15314a;
    public final long b;
    public final long c;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f40568a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public long f15315a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public final Context f15316a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public CacheErrorLogger f15317a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public CacheEventListener f15318a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public EntryEvictionComparatorSupplier f15319a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public DiskTrimmableRegistry f15320a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Supplier<File> f15321a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public String f15322a;
        public long b;
        public long c;

        public class a implements Supplier<File> {
            public a() {
            }

            @Override // com.facebook.common.internal.Supplier
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public File get() {
                return b.this.f15316a.getApplicationContext().getCacheDir();
            }
        }

        public ao2 l() {
            ax6.p((this.f15321a == null && this.f15316a == null) ? false : true, "Either a non-null context or a base directory path or supplier must be provided.");
            if (this.f15321a == null && this.f15316a != null) {
                this.f15321a = new a();
            }
            return new ao2(this);
        }

        public b m(String str) {
            this.f15322a = str;
            return this;
        }

        public b n(File file) {
            this.f15321a = vw8.a(file);
            return this;
        }

        public b o(Supplier<File> supplier) {
            this.f15321a = supplier;
            return this;
        }

        public b p(CacheErrorLogger cacheErrorLogger) {
            this.f15317a = cacheErrorLogger;
            return this;
        }

        public b q(CacheEventListener cacheEventListener) {
            this.f15318a = cacheEventListener;
            return this;
        }

        public b r(DiskTrimmableRegistry diskTrimmableRegistry) {
            this.f15320a = diskTrimmableRegistry;
            return this;
        }

        public b s(EntryEvictionComparatorSupplier entryEvictionComparatorSupplier) {
            this.f15319a = entryEvictionComparatorSupplier;
            return this;
        }

        public b t(long j) {
            this.f15315a = j;
            return this;
        }

        public b u(long j) {
            this.b = j;
            return this;
        }

        public b v(long j) {
            this.c = j;
            return this;
        }

        public b w(int i) {
            this.f40568a = i;
            return this;
        }

        public b(@Nullable Context context) {
            this.f40568a = 1;
            this.f15322a = "image_cache";
            this.f15315a = 41943040L;
            this.b = 10485760L;
            this.c = 2097152L;
            this.f15319a = new com.facebook.cache.disk.a();
            this.f15316a = context;
        }
    }

    public static b k(@Nullable Context context) {
        return new b(context);
    }

    public String a() {
        return this.f15314a;
    }

    public Supplier<File> b() {
        return this.f15313a;
    }

    public CacheErrorLogger c() {
        return this.f15309a;
    }

    public CacheEventListener d() {
        return this.f15310a;
    }

    public long e() {
        return this.f15308a;
    }

    public DiskTrimmableRegistry f() {
        return this.f15312a;
    }

    public EntryEvictionComparatorSupplier g() {
        return this.f15311a;
    }

    public long h() {
        return this.b;
    }

    public long i() {
        return this.c;
    }

    public int j() {
        return this.f40567a;
    }

    public ao2(b bVar) {
        this.f40567a = bVar.f40568a;
        this.f15314a = (String) ax6.i(bVar.f15322a);
        this.f15313a = (Supplier) ax6.i(bVar.f15321a);
        this.f15308a = bVar.f15315a;
        this.b = bVar.b;
        this.c = bVar.c;
        this.f15311a = (EntryEvictionComparatorSupplier) ax6.i(bVar.f15319a);
        this.f15309a = bVar.f15317a == null ? com.facebook.cache.common.a.b() : bVar.f15317a;
        this.f15310a = bVar.f15318a == null ? com.facebook.cache.common.b.g() : bVar.f15318a;
        this.f15312a = bVar.f15320a == null ? lz5.c() : bVar.f15320a;
    }
}
