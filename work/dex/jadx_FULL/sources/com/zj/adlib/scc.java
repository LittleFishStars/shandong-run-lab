package com.zj.adlib;

import androidx.annotation.NonNull;
import java.io.OutputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class scc extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f44662a = 0;

    public final long g() {
        return this.f44662a;
    }

    @Override // java.io.OutputStream
    public final void write(int i) {
        this.f44662a++;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) {
        this.f44662a += (long) bArr.length;
    }

    @Override // java.io.OutputStream
    public final void write(@NonNull byte[] bArr, int i, int i2) {
        int length;
        int i3;
        if (i < 0 || i > (length = bArr.length) || i2 < 0 || (i3 = i + i2) > length || i3 < 0) {
            throw new IndexOutOfBoundsException();
        }
        this.f44662a += (long) i2;
    }
}
