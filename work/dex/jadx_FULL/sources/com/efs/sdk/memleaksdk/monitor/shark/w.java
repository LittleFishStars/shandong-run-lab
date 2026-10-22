package com.efs.sdk.memleaksdk.monitor.shark;

import java.io.IOException;
import java.io.InterruptedIOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w f29886a = new w() { // from class: com.efs.sdk.memleaksdk.monitor.internal.w.1
        @Override // com.efs.sdk.memleaksdk.monitor.shark.w
        public void a() throws IOException {
        }
    };
    private boolean b;
    private long c;

    public void a() throws IOException {
        if (Thread.interrupted()) {
            throw new InterruptedIOException("thread interrupted");
        }
        if (this.b && this.c - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }
}
