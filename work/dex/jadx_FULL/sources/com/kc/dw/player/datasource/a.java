package com.kc.dw.player.datasource;

import android.media.MediaDataSource;
import com.kc.dw.core.utils.LogUtil;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class a extends MediaDataSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.kc.dw.cache.media.datasouce.b f39578a;

    public a(String str) {
        this.f39578a = new com.kc.dw.cache.media.datasouce.b(str);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        com.kc.dw.cache.media.datasouce.b bVar = this.f39578a;
        bVar.getClass();
        try {
            LogUtil.dev("b", "close");
            RandomAccessFile randomAccessFile = bVar.f39224a;
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            RandomAccessFile randomAccessFile2 = bVar.b;
            if (randomAccessFile2 != null) {
                try {
                    randomAccessFile2.close();
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.media.MediaDataSource
    public long getSize() throws IOException {
        File file;
        com.kc.dw.cache.media.datasouce.b bVar = this.f39578a;
        bVar.getClass();
        try {
            File file2 = bVar.c;
            if (file2 != null && file2.exists()) {
                bVar.f = bVar.c.length();
                return bVar.f;
            }
            File file3 = bVar.e;
            if (file3 == null || !file3.exists() || bVar.e.length() <= 0) {
                File file4 = bVar.d;
                if (file4 != null && file4.exists() && bVar.d.length() > 0) {
                    file = bVar.d;
                }
                if (bVar.f == -2147483648L) {
                    return -1L;
                }
                return bVar.f;
            }
            file = bVar.e;
            return file.length();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:? A[RETURN, SYNTHETIC] */
    @Override // android.media.MediaDataSource
    public int readAt(long j, byte[] bArr, int i, int i2) throws IOException {
        int i3;
        RandomAccessFile randomAccessFile;
        com.kc.dw.cache.media.datasouce.b bVar = this.f39578a;
        bVar.getClass();
        try {
            if (j != bVar.f) {
                if (j < bVar.f39224a.length()) {
                    bVar.f39224a.seek(j);
                    randomAccessFile = bVar.f39224a;
                } else {
                    if (j < bVar.b.length()) {
                        bVar.b.seek(j);
                        randomAccessFile = bVar.b;
                    } else {
                        i3 = 0;
                    }
                    if (i3 > 0) {
                        return i3;
                    }
                }
                i3 = randomAccessFile.read(bArr, i, i2);
                if (i3 > 0) {
                    return i3;
                }
            }
        } catch (Throwable unused) {
        }
        return -1;
    }
}
