package com.amap.api.col.p0003l;

import com.zj.adlib.ecb;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class iw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ecb f25978a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ByteBuffer f931a;

    public iw(int i) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i);
        this.f931a = byteBufferAllocate;
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        this.f25978a = new ecb(this.f931a);
    }

    public final iw a() {
        this.f25978a.c(this.f931a);
        return this;
    }
}
