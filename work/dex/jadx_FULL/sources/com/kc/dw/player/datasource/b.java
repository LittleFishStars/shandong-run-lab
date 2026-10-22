package com.kc.dw.player.datasource;

import android.media.MediaDataSource;
import com.kc.dw.cache.media.datasouce.c;
import com.kc.dw.core.utils.LogUtil;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.SocketTimeoutException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class b extends MediaDataSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.kc.dw.cache.media.datasouce.a f39579a;

    public b(String str, c cVar) {
        this.f39579a = new com.kc.dw.cache.media.datasouce.a(str, cVar);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        com.kc.dw.cache.media.datasouce.a aVar = this.f39579a;
        aVar.getClass();
        try {
            LogUtil.dev("a", "close");
            aVar.i = true;
            RandomAccessFile randomAccessFile = aVar.c;
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            RandomAccessFile randomAccessFile2 = aVar.d;
            if (randomAccessFile2 != null) {
                try {
                    randomAccessFile2.close();
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            try {
                com.kc.dw.cache.media.download.b bVar = aVar.j;
                if (bVar != null) {
                    bVar.b(aVar.l);
                    aVar.j.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0052  */
    @Override // android.media.MediaDataSource
    public long getSize() throws IOException {
        com.kc.dw.cache.media.datasouce.a aVar = this.f39579a;
        aVar.getClass();
        try {
            File file = aVar.e;
            int i = 0;
            if (file != null && file.exists()) {
                aVar.h = aVar.e.length();
                return aVar.h;
            }
            synchronized (aVar.b) {
                while (aVar.h == -2147483648L) {
                    i += 15;
                    try {
                        aVar.b.wait(5L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (i > 20000) {
                    }
                }
                if (aVar.h != -2147483648L) {
                    return aVar.h;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (aVar.h != -2147483648L) {
                return aVar.h;
            }
        }
        return -1L;
    }

    @Override // android.media.MediaDataSource
    public int readAt(long j, byte[] bArr, int i, int i2) throws IOException {
        RandomAccessFile randomAccessFile;
        com.kc.dw.cache.media.datasouce.a aVar = this.f39579a;
        aVar.getClass();
        try {
            if (j != aVar.h) {
                com.kc.dw.cache.media.download.b bVar = aVar.j;
                if (bVar != null) {
                    bVar.a(aVar.k, j, i2, null);
                }
                int i3 = 0;
                int i4 = 0;
                while (!aVar.i) {
                    synchronized (aVar.b) {
                        if (j < aVar.c.length()) {
                            aVar.c.seek(j);
                            randomAccessFile = aVar.c;
                        } else {
                            com.kc.dw.cache.media.download.b bVar2 = aVar.j;
                            if (bVar2 == null || !bVar2.a(aVar.d, j)) {
                                i3 += 33;
                                aVar.b.wait(33L);
                            } else {
                                aVar.d.seek(j);
                                randomAccessFile = aVar.d;
                            }
                        }
                        i4 = randomAccessFile.read(bArr, i, i2);
                    }
                    if (i4 > 0) {
                        return i4;
                    }
                    if (i3 >= 20000) {
                        LogUtil.e("a", "readAt timeout");
                        throw new SocketTimeoutException();
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return -1;
    }
}
