package com.fl.saas.s2s.videocache;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface Cache {
    void append(byte[] bArr, int i);

    long available();

    void close();

    void complete();

    boolean isCompleted();

    int read(byte[] bArr, long j, int i);
}
