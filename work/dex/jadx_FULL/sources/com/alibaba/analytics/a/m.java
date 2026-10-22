package com.alibaba.analytics.a;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static File f23747a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    static FileChannel f621a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    static FileLock f622a;

    public static synchronized boolean c(Context context) {
        FileLock fileLockTryLock;
        if (f23747a == null) {
            f23747a = new File(context.getFilesDir() + File.separator + "Analytics.Lock");
        }
        boolean zExists = f23747a.exists();
        if (!zExists) {
            try {
                zExists = f23747a.createNewFile();
            } catch (IOException unused) {
            }
        }
        if (!zExists) {
            return true;
        }
        if (f621a == null) {
            try {
                f621a = new RandomAccessFile(f23747a, "rw").getChannel();
            } catch (Exception unused2) {
                return false;
            }
        }
        try {
            fileLockTryLock = f621a.tryLock();
            if (fileLockTryLock != null) {
                f622a = fileLockTryLock;
                return true;
            }
        } catch (Throwable unused3) {
            fileLockTryLock = null;
        }
        Log.d("TAG", "mLock:" + fileLockTryLock);
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0016 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    public static synchronized void release() {
        FileChannel fileChannel;
        FileLock fileLock = f622a;
        if (fileLock != null) {
            try {
                fileLock.release();
            } catch (IOException unused) {
            } finally {
                f622a = null;
            }
            fileChannel = f621a;
            if (fileChannel != null) {
                try {
                    fileChannel.close();
                } catch (Exception unused2) {
                } finally {
                    f621a = null;
                }
            }
        } else {
            fileChannel = f621a;
            if (fileChannel != null) {
                fileChannel.close();
            }
        }
        throw th;
    }
}
