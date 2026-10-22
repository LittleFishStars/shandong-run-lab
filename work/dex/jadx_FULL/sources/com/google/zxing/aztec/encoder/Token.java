package com.google.zxing.aztec.encoder;

import com.zj.adlib.qv0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
abstract class Token {
    public static final Token b = new b(null, 0, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Token f32498a;

    public Token(Token token) {
        this.f32498a = token;
    }

    public final Token a(int i, int i2) {
        return new b(this, i, i2);
    }

    public final Token b(int i, int i2) {
        return new a(this, i, i2);
    }

    public abstract void c(qv0 qv0Var, byte[] bArr);

    public final Token d() {
        return this.f32498a;
    }
}
