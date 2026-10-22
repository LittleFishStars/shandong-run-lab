package com.alibaba.ariver.kernel.common.io;

import com.alibaba.ariver.kernel.common.utils.IOUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ProcessLock {
    public static final String TAG = "AriverKernelProcessLock";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private File f24244a;
    private RandomAccessFile b;
    private FileChannel c;
    private FileLock d;

    public ProcessLock(String str) {
        this.f24244a = new File(str);
    }

    public void lock() {
        try {
            if (this.b == null) {
                this.b = new RandomAccessFile(this.f24244a, "rw");
            }
            RandomAccessFile randomAccessFile = this.b;
            if (randomAccessFile == null || this.f24244a == null) {
                RVLogger.e(TAG, "lock error lockRaf = " + this.b + " lockFile = " + this.f24244a);
                return;
            }
            this.c = randomAccessFile.getChannel();
            RVLogger.d(TAG, "Blocking on lock " + this.f24244a.getPath());
            try {
                this.d = this.c.lock();
                RVLogger.d(TAG, this.f24244a.getPath() + " locked");
            } catch (IOException e) {
                RVLogger.e(TAG, "lock error ", e);
            }
        } catch (FileNotFoundException e2) {
            RVLogger.e(TAG, "ProcessLock error", e2);
        }
    }

    public boolean tryLock() {
        try {
            if (this.b == null) {
                this.b = new RandomAccessFile(this.f24244a, "rw");
            }
            RandomAccessFile randomAccessFile = this.b;
            if (randomAccessFile == null || this.f24244a == null) {
                RVLogger.e(TAG, "tryLock error lockRaf = " + this.b + " lockFile = " + this.f24244a);
                return false;
            }
            this.c = randomAccessFile.getChannel();
            RVLogger.d(TAG, "Blocking on tryLock " + this.f24244a.getPath());
            try {
                try {
                    this.d = this.c.tryLock();
                } catch (IOException e) {
                    RVLogger.e(TAG, "TryLock error ", e);
                }
                IOUtils.closeQuietly(this.c);
                boolean z = this.d != null;
                RVLogger.d(TAG, this.f24244a.getPath() + "try locked: " + z);
                return z;
            } catch (Throwable th) {
                IOUtils.closeQuietly(this.c);
                throw th;
            }
        } catch (FileNotFoundException e2) {
            RVLogger.e(TAG, "Process tryLock error", e2);
            return false;
        }
    }

    public void unlock() {
        FileLock fileLock = this.d;
        if (fileLock != null) {
            try {
                fileLock.release();
            } catch (IOException unused) {
                StringBuilder sb = new StringBuilder();
                sb.append("Failed to release lock on ");
                File file = this.f24244a;
                sb.append(file != null ? file.getPath() : "");
                RVLogger.e(TAG, sb.toString());
            }
        }
        IOUtils.closeQuietly(this.c);
        IOUtils.closeQuietly(this.b);
        if (this.f24244a != null) {
            RVLogger.d(TAG, this.f24244a.getPath() + " unlocked");
        }
    }

    public ProcessLock(File file) {
        this.f24244a = file;
    }
}
