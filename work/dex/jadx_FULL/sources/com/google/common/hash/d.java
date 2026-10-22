package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.common.base.i;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Beta
@ElementTypesAreNonnullByDefault
public final class d extends FilterOutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Hasher f32143a;

    public d(HashFunction hashFunction, OutputStream outputStream) {
        super((OutputStream) i.E(outputStream));
        this.f32143a = (Hasher) i.E(hashFunction.newHasher());
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        ((FilterOutputStream) this).out.close();
    }

    public HashCode g() {
        return this.f32143a.p();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) throws IOException {
        this.f32143a.g((byte) i);
        ((FilterOutputStream) this).out.write(i);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.f32143a.h(bArr, i, i2);
        ((FilterOutputStream) this).out.write(bArr, i, i2);
    }
}
