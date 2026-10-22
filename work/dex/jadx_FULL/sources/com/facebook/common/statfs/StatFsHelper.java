package com.facebook.common.statfs;

import android.annotation.SuppressLint;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import com.zj.adlib.i69;
import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@ThreadSafe
public class StatFsHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static StatFsHelper f29956a;
    public static final long b = TimeUnit.MINUTES.toMillis(2);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @GuardedBy("lock")
    public long f1561a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public volatile File f1563a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public volatile File f1567b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public volatile StatFs f1562a = null;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public volatile StatFs f1566b = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public volatile boolean f1565a = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Lock f1564a = new ReentrantLock();

    public enum StorageType {
        INTERNAL,
        EXTERNAL
    }

    public static synchronized StatFsHelper c() {
        if (f29956a == null) {
            f29956a = new StatFsHelper();
        }
        return f29956a;
    }

    public static StatFs createStatFs(String str) {
        return new StatFs(str);
    }

    public final void a() {
        if (this.f1565a) {
            return;
        }
        this.f1564a.lock();
        try {
            if (!this.f1565a) {
                this.f1563a = Environment.getDataDirectory();
                this.f1567b = Environment.getExternalStorageDirectory();
                g();
                this.f1565a = true;
            }
        } finally {
            this.f1564a.unlock();
        }
    }

    @SuppressLint({"DeprecatedMethod"})
    public long b(StorageType storageType) {
        a();
        d();
        StatFs statFs = storageType == StorageType.INTERNAL ? this.f1562a : this.f1566b;
        if (statFs != null) {
            return statFs.getBlockSizeLong() * statFs.getAvailableBlocksLong();
        }
        return 0L;
    }

    public final void d() {
        if (this.f1564a.tryLock()) {
            try {
                if (SystemClock.uptimeMillis() - this.f1561a > b) {
                    g();
                }
            } finally {
                this.f1564a.unlock();
            }
        }
    }

    public void e() {
        if (this.f1564a.tryLock()) {
            try {
                a();
                g();
            } finally {
                this.f1564a.unlock();
            }
        }
    }

    public boolean f(StorageType storageType, long j) {
        a();
        long jB = b(storageType);
        return jB <= 0 || jB < j;
    }

    @GuardedBy("lock")
    public final void g() {
        this.f1562a = h(this.f1562a, this.f1563a);
        this.f1566b = h(this.f1566b, this.f1567b);
        this.f1561a = SystemClock.uptimeMillis();
    }

    public final StatFs h(@Nullable StatFs statFs, @Nullable File file) {
        StatFs statFs2 = null;
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            if (statFs == null) {
                statFs = createStatFs(file.getAbsolutePath());
            } else {
                statFs.restat(file.getAbsolutePath());
            }
            statFs2 = statFs;
            return statFs2;
        } catch (IllegalArgumentException unused) {
            return statFs2;
        } catch (Throwable th) {
            throw i69.d(th);
        }
    }
}
