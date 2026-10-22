package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
@GwtIncompatible
public final class n extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @CheckForNull
    public InputStream f32195a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Iterator<? extends ByteSource> f6357a;

    public n(Iterator<? extends ByteSource> it) throws IOException {
        this.f6357a = (Iterator) com.google.common.base.i.E(it);
        g();
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        InputStream inputStream = this.f32195a;
        if (inputStream == null) {
            return 0;
        }
        return inputStream.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        InputStream inputStream = this.f32195a;
        if (inputStream != null) {
            try {
                inputStream.close();
            } finally {
                this.f32195a = null;
            }
        }
    }

    public final void g() throws IOException {
        close();
        if (this.f6357a.hasNext()) {
            this.f32195a = this.f6357a.next().m();
        }
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        while (true) {
            InputStream inputStream = this.f32195a;
            if (inputStream == null) {
                return -1;
            }
            int i = inputStream.read();
            if (i != -1) {
                return i;
            }
            g();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        InputStream inputStream = this.f32195a;
        if (inputStream == null || j <= 0) {
            return 0L;
        }
        long jSkip = inputStream.skip(j);
        if (jSkip != 0) {
            return jSkip;
        }
        if (read() == -1) {
            return 0L;
        }
        return this.f32195a.skip(j - 1) + 1;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        com.google.common.base.i.E(bArr);
        while (true) {
            InputStream inputStream = this.f32195a;
            if (inputStream == null) {
                return -1;
            }
            int i3 = inputStream.read(bArr, i, i2);
            if (i3 != -1) {
                return i3;
            }
            g();
        }
    }
}
