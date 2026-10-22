package com.zj.adlib;

import android.system.Os;
import android.system.OsConstants;
import android.system.StructStat;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class jnd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f42628a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f17441a;
    public final long b;

    public jnd(long j, long j2, boolean z) {
        this.f42628a = j;
        this.b = j2;
        this.f17441a = z;
    }

    public static jnd a(final FileDescriptor fileDescriptor) throws IOException {
        StructStat structStat = (StructStat) c(new Callable() { // from class: com.zj.adlib.vad
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return Os.fstat(fileDescriptor);
            }
        });
        return new jnd(structStat.st_dev, structStat.st_ino, OsConstants.S_ISLNK(structStat.st_mode));
    }

    public static jnd b(final String str) throws IOException {
        StructStat structStat = (StructStat) c(new Callable() { // from class: com.zj.adlib.l7d
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return Os.lstat(str);
            }
        });
        return new jnd(structStat.st_dev, structStat.st_ino, OsConstants.S_ISLNK(structStat.st_mode));
    }

    public static Object c(Callable callable) throws IOException {
        try {
            return callable.call();
        } catch (Throwable th) {
            throw new IOException(th);
        }
    }
}
