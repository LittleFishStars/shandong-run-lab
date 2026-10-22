package com.zj.adlib;

import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class bx6 extends ByteArrayOutputStream {
    public bx6(int i) {
        super(i);
    }

    @Override // java.io.ByteArrayOutputStream
    public byte[] toByteArray() {
        int i = ((ByteArrayOutputStream) this).count;
        byte[] bArr = ((ByteArrayOutputStream) this).buf;
        return i == bArr.length ? bArr : super.toByteArray();
    }
}
