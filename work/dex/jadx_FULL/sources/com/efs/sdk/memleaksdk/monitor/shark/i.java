package com.efs.sdk.memleaksdk.monitor.shark;

import java.io.Closeable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class i {
    public static void a(Closeable closeable) {
        try {
            closeable.close();
        } catch (Throwable unused) {
        }
    }
}
