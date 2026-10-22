package com.zj.adlib;

import java.io.BufferedOutputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class dh7 extends BufferedOutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f41183a;

    public dh7(OutputStream outputStream) {
        super(outputStream);
    }

    public void a(OutputStream outputStream) {
        sb0.i(this.f41183a);
        ((BufferedOutputStream) this).out = outputStream;
        ((BufferedOutputStream) this).count = 0;
        this.f41183a = false;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        this.f41183a = true;
        flush();
        th = null;
        try {
            ((BufferedOutputStream) this).out.close();
        } catch (Throwable th) {
            if (th == null) {
                th = th;
            }
        }
        if (th != null) {
            gj9.s1(th);
        }
    }

    public dh7(OutputStream outputStream, int i) {
        super(outputStream, i);
    }
}
