package com.efs.sdk.memleaksdk.monitor.shark;

import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface v extends Closeable {
    long b(l lVar, long j) throws IOException;

    void close() throws IOException;
}
