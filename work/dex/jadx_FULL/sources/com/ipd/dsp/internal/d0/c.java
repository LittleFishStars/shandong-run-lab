package com.ipd.dsp.internal.d0;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ipd.dsp.Dsp;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class c extends FilterInputStream {
    public static final String h = "ContentLengthStream";
    public static final int i = -1;
    public final long f;
    public int g;

    public c(@NonNull InputStream inputStream, long j) {
        super(inputStream);
        this.f = j;
    }

    @NonNull
    public static InputStream a(@NonNull InputStream inputStream, @Nullable String str) {
        return a(inputStream, a(str));
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        return (int) Math.max(this.f - ((long) this.g), ((FilterInputStream) this).in.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        int i2;
        i2 = super.read();
        a(i2 >= 0 ? 1 : -1);
        return i2;
    }

    @NonNull
    public static InputStream a(@NonNull InputStream inputStream, long j) {
        return new c(inputStream, j);
    }

    public static int a(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            if (!Dsp.isDebugLogEnable()) {
                return -1;
            }
            com.ipd.dsp.internal.c2.k.a(h, "failed to parse content length header: " + str, e);
            return -1;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i2, int i3) throws IOException {
        return a(super.read(bArr, i2, i3));
    }

    public final int a(int i2) throws IOException {
        if (i2 >= 0) {
            this.g += i2;
            return i2;
        }
        if (this.f - ((long) this.g) <= 0) {
            return i2;
        }
        throw new IOException("Failed to read all expected data, expected: " + this.f + ", but read: " + this.g);
    }
}
