package com.byazt.ep;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import com.google.android.exoplayer2.upstream.cache.CachedContentIndex;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1555, 20})
public class c implements com.byazt.yj.tt, Cloneable {
    public static volatile com.byazt.yj.tt sp;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public File f28476a;
    public long c;
    public boolean n;
    public int tt;
    public boolean uj;
    public int ve;

    public c(int i, long j, File file) {
        this(i, 524288, j, i != 0, j != 0, file);
    }

    public static void c(Context context, com.byazt.yj.tt ttVar) {
        if (ttVar != null) {
            sp = ttVar;
        } else {
            sp = c(new File(com.byazt.nys.tt.tt(context), "image"));
        }
    }

    private static long tt() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
    }

    @Override // com.byazt.yj.tt
    public File getCacheDir() {
        return this.f28476a;
    }

    @Override // com.byazt.yj.tt
    public long getFileCacheSize() {
        return this.c;
    }

    @Override // com.byazt.yj.tt
    public int getMemoryCacheSize() {
        return this.tt;
    }

    @Override // com.byazt.yj.tt
    public int getRawMemoryCacheSize() {
        return this.ve;
    }

    @Override // com.byazt.yj.tt
    public boolean isDiskCache() {
        return this.n;
    }

    @Override // com.byazt.yj.tt
    public boolean isMemoryCache() {
        return this.uj;
    }

    @Override // com.byazt.yj.tt
    public boolean isQueryAll() {
        return true;
    }

    @Override // com.byazt.yj.tt
    public boolean isRawMemoryCache() {
        return this.ve > 0;
    }

    public c(int i, int i2, long j, boolean z, boolean z2, File file) {
        this.c = j;
        this.tt = i;
        this.ve = i2;
        this.uj = z;
        this.n = z2;
        this.f28476a = file;
    }

    public static com.byazt.yj.tt c(File file) {
        int iMin;
        long jMin;
        file.mkdirs();
        if (sp == null) {
            iMin = Math.min(Long.valueOf(Runtime.getRuntime().maxMemory()).intValue() / 16, CachedContentIndex.f31137a);
            jMin = Math.min(tt() / 16, 31457280L);
        } else {
            iMin = Math.min(sp.getMemoryCacheSize() / 2, CachedContentIndex.f31137a);
            jMin = Math.min(sp.getFileCacheSize() / 2, 31457280L);
        }
        return new c(Math.max(iMin, 5242880), Math.max(jMin, 10485760L), file);
    }

    public static com.byazt.yj.tt c() {
        return sp;
    }
}
