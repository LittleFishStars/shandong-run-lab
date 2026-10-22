package com.alibaba.ariver.commonability.file.fs.a.b;

import android.system.Os;
import android.system.StructStat;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile Object f24018a;
    private static volatile Method b;

    private static Object a() {
        if (f24018a == null) {
            synchronized (a.class) {
                if (f24018a == null) {
                    try {
                        f24018a = Class.forName("libcore.io.Libcore").getField("os").get(null);
                    } catch (Exception unused) {
                    }
                }
            }
        }
        return f24018a;
    }

    private static Method b() {
        Object objA;
        if (b == null) {
            synchronized (b.class) {
                if (b == null && (objA = a()) != null) {
                    try {
                        b = objA.getClass().getMethod("stat", String.class);
                    } catch (Exception unused) {
                    }
                }
            }
        }
        return b;
    }

    public static b a(String str) {
        try {
            StructStat structStatStat = Os.stat(str);
            return new b(structStatStat.st_dev, structStatStat.st_ino, structStatStat.st_mode, structStatStat.st_nlink, structStatStat.st_uid, structStatStat.st_gid, structStatStat.st_rdev, structStatStat.st_size, structStatStat.st_atime, structStatStat.st_mtime, structStatStat.st_ctime, structStatStat.st_blksize, structStatStat.st_blocks);
        } catch (Exception unused) {
            return null;
        }
    }
}
