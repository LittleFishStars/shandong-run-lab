package com.fl.saas.s2s.videocache;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface Source {
    void close();

    long length();

    void open(long j);

    int read(byte[] bArr);
}
