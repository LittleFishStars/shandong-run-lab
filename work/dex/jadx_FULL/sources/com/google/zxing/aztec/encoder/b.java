package com.google.zxing.aztec.encoder;

import com.zj.adlib.dv9;
import com.zj.adlib.qv0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class b extends Token {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final short f32500a;
    public final short b;

    public b(Token token, int i, int i2) {
        super(token);
        this.f32500a = (short) i;
        this.b = (short) i2;
    }

    @Override // com.google.zxing.aztec.encoder.Token
    public void c(qv0 qv0Var, byte[] bArr) {
        qv0Var.d(this.f32500a, this.b);
    }

    public String toString() {
        short s = this.f32500a;
        short s2 = this.b;
        return dv9.f41283a + Integer.toBinaryString((s & ((1 << s2) - 1)) | (1 << s2) | (1 << this.b)).substring(1) + dv9.b;
    }
}
