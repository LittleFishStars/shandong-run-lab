package com.byazt.wx;

import com.byazt.jl.i;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 525, 20})
public class c extends ve<com.byazt.jl.tt> {
    public c(com.byazt.zt.tt ttVar) {
        super(ttVar);
    }

    @Override // com.byazt.wx.ve
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public com.byazt.jl.tt tt(com.byazt.zt.tt ttVar, i.c cVar) {
        return new com.byazt.jl.tt(ttVar, cVar);
    }

    public static c c(final ByteBuffer byteBuffer) {
        return new c(new com.byazt.zt.c() { // from class: com.byazt.wx.c.1
            @Override // com.byazt.zt.c
            public ByteBuffer c() {
                byteBuffer.position(0);
                return byteBuffer;
            }
        });
    }
}
