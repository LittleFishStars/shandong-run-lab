package com.kc.dw.cache.media.download;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface a {
    void a(long j);

    void a(String str, long j, int i, RandomAccessFile randomAccessFile);

    boolean a(RandomAccessFile randomAccessFile, long j);

    void close();
}
