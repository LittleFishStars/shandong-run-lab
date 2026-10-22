package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;
import java.util.Objects;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
@GwtIncompatible
public final class c extends Reader {
    public int K;
    public int L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @CheckForNull
    public CharSequence f32183a;

    public c(CharSequence charSequence) {
        this.f32183a = (CharSequence) com.google.common.base.i.E(charSequence);
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.f32183a = null;
    }

    public final void g() throws IOException {
        if (this.f32183a == null) {
            throw new IOException("reader closed");
        }
    }

    public final boolean h() {
        return j() > 0;
    }

    public final int j() {
        Objects.requireNonNull(this.f32183a);
        return this.f32183a.length() - this.K;
    }

    @Override // java.io.Reader
    public synchronized void mark(int i) throws IOException {
        com.google.common.base.i.k(i >= 0, "readAheadLimit (%s) may not be negative", i);
        g();
        this.L = this.K;
    }

    @Override // java.io.Reader
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.Reader, java.lang.Readable
    public synchronized int read(CharBuffer charBuffer) throws IOException {
        com.google.common.base.i.E(charBuffer);
        g();
        Objects.requireNonNull(this.f32183a);
        if (!h()) {
            return -1;
        }
        int iMin = Math.min(charBuffer.remaining(), j());
        for (int i = 0; i < iMin; i++) {
            CharSequence charSequence = this.f32183a;
            int i2 = this.K;
            this.K = i2 + 1;
            charBuffer.put(charSequence.charAt(i2));
        }
        return iMin;
    }

    @Override // java.io.Reader
    public synchronized boolean ready() throws IOException {
        g();
        return true;
    }

    @Override // java.io.Reader
    public synchronized void reset() throws IOException {
        g();
        this.K = this.L;
    }

    @Override // java.io.Reader
    public synchronized long skip(long j) throws IOException {
        int iMin;
        com.google.common.base.i.p(j >= 0, "n (%s) may not be negative", j);
        g();
        iMin = (int) Math.min(j(), j);
        this.K += iMin;
        return iMin;
    }

    @Override // java.io.Reader
    public synchronized int read() throws IOException {
        int iCharAt;
        g();
        Objects.requireNonNull(this.f32183a);
        if (h()) {
            CharSequence charSequence = this.f32183a;
            int i = this.K;
            this.K = i + 1;
            iCharAt = charSequence.charAt(i);
        } else {
            iCharAt = -1;
        }
        return iCharAt;
    }

    @Override // java.io.Reader
    public synchronized int read(char[] cArr, int i, int i2) throws IOException {
        com.google.common.base.i.f0(i, i + i2, cArr.length);
        g();
        Objects.requireNonNull(this.f32183a);
        if (!h()) {
            return -1;
        }
        int iMin = Math.min(i2, j());
        for (int i3 = 0; i3 < iMin; i3++) {
            CharSequence charSequence = this.f32183a;
            int i4 = this.K;
            this.K = i4 + 1;
            cArr[i + i3] = charSequence.charAt(i4);
        }
        return iMin;
    }
}
