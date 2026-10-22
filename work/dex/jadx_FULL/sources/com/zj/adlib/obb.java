package com.zj.adlib;

import com.amap.api.col.p0003l.ij;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class obb extends ij {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ByteArrayOutputStream f43714a;

    public obb() {
        this.f43714a = new ByteArrayOutputStream();
    }

    @Override // com.amap.api.col.p0003l.ij
    public final byte[] a(byte[] bArr) {
        byte[] byteArray = this.f43714a.toByteArray();
        try {
            this.f43714a.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.f43714a = new ByteArrayOutputStream();
        return byteArray;
    }

    @Override // com.amap.api.col.p0003l.ij
    public final void b(byte[] bArr) {
        try {
            this.f43714a.write(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public obb(ij ijVar) {
        super(ijVar);
        this.f43714a = new ByteArrayOutputStream();
    }
}
