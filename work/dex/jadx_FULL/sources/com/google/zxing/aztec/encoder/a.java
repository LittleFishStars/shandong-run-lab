package com.google.zxing.aztec.encoder;

import com.zj.adlib.dv9;
import com.zj.adlib.qv0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class a extends Token {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f32499a;
    public final int b;

    public a(Token token, int i, int i2) {
        super(token);
        this.f32499a = i;
        this.b = i2;
    }

    @Override // com.google.zxing.aztec.encoder.Token
    public void c(qv0 qv0Var, byte[] bArr) {
        int i = this.b;
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 == 0 || (i2 == 31 && i <= 62)) {
                qv0Var.d(31, 5);
                if (i > 62) {
                    qv0Var.d(i - 31, 16);
                } else if (i2 == 0) {
                    qv0Var.d(Math.min(i, 31), 5);
                } else {
                    qv0Var.d(i - 31, 5);
                }
            }
            qv0Var.d(bArr[this.f32499a + i2], 8);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        sb.append(this.f32499a);
        sb.append("::");
        sb.append((this.f32499a + this.b) - 1);
        sb.append(dv9.b);
        return sb.toString();
    }
}
