package com.zj.adlib;

import androidx.annotation.NonNull;
import java.io.OutputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class p8c extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f43928a = 0;

    public final long g() {
        return this.f43928a;
    }

    @Override // java.io.OutputStream
    public final void write(int i) {
        this.f43928a++;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) {
        this.f43928a += (long) bArr.length;
    }

    @Override // java.io.OutputStream
    public final void write(@NonNull byte[] bArr, int i, int i2) {
        int length;
        int i3;
        if (i < 0 || i > (length = bArr.length) || i2 < 0 || (i3 = i + i2) > length || i3 < 0) {
            throw new IndexOutOfBoundsException();
        }
        this.f43928a += (long) i2;
    }
}
