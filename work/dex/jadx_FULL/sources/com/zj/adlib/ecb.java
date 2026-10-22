package com.zj.adlib;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class ecb extends uhb {
    public ecb(ByteBuffer byteBuffer) {
        super(byteBuffer);
    }

    @Override // com.zj.adlib.uhb
    public final int b(CharSequence charSequence) {
        try {
            return super.b(charSequence);
        } catch (Throwable th) {
            phb.a(th);
            return super.b("");
        }
    }
}
