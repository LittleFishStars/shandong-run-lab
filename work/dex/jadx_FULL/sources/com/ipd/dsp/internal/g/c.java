package com.ipd.dsp.internal.g;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class c extends OutputStream {

    @NonNull
    public final OutputStream f;
    public byte[] g;
    public com.ipd.dsp.internal.j.b h;
    public int i;

    public c(@NonNull OutputStream outputStream, @NonNull com.ipd.dsp.internal.j.b bVar) {
        this(outputStream, bVar, 65536);
    }

    public final void a() throws IOException {
        int i = this.i;
        if (i > 0) {
            this.f.write(this.g, 0, i);
            this.i = 0;
        }
    }

    public final void b() throws IOException {
        if (this.i == this.g.length) {
            a();
        }
    }

    public final void c() {
        byte[] bArr = this.g;
        if (bArr != null) {
            this.h.put(bArr);
            this.g = null;
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            flush();
            this.f.close();
            c();
        } catch (Throwable th) {
            this.f.close();
            throw th;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        a();
        this.f.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        byte[] bArr = this.g;
        int i2 = this.i;
        this.i = i2 + 1;
        bArr[i2] = (byte) i;
        b();
    }

    @VisibleForTesting
    public c(@NonNull OutputStream outputStream, com.ipd.dsp.internal.j.b bVar, int i) {
        this.f = outputStream;
        this.h = bVar;
        this.g = (byte[]) bVar.b(i, byte[].class);
    }

    @Override // java.io.OutputStream
    public void write(@NonNull byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(@NonNull byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        do {
            int i4 = i2 - i3;
            int i5 = i + i3;
            int i6 = this.i;
            if (i6 == 0 && i4 >= this.g.length) {
                this.f.write(bArr, i5, i4);
                return;
            }
            int iMin = Math.min(i4, this.g.length - i6);
            System.arraycopy(bArr, i5, this.g, this.i, iMin);
            this.i += iMin;
            i3 += iMin;
            b();
        } while (i3 < i2);
    }
}
