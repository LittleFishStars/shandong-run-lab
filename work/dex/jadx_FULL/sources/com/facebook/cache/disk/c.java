package com.facebook.cache.disk;

import com.facebook.binaryresource.BinaryResource;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.common.file.FileUtils;
import com.facebook.common.internal.Supplier;
import com.facebook.common.internal.VisibleForTesting;
import com.zj.adlib.ad3;
import com.zj.adlib.ax6;
import com.zj.adlib.fg3;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class c implements DiskStorage {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Class<?> f29949a = c.class;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int f1551a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final CacheErrorLogger f1552a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @VisibleForTesting
    public volatile a f1553a = new a(null, null);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Supplier<File> f1554a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f1555a;

    @VisibleForTesting
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public final DiskStorage f29950a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public final File f1556a;

        @VisibleForTesting
        public a(@Nullable File file, @Nullable DiskStorage diskStorage) {
            this.f29950a = diskStorage;
            this.f1556a = file;
        }
    }

    public c(int i, Supplier<File> supplier, String str, CacheErrorLogger cacheErrorLogger) {
        this.f1551a = i;
        this.f1552a = cacheErrorLogger;
        this.f1554a = supplier;
        this.f1555a = str;
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public DiskStorage.a a() throws IOException {
        return l().a();
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public BinaryResource b(String str, Object obj) throws IOException {
        return l().b(str, obj);
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public boolean c(String str, Object obj) throws IOException {
        return l().c(str, obj);
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public void clearAll() throws IOException {
        l().clearAll();
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public long d(String str) throws IOException {
        return l().d(str);
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public Collection<DiskStorage.Entry> e() throws IOException {
        return l().e();
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public void f() {
        try {
            l().f();
        } catch (IOException e) {
            ad3.r(f29949a, "purgeUnexpectedResources", e);
        }
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public boolean g(String str, Object obj) throws IOException {
        return l().g(str, obj);
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public long h(DiskStorage.Entry entry) throws IOException {
        return l().h(entry);
    }

    @VisibleForTesting
    public void i(File file) throws IOException {
        try {
            FileUtils.a(file);
            ad3.b(f29949a, "Created cache directory %s", file.getAbsolutePath());
        } catch (FileUtils.CreateDirectoryException e) {
            this.f1552a.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, f29949a, "createRootDirectoryIfNecessary", e);
            throw e;
        }
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public DiskStorage.Inserter insert(String str, Object obj) throws IOException {
        return l().insert(str, obj);
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public boolean isEnabled() {
        try {
            return l().isEnabled();
        } catch (IOException unused) {
            return false;
        }
    }

    public final void j() throws IOException {
        File file = new File(this.f1554a.get(), this.f1555a);
        i(file);
        this.f1553a = new a(file, new DefaultDiskStorage(file, this.f1551a, this.f1552a));
    }

    @VisibleForTesting
    public void k() {
        if (this.f1553a.f29950a == null || this.f1553a.f1556a == null) {
            return;
        }
        fg3.b(this.f1553a.f1556a);
    }

    @VisibleForTesting
    public synchronized DiskStorage l() throws IOException {
        if (m()) {
            k();
            j();
        }
        return (DiskStorage) ax6.i(this.f1553a.f29950a);
    }

    public final boolean m() {
        File file;
        a aVar = this.f1553a;
        return aVar.f29950a == null || (file = aVar.f1556a) == null || !file.exists();
    }
}
