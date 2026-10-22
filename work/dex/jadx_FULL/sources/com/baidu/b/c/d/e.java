package com.baidu.b.c.d;

import java.math.BigInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class e implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private BigInteger f26291a;
    private BigInteger b;

    public e(byte[] bArr, byte[] bArr2) {
        this.f26291a = new BigInteger(bArr);
        this.b = new BigInteger(bArr2);
    }

    @Override // com.baidu.b.c.d.d
    public BigInteger a() {
        return this.f26291a;
    }

    @Override // com.baidu.b.c.d.d
    public BigInteger b() {
        return this.b;
    }
}
