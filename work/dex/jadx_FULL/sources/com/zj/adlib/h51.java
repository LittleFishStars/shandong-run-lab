package com.zj.adlib;

import com.facebook.binaryresource.BinaryResource;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class h51 implements BinaryResource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f42056a;

    public h51(byte[] bArr) {
        this.f42056a = (byte[]) ax6.i(bArr);
    }

    @Override // com.facebook.binaryresource.BinaryResource
    public byte[] a() {
        return this.f42056a;
    }

    @Override // com.facebook.binaryresource.BinaryResource
    public InputStream b() throws IOException {
        return new ByteArrayInputStream(this.f42056a);
    }

    @Override // com.facebook.binaryresource.BinaryResource
    public long size() {
        return this.f42056a.length;
    }
}
