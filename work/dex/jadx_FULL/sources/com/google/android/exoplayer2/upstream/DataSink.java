package com.google.android.exoplayer2.upstream;

import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface DataSink {

    public interface Factory {
        DataSink a();
    }

    void a(DataSpec dataSpec) throws IOException;

    void close() throws IOException;

    void write(byte[] bArr, int i, int i2) throws IOException;
}
