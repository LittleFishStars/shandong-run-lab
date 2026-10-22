package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
@GwtIncompatible
public class o extends Reader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @CheckForNull
    public Reader f32196a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Iterator<? extends CharSource> f6358a;

    public o(Iterator<? extends CharSource> it) throws IOException {
        this.f6358a = it;
        g();
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Reader reader = this.f32196a;
        if (reader != null) {
            try {
                reader.close();
            } finally {
                this.f32196a = null;
            }
        }
    }

    public final void g() throws IOException {
        close();
        if (this.f6358a.hasNext()) {
            this.f32196a = this.f6358a.next().m();
        }
    }

    @Override // java.io.Reader
    public int read(char[] cArr, int i, int i2) throws IOException {
        com.google.common.base.i.E(cArr);
        Reader reader = this.f32196a;
        if (reader == null) {
            return -1;
        }
        int i3 = reader.read(cArr, i, i2);
        if (i3 != -1) {
            return i3;
        }
        g();
        return read(cArr, i, i2);
    }

    @Override // java.io.Reader
    public boolean ready() throws IOException {
        Reader reader = this.f32196a;
        return reader != null && reader.ready();
    }

    @Override // java.io.Reader
    public long skip(long j) throws IOException {
        com.google.common.base.i.e(j >= 0, "n is negative");
        if (j > 0) {
            while (true) {
                Reader reader = this.f32196a;
                if (reader == null) {
                    break;
                }
                long jSkip = reader.skip(j);
                if (jSkip > 0) {
                    return jSkip;
                }
                g();
            }
        }
        return 0L;
    }
}
