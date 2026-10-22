package com.byazt.of;

import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1217, 54})
public abstract class ve {
    public static tt c(RandomAccessFile randomAccessFile, long j, long j2) {
        return c(randomAccessFile.getChannel(), j, j2);
    }

    public static tt c(FileChannel fileChannel, long j, long j2) {
        fileChannel.getClass();
        return new uj(fileChannel, j, j2);
    }
}
